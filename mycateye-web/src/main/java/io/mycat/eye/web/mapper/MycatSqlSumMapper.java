package io.mycat.eye.web.mapper;

import io.mycat.eye.web.bean.MycatSqlSum;
import io.mycat.eye.web.bean.MycatSqlSumExample;
import io.mycat.eye.web.bean.MycatSqlSumKey;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MycatSqlSumMapper {
    long countByExample(MycatSqlSumExample example);

    int deleteByExample(MycatSqlSumExample example);

    int deleteByPrimaryKey(MycatSqlSumKey key);

    int insert(MycatSqlSum record);

    int insertSelective(MycatSqlSum record);

    List<MycatSqlSum> selectByExample(MycatSqlSumExample example);

    MycatSqlSum selectByPrimaryKey(MycatSqlSumKey key);

    int updateByExampleSelective(@Param("record") MycatSqlSum record, @Param("example") MycatSqlSumExample example);

    int updateByExample(@Param("record") MycatSqlSum record, @Param("example") MycatSqlSumExample example);

    int updateByPrimaryKeySelective(MycatSqlSum record);

    int updateByPrimaryKey(MycatSqlSum record);
}