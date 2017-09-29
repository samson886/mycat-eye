package io.mycat.eye.web.mapper;

import io.mycat.eye.web.bean.MysqlStatusHistory;
import io.mycat.eye.web.bean.MysqlStatusHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MysqlStatusHistoryMapper {
    int countByExample(MysqlStatusHistoryExample example);

    int deleteByExample(MysqlStatusHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MysqlStatusHistory record);

    int insertSelective(MysqlStatusHistory record);

    List<MysqlStatusHistory> selectByExample(MysqlStatusHistoryExample example);

    MysqlStatusHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MysqlStatusHistory record, @Param("example") MysqlStatusHistoryExample example);

    int updateByExample(@Param("record") MysqlStatusHistory record, @Param("example") MysqlStatusHistoryExample example);

    int updateByPrimaryKeySelective(MysqlStatusHistory record);

    int updateByPrimaryKey(MysqlStatusHistory record);
    
    Long maxByExample(MysqlStatusHistoryExample example);
}