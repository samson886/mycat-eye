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
       });
   }

    // MYCAT节点列表
    var mycatNodes = $('#dataNodes');
    // MYSQL节点列表
    var mysqlNodes = $('#nodeUl');
    // MYSQL节点信息
    var currentMysql = $('#defaultNode');
    var nodes = getNodes();
    // 获取所有mysql节点列表
    if(mysqlNodes && mysqlNodes.length>0) {
        getMysqlList(mysqlNodes,function(){
            var c = mysqlNodes.find('li').eq(0);
            if(nodes.curMysql!=''){
                currentMysql.text(nodes['list']['mysql']['name']||'');
                currentMysql.attr('data-value',nodes['list']['mysql']['value']||'');
            }else{
                currentMysql.text(c.attr('data-name')||'暂无节点');
                currentMysql.attr('data-value',c.attr('data-value')||'');
                var n = nodes.list || {mysql: {name: '', value: ''}, mycat: {name: '', value: ''}};
                n.mysql.name = c.attr('data-name')||'暂无节点';
                n.mysql.value = c.attr('data-value')||'';
                window.sessionStorage.setItem('nodes',JSON.stringify(n));
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
            }
        });
    }
    // 获取所有mycat节点列表
    if (mycatNodes && mycatNodes.length>0) {
        getMycatList(mycatNodes,function(){
            mycatNodes.val(nodes.curMycat);
            doSearch();
        });
        mycatNodes.on('change', function (e) {
            var _this = $(this);
            //console.log($(this).val(),$(this).find(':selected').text());
            var n = nodes.list || {mysql: {name: '', value: ''}, mycat: {name: '', value: ''}};
            n.mycat.name = _this.find(':selected').text();
            n.mycat.value = _this.val();
            window.sessionStorage.setItem('nodes', JSON.stringify(n));
        });
    }
    // 绑定搜索按钮事件
    $('#btn-search').on('click', function(e){
        doSearch();
    });
    function doSearch(){
        var sid = $('#dataNodes').val();
        var tr = $('#reservationtime').val();
        if(sid && sid!=''){
            showMemory(sid,tr);
            showConnection(sid,tr);
            showBackend(sid,tr);
        }
    }

    // 初始化dataTable实例
    var tb1,tb2;
    // 内存分析
    function showMemory(sid,tr) {
        var mycatMemory = document.getElementById('mycat-memory');
        if (mycatMemory) {
            memoryChart = echarts.init(mycatMemory, 'light');
            var option = {
                title: {
                    text: ''
                },
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'cross',
                        label: {
                            backgroundColor: '#6a7985'
                        }
                    }
                },
                legend: {
                    type: 'scroll',
                    // bottom: '0%',
                    top: '3%',
                    // left: '3%',
                    data: ['TOTAL_MEMORY', 'USED_MEMORY', 'MAX_MEMORY']
                },
                toolbox: {
                    feature: {
                        saveAsImage: {}
                    }
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '6%',
                    containLabel: true
                },
                xAxis: [
                    {
                        // type: 'time',
                        type: 'category',
                        boundaryGap: false,
                        // data : ['周一','周二','周三','周四','周五','周六','周日']
                    }
                ],
                yAxis: [
                    {
                        type: 'value'
                    }
                ],
                series: [
                    {
                        name: 'TOTAL_MEMORY',
                        type: 'line',
                        stack: '总量',
                        label: {
                            normal: {
                                show: true,
                                position: 'top'
                            }
                        },
                        areaStyle: {normal: {opacity: 0.3}},
                        lineStyle: {normal: {width: 1}},
                        // data:[820, 932, 901, 934, 1290, 1330, 1320]
                    },
                    {
                        name: 'USED_MEMORY',
                        type: 'line',
                        stack: '总量',
                        areaStyle: {normal: {opacity: 0.3}},
                        lineStyle: {normal: {width: 1}},
                        // data:[320, 332, 301, 334, 390, 330, 320]
                    },
                    {
                        name: 'MAX_MEMORY',
                        type: 'line',
                        stack: '总量',
                        areaStyle: {normal: {opacity: 0.3}},
                        lineStyle: {normal: {width: 1}},
                        // data:[150, 232, 201, 154, 190, 330, 410]
                    }
                ]
            };
            $("body").mLoading({mask:false});
            $.get('/mycat/status/all?server_id=' + sid + '&timeRange=' + tr, function (res, status) {
                console.log(res, status)
                option.xAxis[0].data = res.data.xAxisData;
                option.series[0].data = res.data.seriesDatas.totalMemory;
                option.series[1].data = res.data.seriesDatas.useMemory;
                option.series[2].data = res.data.seriesDatas.maxMemory;
                memoryChart.setOption(option);
                $("body").mLoading("hide");
            }).fail(function(){
                $("body").mLoading("hide");
            });
        }
    }
    // 前端连接
    function showConnection(sid,tr) {
        if(tb1){
            tb1.destroy();
        }
        tb1 = $('#mycat-connection').DataTable({
            'oLanguage': dtb.oLanguage,
            'ajax': '/mycat/status/connection?server_id=' + sid + '&timeRange=' + tr,
            'columns':[
                { 'data':'id'},
                { 'data':'processor'},
                { 'data':'cHost'},
                { 'data':'cPort'},
                { 'data':'lPort'},
                { 'data':'netIn'},
                { 'data':'netOut'},
                { 'data':'aliveTime'},
                { 'data':'recvBuffer'},
                { 'data':'sendQueue'},
                { 'data':'txlevel'},
                { 'data':'autocommit'}
            ]
        });
    }
    // 后端连接
    function showBackend(sid,tr) {
        if (tb2) {
            tb2.destroy();
        }
        tb2 = $('#mycat-backend').DataTable({
            'oLanguage': dtb.oLanguage,
            'ajax': '/mycat/status/backend?server_id=' + sid + '&timeRange=' + tr,
            'columns': [
                { 'data': 'id' },
                { 'data': 'processor' },
                { 'data': 'mysqlid' },
                { 'data': 'cHost' },
                { 'data': 'cPort' },
                { 'data': 'lPort' },
                { 'data': 'netIn' },
                { 'data': 'netOut' },
                { 'data': 'life' },
                { 'data': 'closed' },
                { 'data': 'borrowed' },
                { 'data': 'sendQueue' },
                { 'data': 'cSchema' },
                { 'data': 'txlevel' },
                { 'data': 'autocommit' }
            ]
        });
    }

});
