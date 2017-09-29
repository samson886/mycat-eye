//全局变量，设置ajax请求地址
var ajaxHost=window.localStorage.getItem("agent-host");
if(ajaxHost==null){
    //同步ajax获取agent host地址
    $.ajax({ url: "agent-host",async: false, success: function(data){
        ajaxHost=data;
        window.localStorage.setItem("agent-host",ajaxHost);
    }});
}


