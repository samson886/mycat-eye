package io.mycat.eye.web.bean;

import java.io.Serializable;

public class MycatDirectMemory implements Serializable {
    private Integer id;

    private String mdirectMemoryMaxed;

    private String directMemoryUsed;

    private String directMemoryAvailable;

    private Float safetyFraction;

    private String directMemoryReserved;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMdirectMemoryMaxed() {
        return mdirectMemoryMaxed;
    }

    public void setMdirectMemoryMaxed(String mdirectMemoryMaxed) {
        this.mdirectMemoryMaxed = mdirectMemoryMaxed;
    }

    public String getDirectMemoryUsed() {
        return directMemoryUsed;
    }

    public void setDirectMemoryUsed(String directMemoryUsed) {
        this.directMemoryUsed = directMemoryUsed;
    }

    public String getDirectMemoryAvailable() {
        return directMemoryAvailable;
    }

    public void setDirectMemoryAvailable(String directMemoryAvailable) {
        this.directMemoryAvailable = directMemoryAvailable;
    }

    public Float getSafetyFraction() {
        return safetyFraction;
    }

    public void setSafetyFraction(Float safetyFraction) {
        this.safetyFraction = safetyFraction;
    }

    public String getDirectMemoryReserved() {
        return directMemoryReserved;
    }

    public void setDirectMemoryReserved(String directMemoryReserved) {
        this.directMemoryReserved = directMemoryReserved;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", mdirectMemoryMaxed=").append(mdirectMemoryMaxed);
        sb.append(", directMemoryUsed=").append(directMemoryUsed);
        sb.append(", directMemoryAvailable=").append(directMemoryAvailable);
        sb.append(", safetyFraction=").append(safetyFraction);
        sb.append(", directMemoryReserved=").append(directMemoryReserved);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}