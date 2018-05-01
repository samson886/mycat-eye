package io.mycat.eye.web.mapper;

import io.mycat.eye.web.bean.MycatConnection;
import io.mycat.eye.web.bean.MycatConnectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MycatConnectionMapper {
    long countByExample(MycatConnectionExample example);

    int deleteByExample(MycatConnectionExample example);

    int insert(MycatConnection record);

    int insertSelective(MycatConnection record);

    List<MycatConnection> selectByExample(MycatConnectionExample example);

    int updateByExampleSelective(@Param("record") MycatConnection record, @Param("example") MycatConnectionExample example);

    int updateByExample(@Param("record") MycatConnection record, @Param("example") MycatConnectionExample example);
}