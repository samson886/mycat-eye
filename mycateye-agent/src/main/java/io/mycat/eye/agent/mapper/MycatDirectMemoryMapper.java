package io.mycat.eye.agent.mapper;

import io.mycat.eye.agent.bean.MycatDirectMemory;
import io.mycat.eye.agent.bean.MycatDirectMemoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MycatDirectMemoryMapper {
    long countByExample(MycatDirectMemoryExample example);

    int deleteByExample(MycatDirectMemoryExample example);

    int insert(MycatDirectMemory record);

    int insertSelective(MycatDirectMemory record);

    List<MycatDirectMemory> selectByExample(MycatDirectMemoryExample example);

    int updateByExampleSelective(@Param("record") MycatDirectMemory record, @Param("example") MycatDirectMemoryExample example);

    int updateByExample(@Param("record") MycatDirectMemory record, @Param("example") MycatDirectMemoryExample example);
}