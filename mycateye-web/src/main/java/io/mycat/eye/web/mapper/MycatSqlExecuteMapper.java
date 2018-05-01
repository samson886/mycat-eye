package io.mycat.eye.web.mapper;

import io.mycat.eye.web.bean.MycatSqlExecute;
import io.mycat.eye.web.bean.MycatSqlExecuteExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MycatSqlExecuteMapper {
    long countByExample(MycatSqlExecuteExample example);

    int deleteByExample(MycatSqlExecuteExample example);

    int insert(MycatSqlExecute record);

    int insertSelective(MycatSqlExecute record);

    List<MycatSqlExecute> selectByExample(MycatSqlExecuteExample example);

    int updateByExampleSelective(@Param("record") MycatSqlExecute record, @Param("example") MycatSqlExecuteExample example);

    int updateByExample(@Param("record") MycatSqlExecute record, @Param("example") MycatSqlExecuteExample example);
}