package io.mycat.eye.web.mapper;

import io.mycat.eye.web.bean.MycatBackend;
import io.mycat.eye.web.bean.MycatBackendExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MycatBackendMapper {
    long countByExample(MycatBackendExample example);

    int deleteByExample(MycatBackendExample example);

    int insert(MycatBackend record);

    int insertSelective(MycatBackend record);

    List<MycatBackend> selectByExample(MycatBackendExample example);

    int updateByExampleSelective(@Param("record") MycatBackend record, @Param("example") MycatBackendExample example);

    int updateByExample(@Param("record") MycatBackend record, @Param("example") MycatBackendExample example);
}