//全局变量，设置ajax请求地址
var ajaxUrlPrefix=window.localStorage.getItem("agent-url");
if(ajaxUrlPrefix==null){
    //同步ajax获取agent host地址
    $.ajax({ url: "agent-url",async: false, success: function(data){
        ajaxUrlPrefix=data;
        window.localStorage.setItem("agent-url",ajaxUrlPrefix);
    }});
}


