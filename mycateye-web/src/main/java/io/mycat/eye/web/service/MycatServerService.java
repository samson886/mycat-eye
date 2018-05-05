package io.mycat.eye.web.service;

import io.mycat.eye.web.bean.MycatServer;
import io.mycat.eye.web.bean.MycatServerExample;
import io.mycat.eye.web.mapper.MycatServerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xqy on 18/5/1.
 */
@Service
public class MycatServerService {

    @Autowired
    MycatServerMapper mycatServerMapper;

    public List<MycatServer> getMycatServer(){
        MycatServerExample example = new MycatServerExample();
        return mycatServerMapper.selectByExample(example);
    }

    public MycatServer getServer(int id){
        return mycatServerMapper.selectByPrimaryKey(id);
    }

    public void addServer(MycatServer server){
        mycatServerMapper.insertSelective(server);
    }

    public void updateServer(MycatServer server){
        mycatServerMapper.updateByPrimaryKey(server);
    }

    public void delete(int id){
        mycatServerMapper.deleteByPrimaryKey(id);
    }
}
