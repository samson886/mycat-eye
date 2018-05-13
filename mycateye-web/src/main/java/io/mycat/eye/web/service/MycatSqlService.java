package io.mycat.eye.web.service;

import io.mycat.eye.web.bean.*;
import io.mycat.eye.web.mapper.MycatSqlHighMapper;
import io.mycat.eye.web.mapper.MycatSqlMapper;
import io.mycat.eye.web.mapper.MycatSqlSlowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xqy on 18/5/4.
 */
@Service
public class MycatSqlService {

    @Autowired
    MycatSqlMapper sqlMapper;

    @Autowired
    MycatSqlHighMapper sqlHighMapper;

    @Autowired
    MycatSqlSlowMapper sqlSlowMapper;

    public List<MycatSql> getAll(int server_id, long beginTime, long endTime){
        MycatSqlExample example = new MycatSqlExample();
        MycatSqlExample.Criteria criteria = example.createCriteria();
        criteria.andServerIdEqualTo(server_id);
        criteria.andCollectTimeBetween(beginTime,endTime);
        return sqlMapper.selectByExample(example);
    }

    public List<MycatSqlHigh> getHigh(int server_id, long beginTime, long endTime){
        MycatSqlHighExample example = new MycatSqlHighExample();
        MycatSqlHighExample.Criteria criteria = example.createCriteria();
        criteria.andServerIdEqualTo(server_id);
        criteria.andCollectTimeBetween(beginTime,endTime);
        return sqlHighMapper.selectByExample(example);
    }

    public List<MycatSqlSlow> getSlow(int server_id, long beginTime, long endTime){
        MycatSqlSlowExample example = new MycatSqlSlowExample();
        MycatSqlSlowExample.Criteria criteria = example.createCriteria();
        criteria.andServerIdEqualTo(server_id);
        criteria.andCollectTimeBetween(beginTime,endTime);
        return sqlSlowMapper.selectByExample(example);
    }
}
