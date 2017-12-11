var ajaxUrlPrefix = "";
$(function($) {
	// 获取agent地址
	$.get("/agent-url", function(data) {
		ajaxUrlPrefix = data;
		var serverId = window.localStorage.getItem("currentServerId");
		if (serverId != null) {
			// 加载集群列表
			fnLoadTrxList(serverId);
		}

	});
});

/**
 * 加载事务信息
 */
var fnLoadTrxList = function(serverId) {
	var ajaxUrl = ajaxUrlPrefix + "/innodb/trx/" + serverId;
	var table = $('#tbTrx').DataTable({
		"bLengthChange" : false,
		"bFilter" : false,
		"bSort" : false,
		"processing" : true,
		"bProcessing" : true,
		"serverSide" : false,
		"iDisplayLength" : 10,
		"pagingType" : "simple",
		"oLanguage" : {
			"sLengthMenu" : "每页显示 _MENU_ 条记录",
			"sZeroRecords" : "对不起，查询不到任何相关数据",
			"sInfo" : "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
			"sInfoEmtpy" : "找不到相关数据",
			"sInfoFiltered" : "数据表中共为 _MAX_ 条记录)",
			"sProcessing" : "",
			"sLoadingRecords" : "Loading...",
			"sSearch" : "标签搜索",
			"sUrl" : "", // 多语言配置文件，可将oLanguage的设置放在一个txt文件中，例：Javascript/datatable/dtCH.txt
			"oPaginate" : {
				"sFirst" : "第一页",
				"sPrevious" : " 上一页 ",
				"sNext" : " 下一页 ",
				"sLast" : " 最后一页 "
			}

		},
		"ajax" : ajaxUrl,
		"columns" : [ {
			"class" : "details-control",
			"orderable" : false,
			"data" : null,
			"defaultContent" : ""
		}, {
			"data" : "trxMysqlThreadId"
		}, {
			"data" : "trxId"
		}, {
			"data" : "trxState"
		}, {
			"data" : "trxTablesLocked"
		}, {
			"data" : "trxRowsLocked"
		}, {
			"data" : "trxIsReadOnly"
		}, {
			"data" : "trxIsolationLevel"
		} ]
	});
	
	
	// Array to track the ids of the details displayed rows
	var detailRows = [];

	$('#tbTrx tbody').on('click', 'tr td.details-control', function() {
		var tr = $(this).closest('tr');
		var row = table.row(tr);
		var idx = $.inArray(tr.attr('id'), detailRows);

		if (row.child.isShown()) {
			tr.removeClass('details');
			row.child.hide();

			// Remove from the 'open' array
			detailRows.splice(idx, 1);
		} else {
			tr.addClass('details');
			row.child(format(row.data())).show();

			// Add to the 'open' array
			if (idx === -1) {
				detailRows.push(tr.attr('id'));
			}
		}
	});

	// On each draw, loop over the `detailRows` array and show any child rows
	table.on('draw', function() {
		$.each(detailRows, function(i, id) {
			$('#' + id + ' td.details-control').trigger('click');
		});
	});
}

function format(d) {
	return 'trx_id: '
			+ d.trxId
			+ '<br>'
			+ 'trx_started: '
			+ d.trxStarted
			+ '<br>'
			+ 'trx_requested_lock_id: '
			+ d.trxRequestedLockId
			+ '<br>'
			+ 'trx_wait_started: '
			+ d.trxWaitStarted
			+ '<br>'
			+ 'trx_weight: '
			+ d.trxWeight
			+ '<br>'
			+ 'trx_query: '
			+ d.trxQuery
			+ '<br>'
			+ 'trx_operation_state: '
			+ d.trxOperationState
			+ '<br>'
			+ 'trx_tables_in_use: '
			+ d.trxTablesInUse
			+ '<br>'
			+ 'trx_lock_structs: '
			+ d.trxLockStructs
			+ '<br>'
			+ 'trx_lock_memory_bytes: '
			+ d.trxLockMemoryBytes
			+ '<br>'
			+ 'trx_rows_modified: '
			+ d.trxRowsModified
			+ '<br>'
			+ 'trx_concurrency_tickets: '
			+ d.trxConcurrencyTickets
			+ '<br>'
			+ 'trx_unique_checks: '
			+ d.trxUniqueChecks
			+ '<br>'
			+ 'trx_foreign_key_checks: '
			+ d.trxForeignKeyChecks
			+ '<br>'
			+ 'trx_last_foreign_key_error: '
			+ d.trxLastForeignKeyError
			+ '<br>'
			;
}