package io.mycat.eye.agent.mapper;

import io.mycat.eye.agent.bean.MycatServer;
import io.mycat.eye.agent.bean.MycatServerExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MycatServerMapper {
    long countByExample(MycatServerExample example);

    int deleteByExample(MycatServerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MycatServer record);

    int insertSelective(MycatServer record);

    List<MycatServer> selectByExample(MycatServerExample example);

    MycatServer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MycatServer record, @Param("example") MycatServerExample example);

    int updateByExample(@Param("record") MycatServer record, @Param("example") MycatServerExample example);

    int updateByPrimaryKeySelective(MycatServer record);

    int updateByPrimaryKey(MycatServer record);
}