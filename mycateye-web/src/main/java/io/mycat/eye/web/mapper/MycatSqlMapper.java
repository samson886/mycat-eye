package io.mycat.eye.web.mapper;

import io.mycat.eye.web.bean.MycatSql;
import io.mycat.eye.web.bean.MycatSqlExample;
import io.mycat.eye.web.bean.MycatSqlKey;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MycatSqlMapper {
    long countByExample(MycatSqlExample example);

    int deleteByExample(MycatSqlExample example);

    int deleteByPrimaryKey(MycatSqlKey key);

    int insert(MycatSql record);

    int insertSelective(MycatSql record);

    List<MycatSql> selectByExampleWithBLOBs(MycatSqlExample example);

    List<MycatSql> selectByExample(MycatSqlExample example);

    MycatSql selectByPrimaryKey(MycatSqlKey key);

    int updateByExampleSelective(@Param("record") MycatSql record, @Param("example") MycatSqlExample example);

    int updateByExampleWithBLOBs(@Param("record") MycatSql record, @Param("example") MycatSqlExample example);

    int updateByExample(@Param("record") MycatSql record, @Param("example") MycatSqlExample example);

    int updateByPrimaryKeySelective(MycatSql record);

    int updateByPrimaryKeyWithBLOBs(MycatSql record);

    int updateByPrimaryKey(MycatSql record);
}