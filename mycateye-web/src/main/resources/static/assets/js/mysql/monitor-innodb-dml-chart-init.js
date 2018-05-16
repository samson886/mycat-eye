var dmlChartInit = function(json) {
	var xAxisDataDML = [];
	var seriesInsert = [];
	var seriesUpdate = [];
	var seriesDelete = [];
	// 基于准备好的dom，初始化echarts实例
	var dmlChart = echarts.init(document.getElementById('dmlChart'));
	var _xAxisDataDML = json.xAxisData;
	var _seriesInsert = json.seriesDatas.inserted;
	var _seriesUpdate = json.seriesDatas.updated;
	var _seriesDelete = json.seriesDatas.deleted;

	// 一次将值填入数组
	for (var i = 0; i < _xAxisDataDML.length; i++) {
		xAxisDataDML.push(_xAxisDataDML[i]);
		seriesInsert.push(_seriesInsert[i]);
		seriesUpdate.push(_seriesUpdate[i]);
		seriesDelete.push(_seriesDelete[i]);
	}
	// 指定图表的配置项和数据
	var optionDML = {
		legend : {
			data : [ 'Insert', 'Update', 'Delete'
					]
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
			data : xAxisDataDML
		} ],
		yAxis : [ {
			name : '操作数',
			type : 'value'
		} ],

		series : [ {
			name : 'Insert',
			type : 'line',
			stack : '',
			smooth : true,
			data : seriesInsert
		}, {
			name : 'Update',
			type : 'line',
			stack : '',
			smooth : true,
			data : seriesUpdate
		}, {
			name : 'Delete',
			type : 'line',
			stack : '',
			smooth : true,
			data : seriesDelete
		} ]
	};
	dmlChart.setOption(optionDML);
}
