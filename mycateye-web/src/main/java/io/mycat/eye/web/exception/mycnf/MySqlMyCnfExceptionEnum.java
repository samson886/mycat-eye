package io.mycat.eye.web.exception.mycnf;

import io.mycat.eye.web.exception.IExceptionEnumRoot;
public enum MySqlMyCnfExceptionEnum implements IExceptionEnumRoot {
    DATA_ERROR("ME-MYSQL-MYCNF-001", "数据异常"),
    SERVER_HOST_NAME_NULL("ME-MYSQL-MYCNF-002", "MySQL数据库服务器主机名不允许为空"),
    PHYSICAL_MEMORY_NULL("ME-MYSQL-MYCNF-003", "服务器物理内存不允许为空"),
    INSTALL_PATH_NULL("ME-MYSQL-MYCNF-004", "MySQL安装路径不允许为空"),
    DATA_FILE_PATH_NULL("ME-MYSQL-MYCNF-005", "MySQL数据文件路径不允许为空"),
    LISTEN_PORT_NULL("ME-MYSQL-MYCNF-006", "MySQL监听的端口不允许为空"),
    SOCKET_FILE_POSITION_NULL("ME-MYSQL-MYCNF-007", "MySQL SOCKET文件位置不允许为空"),
    EXPECTED_TABLE_COUNT_NULL("ME-MYSQL-MYCNF-008", "数据表数量不允许为空"),
    EXPECTED_MAX_CONNECT_NULL("ME-MYSQL-MYCNF-009", "最大并发连接数不允许为空"),
    BINLOG_EXPIRE_DAYS_NULL("ME-MYSQL-MYCNF-0010", "binlog保留时间不允许为空"),
    SERVER_ID_NULL("ME-MYSQL-MYCNF-011", "MySQL数据库SeverId不允许为空");
    private String code;
    private String message;

    MySqlMyCnfExceptionEnum(String code, String message) {
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
