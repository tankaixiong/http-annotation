package tank.http.annotation.api;

import java.lang.reflect.Field;
import java.util.Vector;

/**
 * @author tank
 * @date:2015年10月8日 下午11:43:04
 * @description:
 * @version :1.0
 */
public class AnnotationParser {
	
	public static void init(String [] scanPackage){
		
		
	}

	public static void main(String[] args) {
		
		 System.out.println(HttpMethod.GET);
		
		try {
			Field field = ClassLoader.class.getDeclaredField("classes");  
			field.setAccessible(true);//设置该成员变量为可访问  
			
			Vector<Class<?>> classListClasses=(Vector<Class<?>>) field.get(ClassLoader.getSystemClassLoader());
			
			 for (Class<?> cz : classListClasses) {
				System.out.println(cz.getName());
			}
			
			
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

	}
}
