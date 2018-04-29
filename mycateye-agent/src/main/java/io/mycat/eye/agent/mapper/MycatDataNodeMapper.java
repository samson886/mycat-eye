package io.mycat.eye.agent.mapper;

import io.mycat.eye.agent.bean.MycatDataNode;
import io.mycat.eye.agent.bean.MycatDataNodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MycatDataNodeMapper {
    long countByExample(MycatDataNodeExample example);

    int deleteByExample(MycatDataNodeExample example);

    int insert(MycatDataNode record);

    int insertSelective(MycatDataNode record);

    List<MycatDataNode> selectByExample(MycatDataNodeExample example);

    int updateByExampleSelective(@Param("record") MycatDataNode record, @Param("example") MycatDataNodeExample example);

    int updateByExample(@Param("record") MycatDataNode record, @Param("example") MycatDataNodeExample example);
}