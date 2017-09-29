$(function($) {
	var username=$.cookie('MYCAT-EYE-ADMIN');
	if(username=="null"||username==null){
		$(window).attr('location','login.html');
	}
	else{
		$("#login_admin").html(username);
	}
			
	$("#logout").click(function(){
		$.cookie("MYCAT-EYE-ADMIN", null);
		$(window).attr('location','login.html');
	});
});
