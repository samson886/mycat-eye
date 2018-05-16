// 安全检查
var checkSecurity = function(serverId) {
	bsStep(1);
	// 权限检查
	$("#span_super_priv")
			.append(
					"<img style=\"width:100px;height:20px;\" title=\"正在检查\" src=\"assets/img/loading_check.gif\" />");
	$
			.getJSON(
					globalAgentUrl + "/health-check/super-priv/" + serverId,
					function(json) {
						$("#span_super_priv").empty();
						if (json.code == "200") {
							sessionStorage.setItem("super_priv", JSON
									.stringify(json.data));
							$("#li_super_priv").addClass(
									"list-group-item-danger");
							$("#span_super_priv")
									.append(
											"<a href=\"javascript:showCheckResultBySuperPriv('super_priv')\">该项有问题，立即查看</a>");
						} else {
							$("#li_super_priv").removeClass();
							$("#li_super_priv").addClass("list-group-item");
							$("#span_super_priv")
									.append(
											"<img style=\"width:28px;height:28px;\" src=\"assets/img/ok.png\" />");
						}
					});
	// 弱密码检查
	$("#span_weak_password")
			.append(
					"<img style=\"width:100px;height:20px;\" title=\"正在检查\" src=\"assets/img/loading_check.gif\" />");
	$
			.getJSON(
					globalAgentUrl + "/health-check/weak-password/" + serverId,
					function(json) {
						$("#span_weak_password").empty();
						if (json.code == "200") {
							sessionStorage.setItem("weak_password", JSON
									.stringify(json.data));
							$("#li_weak_password").addClass(
									"list-group-item-danger");
							$("#span_weak_password")
									.append(
											"<a href=\"javascript:showCheckResultByWeakPassword('weak_password')\">该项有问题，立即查看</a>");
						} else {
							$("#li_weak_password").removeClass();
							$("#li_weak_password").addClass("list-group-item");
							$("#span_weak_password")
									.append(
											"<img style=\"width:28px;height:28px;\" src=\"assets/img/ok.png\" />");
						}
					});
}


//显示权限检查结果
var showCheckResultBySuperPriv = function(sessionStorageKey) {
	jsonStr = sessionStorage.getItem(sessionStorageKey);
	jsonObj = JSON.parse(jsonStr);
	var html = "<div class=\"alert alert-danger\" role=\"alert\">检查出具有超级权限的远程用户信息，这将对数据库带来极大的安全风险，建议你对下列用户做权限限制。</div>";
	html += "<table class=\"table\"><thead>";
	html += "<tr><th>用户名</th><th>是否有超级权限</th></tr>";
	html += "</thead>";
	html += "<tbody>";
	var tbody = "";
	$.each(jsonObj, function(n, value) {
		var trs = "";
		trs += "<tr><td>" + value.User + "</td> <td>" + value.Super_priv
				+ "</td></tr>";
		tbody += trs;
	});
	html += tbody;
	html += "</tbody></table>";
	$("#checkResult").empty();
	$("#checkResult").append(html);
	$("#modalTitle").text("权限检查结果");
	$("#checkResultModal").modal('show');
}

//显示弱密码检查结果
var showCheckResultByWeakPassword = function(sessionStorageKey) {
	jsonStr = sessionStorage.getItem(sessionStorageKey);
	jsonObj = JSON.parse(jsonStr);
	var html = "<div class=\"alert alert-danger\" role=\"alert\">检查出数据库用户密码存在弱密码的情况，这将给数据库安全带来风险，建议你修改密码，增加密码强度。</div>";
	html += "<table class=\"table\"><thead>";
	html += "<tr><th>用户名</th><th>密码</th></tr>";
	html += "</thead>";
	html += "<tbody>";
	var tbody = "";
	$.each(jsonObj, function(n, value) {
		var trs = "";
		trs += "<tr><td>" + value.user + "</td> <td>" + value.plaintext
				+ "</td></tr>";
		tbody += trs;
	});
	html += tbody;
	html += "</tbody></table>";
	$("#checkResult").empty();
	$("#checkResult").append(html);
	$("#modalTitle").text("弱密码检查结果");
	$("#checkResultModal").modal('show');
}