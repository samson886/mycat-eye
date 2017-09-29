package io.mycat.eye.web.service;

import java.util.List;

import io.mycat.eye.web.bean.MysqlServer;

/**
 * All rights Reserved, Designed By www.mycat.io
 *
 * @version V1.0
 * @Package www.mycat.io.service
 * @Description: 类描述：
 * @author: 李平(360841519@qq.com)
 * @date: 2017/5/4  14:36
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved.
 */
public interface MysqlServerService {
    
    MysqlServer getServerById(Long id);
    
    List<MysqlServer> getAllNodes();
}
