package io.mycat.eye.web.bean;

import java.io.Serializable;

public class MycatSqlHigh extends MycatSqlHighKey implements Serializable {
    private String cUser;

    private Long frequency;

    private Long avgTime;

    private Long maxTime;

    private Long minTime;

    private Long executeTime;

    private Long lastTime;

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

    public Long getFrequency() {
        return frequency;
    }

    public void setFrequency(Long frequency) {
        this.frequency = frequency;
    }

    public Long getAvgTime() {
        return avgTime;
    }

    public void setAvgTime(Long avgTime) {
        this.avgTime = avgTime;
    }

    public Long getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(Long maxTime) {
        this.maxTime = maxTime;
    }

    public Long getMinTime() {
        return minTime;
    }

    public void setMinTime(Long minTime) {
        this.minTime = minTime;
    }

    public Long getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(Long executeTime) {
        this.executeTime = executeTime;
    }

    public Long getLastTime() {
        return lastTime;
    }

    public void setLastTime(Long lastTime) {
        this.lastTime = lastTime;
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
        sb.append(", frequency=").append(frequency);
        sb.append(", avgTime=").append(avgTime);
        sb.append(", maxTime=").append(maxTime);
        sb.append(", minTime=").append(minTime);
        sb.append(", executeTime=").append(executeTime);
        sb.append(", lastTime=").append(lastTime);
        sb.append(", serverId=").append(serverId);
        sb.append(", collectTime=").append(collectTime);
        sb.append(", startupTime=").append(startupTime);
        sb.append(", cSql=").append(cSql);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}