// 复制检查
var checkReplication = function(serverId) {
	bsStep(4);
	// 复制检查：IO线程、SQL线程、复制延迟
	$("#span_slave_io_running")
			.append(
					"<img style=\"width:100px;height:20px;\" title=\"正在检查\" src=\"assets/img/loading_check.gif\" />");
	$("#span_slave_sql_running")
	.append(
			"<img style=\"width:100px;height:20px;\" title=\"正在检查\" src=\"assets/img/loading_check.gif\" />");
	$("#span_seconds_behind_master")
	.append(
			"<img style=\"width:100px;height:20px;\" title=\"正在检查\" src=\"assets/img/loading_check.gif\" />");
	
	$
			.getJSON(
					globalAgentUrl + "/health-check/replication/" + serverId,
					function(json) {
						$("#span_slave_io_running").empty();
						$("#span_slave_sql_running").empty();
						$("#span_seconds_behind_master").empty();
						if (json.code == "200") {
							slaveIORunning=json.data[0].Slave_IO_Running;
							slaveSQLRunning=json.data[0].Slave_SQL_Running;
							secondsBehindMaster=json.data[0].Seconds_Behind_Master;
							if(slaveIORunning=="Yes"){
								slaveIORunningClassIsDanger(slaveIORunning);
							}
							else{
								slaveIORunningClassIsOk();
							}
							if(slaveSQLRunning!="Yes"){
								slaveSQLRunningClassIsDanger(slaveSQLRunning);
							}
							else{
								slaveSQLRunningClassIsOk();
							}
							if(secondsBehindMaster!="0"){
								secondsBehindMasterClassIsDanger(secondsBehindMaster);
							}
							else{
								secondsBehindMasterClassIsOk();
							}
						} else {
							slaveIORunningClassIsOk();
							
							slaveSQLRunningClassIsOk();
							
							secondsBehindMasterClassIsOk();
						}
					});
}

//显示从库IO线程状态检查结果
var showCheckResultBySlaveIORunning = function(slaveIORunning) {
	var html = "<div class=\"alert alert-danger\" role=\"alert\">检查到数据库从库IO线程状态为："+slaveIORunning+",请及时检查。</div>";
	showModal(html,"从库IO线程状态");
}

//显示从库SQL线程状态检查结果
var showCheckResultBySlaveSQLRunning = function(slaveSQLRunning) {
	var html = "<div class=\"alert alert-danger\" role=\"alert\">检查到数据库从库SQL线程状态为："+slaveIORunning+",请及时检查。</div>";
	showModal(html,"从库SQL线程状态");
}

//显示从库复制延迟检查结果
var showCheckResultBySecondsBehindMaster = function(secondsBehindMaster) {
	var html = "<div class=\"alert alert-danger\" role=\"alert\">提醒：检查到数据库复制延迟为："+secondsBehindMaster+"。如果你知晓并接受该延迟，请忽略。</div>";
	showModal(html,"从库复制延迟");
}

//显示模态窗口
var showModal=function(html,title){
	$("#checkResult").empty();
	$("#checkResult").append(html);
	$("#modalTitle").text(title);
	$("#checkResultModal").modal('show');
}

//IO线程状态正常的样式
var slaveIORunningClassIsOk=function(){
	$("#li_slave_io_running").removeClass();
	$("#li_slave_io_running").addClass("list-group-item");
	$("#span_slave_io_running")
			.append(
					"<img style=\"width:28px;height:28px;\" src=\"assets/img/ok.png\" />");
}
//SQL线程状态正常的样式
var slaveSQLRunningClassIsOk=function(){
	$("#li_slave_sql_running").removeClass();
	$("#li_slave_sql_running").addClass("list-group-item");
	$("#span_slave_sql_running")
			.append(
					"<img style=\"width:28px;height:28px;\" src=\"assets/img/ok.png\" />");
}
//复制延迟正常的样式
var secondsBehindMasterClassIsOk=function(){
	$("#li_seconds_behind_master").removeClass();
	$("#li_seconds_behind_master").addClass("list-group-item");
	$("#span_seconds_behind_master")
			.append(
					"<img style=\"width:28px;height:28px;\" src=\"assets/img/ok.png\" />");
}
//IO线程状态异常的样式
var slaveIORunningClassIsDanger=function(slaveIORunning){
	$("#li_slave_io_running").addClass("list-group-item-danger");
	$("#span_slave_io_running")
			.append(
					"<a href=\"javascript:showCheckResultBySlaveIORunning('"+slaveIORunning+"')\">该项有问题，立即查看</a>");
}

//SQL线程状态异常的样式
var slaveSQLRunningClassIsDanger=function(slaveSQLRunning){
	$("#li_slave_sql_running").addClass("list-group-item-danger");
	$("#span_slave_sql_running")
			.append(
					"<a href=\"javascript:showCheckResultBySlaveSQLRunning('"+slaveSQLRunning+"')\">该项有问题，立即查看</a>");
}
//复制延迟异常的样式
var secondsBehindMasterClassIsDanger=function(secondsBehindMaster){
	$("#li_seconds_behind_master").addClass("list-group-item-danger");
	$("#span_seconds_behind_master")
			.append(
					"<a href=\"javascript:showCheckResultBySecondsBehindMaster('"+secondsBehindMaster+"')\">该项有问题，立即查看</a>");
}