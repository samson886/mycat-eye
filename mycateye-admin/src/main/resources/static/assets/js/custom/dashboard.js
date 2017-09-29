$(function($) {
    var serverId = window.localStorage.getItem("currentServerId");
    if(serverId!=null){
		//初始化控制台概要数据
        fnDashboardOverviewInit(serverId);
        //初始化当前进程列表
        fnShowProcesslistInit(serverId);
	}


	//刷新当前进程
	$("#reload").click(function() {
		$('#processlist').DataTable().destroy();
		fnShowProcesslistInit(serverId);
	});
});

//初始化控制台概要数据
var fnDashboardOverviewInit = function(serverId) {
	var ajaxUrl = ajaxHost + "agent/dashboard/" + serverId + "/dashboard-overview";
	$.getJSON(ajaxUrl, function(json) {
		$("#uptime").text(json.uptime);
		$("#threadsRunning").text(json.threadsRunning);
		$("#dataTotal").text(json.dataTotal);
		$("#innoDBBufferPoolSize").text(json.innoDBBufferPoolSize);
		$("#bytesReceived").text(json.bytesReceived);
		$("#bytesSent").text(json.bytesSent);
		$("#schemaTotal").text(json.schemaTotal);
		$("#tableTotal").text(json.tableTotal);
		$("#tableTotal").text(json.tableTotal);
		//加载QPS数据图表
		fnLoadQPSChartData(json.qpsChartData);
		//加载查询统计数据图表
		fnLoadQueryChatData(json.queryChartData);
	});
}
//初始化当前进程列表
var fnShowProcesslistInit = function(serverId) {
	var ajaxUrl = ajaxHost + "agent/dashboard/" + serverId + "/processlist";
	var table = $('#processlist')
		.DataTable({
			"bLengthChange": false,
			"bFilter": true,
			"bSort": false,
			"serverSide": false,
			"iDisplayLength": 20,
			"pagingType": "simple",
			"oLanguage": {
				"sLengthMenu": "每页显示 _MENU_ 条记录",
				"sZeroRecords": "对不起，查询不到任何相关数据",
				"sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
				"sInfoEmtpy": "找不到相关数据",
				"sInfoFiltered": "数据表中共为 _MAX_ 条记录)",
				"sSearch": "搜索",
				"oPaginate": {
					"sFirst": "第一页",
					"sPrevious": " 上一页 ",
					"sNext": " 下一页 ",
					"sLast": " 最后一页 "
				}

			},
			"ajax": ajaxUrl,
			"columns": [{
				"data": "id"
			}, {
				"data": "user"
			}, {
				"data": "host"
			}, {
				"data": "db"
			}, {
				"data": "command"
			}, {
				"data": "time"
			}, {
				"data": "state"
			}, {
				"data": "info"
			}]
		});
}

// 加载QPS数据图表
var fnLoadQPSChartData = function(qpsChartData) {

	var xAxisDataQps = [];
	var seriesQps = [];
	// 基于准备好的dom，初始化echarts实例
	fnSetChartWidth(document.getElementById('qpsChart'));
	var qpsChart = echarts.init(document.getElementById('qpsChart'));
	var _xAxisDataQps = qpsChartData.xAxisData;
	var _seriesQps = qpsChartData.seriesData;

	// 一次将值填入数组
	for(var i = 0; i < _xAxisDataQps.length; i++) {
		xAxisDataQps.push(_xAxisDataQps[i]);
		seriesQps.push(_seriesQps[i]);
	}
	// 指定图表的配置项和数据
	var optionQps = {
		tooltip: {
			trigger: 'axis',
			axisPointer: {
				type: 'cross',
				animation: false,
				label: {
					backgroundColor: '#505765'
				}
			}
		},
		grid: {
			left: '5%',
			right: '4%',
			bottom: 80
		},
		xAxis: [{
			type: 'category',
			boundaryGap: false,
			data: xAxisDataQps
		}],
		yAxis: [{
			name: '每秒请求数',
			type: 'value'
		}],

		series: [{
			smooth: true,
			symbol: 'none',
			itemStyle: {
				normal: {
					areaStyle: {
						color: '#A6D1F0',
						type: 'default'
					}
				}
			},
			name: 'QPS',
			type: 'line',
			stack: '',
			data: seriesQps
		}]
	};
	qpsChart.setOption(optionQps);
};
//加载查询统计图表数据
var fnLoadQueryChatData = function(queryChartData) {
	var xAxisDataQuery = [];
	var seriesQuery = [];
	// 基于准备好的dom，初始化echarts实例
	var _xAxisDataQuery = queryChartData.xAxisData;
	var _seriesQuery = queryChartData.seriesData;

	// 一次将值填入数组
	for(var i = 0; i < _xAxisDataQuery.length; i++) {
		xAxisDataQuery.push(_xAxisDataQuery[i]);
		seriesQuery.push(_seriesQuery[i]);
	}

	option = {
		tooltip: {},
		xAxis: {
			data: xAxisDataQuery,
			silent: false,
			splitLine: {
				show: false
			}
		},
		yAxis: {},
		series: [{
			itemStyle: {
				normal: {
					color: '#188df0'
				}
			},
			name: '执行总数',
			type: 'bar',
			data: seriesQuery,
			animationDelay: function(idx) {
				return idx * 10;
			}
		}],
		animationEasing: 'elasticOut',
		animationDelayUpdate: function(idx) {
			return idx * 5;
		}
	};
	fnSetChartWidth(document.getElementById('queryChart'));
	var myChart = echarts.init(document.getElementById('queryChart'));
	
	myChart.setOption(option);
}
//设置图表宽度
var fnSetChartWidth=function(obj){
	obj.style.width=window.localStorage.getItem("chartWidth");
}
