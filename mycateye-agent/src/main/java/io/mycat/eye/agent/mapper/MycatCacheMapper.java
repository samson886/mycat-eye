package io.mycat.eye.agent.mapper;

import io.mycat.eye.agent.bean.MycatCache;
import io.mycat.eye.agent.bean.MycatCacheExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MycatCacheMapper {
    long countByExample(MycatCacheExample example);

    int deleteByExample(MycatCacheExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MycatCache record);

    int insertSelective(MycatCache record);

    List<MycatCache> selectByExample(MycatCacheExample example);

    MycatCache selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MycatCache record, @Param("example") MycatCacheExample example);

    int updateByExample(@Param("record") MycatCache record, @Param("example") MycatCacheExample example);

    int updateByPrimaryKeySelective(MycatCache record);

    int updateByPrimaryKey(MycatCache record);
}