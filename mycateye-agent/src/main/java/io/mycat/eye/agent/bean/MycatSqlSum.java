package io.mycat.eye.agent.bean;

import java.io.Serializable;

public class MycatSqlSum extends MycatSqlSumKey implements Serializable {
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

    private Integer timeCount0;

    private Integer timeCount1;

    private Integer timeCount2;

    private Integer timeCount3;

    private Integer ttlCount0;

    private Integer ttlCount1;

    private Integer ttlCount2;

    private Integer ttlCount3;

    private static final long serialVersionUID = 1L;

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

    public Integer getTimeCount0() {
        return timeCount0;
    }

    public void setTimeCount0(Integer timeCount0) {
        this.timeCount0 = timeCount0;
    }

    public Integer getTimeCount1() {
        return timeCount1;
    }

    public void setTimeCount1(Integer timeCount1) {
        this.timeCount1 = timeCount1;
    }

    public Integer getTimeCount2() {
        return timeCount2;
    }

    public void setTimeCount2(Integer timeCount2) {
        this.timeCount2 = timeCount2;
    }

    public Integer getTimeCount3() {
        return timeCount3;
    }

    public void setTimeCount3(Integer timeCount3) {
        this.timeCount3 = timeCount3;
    }

    public Integer getTtlCount0() {
        return ttlCount0;
    }

    public void setTtlCount0(Integer ttlCount0) {
        this.ttlCount0 = ttlCount0;
    }

    public Integer getTtlCount1() {
        return ttlCount1;
    }

    public void setTtlCount1(Integer ttlCount1) {
        this.ttlCount1 = ttlCount1;
    }

    public Integer getTtlCount2() {
        return ttlCount2;
    }

    public void setTtlCount2(Integer ttlCount2) {
        this.ttlCount2 = ttlCount2;
    }

    public Integer getTtlCount3() {
        return ttlCount3;
    }

    public void setTtlCount3(Integer ttlCount3) {
        this.ttlCount3 = ttlCount3;
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
        sb.append(", timeCount0=").append(timeCount0);
        sb.append(", timeCount1=").append(timeCount1);
        sb.append(", timeCount2=").append(timeCount2);
        sb.append(", timeCount3=").append(timeCount3);
        sb.append(", ttlCount0=").append(ttlCount0);
        sb.append(", ttlCount1=").append(ttlCount1);
        sb.append(", ttlCount2=").append(ttlCount2);
        sb.append(", ttlCount3=").append(ttlCount3);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}