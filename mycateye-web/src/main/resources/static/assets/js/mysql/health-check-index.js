// 索引检查
var checkIndex = function(serverId) {
	bsStep(5);
	// 无用索引检查
	unusedIndexClassIsLoading();
	$.getJSON(
					globalAgentUrl + "/health-check/unused-index/" + serverId,
					function(json) {
						$("#span_unused_index").empty();
						if (json.code == "200") {
							unusedIndexClassIsDanger(serverId);
						} else {
							unusedIndexClassIsOK();
						}
					});
	// 主键检查
	primaryKeyClassIsLoading();
	$.getJSON(
					globalAgentUrl + "/health-check/no-primary-key/" + serverId,
					function(json) {
						$("#span_primary_key").empty();
						if (json.code == "200") {
							primaryKeyClassIsDanger(serverId);
						} else {
							primaryKeyClassIsOK();
						}
					});
	// 索引区分度检查
	indexCardinalityClassIsLoading();
	$.getJSON(
					globalAgentUrl + "/health-check/index-cardinality/" + serverId,
					function(json) {
						$("#span_index_cardinality").empty();
						if (json.code == "200") {
							indexCardinalityClassIsDanger(serverId);
						} else {
							indexCardinalityClassIsOK();
						}
					});
	// 冗余检查
	redundantIndexClassIsLoading();
	$.getJSON(
					globalAgentUrl + "/health-check/index-cardinality/" + serverId,
					function(json) {
						$("#span_redundant_index").empty();
						if (json.code == "200") {
							redundantIndexClassIsDanger(serverId);
						} else {
							redundantIndexClassIsOK();
						}
					});
}
//无用索引样式为loading
var unusedIndexClassIsLoading=function(){
	$("#span_unused_index")
	.append(
			"<img style=\"width:100px;height:20px;\" title=\"正在检查\" src=\"assets/img/loading_check.gif\" />");
}
//无用索引样式为异常
var unusedIndexClassIsDanger=function(serverId){
	$("#li_unused_index").addClass("list-group-item-danger");
	$("#span_unused_index")
			.append(
					"<a href=\"javascript:showCheckResultByUnusedIndex("+serverId+")\">该项有问题，立即查看</a>");
}

//无用索引样式为OK
var unusedIndexClassIsOK=function(){
	$("#li_unused_index").removeClass();
	$("#li_unused_index").addClass("list-group-item");
	$("#span_unused_index")
			.append(
					"<img style=\"width:28px;height:28px;\" src=\"assets/img/ok.png\" />");
}

//主键检查样式为loading
var primaryKeyClassIsLoading=function(){
	$("#span_primary_key")
	.append(
			"<img style=\"width:100px;height:20px;\" title=\"正在检查\" src=\"assets/img/loading_check.gif\" />");
}
//主键检查样式为异常
var primaryKeyClassIsDanger=function(serverId){
	$("#li_primary_key").addClass("list-group-item-danger");
	$("#span_primary_key")
			.append(
					"<a href=\"javascript:showCheckResultByPrimaryKey("+serverId+")\">该项有问题，立即查看</a>");
}
//主键检查样式为OK
var primaryKeyClassIsOK=function(){
	$("#li_primary_key").removeClass();
	$("#li_primary_key").addClass("list-group-item");
	$("#span_primary_key")
			.append(
					"<img style=\"width:28px;height:28px;\" src=\"assets/img/ok.png\" />");
}

//索引区分度检查样式为loading
var indexCardinalityClassIsLoading=function(){
	$("#span_index_cardinality")
	.append(
			"<img style=\"width:100px;height:20px;\" title=\"正在检查\" src=\"assets/img/loading_check.gif\" />");
}
//索引区分度样式为异常
var indexCardinalityClassIsDanger=function(serverId){
	$("#li_index_cardinality").addClass("list-group-item-danger");
	$("#span_index_cardinality")
			.append(
					"<a href=\"javascript:showCheckResultByIndexCardinality("+serverId+")\">该项有问题，立即查看</a>");
}
//索引区分度样式为OK
var indexCardinalityClassIsOK=function(){
	$("#li_index_cardinality").removeClass();
	$("#li_index_cardinality").addClass("list-group-item");
	$("#span_index_cardinality")
			.append(
					"<img style=\"width:28px;height:28px;\" src=\"assets/img/ok.png\" />");
}

//冗余索引样式为loading
var redundantIndexClassIsLoading=function(){
	$("#span_redundant_index")
	.append(
			"<img style=\"width:100px;height:20px;\" title=\"正在检查\" src=\"assets/img/loading_check.gif\" />");
}
//冗余索引样式为异常
var redundantIndexClassIsDanger=function(serverId){
	$("#li_redundant_index").addClass("list-group-item-danger");
	$("#span_redundant_index")
			.append(
					"<a href=\"javascript:showCheckResultByRedundantIndex("+serverId+")\">该项有问题，立即查看</a>");
}
//冗余索引样式为OK
var redundantIndexClassIsOK=function(){
	$("#li_redundant_index").removeClass();
	$("#li_redundant_index").addClass("list-group-item");
	$("#span_redundant_index")
			.append(
					"<img style=\"width:28px;height:28px;\" src=\"assets/img/ok.png\" />");
}


//显示无用索引检查结果
var showCheckResultByUnusedIndex = function(serverId) {
	var html = "<div class=\"alert alert-danger\" role=\"alert\">目前数据库存在无用索引，这些索引在发生插入和删除时会产生一定的性能问题，请<a target=\"_blank\" href=\"sample/unused-index.html?serverId="+serverId+"\">及时检查</a>。</div>";
	showModal(html,"无用索引检查结果");
}

//显示主键检查结果
var showCheckResultByPrimaryKey = function(serverId) {
	var html = "<div class=\"alert alert-danger\" role=\"alert\">目前数据库存在没有建立主键的表，这将给数据库带来性能问题，请<a target=\"_blank\" href=\"sample/no-primary-key.html?serverId="+serverId+"\">及时检查</a>。</div>";
	showModal(html,"主键检查结果");
}

//显示索引区分度检查结果
var showCheckResultByIndexCardinality = function(serverId) {
	var html = "<div class=\"alert alert-danger\" role=\"alert\">目前数据库存在一些索引，其选择度较低，这样的索引带来的性能收益可能较低，请<a target=\"_blank\" href=\"sample/index-cardinality.html?serverId="+serverId+"\">及时检查</a>。</div>";
	showModal(html,"索引区分度检查结果");
}

//显示冗余索引检查结果
var showCheckResultByRedundantIndex = function(serverId) {
	var html = "<div class=\"alert alert-danger\" role=\"alert\">目前数据库存在一些冗余索引，冗余索引是不会被SQL请求使用的索引，但会影响插入和删除的效率，请<a target=\"_blank\" href=\"sample/redundant-index.html?serverId="+serverId+"\">及时检查</a>。</div>";
	showModal(html,"冗余索引检查结果");
}

//显示模态窗口
var showModal=function(html,title){
	$("#checkResult").empty();
	$("#checkResult").append(html);
	$("#modalTitle").text(title);
	$("#checkResultModal").modal('show');
}