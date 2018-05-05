package io.mycat.eye.web.service;

import io.mycat.eye.web.mapper.MycatSqlHighMapper;
import io.mycat.eye.web.mapper.MycatSqlMapper;
import io.mycat.eye.web.mapper.MycatSqlSlowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xqy on 18/5/4.
 */
@Service
public class MycatSqlService {

    @Autowired
    MycatSqlMapper sqlMapper;

    @Autowired
    MycatSqlHighMapper sqlHighMapper;

    @Autowired
    MycatSqlSlowMapper sqlSlowMapper;
}
