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

    int deleteByPrimaryKey(Long sqlId);

    int insert(MycatSqlExecute record);

    int insertSelective(MycatSqlExecute record);

    List<MycatSqlExecute> selectByExample(MycatSqlExecuteExample example);

    MycatSqlExecute selectByPrimaryKey(Long sqlId);

    int updateByExampleSelective(@Param("record") MycatSqlExecute record, @Param("example") MycatSqlExecuteExample example);

    int updateByExample(@Param("record") MycatSqlExecute record, @Param("example") MycatSqlExecuteExample example);

    int updateByPrimaryKeySelective(MycatSqlExecute record);

    int updateByPrimaryKey(MycatSqlExecute record);
}