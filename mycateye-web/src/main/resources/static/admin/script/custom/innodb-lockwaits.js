var ajaxUrlPrefix = "";
$(function($) {
	// 获取agent地址
	$.get("/agent-url", function(data) {
		ajaxUrlPrefix = data;
		var serverId = window.localStorage.getItem("currentServerId");
		if (serverId != null) {
			// 加载集群列表
			fnLoadLockwaitsList(serverId);
		}

	});
});

var fnLoadLockwaitsList = function(serverId) {
	var ajaxUrl = ajaxUrlPrefix + "/innodb/lockwaits/" + serverId;
	var table = $('#tbLockwaits').DataTable({
		"bLengthChange" : false,
		"bFilter" : false,
		"bSort" : false,
		"processing" : true,
		"bProcessing" : true,
		"serverSide" : false,
		"iDisplayLength" : 10,
		"pagingType" : "simple",
		"oLanguage" : {
			"sLengthMenu" : "每页显示 _MENU_ 条记录",
			"sZeroRecords" : "对不起，查询不到任何相关数据",
			"sInfo" : "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
			"sInfoEmtpy" : "找不到相关数据",
			"sInfoFiltered" : "数据表中共为 _MAX_ 条记录)",
			"sProcessing" : "",
			"sLoadingRecords" : "Loading...",
			"sSearch" : "标签搜索",
			"sUrl" : "", // 多语言配置文件，可将oLanguage的设置放在一个txt文件中，例：Javascript/datatable/dtCH.txt
			"oPaginate" : {
				"sFirst" : "第一页",
				"sPrevious" : " 上一页 ",
				"sNext" : " 下一页 ",
				"sLast" : " 最后一页 "
			}

		},
		"ajax" : ajaxUrl,
		"columns" : [ {
			"data" : "requestingTrxId"
		}, {
			"data" : "requestedLockId"
		}, {
			"data" : "blockingTrxId"
		}, {
			"data" : "blockingLockId"
		} ]
	});
}