package io.mycat.eye.web.bean;

import java.io.Serializable;

public class MycatSqlDetail implements Serializable {
    private Integer id;

    private String dataSource;

    private Long execute;

    private Double time;

    private Long lastExecuteTimestamp;

    private Double lastTime;

    private Long sqlId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public Long getExecute() {
        return execute;
    }

    public void setExecute(Long execute) {
        this.execute = execute;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public Long getLastExecuteTimestamp() {
        return lastExecuteTimestamp;
    }

    public void setLastExecuteTimestamp(Long lastExecuteTimestamp) {
        this.lastExecuteTimestamp = lastExecuteTimestamp;
    }

    public Double getLastTime() {
        return lastTime;
    }

    public void setLastTime(Double lastTime) {
        this.lastTime = lastTime;
    }

    public Long getSqlId() {
        return sqlId;
    }

    public void setSqlId(Long sqlId) {
        this.sqlId = sqlId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", dataSource=").append(dataSource);
        sb.append(", execute=").append(execute);
        sb.append(", time=").append(time);
        sb.append(", lastExecuteTimestamp=").append(lastExecuteTimestamp);
        sb.append(", lastTime=").append(lastTime);
        sb.append(", sqlId=").append(sqlId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}