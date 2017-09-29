$(function($) {
	fnLoadNodeList();
	//新增节点
	$("#btnAddNode").click(
		function() {
			$("#id").val(0);
			$("#host").val("");
			$("#port").val("");
			$("#username").val("");
			$("#password").val("");
			$("#tags").val("");
			fnLoadClusterSelect(0);
			$('#nodeModal').modal('show');
		});
});
//提交
$("#submit").click(function() {
	var id = $("#id").val();
	var host = $("#host").val();
	var port = $("#port").val();
	var username = $("#username").val();
	var password = $("#password").val();
	var tags = $("#tags").val();
	var clusterId = $("#clusterSelect").val();
	var ajaxUrl = ajaxUrlPrefix + "/mysql/node/save?id=" + id + "&host=" + host + "&port=" + port + "&username=" + username + "&password=" + password + "&tags=" + tags + "&clusterId=" + clusterId;
	$.getJSON(ajaxUrl, function(json) {
		if(json.code == 200) {
			location.reload(true);
		} else {
			$("#alert").text(json.message);
			$("#alert").show();
		}
	});
});
//加载节点列表
var fnLoadNodeList = function() {
	var ajaxUrl = ajaxUrlPrefix + "/mysql/node/list";
	var table = $('#nodeList')
		.DataTable({
			"bLengthChange": false,
			"bFilter": false,
			"bSort": false,
			"processing": true,
			"bProcessing": true,
			"serverSide": true,
			"iDisplayLength": 10,
			"pagingType": "simple",
			"oLanguage": {
				"sLengthMenu": "每页显示 _MENU_ 条记录",
				"sZeroRecords": "对不起，查询不到任何相关数据",
				"sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
				"sInfoEmtpy": "找不到相关数据",
				"sInfoFiltered": "数据表中共为 _MAX_ 条记录)",
				"sProcessing": "",
				"sLoadingRecords": "Loading...",
				"sSearch": "标签搜索",
				"sUrl": "", // 多语言配置文件，可将oLanguage的设置放在一个txt文件中，例：Javascript/datatable/dtCH.txt
				"oPaginate": {
					"sFirst": "第一页",
					"sPrevious": " 上一页 ",
					"sNext": " 下一页 ",
					"sLast": " 最后一页 "
				}

			},
			"ajax": ajaxUrl,
			"columns": [{
				"data": "mysqlServer.id"
			}, {
				"data": "mysqlServer.host"
			}, {
				"data": "mysqlServer.port"
			}, {
				"data": "mysqlServer.tags"
			}, {
				"data": "clusterName"
			}],
			"columnDefs": [{
				"targets": [5], // 目标列位置，下标从0开始
				"data": "id", // 数据列名
				"render": function(data, type,
					full) { // 返回自定义内容
					var html = "<button type=\"button\" onClick=\"javascript:fnEditNode(" + full.mysqlServer.id + ")\" class=\"btn btn-default btn-sm oper-btn\"><span class=\"glyphicon glyphicon-edit\"></span> 编辑</button>&nbsp;&nbsp;&nbsp;";
					html += "<button type=\"button\" class=\"btn btn-default btn-sm oper-btn\"><span class=\"glyphicon glyphicon-alert\"></span> 配置报警</button>&nbsp;&nbsp;&nbsp;";
					html += "<button type=\"button\" onClick=\"javascript:fnDeleteNode(" + full.mysqlServer.id + ",'" + full.mysqlServer.tags + "')\" class=\"btn btn-default btn-sm oper-btn\"><span class=\"glyphicon glyphicon-remove\"></span> 删除</button>";

					return html;
				}
			}]
		});
}
//加载集群下拉菜单
var fnLoadClusterSelect = function(id) {
	$("#clusterSelect").empty();
	var ajaxUrl = ajaxUrlPrefix + "/mysql/cluster/all";
	$.getJSON(ajaxUrl, function(data) {
		//初始化集群下拉菜单
		var option = "";
		$.each(data, function(n, value) {
			option += "<option value=" + value.id + " >" + value.name + "</option>";
		});
		if(option == "") {
			option = "<option value=\"0\" selected=\"selected\">暂无集群</option>";
		}
		$("#clusterSelect").append(option);
		//如果id不为0，则为新增，不为0则为编辑需要初始化集群名称
		if(id != 0) {
			$("#clusterSelect").val(id);
		}
	});
}
// 编辑节点名称
var fnEditNode = function(id) {
	var ajaxUrl = ajaxUrlPrefix + "/mysql/node/info?id=" + id;
	$.getJSON(ajaxUrl, function(json) {
		$("#id").val(json.id);
		$('#nodeModal').modal('show');
		$("#host").val(json.host);
		$("#port").val(json.port);
		$("#username").val(json.username);
		$("#password").val(json.password);
		$("#tags").val(json.tags);
		fnLoadClusterSelect(json.clusterId);
	});
}
//删除节点
var fnDeleteNode = function(id, name) {
	bootbox.setLocale("zh_CN");
	bootbox.confirm("你确认删除" + name + "这个节点吗？", function(
		result) {
		if(result) {
			var ajaxUrl = ajaxUrlPrefix + "/mysql/node/delete?id=" + id;
			$.getJSON(ajaxUrl, function(json) {
				if(json.code == "200") {
					location.reload(true);
				}
			});
		}
	});
}