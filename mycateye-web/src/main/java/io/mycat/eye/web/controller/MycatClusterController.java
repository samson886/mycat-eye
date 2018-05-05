package io.mycat.eye.web.controller;

import io.mycat.eye.web.bean.MycatCluster;
import io.mycat.eye.web.bean.MycatClusterExample;
import io.mycat.eye.web.dto.RestResponse;
import io.mycat.eye.web.service.MycatClusterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xqy on 18/5/3.
 */
@RestController
@RequestMapping(value = "/mycat/cluster")
public class MycatClusterController {
    Logger logger = LoggerFactory.getLogger(MycatClusterController.class);

    @Autowired
    MycatClusterService service;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity getList(){
        logger.debug("list");
        RestResponse<Object> response = RestResponse.buildExceptionResponse(200,"successful");
        try{
            MycatClusterExample example = new MycatClusterExample();
            response.setData(service.getList(example));
            return new ResponseEntity(response, HttpStatus.OK);
        }catch (Exception e){
            response.setCode(700);
            response.setMessage(e.getMessage());
            return new ResponseEntity(response,HttpStatus.OK);
        }
    }

    @RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
    public ResponseEntity getCluster(@PathVariable int id){
        RestResponse<Object> response = RestResponse.buildExceptionResponse(200,"successful");
        try{
            response.setData(service.getCluster(id));
            return new ResponseEntity(response, HttpStatus.OK);
        }catch (Exception e){
            response.setCode(700);
            response.setMessage(e.getMessage());
            return new ResponseEntity(response,HttpStatus.OK);
        }
    }

    @RequestMapping(value = "detail", method = RequestMethod.POST)
    public ResponseEntity addCluster(@RequestBody MycatCluster cluster){
        RestResponse<Object> response = RestResponse.buildExceptionResponse(200,"successful");
        try{
            service.addCluster(cluster);
            return new ResponseEntity(response, HttpStatus.OK);
        }catch (Exception e){
            response.setCode(700);
            response.setMessage(e.getMessage());
            return new ResponseEntity(response,HttpStatus.OK);
        }
    }

    @RequestMapping(value = "detail/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateCluster(@PathVariable int id,@RequestBody MycatCluster cluster){
        RestResponse<Object> response = RestResponse.buildExceptionResponse(200,"successful");
        try{
            service.updateCluster(cluster);
            return new ResponseEntity(response, HttpStatus.OK);
        }catch (Exception e){
            response.setCode(700);
            response.setMessage(e.getMessage());
            return new ResponseEntity(response,HttpStatus.OK);
        }
    }

    @RequestMapping(value = "detail/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteCluster(@PathVariable int id){
        RestResponse<Object> response = RestResponse.buildExceptionResponse(200,"successful");
        try{
            service.deleteCluster(id);
            return new ResponseEntity(response, HttpStatus.OK);
        }catch (Exception e){
            response.setCode(700);
            response.setMessage(e.getMessage());
            return new ResponseEntity(response,HttpStatus.OK);
        }
    }
}
