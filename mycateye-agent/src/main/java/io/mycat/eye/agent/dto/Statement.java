/**
 * All rights Reserved, Designed By www.openwork.org.cn
 * @Title:  Statement.java
 * @Package cn.bqjr.dbeye.agent.dto
 * @Description:    TODO
 * @author: 李平(360841519@qq.com)
 * @date:   2017年5月9日 下午4:45:19
 * @version V1.0
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved.
 */
package io.mycat.eye.agent.dto;

import java.util.Date;


/**
 * @ClassName: Statement
 * @Description:TODO
 * @author: 李平(360841519@qq.com)
 * @date: 2017年5月9日 下午4:45:19
 *
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved.
 */
public class Statement {
    private String digest;
    private String currentSchema;
    private String sqlText;
    private String digestText;
    private String eventName;
    private Long countStar;
    private Long minTimerWait;
    private Long avgTimerWait;
    private Long maxTimerWait;
    private Long sumLockTime;
    private Long sumRowsAffected;
    private Long sumRowsSent;
    private Long sumRowsExamined;
    private Long sumCreatedTmpDiskTables;
    private Long sumCreatedTmpTables;
    private Long sumSelectFullJoin;
    private Long sumSelectFullRangeJoin;
    private Long sumSelectRange;
    private Long sumSelectRangeCheck;
    private Long sumSelectScan;
    private Long sumSortMergePasses;
    private Long sumSortRange;
    private Long sumSortRows;
    private Long sumSortScan;
    private Long sumNoIndexUsed;
    private Long sumNoGoodIndexUsed;
    private Date firstSeen;
    private Date lastSeen;
    /**
     * @return the digest
     */
    public String getDigest() {
        return digest;
    }
    /**
     * @param digest the digest to set
     */
    public void setDigest(String digest) {
        this.digest = digest;
    }
    /**
     * @return the currentSchema
     */
    public String getCurrentSchema() {
        return currentSchema;
    }
    /**
     * @param currentSchema the currentSchema to set
     */
    public void setCurrentSchema(String currentSchema) {
        this.currentSchema = currentSchema;
    }
    /**
     * @return the sqlText
     */
    public String getSqlText() {
        return sqlText;
    }
    /**
     * @param sqlText the sqlText to set
     */
    public void setSqlText(String sqlText) {
        this.sqlText = sqlText;
    }
    /**
     * @return the digestText
     */
    public String getDigestText() {
        return digestText;
    }
    /**
     * @param digestText the digestText to set
     */
    public void setDigestText(String digestText) {
        this.digestText = digestText;
    }
    /**
     * @return the countStar
     */
    public Long getCountStar() {
        return countStar;
    }
    /**
     * @param countStar the countStar to set
     */
    public void setCountStar(Long countStar) {
        this.countStar = countStar;
    }
    /**
     * @return the minTimerWait
     */
    public Long getMinTimerWait() {
        return minTimerWait;
    }
    /**
     * @param minTimerWait the minTimerWait to set
     */
    public void setMinTimerWait(Long minTimerWait) {
        this.minTimerWait = minTimerWait;
    }
    /**
     * @return the avgTimerWait
     */
    public Long getAvgTimerWait() {
        return avgTimerWait;
    }
    /**
     * @param avgTimerWait the avgTimerWait to set
     */
    public void setAvgTimerWait(Long avgTimerWait) {
        this.avgTimerWait = avgTimerWait;
    }
    /**
     * @return the maxTimerWait
     */
    public Long getMaxTimerWait() {
        return maxTimerWait;
    }
    /**
     * @param maxTimerWait the maxTimerWait to set
     */
    public void setMaxTimerWait(Long maxTimerWait) {
        this.maxTimerWait = maxTimerWait;
    }
    /**
     * @return the sumLockTime
     */
    public Long getSumLockTime() {
        return sumLockTime;
    }
    /**
     * @param sumLockTime the sumLockTime to set
     */
    public void setSumLockTime(Long sumLockTime) {
        this.sumLockTime = sumLockTime;
    }
    /**
     * @return the sumRowsAffected
     */
    public Long getSumRowsAffected() {
        return sumRowsAffected;
    }
    /**
     * @param sumRowsAffected the sumRowsAffected to set
     */
    public void setSumRowsAffected(Long sumRowsAffected) {
        this.sumRowsAffected = sumRowsAffected;
    }
    /**
     * @return the sumRowsSent
     */
    public Long getSumRowsSent() {
        return sumRowsSent;
    }
    /**
     * @param sumRowsSent the sumRowsSent to set
     */
    public void setSumRowsSent(Long sumRowsSent) {
        this.sumRowsSent = sumRowsSent;
    }
    /**
     * @return the sumRowsExamined
     */
    public Long getSumRowsExamined() {
        return sumRowsExamined;
    }
    /**
     * @param sumRowsExamined the sumRowsExamined to set
     */
    public void setSumRowsExamined(Long sumRowsExamined) {
        this.sumRowsExamined = sumRowsExamined;
    }
    /**
     * @return the sumCreatedTmpDiskTables
     */
    public Long getSumCreatedTmpDiskTables() {
        return sumCreatedTmpDiskTables;
    }
    /**
     * @param sumCreatedTmpDiskTables the sumCreatedTmpDiskTables to set
     */
    public void setSumCreatedTmpDiskTables(Long sumCreatedTmpDiskTables) {
        this.sumCreatedTmpDiskTables = sumCreatedTmpDiskTables;
    }
    /**
     * @return the sumCreatedTmpTables
     */
    public Long getSumCreatedTmpTables() {
        return sumCreatedTmpTables;
    }
    /**
     * @param sumCreatedTmpTables the sumCreatedTmpTables to set
     */
    public void setSumCreatedTmpTables(Long sumCreatedTmpTables) {
        this.sumCreatedTmpTables = sumCreatedTmpTables;
    }
    /**
     * @return the sumSelectFullJoin
     */
    public Long getSumSelectFullJoin() {
        return sumSelectFullJoin;
    }
    /**
     * @param sumSelectFullJoin the sumSelectFullJoin to set
     */
    public void setSumSelectFullJoin(Long sumSelectFullJoin) {
        this.sumSelectFullJoin = sumSelectFullJoin;
    }
    /**
     * @return the sumSelectFullRangeJoin
     */
    public Long getSumSelectFullRangeJoin() {
        return sumSelectFullRangeJoin;
    }
    /**
     * @param sumSelectFullRangeJoin the sumSelectFullRangeJoin to set
     */
    public void setSumSelectFullRangeJoin(Long sumSelectFullRangeJoin) {
        this.sumSelectFullRangeJoin = sumSelectFullRangeJoin;
    }
    /**
     * @return the sumSelectRange
     */
    public Long getSumSelectRange() {
        return sumSelectRange;
    }
    /**
     * @param sumSelectRange the sumSelectRange to set
     */
    public void setSumSelectRange(Long sumSelectRange) {
        this.sumSelectRange = sumSelectRange;
    }
    /**
     * @return the sumSelectRangeCheck
     */
    public Long getSumSelectRangeCheck() {
        return sumSelectRangeCheck;
    }
    /**
     * @param sumSelectRangeCheck the sumSelectRangeCheck to set
     */
    public void setSumSelectRangeCheck(Long sumSelectRangeCheck) {
        this.sumSelectRangeCheck = sumSelectRangeCheck;
    }
    /**
     * @return the sumSelectScan
     */
    public Long getSumSelectScan() {
        return sumSelectScan;
    }
    /**
     * @param sumSelectScan the sumSelectScan to set
     */
    public void setSumSelectScan(Long sumSelectScan) {
        this.sumSelectScan = sumSelectScan;
    }
    /**
     * @return the sumSortMergePasses
     */
    public Long getSumSortMergePasses() {
        return sumSortMergePasses;
    }
    /**
     * @param sumSortMergePasses the sumSortMergePasses to set
     */
    public void setSumSortMergePasses(Long sumSortMergePasses) {
        this.sumSortMergePasses = sumSortMergePasses;
    }
    /**
     * @return the sumSortRange
     */
    public Long getSumSortRange() {
        return sumSortRange;
    }
    /**
     * @param sumSortRange the sumSortRange to set
     */
    public void setSumSortRange(Long sumSortRange) {
        this.sumSortRange = sumSortRange;
    }
    /**
     * @return the sumSortRows
     */
    public Long getSumSortRows() {
        return sumSortRows;
    }
    /**
     * @param sumSortRows the sumSortRows to set
     */
    public void setSumSortRows(Long sumSortRows) {
        this.sumSortRows = sumSortRows;
    }
    /**
     * @return the sumSortScan
     */
    public Long getSumSortScan() {
        return sumSortScan;
    }
    /**
     * @param sumSortScan the sumSortScan to set
     */
    public void setSumSortScan(Long sumSortScan) {
        this.sumSortScan = sumSortScan;
    }
    /**
     * @return the sumNoIndexUsed
     */
    public Long getSumNoIndexUsed() {
        return sumNoIndexUsed;
    }
    /**
     * @param sumNoIndexUsed the sumNoIndexUsed to set
     */
    public void setSumNoIndexUsed(Long sumNoIndexUsed) {
        this.sumNoIndexUsed = sumNoIndexUsed;
    }
    /**
     * @return the sumNoGoodIndexUsed
     */
    public Long getSumNoGoodIndexUsed() {
        return sumNoGoodIndexUsed;
    }
    /**
     * @param sumNoGoodIndexUsed the sumNoGoodIndexUsed to set
     */
    public void setSumNoGoodIndexUsed(Long sumNoGoodIndexUsed) {
        this.sumNoGoodIndexUsed = sumNoGoodIndexUsed;
    }
    /**
     * @return the firstSeen
     */
    public Date getFirstSeen() {
        return firstSeen;
    }
    /**
     * @param firstSeen the firstSeen to set
     */
    public void setFirstSeen(Date firstSeen) {
        this.firstSeen = firstSeen;
    }
    /**
     * @return the lastSeen
     */
    public Date getLastSeen() {
        return lastSeen;
    }
    /**
     * @param lastSeen the lastSeen to set
     */
    public void setLastSeen(Date lastSeen) {
        this.lastSeen = lastSeen;
    }
    /**
     * @return the eventName
     */
    public String getEventName() {
        return eventName;
    }
    /**
     * @param eventName the eventName to set
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    
}
