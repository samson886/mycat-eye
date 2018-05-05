package io.mycat.eye.web.controller;

import io.mycat.eye.web.bean.MycatBackend;
import io.mycat.eye.web.bean.MycatConnection;
import io.mycat.eye.web.dto.ChatDataDto;
import io.mycat.eye.web.dto.RestResponse;
import io.mycat.eye.web.service.MycatBackendService;
import io.mycat.eye.web.service.MycatConnectionService;
import io.mycat.eye.web.service.MycatStatusService;
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
 * Created by xqy on 18/5/3.
 */
@RestController
@RequestMapping("/mycat/status")
public class MycatStatusController {
    Logger logger = LoggerFactory.getLogger(MycatStatusController.class);

    @Autowired
    MycatStatusService mycatStatusService;

    @Autowired
    MycatConnectionService mycatConnectionService;

    @Autowired
    MycatBackendService mycatBackendService;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public ResponseEntity getServerStatus(int server_id, String timeRange){
        logger.debug("status === server_id:"+server_id+" time_range:"+timeRange);
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
        try {
            ChatDataDto dto = mycatStatusService.getServerStatus(server_id, beginTime, endTime);
            response.setData(dto);
            return new ResponseEntity(response,HttpStatus.OK);
        }catch (Exception e){
            response.setCode(500);
            response.setMessage(e.getMessage());
            return new ResponseEntity(response,HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    @RequestMapping(value = "connection", method = RequestMethod.GET)
    public ResponseEntity getMycatConnection(int server_id, String timeRange){
        logger.debug("connection === server_id:"+server_id+" time_range:"+timeRange);
        RestResponse<Object> response = RestResponse.buildExceptionResponse(200,"successful");
        if(server_id == 0){
            response.setCode(401);
            response.setMessage("节点ID不可为空");
            return new ResponseEntity(response,HttpStatus.BAD_REQUEST);
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
            List<MycatConnection> list = mycatConnectionService.getConnection(server_id, Timestamp.valueOf(beginTime).getTime(),Timestamp.valueOf(endTime).getTime());
            response.setData(list);
            return new ResponseEntity(response,HttpStatus.OK);
        }catch (Exception e){
            response.setCode(500);
            response.setMessage(e.getMessage());
            return new ResponseEntity(response, HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    @RequestMapping(value = "backend", method = RequestMethod.GET)
    public ResponseEntity getMycatBackend(int server_id, String timeRange){
        logger.debug("backend === server_id:"+server_id+" time_range:"+timeRange);
        RestResponse<Object> response = RestResponse.buildExceptionResponse(200,"successful");
        if(server_id == 0){
            response.setCode(401);
            response.setMessage("节点ID不可为空");
            return new ResponseEntity(response,HttpStatus.BAD_REQUEST);
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
            List<MycatBackend> list = mycatBackendService.getBackend(server_id,Timestamp.valueOf(beginTime).getTime(),Timestamp.valueOf(endTime).getTime());
            response.setData(list);
            return new ResponseEntity(response,HttpStatus.OK);
        }catch (Exception e){
            response.setCode(500);
            response.setMessage(e.getMessage());
            return new ResponseEntity(response,HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}
