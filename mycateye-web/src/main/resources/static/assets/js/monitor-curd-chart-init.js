var curdChartInit = function(json) {
	var xAxisDataCURD = [];
	var seriesInsert = [];
	var seriesUpdate = [];
	var seriesDelete = [];
	var seriesSelect = [];
	// 基于准备好的dom，初始化echarts实例
	var curdChart = echarts.init(document.getElementById('curdChart'));
	var _xAxisDataCURD = json.xAxisData;
	var _seriesInsert = json.seriesDatas.com_insert;
	var _seriesUpdate = json.seriesDatas.com_update;
	var _seriesDelete = json.seriesDatas.com_delete;
	var _seriesSelect = json.seriesDatas.com_select;

	// 一次将值填入数组
	for (var i = 0; i < _xAxisDataCURD.length; i++) {
		xAxisDataCURD.push(_xAxisDataCURD[i]);
		seriesInsert.push(_seriesInsert[i]);
		seriesUpdate.push(_seriesUpdate[i]);
		seriesDelete.push(_seriesDelete[i]);
		seriesSelect.push(_seriesSelect[i]);
	}
	// 指定图表的配置项和数据
	var optionCURD = {
		legend : {
			data : [ 'Insert', 'Update', 'Delete',
					'Select' ]
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
			data : xAxisDataCURD
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
		}, {
			name : 'Select',
			type : 'line',
			stack : '',
			smooth : true,
			data : seriesSelect
		} ]
	};
	curdChart.setOption(optionCURD);
}
