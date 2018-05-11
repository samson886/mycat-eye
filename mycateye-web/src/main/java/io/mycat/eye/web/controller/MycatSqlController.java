package io.mycat.eye.web.controller;

import io.mycat.eye.web.bean.MycatSqlDetail;
import io.mycat.eye.web.bean.MycatSqlExecute;
import io.mycat.eye.web.bean.MycatSqlSum;
import io.mycat.eye.web.bean.MycatSqlSumExample;
import io.mycat.eye.web.dto.RestResponse;
import io.mycat.eye.web.service.MycatSqlExecuteService;
import io.mycat.eye.web.service.MycatSqlSumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by xqy on 18/5/1.
 */
@RestController
@RequestMapping("/mycat/sql")
public class MycatSqlController {
    Logger logger = LoggerFactory.getLogger(MycatSqlController.class);

    @Autowired
    MycatSqlExecuteService mycatSqlService;

    @Autowired
    MycatSqlSumService mycatSqlSumService;

    @RequestMapping(value = "execute", method = RequestMethod.GET)
    public ResponseEntity getSqlExecute(int server_id, String timeRange){
        logger.debug("sql/execute === server_id:"+server_id+" time_range:"+timeRange);
        RestResponse<Object> response = RestResponse.buildExceptionResponse(200,"successful");
        if(server_id == 0){
            response.setCode(401);
            response.setMessage("节点ID不可为空");
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
        if(timeRange==null){
            response.setCode(401);
            response.setMessage("日期范围不可为空");
            return new ResponseEntity(response,HttpStatus.BAD_REQUEST);
        }
        String[] times = timeRange.split("-");
        if(times.length<=1){
            response.setCode(401);
            response.setMessage("参数错误");
            return new ResponseEntity(response,HttpStatus.BAD_REQUEST);
        }
        String beginTime = times[0].trim().replaceAll("/", "-");
        String endTime = times[1].trim().replaceAll("/", "-");
        try{
            List<MycatSqlExecute> list = mycatSqlService.getExecuteSql(server_id, Timestamp.valueOf(beginTime).getTime(),Timestamp.valueOf(endTime).getTime());
            response.setData(list);
            return new ResponseEntity(response,HttpStatus.OK);
        }catch (Exception e){
            response.setCode(500);
            response.setMessage(e.getMessage());
            return new ResponseEntity(response,HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public ResponseEntity getSqlDetail(int server_id,long sql_id){
        logger.debug("sql/detail === server_id:"+server_id+" sql_id:"+sql_id);
        RestResponse<Object> response = RestResponse.buildExceptionResponse(200,"successful");
        if(sql_id == 0){
            response.setCode(401);
            response.setMessage("参数错误");
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
        try{
            List<MycatSqlDetail> list = mycatSqlService.getSqlDetail(sql_id,server_id);
            response.setData(list);
            return new ResponseEntity(response,HttpStatus.OK);
        }catch (Exception e){
            response.setCode(500);
            response.setMessage(e.getMessage());
            return new ResponseEntity(response,HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    @RequestMapping(value = "sum/user", method = RequestMethod.GET)
    public ResponseEntity getSqlSumUser(int server_id){
        logger.debug("sql/sum/user === server_id:"+server_id);
        RestResponse<Object> response = RestResponse.buildExceptionResponse(200,"successful");

        try{
            MycatSqlSumExample example = new MycatSqlSumExample();
            MycatSqlSumExample.Criteria criteria = example.createCriteria();
            criteria.andServerIdEqualTo(server_id);
            criteria.andCollectTypeEqualTo("1");
            List<MycatSqlSum> list = mycatSqlSumService.getSumList(example);
            response.setData(list);
            return new ResponseEntity(response,HttpStatus.OK);
        }catch (Exception e){
            response.setCode(500);
            response.setMessage(e.getMessage());
            return new ResponseEntity(response,HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    @RequestMapping(value = "sum/table", method = RequestMethod.GET)
    public ResponseEntity getSqlSumTable(int server_id){
        logger.debug("sql/sum/user === server_id:"+server_id);
        RestResponse<Object> response = RestResponse.buildExceptionResponse(200,"successful");

        try{
            MycatSqlSumExample example = new MycatSqlSumExample();
            MycatSqlSumExample.Criteria criteria = example.createCriteria();
            criteria.andServerIdEqualTo(server_id);
            criteria.andCollectTypeEqualTo("2");
            List<MycatSqlSum> list = mycatSqlSumService.getSumList(example);
            response.setData(list);
            return new ResponseEntity(response,HttpStatus.OK);
        }catch (Exception e){
            response.setCode(500);
            response.setMessage(e.getMessage());
            return new ResponseEntity(response,HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}
