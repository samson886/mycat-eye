var analyzeSql = function(digest) {
			$("body").mLoading({
				mask : false
			//是否显示遮罩效果，默认显示
			});
			var json_data = JSON.parse(window.localStorage.getItem(digest));
			//显示Sql Example数据
			showSqlExample(json_data);
			//显示Sql统计数据
			showSqlStat(json_data);
			//显示Sql执行计划
			showSqlExplain(json_data);
			//显示Sql建议
			showSqlAdvisor(json_data);

			//显示sql分析面板
			$("#panel_sql_analyze").show();
			setTimeout("$(\"body\").mLoading(\"hide\")", 500);
		}
		//显示Sql Example数据
		var showSqlExample = function(json_data) {
			//sql例子
			$("#sql_statement").html(json_data.digestText);
			$("#sql_statement_example").html(json_data.sqlText);
		}
		//显示Sql统计数据
		var showSqlStat = function(json_data) {
			$("#currentSchema").html(json_data.currentSchema);
			//$("#currentTable").html(json_data.currentTable);
			$("#firstSeen").html(getLocalTime(json_data.firstSeen));
			$("#lastSeen").html(getLocalTime(json_data.lastSeen));
			$("#countStar").html(json_data.countStar);
			$("#avgTimerWait").html(
					nanosecondToMillisecond(json_data.avgTimerWait) + "毫秒");
		}
		//显示Sql执行计划
		var showSqlExplain = function(json_date) {
			$("#sql_explain_tbody").empty();
			var serverId = $("#defaultServerId").val();
			var schema = json_date.currentSchema;
			var exeSql = json_date.sqlText;
			$.getJSON("/mysql/statement/explain", {
				serverId : serverId,
				schema : schema,
				exeSql : exeSql
			}, function(json) {
				var trHtml = "";
				var tableArray = [];
				$.each(json.data, function(index, content) {
					trHtml += "<tr width='100%'>";
					trHtml += "<td style=\"WORD-WRAP: break-word\">"
							+ content.id + "</td>";
					trHtml += "<td style=\"WORD-WRAP: break-word\">"
							+ content.select_type + "</td>";
					trHtml += "<td style=\"WORD-WRAP: break-word\">"
							+ content.table + "</td>";
					trHtml += "<td style=\"WORD-WRAP: break-word\">"
							+ content.partitions + "</td>";
					trHtml += "<td style=\"WORD-WRAP: break-word\">"
							+ content.type + "</td>";
					trHtml += "<td style=\"WORD-WRAP: break-word\">"
							+ content.possible_keys + "</td>";
					trHtml += "<td style=\"WORD-WRAP: break-word\">"
							+ content.key + "</td>";
					trHtml += "<td style=\"WORD-WRAP: break-word\">"
							+ content.key_len + "</td>";
					trHtml += "<td style=\"WORD-WRAP: break-word\">"
							+ content.ref + "</td>";
					trHtml += "<td style=\"WORD-WRAP: break-word\">"
							+ content.rows + "</td>";
					trHtml += "<td style=\"WORD-WRAP: break-word\">"
							+ content.filtered + "</td>";
					trHtml += "<td style=\"WORD-WRAP: break-word\">"
							+ content.extra + "</td>";
					trHtml += "</tr>";
					if (content.table != null) {
						tableArray.push(content.table);
					}
				});
				$("#sql_explain_tbody").append(trHtml);
				//在执行计划中有准确的表信息，所以在此设置当前表的名称
				$("#currentTable").html(tableArray);
				//显示表列表
				showSqlTableList(schema, tableArray);
				//显示表详细信息
				showTableDetail(schema, tableArray[0]);
			});
		}
		//显示Sql建议
		var showSqlAdvisor = function(json_date) {
			var serverId = $("#defaultServerId").val();
			var schema = json_date.currentSchema;
			var sql = json_date.sqlText;
			$.post("mysql/statement/sql-advisor", {
				serverId : serverId,
				schema : schema,
				sql : sql
			}, function(data) {
				$("#sql_advisor").html(data);
			});
		}
		//显示表信息
		var showSqlTableInfo = function(schema, table) {
			if (table == "null") {
				return;
			}
		}
		//显示表列表
		var showSqlTableList = function(schema, tableArray) {
			$("#tableList").empty();
			var aHtml = "";
			for (x in tableArray) {
				aHtml += "<a type=\"button\" class=\"list-group-item\" href=\"javascript:showTableDetail('"
						+ schema
						+ "','"
						+ tableArray[x]
						+ "')\">"
						+ tableArray[x] + "</a>";
			}
			$("#tableList").append(aHtml);
		}
		//显示表详细信息
		var showTableDetail = function(schema, table) {
			//清空表索引信息
			$("#table_index_tbody").empty();
			
			if (table == "null" || table == undefined) {
				$("#showCreateTable").html("暂无信息");
				return;
			}
			var serverId = $("#defaultServerId").val();
			//显示create table语句
			$.getJSON("mysql/statement/getCreateTable", {
				serverId : serverId,
				schema : schema,
				table : table
			}, function(json) {
				$("#showCreateTable").html(json.data);
			});
			//显示表索引语句
			$
					.getJSON(
							"mysql/statement/getTableIndex",
							{
								serverId : serverId,
								schema : schema,
								table : table
							},
							function(json) {
								var trHtml = "";
								$
										.each(
												json.data,
												function(index, content) {
													trHtml += "<tr width='100%'>";
													if (content.NON_UNIQUE == "0") {
														trHtml += "<td style=\"WORD-WRAP: break-word\">唯一</td>";
													} else {
														trHtml += "<td style=\"WORD-WRAP: break-word\">不唯一</td>";
													}
													trHtml += "<td style=\"WORD-WRAP: break-word\">"
															+ content.COLUMN_NAME
															+ "</td>";
													trHtml += "<td style=\"WORD-WRAP: break-word\">"
															+ content.INDEX_NAME
															+ "</td>";
													trHtml += "<td style=\"WORD-WRAP: break-word\">"
															+ content.NULLABLE
															+ "</td>";
													trHtml += "<td style=\"WORD-WRAP: break-word\">"
															+ content.INDEX_TYPE
															+ "</td>";
													trHtml += "<td style=\"WORD-WRAP: break-word\">"
															+ content.CARDINALITY
															+ "</td>";
													trHtml += "</tr>";
												});
								$("#table_index_tbody").html(trHtml);
							});
		}
		
