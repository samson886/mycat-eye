package io.mycat.eye.agent.bean;

import java.io.Serializable;

public class MycatServer implements Serializable {
    private Integer id;

    private String serverName;

    private String ipAddr;

    private Integer managerPort;

    private Integer serverPort;

    private Integer clusterId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public Integer getManagerPort() {
        return managerPort;
    }

    public void setManagerPort(Integer managerPort) {
        this.managerPort = managerPort;
    }

    public Integer getServerPort() {
        return serverPort;
    }

    public void setServerPort(Integer serverPort) {
        this.serverPort = serverPort;
    }

    public Integer getClusterId() {
        return clusterId;
    }

    public void setClusterId(Integer clusterId) {
        this.clusterId = clusterId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", serverName=").append(serverName);
        sb.append(", ipAddr=").append(ipAddr);
        sb.append(", managerPort=").append(managerPort);
        sb.append(", serverPort=").append(serverPort);
        sb.append(", clusterId=").append(clusterId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}