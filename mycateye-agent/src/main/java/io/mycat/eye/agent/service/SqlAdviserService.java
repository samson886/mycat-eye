/**  
 * All rights Reserved, Designed By www.openwork.org.cn
 * @Title:  SqlAdviserService.java   
 * @Package cn.bqjr.dbeye.agent.service   
 * @Description:    TODO 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年5月22日 上午8:45:32   
 * @version V1.0 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved. 
 */
package io.mycat.eye.agent.service;

/**
 * @ClassName: SqlAdviserService
 * @Description:SQL建议Service
 * @author: 李平(360841519@qq.com)
 * @date: 2017年5月22日 上午8:45:32
 * 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved.
 */
public interface SqlAdviserService {
    /**
     * 获取SQL建议
     * @Title: getAdvice   
     * @param sql
     * @return        
     * @throws
     */
    String getAdvice(Long serverId, String schema, String sql);
}
