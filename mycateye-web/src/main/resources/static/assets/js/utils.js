;(function(global,$){
    //定义获取指定毫秒前的时间
    var getMillisecondAgoFormatDate = function(millisecond) {
        var curDate = new Date();
        var date = new Date(curDate.getTime() - millisecond);
        var seperator1 = "/";
        var seperator2 = ":";
        var month = date.getMonth() + 1;
        var strDate = date.getDate();
        var strHours = date.getHours();
        var strMinutes = date.getMinutes();
        var strSeconds = date.getSeconds();
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if (strDate >= 0 && strDate <= 9) {
            strDate = "0" + strDate;
        }
        if (strHours >= 0 && strHours <= 9) {
            strHours = "0" + strHours;
        }
        if (strMinutes >= 0 && strMinutes <= 9) {
            strMinutes = "0" + strMinutes;
        }
        if (strSeconds >= 0 && strSeconds <= 9) {
            strSeconds = "0" + strSeconds;
        }
        var currentdate = date.getFullYear() + seperator1 + month + seperator1
        + strDate + " " + strHours + seperator2 + strMinutes + seperator2
        + strSeconds;
        return currentdate;
    }
    var digitRound = function(digit, length) {
        length = length ? parseInt(length) : 0;
        if (length <= 0)
            return Math.round(digit);
        digit = Math.round(digit * Math.pow(10, length)) / Math.pow(10, length);
        return digit;
    };

    var nanosecondToMillisecond = function(nanosecond) {
        var millisecond = nanosecond / 1000000000;
        return digitRound(millisecond, 2);
    }

    String.prototype.replaceAll = function(s1, s2) {
        return this.replace(new RegExp(s1, "gm"), s2);
    };

    getLocalTime = function(nS) {
        return new Date(parseInt(nS)).toLocaleString().replace(/年|月/g, "-")
            .replace(/日/g, " ");
    };

	//定义获取地址栏参数的函数
    function getUrlParam(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
        var r = window.location.search.substr(1).match(reg); // 匹配目标参数
        if (r != null)
            return unescape(r[2]);
        return null; // 返回参数值
    }

    global.nanosecondToMillisecond = nanosecondToMillisecond;
    global.getUrlParam = getUrlParam;
    global.getLocalTime = getLocalTime;
    global.digitRound = digitRound;
    global.getMillisecondAgoFormatDate = getMillisecondAgoFormatDate;

    //
    global.getParameter = function(t) {
        var e = new RegExp("[&,?]" + t + "=([^\\&,\\#]*)", "i"),
            i = e.exec(global.location.search);
        return i ? i[1] : null
    };

    // notification
	// alert-primary | secondary | success | danger | warning | info | light | dark
	var _toastTpl = '<div class="alert alert-{{ class }}">{{ msg }}</div>';
    var defaultDelay = 2000;
    var closed = true;
	function doNotify(msg, klass, delay) {
		if(typeof delay == 'boolean'){
		    closed = false;
        }
        //var a = document.createDocumentFragment('div');
        var a = document.createElement('div');
		a.id = 'notify-'+Math.random();
		a.className = 'myeye-notify alert alert-'+klass;
		a.innerHTML = msg;
		document.body.appendChild(a);
		if(closed){
		    setTimeout(function () {
                document.body.removeChild(a);
            }, delay || defaultDelay)
        }
    }
	global.notifi = {
		info: function(msg,delay) {
		    return doNotify(msg, 'info', delay)
        },
        warn: function(msg,delay) {
		    doNotify(msg, 'warning', delay);
        },
        error: function (msg,delay) {
            doNotify(msg, 'error', delay);
        },
        success: function (msg, delay) {
            doNotify(msg, 'success', delay);
        },
        primary: function (msg, delay) {
            doNotify(msg, 'primary', delay);
        },
        secondary: function (msg, delay) {
            doNotify(msg, 'secondary', delay);
        }
	};

    global.getNodes = function(key){
        var currentNodes = window.sessionStorage.getItem('nodes');
        var curMysql = '', curMycat = '';
        if (currentNodes) {
            try {
                currentNodes = JSON.parse(currentNodes);
                curMysql = currentNodes['mysql'] ? currentNodes['mysql']['value'] || '' : '';
                curMycat = currentNodes['mycat'] ? currentNodes['mycat']['value'] || '' : '';
                // currentMysql.text(currentNodes['mysql'] ? currentNodes['mysql']['name'] || '' : '');
                // currentMysql.attr('data-value', curMysql);
            } catch (e) {
                console.log(currentNodes);
                currentNodes = null;
                curMysql = '';
                curMycat = '';
            }
        }
        return {list:currentNodes,curMysql:curMysql,curMycat:curMycat};
    }

    // 获取mysql列表
    global.getMysqlList = function(mysqlNodes,cb){
        $.getJSON("/mysql/node/all", function (data) {
            var li = [];
            var d = data || [];
            if(d.length==0){
                li.push('<li class="disabled" data-name="暂无节点" data-value=""><a href="javascript:void(0);">暂未添加任何节点</a></li>')
            }
            for(var i=0;i<d.length;i++){
                li.push('<li class="" data-name="'+d[i]['host']+'-'+d[i]['port']+'" data-value="'+d[i]['id']+'"><a href="javascript:void(0);">'+d[i]['host']+'-'+d[i]['port']+'</a></li>')
            }
            mysqlNodes.html(li.join(''));
            if(cb && typeof cb == 'function'){
                cb(d);
            }
        }).fail(function(){
            if(cb && typeof cb == 'function'){
                cb([]);
            }
        });
    };

    // 获取mycat列表
    global.getMycatList = function(mycatNodes,cb){
        $.get('/mycat/server/list', function (res) {
            var data = res.data || [];
            var html = ['<option value="">请选择mycat节点</option>'];
            for (var i = 0; i < data.length; i++) {
                html.push('<option value="' + data[i]['id'] + '">' + data[i]['serverName'] + '</option>');
            }
            mycatNodes.html(html.join(''));
            if(cb && typeof cb == 'function'){
                cb();
            }
        });
    }

    // 保存sql详细数据到本地
    global.saveSqlDataLocalStorage = function (serverId) {
        // 将sql语句详细数据保存到html5本地
        $.getJSON("/mysql/statement/getAllSqlStatement?server_id=" + serverId
            + "&limit=100&offset=0&key=last_seen&order=desc", function (json) {
            $.each(json.data, function (index, content) {
                window.localStorage.setItem(content.digest, JSON.stringify(content));
            });
        });
    };
    global.dtb={
        "oLanguage" : {
            "sLengthMenu" : "每页显示 _MENU_ 条记录",
            "sZeroRecords" : "对不起，查询不到任何相关数据",
            "sInfo" : "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
            "sInfoEmtpy" : "找不到相关数据",
            "sInfoFiltered" : "数据表中共为 _MAX_ 条记录)",
            "sProcessing" : "正在加载中...",
            "sSearch" : "标签搜索",
            "sUrl" : "", // 多语言配置文件，可将oLanguage的设置放在一个txt文件中，例：Javascript/datatable/dtCH.txt
            "oPaginate" : {
                "sFirst" : "第一页",
                "sPrevious" : " 上一页 ",
                "sNext" : " 下一页 ",
                "sLast" : " 最后一页 "
            }
        }
    }

})(window,jQuery,undefined);
