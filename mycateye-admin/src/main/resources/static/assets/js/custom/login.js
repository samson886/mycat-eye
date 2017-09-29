$(function($) {
	//响应回车键登录
	$("body").keydown(function() {
		if(event.keyCode == "13") {
			$("#submit").click();
		}
	});
});

//开启进度条，执行登录
$("#submit").loadingbar({
	dataType: "json",
	success: function(json) {
		if(json.code == "200") {
			$.cookie('MYCAT-EYE-ADMIN', json.data);
			$(window).attr('location', 'index.html');
		} else {
			$("#alert").html(json.message);
			$("#alert").show();
		}
	}

});
//执行ajax前的操作并返回请求的url地址
function ajaxBeforeAndReturnUrl() {
	$("#alert").hide();
	var username = $("#username").val();
	var password = $("#password").val();
	var ajaxUrl = ajaxUrlPrefix + "/sysuser/login?username=" + username + "&password=" + password;
	return ajaxUrl;
}