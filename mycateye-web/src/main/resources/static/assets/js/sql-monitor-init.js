$(function($) {
	// 初始化节点列表
	$.getJSON("/mysql/node/all", function(data) {
		var li = "";
		$.each(data, function(n, value) {
			if (n == 0) {
				$("#defaultNode").text(value.tags);
				// 保存当前serverId
				$("#defaultServerId").val(value.id);
				// 保存sql详细数据到本地
				saveSqlDataLocalStorage(value.id);
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
// 保存sql详细数据到本地
var saveSqlDataLocalStorage = function(serverId) {
	// 将sql语句详细数据保存到html5本地
	$.getJSON("/mysql/statement/getAllSqlStatement?server_id=" + serverId
			+ "&limit=100&offset=0&key=last_seen&order=desc", function(json) {
		$.each(json.data, function(index, content) {
			window.localStorage
					.setItem(content.digest, JSON.stringify(content));
		});
	});
}
// 选择节点，刷新SQL列表
function reloadChart(serverId, tags) {
	$("#defaultNode").text(tags);
	// 保存当前serverId
	$("#defaultServerId").val(serverId);
	// 保存sql详细数据到本地
	saveSqlDataLocalStorage(serverId);
	// 加载表格数据
	dttable = $('#example').dataTable();
	dttable.fnClearTable(); // 清空一下table
	dttable.fnDestroy(); // 还原初始化了的datatable
	dataTableInit(serverId);
	// 隐藏sql分析面板
	$("#panel_sql_analyze").hide();
}
var dataTableInit = function(serverId) {

	var table = $('#example')
			.DataTable(
					{
						"bLengthChange" : false,
						"bFilter" : false,
						"ordering" : false,
						"processing" : true,
						"iDisplayLength" : 10,
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
						"ajax" : "/mysql/statement/getAllSqlStatement?server_id="
								+ serverId
								+ "&limit=100&offset=0&key=last_seen&order=desc",
						"columns" : [ null, {
							"data" : "currentSchema"
						}, null, null, {
							"data" : "countStar"
						}, null ],
						"columnDefs" : [
								{
									"targets" : [ 0 ], // 目标列位置，下标从0开始
									"data" : "sqlText", // 数据列名
									"render" : function(data, type, full) { // 返回自定义内容
										var html = "<a data-toggle=\"tooltip\" title=\""
												+ full.sqlText
												+ "\">"
												+ $.fixedWidth(full.sqlText,
														100) + "</a>";
										return html;
									}
								},
								{
									"targets" : [ 2 ], // 目标列位置，下标从0开始
									"data" : "avgTimerWait", // 数据列名
									"render" : function(data, type, full) { // 返回自定义内容
										var html = nanosecondToMillisecond(full.avgTimerWait)
												+ "毫秒";
										return html;
									}
								},
								{
									"targets" : [ 3 ], // 目标列位置，下标从0开始
									"data" : "lastSeen", // 数据列名
									"render" : function(data, type, full) { // 返回自定义内容
										var html = getLocalTime(full.lastSeen);
										return html;
									}
								},
								{
									"targets" : [ 5 ], // 目标列位置，下标从0开始
									"data" : null, // 数据列名
									"render" : function(data, type, full) { // 返回自定义内容
										var html = "<a href=\"javascript:analyzeSql('"
												+ full.digest
												+ "')\" class=\"btn btn-success btn-sm\" type=\"submit\">分析</a>";
										return html;
									}
								} ]
					});
}