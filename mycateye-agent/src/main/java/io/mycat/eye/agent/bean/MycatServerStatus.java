package io.mycat.eye.agent.bean;

import java.io.Serializable;

public class MycatServerStatus implements Serializable {
    private Integer id;

    private Integer mycatId;

    private String uptime;

    private Long usedMemory;

    private Long totalMemory;

    private Long maxMemory;

    private Long reloadTime;

    private Long rollbackTime;

    private String charset;

    private String status;

    private Long collectTime;

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

    public Long getUsedMemory() {
        return usedMemory;
    }

    public void setUsedMemory(Long usedMemory) {
        this.usedMemory = usedMemory;
    }

    public Long getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(Long totalMemory) {
        this.totalMemory = totalMemory;
    }

    public Long getMaxMemory() {
        return maxMemory;
    }

    public void setMaxMemory(Long maxMemory) {
        this.maxMemory = maxMemory;
    }

    public Long getReloadTime() {
        return reloadTime;
    }

    public void setReloadTime(Long reloadTime) {
        this.reloadTime = reloadTime;
    }

    public Long getRollbackTime() {
        return rollbackTime;
    }

    public void setRollbackTime(Long rollbackTime) {
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

    public Long getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Long collectTime) {
        this.collectTime = collectTime;
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
        sb.append(", collectTime=").append(collectTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}