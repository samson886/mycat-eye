package io.mycat.eye.agent.mapper;

import io.mycat.eye.agent.bean.MysqlWeakPassword;
import io.mycat.eye.agent.bean.MysqlWeakPasswordExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MysqlWeakPasswordMapper {
    int countByExample(MysqlWeakPasswordExample example);

    int deleteByExample(MysqlWeakPasswordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MysqlWeakPassword record);

    int insertSelective(MysqlWeakPassword record);

    List<MysqlWeakPassword> selectByExample(MysqlWeakPasswordExample example);

    MysqlWeakPassword selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MysqlWeakPassword record, @Param("example") MysqlWeakPasswordExample example);

    int updateByExample(@Param("record") MysqlWeakPassword record, @Param("example") MysqlWeakPasswordExample example);

    int updateByPrimaryKeySelective(MysqlWeakPassword record);

    int updateByPrimaryKey(MysqlWeakPassword record);
}