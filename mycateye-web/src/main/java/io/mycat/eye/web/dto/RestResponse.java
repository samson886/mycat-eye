package io.mycat.eye.web.dto;

import com.sun.xml.internal.rngom.ast.builder.BuildException;

/**
 * Rest响应结果对象
 * @ClassName:  RestResponse   
 * @Description:Rest响应结果对象
 * @author: 李平(360841519@qq.com)
 * @date:   2017年8月7日 下午3:03:11   
 *   
 * @param <T>  
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved.
 */
public class RestResponse<T>  {

    private int code;
    private String message;
    private T data;
    private long timestamp = System.currentTimeMillis();

    public RestResponse() {

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    
    public static RestResponse<Object> buildExceptionResponse(int code, String errorMessage) {
        RestResponse<Object> restResponse = new RestResponse<>();
        restResponse.setCode(code);
        restResponse.setMessage(errorMessage);
        return restResponse;
    }
    public static RestResponse<Object> buildOKResponse(String msg) {
        return buildExceptionResponse(200, msg);
    }
    public static RestResponse<Object> buildErrorResponse(String errorMessage) {
        return buildExceptionResponse(700, errorMessage);
    }
}
