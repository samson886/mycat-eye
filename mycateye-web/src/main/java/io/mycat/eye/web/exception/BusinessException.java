package io.mycat.eye.web.exception;

public class BusinessException extends RuntimeException
{
    private static final long serialVersionUID = -7835062948383843906L;
    
    private IExceptionEnumRoot exceptionInfo;
    
    public BusinessException(IExceptionEnumRoot exceptionInfo)
    {
        this.exceptionInfo = exceptionInfo;
    }
    
    public IExceptionEnumRoot getExceptionInfo()
    {
        return exceptionInfo;
    }
}
