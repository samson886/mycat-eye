var transactionChartInit = function(json) {
	var xAxisDataTransaction = [];
	var seriesCommit = [];
	var seriesRollback = [];
	// 基于准备好的dom，初始化echarts实例
	var transactionChart = echarts.init(document
			.getElementById('transactionChart'));
	var _xAxisDataTransaction = json.xAxisData;
	var _seriesCommit = json.seriesDatas.com_commit;
	var _seriesRollback = json.seriesDatas.com_rollback;

	// 一次将值填入数组
	for (var i = 0; i < _xAxisDataTransaction.length; i++) {
		xAxisDataTransaction.push(_xAxisDataTransaction[i]);
		seriesCommit.push(_seriesCommit[i]);
		seriesRollback.push(_seriesRollback[i]);
	}
	// 指定图表的配置项和数据
	var optionTransaction = {
		legend : {
			data : [ 'Commit', 'Rollback' ]
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
			data : xAxisDataTransaction
		} ],
		yAxis : [ {
			name : '执行次数',
			type : 'value'
		} ],

		series : [ {
			name : 'Commit',
			type : 'line',
			stack : '',
			smooth : true,
			data : seriesCommit
		}, {
			name : 'Rollback',
			type : 'line',
			stack : '',
			smooth : true,
			data : seriesRollback
		} ]
	};
	transactionChart.setOption(optionTransaction);
}
