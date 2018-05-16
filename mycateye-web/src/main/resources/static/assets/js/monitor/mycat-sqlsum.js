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
         fetchUserData(sid,tr);
         fetchTableData(sid,tr);
     }

     //
     var table1,table2;
     function fetchUserData(sid,tr){
         $("body").mLoading({mask:false});
         $.ajax({
             url: '/mycat/sql/sum/user?server_id='+sid,
             method: 'GET',
             dataType: 'json',
             success: function (res,textStatus) {
                 // console.log(res.data, textStatus);
                 $('#btn-search').button('reset');
                 var data = res.data || [];
                 if (res.code == 200) {
                     if(table1){
                         table1.destroy();
                     }
                     table1 = $('#tab1').find('table').DataTable({
                         'oLanguage': dtb.oLanguage,
                         // 'ajax':'/mycat/sql/sum/user?server_id='+server_id,
                         //'ajax':'data/sql_sum_user.json',
                         data: data,
                         'columns': [
                             {'data': 'id'},
                             {'data': 'cUser'},
                             {'data': 'sqlMax'},
                             {'data': 'netIn'},
                             {'data': 'netOut'}
                         ],
                         'columnDefs': [
                             {
                                 'render': function (data, type, row) {
                                     return '<span class="sparklines sparklines-pie" sparkType="pie" width="42px" height="42px" id="pie1-'+row['sid']+'"><!-- ' + row['r'] + ',' + row['w'] + ' --></span>';
                                 },
                                 'targets': 5
                             },
                             {
                                 'render': function (data, type, row) {
                                     var tc = row['timeCount'].replace(' ', '');
                                     return '<span class="sparklines sparklines-bar" sparkType="bar" width="122px" height="42px" id="bar-'+row['sid']+'"><!-- ' + tc + ' --></span>';
                                 },
                                 'targets': 6
                             },
                             {
                                 'render': function (data, type, row) {
                                     var ttl = row['ttlCount'].replace(' ', '');
                                     return '<span class="sparklines sparklines-bar" sparkType="bar" width="122px" height="42px"><!-- ' + ttl + ' --></span>';
                                 },
                                 'targets': 7
                             },
                             {
                                 'render': function (data, type, row) {
                                     //console.log(data,type,row['lastTime'])
                                     return row['lastTime'] + '';
                                 },
                                 'targets': 8
                             }
                         ]
                     });
                     drawTable1(data,table1);
                 }
                 $("body").mLoading("hide");
             },
             error: function (jqXhr,status) {
                 console.log('err',jqXhr,status);
                 $('#btn-search').button('reset');
                 $("body").mLoading("hide");
             }
         });
     }
     //
     function fetchTableData(sid,tr){
         $("body").mLoading({mask:false});
         $.ajax({
             url: '/mycat/sql/sum/table?server_id='+sid,
             method: 'GET',
             dataType: 'json',
             success: function (res,textStatus) {
                 // console.log(res.data,textStatus);
                 $('#btn-search').button('reset');
                 var data = res.data || [];
                 if(res.code == 200){
                     if(table2){
                         table2.destroy();
                     }
                     table2 = $('#tab2').find('table').DataTable({
                         'oLanguage': dtb.oLanguage,
                         //'ajax':'/mycat/sql/sum/table?server_id='+server_id,
                         //'ajax':'data/sql_sum_table.json',
                         data: data,
                         'columns':[
                             {'data':'id'},
                             {'data':'sqlTable'}
                         ],
                         'columnDefs': [
                             {
                                 'render': function(data,type,row){
                                     return '<span class="sparklines sparklines-pie" sparkType="pie" width="42px" height="42px" id="pie2-'+row['sid']+'"><!-- '+row['r']+','+row['w']+' --></span>';
                                 },
                                 'targets': 2
                             },
                             {
                                 'render': function(data,type,row){
                                     return row['lastTime']+'';
                                 },
                                 'targets': 3
                             },
                             {
                                 'render': function(data,type,row){
                                     return row['relatable']+'';
                                 },
                                 'targets': 4
                             },
                             {
                                 'render': function(data,type,row){
                                     return row['relacount']+'';
                                 },
                                 'targets': 5
                             }
                         ]
                     });
                     drawTable2(data,table2);
                 }
                 $("body").mLoading("hide");
             },
             error: function (jqXhr,status) {
                 console.log('err',jqXhr,status);
                 $('#btn-search').button('reset');
                 $("body").mLoading("hide");
             }
         });
     }
     //
     function drawTable1() {
         $('#tab1').find('.sparklines-pie').each(function (e) {
             _this = $(this);
             var isSpark = _this.attr('data-spark');
             if(!isSpark) {
                 _this.sparkline('html', {
                     width: '42px',
                     height: '42px',
                     sliceColors: ['#5ca0a7', '#d78169', '#53656f'],
                     enableTagOptions: true
                 });
                 _this.attr('data-spark','1');
             }
         });
         $('#tab1').find('.sparklines-bar').each(function (e) {
             _this = $(this);
             var isSpark = _this.attr('data-spark');
             if(!isSpark) {
                 _this.sparkline('html', {
                     widht: '100px',
                     height: '60px',
                     barWidth: '10px',
                     barColor: '#5ca0a7',
                     enableTagOptions: true
                 });
                 _this.attr('data-spark','1');
             }
         });
     }
     function drawTable2() {
         $('#tab2').find('.sparklines-pie').each(function (e) {
             _this = $(this);
             var isSpark = _this.attr('data-spark');
             console.log(!isSpark);
             if(!isSpark) {
                 _this.sparkline('html', {
                     width: '42px',
                     height: '42px',
                     sliceColors: ['#5ca0a7', '#d78169', '#53656f'],
                     enableTagOptions: true
                 });
                 _this.attr('data-spark','1');
             }
         });
     }
     $('#tab1').find('table').on('page.dt', function () {
         console.log('User redraw',table1.page.info());
         setTimeout(function(){drawTable1();},300);
     });
     $('#tab2').find('table').on('page.dt', function () {
         console.log('Table redraw' );
         setTimeout(function(){drawTable2();},300);
     });

 });
