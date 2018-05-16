var threadsChartInit = function(json) {
	var xAxisDataThreads = [];
	var seriesThreadsRunning = [];
	var seriesThreadsConnected = [];
	// 基于准备好的dom，初始化echarts实例
	var threadsChart = echarts.init(document.getElementById('threadsChart'));
	var _xAxisDataThreads = json.xAxisData;
	var _seriesThreadsRunning = json.seriesDatas.threads_running;
	var _seriesThreadsConnected = json.seriesDatas.threads_connected;

	// 一次将值填入数组
	for (var i = 0; i < _xAxisDataThreads.length; i++) {
		xAxisDataThreads.push(_xAxisDataThreads[i]);
		seriesThreadsRunning.push(_seriesThreadsRunning[i]);
		seriesThreadsConnected.push(_seriesThreadsConnected[i]);
	}
	// 指定图表的配置项和数据
	var optionThreads = {
		legend : {
			data : [ 'ThreadsRunning', 'ThreadsConnected' ]
		},
		tooltip : {
			trigger : 'axis',
			axisPointer : {
				type : 'cross',
				animation : false,
				label : {
					backgroundColor : '#505765'
				}
			}
		},
		grid : {
			left : '5%',
			right : '4%',
			bottom : 80
		},
		xAxis : [ {
			type : 'category',
			boundaryGap : false,
			data : xAxisDataThreads
		} ],
		yAxis : [ {
			name : '线程数',
			type : 'value'
		} ],

		series : [ {
			name : 'ThreadsRunning',
			type : 'line',
			stack : '',
			smooth : true,
			data : seriesThreadsRunning
		}, {
			name : 'ThreadsConnected',
			type : 'line',
			stack : '',
			smooth : true,
			data : seriesThreadsConnected
		} ]
	};
	threadsChart.setOption(optionThreads);
}
