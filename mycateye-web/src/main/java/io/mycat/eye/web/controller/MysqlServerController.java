package io.mycat.eye.web.controller;

import io.mycat.eye.web.bean.MysqlServer;
import io.mycat.eye.web.service.MysqlServerService;
import io.mycat.eye.web.util.AgentUrlUtil;
import io.mycat.eye.web.util.RestTemplateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: MysqlServerController
 * @Description: MySQL服务器节点Controller
 * @author: 李平(360841519 @ qq.com)
 * @date: 2017年4月11日 下午4:25:31
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved.
 */
@RestController
public class MysqlServerController extends AbstractController {
    @Autowired
    private MysqlServerService mysqlServerService;
    @Autowired
    private AgentUrlUtil agentUrlUtil;
    @Autowired
    private RestTemplateUtils restTemplateUtils;

    @RequestMapping("/mysql/node/all")
    public List<MysqlServer> getAllNodes() {
        return mysqlServerService.getAllNodes();
    }


    @RequestMapping("/mysql/node/server")
    public List<MysqlServer> getServer() {

        return mysqlServerService.getAllNodes();
    }


}
