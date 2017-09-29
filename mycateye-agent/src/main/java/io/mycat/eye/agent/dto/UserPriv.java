package io.mycat.eye.agent.dto;

/**
 * 
 * @ClassName:  UserPriv   
 * @Description:用户权限信息
 * @author: 李平(360841519@qq.com)
 * @date:   2017年5月18日 上午10:44:43   
 *     
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved.
 */
public class UserPriv {
    private String user;
    private String host;
    private String type;
    private String priv;
    private String grant;

    /**
     * @return the user
     */
    public String getUser() {
	return user;
    }

    /**
     * @param user
     *            the user to set
     */
    public void setUser(String user) {
	this.user = user;
    }

    /**
     * @return the host
     */
    public String getHost() {
	return host;
    }

    /**
     * @param host
     *            the host to set
     */
    public void setHost(String host) {
	this.host = host;
    }

    /**
     * @return the type
     */
    public String getType() {
	return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(String type) {
	this.type = type;
    }

    /**
     * @return the priv
     */
    public String getPriv() {
	return priv;
    }

    /**
     * @param priv
     *            the priv to set
     */
    public void setPriv(String priv) {
	this.priv = priv;
    }

    /**
     * @return the grant
     */
    public String getGrant() {
	return grant;
    }

    /**
     * @param grant
     *            the grant to set
     */
    public void setGrant(String grant) {
	this.grant = grant;
    }

}
