package io.mycat.eye.agent.bean;

import java.io.Serializable;

public class MycatCluster implements Serializable {
    private Integer id;

    private String clusterName;

    private String clusterHost;

    private Integer clusterPort;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public String getClusterHost() {
        return clusterHost;
    }

    public void setClusterHost(String clusterHost) {
        this.clusterHost = clusterHost;
    }

    public Integer getClusterPort() {
        return clusterPort;
    }

    public void setClusterPort(Integer clusterPort) {
        this.clusterPort = clusterPort;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", clusterName=").append(clusterName);
        sb.append(", clusterHost=").append(clusterHost);
        sb.append(", clusterPort=").append(clusterPort);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}