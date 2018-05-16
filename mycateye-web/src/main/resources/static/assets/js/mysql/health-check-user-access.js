// 用户访问检查
var checkUserAccess = function(serverId) {
	bsStep(2);
	// 锁等待检查
	$("#span_lock_wait")
			.append(
					"<img style=\"width:100px;height:20px;\" title=\"正在检查\" src=\"assets/img/loading_check.gif\" />");
	$
			.getJSON(
					globalAgentUrl + "/health-check/lock-wait/" + serverId,
					function(json) {
						$("#span_lock_wait").empty();
						if (json.code == "200") {
							sessionStorage.setItem("lock_wait", JSON
									.stringify(json.data));
							$("#li_lock_wait").addClass(
									"list-group-item-danger");
							$("#span_lock_wait")
									.append(
											"<a href=\"javascript:showCheckResultByLockWait('lock_wait')\">该项有问题，立即查看</a>");
						} else {
							$("#li_lock_wait").removeClass();
							$("#li_lock_wait").addClass("list-group-item");
							$("#span_lock_wait")
									.append(
											"<img style=\"width:28px;height:28px;\" src=\"assets/img/ok.png\" />");
						}
					});
	// 事务检查
	$("#span_transaction")
			.append(
					"<img style=\"width:100px;height:20px;\" title=\"正在检查\" src=\"assets/img/loading_check.gif\" />");
	$
			.getJSON(
					globalAgentUrl + "/health-check/transaction/" + serverId,
					function(json) {
						$("#span_transaction").empty();
						if (json.code == "200") {
							sessionStorage.setItem("transaction", JSON
									.stringify(json.data));
							$("#li_transaction").addClass(
									"list-group-item-danger");
							$("#span_transaction")
									.append(
											"<a href=\"javascript:showCheckResultByTransaction('transaction')\">该项有问题，立即查看</a>");
						} else {
							$("#li_transaction").removeClass();
							$("#li_transaction").addClass("list-group-item");
							$("#span_transaction")
									.append(
											"<img style=\"width:28px;height:28px;\" src=\"assets/img/ok.png\" />");
						}
					});
	
	// 慢查询检查
	$("#span_slow")
			.append(
					"<img style=\"width:100px;height:20px;\" title=\"正在检查\" src=\"assets/img/loading_check.gif\" />");
	$
			.getJSON(
					globalAgentUrl + "/health-check/slow/" + serverId,
					function(json) {
						$("#span_slow").empty();
						if (json.code == "200") {
							sessionStorage.setItem("slow", JSON
									.stringify(json.data));
							$("#li_slow").addClass(
									"list-group-item-danger");
							$("#span_slow")
									.append(
											"<a href=\"javascript:showCheckResultBySlow('slow')\">该项有问题，立即查看</a>");
						} else {
							$("#li_slow").removeClass();
							$("#li_slow").addClass("list-group-item");
							$("#span_slow")
									.append(
											"<img style=\"width:28px;height:28px;\" src=\"assets/img/ok.png\" />");
						}
					});
}

// 显示锁等待检查结果
var showCheckResultByLockWait = function(sessionStorageKey) {
	jsonStr = sessionStorage.getItem(sessionStorageKey);
	jsonObj = JSON.parse(jsonStr);
	var html = "<div class=\"alert alert-danger\" role=\"alert\">检查出数据库存在锁等待的情况，这可能是一些事务一直未完成所致。你可以查看内置数据库表sys.innodb_lock_waits表，获取详细信息。</div>";
	html += "<table class=\"table\"><thead>";
	html += "<tr><th>表</th><th>等待语句</th><th>锁</th></tr>";
	html += "</thead>";
	html += "<tbody>";
	var tbody = "";
	$.each(jsonObj, function(n, value) {
		var trs = "";
		trs += "<tr><td>" + value.locked_table + "</td> <td>"
				+ value.waiting_query + "</td><td>" + value.waiting_lock_mode
				+ "</td></tr>";
		tbody += trs;
	});
	html += tbody;
	html += "</tbody></table>";
	$("#checkResult").empty();
	$("#checkResult").append(html);
	$("#modalTitle").text("锁等待检查结果");
	$("#checkResultModal").modal('show');
}

//显示事务检查结果
var showCheckResultByTransaction = function(sessionStorageKey) {
	jsonStr = sessionStorage.getItem(sessionStorageKey);
	jsonObj = JSON.parse(jsonStr);
	var html = "<div class=\"alert alert-danger\" role=\"alert\">目前数据库存在未完成的事务，请通过内置数据库表performance_schema.events_transactions_current表，进行详细查询。</div>";
	$("#checkResult").empty();
	$("#checkResult").append(html);
	$("#modalTitle").text("事务检查结果");
	$("#checkResultModal").modal('show');
}

//显示慢查询检查结果
var showCheckResultBySlow = function(sessionStorageKey) {
	jsonStr = sessionStorage.getItem(sessionStorageKey);
	jsonObj = JSON.parse(jsonStr);
	var html = "<div class=\"alert alert-danger\" role=\"alert\">目前数据库存在慢查询，请通过内置数据库表mysql.slow_log获取详细信息。</div>";
	$("#checkResult").empty();
	$("#checkResult").append(html);
	$("#modalTitle").text("慢查询检查结果");
	$("#checkResultModal").modal('show');
}