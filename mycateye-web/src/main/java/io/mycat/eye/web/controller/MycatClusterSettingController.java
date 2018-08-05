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
    String schemaListStr = "[{\"name\":\"TESTDB\",\"checkSQLschema\":false,\"sqlMaxLimit\":100,\"table\":[{\"name\":\"travelrecord\",\"dataNode\":\"dn1,dn2,dn3\",\"rule\":\"auto-sharding-long\"},{\"name\":\"company\",\"dataNode\":\"dn1,dn2,dn3\",\"primaryKey\":\"ID\",\"type\":\"global\"},{\"name\":\"goods\",\"dataNode\":\"dn1,dn2\",\"primaryKey\":\"ID\",\"type\":\"global\"},{\"name\":\"hotnews\",\"dataNode\":\"dn1,dn2,dn3\",\"rule\":\"mod-long\",\"primaryKey\":\"ID\",\"autoIncrement\":true},{\"name\":\"employee\",\"dataNode\":\"dn1,dn2\",\"rule\":\"sharding-by-intfile\",\"primaryKey\":\"ID\"},{\"name\":\"customer\",\"dataNode\":\"dn1,dn2\",\"rule\":\"sharding-by-intfile\",\"primaryKey\":\"ID\",\"childTable\":[{\"name\":\"orders\",\"joinKey\":\"customer_id\",\"parentKey\":\"id\",\"primaryKey\":\"ID\",\"childTable\":[{\"name\":\"order_items\",\"joinKey\":\"order_id\",\"parentKey\":\"id\",\"childTable\":[{\"name\":\"orders\",\"joinKey\":\"customer_id\",\"parentKey\":\"id\",\"primaryKey\":\"ID\",\"childTable\":[{\"name\":\"order_items\",\"joinKey\":\"order_id\",\"parentKey\":\"id\",\"childTable\":[]}]},{\"name\":\"customer_addr\",\"joinKey\":\"customer_id\",\"parentKey\":\"id\",\"primaryKey\":\"ID\"}]}]},{\"name\":\"customer_addr\",\"joinKey\":\"customer_id\",\"parentKey\":\"id\",\"primaryKey\":\"ID\"}]}]}]";
