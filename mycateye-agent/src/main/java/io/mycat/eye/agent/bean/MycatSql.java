package io.mycat.eye.agent.bean;

import java.io.Serializable;

public class MycatSql extends MycatSqlKey implements Serializable {
    private String cUser;

    private Long startTime;

    private Long executeTime;

    private Integer serverId;

    private Long collectTime;

    private Long startupTime;

    private String cSql;

    private static final long serialVersionUID = 1L;

    public String getcUser() {
        return cUser;
    }

    public void setcUser(String cUser) {
        this.cUser = cUser;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(Long executeTime) {
        this.executeTime = executeTime;
    }

    public Integer getServerId() {
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    public Long getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Long collectTime) {
        this.collectTime = collectTime;
    }

    public Long getStartupTime() {
        return startupTime;
    }

    public void setStartupTime(Long startupTime) {
        this.startupTime = startupTime;
    }

    public String getcSql() {
        return cSql;
    }

    public void setcSql(String cSql) {
        this.cSql = cSql;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cUser=").append(cUser);
        sb.append(", startTime=").append(startTime);
        sb.append(", executeTime=").append(executeTime);
        sb.append(", serverId=").append(serverId);
        sb.append(", collectTime=").append(collectTime);
        sb.append(", startupTime=").append(startupTime);
        sb.append(", cSql=").append(cSql);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}