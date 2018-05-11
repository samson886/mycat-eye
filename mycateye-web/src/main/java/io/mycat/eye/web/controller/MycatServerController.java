package io.mycat.eye.web.controller;

import io.mycat.eye.web.bean.MycatBackend;
import io.mycat.eye.web.bean.MycatConnection;
import io.mycat.eye.web.bean.MycatServer;
import io.mycat.eye.web.bean.MycatServerExample;
import io.mycat.eye.web.dto.ChatDataDto;
import io.mycat.eye.web.dto.RestResponse;
import io.mycat.eye.web.service.MycatBackendService;
import io.mycat.eye.web.service.MycatConnectionService;
import io.mycat.eye.web.service.MycatServerService;
import io.mycat.eye.web.service.MycatStatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by xqy on 18/5/1.
 */
@RestController
@RequestMapping("/mycat/server")
public class MycatServerController {
    Logger logger = LoggerFactory.getLogger(MycatServerController.class);

    @Autowired
    MycatServerService mycatServerService;


    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity getServerList(){
        logger.debug("list");
        RestResponse<Object> response = RestResponse.buildExceptionResponse(200,"successful");
        try{
            response.setData(mycatServerService.getMycatServer());
            return new ResponseEntity(response,HttpStatus.OK);
        }catch (Exception e){
            response.setCode(700);
            response.setMessage(e.getMessage());
            return new ResponseEntity(response,HttpStatus.OK);
        }
    }

    // 编辑节点
    @RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
    public ResponseEntity getServer(@PathVariable int id){
        RestResponse<Object> response = RestResponse.buildExceptionResponse(200, "ok");
        try{
            response.setData(mycatServerService.getServer(id));
            return new ResponseEntity(response,HttpStatus.OK);
        }catch (Exception e){
            response.setCode(700);
            response.setMessage(e.getMessage());
            return new ResponseEntity(response,HttpStatus.OK);
        }
    }

    // 新增节点
    @RequestMapping(value = "detail", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity updateServer(@RequestBody MycatServer server){
        RestResponse<Object> response = RestResponse.buildExceptionResponse(200, "ok");
        try{
            long curTime = System.currentTimeMillis();
            server.setCreateTime(curTime);
            server.setLastUpdateTime(curTime);
            mycatServerService.addServer(server);
            return new ResponseEntity(response,HttpStatus.OK);
        }catch (Exception e){
            response.setCode(700);
            response.setMessage(e.getMessage());
            return new ResponseEntity(response,HttpStatus.OK);
        }
    }

    // 编辑节点
    @RequestMapping(value = "detail/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getServer(@PathVariable int id, @RequestBody MycatServer server){
        RestResponse<Object> response = RestResponse.buildExceptionResponse(200, "ok");
        try{
            if(server.getId() == null){
                server.setId(id);
            }
            mycatServerService.updateServer(server);
            return new ResponseEntity(response,HttpStatus.OK);
        }catch (Exception e){
            response.setCode(700);
            response.setMessage(e.getMessage());
            return new ResponseEntity(response,HttpStatus.OK);
        }
    }

    // 删除节点
    @RequestMapping(value = "detail/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteServer(@PathVariable int id){
        RestResponse<Object> response = RestResponse.buildExceptionResponse(200, "ok");
        try{
            mycatServerService.delete(id);
            return new ResponseEntity(response,HttpStatus.OK);
        }catch (Exception e){
            response.setCode(700);
            response.setMessage(e.getMessage());
            return new ResponseEntity(response,HttpStatus.OK);
        }
    }



}