/*    String  schemaListStr = "[{\n" +
            "\t\"checkSQLschema\": false,\n" +
            "\t\"sqlMaxLimit\": 100,\n" +
            "\t\"name\": \"TESTDB\",\n" +
            "\t\"table\": [{\n" +
            "\t\t\"name\": \"e_account_subject\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"account_subject_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_admin\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"admin_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_chapter\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"chapter_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_chapter_pick_count\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"chapter_pick_count_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_class\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"class_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_class_package\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"class_package_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_class_student\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"class_student_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_class_warehouse\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"class_warehouse_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_code_def\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"code_def_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_code_type\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"code_type_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_content\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"content_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_course\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"course_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_course_resource\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"course_resource_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_institution\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"institution_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_institution_param\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"institution_param_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_item\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"item_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_knowledge\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"knowledge_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_model_test\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"model_test_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_natureclass\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"natureclass_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_natureclass_student\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"natureclass_student_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_node\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"node_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_op\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"op_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_outline\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"outline_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_package\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"package_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_package_warehouse\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"package_warehouse_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_pick_list\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"pick_list_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_pick_list_topic\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"pick_list_topic_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_pick_rule\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"pick_rule_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_pick_rule_questiontype\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"pick_rule_questiontype_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_pick_topic\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"pick_topic_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_qrcode\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"qrcode_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_question\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"question_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_student\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"student_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_student_box\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"student_box_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_student_package_time\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"student_package_time_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_student_param\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"student_param_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_student_score_statistics\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"student_score_statistics_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_task\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"task_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_teacher\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"teacher_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_teacher_permision\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"teacher_permision_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_topic\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"topic_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_topic_image\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"topic_image_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_topic_warehouse\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"topic_warehouse_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_user_info\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"user_info_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"html_parameter\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"parameter_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"sys_parameter\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"parameter_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"sys_update_info\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"s_update_info_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"w_book\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"book_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"w_book_card\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"book_card_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"w_resource\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"resource_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"w_resource_question\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"resource_question_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"w_student_book\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"student_book_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"w_student_weixin\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"student_weixin_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_task_result_self\",\n" +
            "\t\t\"rule\": \"sharding-by-month\",\n" +
            "\t\t\"dataNode\": \"dn$1-4\",\n" +
            "\t\t\"primaryKey\": \"task_result_self_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_task_result\",\n" +
            "\t\t\"rule\": \"sharding-by-month\",\n" +
            "\t\t\"dataNode\": \"dn$1-4\",\n" +
            "\t\t\"primaryKey\": \"task_result_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_result_detail_error\",\n" +
            "\t\t\"rule\": \"sharding-by-month\",\n" +
            "\t\t\"dataNode\": \"dn$1-4\",\n" +
            "\t\t\"primaryKey\": \"result_detail_error_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_result_detail\",\n" +
            "\t\t\"rule\": \"sharding-by-month\",\n" +
            "\t\t\"dataNode\": \"dn$1-4\",\n" +
            "\t\t\"primaryKey\": \"result_detail_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_result_detail_self\",\n" +
            "\t\t\"rule\": \"sharding-by-month\",\n" +
            "\t\t\"dataNode\": \"dn$1-4\",\n" +
            "\t\t\"primaryKey\": \"result_detail_self_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_result_detail_self_error\",\n" +
            "\t\t\"rule\": \"sharding-by-month\",\n" +
            "\t\t\"dataNode\": \"dn$1-4\",\n" +
            "\t\t\"primaryKey\": \"result_detail_self_error_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_store\",\n" +
            "\t\t\"rule\": \"sharding-by-month\",\n" +
            "\t\t\"dataNode\": \"dn$1-4\",\n" +
            "\t\t\"primaryKey\": \"store_id\"\n" +
            "\t}, {\n" +
            "\t\t\"autoIncrement\": true,\n" +
            "\t\t\"name\": \"mytable\",\n" +
            "\t\t\"rule\": \"mod-long\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3\",\n" +
            "\t\t\"primaryKey\": \"id\"\n" +
            "\t}, {\n" +
            "\t\t\"autoIncrement\": true,\n" +
            "\t\t\"name\": \"crcTable\",\n" +
            "\t\t\"rule\": \"crc32slot\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3,dn4,dn5,dn6\",\n" +
            "\t\t\"primaryKey\": \"id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"travelrecord\",\n" +
            "\t\t\"rule\": \"mod-long\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3\"\n" +
            "\t}]\n" +
            "}, {\n" +
            "\t\"checkSQLschema\": false,\n" +
            "\t\"sqlMaxLimit\": 100,\n" +
            "\t\"name\": \"MYTESTDB\",\n" +
            "\t\"table\": [{\n" +
            "\t\t\"name\": \"e_node\",\n" +
            "\t\t\"dataNode\": \"dn2\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"node_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_course\",\n" +
            "\t\t\"dataNode\": \"dn2\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"node_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_chapter\",\n" +
            "\t\t\"dataNode\": \"dn2\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"node_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_knowledge\",\n" +
            "\t\t\"dataNode\": \"dn2\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"node_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"e_topic_warehouse\",\n" +
            "\t\t\"dataNode\": \"dn2\",\n" +
            "\t\t\"type\": \"global\",\n" +
            "\t\t\"primaryKey\": \"node_id\"\n" +
            "\t}, {\n" +
            "\t\t\"name\": \"travelrecord\",\n" +
            "\t\t\"rule\": \"mod-long\",\n" +
            "\t\t\"dataNode\": \"dn1,dn2,dn3\"\n" +
            "\t}]\n" +
            "}]"; */
    String  dataNodeListStr = "[\n" +
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
}
