package io.mycat.eye.agent.bean;

import java.io.Serializable;
import java.util.Date;

public class MysqlStatusHistory implements Serializable {
    private Long id;

    private Long serverId;

    private String uptime;

    private Integer openTables;

    private Integer threadsConnected;

    private Integer threadsRunning;

    private Integer threadsCreated;

    private Integer threadsCached;

    private Integer connections;

    private Integer abortedClients;

    private Integer abortedConnects;

    private Long bytesReceived;

    private String bytesReceivedPersecond;

    private Long bytesSent;

    private String bytesSentPersecond;

    private Long comSelect;

    private String comSelectPersecond;

    private Long comInsert;

    private String comInsertPersecond;

    private Long comUpdate;

    private String comUpdatePersecond;

    private Long comDelete;

    private String comDeletePersecond;

    private Long comCommit;

    private String comCommitPersecond;

    private Long comRollback;

    private String comRollbackPersecond;

    private Long questions;

    private String questionsPersecond;

    private Long transactions;

    private String transactionsPersecond;

    private Long createdTmpTables;

    private String createdTmpTablesPersecond;

    private Long createdTmpDiskTables;

    private String createdTmpDiskTablesPersecond;

    private Long createdTmpFiles;

    private String createdTmpFilesPersecond;

    private Long innodbDataReads;

    private String innodbDataReadsPersecond;

    private Long innodbDataWrites;

    private String innodbDataWritesPersecond;

    private Long innodbDataFsyncs;

    private String innodbDataFsyncsPersecond;

    private Long innodbDataRead;

    private String innodbDataReadPersecond;

    private Long innodbDataWritten;

    private String innodbDataWrittenPersecond;

    private Long innodbBufferPoolPagesDirty;

    private String innodbBufferPoolPagesDirtyPersecond;

    private Long innodbBufferPoolPagesFlushed;

    private String innodbBufferPoolPagesFlushedPersecond;

    private String innodbBufferReadHitRatio;

    private String innodbBufferUsage;

    private Long innodbRowsInserted;

    private String innodbRowsInsertedPersecond;

    private Long innodbRowsUpdated;

    private String innodbRowsUpdatedPersecond;

    private Long innodbRowsDeleted;

    private String innodbRowsDeletedPersecond;

    private Long innodbBufferPoolPagesTotal;

    private Long innodbBufferPoolPagesFree;

    private Integer innodbPageSize;

    private Integer slowQueries;

    private Long slaveDelay;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getServerId() {
        return serverId;
    }

