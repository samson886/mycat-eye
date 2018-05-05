package io.mycat.eye.web.service;

import io.mycat.eye.web.bean.MycatSqlDetail;
import io.mycat.eye.web.bean.MycatSqlDetailExample;
import io.mycat.eye.web.bean.MycatSqlExecute;
import io.mycat.eye.web.bean.MycatSqlExecuteExample;
import io.mycat.eye.web.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xqy on 18/5/1.
 */
@Service
public class MycatSqlExecuteService {
    @Autowired
    MycatSqlExecuteMapper mycatSqlExecuteMapper;

    @Autowired
    MycatSqlDetailMapper mycatSqlDetailMapper;


    public List<MycatSqlExecute> getExecuteSql(int server_id, long beginTime, long endTime){
        MycatSqlExecuteExample example = new MycatSqlExecuteExample();
        MycatSqlExecuteExample.Criteria criteria = example.createCriteria();
        criteria.andServerIdEqualTo(server_id);
        return mycatSqlExecuteMapper.selectByExample(example);
    }

    public List<MycatSqlDetail> getSqlDetail(long sql_id,int server_id){
        MycatSqlDetailExample example = new MycatSqlDetailExample();
        MycatSqlDetailExample.Criteria criteria = example.createCriteria();
        criteria.andSqlIdEqualTo(sql_id);
        return mycatSqlDetailMapper.selectByExample(example);
    }

}
