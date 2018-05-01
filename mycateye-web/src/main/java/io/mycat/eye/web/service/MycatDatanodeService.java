package io.mycat.eye.web.service;

import io.mycat.eye.web.bean.MycatDataNode;
import io.mycat.eye.web.bean.MycatDataNodeExample;
import io.mycat.eye.web.mapper.MycatDataNodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xqy on 18/5/1.
 */
@Service
public class MycatDatanodeService {
    @Autowired
    MycatDataNodeMapper mapper;

    public List<MycatDataNode> getDataNode(int server_id){
        MycatDataNodeExample example = new MycatDataNodeExample();
        MycatDataNodeExample.Criteria criteria = example.createCriteria();
        criteria.andServerIdEqualTo(server_id);
        return mapper.selectByExample(example);
    }
}
