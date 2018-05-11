package io.mycat.eye.agent.mapper;

import io.mycat.eye.agent.bean.MycatSqlSlow;
import io.mycat.eye.agent.bean.MycatSqlSlowExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MycatSqlSlowMapper {
    long countByExample(MycatSqlSlowExample example);

    int deleteByExample(MycatSqlSlowExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MycatSqlSlow record);

    int insertSelective(MycatSqlSlow record);

    List<MycatSqlSlow> selectByExampleWithBLOBs(MycatSqlSlowExample example);

    List<MycatSqlSlow> selectByExample(MycatSqlSlowExample example);

    MycatSqlSlow selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MycatSqlSlow record, @Param("example") MycatSqlSlowExample example);

    int updateByExampleWithBLOBs(@Param("record") MycatSqlSlow record, @Param("example") MycatSqlSlowExample example);

    int updateByExample(@Param("record") MycatSqlSlow record, @Param("example") MycatSqlSlowExample example);

    int updateByPrimaryKeySelective(MycatSqlSlow record);

    int updateByPrimaryKeyWithBLOBs(MycatSqlSlow record);

    int updateByPrimaryKey(MycatSqlSlow record);
}