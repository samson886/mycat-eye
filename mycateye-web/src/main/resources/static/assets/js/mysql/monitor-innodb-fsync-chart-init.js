var fsyncChartInit = function(json) {
	var xAxisDataFsync = [];
	var seriesFsync = [];
	// 基于准备好的dom，初始化echarts实例
	var fsyncChart = echarts.init(document.getElementById('fsyncChart'));
	var _xAxisDataFsync = json.xAxisData;
	var _seriesFsync = json.seriesDatas.fsync;

	// 一次将值填入数组
	for (var i = 0; i < _xAxisDataFsync.length; i++) {
		xAxisDataFsync.push(_xAxisDataFsync[i]);
		seriesFsync.push(_seriesFsync[i]);
	}
	// 指定图表的配置项和数据
	var optionFsync = {
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
			data : xAxisDataFsync
		} ],
		yAxis : [ {
			name : '每秒刷盘次数',
			type : 'value'
		} ],

		series : [ {
			name : 'Fsync',
			type : 'line',
			stack : '',
			smooth : true,
			data : seriesFsync
		} ]
	};
	fsyncChart.setOption(optionFsync);
}
