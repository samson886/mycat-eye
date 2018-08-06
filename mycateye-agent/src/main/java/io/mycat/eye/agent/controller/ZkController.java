package io.mycat.eye.agent.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.mycat.eye.agent.bean.Constant;
import io.mycat.eye.agent.dto.RestResponse;
import io.mycat.eye.agent.service.zkConfig.ZkConfigService;
import io.mycat.eye.agent.service.zkConfig.ZkConfigServiceFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * cjw qq:294712221
 */
@RestController
@RequestMapping("/zk")
public class ZkController {
    ZkConfigService userJson;
    ZkConfigService indexToCharsetPropertiesJson;
    ZkConfigService defaultJson;
    ZkConfigService clusterJson;

    ZkConfigService schemaJson;
    ZkConfigService dataNodeJson;
    ZkConfigService dataHostJson;

    public ZkController(ZkConfigServiceFactory zkConfigServiceFactory) {
        this.userJson = zkConfigServiceFactory.create("user", "server/user");
        this.indexToCharsetPropertiesJson = zkConfigServiceFactory
                .create("index_to_charset_properties", "server/index_to_charset.properties");
        this.defaultJson = zkConfigServiceFactory.create("default", "server/default");
        this.clusterJson = zkConfigServiceFactory.create("cluster", "server/cluster");
        this.schemaJson = zkConfigServiceFactory.create("schema", "schema/schema");
        this.dataNodeJson = zkConfigServiceFactory.create("dataNode", "schema/dataNode");
        this.dataHostJson = zkConfigServiceFactory.create("dataHost", "schema/dataHost");
    }

