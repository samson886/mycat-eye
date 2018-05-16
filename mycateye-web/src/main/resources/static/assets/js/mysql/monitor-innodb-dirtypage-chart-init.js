var dirtyPageChartInit = function(json) {
	var xAxisDataDirtyPage = [];
	var seriesGenerate = [];
	var seriesRefresh = [];
	// 基于准备好的dom，初始化echarts实例
	var dirtyPageChart = echarts.init(document
			.getElementById('dirtyPageChart'));
	var _xAxisDataDirtyPage = json.xAxisData;
	var _seriesGenerate = json.seriesDatas.dirty;
	var _seriesRefresh = json.seriesDatas.flushed;

	// 一次将值填入数组
	for (var i = 0; i < _xAxisDataDirtyPage.length; i++) {
		xAxisDataDirtyPage.push(_xAxisDataDirtyPage[i]);
		seriesGenerate.push(_seriesGenerate[i]);
		seriesRefresh.push(_seriesRefresh[i]);
	}
	// 指定图表的配置项和数据
	var optionDirtyPage = {
		legend : {
			data : [ '生成', '已刷新' ]
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
			data : xAxisDataDirtyPage
		} ],
		yAxis : [ {
			name : '页数',
			type : 'value'
		} ],

		series : [ {
			name : '生成',
			type : 'line',
			stack : '',
			smooth : true,
			data : seriesGenerate
		}, {
			name : '已刷新',
			type : 'line',
			stack : '',
			smooth : true,
			data : seriesRefresh
		} ]
	};
	dirtyPageChart.setOption(optionDirtyPage);
}