    public void setServerId(Long serverId) {
        this.serverId = serverId;
    }

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime == null ? null : uptime.trim();
    }

    public Integer getOpenTables() {
        return openTables;
    }

    public void setOpenTables(Integer openTables) {
        this.openTables = openTables;
    }

    public Integer getThreadsConnected() {
        return threadsConnected;
    }

    public void setThreadsConnected(Integer threadsConnected) {
        this.threadsConnected = threadsConnected;
    }

    public Integer getThreadsRunning() {
        return threadsRunning;
    }

    public void setThreadsRunning(Integer threadsRunning) {
        this.threadsRunning = threadsRunning;
    }

    public Integer getThreadsCreated() {
        return threadsCreated;
    }

    public void setThreadsCreated(Integer threadsCreated) {
        this.threadsCreated = threadsCreated;
    }

    public Integer getThreadsCached() {
        return threadsCached;
    }

    public void setThreadsCached(Integer threadsCached) {
        this.threadsCached = threadsCached;
    }

    public Integer getConnections() {
        return connections;
    }

    public void setConnections(Integer connections) {
        this.connections = connections;
    }

    public Integer getAbortedClients() {
        return abortedClients;
    }

    public void setAbortedClients(Integer abortedClients) {
        this.abortedClients = abortedClients;
    }

    public Integer getAbortedConnects() {
        return abortedConnects;
    }

    public void setAbortedConnects(Integer abortedConnects) {
        this.abortedConnects = abortedConnects;
    }

    public Long getBytesReceived() {
        return bytesReceived;
    }

    public void setBytesReceived(Long bytesReceived) {
        this.bytesReceived = bytesReceived;
    }

    public String getBytesReceivedPersecond() {
        return bytesReceivedPersecond;
    }

    public void setBytesReceivedPersecond(String bytesReceivedPersecond) {
        this.bytesReceivedPersecond = bytesReceivedPersecond == null ? null : bytesReceivedPersecond.trim();
    }

    public Long getBytesSent() {
        return bytesSent;
    }

    public void setBytesSent(Long bytesSent) {
        this.bytesSent = bytesSent;
    }

    public String getBytesSentPersecond() {
        return bytesSentPersecond;
    }

    public void setBytesSentPersecond(String bytesSentPersecond) {
        this.bytesSentPersecond = bytesSentPersecond == null ? null : bytesSentPersecond.trim();
    }

    public Long getComSelect() {
        return comSelect;
    }

    public void setComSelect(Long comSelect) {
        this.comSelect = comSelect;
    }

    public String getComSelectPersecond() {
        return comSelectPersecond;
    }

    public void setComSelectPersecond(String comSelectPersecond) {
        this.comSelectPersecond = comSelectPersecond == null ? null : comSelectPersecond.trim();
    }

    public Long getComInsert() {
        return comInsert;
    }

    public void setComInsert(Long comInsert) {
        this.comInsert = comInsert;
    }

    public String getComInsertPersecond() {
        return comInsertPersecond;
    }

    public void setComInsertPersecond(String comInsertPersecond) {
        this.comInsertPersecond = comInsertPersecond == null ? null : comInsertPersecond.trim();
    }

    public Long getComUpdate() {
        return comUpdate;
    }

    public void setComUpdate(Long comUpdate) {
        this.comUpdate = comUpdate;
    }

    public String getComUpdatePersecond() {
        return comUpdatePersecond;
    }

    public void setComUpdatePersecond(String comUpdatePersecond) {
        this.comUpdatePersecond = comUpdatePersecond == null ? null : comUpdatePersecond.trim();
    }

    public Long getComDelete() {
        return comDelete;
    }

    public void setComDelete(Long comDelete) {
        this.comDelete = comDelete;
    }

    public String getComDeletePersecond() {
        return comDeletePersecond;
    }

    public void setComDeletePersecond(String comDeletePersecond) {
        this.comDeletePersecond = comDeletePersecond == null ? null : comDeletePersecond.trim();
    }

    public Long getComCommit() {
        return comCommit;
    }

    public void setComCommit(Long comCommit) {
        this.comCommit = comCommit;
    }

    public String getComCommitPersecond() {
        return comCommitPersecond;
    }

    public void setComCommitPersecond(String comCommitPersecond) {
        this.comCommitPersecond = comCommitPersecond == null ? null : comCommitPersecond.trim();
    }

    public Long getComRollback() {
        return comRollback;
    }

    public void setComRollback(Long comRollback) {
        this.comRollback = comRollback;
    }

    public String getComRollbackPersecond() {
        return comRollbackPersecond;
    }

    public void setComRollbackPersecond(String comRollbackPersecond) {
        this.comRollbackPersecond = comRollbackPersecond == null ? null : comRollbackPersecond.trim();
    }

    public Long getQuestions() {
        return questions;
    }

    public void setQuestions(Long questions) {
        this.questions = questions;
    }

    public String getQuestionsPersecond() {
        return questionsPersecond;
    }

    public void setQuestionsPersecond(String questionsPersecond) {
        this.questionsPersecond = questionsPersecond == null ? null : questionsPersecond.trim();
    }

    public Long getTransactions() {
        return transactions;
    }

    public void setTransactions(Long transactions) {
        this.transactions = transactions;
    }

    public String getTransactionsPersecond() {
        return transactionsPersecond;
    }

    public void setTransactionsPersecond(String transactionsPersecond) {
        this.transactionsPersecond = transactionsPersecond == null ? null : transactionsPersecond.trim();
    }

    public Long getCreatedTmpTables() {
        return createdTmpTables;
    }

    public void setCreatedTmpTables(Long createdTmpTables) {
        this.createdTmpTables = createdTmpTables;
    }

    public String getCreatedTmpTablesPersecond() {
        return createdTmpTablesPersecond;
    }

    public void setCreatedTmpTablesPersecond(String createdTmpTablesPersecond) {
        this.createdTmpTablesPersecond = createdTmpTablesPersecond == null ? null : createdTmpTablesPersecond.trim();
    }

    public Long getCreatedTmpDiskTables() {
        return createdTmpDiskTables;
    }

    public void setCreatedTmpDiskTables(Long createdTmpDiskTables) {
        this.createdTmpDiskTables = createdTmpDiskTables;
    }

    public String getCreatedTmpDiskTablesPersecond() {
        return createdTmpDiskTablesPersecond;
    }

    public void setCreatedTmpDiskTablesPersecond(String createdTmpDiskTablesPersecond) {
        this.createdTmpDiskTablesPersecond = createdTmpDiskTablesPersecond == null ? null : createdTmpDiskTablesPersecond.trim();
    }

    public Long getCreatedTmpFiles() {
        return createdTmpFiles;
    }

    public void setCreatedTmpFiles(Long createdTmpFiles) {
        this.createdTmpFiles = createdTmpFiles;
    }

    public String getCreatedTmpFilesPersecond() {
        return createdTmpFilesPersecond;
    }

    public void setCreatedTmpFilesPersecond(String createdTmpFilesPersecond) {
        this.createdTmpFilesPersecond = createdTmpFilesPersecond == null ? null : createdTmpFilesPersecond.trim();
    }

    public Long getInnodbDataReads() {
        return innodbDataReads;
    }

    public void setInnodbDataReads(Long innodbDataReads) {
        this.innodbDataReads = innodbDataReads;
    }

    public String getInnodbDataReadsPersecond() {
        return innodbDataReadsPersecond;
    }

    public void setInnodbDataReadsPersecond(String innodbDataReadsPersecond) {
        this.innodbDataReadsPersecond = innodbDataReadsPersecond == null ? null : innodbDataReadsPersecond.trim();
    }

    public Long getInnodbDataWrites() {
        return innodbDataWrites;
    }

    public void setInnodbDataWrites(Long innodbDataWrites) {
        this.innodbDataWrites = innodbDataWrites;
    }

    public String getInnodbDataWritesPersecond() {
        return innodbDataWritesPersecond;
    }

    public void setInnodbDataWritesPersecond(String innodbDataWritesPersecond) {
        this.innodbDataWritesPersecond = innodbDataWritesPersecond == null ? null : innodbDataWritesPersecond.trim();
    }

    public Long getInnodbDataFsyncs() {
        return innodbDataFsyncs;
    }

    public void setInnodbDataFsyncs(Long innodbDataFsyncs) {
        this.innodbDataFsyncs = innodbDataFsyncs;
    }

    public String getInnodbDataFsyncsPersecond() {
        return innodbDataFsyncsPersecond;
    }

    public void setInnodbDataFsyncsPersecond(String innodbDataFsyncsPersecond) {
        this.innodbDataFsyncsPersecond = innodbDataFsyncsPersecond == null ? null : innodbDataFsyncsPersecond.trim();
    }

    public Long getInnodbDataRead() {
        return innodbDataRead;
    }

    public void setInnodbDataRead(Long innodbDataRead) {
        this.innodbDataRead = innodbDataRead;
    }

    public String getInnodbDataReadPersecond() {
        return innodbDataReadPersecond;
    }

    public void setInnodbDataReadPersecond(String innodbDataReadPersecond) {
        this.innodbDataReadPersecond = innodbDataReadPersecond == null ? null : innodbDataReadPersecond.trim();
    }

    public Long getInnodbDataWritten() {
        return innodbDataWritten;
    }

    public void setInnodbDataWritten(Long innodbDataWritten) {
        this.innodbDataWritten = innodbDataWritten;
    }

    public String getInnodbDataWrittenPersecond() {
        return innodbDataWrittenPersecond;
    }

    public void setInnodbDataWrittenPersecond(String innodbDataWrittenPersecond) {
        this.innodbDataWrittenPersecond = innodbDataWrittenPersecond == null ? null : innodbDataWrittenPersecond.trim();
    }

    public Long getInnodbBufferPoolPagesDirty() {
        return innodbBufferPoolPagesDirty;
    }

    public void setInnodbBufferPoolPagesDirty(Long innodbBufferPoolPagesDirty) {
        this.innodbBufferPoolPagesDirty = innodbBufferPoolPagesDirty;
    }

    public String getInnodbBufferPoolPagesDirtyPersecond() {
        return innodbBufferPoolPagesDirtyPersecond;
    }

    public void setInnodbBufferPoolPagesDirtyPersecond(String innodbBufferPoolPagesDirtyPersecond) {
        this.innodbBufferPoolPagesDirtyPersecond = innodbBufferPoolPagesDirtyPersecond == null ? null : innodbBufferPoolPagesDirtyPersecond.trim();
    }

    public Long getInnodbBufferPoolPagesFlushed() {
        return innodbBufferPoolPagesFlushed;
    }

    public void setInnodbBufferPoolPagesFlushed(Long innodbBufferPoolPagesFlushed) {
        this.innodbBufferPoolPagesFlushed = innodbBufferPoolPagesFlushed;
    }

    public String getInnodbBufferPoolPagesFlushedPersecond() {
        return innodbBufferPoolPagesFlushedPersecond;
    }

    public void setInnodbBufferPoolPagesFlushedPersecond(String innodbBufferPoolPagesFlushedPersecond) {
        this.innodbBufferPoolPagesFlushedPersecond = innodbBufferPoolPagesFlushedPersecond == null ? null : innodbBufferPoolPagesFlushedPersecond.trim();
    }

    public String getInnodbBufferReadHitRatio() {
        return innodbBufferReadHitRatio;
    }

    public void setInnodbBufferReadHitRatio(String innodbBufferReadHitRatio) {
        this.innodbBufferReadHitRatio = innodbBufferReadHitRatio == null ? null : innodbBufferReadHitRatio.trim();
    }

    public String getInnodbBufferUsage() {
        return innodbBufferUsage;
    }

    public void setInnodbBufferUsage(String innodbBufferUsage) {
        this.innodbBufferUsage = innodbBufferUsage == null ? null : innodbBufferUsage.trim();
    }

    public Long getInnodbRowsInserted() {
        return innodbRowsInserted;
    }

    public void setInnodbRowsInserted(Long innodbRowsInserted) {
        this.innodbRowsInserted = innodbRowsInserted;
    }

    public String getInnodbRowsInsertedPersecond() {
        return innodbRowsInsertedPersecond;
    }

    public void setInnodbRowsInsertedPersecond(String innodbRowsInsertedPersecond) {
        this.innodbRowsInsertedPersecond = innodbRowsInsertedPersecond == null ? null : innodbRowsInsertedPersecond.trim();
    }

    public Long getInnodbRowsUpdated() {
        return innodbRowsUpdated;
    }

    public void setInnodbRowsUpdated(Long innodbRowsUpdated) {
        this.innodbRowsUpdated = innodbRowsUpdated;
    }

    public String getInnodbRowsUpdatedPersecond() {
        return innodbRowsUpdatedPersecond;
    }

    public void setInnodbRowsUpdatedPersecond(String innodbRowsUpdatedPersecond) {
        this.innodbRowsUpdatedPersecond = innodbRowsUpdatedPersecond == null ? null : innodbRowsUpdatedPersecond.trim();
    }

    public Long getInnodbRowsDeleted() {
        return innodbRowsDeleted;
    }

    public void setInnodbRowsDeleted(Long innodbRowsDeleted) {
        this.innodbRowsDeleted = innodbRowsDeleted;
    }

    public String getInnodbRowsDeletedPersecond() {
        return innodbRowsDeletedPersecond;
    }

    public void setInnodbRowsDeletedPersecond(String innodbRowsDeletedPersecond) {
        this.innodbRowsDeletedPersecond = innodbRowsDeletedPersecond == null ? null : innodbRowsDeletedPersecond.trim();
    }

    public Long getInnodbBufferPoolPagesTotal() {
        return innodbBufferPoolPagesTotal;
    }

    public void setInnodbBufferPoolPagesTotal(Long innodbBufferPoolPagesTotal) {
        this.innodbBufferPoolPagesTotal = innodbBufferPoolPagesTotal;
    }

    public Long getInnodbBufferPoolPagesFree() {
        return innodbBufferPoolPagesFree;
    }

    public void setInnodbBufferPoolPagesFree(Long innodbBufferPoolPagesFree) {
        this.innodbBufferPoolPagesFree = innodbBufferPoolPagesFree;
    }

    public Integer getInnodbPageSize() {
        return innodbPageSize;
    }

    public void setInnodbPageSize(Integer innodbPageSize) {
        this.innodbPageSize = innodbPageSize;
    }

    public Integer getSlowQueries() {
        return slowQueries;
    }

    public void setSlowQueries(Integer slowQueries) {
        this.slowQueries = slowQueries;
    }

    public Long getSlaveDelay() {
        return slaveDelay;
    }

    public void setSlaveDelay(Long slaveDelay) {
        this.slaveDelay = slaveDelay;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", serverId=").append(serverId);
        sb.append(", uptime=").append(uptime);
        sb.append(", openTables=").append(openTables);
        sb.append(", threadsConnected=").append(threadsConnected);
        sb.append(", threadsRunning=").append(threadsRunning);
        sb.append(", threadsCreated=").append(threadsCreated);
        sb.append(", threadsCached=").append(threadsCached);
        sb.append(", connections=").append(connections);
        sb.append(", abortedClients=").append(abortedClients);
        sb.append(", abortedConnects=").append(abortedConnects);
        sb.append(", bytesReceived=").append(bytesReceived);
        sb.append(", bytesReceivedPersecond=").append(bytesReceivedPersecond);
        sb.append(", bytesSent=").append(bytesSent);
        sb.append(", bytesSentPersecond=").append(bytesSentPersecond);
        sb.append(", comSelect=").append(comSelect);
        sb.append(", comSelectPersecond=").append(comSelectPersecond);
        sb.append(", comInsert=").append(comInsert);
        sb.append(", comInsertPersecond=").append(comInsertPersecond);
        sb.append(", comUpdate=").append(comUpdate);
        sb.append(", comUpdatePersecond=").append(comUpdatePersecond);
        sb.append(", comDelete=").append(comDelete);
        sb.append(", comDeletePersecond=").append(comDeletePersecond);
        sb.append(", comCommit=").append(comCommit);
        sb.append(", comCommitPersecond=").append(comCommitPersecond);
        sb.append(", comRollback=").append(comRollback);
        sb.append(", comRollbackPersecond=").append(comRollbackPersecond);
        sb.append(", questions=").append(questions);
        sb.append(", questionsPersecond=").append(questionsPersecond);
        sb.append(", transactions=").append(transactions);
        sb.append(", transactionsPersecond=").append(transactionsPersecond);
        sb.append(", createdTmpTables=").append(createdTmpTables);
        sb.append(", createdTmpTablesPersecond=").append(createdTmpTablesPersecond);
        sb.append(", createdTmpDiskTables=").append(createdTmpDiskTables);
        sb.append(", createdTmpDiskTablesPersecond=").append(createdTmpDiskTablesPersecond);
        sb.append(", createdTmpFiles=").append(createdTmpFiles);
        sb.append(", createdTmpFilesPersecond=").append(createdTmpFilesPersecond);
        sb.append(", innodbDataReads=").append(innodbDataReads);
        sb.append(", innodbDataReadsPersecond=").append(innodbDataReadsPersecond);
        sb.append(", innodbDataWrites=").append(innodbDataWrites);
        sb.append(", innodbDataWritesPersecond=").append(innodbDataWritesPersecond);
        sb.append(", innodbDataFsyncs=").append(innodbDataFsyncs);
        sb.append(", innodbDataFsyncsPersecond=").append(innodbDataFsyncsPersecond);
        sb.append(", innodbDataRead=").append(innodbDataRead);
        sb.append(", innodbDataReadPersecond=").append(innodbDataReadPersecond);
        sb.append(", innodbDataWritten=").append(innodbDataWritten);
        sb.append(", innodbDataWrittenPersecond=").append(innodbDataWrittenPersecond);
        sb.append(", innodbBufferPoolPagesDirty=").append(innodbBufferPoolPagesDirty);
        sb.append(", innodbBufferPoolPagesDirtyPersecond=").append(innodbBufferPoolPagesDirtyPersecond);
        sb.append(", innodbBufferPoolPagesFlushed=").append(innodbBufferPoolPagesFlushed);
        sb.append(", innodbBufferPoolPagesFlushedPersecond=").append(innodbBufferPoolPagesFlushedPersecond);
        sb.append(", innodbBufferReadHitRatio=").append(innodbBufferReadHitRatio);
        sb.append(", innodbBufferUsage=").append(innodbBufferUsage);
        sb.append(", innodbRowsInserted=").append(innodbRowsInserted);
        sb.append(", innodbRowsInsertedPersecond=").append(innodbRowsInsertedPersecond);
        sb.append(", innodbRowsUpdated=").append(innodbRowsUpdated);
        sb.append(", innodbRowsUpdatedPersecond=").append(innodbRowsUpdatedPersecond);
        sb.append(", innodbRowsDeleted=").append(innodbRowsDeleted);
        sb.append(", innodbRowsDeletedPersecond=").append(innodbRowsDeletedPersecond);
        sb.append(", innodbBufferPoolPagesTotal=").append(innodbBufferPoolPagesTotal);
        sb.append(", innodbBufferPoolPagesFree=").append(innodbBufferPoolPagesFree);
        sb.append(", innodbPageSize=").append(innodbPageSize);
        sb.append(", slowQueries=").append(slowQueries);
        sb.append(", slaveDelay=").append(slaveDelay);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}