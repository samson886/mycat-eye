package io.mycat.eye.web.service;

import io.mycat.eye.web.bean.MycatCluster;
import io.mycat.eye.web.bean.MycatClusterExample;
import io.mycat.eye.web.mapper.MycatClusterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xqy on 18/5/3.
 */
@Service
public class MycatClusterService {
    @Autowired
    MycatClusterMapper mapper;

    public List<MycatCluster> getList(MycatClusterExample example){
        return mapper.selectByExample(example);
    }

    public MycatCluster getCluster(int id){
        return mapper.selectByPrimaryKey(id);
    }

    public void addCluster(MycatCluster cluster){
        mapper.insertSelective(cluster);
    }

    public void updateCluster(MycatCluster cluster){
        mapper.updateByPrimaryKeySelective(cluster);
    }

    public void deleteCluster(int id){
        mapper.deleteByPrimaryKey(id);
    }
}
