(function ($,global) {
    var mycatNodes = $('#dataNodes');
    var currentMysql = $('#defaultNode');
    var currentNodes = window.sessionStorage.getItem('nodes');
    var curMysql='',curMycat='';
    if(currentNodes){
        try{
            currentNodes = JSON.parse(currentNodes);
            curMysql = currentNodes['mysql']?currentNodes['mysql']['value']||'':'';
            curMycat = currentNodes['mycat']?currentNodes['mycat']['value']||'':'';
            currentMysql.text(currentNodes['mysql']?currentNodes['mysql']['name']||'':'');
            currentMysql.attr('data-value',curMysql);
            //mycatNodes.val(curMycat);
        }catch(e){
            console.log(currentNodes);
            currentNodes = null;
        }
    }
    if(mycatNodes){
        $.get('/mycat/server/list',function(res){
            var data = res.data || [];
            var html = ['<option value="">请选择mycat节点</option>'];
            for(var i=0;i<data.length;i++){
                html.push('<option value="'+data[i]['id']+'">'+data[i]['serverName']+'</option>');
            }
            mycatNodes.html(html.join(''));
            mycatNodes.val(curMycat);
        });
        mycatNodes.on('change',function(e){
            var _this = $(this);
            //console.log($(this).val(),$(this).find(':selected').text());
            var n = currentNodes || {mysql:{name:'',value:''},mycat:{name:'',value:''}};
            n.mycat.name = _this.find(':selected').text();
            n.mycat.value = _this.val();
            window.sessionStorage.setItem('nodes',JSON.stringify(n));
        });
    }

    // 初始化节点列表
    $.getJSON("/mysql/node/all", function(data) {
        var li = "";
        var d = data || [];
        if(d.length>0){
            $.each(data, function(n, value) {
                if (curMycat == '' && n == 0) {
                    $("#defaultNode").text(value.tags);
                    // 保存当前serverId
                    $("#defaultServerId").val(value.id);
                    // 保存sql详细数据到本地
                    saveSqlDataLocalStorage(value.id);
                }
                li += "<li><a href='javascript:reloadChart(" + value.id + ",\""
                    + value.tags + "\")'>" + value.tags + "</a></li>";
            });
        }
        if (li == "") {
            li = "<li><a href='javascript:void(0)'>暂未添加任何节点</a></li>";
        }
        $("#nodeUl").append(li);
    });


    // 保存sql详细数据到本地
    var saveSqlDataLocalStorage = function(serverId) {
        // 将sql语句详细数据保存到html5本地
        $.getJSON("/mysql/statement/getAllSqlStatement?server_id=" + serverId
            + "&limit=100&offset=0&key=last_seen&order=desc", function(json) {
            $.each(json.data, function(index, content) {
                window.localStorage.setItem(content.digest, JSON.stringify(content));
            });
        });
    };


    function showMemory() {
        var mycatMemory = document.getElementById('mycat-memory');
        if(mycatMemory){
            var sid = $('#dataNodes').val();
            var tr = $('#reservationtime').val();
            memoryChart = echarts.init(mycatMemory,'light');
            var option = {
                title: {
                    text: ''
                },
                tooltip : {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'cross',
                        label: {
                            backgroundColor: '#6a7985'
                        }
                    }
                },
                legend: {
                    type:'scroll',
                    // bottom: '0%',
                    top: '3%',
                    // left: '3%',
                    data:['TOTAL_MEMORY','USED_MEMORY','MAX_MEMORY']
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
                xAxis : [
                    {
                        // type: 'time',
                        type: 'category',
                        boundaryGap : false,
                        // data : ['周一','周二','周三','周四','周五','周六','周日']
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:'TOTAL_MEMORY',
                        type:'line',
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
                        name:'USED_MEMORY',
                        type:'line',
                        stack: '总量',
                        areaStyle: {normal: {opacity: 0.3}},
                        lineStyle: {normal: {width: 1}},
                        // data:[320, 332, 301, 334, 390, 330, 320]
                    },
                    {
                        name:'MAX_MEMORY',
                        type:'line',
                        stack: '总量',
                        areaStyle: {normal: {opacity: 0.3}},
                        lineStyle: {normal: {width: 1}},
                        // data:[150, 232, 201, 154, 190, 330, 410]
                    }
                ]
            };
            $.get('/mycat/status/all?server_id='+sid+'&timeRange='+tr, function(res,status) {
                console.log(res,status)
                option.xAxis[0].data = res.data.xAxisData;
                option.series[0].data = res.data.seriesDatas.totalMemory;
                option.series[1].data = res.data.seriesDatas.useMemory;
                option.series[2].data = res.data.seriesDatas.maxMemory;
                memoryChart.setOption(option);
            });
            // console.log(option,echarts)
            // $.get('data.json').done(function (data) {
            //     // 填入数据
            //     myChart.setOption({
            //         xAxis: {
            //             data: data.categories
            //         },
            //         series: [{
            //             // 根据名字对应到相应的系列
            //             name: 'SERIAL_NAME',
            //             data: data.data
            //         }]
            //     });
            // });
        }
    }

    var mycatEye = global.mycatEye || {};
    mycatEye.showMemory = mycatEye.showMemory || showMemory;
    // mycatEye.showConnection = mycatEye.showConnection || showConnection;
    // mycatEye.showBackend = mycatEye.showBackend || showBackend;
    global.mycatEye = mycatEye;

})(jQuery,window,undefined);
