package io.mycat.eye.agent.bean;

import java.io.Serializable;

public class MycatServerStatus implements Serializable {
    private Integer id;

    private Integer mycatId;

    private String uptime;

    private Integer usedMemory;

    private Integer totalMemory;

    private Integer maxMemory;

    private Integer reloadTime;

    private Integer rollbackTime;

    private String charset;

    private String status;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMycatId() {
        return mycatId;
    }

    public void setMycatId(Integer mycatId) {
        this.mycatId = mycatId;
    }

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime;
    }

    public Integer getUsedMemory() {
        return usedMemory;
    }

    public void setUsedMemory(Integer usedMemory) {
        this.usedMemory = usedMemory;
    }

    public Integer getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(Integer totalMemory) {
        this.totalMemory = totalMemory;
    }

    public Integer getMaxMemory() {
        return maxMemory;
    }

    public void setMaxMemory(Integer maxMemory) {
        this.maxMemory = maxMemory;
    }

    public Integer getReloadTime() {
        return reloadTime;
    }

    public void setReloadTime(Integer reloadTime) {
        this.reloadTime = reloadTime;
    }

    public Integer getRollbackTime() {
        return rollbackTime;
    }

    public void setRollbackTime(Integer rollbackTime) {
        this.rollbackTime = rollbackTime;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", mycatId=").append(mycatId);
        sb.append(", uptime=").append(uptime);
        sb.append(", usedMemory=").append(usedMemory);
        sb.append(", totalMemory=").append(totalMemory);
        sb.append(", maxMemory=").append(maxMemory);
        sb.append(", reloadTime=").append(reloadTime);
        sb.append(", rollbackTime=").append(rollbackTime);
        sb.append(", charset=").append(charset);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}