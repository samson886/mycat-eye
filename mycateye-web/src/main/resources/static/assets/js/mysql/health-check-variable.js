// 参数检查
var checkVariables = function(serverId) {
	bsStep(3);
	// 编码检查
	$("#span_charset")
			.append(
					"<img style=\"width:100px;height:20px;\" title=\"正在检查\" src=\"assets/img/loading_check.gif\" />");
	$
			.getJSON(
					globalAgentUrl + "/health-check/charset/" + serverId,
					function(json) {
						$("#span_charset").empty();
						if (json.code == "200") {
							sessionStorage.setItem("charset", JSON
									.stringify(json.data));
							$("#li_charset").addClass("list-group-item-danger");
							$("#span_charset")
									.append(
											"<a href=\"javascript:showCheckResultByCharset('charset')\">该项有问题，立即查看</a>");
						} else {
							$("#li_charset").removeClass();
							$("#li_charset").addClass("list-group-item");
							$("#span_charset")
									.append(
											"<img style=\"width:28px;height:28px;\" src=\"assets/img/ok.png\" />");
						}
					});
}

//显示编码检查结果
var showCheckResultByCharset = function(sessionStorageKey) {
	jsonStr = sessionStorage.getItem(sessionStorageKey);
	jsonObj = JSON.parse(jsonStr);
	var html = "<div class=\"alert alert-danger\" role=\"alert\">目前数据库存在非UTF8（UTF8MB4）的编码，我们强烈建议你统一你的数据库编码为UTF8或UTF8MB4。</div>";
	html += "<table class=\"table\"><thead>";
	html += "<tr><th>表</th><th>列名</th><th>当前编码</th></tr>";
	html += "</thead>";
	html += "<tbody>";
	var tbody = "";
	$.each(jsonObj, function(n, value) {
		var trs = "";
		trs += "<tr><td>" + value.TABLE_NAME + "</td> <td>"
				+ value.COLUMN_NAME + "</td><td>" + value.CHARACTER_SET_NAME
				+ "</td></tr>";
		tbody += trs;
	});
	html += tbody;
	html += "</tbody></table>";
	$("#checkResult").empty();
	$("#checkResult").append(html);
	$("#modalTitle").text("编码检查结果");
	$("#checkResultModal").modal('show');
}