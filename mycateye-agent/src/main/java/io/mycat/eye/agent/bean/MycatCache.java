package io.mycat.eye.agent.bean;

import java.io.Serializable;

public class MycatCache implements Serializable {
    private Integer id;

    private String cache;

    private Integer cMax;

    private Integer cur;

    private Integer access;

    private Integer hit;

    private Integer put;

    private Integer lastAccess;

    private Integer lastPut;

    private Integer serverId;

    private Long collectTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCache() {
        return cache;
    }

    public void setCache(String cache) {
        this.cache = cache;
    }

    public Integer getcMax() {
        return cMax;
    }

    public void setcMax(Integer cMax) {
        this.cMax = cMax;
    }

    public Integer getCur() {
        return cur;
    }

    public void setCur(Integer cur) {
        this.cur = cur;
    }

    public Integer getAccess() {
        return access;
    }

    public void setAccess(Integer access) {
        this.access = access;
    }

    public Integer getHit() {
        return hit;
    }

    public void setHit(Integer hit) {
        this.hit = hit;
    }

    public Integer getPut() {
        return put;
    }

    public void setPut(Integer put) {
        this.put = put;
    }

    public Integer getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(Integer lastAccess) {
        this.lastAccess = lastAccess;
    }

    public Integer getLastPut() {
        return lastPut;
    }

    public void setLastPut(Integer lastPut) {
        this.lastPut = lastPut;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", cache=").append(cache);
        sb.append(", cMax=").append(cMax);
        sb.append(", cur=").append(cur);
        sb.append(", access=").append(access);
        sb.append(", hit=").append(hit);
        sb.append(", put=").append(put);
        sb.append(", lastAccess=").append(lastAccess);
        sb.append(", lastPut=").append(lastPut);
        sb.append(", serverId=").append(serverId);
        sb.append(", collectTime=").append(collectTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}