var qpsChartInit = function(json) {
	var xAxisDataQps = [];
	var seriesQps = [];
	// 基于准备好的dom，初始化echarts实例
	var qpsChart = echarts.init(document.getElementById('qpsChart'));
	var _xAxisDataQps = json.xAxisData;
	var _seriesQps = json.seriesDatas.qps;

	// 一次将值填入数组
	for (var i = 0; i < _xAxisDataQps.length; i++) {
		xAxisDataQps.push(_xAxisDataQps[i]);
		seriesQps.push(_seriesQps[i]);
	}
	// 指定图表的配置项和数据
	var optionQps = {
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
			data : xAxisDataQps
		} ],
		yAxis : [ {
			name : '每秒请求数',
			type : 'value'
		} ],

		series : [ {
			name : 'QPS',
			type : 'line',
			stack : '',
			smooth : true,
			data : seriesQps
		} ]
	};
	qpsChart.setOption(optionQps);
}
