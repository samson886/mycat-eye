package io.mycat.eye.web.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.mycat.eye.web.bean.MysqlServer;
import io.mycat.eye.web.dto.RestResponse;
import io.mycat.eye.web.service.MysqlServerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**   
 * @ClassName:  MycatClusterSettingController
 * @Description:  集群配置
 * @author: zwy
 *
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
@RestController
public class MycatClusterSettingController extends  AbstractController{
	@Autowired
	private MysqlServerService mysqlServerService;
	Logger logger = LoggerFactory.getLogger(MycatClusterSettingController.class);
    static String schemaListStr = "[{\"name\":\"TESTDB\",\"checkSQLschema\":false,\"sqlMaxLimit\":100,\"table\":[{\"name\":\"travelrecord\",\"dataNode\":\"dn1,dn2,dn3\",\"rule\":\"auto-sharding-long\"},{\"name\":\"company\",\"dataNode\":\"dn1,dn2,dn3\",\"primaryKey\":\"ID\",\"type\":\"global\"},{\"name\":\"goods\",\"dataNode\":\"dn1,dn2\",\"primaryKey\":\"ID\",\"type\":\"global\"},{\"name\":\"hotnews\",\"dataNode\":\"dn1,dn2,dn3\",\"rule\":\"mod-long\",\"primaryKey\":\"ID\",\"autoIncrement\":true},{\"name\":\"employee\",\"dataNode\":\"dn1,dn2\",\"rule\":\"sharding-by-intfile\",\"primaryKey\":\"ID\"},{\"name\":\"customer\",\"dataNode\":\"dn1,dn2\",\"rule\":\"sharding-by-intfile\",\"primaryKey\":\"ID\",\"childTable\":[{\"name\":\"orders\",\"joinKey\":\"customer_id\",\"parentKey\":\"id\",\"primaryKey\":\"ID\",\"childTable\":[{\"name\":\"order_items\",\"joinKey\":\"order_id\",\"parentKey\":\"id\",\"childTable\":[{\"name\":\"orders\",\"joinKey\":\"customer_id\",\"parentKey\":\"id\",\"primaryKey\":\"ID\",\"childTable\":[{\"name\":\"order_items\",\"joinKey\":\"order_id\",\"parentKey\":\"id\",\"childTable\":[]}]},{\"name\":\"customer_addr\",\"joinKey\":\"customer_id\",\"parentKey\":\"id\",\"primaryKey\":\"ID\"}]}]},{\"name\":\"customer_addr\",\"joinKey\":\"customer_id\",\"parentKey\":\"id\",\"primaryKey\":\"ID\"}]}]}]";

