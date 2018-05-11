
const getParameter = function(t) {
    var e = new RegExp("[&,?]" + t + "=([^\\&,\\#]*)", "i"),
        i = e.exec(window.location.search);
    return i ? i[1] : null
}

function ajax(url,params){
    var multipart = params && params.multipart?true:false;
    var contentType = 'application/json; charset=utf-8';
    var dataType = 'json';

    var options = $.extend({dataType:dataType,contentType:contentType,url:url},params);
    if(multipart){
        options.cache = false;
        options.contentType = false;
        options.processData = false;
    }
    options.beforeSend = function(jqXhr,settings){
        // show loading
    };
    options.complete = function(jqXhr,textStatus){
        // textStatus: "success", "notmodified", "nocontent", "error", "timeout", "abort", or "parsererror"
        // close loading
        console.log('complete',jqXhr,textStatus)
        // hide loading

        // need login
        if(401 == jqXhr.status){
            document.location.href = '/admin/login.html?redirectUrl='+window.encodeURIComponent(window.location.href);
        }
    };
    options.error = function(jqXhr,status){
        // "timeout" "error" "abort" "parsererror"
        console.log('error',jqXhr,status)
    }
    //console.log(options)
    $.ajax(options);
    // res, status,jqxhr
    // err,status
}

const http = {
    get: function (url,param) {
        param.method = 'GET';
        ajax(url,param);
    },
    post: function (url,param) {
        param.method = 'POST';
        ajax(url,param);
    },
    put: function (url,param) {
        param.method = 'PUT';
        ajax(url,param);
    },
    del: function (url,param) {
        param.method = 'DELETE';
        ajax(url,param);
    },
    formdata: function (url,param) {
        param.method = 'POST';
        param.multipart = true;
        ajax(url,param);
    }
}


// notification
let tpl = `<div class="alert alert-${type} alert-dismissible fade show" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>`;
const tip = $('#alert');
const klass = 'alert-primary alert-secondary alert-success alert-danger alert-warning alert-info alert-light alert-dark';
const Notify = {
    primary: (msg,delay) => {
        setAlert(msg,'primary',delay);
    },
    secondary: (msg,delay) => {
        setAlert(msg,'secondary',delay);
    },
    success: (msg,delay) => {
        setAlert(msg,'success',delay);
    },
    danger: (msg,delay) => {
        setAlert(msg,'danger',delay);
    },
    warning: (msg,delay) => {
        setAlert(msg,'warning',delay);
    },
    info: (msg,delay) => {
        setAlert(msg,'info',delay);
    },
    light: (msg,delay) => {
        setAlert(msg,'light',delay);
    },
    dark: (msg,delay) => {
        setAlert(msg,'dark',delay);
    }
}
const setAlert = function (msg,klass,delay) {
    tip.removeClass(klass).addClass('alert-'+klass);
    tip.find('.alert-content').html(msg);
    tip.alert();
    if(checkDelay(delay)){
        setTimeout(()=>{
            tip.alert('close');
        },delay);
    }
}
const checkDelay = function (delay) {
    let closed = false;
    if(typeof delay == 'boolean'){
        closed = false;
    }
    return closed;
}

export { getParameter,http,Notify };




