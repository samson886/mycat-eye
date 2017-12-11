var ajaxUrlPrefix="";
$(function($){
	//获取agent地址
	$.get("/agent-url", function(data) {
		ajaxUrlPrefix=data;
		//加载当前节点
		fnLoadCurrentNode();
	});
});
//加载当前节点
var fnLoadCurrentNode = function() {
	var ajaxUrl = ajaxUrlPrefix + "/mysql/node/list";
	$.getJSON(ajaxUrl, {
		draw: 1,
		start: 0,
		length: 100
	}, function(json) {
		//如果页面session中保存有节点，则将当前节点设置为该节点
		var currentServerTags = window.localStorage.getItem("currentServerTags");
		if(currentServerTags != null) {
			$("#currentServerId").text(currentServerTags);
		}
		else{
			$("#currentServerId").text("");
		}
		var ulNodeList = $("#ulNodeList");
		$.each(json.data, function(n, item) {
			//如果页面session中没有节点，则将第一个节点作为默认节点
			if(n == 0 && ($("#currentServerId").text() == "")) {
				var id = item.mysqlServer.id;
				var tags = item.mysqlServer.tags;
				$("#currentServerId").text(tags);
				window.localStorage.setItem("currentServerId", id);
				window.localStorage.setItem("currentServerTags", tags);
			}
			var html = "";
			html += "<li>";
			html += "<a href=\"javascript:fnSelectNode('" + item.mysqlServer.id + "','" + item.mysqlServer.tags + "')\">" + item.mysqlServer.tags + "</a>";
			html += "</li>";
			ulNodeList.append(html);
		});
	});
}
//选择节点
var fnSelectNode = function(id, tags) {
	window.localStorage.setItem("currentServerId", id);
	window.localStorage.setItem("currentServerTags", tags);
	$("#currentServerId").text(tags);
	$(location).attr('href', 'index.html');
}