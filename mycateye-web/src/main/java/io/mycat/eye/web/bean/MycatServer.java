package io.mycat.eye.web.bean;

import java.io.Serializable;

public class MycatServer implements Serializable {
    private Integer id;

    private String serverName;

    private String serverHost;

    private Integer managerPort;

    private Integer serverPort;

    private Long startup;

    private String user;

    private String password;

    private Integer clusterId;

    private Byte isClusterNode;

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

    public String getServerHost() {
        return serverHost;
    }

    public void setServerHost(String serverHost) {
        this.serverHost = serverHost;
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

    public Long getStartup() {
        return startup;
    }

    public void setStartup(Long startup) {
        this.startup = startup;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getClusterId() {
        return clusterId;
    }

    public void setClusterId(Integer clusterId) {
        this.clusterId = clusterId;
    }

    public Byte getIsClusterNode() {
        return isClusterNode;
    }

    public void setIsClusterNode(Byte isClusterNode) {
        this.isClusterNode = isClusterNode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", serverName=").append(serverName);
        sb.append(", serverHost=").append(serverHost);
        sb.append(", managerPort=").append(managerPort);
        sb.append(", serverPort=").append(serverPort);
        sb.append(", startup=").append(startup);
        sb.append(", user=").append(user);
        sb.append(", password=").append(password);
        sb.append(", clusterId=").append(clusterId);
        sb.append(", isClusterNode=").append(isClusterNode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}