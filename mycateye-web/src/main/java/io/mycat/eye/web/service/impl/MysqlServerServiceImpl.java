package io.mycat.eye.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mycat.eye.web.bean.MysqlServer;
import io.mycat.eye.web.bean.MysqlServerExample;
import io.mycat.eye.web.mapper.MysqlServerMapper;
import io.mycat.eye.web.service.MysqlServerService;

/**
 * All rights Reserved, Designed By www.mycat.io
 *
 * @version V1.0
 * @Package www.mycat.io.service
 * @Description: 类描述：
 * @author: 李平(360841519@qq.com)
 * @date: 2017/5/4  14:38
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved.
 */
@Service
public class MysqlServerServiceImpl implements MysqlServerService {
    @Autowired
    private MysqlServerMapper mysqlServerMapper;

    @Override
    public MysqlServer getServerById(Long id) {

        return mysqlServerMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<MysqlServer> getAllNodes()
    {
        MysqlServerExample example = new MysqlServerExample();
        return mysqlServerMapper.selectByExample(example);
    }
}