    /**
     * http://127.0.0.1:7003/agent/zk/mycat-cluster-1/server/cluster/all
     *
     * {"code":200,"message":"SUCCESS","data":["mycat_fz_01"],"timestamp":1531316353239}
     *
     * @param cluster
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{cluster}/server/cluster/all", method = {RequestMethod.GET})
    @CrossOrigin(origins = "*")
    public RestResponse<Object> getClusterAll(@PathVariable String cluster) throws Exception {
        RestResponse<Object> restResponse = new RestResponse<>();
        try {
            List<String> children = clusterJson.getChildrenInCluster(cluster);
            restResponse.setData(children);
            restResponse.setCode(Constant.SUCCESS_CODE);
            restResponse.setMessage(Constant.SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            restResponse.setCode(Constant.FAIL_CODE);
            restResponse.setMessage(Constant.FAIL_MESSAGE);
        }
        return restResponse;
    }

    /**
     * http://127.0.0.1:7003/agent/zk/mycat-cluster-1/server/cluster/mycat_fz_01
     *
     * {
     "code": 200,
     "message": "SUCCESS",
     "data": "{\"property\":[{\"value\":\"1\",\"name\":\"useSqlStat\"},{\"value\":\"0\",\"name\":\"useGlobleTableCheck\"},{\"value\":\"druidparser\",\"name\":\"defaultSqlParser\"},{\"value\":\"2\",\"name\":\"sequnceHandlerType\"},{\"value\":\"0\",\"name\":\"processorBufferPoolType\"},{\"value\":\"0\",\"name\":\"handleDistributedTransactions\"},{\"value\":\"1\",\"name\":\"useOffHeapForMerge\"},{\"value\":\"1m\",\"name\":\"memoryPageSize\"},{\"value\":\"1k\",\"name\":\"spillsFileBufferSize\"},{\"value\":\"0\",\"name\":\"useStreamOutput\"},{\"value\":\"389m\",\"name\":\"systemReserveMemorySize\"}]}",
     "timestamp": 1531316847169
     }
     * @param cluster
     * @param clusterName
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{cluster}/server/cluster/{clusterName}", method = {RequestMethod.GET})
    @CrossOrigin(origins = "*")
    public RestResponse<Object> getCluster(@PathVariable String cluster, @PathVariable String clusterName) throws Exception {
        RestResponse<Object> restResponse = new RestResponse<>();
        restResponse.setCode(Constant.FAIL_CODE);
        restResponse.setMessage(Constant.FAIL_MESSAGE);
        final String finalClusterName = clusterName;
        try {
            Optional<String> children = clusterJson.getChildrenInClusterWithPath(cluster, finalClusterName::equals);
            if (children.isPresent()) {
                String data = clusterJson.getData(children.get());
                restResponse.setData(data);
                restResponse.setCode(Constant.SUCCESS_CODE);
                restResponse.setMessage(Constant.SUCCESS_MESSAGE);
                return restResponse;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return restResponse;
    }

    /**
     http://127.0.0.1:7003/agent/zk/mycat-cluster-1/server/cluster/mycat_fz_01
     {
     "property": [{
     "value": "1",
     "name": "useSqlStat"
     }, {
     "value": "0",
     "name": "useGlobleTableCheck"
     }, {
     "value": "druidparser",
     "name": "defaultSqlParser"
     }, {
     "value": "2",
     "name": "sequnceHandlerType"
     }, {
     "value": "0",
     "name": "processorBufferPoolType"
     }, {
     "value": "0",
     "name": "handleDistributedTransactions"
     }, {
     "value": "1",
     "name": "useOffHeapForMerge"
     }, {
     "value": "1m",
     "name": "memoryPageSize"
     }, {
     "value": "1k",
     "name": "spillsFileBufferSize"
     }, {
     "value": "0",
     "name": "useStreamOutput"
     }, {
     "value": "389m",
     "name": "systemReserveMemorySize"
     }]
     }

     *
     * @param cluster
     * @param body
     * @param clusterName
     * @return
     */
    @RequestMapping(value = "/{cluster}/server/cluster/{clusterName}", method = {RequestMethod.POST})
    @CrossOrigin(origins = "*")
    public RestResponse<String> updateCluster(@PathVariable String cluster, @RequestBody String body, @PathVariable String clusterName) {
        RestResponse<String> restResponse = new RestResponse<>();
        restResponse.setMessage(Constant.FAIL_MESSAGE);
        restResponse.setCode(Constant.FAIL_CODE);
        JSONObject jsonObject = JSON.parseObject(body);
        //todo check
        final String finalClusterName = clusterName.trim();
        try {
            Optional<String> path = clusterJson.getChildrenInClusterWithPath(cluster, finalClusterName::equals);
            if (path.isPresent()) {
                clusterJson.setData(path.get(),jsonObject.toJSONString());
                restResponse.setCode(Constant.SUCCESS_CODE);
                restResponse.setMessage(Constant.SUCCESS_MESSAGE);
                return restResponse;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return restResponse;
    }

    /**
     http://127.0.0.1:7003/agent/zk/mycat-cluster-1/server/default
     {
     "code": 200,
     "message": "SUCCESS",
     "data": "{\"property\":[{\"value\":\"1\",\"name\":\"useSqlStat\"},{\"value\":\"0\",\"name\":\"useGlobleTableCheck\"},{\"value\":\"druidparser\",\"name\":\"defaultSqlParser\"},{\"value\":\"2\",\"name\":\"sequnceHandlerType\"},{\"value\":\"0\",\"name\":\"processorBufferPoolType\"},{\"value\":\"0\",\"name\":\"handleDistributedTransactions\"},{\"value\":\"1\",\"name\":\"useOffHeapForMerge\"},{\"value\":\"1m\",\"name\":\"memoryPageSize\"},{\"value\":\"1k\",\"name\":\"spillsFileBufferSize\"},{\"value\":\"0\",\"name\":\"useStreamOutput\"},{\"value\":\"384m\",\"name\":\"systemReserveMemorySize\"}]}",
     "timestamp": 1531317511346
     }
     * @param cluster
     * @return
     */
    @RequestMapping(value = "/{cluster}/server/default", method = {RequestMethod.GET})
    @CrossOrigin(origins = "*")
    public RestResponse<String> getDefault(@PathVariable String cluster) {
        return query(defaultJson, cluster);
    }

    /**
     http://127.0.0.1:7003/agent/zk/mycat-cluster-1/server/default
     {
     "property": [{
     "value": "1",
     "name": "useSqlStat"
     }, {
     "value": "0",
     "name": "useGlobleTableCheck"
     }, {
     "value": "druidparser",
     "name": "defaultSqlParser"
     }, {
     "value": "2",
     "name": "sequnceHandlerType"
     }, {
     "value": "0",
     "name": "processorBufferPoolType"
     }, {
     "value": "0",
     "name": "handleDistributedTransactions"
     }, {
     "value": "1",
     "name": "useOffHeapForMerge"
     }, {
     "value": "1m",
     "name": "memoryPageSize"
     }, {
     "value": "1k",
     "name": "spillsFileBufferSize"
     }, {
     "value": "0",
     "name": "useStreamOutput"
     }, {
     "value": "384m",
     "name": "systemReserveMemorySize"
     }]
     }
     * @param cluster
     * @param body
     * @return
     */
    @RequestMapping(value = "/{cluster}/server/default", method = {RequestMethod.POST})
    @CrossOrigin(origins = "*")
    public RestResponse<String> updateDefault(@PathVariable String cluster, @RequestBody String body) {
        JSONObject jsonObject = JSON.parseObject(body);
        //todo check
        return update(defaultJson, cluster, jsonObject);
    }

    /**
     http://127.0.0.1:7003/agent/zk/mycat-cluster-1/server/user
     {
     "code": 200,
     "message": "SUCCESS",
     "data": "[{\"name\":\"root\",\"property\":[{\"value\":\"\",\"name\":\"password\"},{\"value\":\"TESTDB\",\"name\":\"schemas\"}]},{\"name\":\"user\",\"property\":[{\"value\":\"\",\"name\":\"password\"},{\"value\":\"TESTDB\",\"name\":\"schemas\"},{\"value\":\"true\",\"name\":\"readOnly\"}]}]",
     "timestamp": 1531317729672
     }
     * @param cluster
     * @return
     */
    @RequestMapping(value = "/{cluster}/server/user", method = {RequestMethod.GET})
    @CrossOrigin(origins = "*")
    public RestResponse<String> getUser(@PathVariable String cluster) {
        return query(userJson, cluster);
    }
    /**
     http://127.0.0.1:7003/agent/zk/mycat-cluster-1/server/user
     [{
     "name": "root",
     "property": [{
     "value": "",
     "name": "password"
     }, {
     "value": "TESTDB",
     "name": "schemas"
     }]
     }, {
     "name": "user",
     "property": [{
     "value": "",
     "name": "password"
     }, {
     "value": "TESTDB",
     "name": "schemas"
     }, {
     "value": "true",
     "name": "readOnly"
     }]
     }]
     * @param cluster
     * @return
     */
    @RequestMapping(value = "/{cluster}/server/user", method = {RequestMethod.POST})
    @CrossOrigin(origins = "*")
    public RestResponse<String> updateUser(@PathVariable String cluster, @RequestBody String body) {
        JSON jsonObject = JSON.parseArray(body);//这里接收的是json数组
        //todo check
        return update(userJson, cluster, jsonObject);
    }
    /**
     http://127.0.0.1:7003/agent/zk/mycat-cluster-1/server/charset
     * @param cluster
     * @return
     */
    @RequestMapping(value = "/{cluster}/server/charset", method = {RequestMethod.GET})
    @CrossOrigin(origins = "*")
    public RestResponse<String> getCharset(@PathVariable String cluster) {
        return query(indexToCharsetPropertiesJson, cluster);
    }
    /**
     http://127.0.0.1:7003/agent/zk/mycat-cluster-1/server/charset
     * @param cluster
     * @return
     */
    @RequestMapping(value = "/{cluster}/server/charset", method = {RequestMethod.POST})
    @CrossOrigin(origins = "*")
    public RestResponse<String> updateCharset(@PathVariable String cluster, @RequestBody String body) {
        RestResponse<String> restResponse = new RestResponse<>();
        restResponse.setCode(Constant.FAIL_CODE);
        restResponse.setMessage(Constant.FAIL_MESSAGE);
        try {
            userJson.updateAsString(cluster, body);//字符串
            //todo check
            restResponse.setCode(Constant.SUCCESS_CODE);
            restResponse.setMessage(Constant.SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return restResponse;
    }
// schema
    /**
     http://127.0.0.1:7003/agent/zk/mycat-cluster-1/schema/schema
     * @param cluster
     * @return
     */
    @RequestMapping(value = "/{cluster}/schema/schema", method = {RequestMethod.GET})
    @CrossOrigin(origins = "*")
    public RestResponse<String> getSchema(@PathVariable String cluster) {
        return query(this.schemaJson, cluster);
    }
    /**
     http://127.0.0.1:7003/agent/zk/mycat-cluster-1/schema/schema
     * @param cluster
     * @return
     */
    @RequestMapping(value = "/{cluster}/schema/schema", method = {RequestMethod.POST})
    @CrossOrigin(origins = "*")
    public RestResponse<String> updateSchema(@PathVariable String cluster, @RequestBody String body) {
        return update(this.schemaJson, cluster, body);
    }
    //dataHost
    /**
     http://127.0.0.1:7003/agent/zk/mycat-cluster-1/schema/dataHost
     * @param cluster
     * @return
     */
    @RequestMapping(value = "/{cluster}/schema/dataHost", method = {RequestMethod.GET})
    @CrossOrigin(origins = "*")
    public RestResponse<String> getDataHost(@PathVariable String cluster) {
        return query(dataHostJson, cluster);
    }
    /**
     http://127.0.0.1:7003/agent/zk/mycat-cluster-1/schema/dataHost
     * @param cluster
     * @return
     */
    @RequestMapping(value = "/{cluster}/schema/dataHost", method = {RequestMethod.POST})
    @CrossOrigin(origins = "*")
    public RestResponse<String> updateDataHost(@PathVariable String cluster, @RequestBody String body) {

        return update(this.dataHostJson, cluster, body);
    }
    //dataNode
    /**
     http://127.0.0.1:7003/agent/zk/mycat-cluster-1/schema/dataNode
     * @param cluster
     * @return
     */
    @RequestMapping(value = "/{cluster}/schema/dataNode", method = {RequestMethod.GET})
    @CrossOrigin(origins = "*")
    public RestResponse<String> getDataNode(@PathVariable String cluster) {
        return query(this.dataNodeJson, cluster);
    }
    /**
     http://127.0.0.1:7003/agent/zk/mycat-cluster-1/schema/dataNode
     * @param cluster
     * @return
     */
    @RequestMapping(value = "/{cluster}/schema/dataNode", method = {RequestMethod.POST})
    @CrossOrigin(origins = "*")
    public RestResponse<String> updateDataNode(@PathVariable String cluster, @RequestBody String body) {

        return update(this.dataNodeJson, cluster, body);
    }



    private RestResponse<String> query(ZkConfigService json, String cluster) {
        RestResponse<String> restResponse = new RestResponse<>();
        try {
            restResponse.setData(json.getAsString(cluster));
            restResponse.setCode(Constant.SUCCESS_CODE);
            restResponse.setMessage(Constant.SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();/**/
            restResponse.setCode(Constant.FAIL_CODE);
            restResponse.setMessage(Constant.FAIL_MESSAGE);
        }
        return restResponse;
    }

    private RestResponse<String> update(ZkConfigService userJson, String cluster, JSON jsonObject) {
        RestResponse<String> restResponse = new RestResponse<>();
        try {
            userJson.updateAsJson(cluster, jsonObject);
            restResponse.setCode(Constant.SUCCESS_CODE);
            restResponse.setMessage(Constant.SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            restResponse.setCode(Constant.FAIL_CODE);
            restResponse.setMessage(Constant.FAIL_MESSAGE);
        }
        return restResponse;
    }
    private RestResponse<String> update(ZkConfigService userJson, String cluster, String body) {
        RestResponse<String> restResponse = new RestResponse<>();
        try {
            userJson.updateAsString(cluster, body);
            restResponse.setCode(Constant.SUCCESS_CODE);
            restResponse.setMessage(Constant.SUCCESS_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            restResponse.setCode(Constant.FAIL_CODE);
            restResponse.setMessage(Constant.FAIL_MESSAGE);
        }
        return restResponse;
    }
}
