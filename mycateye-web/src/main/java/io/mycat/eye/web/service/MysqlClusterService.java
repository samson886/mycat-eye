package io.mycat.eye.web.service;

import io.mycat.eye.web.bean.MysqlCluster;
import io.mycat.eye.web.bean.MysqlClusterExample;
import io.mycat.eye.web.mapper.MysqlClusterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xqy on 18/5/14.
 */
@Service
public class MysqlClusterService {

    @Autowired
    MysqlClusterMapper mapper;

    public List<MysqlCluster> getAll(MysqlClusterExample example){
        return mapper.selectByExample(example);
    }

}
