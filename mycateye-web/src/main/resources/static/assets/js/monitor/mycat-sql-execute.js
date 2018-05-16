/**
 * Created by xqy on 18/5/14.
 */
$(function(){
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

    //
    $('#btn-search').on('click', function (e) {
        var $btn = $(this).button('loading')
        var sid = $('#dataNodes').val();
        var tr = $("#reservationtime").val();
        if(sid==''){
            notifi.warn('请选择服务节点！');
            $btn.button('reset');
            return;
        }
        if(tr==''){
            notifi.warn('请选择查询时间！');
            $btn.button('reset');
            return;
        }
        doSearch();
    });

    var table;
    function doSearch() {
        var sid = $('#dataNodes').val();
        var tr = $("#reservationtime").val();
        if(table){
            table.destroy();
        }
        table = $('#mycat-sql-execute').DataTable({
            'oLanguage': dtb.oLanguage,
            'ajax': '/mycat/sql/execute?server_id='+sid+'&timeRange='+tr,
            // "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
            // 'ajax': {
            //    'url':'/data/sql_execute.json',
            //    'dataSrc':''
            // },
            // 'columns': [
            //    { "data": "name" },
            //    { "data": "position" },
            //    { "data": "office" },
            //    { "data": "extn" },
            //    { "data": "start_date" },
            //    { "data": "salary" }
            // ]
            'columns': [
                {'data': 'sqlId'},
                {'data': 'sqlExecute'},
                {'data': 'sqlTime'},
                {'data': 'maxTime'},
                {'data': 'minTime'}
            ],
            'columnDefs': [
                {
                    'render': function(data,type,row){
                        // console.log(data,type,row['sqlId'])
                        return '<a href="monitor-mycat-sql-detail.html?server_id='+sid+'&sql_id='+(row['sqlId'] || '')+'&timeRange='+encodeURIComponent(tr)+'">查看详情</a>';
                    },
                    'targets': 5
                }
            ]
        });
        $('#btn-search').button('reset');
    }

});
