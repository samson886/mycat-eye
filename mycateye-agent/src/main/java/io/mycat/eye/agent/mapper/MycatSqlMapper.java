package io.mycat.eye.agent.mapper;

import io.mycat.eye.agent.bean.MycatSql;
import io.mycat.eye.agent.bean.MycatSqlExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MycatSqlMapper {
    long countByExample(MycatSqlExample example);

    int deleteByExample(MycatSqlExample example);

    int insert(MycatSql record);

    int insertSelective(MycatSql record);

    List<MycatSql> selectByExample(MycatSqlExample example);

    int updateByExampleSelective(@Param("record") MycatSql record, @Param("example") MycatSqlExample example);

    int updateByExample(@Param("record") MycatSql record, @Param("example") MycatSqlExample example);
}