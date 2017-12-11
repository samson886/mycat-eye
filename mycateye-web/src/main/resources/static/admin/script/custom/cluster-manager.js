var ajaxUrlPrefix = "";
$(function($) {
	// 获取agent地址
	$.get("/agent-url", function(data) {
		ajaxUrlPrefix = data;
		// 加载集群列表
		fnLoadClusterList();
	});
	// 新增集群
	$("#btnAddCluster").click(
			function() {
				bootbox.setLocale("zh_CN");
				bootbox.prompt({
					backdrop : false,
					title : "请输入集群名称",
					callback : function(result) {
						if (result == null) {
							return;
						} else {
							var clusterName = result;
							var ajaxUrl = ajaxUrlPrefix
									+ "/mysql/cluster/save?id=0&name="
									+ clusterName;
							$.getJSON(ajaxUrl, function(json) {
								if (json.code == "200") {
									fnLoadClusterList();
								}
							});
						}
					}
				});
			});
});

// 加载集群列表
var fnLoadClusterList = function() {
	var ajaxUrl = ajaxUrlPrefix + "/mysql/cluster/all";
	$
			.getJSON(
					ajaxUrl,
					function(json) {
						var tbCluster = $("#tbCluster");
						tbCluster.empty();
						var html = "";
						$
								.each(
										json,
										function(i, value) {
											html += "<tr>";
											html += "<td>";
											html += value.id;
											html += "</td>";
											html += "<td>";
											html += value.name;
											html += "</td>";
											html += "<td>";
											html += "<button type=\"button\" onClick=\"javascript:fnEditCluster("
													+ value.id
													+ ",'"
													+ value.name
													+ "')\" class=\"btn btn-default btn-sm oper-btn\"><span class=\"glyphicon glyphicon-edit\"></span> 编辑</button>&nbsp;&nbsp;&nbsp;";
											html += "<button type=\"button\" onClick=\"javascript:fnDeleteCluster("
													+ value.id
													+ ",'"
													+ value.name
													+ "')\" class=\"btn btn-default btn-sm oper-btn\"><span class=\"glyphicon glyphicon-remove\"></span> 删除</button>";
											html += "</td>";
											html += "</tr>";
										});
						tbCluster.append(html);
					});
}

// 弹出窗口，编辑集群名称
var fnEditCluster = function(id, name) {
	bootbox.setLocale("zh_CN");
	bootbox.prompt({
		title : "编辑集群",
		inputType : 'text',
		value : name,
		callback : function(result) {
			if (result == null) {
				return;
			} else {
				var newName = result;
				var ajaxUrl = ajaxUrlPrefix + "/mysql/cluster/save?id=" + id
						+ "&name=" + newName;
				$.getJSON(ajaxUrl, function(json) {
					if (json.code == "200") {
						fnLoadClusterList();
					}
				});
			}
		}
	});
}
// 删除集群
var fnDeleteCluster = function(id, name) {
	bootbox.setLocale("zh_CN");
	bootbox.confirm("你确认删除" + name + "这个集群吗？删除后集群下的节点不会被删除", function(result) {
		if (result) {
			var ajaxUrl = ajaxUrlPrefix + "/mysql/cluster/delete?id=" + id;
			$.getJSON(ajaxUrl, function(json) {
				if (json.code == "200") {
					fnLoadClusterList(ajaxUrlPrefix);
				}
			});
		}
	});
}