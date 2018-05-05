$(function() {
	/* 换肤 */
	$(".dropdown .changecolor li").click(function() {
		var style = $(this).attr("id");
		$("link[title!='']").attr("disabled", "disabled");
		$("link[title='" + style + "']").removeAttr("disabled");

		$.cookie('mystyle', style, {
			expires : 7
		}); // 存储一个带7天期限的 cookie
	});
	var cookie_style = $.cookie("mystyle");
	if (cookie_style != null) {
		$("link[title!='']").attr("disabled", "disabled");
		$("link[title='" + cookie_style + "']").removeAttr("disabled");
	}

	/* 左侧导航栏显示隐藏功能 */
	$(".subNav").on("click",function() {
		/* 显示 */
		var _this = $(this);
		var first = _this.find("span:first-child");
		if(first.hasClass("fa-angle-right")){
			first.removeClass("fa-angle-right").addClass("fa-angle-down");
			_this.removeClass("sublist-down").addClass("sublist-up");
		}
		/* 隐藏 */
		else {
			first.removeClass("fa-angle-down").addClass("fa-angle-right");
			_this.removeClass("sublist-up").addClass("sublist-down");
		}
		// 修改数字控制速度， slideUp(500)控制卷起速度
		_this.next(".navContent").slideToggle(300).siblings(".navContent").slideUp(300);
	});

	/* 左侧导航栏缩进功能 */
	$(".left-main .sidebar-fold").on("click",function() {
		var paret = $(this).parent();
		var paretRight = paret.parent().find(".right-product");
		//if ($(this).parent().attr('class') == "left-main left-full") {
		if(paret.hasClass("left-full")){
			paret.removeClass("left-full").addClass("left-off");
			paretRight.removeClass("right-full").addClass("right-off");
		} else {
			paret.removeClass("left-off").addClass("left-full");
			paretRight.removeClass("right-off").addClass("right-full");
		}
	});

	/* 左侧鼠标移入提示功能 */
	$(".sBox ul li").on("mouseenter", function() {
		if ($(this).find("span:last-child").css("display") == "none") {
			$(this).find("div").show();
		}
	});
    $(".sBox ul li").on("mouseleave", function() {
		$(this).find("div").hide();
	});
})
