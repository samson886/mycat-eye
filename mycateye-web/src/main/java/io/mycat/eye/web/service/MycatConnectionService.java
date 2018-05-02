package io.mycat.eye.web.service;

import io.mycat.eye.web.bean.MycatConnection;
import io.mycat.eye.web.bean.MycatConnectionExample;
import io.mycat.eye.web.mapper.MycatConnectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xqy on 18/5/1.
 */
@Service
public class MycatConnectionService {
    @Autowired
    MycatConnectionMapper mapper;

    public List<MycatConnection> getConnection(int server_id, long beginTime, long endTime){
        MycatConnectionExample example = new MycatConnectionExample();
        MycatConnectionExample.Criteria criteria = example.createCriteria();
        criteria.andMycatIdEqualTo(server_id);
        criteria.andCollectTimeBetween(beginTime,endTime);
        return mapper.selectByExample(example);
    }
}
