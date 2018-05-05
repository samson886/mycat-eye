package io.mycat.eye.web.mapper;

import io.mycat.eye.web.bean.MycatSqlDetail;
import io.mycat.eye.web.bean.MycatSqlDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MycatSqlDetailMapper {
    long countByExample(MycatSqlDetailExample example);

    int deleteByExample(MycatSqlDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MycatSqlDetail record);

    int insertSelective(MycatSqlDetail record);

    List<MycatSqlDetail> selectByExample(MycatSqlDetailExample example);

    MycatSqlDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MycatSqlDetail record, @Param("example") MycatSqlDetailExample example);

    int updateByExample(@Param("record") MycatSqlDetail record, @Param("example") MycatSqlDetailExample example);

    int updateByPrimaryKeySelective(MycatSqlDetail record);

    int updateByPrimaryKey(MycatSqlDetail record);
}