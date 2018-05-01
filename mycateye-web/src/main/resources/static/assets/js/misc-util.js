(function($,global) {
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

	// 2018-05-01
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


})(jQuery,window,undefined);



$(function () {
    $.extend($, {
        fixedWidth : function(str, length, char) {
            str = str.toString();
            if (!char)
                char = "...";
            var num = length - lengthB(str);
            if (num < 0) {
                str = substringB(str, length - lengthB(char)) + char;
            }
            return str;
            function substringB(str, length) {
                var num = 0, len = str.length, tenp = "";
                if (len) {
                    for (var i = 0; i < len; i++) {
                        if (num > length)
                            break;
                        if (str.charCodeAt(i) > 255) {
                            num += 2;
                            tenp += str.charAt(i);
                        } else {
                            num++;
                            tenp += str.charAt(i);
                        }
                    }
                    return tenp;
                } else {
                    return null;
                }
            }
            function lengthB(str) {
                var num = 0, len = str.length;
                if (len) {
                    for (var i = 0; i < len; i++) {
                        if (str.charCodeAt(i) > 255) {
                            num += 2;
                        } else {
                            num++;
                        }
                    }
                    return num;
                } else {
                    return 0;
                }
            }
        }
    });

    // 悬浮div
    $.fn.floatAutoScroll = function() {
        this.each(function() {
            var obj = $(this);
            var top = obj.css('top').replace('px', '');
            $(window).scroll(function() {
                var scrollTop = $(window).scrollTop();
                obj.stop().animate({
                    top : (top * 1 + scrollTop * 1)
                }, 'normal');
            });
        });
    };

    $('.float-container').floatAutoScroll();


});






