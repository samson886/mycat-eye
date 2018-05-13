package io.mycat.eye.web.bean;

import java.io.Serializable;

public class MycatSqlLargeRs extends MycatSqlLargeRsKey implements Serializable {
    private String sqlUser;

    private Long frequency;

    private Long resultsetSize;

    private Integer serverId;

    private Long collectTime;

    private Long startupTime;

    private String cSql;

    private static final long serialVersionUID = 1L;

    public String getSqlUser() {
        return sqlUser;
    }

    public void setSqlUser(String sqlUser) {
        this.sqlUser = sqlUser;
    }

    public Long getFrequency() {
        return frequency;
    }

    public void setFrequency(Long frequency) {
        this.frequency = frequency;
    }

    public Long getResultsetSize() {
        return resultsetSize;
    }

    public void setResultsetSize(Long resultsetSize) {
        this.resultsetSize = resultsetSize;
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
        sb.append(", sqlUser=").append(sqlUser);
        sb.append(", frequency=").append(frequency);
        sb.append(", resultsetSize=").append(resultsetSize);
        sb.append(", serverId=").append(serverId);
        sb.append(", collectTime=").append(collectTime);
        sb.append(", startupTime=").append(startupTime);
        sb.append(", cSql=").append(cSql);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}