    static String  dataNodeListStr = "[\n" +
            "  {\n" +
            "    \"name\": \"dn1\",\n" +
            "    \"dataHost\": \"localhost1\",\n" +
            "    \"database\": \"db1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"dn2\",\n" +
            "    \"dataHost\": \"localhost1\",\n" +
            "    \"database\": \"db2\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"dn3\",\n" +
            "    \"dataHost\": \"localhost1\",\n" +
            "    \"database\": \"db3\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"dn4\",\n" +
            "    \"dataHost\": \"localhost1\",\n" +
            "    \"database\": \"db4\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"dn5\",\n" +
            "    \"dataHost\": \"localhost1\",\n" +
            "    \"database\": \"db5\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"dn6\",\n" +
            "    \"dataHost\": \"localhost1\",\n" +
            "    \"database\": \"db6\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"dn7\",\n" +
            "    \"dataHost\": \"localhost1\",\n" +
            "    \"database\": \"db7\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"dn8\",\n" +
            "    \"dataHost\": \"localhost1\",\n" +
            "    \"database\": \"db8\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"dn9\",\n" +
            "    \"dataHost\": \"localhost1\",\n" +
            "    \"database\": \"db9\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"dn10\",\n" +
            "    \"dataHost\": \"localhost1\",\n" +
            "    \"database\": \"db10\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"dn11\",\n" +
            "    \"dataHost\": \"localhost1\",\n" +
            "    \"database\": \"db11\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"dn12\",\n" +
            "    \"dataHost\": \"localhost1\",\n" +
            "    \"database\": \"db12\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"dn13\",\n" +
            "    \"dataHost\": \"localhost1\",\n" +
            "    \"database\": \"db13\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"dn14\",\n" +
            "    \"dataHost\": \"localhost1\",\n" +
            "    \"database\": \"db14\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"dn15\",\n" +
            "    \"dataHost\": \"localhost1\",\n" +
            "    \"database\": \"db15\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"dn16\",\n" +
            "    \"dataHost\": \"localhost1\",\n" +
            "    \"database\": \"db16\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"dn17\",\n" +
            "    \"dataHost\": \"localhost1\",\n" +
            "    \"database\": \"db17\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"dn18\",\n" +
            "    \"dataHost\": \"localhost1\",\n" +
            "    \"database\": \"db18\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"dn19\",\n" +
            "    \"dataHost\": \"localhost1\",\n" +
            "    \"database\": \"db19\"\n" +
            "  }\n" +
            "]";
    String  dataHostListStr = "[{\n" +
            "\t\"balance\": 3,\n" +
            "\t\"maxCon\": 100,\n" +
            "\t\"minCon\": 2,\n" +
            "\t\"name\": \"localhost1\",\n" +
            "\t\"writeType\": 0,\n" +
            "\t\"switchType\": 1,\n" +
            "\t\"slaveThreshold\": 100,\n" +
            "\t\"dbType\": \"mysql\",\n" +
            "\t\"dbDriver\": \"native\",\n" +
            "maxRetryCount:\"6\",\n" +
            "\"slaveIDs\": \"0\",\n" +
            "\t\"heartbeat\": \"SHOW SLAVE STATUS\",\n" +
            "\t\"writeHost\": [{\n" +
            "\t\t\"host\": \"hostM1\",\n" +
            "\t\t\"url\": \"localhost:3306\",\n" +
            "\t\t\"password\": \"123\",\n" +
            "\t\t\"user\": \"root\",\n" +
            "\t\t\"readHost\": [{\n" +
            "\t\t\t\"host\": \"hostS2\",\n" +
            "\t\t\t\"url\": \"localhost:3306\",\n" +
            "\t\t\t\"password\": \"123\",\n" +
            "\t\t\t\"user\": \"root\"\n" +
            "\t\t}]\n" +
            "\t}, {\n" +
            "\t\t\"host\": \"hostM2\",\n" +
            "\t\t\"url\": \"localhost:3340\",\n" +
            "\t\t\"password\": \"123\",\n" +
            "\t\t \"user\":  \"root\"\n" +
            "\t}] \n" +
            "}]";
	@RequestMapping("/mycat/cluster/getDataHostList")
	public ResponseEntity getDataHostList() {
		logger.debug("getDataHostList");
		RestResponse<Object> response = RestResponse.buildExceptionResponse(200,"successful");
		try{
			response.setData(JSONArray.parse(dataHostListStr));
		}catch (Exception e){
			response.setMessage(e.getMessage());
            response.setCode(700);
		} finally {
            return new ResponseEntity(response,HttpStatus.OK);

        }
	}


    @RequestMapping("/mycat/cluster/getDataNodeList")
    public ResponseEntity getDataNodeList() {
        logger.debug("getDataNodeList");
        RestResponse<Object> response = RestResponse.buildExceptionResponse(200,"successful");
        try{
            response.setData(JSONArray.parse(dataNodeListStr));
        }catch (Exception e){
            response.setCode(700);
            response.setMessage(e.getMessage());
        } finally {
            return new ResponseEntity(response,HttpStatus.OK);

        }
    }

    @RequestMapping("/mycat/cluster/getSchemaList")
    public ResponseEntity getSchemaList() {
        logger.debug("getSchemaList");
        RestResponse<Object> response = RestResponse.buildExceptionResponse(200,"successful");
        try{
            response.setData(JSONArray.parse(schemaListStr));
        }catch (Exception e){
            response.setCode(700);
            response.setMessage(e.getMessage());
        } finally {
            return new ResponseEntity(response,HttpStatus.OK);

        }
    }
    //saveSchemaList
    @RequestMapping("/mycat/cluster/saveSchemaList")
    public ResponseEntity saveSchemaList(String schemList, String cluster) {
        logger.debug("saveSchemaList");
        RestResponse<Object> response = RestResponse.buildExceptionResponse(200,"successful");
        try{
            System.out.println(schemList);
            System.out.println(cluster);
            schemaListStr = schemList;
            response.setData(JSONArray.parse(schemaListStr));
        }catch (Exception e){
            response.setCode(700);
            response.setMessage(e.getMessage());
        } finally {
            return new ResponseEntity(response,HttpStatus.OK);
        }
    }
    private static Map<String,String> schemaListMap = new  ConcurrentHashMap<String,String>();
	static {
        schemaListMap.put("cluster1", schemaListStr);
    }
    //saveSchemaList
    @RequestMapping("/mycat/cluster/saveSchemaListToZk")
    public ResponseEntity saveSchemaListToZk(String cluster) {
        logger.debug("saveSchemaList");
        RestResponse<Object> response = RestResponse.buildExceptionResponse(200,"successful");
        try{
            System.out.println(cluster);
            response.setData(JSONArray.parse(schemaListStr));
        }catch (Exception e){
            response.setCode(700);
            response.setMessage(e.getMessage());
        } finally {
            return new ResponseEntity(response,HttpStatus.OK);
        }
    }
}
