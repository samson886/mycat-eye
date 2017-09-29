//定义拓扑图需要的元素
var nodeIds, shadowState, nodesArray, nodes, edgesArray, edges, network;

$(function($) {
	//获取agent地址
	$.get("agent-url", function(agentUrl) {
		// 获取所有集群信息
		$.getJSON(agentUrl + "/mysql/cluster/all", function(data) {
			var li = "";
			$.each(data, function(n, value) {
				if (n == 0) {
					$("#defaultCluster").text(value.name);
					// 保存当前clusterId
					$("#defaultClusterId").val(value.id);
				}
				li += "<li><a href='javascript:reloadNetWork(" + value.id
						+ ",\"" + value.name + "\")'>" + value.name
						+ "</a></li>";
			});
			if (li == "") {
				li = "<li><a href='javascript:void(0)'>暂未添加任何节点</a></li>";
			}
			$("#clusterUl").append(li);
			clusterId = $("#defaultClusterId").val();
			loadClusterNetwork(agentUrl, clusterId);
		});
	});
});
// 显示当前集群的拓扑结构
var loadClusterNetwork = function(agentUrl, clusterId) {
	// 开始加载数据，显示loading图标
	$("body").mLoading({
		mask : false
	// 是否显示遮罩效果，默认显示
	});
	$.getJSON(agentUrl + "/mysql/cluster/network", {
		clusterId : clusterId
	}, function(data) {
		var mysqlServers = data.mysqlServers;
		var DIR = '/assets/img/';
		nodesArray = [];
		$.each(mysqlServers, function(n, value) {
			label = value.tags;
			nodesArray.push({
				id : value.id,
				label : label,
				image : DIR + 'mysql.png',
				shape : 'image',
				physics : false
			});
		});
		edgesArray = [];
		var relations = data.relations;
		$.each(relations, function(n, value) {
			label = "Slave_IO_Running:" + value.slaveStatus.slaveIORunning
					+ "\nSlave_SQL_Running:"
					+ value.slaveStatus.slaveSQLRunning + "\ndelay:"
					+ value.slaveStatus.secondsBehindMaster;
			edgesArray.push({
				from : value.from.id,
				to : value.to.id,
				label : label,
				font : {
					align : 'left'
				},
				arrows : 'to',
				dashes : true
			});
		});

		startNetwork();
		// 加载数据完毕关闭loading图标
		$("body").mLoading("hide");
	});
}
//构建拓扑图
function startNetwork() {
	shadowState = false;
	nodes = new vis.DataSet(nodesArray);
	edges = new vis.DataSet(edgesArray);

	var container = document.getElementById('mynetwork');
	var data = {
		nodes : nodes,
		edges : edges
	};
	var options = {
		layout : {
			hierarchical : {
				direction : "UD",
				sortMethod : "directed",
				levelSeparation : 300,
				nodeSpacing : 300
			}
		},
		interaction : {
			dragNodes : true,
			zoomView:false
		},
		physics : {
			enabled : true
		}
	};
	network = new vis.Network(container, data, options);
	//双击节点，展示节点详细信息
	network.on(
					"doubleClick",
					function(params) {
						params.event = "[original event]";
						if(params.nodes[0]!=undefined){
							showNodeDetails(params.nodes[0]);
						}
			});
}

var reloadNetWork=function(clusterId,clusterName){
	$("#defaultCluster").text(clusterName);
	$("#defaultClusterId").val(clusterId);
	//获取agent地址
	$.get("agent-url", function(agentUrl) {
		loadClusterNetwork(agentUrl, clusterId);
	});
}
