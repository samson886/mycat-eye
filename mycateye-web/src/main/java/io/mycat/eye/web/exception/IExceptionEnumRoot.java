package io.mycat.eye.web.exception;

public interface IExceptionEnumRoot
{
    
    /**
     * 获取异常编码
     *
     * @return
     */
    String getCode();
    
    /**
     * 获取异常信息
     *
     * @return
     */
    String getMessage();
}
