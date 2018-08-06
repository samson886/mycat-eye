package io.mycat.eye.web.controller;

import com.alibaba.fastjson.JSON;
import io.mycat.eye.web.bean.Constant;
import io.mycat.eye.web.dto.RestResponse;
import io.mycat.eye.web.service.ZkConfigService;
import io.mycat.eye.web.util.AgentUrlUtil;
import io.mycat.eye.web.util.RestTemplateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * cjw qq:294712221
 */
@RestController
@RequestMapping("/mycat/zk")
public class MycatZkController {
    Logger logger = LoggerFactory.getLogger(MycatZkController.class);

    @Autowired
    RestTemplateUtils restTemplateUtils;
    @Autowired
    AgentUrlUtil agentUrlUtil;

    /**
     * http://127.0.0.1:7001/mycat/zk/mycat-cluster-1/server/cluster/all
     *
     * @param cluster
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{cluster}/server/cluster/all", method = {RequestMethod.GET})
    public RestResponse<Object> getClusterAll(@PathVariable String cluster) throws Exception {
        String response = restTemplateUtils.getWithOneParam(agentUrlUtil.getZkClusterAll(), "cluster", cluster);
        return returnRestResponse(response);
    }

    /**
     * http://127.0.0.1:7001/mycat/zk/mycat-cluster-1/server/cluster/mycat_fz_01
     *
     * @param cluster
     * @param clusterName
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{cluster}/server/cluster/{clusterName}", method = {RequestMethod.GET})
    public RestResponse<Object> getCluster(@PathVariable String cluster, @PathVariable String clusterName) throws Exception {
        String response = restTemplateUtils.getWithTwoParam(agentUrlUtil.getZkCluster(), "cluster", cluster, "clusterName", clusterName);
        return returnRestResponse(response);
    }

    /**
     * http://127.0.0.1:7001/mycat/zk/mycat-cluster-1/server/cluster/mycat_fz_01
     * {
     * "property": [{
     * "value": "1",
     * "name": "useSqlStat"
     * }, {
     * "value": "0",
     * "name": "useGlobleTableCheck"
     * }, {
     * "value": "druidparser",
     * "name": "defaultSqlParser"
     * }, {
     * "value": "2",
     * "name": "sequnceHandlerType"
     * }, {
     * "value": "0",
     * "name": "processorBufferPoolType"
     * }, {
     * "value": "0",
     * "name": "handleDistributedTransactions"
     * }, {
     * "value": "1",
     * "name": "useOffHeapForMerge"
     * }, {
     * "value": "1m",
     * "name": "memoryPageSize"
     * }, {
     * "value": "1k",
     * "name": "spillsFileBufferSize"
     * }, {
     * "value": "0",
     * "name": "useStreamOutput"
     * }, {
     * "value": "389m",
     * "name": "systemReserveMemorySize"
     * }]
     * }
     *
     * @param cluster
     * @param body
     * @param clusterName
     * @return
     */
    @RequestMapping(value = "/{cluster}/server/cluster/{clusterName}", method = {RequestMethod.POST})
    public RestResponse<Object> updateCluster(@PathVariable String cluster, @RequestBody String body, @PathVariable String clusterName) {
        String response = restTemplateUtils.postBodyWithTwoUriParams(agentUrlUtil.updateZkCluster(), "cluster", cluster, "clusterName", clusterName, body);
        return returnRestResponse(response);
    }

    /**
     * http://127.0.0.1:7001/mycat/zk/mycat-cluster-1/server/default
     *
     * @param cluster
     * @return
     */
    @RequestMapping(value = "/{cluster}/server/default", method = {RequestMethod.GET})
    public RestResponse<Object> getDefault(@PathVariable String cluster) {
        String response = restTemplateUtils.getWithOneParam(agentUrlUtil.getDefault(), "cluster", cluster);
        return returnRestResponse(response);
    }

    /**
     * http://127.0.0.1:7001/mycat/zk/mycat-cluster-1/server/default
     * {
     * "property": [{
     * "value": "1",
     * "name": "useSqlStat"
     * }, {
     * "value": "0",
     * "name": "useGlobleTableCheck"
     * }, {
     * "value": "druidparser",
     * "name": "defaultSqlParser"
     * }, {
     * "value": "2",
     * "name": "sequnceHandlerType"
     * }, {
     * "value": "0",
     * "name": "processorBufferPoolType"
     * }, {
     * "value": "0",
     * "name": "handleDistributedTransactions"
     * }, {
     * "value": "1",
     * "name": "useOffHeapForMerge"
     * }, {
     * "value": "1m",
     * "name": "memoryPageSize"
     * }, {
     * "value": "1k",
     * "name": "spillsFileBufferSize"
     * }, {
     * "value": "0",
     * "name": "useStreamOutput"
     * }, {
     * "value": "384m",
     * "name": "systemReserveMemorySize"
     * }]
     * }
     *
     * @param cluster
     * @param body
     * @return
     */
    @RequestMapping(value = "/{cluster}/server/default", method = {RequestMethod.POST})
    public RestResponse<Object> updateDefault(@PathVariable String cluster, @RequestBody String body) {
        String response = restTemplateUtils.postBodyWithOneUriParams(agentUrlUtil.updateDefault(), "cluster", cluster, body);
        return returnRestResponse(response);
    }

