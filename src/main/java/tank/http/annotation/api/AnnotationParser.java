package tank.http.annotation.api;

import java.lang.reflect.Method;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tank
 * @date:2015年10月8日 下午11:43:04
 * @description:
 * @version :1.0
 */
public class AnnotationParser {

	private static Logger LOG = LoggerFactory.getLogger(AnnotationParser.class);

	public static synchronized void init(String[] scanPackage) {
		String baseUrl = "";
		try {
			for (String packagePath : scanPackage) {
				Set<Class<?>> set = ScanClass.getClasses(packagePath);

				for (Class<?> clazz : set) {

					Object obj = clazz.newInstance();

					HttpController controlAnno = clazz.getAnnotation(HttpController.class);
					if (controlAnno != null) {
						HttpRequestMapping mapingAnno = clazz.getAnnotation(HttpRequestMapping.class);
						if (mapingAnno != null) {
							baseUrl = mapingAnno.value();
						}

						Method[] method = clazz.getMethods();

						for (Method m : method) {
							HttpRequestMapping manno = m.getAnnotation(HttpRequestMapping.class);
							if (manno != null) {

								MappingEntity entity = new MappingEntity();
								entity.setClazz(clazz);
								entity.setContentType(manno.contextType());
								entity.setHttpType(manno.method());
								entity.setInstance(obj);
								entity.setUrl(baseUrl + manno.value());
								entity.setMethod(m);

								HttpMappingContext.putMappingEntity(entity);

							}
						}

					}

				}
			}
		} catch (Exception e) {
			LOG.error("{}", e);
		}

	}

}
