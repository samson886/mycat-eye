/**  
 * All rights Reserved, Designed By www.openwork.org.cn
 * @Title:  SqlAdviserController.java   
 * @Package cn.bqjr.dbeye.agent.controller   
 * @Description:    TODO 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年5月22日 上午11:24:21   
 * @version V1.0 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved. 
 */
package io.mycat.eye.agent.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.mycat.eye.agent.service.SqlAdviserService;

/**   
 * @ClassName:  SqlAdviserController   
 * @Description:TODO
 * @author: 李平(360841519@qq.com)
 * @date:   2017年5月22日 上午11:24:21   
 *     
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved. 
 */
@RestController
@RequestMapping("/sql-adviser")
public class SqlAdviserController
{
    @Resource
    private SqlAdviserService sqlAdviserService;
    
    /**
     * 获取SQL建议
     * @Title: getAdvice   
     * @param request
     * @return        
     * @throws
     */
    @RequestMapping(value = "/advice", method = {RequestMethod.POST, RequestMethod.GET})
    public Object getAdvice(HttpServletRequest request)
    {
        Long serverId = new Long(request.getParameter("serverId").toString());
        String schema = request.getParameter("schema");
        String sql = request.getParameter("sql");
        return sqlAdviserService.getAdvice(serverId, schema, sql);
    }
}
