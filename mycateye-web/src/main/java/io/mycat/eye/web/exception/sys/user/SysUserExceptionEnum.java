package io.mycat.eye.web.exception.sys.user;

import io.mycat.eye.web.exception.IExceptionEnumRoot;

/**
 * Created by BQ0082 on 2017/4/1.
 */
public enum SysUserExceptionEnum implements IExceptionEnumRoot {
    USER_NAME_NOT_NULL("ME-UR-001", "用户名不能为空"),

    PASSWORD_NOT_NULL("ME-UR-002", "密码不能为空"),

    PASSWORD_VERIFY_FAIL("ME-UR-003", "密码验证失败"),

    USER_NOT_EXISTS("ME-UR-004", "用户不存在"),

    USER_ALREADY_EXISTS("ME-UR-005", "用户已存在"),

    ;

    private String code;

    private String message;

    SysUserExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
