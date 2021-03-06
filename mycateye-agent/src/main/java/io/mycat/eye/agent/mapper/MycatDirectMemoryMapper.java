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

    int deleteByPrimaryKey(Integer id);

    int insert(MycatDirectMemory record);

    int insertSelective(MycatDirectMemory record);

    List<MycatDirectMemory> selectByExample(MycatDirectMemoryExample example);

    MycatDirectMemory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MycatDirectMemory record, @Param("example") MycatDirectMemoryExample example);

    int updateByExample(@Param("record") MycatDirectMemory record, @Param("example") MycatDirectMemoryExample example);

    int updateByPrimaryKeySelective(MycatDirectMemory record);

    int updateByPrimaryKey(MycatDirectMemory record);
}