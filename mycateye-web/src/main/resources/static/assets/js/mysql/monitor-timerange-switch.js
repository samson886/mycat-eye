$(function($) {
	//点击1小时范围时触发
	$("#timeRange1").click(function(){
		var hasClass=$("#timeRange1").hasClass("btn-info");
		if(hasClass){
			return;
		}
		var defaultServerId=$("#defaultServerId").val();
		$("button[name='timeRangeGroup']").removeClass("btn-info");
		$("#timeRange1").addClass("btn-info");
		//加载1小时的图表数据
		chartInit(defaultServerId,-1);
		//将默认时间范围设为1小时
		$("#defaultTimeRange").val(-1);
	});
	//点击8小时范围时触发
	$("#timeRange8").click(function(){
		var hasClass=$("#timeRange8").hasClass("btn-info");
		if(hasClass){
			return;
		}
		var defaultServerId=$("#defaultServerId").val();
		$("button[name='timeRangeGroup']").removeClass("btn-info");
		$("#timeRange8").addClass("btn-info");
		//加载8小时的图表数据
		chartInit(defaultServerId,-8);
		//将默认时间范围设为8小时
		$("#defaultTimeRange").val(-8);
	});
	//点击24小时范围时触发
	$("#timeRange24").click(function(){
		var hasClass=$("#timeRange24").hasClass("btn-info");
		if(hasClass){
			return;
		}
		var defaultServerId=$("#defaultServerId").val();
		$("button[name='timeRangeGroup']").removeClass("btn-info");
		$("#timeRange24").addClass("btn-info");
		//加载24小时的图表数据
		chartInit(defaultServerId,-24);
		//将默认时间范围设为24小时
		$("#defaultTimeRange").val(-24);
	});
});