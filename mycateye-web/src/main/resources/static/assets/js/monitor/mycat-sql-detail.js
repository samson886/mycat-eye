/**
 * Created by xqy on 18/5/14.
 */
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

     var sql_id = getParameter('sql_id'),
        sid = getParameter('server_id'),
        tr = getParameter('timeRange'),
        backurl = 'monitor-mycat-sql-execute.html',
        backparam='';

    if(sid){
        backparam += '&server_id='+sid;
    }
    if(tr){
        //tr = decodeURIComponent(tr);
        backparam += '&timeRange='+tr;
    }
    if(backparam!='') {
        backparam = '?'+backparam.slice(1);
    }
    $('#prevPage').attr('href',backurl+backparam);

    var mycatTable = $('#mycat-sql-execute');
    if(mycatTable && mycatTable.length>0){
        var table = mycatTable.DataTable({
            'oLanguage': dtb.oLanguage,
            'ajax': '/mycat/sql/detail?server_id='+sid+'&sql_id='+sql_id,
            'columns': [
                {'data': 'dataSource'},
                {'data': 'execute'},
                {'data': 'time'},
                {'data': 'lastExecuteTimestamp'},
                {'data': 'lastTime'}
            ]
        });
    }

 });
