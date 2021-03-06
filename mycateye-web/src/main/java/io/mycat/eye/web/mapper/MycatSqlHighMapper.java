package io.mycat.eye.web.mapper;

import io.mycat.eye.web.bean.MycatSqlHigh;
import io.mycat.eye.web.bean.MycatSqlHighExample;
import io.mycat.eye.web.bean.MycatSqlHighKey;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MycatSqlHighMapper {
    long countByExample(MycatSqlHighExample example);

    int deleteByExample(MycatSqlHighExample example);

    int deleteByPrimaryKey(MycatSqlHighKey key);

    int insert(MycatSqlHigh record);

    int insertSelective(MycatSqlHigh record);

    List<MycatSqlHigh> selectByExampleWithBLOBs(MycatSqlHighExample example);

    List<MycatSqlHigh> selectByExample(MycatSqlHighExample example);

    MycatSqlHigh selectByPrimaryKey(MycatSqlHighKey key);

    int updateByExampleSelective(@Param("record") MycatSqlHigh record, @Param("example") MycatSqlHighExample example);

    int updateByExampleWithBLOBs(@Param("record") MycatSqlHigh record, @Param("example") MycatSqlHighExample example);

    int updateByExample(@Param("record") MycatSqlHigh record, @Param("example") MycatSqlHighExample example);

    int updateByPrimaryKeySelective(MycatSqlHigh record);

    int updateByPrimaryKeyWithBLOBs(MycatSqlHigh record);

    int updateByPrimaryKey(MycatSqlHigh record);
}