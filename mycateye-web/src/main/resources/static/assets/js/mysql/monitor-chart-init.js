$(function() {
	var datetimerange = $("#reservationtime");
    if (datetimerange && datetimerange.length > 0) {
		//定义时间选择事件
		datetimerange.daterangepicker({
			timePicker: true,
			timePickerIncrement: 1,
			format: 'YYYY/MM/DD HH:mm:ss'
		},
		function (start, end, label) {
			var tr = datetimerange.val();
			//console.log('start', start, 'end', end, 'label', label);
			var sid = $('#defaultNode').attr('data-value') || '';
			if(sid == ''){
				notifi.error('请选择要查看的mysql节点');
				return;
			}
			chartInit(sid, tr);
		});
	}

	// MYSQL节点列表
    var mysqlNodes = $('#nodeUl');
    // MYSQL节点信息
    var currentMysql = $('#defaultNode');
    var nodes = getNodes();
    // 获取所有mysql节点列表
    if(mysqlNodes && mysqlNodes.length>0) {
        getMysqlList(mysqlNodes,function(data){
			if(data.length>0){
	            var c = mysqlNodes.find('li').eq(0);
	            if(nodes.curMysql!=''){
	                currentMysql.text(nodes['list']['mysql']['name']||'');
	                currentMysql.attr('data-value',nodes['list']['mysql']['value']||'');
					chartInit($('#defaultNode').attr('data-value') || '',$("#reservationtime").val()||'');
	            }else{
	                currentMysql.text(c.attr('data-name')||'暂无节点');
	                currentMysql.attr('data-value',c.attr('data-value')||'');
	                var n = nodes.list || {mysql: {name: '', value: ''}, mycat: {name: '', value: ''}};
	                n.mysql.name = c.attr('data-name')||'暂无节点';
	                n.mysql.value = c.attr('data-value')||'';
	                window.sessionStorage.setItem('nodes',JSON.stringify(n));
					chartInit($('#defaultNode').attr('data-value') || '',$("#reservationtime").val()||'');
	            }
				var timeRange = $("#reservationtime").val();
			}
        });
        mysqlNodes.on('click','li',function(e){
            var _this = $(this);
    		if(!_this.hasClass('active') && !_this.hasClass('disabled')){
                var name = _this.attr('data-name');
                var value = _this.attr('data-value');
                currentMysql.text(name);
                currentMysql.attr('data-value',value);
                var n = nodes.list || {mysql: {name: '', value: ''}, mycat: {name: '', value: ''}};
                n.mysql.name = name;
                n.mysql.value = value;
                window.sessionStorage.setItem('nodes',JSON.stringify(n));
				chartInit($('#defaultNode').attr('data-value') || '',$("#reservationtime").val()||'');
            }
        });
    }


	// //初始化节点列表
	// nodeInit();
	// //初始化时间区间
	// var now = getMillisecondAgoFormatDate(0);
	// var halfAnHourAgo = getMillisecondAgoFormatDate(30 * 60 * 1000);
	// var timeRange=halfAnHourAgo + " - " + now;
	//
	// $("#reservationtime").val(timeRange);
	// //定义时间选择事件
	// $('#reservationtime').daterangepicker(
	// 		{
	// 			timePicker : true,
	// 			timePickerIncrement : 1,
	// 			format : 'YYYY/MM/DD HH:mm:ss'
	// 		},
	// 		function(start, end, label) {
	// 			timeRange=$("#reservationtime").val();
	// 			//初始化图表
	// 			var serverId=$("#defaultServerId").val();
	// 			chartInit(serverId, timeRange);
	// 		});
	// // 初始化图表
	// $.getJSON("/mysql/node/all", function(data) {
	// 	$.each(data, function(n, value) {
	// 		if (n == 0) {
	// 			chartInit(value.id, timeRange);
	// 		}
	// 		return;
	// 	});
	// });

});
// 初始化各图表数据
var chartInit = function(serverId, timeRange) {
	if(!serverId && serverId==''){
		notifi.error('请选择节点');
		return;
	}
	//开始加载数据，显示loading图标
	$("body").mLoading({
		mask : false
	//是否显示遮罩效果，默认显示
	});
	$.getJSON("/mysql/performance/monitor?server_id=" + serverId
			+ "&time_range=" + timeRange, function(json) {
		// 初始化QPS图表
		qpsChartInit(json);
		// 初始化线程图表
		threadsChartInit(json);
		// 初始化发送接受数据图表
		sentReceivedChartInit(json);
		// 初始化CURD操作图表
		curdChartInit(json);
		//初始化事务图表
		transactionChartInit(json);
		//innodb刷盘图表
		fsyncChartInit(json);
		//innodb脏页图表
		dirtyPageChartInit(json);
		//innodb DML图表
		dmlChartInit(json);
		//加载数据完毕关闭loading图标
		$("body").mLoading("hide");
	}).fail(function(){
		$("body").mLoading("hide");
	});
};

// //定义获取指定毫秒前的时间
// var getMillisecondAgoFormatDate = function(millisecond) {
// 	Date
// 	curDate = new Date();
// 	var date = new Date(curDate.getTime() - millisecond);
// 	var seperator1 = "/";
// 	var seperator2 = ":";
// 	var month = date.getMonth() + 1;
// 	var strDate = date.getDate();
// 	var strHours = date.getHours();
// 	var strMinutes = date.getMinutes();
// 	var strSeconds = date.getSeconds();
// 	if (month >= 1 && month <= 9) {
// 		month = "0" + month;
// 	}
// 	if (strDate >= 0 && strDate <= 9) {
// 		strDate = "0" + strDate;
// 	}
// 	if (strHours >= 0 && strHours <= 9) {
// 		strHours = "0" + strHours;
// 	}
// 	if (strMinutes >= 0 && strMinutes <= 9) {
// 		strMinutes = "0" + strMinutes;
// 	}
// 	if (strSeconds >= 0 && strSeconds <= 9) {
// 		strSeconds = "0" + strSeconds;
// 	}
// 	var currentdate = date.getFullYear() + seperator1 + month + seperator1
// 			+ strDate + " " + strHours + seperator2 + strMinutes + seperator2
// 			+ strSeconds;
// 	return currentdate;
// }
// //初始化节点
// var nodeInit=function(){
// 	$.getJSON("/mysql/node/all", function(data) {
// 		var li = "";
// 		$.each(data, function(n, value) {
// 			if (n == 0) {
// 				$("#defaultNode").text(value.tags);
// 				//保存当前serverId
// 				$("#defaultServerId").val(value.id);
// 			}
// 			li += "<li><a href='javascript:reloadChart(" + value.id
// 					+ ",\"" + value.tags + "\")'>" + value.tags
// 					+ "</a></li>";
// 		});
// 		if (li == "") {
// 			li = "<li><a href='javascript:void(0)'>暂未添加任何节点</a></li>";
// 		}
// 		$("#nodeUl").append(li);
// 	});
// }

//选择节点，刷新图表
var reloadChart=function(serverId, tags) {
	$("#defaultNode").text(tags);
	//保存当前serverId
	$("#defaultServerId").val(serverId);
	//获取当前时间区间
	var defaultTimeRange=$("#reservationtime").val();
	//初始化图表
	chartInit(serverId,defaultTimeRange);
}
