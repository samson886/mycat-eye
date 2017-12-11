$(function($) {
	$("#modifyPassword").click(
			function() {
				bootbox.setLocale("zh_CN");
				bootbox.prompt({
					title : "请输入新密码,确认后将重新登录",
					inputType : 'password',
					callback : function(result) {
						if (result == null) {
							return;
						} else {
							var username = $.cookie('MYCATEYE-ADMIN');
							var password = result;
							var url = "/api/modify-password?username="
									+ username + "&password=" + password;
							$.getJSON(url, function(json) {
								$.cookie("MYCATEYE-ADMIN", null, { path: '/' });
								$(window).attr('location','login.html');
							});
						}
					}
				});
			});
});