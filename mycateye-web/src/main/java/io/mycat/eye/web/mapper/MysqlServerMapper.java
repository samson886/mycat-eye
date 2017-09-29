package io.mycat.eye.web.mapper;

import io.mycat.eye.web.bean.MysqlServer;
import io.mycat.eye.web.bean.MysqlServerExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MysqlServerMapper {
    int countByExample(MysqlServerExample example);

    int deleteByExample(MysqlServerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MysqlServer record);

    int insertSelective(MysqlServer record);

    List<MysqlServer> selectByExample(MysqlServerExample example);

    MysqlServer selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MysqlServer record, @Param("example") MysqlServerExample example);

    int updateByExample(@Param("record") MysqlServer record, @Param("example") MysqlServerExample example);

    int updateByPrimaryKeySelective(MysqlServer record);

    int updateByPrimaryKey(MysqlServer record);
}