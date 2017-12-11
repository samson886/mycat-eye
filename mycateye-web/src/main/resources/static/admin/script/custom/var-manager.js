var ajaxUrlPrefix = "";
$(function($) {
	// 获取agent地址
	$.get("/agent-url", function(data) {
		ajaxUrlPrefix = data;
		// 加载变量列表
		fnLoadVariables("");
	});
});

// 加载变量列表
var fnLoadVariables = function(filter) {
	var serverId = window.localStorage.getItem("currentServerId");
	var ajaxUrl = ajaxUrlPrefix + "/mysql/" + serverId
			+ "/globalVariables?filter=" + filter;

	var mysqlVarDocUrlPrefix = "https://dev.mysql.com/doc/refman/5.7/en/server-system-variables.html#sysvar_";

	$.getJSON(
					ajaxUrl,
					function(json) {
						if (json.code == "200") {
							$("#tbody_variables").empty();
							var data = json.data;
							$
									.each(
											data,
											function(index, value) {
												var html = "";
												html += "<tr>";
												if (value.Variable_name == null) {
													html += "<td>"
															+ value.VARIABLE_NAME
															+ "</td>";
													html += "<td>"
															+ value.VARIABLE_VALUE
															+ "</td>";
												} else {
													html += "<td>"
															+ value.Variable_name
															+ "</td>";
													html += "<td>"
															+ value.Value
															+ "</td>";
												}
												var mysqlVarDocUrl = mysqlVarDocUrlPrefix
														+ value.Variable_name;
												html += "<td style=\"width:100px;\"><a title=\"修改变量值\" class=\"btn btn-info btn-editone btn-sm\" href=\"javascript:fnEditVariables('"
														+ value.Variable_name
														+ "','"
														+ value.Value
														+ "')\"><i class=\"glyphicon glyphicon-pencil\"></i></a>&nbsp;<a title=\"查看变量解释\" target=\"_blank\" class=\"btn btn-info btn-editone btn-sm\" href=\""
														+ mysqlVarDocUrl
														+ "\"><i class=\"glyphicon glyphicon-search\"></i></a></td>";
												html += "</tr>";
												$("#tbody_variables").append(
														html);
											});
						}
					});
}
// 通过过滤条件查询变量
$("#input_variables").keyup(function() {
	var filter = $("#input_variables").val();
	fnLoadVariables(filter);
});
// 编辑变量
var fnEditVariables = function(variableName, variableValue) {
	var serverId = window.localStorage.getItem("currentServerId");
	bootbox.setLocale("zh_CN");
	bootbox.prompt({
		title : "编辑变量：" + variableName,
		inputType : 'text',
		value : variableValue,
		callback : function(result) {
			if (result == null) {
				return;
			} else {
				var ajaxUrl = ajaxUrlPrefix + "/mysql/" + serverId
						+ "/globalVariables/" + variableName + "/" + result
						+ "/";
				$.getJSON(ajaxUrl, function(json) {
					if (json.code == "200") {
						var filter = $("#input_variables").val();
						fnLoadVariables(filter);
					} else {
						bootbox.alert(json.message);
					}
				});
			}
		}
	});
}