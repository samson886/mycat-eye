package io.mycat.eye.web.controller;

import io.mycat.eye.web.bean.MycatDataNode;
import io.mycat.eye.web.dto.RestResponse;
import io.mycat.eye.web.service.MycatDatanodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xqy on 18/5/1.
 */
@RestController
@RequestMapping("/mycat/datanode")
public class MycatDatanodeController {
    Logger logger = LoggerFactory.getLogger(MycatDatanodeController.class);

    @Autowired
    MycatDatanodeService mycatDatanodeService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity getList(int server_id){
        logger.debug("/mycat/datanode/list: "+server_id);
        RestResponse<Object> response = RestResponse.buildExceptionResponse(200,"successful");
        try{
            List<MycatDataNode> list = mycatDatanodeService.getDataNode(server_id);
            response.setData(list);
            return new ResponseEntity(response, HttpStatus.OK);
        }catch (Exception e){
            response.setCode(500);
            response.setMessage(e.getMessage());
            return new ResponseEntity(response,HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}
