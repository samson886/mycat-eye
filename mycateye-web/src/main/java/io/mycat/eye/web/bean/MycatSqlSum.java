package io.mycat.eye.web.bean;

import java.io.Serializable;

public class MycatSqlSum implements Serializable {
    private Integer sid;

    private Integer id;

    private String cUser;

    private Integer r;

    private Integer w;

    private Float rP;

    private Integer sqlMax;

    private Integer netIn;

    private Integer netOut;

    private String timeCount;

    private String ttlCount;

    private Long lastTime;

    private String sqlTable;

    private String relatable;

    private String relacount;

    private String collectType;

    private static final long serialVersionUID = 1L;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getcUser() {
        return cUser;
    }

    public void setcUser(String cUser) {
        this.cUser = cUser;
    }

    public Integer getR() {
        return r;
    }

    public void setR(Integer r) {
        this.r = r;
    }

    public Integer getW() {
        return w;
    }

    public void setW(Integer w) {
        this.w = w;
    }

    public Float getrP() {
        return rP;
    }

    public void setrP(Float rP) {
        this.rP = rP;
    }

    public Integer getSqlMax() {
        return sqlMax;
    }

    public void setSqlMax(Integer sqlMax) {
        this.sqlMax = sqlMax;
    }

    public Integer getNetIn() {
        return netIn;
    }

    public void setNetIn(Integer netIn) {
        this.netIn = netIn;
    }

    public Integer getNetOut() {
        return netOut;
    }

    public void setNetOut(Integer netOut) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sid=").append(sid);
        sb.append(", id=").append(id);
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
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}