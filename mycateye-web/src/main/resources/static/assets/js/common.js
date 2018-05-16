
$(function () {
    //初始化时间区间
    var datetimerange = $("#reservationtime");
    if (datetimerange && datetimerange.length > 0) {
        var now = getMillisecondAgoFormatDate(0);
        var halfAnHourAgo = getMillisecondAgoFormatDate(30 * 60 * 1000);
        var timeRange = halfAnHourAgo + " - " + now;
        datetimerange.val(timeRange);
    }




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