    /**
     * http://127.0.0.1:7001/mycat/zk/mycat-cluster-1/server/user
     *
     * @param cluster
     * @return
     */
    @RequestMapping(value = "/{cluster}/server/user", method = {RequestMethod.GET})
    public RestResponse<Object> getUser(@PathVariable String cluster) {
        String response = restTemplateUtils.getWithOneParam(agentUrlUtil.getUser(), "cluster", cluster);
        return returnRestResponse(response);
    }

    /**
     * http://127.0.0.1:7001/mycat/zk/mycat-cluster-1/server/user
     * [{
     * "name": "root",
     * "property": [{
     * "value": "",
     * "name": "password"
     * }, {
     * "value": "TESTDB",
     * "name": "schemas"
     * }]
     * }, {
     * "name": "user",
     * "property": [{
     * "value": "",
     * "name": "password"
     * }, {
     * "value": "TESTDB",
     * "name": "schemas"
     * }, {
     * "value": "true",
     * "name": "readOnly"
     * }]
     * }]
     *
     * @param cluster
     * @param body
     * @return
     */
    @RequestMapping(value = "/{cluster}/server/user", method = {RequestMethod.POST})
    public RestResponse<Object> updateUser(@PathVariable String cluster, @RequestBody String body) {
        String response = restTemplateUtils.postBodyWithOneUriParams(agentUrlUtil.updateUser(), "cluster", cluster, body);
        return returnRestResponse(response);
    }

    /**
     * http://127.0.0.1:7001/mycat/zk/mycat-cluster-1/server/charset
     *
     * @param cluster
     * @return
     */
    @RequestMapping(value = "/{cluster}/server/charset", method = {RequestMethod.GET})
    public RestResponse<Object> getCharset(@PathVariable String cluster) {
        String response = restTemplateUtils.getWithOneParam(agentUrlUtil.getCharset(), "cluster", cluster);
        return returnRestResponse(response);
    }

    /**
     * http://127.0.0.1:7001/mycat/zk/mycat-cluster-1/server/charset
     *
     * @param cluster
     * @return
     */
    @RequestMapping(value = "/{cluster}/server/charset", method = {RequestMethod.POST})
    @CrossOrigin(origins = "*")
    public RestResponse<Object> updateCharset(@PathVariable String cluster, @RequestBody String body) {
        String response = restTemplateUtils.postBodyWithOneUriParams(agentUrlUtil.getCharset(), "cluster", cluster, body);
        return returnRestResponse(response);

    }
    // schema
    /**
     http://127.0.0.1:7001/mycat/zk/mycat-cluster-1/schema/schema
     * @param cluster
     * @return
     */
    @RequestMapping(value = "/{cluster}/schema/schema", method = {RequestMethod.GET})
    @CrossOrigin(origins = "*")
    public RestResponse<Object> getSchema(@PathVariable String cluster,Integer forceFromZk) {
        String response = null;
        response = fetchData(cluster, forceFromZk, agentUrlUtil.getSchema());
        RestResponse<Object> restResponse = returnRestResponse(response);
        if(restResponse.getCode() != Constant.REST_FAIL_CODE){
            ZkConfigService.putData(cluster, agentUrlUtil.getSchema(), JSON.toJSONString(restResponse.getData()));
        }
        return  restResponse;
    }


    /**
     http://127.0.0.1:7001/mycat/zk/mycat-cluster-1/schema/schema
     * @param cluster
     * @param body
     * @return
     */
    @RequestMapping(value = "/{cluster}/schema/schema", method = {RequestMethod.POST})
    @CrossOrigin(origins = "*")
    public RestResponse<Object> updateSchema(@PathVariable String cluster,  String body ) {
        String response = restTemplateUtils.postBodyWithOneUriParams(agentUrlUtil.getSchema(), "cluster", cluster, body);
        ZkConfigService.putData(cluster, agentUrlUtil.getSchema(), body);
        return returnRestResponse(response);
    }

    @RequestMapping(value = "/{cluster}/schema/updateLocalSchema", method = {RequestMethod.POST})
    @CrossOrigin(origins = "*")
    public RestResponse<Object> updateLocalSchema(@PathVariable String cluster,  String body ) {
        ZkConfigService.putData(cluster, agentUrlUtil.getSchema(), body);
        return RestResponse.buildOKResponse("successful");
    }
//    //dataHost      http://127.0.0.1:7001/mycat/zk/mycat-cluster-1/schema/dataHost

