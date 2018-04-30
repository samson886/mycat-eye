package io.mycat.eye.agent.bean;

import java.io.Serializable;

public class MycatSqlExecute implements Serializable {
    private Long sqlId;

    private Long sqlExecute;

    private Double sqlTime;

    private Double maxTime;

    private Double minTime;

    private static final long serialVersionUID = 1L;

    public Long getSqlId() {
        return sqlId;
    }

    public void setSqlId(Long sqlId) {
        this.sqlId = sqlId;
    }

    public Long getSqlExecute() {
        return sqlExecute;
    }

    public void setSqlExecute(Long sqlExecute) {
        this.sqlExecute = sqlExecute;
    }

    public Double getSqlTime() {
        return sqlTime;
    }

    public void setSqlTime(Double sqlTime) {
        this.sqlTime = sqlTime;
    }

    public Double getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(Double maxTime) {
        this.maxTime = maxTime;
    }

    public Double getMinTime() {
        return minTime;
    }

    public void setMinTime(Double minTime) {
        this.minTime = minTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sqlId=").append(sqlId);
        sb.append(", sqlExecute=").append(sqlExecute);
        sb.append(", sqlTime=").append(sqlTime);
        sb.append(", maxTime=").append(maxTime);
        sb.append(", minTime=").append(minTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}