package io.mycat.eye.web.mapper;

import io.mycat.eye.web.bean.MycatServerStatus;
import io.mycat.eye.web.bean.MycatServerStatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MycatServerStatusMapper {
    long countByExample(MycatServerStatusExample example);

    int deleteByExample(MycatServerStatusExample example);

    int insert(MycatServerStatus record);

    int insertSelective(MycatServerStatus record);

    List<MycatServerStatus> selectByExample(MycatServerStatusExample example);

    int updateByExampleSelective(@Param("record") MycatServerStatus record, @Param("example") MycatServerStatusExample example);

    int updateByExample(@Param("record") MycatServerStatus record, @Param("example") MycatServerStatusExample example);
}