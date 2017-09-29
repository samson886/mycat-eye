$(function($) {
	// 初始化节点列表
	$.getJSON("/mysql/node/all", function(data) {
		var li = "";
		$.each(data, function(n, value) {
			if (n == 0) {
				$("#defaultNode").text(value.tags);
				// 保存当前serverId
				$("#defaultServerId").val(value.id);
				// 加载表格数据
				dataTableInit(value.id);
			}
			li += "<li><a href='javascript:reloadChart(" + value.id + ",\""
					+ value.tags + "\")'>" + value.tags + "</a></li>";
		});
		if (li == "") {
			li = "<li><a href='javascript:void(0)'>暂未添加任何节点</a></li>";
		}
		$("#nodeUl").append(li);
	});

});
// 选择节点，刷新SQL列表
function reloadChart(serverId, tags) {
	$("#defaultNode").text(tags);
	// 保存当前serverId
	$("#defaultServerId").val(serverId);
	// 加载表格数据
	dttable = $('#example').dataTable();
	dttable.fnClearTable(); // 清空一下table
	dttable.fnDestroy(); // 还原初始化了的datatable
	dataTableInit(serverId);
	// 隐藏sql分析面板
	$("#panel_sql_analyze").hide();
}
var dataTableInit = function(serverId) {
	var base64 = new Base64();  
	var table = $('#example')
			.DataTable(
					{
						"bLengthChange" : false,
						"bFilter" : false,
						"ordering" : false,
						"processing" : true,
						"iDisplayLength" : 10,
						"serverSide" : true,
						"oLanguage" : {
							"sLengthMenu" : "每页显示 _MENU_ 条记录",
							"sZeroRecords" : "对不起，查询不到任何相关数据",
							"sInfo" : "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
							"sInfoEmtpy" : "找不到相关数据",
							"sInfoFiltered" : "数据表中共为 _MAX_ 条记录)",
							"sProcessing" : "正在加载中...",
							"sSearch" : "标签搜索",
							"sUrl" : "", // 多语言配置文件，可将oLanguage的设置放在一个txt文件中，例：Javascript/datatable/dtCH.txt
							"oPaginate" : {
								"sFirst" : "第一页",
								"sPrevious" : " 上一页 ",
								"sNext" : " 下一页 ",
								"sLast" : " 最后一页 "
							}
						},
						"ajax" : "/mysql/statement/getAllSlowSqlStatement?server_id="
								+ serverId
								+ "&key=start_time&order=desc",
						"columns" : [ null, {
							"data" : "db"
						}, null, {
							"data" : "user_host"
						}, null, null ],
						"columnDefs" : [
								{
									"targets" : [ 0 ], // 目标列位置，下标从0开始
									"data" : "sql_text", // 数据列名
									"render" : function(data, type, full) { // 返回自定义内容
										var html = "<a data-toggle=\"tooltip\" title=\""
												+ base64.decode(full.sql_text)
												+ "\">"
												+ $.fixedWidth(base64.decode(full.sql_text),
														100) + "</a>";
										return html;
									}
								},
								{
									"targets" : [ 2 ], // 目标列位置，下标从0开始
									"data" : "query_time", // 数据列名
									"render" : function(data, type, full) { // 返回自定义内容
										var html = full.query_time;
										return html;
									}
								},
								{
									"targets" : [ 4 ], // 目标列位置，下标从0开始
									"data" : "start_time", // 数据列名
									"render" : function(data, type, full) { // 返回自定义内容
										var html = getLocalTime(full.start_time);
										return html;
									}
								},
								{
									"targets" : [ 5 ], // 目标列位置，下标从0开始
									"data" : null, // 数据列名
									"render" : function(data, type, full) { // 返回自定义内容
										json_data=JSON.stringify(full);
										//用#替换单引号，避免参数在接受时遇到单引号出错
										json_data = json_data.replace(/\'/g,"#");
										var html = "<a href='javascript:analyzeSql("
												+ json_data
												+ ")' class=\"btn btn-success btn-sm\" type=\"submit\">分析</a>";
										return html;
									}
								} ]
					});
}