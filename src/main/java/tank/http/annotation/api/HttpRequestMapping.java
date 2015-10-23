package tank.http.annotation.api;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author tank
 * @date:2015年10月8日 下午11:29:39
 * @description:
 * @version :1.0
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HttpRequestMapping {

	String value() default "";

	HttpMethod method() default HttpMethod.DEFAULT;

	String contextType() default "text/plain";
}
