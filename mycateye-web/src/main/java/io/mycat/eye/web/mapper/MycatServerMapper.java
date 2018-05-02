package io.mycat.eye.web.mapper;

import io.mycat.eye.web.bean.MycatServer;
import io.mycat.eye.web.bean.MycatServerExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MycatServerMapper {
    long countByExample(MycatServerExample example);

    int deleteByExample(MycatServerExample example);

    int insert(MycatServer record);

    int insertSelective(MycatServer record);

    List<MycatServer> selectByExample();

    int updateByExampleSelective(@Param("record") MycatServer record, @Param("example") MycatServerExample example);

    int updateByExample(@Param("record") MycatServer record, @Param("example") MycatServerExample example);
}