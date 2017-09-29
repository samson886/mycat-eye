$(function($) {
	//设置图表宽度
	fnInitChartWidth();
	//加载登录用户信息
	fnLoadUsername();
	//加载当前节点
	fnLoadCurrentNode();
	//修改密码
	$("#modifyPassword").click(function() {
		bootbox.setLocale("zh_CN");
		bootbox.prompt({
			title: "请输入新密码,确认后将重新登录",
			inputType: 'password',
			callback: function(result) {
				if(result == null) {
					return;
				} else {
					var username = $.cookie('MYCAT-EYE-ADMIN');
					var password = result;
					var ajaxUrl = ajaxUrlPrefix + "/sysuser/modify-password?username=" + username + "&newPassword=" + password;
					$.getJSON(ajaxUrl, function(json) {
						$.cookie("MYCAT-EYE-ADMIN", null, {
							path: '/'
						});
						$(window).attr('location', 'login.html');
					});
				}
			}
		});
	});
});
//加载登录用户信息
var fnLoadUsername=function(){
	var username = $.cookie('MYCAT-EYE-ADMIN');
	$(".username").text(username);
}
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
		if(currentServerTags != "null") {
			$("#currentServerId").text(currentServerTags);
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
//设置图表宽度
var fnInitChartWidth=function(){
	window.localStorage.setItem("chartWidth",(window.innerWidth-300)+"px");
}
