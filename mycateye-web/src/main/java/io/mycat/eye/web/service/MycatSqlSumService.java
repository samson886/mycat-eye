package io.mycat.eye.web.service;

import io.mycat.eye.web.bean.MycatSqlSum;
import io.mycat.eye.web.bean.MycatSqlSumExample;
import io.mycat.eye.web.mapper.MycatSqlSumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by xqy on 18/5/4.
 */
@Service
public class MycatSqlSumService {

    @Autowired
    MycatSqlSumMapper mycatSqlSumMapper;

    public List<MycatSqlSum> getSumUser(MycatSqlSumExample example){
        List<MycatSqlSum> list = mycatSqlSumMapper.selectByExample(example);

        return list;
    }
}
