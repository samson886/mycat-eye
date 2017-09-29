//展示节点详细信息
var showNodeDetails = function(serverId) {
	// 设置到session中，便于后面使用
	sessionStorage.setItem("serverId", serverId);

	getOverview(serverId);
	getDatabases(serverId);
	getStatus(serverId, "");
	getBinlog(serverId);
	getVariables(serverId, "");
	getReplication(serverId);
}
// 获取基本信息
var getOverview = function(serverId) {
	// 开始加载数据，显示loading图标
	$("body").mLoading({
		mask : false
	// 是否显示遮罩效果，默认显示
	});
	$("#panelDetails").show();
	// 获取agent地址，显示基本信息
	$
			.get(
					"agent-url",
					function(agentUrl) {
						$
								.getJSON(
										agentUrl + "/mysql/get/overview/"
												+ serverId,
										function(json) {
											if (json.code == "200") {
												$("#host").html(json.data.host);
												$("#port").html(json.data.port);
												$("#tags").html(json.data.tags);
												$("#basedir").html(
														json.data.basedir);
												$("#datadir").html(
														json.data.datadir);
												$("#generalLog").html(
														json.data.generalLog);
												if (json.data.generalLog == "ON") {
													$("#generalLogFile")
															.html(
																	json.data.generalLogFile);
												}
												$("#innodbBufferPoolSize")
														.html(
																json.data.innodbBufferPoolSize);
												$("#logError").html(
														json.data.logError);
												$("#slowQueryLog").html(
														json.data.slowQueryLog);
												if (json.data.slowQueryLog == "ON") {
													$("#slowQueryLogFile")
															.html(
																	json.data.slowQueryLogFile);
												}
												$("#version").html(
														json.data.version);
												$("#characterSetDatabase")
														.html(
																json.data.characterSetDatabase);
											}
										});
					});
	// 加载数据完毕关闭loading图标
	$("body").mLoading("hide");
}
// 获取数据库列表
var getDatabases = function(serverId) {
	// 获取agent地址，显示数据库列表
	$.get("agent-url", function(agentUrl) {
		$.getJSON(agentUrl + "/mysql/" + serverId + "/databases",
				function(json) {
					if (json.code == "200") {
						$("#tbody_databases").empty();
						var data = json.data;
						$.each(data, function(index, value) {
							var html = "";
							html += "<tr>";
							html += "<td>" + value.TABLE_SCHEMA + "</td>";
							html += "<td>" + value.size + "</td>";
							html += "</tr>";
							$("#tbody_databases").append(html);
						});
					}
				});
	});
}
// 获取数据库状态
var getStatus = function(serverId, filter) {
	// 获取agent地址，显示数据库列表
	$.get("agent-url", function(agentUrl) {
		$.getJSON(agentUrl + "/mysql/" + serverId + "/status?filter=" + filter,
				function(json) {
					if (json.code == "200") {
						$("#tbody_status").empty();
						var data = json.data;
						$.each(data, function(index, value) {
							var html = "";
							html += "<tr>";
							html += "<td>" + value.Variable_name + "</td>";
							html += "<td>" + value.Value + "</td>";
							html += "</tr>";
							$("#tbody_status").append(html);
						});
					}
				});
	});
}
// 显示二进制信息
var getBinlog = function(serverId) {
	// 获取agent地址，显示数据库列表
	$.get("agent-url", function(agentUrl) {
		$.getJSON(agentUrl + "/mysql/" + serverId + "/binaryLogs", function(
				json) {
			if (json.code == "200") {
				var data = json.data;
				$("#binlogFileUl").empty();
				var li = "";
				$.each(data, function(n, value) {
					if (n == 0) {
						$("#defaultBinlogFile").text(value.Log_name);
						// 设置二进制文件查看命令
						setShowBinlogEvents(value.Log_name);
					}
					li += "<li><a href='javascript:selectBinlogFile(\""
							+ value.Log_name + "\")'>" + value.Log_name
							+ "</a></li>";
				});
				if (li == "") {
					li = "<li><a href='javascript:void(0)'>暂无任何二进制文件</a></li>";
				}
				$("#binlogFileUl").append(li);
			}
		});
	});
}
// 选择某个二进制文件
var selectBinlogFile = function(logName) {
	$("#defaultBinlogFile").text(logName);
	setShowBinlogEvents(logName);
}
// 设置二进制文件查看命令
var setShowBinlogEvents = function(logName) {
	$("#showBinlogEvents").val(
			"SHOW BINLOG EVENTS IN '" + logName + "' LIMIT 0, 25");
}
// 执行二进制文件查看命令
var execute = function() {
	var serverId = sessionStorage.getItem("serverId");
	var showBinlogEvents = $("#showBinlogEvents").val();
	// 获取agent地址，显示数据库列表
	$.get("agent-url", function(agentUrl) {
		$.getJSON(agentUrl + "/mysql/" + serverId + "/showBinlogEvents", {
			showBinlogEvents : showBinlogEvents
		}, function(json) {
			$("#tbody_binlog_events").empty();
			if (json.code == "200") {
				$("#alert").text("");
				$("#alert").hide();
				var data = json.data;
				$.each(data, function(index, value) {
					var html = "";
					html += "<tr>";
					html += "<td>" + value.Event_type + "</td>";
					html += "<td>" + value.End_log_pos + "</td>";
					html += "<td>" + value.Pos + "</td>";
					html += "<td>" + value.Log_name + "</td>";
					html += "<td>" + value.Server_id + "</td>";
					html += "<td>" + value.Info + "</td>";
					html += "</tr>";
					$("#tbody_binlog_events").append(html);
				});
			}
			// 如果返回错误，则提示错误信息
			else {
				$("#alert").show();
				$("#alert").text(json.message);
			}
		});
	});
}
// 获取变量
var getVariables = function(serverId, filter) {
	// 获取agent地址，显示变量列表
	$.get("agent-url", function(agentUrl) {
		var url = agentUrl + "/mysql/" + serverId + "/globalVariables?filter="
				+ filter;
		$.getJSON(url, function(json) {
			if (json.code == "200") {
				$("#tbody_variables").empty();
				var data = json.data;
				$.each(data, function(index, value) {
					var html = "";
					html += "<tr>";
					html += "<td>" + value.Variable_name + "</td>";
					html += "<td>" + value.Value + "</td>";
					html += "</tr>";
					$("#tbody_variables").append(html);
				});
			}
		});
	});
}
// 通过过滤条件查询状态
$("#input_status").keyup(function() {
	var serverId = sessionStorage.getItem("serverId");
	var filter = $("#input_status").val();
	getStatus(serverId, filter);
});
// 通过过滤条件查询变量
$("#input_variables").keyup(function() {
	var serverId = sessionStorage.getItem("serverId");
	var filter = $("#input_variables").val();
	getVariables(serverId, filter);
});
// 获取复制信息
var getReplication = function(serverId) {
	// 获取agent地址
	$.get("agent-url", function(agentUrl) {
		var urlMasterInfo = agentUrl + "/mysql/" + serverId + "/master-info";
		// 显示主库信息
		$.getJSON(urlMasterInfo, function(json) {
			if (json.code == "200") {
				$("#tbody_master_status").empty();
				$("#tbody_slave_hosts").empty();
				var masterStatus = json.data.masterStatus;
				if (masterStatus == "") {
					$("#alert_master").addClass("alert-warning");
					$("#alert_master").removeClass("alert-success");
					$("#alert_master").text("此服务器尚未配置为一个复制进程中的主服务器。");
					$(".master").hide();
					// 返回
					return;
				} else {
					$(".master").show();
					$("#alert_master").addClass("alert-success");
					$("#alert_master").removeClass("alert-warning");
					$("#alert_master").text("此服务器已被配置为一个复制进程中的主服务器。");
				}
				$.each(masterStatus, function(index, value) {
					var html = "";
					html += "<tr>";
					html += "<td>" + value.File + "</td>";
					html += "<td>" + value.Position + "</td>";
					html += "<td>" + value.Binlog_Do_DB + "</td>";
					html += "<td>" + value.Binlog_Ignore_DB + "</td>";
					html += "</tr>";
					$("#tbody_master_status").append(html);
				});
				var slaveHosts = json.data.slaveHosts;
				$.each(slaveHosts, function(index, value) {
					var html = "";
					html += "<tr>";
					html += "<td>" + value.Server_id + "</td>";
					html += "<td>" + value.Host + "</td>";
					html += "<td>" + value.Port + "</td>";
					html += "<td>" + value.Master_id + "</td>";
					html += "</tr>";
					$("#tbody_slave_hosts").append(html);
				});
			}
		});

		var urlSlaveInfo = agentUrl + "/mysql/" + serverId + "/slave-info";
		$.getJSON(urlSlaveInfo, function(json) {
			var slaveStatus = json.data.slaveStatus;
			if (slaveStatus == "") {
				$("#alert_slave").addClass("alert-warning");
				$("#alert_slave").removeClass("alert-success");
				$("#alert_slave").text("此服务器尚未配置为一个复制进程中的从服务器。");
				$(".slave").hide();
				// 返回
				return;
			} else {
				$("#alert_slave").addClass("alert-success");
				$("#alert_slave").removeClass("alert-warning");
				$("#alert_slave").text("此服务器已被配置为一个复制进程中的从服务器。");
				$(".slave").show();
			}
			$("#td_slave_status").JSONView(slaveStatus[0]);

		});
	});
}
