package io.mycat.eye.agent.mapper;

import io.mycat.eye.agent.bean.MysqlCluster;
import io.mycat.eye.agent.bean.MysqlClusterExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MysqlClusterMapper {
    int countByExample(MysqlClusterExample example);

    int deleteByExample(MysqlClusterExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MysqlCluster record);

    int insertSelective(MysqlCluster record);

    List<MysqlCluster> selectByExample(MysqlClusterExample example);

    MysqlCluster selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MysqlCluster record, @Param("example") MysqlClusterExample example);

    int updateByExample(@Param("record") MysqlCluster record, @Param("example") MysqlClusterExample example);

    int updateByPrimaryKeySelective(MysqlCluster record);

    int updateByPrimaryKey(MysqlCluster record);
}