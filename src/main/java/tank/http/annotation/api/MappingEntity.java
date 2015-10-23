package tank.http.annotation.api;

import java.lang.reflect.Method;

/**
 * @author tank
 * @email kaixiong.tan@qq.com
 * @date:2015年10月9日 下午10:25:20
 * @description:
 * @version :0.1
 */

public class MappingEntity {

	private Class clazz;
	private Method method;
	private Object instance;
	private String url;
	private String contentType;
	private HttpMethod httpType;

	public HttpMethod getHttpType() {
		return httpType;
	}

	public void setHttpType(HttpMethod httpType) {
		this.httpType = httpType;
	}

	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public Object getInstance() {
		return instance;
	}

	public void setInstance(Object instance) {
		this.instance = instance;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

}
