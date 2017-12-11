$(function($) {
	var username=$.cookie('MYCATEYE-ADMIN');
	if(username=="null"||username==null){
		$(window).attr('location','login.html');
	}
	else{
		$("#login_admin").html(username);
	}
			
	$("#logout").click(function(){
		$.cookie("MYCATEYE-ADMIN", null, { path: '/' });
		$(window).attr('location','login.html');
	});
});
