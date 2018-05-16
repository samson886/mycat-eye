package io.mycat.eye.web.controller;

import io.mycat.eye.web.bean.MycatClusterExample;
import io.mycat.eye.web.bean.MysqlClusterExample;
import io.mycat.eye.web.dto.RestResponse;
import io.mycat.eye.web.service.MysqlClusterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xqy on 18/5/14.
 */
@RestController
@RequestMapping("/mysql/cluster")
public class MysqlClusterController {
    Logger logger = LoggerFactory.getLogger(MysqlClusterController.class);

    @Autowired
    MysqlClusterService service;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public ResponseEntity getAll(){
        logger.debug("list");
        RestResponse<Object> response = RestResponse.buildExceptionResponse(200,"successful");
        try{
            MysqlClusterExample example = new MysqlClusterExample();
            response.setData(service.getAll(example));
            return new ResponseEntity(response, HttpStatus.OK);
        }catch (Exception e){
            response.setCode(700);
            response.setMessage(e.getMessage());
            return new ResponseEntity(response,HttpStatus.OK);
        }
    }
}
