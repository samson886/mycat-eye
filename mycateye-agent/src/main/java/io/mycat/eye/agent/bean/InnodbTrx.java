package io.mycat.eye.agent.bean;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class InnodbTrx implements Serializable {
    private String trxId;

    private String trxState;

    private Date trxStarted;

    private String trxRequestedLockId;

    private Date trxWaitStarted;

    private BigInteger trxWeight;

    private BigInteger trxMysqlThreadId;

    private String trxQuery;

    private String trxOperationState;

    private BigInteger trxTablesInUse;

    private BigInteger trxTablesLocked;

    private BigInteger trxLockStructs;

    private BigInteger trxLockMemoryBytes;

    private BigInteger trxRowsLocked;

    private BigInteger trxRowsModified;

    private BigInteger trxConcurrencyTickets;

    private String trxIsolationLevel;

    private Integer trxUniqueChecks;

    private Integer trxForeignKeyChecks;

    private String trxLastForeignKeyError;

    private Integer trxAdaptiveHashLatched;

    private BigInteger trxAdaptiveHashTimeout;

    private Integer trxIsReadOnly;

    private Integer trxAutocommitNonLocking;

    private static final long serialVersionUID = 1L;

	public String getTrxId() {
		return trxId;
	}

	public void setTrxId(String trxId) {
		this.trxId = trxId;
	}

	public String getTrxState() {
		return trxState;
	}

	public void setTrxState(String trxState) {
		this.trxState = trxState;
	}

	public Date getTrxStarted() {
		return trxStarted;
	}

	public void setTrxStarted(Date trxStarted) {
		this.trxStarted = trxStarted;
	}

	public String getTrxRequestedLockId() {
		return trxRequestedLockId;
	}

	public void setTrxRequestedLockId(String trxRequestedLockId) {
		this.trxRequestedLockId = trxRequestedLockId;
	}

	public Date getTrxWaitStarted() {
		return trxWaitStarted;
	}

	public void setTrxWaitStarted(Date trxWaitStarted) {
		this.trxWaitStarted = trxWaitStarted;
	}

	public BigInteger getTrxWeight() {
		return trxWeight;
	}

	public void setTrxWeight(BigInteger trxWeight) {
		this.trxWeight = trxWeight;
	}

	public BigInteger getTrxMysqlThreadId() {
		return trxMysqlThreadId;
	}

	public void setTrxMysqlThreadId(BigInteger trxMysqlThreadId) {
		this.trxMysqlThreadId = trxMysqlThreadId;
	}

	public String getTrxQuery() {
		return trxQuery;
	}

	public void setTrxQuery(String trxQuery) {
		this.trxQuery = trxQuery;
	}

	public String getTrxOperationState() {
		return trxOperationState;
	}

	public void setTrxOperationState(String trxOperationState) {
		this.trxOperationState = trxOperationState;
	}

	public BigInteger getTrxTablesInUse() {
		return trxTablesInUse;
	}

	public void setTrxTablesInUse(BigInteger trxTablesInUse) {
		this.trxTablesInUse = trxTablesInUse;
	}

	public BigInteger getTrxTablesLocked() {
		return trxTablesLocked;
	}

	public void setTrxTablesLocked(BigInteger trxTablesLocked) {
		this.trxTablesLocked = trxTablesLocked;
	}

	public BigInteger getTrxLockStructs() {
		return trxLockStructs;
	}

	public void setTrxLockStructs(BigInteger trxLockStructs) {
		this.trxLockStructs = trxLockStructs;
	}

	public BigInteger getTrxLockMemoryBytes() {
		return trxLockMemoryBytes;
	}

	public void setTrxLockMemoryBytes(BigInteger trxLockMemoryBytes) {
		this.trxLockMemoryBytes = trxLockMemoryBytes;
	}

	public BigInteger getTrxRowsLocked() {
		return trxRowsLocked;
	}

	public void setTrxRowsLocked(BigInteger trxRowsLocked) {
		this.trxRowsLocked = trxRowsLocked;
	}

	public BigInteger getTrxRowsModified() {
		return trxRowsModified;
	}

	public void setTrxRowsModified(BigInteger trxRowsModified) {
		this.trxRowsModified = trxRowsModified;
	}

	public BigInteger getTrxConcurrencyTickets() {
		return trxConcurrencyTickets;
	}

	public void setTrxConcurrencyTickets(BigInteger trxConcurrencyTickets) {
		this.trxConcurrencyTickets = trxConcurrencyTickets;
	}

	public String getTrxIsolationLevel() {
		return trxIsolationLevel;
	}

	public void setTrxIsolationLevel(String trxIsolationLevel) {
		this.trxIsolationLevel = trxIsolationLevel;
	}

	public Integer getTrxUniqueChecks() {
		return trxUniqueChecks;
	}

	public void setTrxUniqueChecks(Integer trxUniqueChecks) {
		this.trxUniqueChecks = trxUniqueChecks;
	}

	public Integer getTrxForeignKeyChecks() {
		return trxForeignKeyChecks;
	}

	public void setTrxForeignKeyChecks(Integer trxForeignKeyChecks) {
		this.trxForeignKeyChecks = trxForeignKeyChecks;
	}

	public String getTrxLastForeignKeyError() {
		return trxLastForeignKeyError;
	}

	public void setTrxLastForeignKeyError(String trxLastForeignKeyError) {
		this.trxLastForeignKeyError = trxLastForeignKeyError;
	}

	public Integer getTrxAdaptiveHashLatched() {
		return trxAdaptiveHashLatched;
	}

	public void setTrxAdaptiveHashLatched(Integer trxAdaptiveHashLatched) {
		this.trxAdaptiveHashLatched = trxAdaptiveHashLatched;
	}

	public BigInteger getTrxAdaptiveHashTimeout() {
		return trxAdaptiveHashTimeout;
	}

	public void setTrxAdaptiveHashTimeout(BigInteger trxAdaptiveHashTimeout) {
		this.trxAdaptiveHashTimeout = trxAdaptiveHashTimeout;
	}

	public Integer getTrxIsReadOnly() {
		return trxIsReadOnly;
	}

	public void setTrxIsReadOnly(Integer trxIsReadOnly) {
		this.trxIsReadOnly = trxIsReadOnly;
	}

	public Integer getTrxAutocommitNonLocking() {
		return trxAutocommitNonLocking;
	}

	public void setTrxAutocommitNonLocking(Integer trxAutocommitNonLocking) {
		this.trxAutocommitNonLocking = trxAutocommitNonLocking;
	}

}