    @RequestMapping(value = "/{cluster}/schema/dataHost", method = {RequestMethod.GET})
    @CrossOrigin(origins = "*")
    public RestResponse<Object> getDataHost(@PathVariable String cluster,Integer forceFromZk) {
        String response = null;
        response = fetchData(cluster, forceFromZk, agentUrlUtil.getDataHost());
        RestResponse<Object> restResponse = returnRestResponse(response);
        if(restResponse.getCode() != Constant.REST_FAIL_CODE){
            ZkConfigService.putData(cluster, agentUrlUtil.getDataHost(), JSON.toJSONString(restResponse.getData()));
        }
        return  restResponse;
    }


    /**
     http://127.0.0.1:7001/mycat/zk/mycat-cluster-1/schema/dataHost
     * @param cluster
     * @param body
     * @return
     */
    @RequestMapping(value = "/{cluster}/schema/dataHost", method = {RequestMethod.POST})
    @CrossOrigin(origins = "*")
    public RestResponse<Object> updateDataHost(@PathVariable String cluster,  String body ) {
        String response = restTemplateUtils.postBodyWithOneUriParams(agentUrlUtil.getDataHost(), "cluster", cluster, body);
        ZkConfigService.putData(cluster, agentUrlUtil.getDataHost(), body);
        return returnRestResponse(response);
    }

    @RequestMapping(value = "/{cluster}/schema/updateLocalDataHost", method = {RequestMethod.POST})
    @CrossOrigin(origins = "*")
    public RestResponse<Object> updateLocalDataHost(@PathVariable String cluster,  String body ) {
        ZkConfigService.putData(cluster, agentUrlUtil.getDataHost(), body);
        return RestResponse.buildOKResponse("successful");
    }
//    //dataNode
//    //dataHost      http://127.0.0.1:7001/mycat/zk/mycat-cluster-1/schema/dataHost

    @RequestMapping(value = "/{cluster}/schema/dataNode", method = {RequestMethod.GET})
    @CrossOrigin(origins = "*")
    public RestResponse<Object> getDataNode(@PathVariable String cluster,Integer forceFromZk) {
        String response = null;
        response = fetchData(cluster, forceFromZk, agentUrlUtil.getDataNode());
        RestResponse<Object> restResponse = returnRestResponse(response);
        if(restResponse.getCode() != Constant.REST_FAIL_CODE){
            ZkConfigService.putData(cluster, agentUrlUtil.getDataNode(), JSON.toJSONString(restResponse.getData()));
        }
        return  restResponse;
    }


    /**
     http://127.0.0.1:7001/mycat/zk/mycat-cluster-1/schema/dataHost
     * @param cluster
     * @param body
     * @return
     */
    @RequestMapping(value = "/{cluster}/schema/dataNode", method = {RequestMethod.POST})
    @CrossOrigin(origins = "*")
    public RestResponse<Object> updateDataNode(@PathVariable String cluster,  String body ) {
        String response = restTemplateUtils.postBodyWithOneUriParams(agentUrlUtil.getDataNode(), "cluster", cluster, body);
        ZkConfigService.putData(cluster, agentUrlUtil.getDataNode(), body);
        return returnRestResponse(response);
    }

    @RequestMapping(value = "/{cluster}/schema/updateLocalDataNode", method = {RequestMethod.POST})
    @CrossOrigin(origins = "*")
    public RestResponse<Object> updateLocalDataNode(@PathVariable String cluster,  String body ) {
        ZkConfigService.putData(cluster, agentUrlUtil.getDataNode(), body);
        return RestResponse.buildOKResponse("successful");
    }

    //从本地 或者远程zk获取配置
    /*
    * @param cluster 集群名称
    * @parma forFromZK 强制从zk集群获取数据
    * @param path 获取这个路径的数据
    * */
    private String fetchData(@PathVariable String cluster, Integer forceFromZk,String path) {
        String response;
        if(forceFromZk != null && forceFromZk == 1) {
            response = restTemplateUtils.getWithOneParam(path, "cluster", cluster);
        } else {
            response = ZkConfigService.getData(cluster, path);
            if (null == response || "null".equals(cluster)){
                response = restTemplateUtils.getWithOneParam(path, "cluster", cluster);
            } else {
                return String.format("{  \"code\": 200,\n" +
                        "  \"message\": \"SUCCESS\",\n" +
                        "  \"data\": %s,   \"timestamp\": 1533439239145 }", response);
            }
        }
        return response;
    }

    private RestResponse<Object> returnRestResponse(String response) {
        if (response.isEmpty()) {
            return RestResponse.buildExceptionResponse(Constant.REST_FAIL_CODE, Constant.REST_FAIL_MESSAGE);
        }

        RestResponse<Object> restResponse = JSON.parseObject(response, RestResponse.class);
        if (restResponse == null) {
            return RestResponse.buildExceptionResponse(Constant.REST_FAIL_CODE, Constant.REST_FAIL_MESSAGE);
        }

        if (restResponse.getCode() != Constant.ZERO) {
            return restResponse;
        }
        return restResponse;
    }

}
