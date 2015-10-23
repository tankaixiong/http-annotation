package tank.http.annotation.api;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tank
 * @email kaixiong.tan@qq.com
 * @date:2015年10月9日 下午8:54:50
 * @description:缓存 http request 映射关系
 * @version :0.1
 */

public class HttpMappingContext {

	private static Logger LOG = LoggerFactory.getLogger(HttpMappingContext.class);
	/**
	 * url,method
	 */
	private static Map<String, MappingEntity> urlMap = new HashMap<String, MappingEntity>();

	public static void putMappingEntity(MappingEntity entity) {
		if (entity.getUrl() == null && entity.getUrl() == "") {
			LOG.error("url不能为空");
			return;
		}
		if (urlMap.containsKey(entity.getUrl())) {
			LOG.error("重复映射:{}", entity.getUrl());
		}
		urlMap.put(entity.getUrl(), entity);

	}

	public static MappingEntity getEntity(String key) {
		return urlMap.get(key);
	}

	public static synchronized void init(String[] scanPackage) {
		AnnotationParser.init(scanPackage);
	}

}
