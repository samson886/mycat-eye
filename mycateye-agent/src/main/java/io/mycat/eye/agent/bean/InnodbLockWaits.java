package io.mycat.eye.agent.bean;

import java.io.Serializable;

public class InnodbLockWaits implements Serializable {
    private String requestingTrxId;

    private String requestedLockId;

    private String blockingTrxId;

    private String blockingLockId;

    private static final long serialVersionUID = 1L;

    public String getRequestingTrxId() {
        return requestingTrxId;
    }

    public void setRequestingTrxId(String requestingTrxId) {
        this.requestingTrxId = requestingTrxId == null ? null : requestingTrxId.trim();
    }

    public String getRequestedLockId() {
        return requestedLockId;
    }

    public void setRequestedLockId(String requestedLockId) {
        this.requestedLockId = requestedLockId == null ? null : requestedLockId.trim();
    }

    public String getBlockingTrxId() {
        return blockingTrxId;
    }

    public void setBlockingTrxId(String blockingTrxId) {
        this.blockingTrxId = blockingTrxId == null ? null : blockingTrxId.trim();
    }

    public String getBlockingLockId() {
        return blockingLockId;
    }

    public void setBlockingLockId(String blockingLockId) {
        this.blockingLockId = blockingLockId == null ? null : blockingLockId.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", requestingTrxId=").append(requestingTrxId);
        sb.append(", requestedLockId=").append(requestedLockId);
        sb.append(", blockingTrxId=").append(blockingTrxId);
        sb.append(", blockingLockId=").append(blockingLockId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}