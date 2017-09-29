var sentReceivedChartInit = function(json) {
	var xAxisDataSendReceived = [];
	var seriesSend = [];
	var seriesReceived = [];
	// 基于准备好的dom，初始化echarts实例
	var sendReceivedChart = echarts.init(document
			.getElementById('sendReceivedChart'));
	var _xAxisDataSendReceived = json.xAxisData;
	var _seriesSend = json.seriesDatas.byte_send;
	var _seriesReceived = json.seriesDatas.byte_received;

	// 一次将值填入数组
	for (var i = 0; i < _xAxisDataSendReceived.length; i++) {
		xAxisDataSendReceived.push(_xAxisDataSendReceived[i]);
		seriesSend.push(_seriesSend[i]);
		seriesReceived.push(_seriesReceived[i]);
	}
	// 指定图表的配置项和数据
	var optionSendReceived = {
		legend : {
			data : [ 'Send', 'Received' ]
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
			data : xAxisDataSendReceived
		} ],
		yAxis : [ {
			name : '字节数',
			type : 'value'
		} ],

		series : [ {
			name : 'Send',
			type : 'line',
			stack : '',
			smooth : true,
			data : seriesSend
		}, {
			name : 'Received',
			type : 'line',
			stack : '',
			smooth : true,
			data : seriesReceived
		} ]
	};
	sendReceivedChart.setOption(optionSendReceived);
}
