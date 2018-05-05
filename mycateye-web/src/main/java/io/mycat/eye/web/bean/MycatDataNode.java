package io.mycat.eye.web.bean;

import java.io.Serializable;

public class MycatDataNode extends MycatDataNodeKey implements Serializable {
    private String datahost;

    private Integer dIndex;

    private String dType;

    private Integer dActive;

    private Integer dIdle;

    private Integer dSize;

    private Long dExecute;

    private Double totalTime;

    private Double maxTime;

    private Long maxSql;

    private Long recoveryTime;

    private Long collectTime;

    private Integer serverId;

    private static final long serialVersionUID = 1L;

    public String getDatahost() {
        return datahost;
    }

    public void setDatahost(String datahost) {
        this.datahost = datahost;
    }

    public Integer getdIndex() {
        return dIndex;
    }

    public void setdIndex(Integer dIndex) {
        this.dIndex = dIndex;
    }

    public String getdType() {
        return dType;
    }

    public void setdType(String dType) {
        this.dType = dType;
    }

    public Integer getdActive() {
        return dActive;
    }

    public void setdActive(Integer dActive) {
        this.dActive = dActive;
    }

    public Integer getdIdle() {
        return dIdle;
    }

    public void setdIdle(Integer dIdle) {
        this.dIdle = dIdle;
    }

    public Integer getdSize() {
        return dSize;
    }

    public void setdSize(Integer dSize) {
        this.dSize = dSize;
    }

    public Long getdExecute() {
        return dExecute;
    }

    public void setdExecute(Long dExecute) {
        this.dExecute = dExecute;
    }

    public Double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Double totalTime) {
        this.totalTime = totalTime;
    }

    public Double getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(Double maxTime) {
        this.maxTime = maxTime;
    }

    public Long getMaxSql() {
        return maxSql;
    }

    public void setMaxSql(Long maxSql) {
        this.maxSql = maxSql;
    }

    public Long getRecoveryTime() {
        return recoveryTime;
    }

    public void setRecoveryTime(Long recoveryTime) {
        this.recoveryTime = recoveryTime;
    }

    public Long getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Long collectTime) {
        this.collectTime = collectTime;
    }

    public Integer getServerId() {
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", datahost=").append(datahost);
        sb.append(", dIndex=").append(dIndex);
        sb.append(", dType=").append(dType);
        sb.append(", dActive=").append(dActive);
        sb.append(", dIdle=").append(dIdle);
        sb.append(", dSize=").append(dSize);
        sb.append(", dExecute=").append(dExecute);
        sb.append(", totalTime=").append(totalTime);
        sb.append(", maxTime=").append(maxTime);
        sb.append(", maxSql=").append(maxSql);
        sb.append(", recoveryTime=").append(recoveryTime);
        sb.append(", collectTime=").append(collectTime);
        sb.append(", serverId=").append(serverId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}