package io.mycat.eye.agent.bean;

import java.io.Serializable;

public class MycatSqlSum extends MycatSqlSumKey implements Serializable {
    private String cUser;

    private Long r;

    private Long w;

    private Float rP;

    private Long sqlMax;

    private Long netIn;

    private Long netOut;

    private String timeCount;

    private String ttlCount;

    private Long lastTime;

    private String sqlTable;

    private String relatable;

    private String relacount;

    private String collectType;

    private Integer serverId;

    private Long collectTime;

    private static final long serialVersionUID = 1L;

    public String getcUser() {
        return cUser;
    }

    public void setcUser(String cUser) {
        this.cUser = cUser;
    }

    public Long getR() {
        return r;
    }

    public void setR(Long r) {
        this.r = r;
    }

    public Long getW() {
        return w;
    }

    public void setW(Long w) {
        this.w = w;
    }

    public Float getrP() {
        return rP;
    }

    public void setrP(Float rP) {
        this.rP = rP;
    }

    public Long getSqlMax() {
        return sqlMax;
    }

    public void setSqlMax(Long sqlMax) {
        this.sqlMax = sqlMax;
    }

    public Long getNetIn() {
        return netIn;
    }

    public void setNetIn(Long netIn) {
        this.netIn = netIn;
    }

    public Long getNetOut() {
        return netOut;
    }

    public void setNetOut(Long netOut) {
        this.netOut = netOut;
    }

    public String getTimeCount() {
        return timeCount;
    }

    public void setTimeCount(String timeCount) {
        this.timeCount = timeCount;
    }

    public String getTtlCount() {
        return ttlCount;
    }

    public void setTtlCount(String ttlCount) {
        this.ttlCount = ttlCount;
    }

    public Long getLastTime() {
        return lastTime;
    }

    public void setLastTime(Long lastTime) {
        this.lastTime = lastTime;
    }

    public String getSqlTable() {
        return sqlTable;
    }

    public void setSqlTable(String sqlTable) {
        this.sqlTable = sqlTable;
    }

    public String getRelatable() {
        return relatable;
    }

    public void setRelatable(String relatable) {
        this.relatable = relatable;
    }

    public String getRelacount() {
        return relacount;
    }

    public void setRelacount(String relacount) {
        this.relacount = relacount;
    }

    public String getCollectType() {
        return collectType;
    }

    public void setCollectType(String collectType) {
        this.collectType = collectType;
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
        sb.append(", cUser=").append(cUser);
        sb.append(", r=").append(r);
        sb.append(", w=").append(w);
        sb.append(", rP=").append(rP);
        sb.append(", sqlMax=").append(sqlMax);
        sb.append(", netIn=").append(netIn);
        sb.append(", netOut=").append(netOut);
        sb.append(", timeCount=").append(timeCount);
        sb.append(", ttlCount=").append(ttlCount);
        sb.append(", lastTime=").append(lastTime);
        sb.append(", sqlTable=").append(sqlTable);
        sb.append(", relatable=").append(relatable);
        sb.append(", relacount=").append(relacount);
        sb.append(", collectType=").append(collectType);
        sb.append(", serverId=").append(serverId);
        sb.append(", collectTime=").append(collectTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}