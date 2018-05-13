package io.mycat.eye.web.mapper;

import io.mycat.eye.web.bean.MycatSqlLarge;
import io.mycat.eye.web.bean.MycatSqlLargeExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MycatSqlLargeMapper {
    long countByExample(MycatSqlLargeExample example);

    int deleteByExample(MycatSqlLargeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MycatSqlLarge record);

    int insertSelective(MycatSqlLarge record);

    List<MycatSqlLarge> selectByExampleWithBLOBs(MycatSqlLargeExample example);

    List<MycatSqlLarge> selectByExample(MycatSqlLargeExample example);

    MycatSqlLarge selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MycatSqlLarge record, @Param("example") MycatSqlLargeExample example);

    int updateByExampleWithBLOBs(@Param("record") MycatSqlLarge record, @Param("example") MycatSqlLargeExample example);

    int updateByExample(@Param("record") MycatSqlLarge record, @Param("example") MycatSqlLargeExample example);

    int updateByPrimaryKeySelective(MycatSqlLarge record);

    int updateByPrimaryKeyWithBLOBs(MycatSqlLarge record);

    int updateByPrimaryKey(MycatSqlLarge record);
}