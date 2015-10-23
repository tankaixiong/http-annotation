package tank.http.annotation.api;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

/**
 * @author tank
 * @email kaixiong.tan@qq.com
 * @date:2015年10月10日 上午11:32:39
 * @description:
 * @version :0.1
 */

public class MethodParamUtils {

	public static void main(String[] args) {
		String test = null;

		Method methodArray[] = MappingEntity.class.getMethods();
		for (Method method : methodArray) {
			System.out.println(method.getName());

			Annotation[][] an = method.getParameterAnnotations();
			System.out.println("length:"+an.length);
			for (Annotation[] annotations : an) {
				for (Annotation annotation : annotations) {
					if (annotation instanceof HttpParam) {
						System.out.println("参数:" + ((HttpParam) annotation).value());
					}
				}
			}

			Class[] clzz = method.getParameterTypes();

			for (Class cz : clzz) {
				System.out.println(cz.getName());
			}

			TypeVariable<Method>[] tm = method.getTypeParameters();
			for (TypeVariable<Method> typeVariable : tm) {
				System.out.println(typeVariable.getName());
			}
		}

	}
}
