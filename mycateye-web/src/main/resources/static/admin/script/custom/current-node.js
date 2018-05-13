var ajaxUrlPrefix="";
$(function($){
	var currentMysql = $('#currentServerId');
	var currentMycat = $('#mycat_server');
	var currentNodes = window.sessionStorage.getItem('nodes');
	var curMysql='',curMycat='';
	if(currentNodes){
		try{
			currentNodes = JSON.parse(currentNodes);
			curMysql = currentNodes['mysql']?currentNodes['mysql']['value']||'':'';
			curMycat = currentNodes['mycat']?currentNodes['mycat']['value']||'':'';
			currentMysql.text(currentNodes['mysql']?currentNodes['mysql']['name']||'':'');
			currentMysql.attr('data-value',curMysql);
			currentMycat.text(currentNodes['mycat']?currentNodes['mycat']['name']||'':'');
			currentMycat.attr('data-value',curMycat);
		}catch(e){
			console.log(currentNodes);
			currentNodes = null;
		}
	}
	//获取agent地址
	//$.get("/agent-url", function(data) {
		//ajaxUrlPrefix=data;
		//加载当前节点
		fnLoadCurrentNode(curMysql,curMycat);
	//});
	var mycat = $('#mycat_server');
	var mysql = $('#currentServerId');
	var nodes = currentNodes || {mysql:{name:'',value:''},mycat:{name:'',value:''}};
	$('#ulMycatList').on('click','li',function(e){
		var _this = $(this);
		if(!_this.hasClass('active')){
			$('#ulMycatList').find('li').removeClass('active');
			_this.addClass('active');
			mycat.text(_this.attr('data-name'));
			mycat.attr('data-value',_this.attr('data-value'));
			nodes.mycat.name = _this.attr('data-name');
			nodes.mycat.value = _this.attr('data-value');
			window.sessionStorage.setItem('nodes',JSON.stringify(nodes));
		}
	});
	$('#ulNodeList').on('click','li',function(e){
		var _this = $(this);
		if(!_this.hasClass('active')){
			$('#ulNodeList').find('li').removeClass('active');
			_this.addClass('active');
			mysql.text(_this.attr('data-name'));
			mysql.attr('data-value',_this.attr('data-value'));
			nodes.mysql.name = _this.attr('data-name');
			nodes.mysql.value = _this.attr('data-value');
			window.sessionStorage.setItem('nodes',JSON.stringify(nodes));
		}
	});
});
//加载当前节点
var fnLoadCurrentNode = function(curMysql,curMycat) {
	var currentMysql = $('#currentServerId');
	var currentMycat = $('#mycat_server');

	$.get('/mysql/node/all').then(function(res){
		var data = res || [];
		var html = ['<li class="dropdown-item" data-name="无节点" data-value=""><a href="javascript:void(0);">无节点</a></li>'];
		for(var i=0;i<data.length;i++){
			html.push('<li class="dropdown-item'+(curMysql==data[i]['id']?' active"':'"')+' data-name="'+data[i]['host']+'-'+data[i]['port']+'" data-value="'+data[i]['id']+'"><a href="javascript:void(0);">'+data[i]['host']+'-'+data[i]['port']+'</a></li>');
		}
		$('#ulNodeList').html(html.join(''));
	});

	$.get('/mycat/server/list').then(function(res){
		var data = res.data || [];
		var html = ['<li class="dropdown-item" data-name="无节点" data-value=""><a href="javascript:void(0);">无节点</a></li>'];
		for(var i=0;i<data.length;i++){
			html.push('<li class="dropdown-item'+(curMycat==data[i]['id']?' active"':'"')+' data-name="'+data[i]['serverName']+'" data-value="'+data[i]['id']+'"><a href="javascript:void(0);">'+data[i]['serverName']+'</a></li>');
		}
		$('#ulMycatList').html(html.join(''));
	});

	// var ajaxUrl = ajaxUrlPrefix + "/mysql/node/list";
	// $.getJSON(ajaxUrl, {
	// 	draw: 1,
	// 	start: 0,
	// 	length: 100
	// }, function(json) {
	// 	//如果页面session中保存有节点，则将当前节点设置为该节点
	// 	var currentServerTags = window.localStorage.getItem("currentServerTags");
	// 	if(currentServerTags != null) {
	// 		$("#currentServerId").text(currentServerTags);
	// 	}
	// 	else{
	// 		$("#currentServerId").text("");
	// 	}
	// 	var ulNodeList = $("#ulNodeList");
	// 	$.each(json.data, function(n, item) {
	// 		//如果页面session中没有节点，则将第一个节点作为默认节点
	// 		if(n == 0 && ($("#currentServerId").text() == "")) {
	// 			var id = item.mysqlServer.id;
	// 			var tags = item.mysqlServer.tags;
	// 			$("#currentServerId").text(tags);
	// 			window.localStorage.setItem("currentServerId", id);
	// 			window.localStorage.setItem("currentServerTags", tags);
	// 		}
	// 		var html = "";
	// 		html += "<li>";
	// 		html += "<a href=\"javascript:fnSelectNode('" + item.mysqlServer.id + "','" + item.mysqlServer.tags + "')\">" + item.mysqlServer.tags + "</a>";
	// 		html += "</li>";
	// 		ulNodeList.append(html);
	// 	});
	// });
}
//选择节点
var fnSelectNode = function(id, tags) {
	window.localStorage.setItem("currentServerId", id);
	window.localStorage.setItem("currentServerTags", tags);
	$("#currentServerId").text(tags);
	$(location).attr('href', 'index.html');
}
