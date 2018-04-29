package io.mycat.eye.agent.mapper;

import io.mycat.eye.agent.bean.MycatSqlDetail;
import io.mycat.eye.agent.bean.MycatSqlDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MycatSqlDetailMapper {
    long countByExample(MycatSqlDetailExample example);

    int deleteByExample(MycatSqlDetailExample example);

    int insert(MycatSqlDetail record);

    int insertSelective(MycatSqlDetail record);

    List<MycatSqlDetail> selectByExample(MycatSqlDetailExample example);

    int updateByExampleSelective(@Param("record") MycatSqlDetail record, @Param("example") MycatSqlDetailExample example);

    int updateByExample(@Param("record") MycatSqlDetail record, @Param("example") MycatSqlDetailExample example);
}