package io.mycat.eye.web.service;

import io.mycat.eye.web.bean.MycatBackend;
import io.mycat.eye.web.bean.MycatBackendExample;
import io.mycat.eye.web.mapper.MycatBackendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xqy on 18/5/1.
 */
@Service
public class MycatBackendService {
    @Autowired
    MycatBackendMapper mapper;

    public List<MycatBackend> getBackend(int server_id,long beginTime, long endTime){
        MycatBackendExample example = new MycatBackendExample();
        MycatBackendExample.Criteria criteria = example.createCriteria();
        criteria.andMycatIdEqualTo(server_id);
        criteria.andCollectTimeBetween(beginTime,endTime);
        return mapper.selectByExample(example);
    }
}
