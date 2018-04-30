$(function () {
    //初始化时间区间
    var datetimerange = $("#reservationtime");
    if(datetimerange && datetimerange.size() > 0){
        var now = getMillisecondAgoFormatDate(0);
        var halfAnHourAgo = getMillisecondAgoFormatDate(30 * 60 * 1000);
        var timeRange=halfAnHourAgo + " - " + now;
        datetimerange.val(timeRange);
        //定义时间选择事件
        datetimerange.daterangepicker({
                timePicker : true,
                timePickerIncrement : 1,
                format : 'YYYY/MM/DD HH:mm:ss'
            },
            function(start, end, label) {
                timeRange=datetimerange.val();
                console.log('start',start,'end',end,'label',label);
                //初始化图表
                // var serverId=$("#defaultServerId").val();
                // chartInit(serverId, timeRange);
            });
    }

});