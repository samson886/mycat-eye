$(function() {

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
				reset(nodes['list']['mysql']['value']||'');
            }else{
                currentMysql.text(c.attr('data-name')||'暂无节点');
                currentMysql.attr('data-value',c.attr('data-value')||'');
                var n = nodes.list || {mysql: {name: '', value: ''}, mycat: {name: '', value: ''}};
                n.mysql.name = c.attr('data-name')||'暂无节点';
                n.mysql.value = c.attr('data-value')||'';
                window.sessionStorage.setItem('nodes',JSON.stringify(n));
				reset(value);
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
				reset(value);
            }
        });
    }


	// // 初始化节点列表
	// $.getJSON("/mysql/node/all", function(data) {
	// 	var li = "";
	// 	$.each(data, function(n, value) {
	// 		if (n == 0) {
	// 			$("#defaultNode").text(value.tags);
	// 			// 保存当前serverId
	// 			$("#defaultServerId").val(value.id);
	// 		}
	// 		li += "<li><a href='javascript:reset(" + value.id + ",\"" + value.tags + "\")'>"
	// 				+ value.tags + "</a></li>";
	// 	});
	// 	if (li == "") {
	// 		li = "<li><a href='javascript:void(0)'>暂未添加任何节点</a></li>";
	// 	}
	// 	$("#nodeUl").append(li);
	// });

	bsStep(0);
	// bsStep(i) i 为number 可定位到第几步 如bsStep(2)/bsStep(3)
	$("#btCheck").click(function() {
		// 获取当前serverId
		serverId = $("#defaultNode").attr('data-value')||'';
		// serverId = $("#defaultServerId").val();
		if(serverId==''){
			notifi.error('请选择mysql节点');
			return;
		}
		// 重置
		reset(serverId);

		// 安全检查
		checkSecurity(serverId);
		setTimeout("checkUserAccess(serverId)",1000)
		setTimeout("checkVariables(serverId)",2000)
		setTimeout("checkReplication(serverId)",3000)
		setTimeout("checkIndex(serverId)",4000)
		// 用户访问检查
		//checkUserAccess(serverId);

		// 参数检查
		//checkVariables(serverId);

		//复制检查
		//checkReplication(serverId);

		//索引检查
		//checkIndex(serverId);
	});
})


// 重新选择节点后，重置检查结果
var reset = function(id,tags) {
	if(id ==''){
		notifi.error('error');
		return;
	}
	// 保存当前serverId
	// $("#defaultServerId").val(id);
	// $("#defaultNode").text(tags);
	bsStep(0);
	$("#li_super_priv").removeClass();
	$("#li_super_priv").addClass("list-group-item");
	$("#span_super_priv").empty();

	$("#li_weak_password").removeClass();
	$("#li_weak_password").addClass("list-group-item");
	$("#span_weak_password").empty();

	$("#li_lock_wait").removeClass();
	$("#li_lock_wait").addClass("list-group-item");
	$("#span_lock_wait").empty();

	$("#li_transaction").removeClass();
	$("#li_transaction").addClass("list-group-item");
	$("#span_transaction").empty();

	$("#li_slow").removeClass();
	$("#li_slow").addClass("list-group-item");
	$("#span_slow").empty();

	$("#li_charset").removeClass();
	$("#li_charset").addClass("list-group-item");
	$("#span_charset").empty();

	$("#li_slave_io_running").removeClass();
	$("#li_slave_io_running").addClass("list-group-item");
	$("#span_slave_io_running").empty();

	$("#li_slave_sql_running").removeClass();
	$("#li_slave_sql_running").addClass("list-group-item");
	$("#span_slave_sql_running").empty();

	$("#li_seconds_behind_master").removeClass();
	$("#li_seconds_behind_master").addClass("list-group-item");
	$("#span_seconds_behind_master").empty();

	$("#li_unused_index").removeClass();
	$("#li_unused_index").addClass("list-group-item");
	$("#span_unused_index").empty();

	$("#li_primary_key").removeClass();
	$("#li_primary_key").addClass("list-group-item");
	$("#span_primary_key").empty();

	$("#li_index_cardinality").removeClass();
	$("#li_index_cardinality").addClass("list-group-item");
	$("#span_index_cardinality").empty();

	$("#li_redundant_index").removeClass();
	$("#li_redundant_index").addClass("list-group-item");
	$("#span_redundant_index").empty();
}
