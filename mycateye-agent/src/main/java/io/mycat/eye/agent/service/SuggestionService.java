/**  
 * All rights Reserved, Designed By www.openwork.org.cn
 * @Title:  SuggestionService.java   
 * @Package cn.bqjr.dbeye.agent.service   
 * @Description:    TODO 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年5月11日 上午11:35:47   
 * @version V1.0 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved. 
 */
package io.mycat.eye.agent.service;

/**
 * @ClassName: SuggestionService
 * @Description:TODO
 * @author: 李平(360841519@qq.com)
 * @date: 2017年5月11日 上午11:35:47
 * 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved.
 */
public interface SuggestionService {
    /**
     * 根据指定MySQL节点状态，获取优化建议
     * @Title: getSuggestion   
     * @param serverId
     * @return        
     * @throws
     */
    Object getSuggestion(Long serverId);
}
