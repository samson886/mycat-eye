var ajaxUrlPrefix = "";
$(function($) {
	// 获取agent地址
	$.get("/agent-url", function(data) {
		ajaxUrlPrefix = data;
		var serverId = window.localStorage.getItem("currentServerId");
		if (serverId != null) {
			// 加载innodb状态
			fnLoadInnodbStatus(serverId);
		}
	});
});

var fnLoadInnodbStatus = function(serverId) {
	var ajaxUrl = ajaxUrlPrefix + "/innodb/status/" + serverId;
	$.get(ajaxUrl, function(data) {
		$("#innodbStatus").html(data);
	});
}