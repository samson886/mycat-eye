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
                currentMysql.attr('data-value',nodes['list']['mysql']['value'] || '');
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
        if (sid == '') {
            notifi.warn('请选择服务节点！');
            $btn.button('reset');
            return;
        }
        doSearch();
    });

    function doSearch(){
        var sid = $('#dataNodes').val();
        var tr = $("#reservationtime").val();
        if (sid == '') {
            notifi.warn('请选择服务节点！');
            return;
        }
        fetchSqlData(sid,tr);
        fetchSqlHighData(sid,tr);
        fetchSqlSlowData(sid,tr);
    }

    var table1,table2,table3;
    function fetchSqlData(sid,tr){
        $("body").mLoading({mask:false});
        $.get('/mycat/sql/all?server_id='+sid+'&timeRange='+tr).then(function(res){
            var data = res.data || [];
            if(table1){
                table1.destroy();
            }
            table1 = $('#tab1').find('table').DataTable({
                'oLanguage': dtb.oLanguage,
                'data': data,
                // 'ajax':'data/sql.json',
                'columns':[
                    {'data':'id'},
                    {'data':'cUser'},
                    {'data':'startTime'},
                    {'data':'executeTime'},
                    {'data':'cSql'}
                ]
            });
            $('#btn-search').button('reset');
            $("body").mLoading("hide");
        }).fail(function(){
            $('#btn-search').button('reset');
            $("body").mLoading("hide");
        });
    }
    function fetchSqlHighData(sid,tr){
        $("body").mLoading({mask:false});
        $.get('/mycat/sql/high?server_id='+sid+'&timeRange='+tr).then(function(res){
            $('#btn-search').button('reset');
            var data = res.data || [];
            if (table2) {
                table2.destroy();
            }
            table2 = $('#tab2').find('table').DataTable({
                'oLanguage': dtb.oLanguage,
                'data': data,
                // 'ajax': 'data/sql_high.json',
                'columns': [
                    { 'data': 'id' },
                    { 'data': 'cUser' },
                    { 'data': 'frequency' },
                    { 'data': 'avgTime' },
                    { 'data': 'maxTime' },
                    { 'data': 'minTime' },
                    { 'data': 'executeTime' },
                    { 'data': 'lastTime' },
                    { 'data': 'cSql' }
                ]
            });
            $("body").mLoading("hide");
        }).fail(function(){
            $('#btn-search').button('reset');
            $("body").mLoading("hide");
        });
    }
    function fetchSqlSlowData(sid,tr){
        $("body").mLoading({mask:false});
        $.get('/mycat/sql/slow?server_id='+sid+'&timeRange='+tr).then(function(res){
            $('#btn-search').button('reset');
            var data = res.data || [];
            if (table3) {
                table3.destroy();
            }
            table3 = $('#tab3').find('table').DataTable({
                'oLanguage': dtb.oLanguage,
                'data': data,
                // 'ajax': 'data/sql_slow.json',
                'columns': [
                    { 'data': 'cUser' },
                    { 'data': 'datasource' },
                    { 'data': 'startTime' },
                    { 'data': 'executeTime' },
                    { 'data': 'cSql' }
                ]
            });
            $("body").mLoading("hide");
        }).fail(function(){
            $('#btn-search').button('reset');
            $("body").mLoading("hide");
        });
    }

});
