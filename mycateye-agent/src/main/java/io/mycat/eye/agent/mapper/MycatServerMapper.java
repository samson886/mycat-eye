package io.mycat.eye.agent.mapper;


import io.mycat.eye.agent.bean.MycatServer;
import io.mycat.eye.agent.bean.MycatServerExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MycatServerMapper {
    long countByExample(MycatServerExample example);

    int deleteByExample(MycatServerExample example);

    int insert(MycatServer record);

    int insertSelective(MycatServer record);

    List<MycatServer> selectByExample(MycatServerExample example);

    int updateByExampleSelective(@Param("record") MycatServer record, @Param("example") MycatServerExample example);

    int updateByExample(@Param("record") MycatServer record, @Param("example") MycatServerExample example);
}