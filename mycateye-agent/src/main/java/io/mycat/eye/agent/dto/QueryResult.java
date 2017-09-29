/**
 * All rights Reserved, Designed By www.openwork.org.cn
 * @Title:  QueryResult.java
 * @Package cn.bqjr.dbeye.dto
 * @Description:    TODO
 * @author: 李平(360841519@qq.com)
 * @date:   2017年4月21日 下午3:47:12
 * @version V1.0
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved.
 */
package io.mycat.eye.agent.dto;

/**
 * @ClassName: QueryResult
 * @Description:查询结果
 * @author: 李平(360841519@qq.com)
 * @date: 2017年4月21日 下午3:47:12
 *
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved.
 */
public class QueryResult<T> {
	private boolean success;
	private String exception;
	private T data;
	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}
	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}
	/**
	 * @return the exception
	 */
	public String getException() {
		return exception;
	}
	/**
	 * @param exception the exception to set
	 */
	public void setException(String exception) {
		this.exception = exception;
	}
	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}
}
