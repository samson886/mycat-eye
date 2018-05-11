(function(){function r(e,n,t){function o(i,f){if(!n[i]){if(!e[i]){var c="function"==typeof require&&require;if(!f&&c)return c(i,!0);if(u)return u(i,!0);var a=new Error("Cannot find module '"+i+"'");throw a.code="MODULE_NOT_FOUND",a}var p=n[i]={exports:{}};e[i][0].call(p.exports,function(r){var n=e[i][1][r];return o(n||r)},p,p.exports,r,e,n,t)}return n[i].exports}for(var u="function"==typeof require&&require,i=0;i<t.length;i++)o(t[i]);return o}return r})()({1:[function(require,module,exports){
var _util = require('./util.js');

var _common = require('./common.js');

var a = (0, _util.getParameter)('a');
(0, _common.log)(a);

},{"./common.js":2,"./util.js":3}],2:[function(require,module,exports){
Object.defineProperty(exports, "__esModule", {
    value: true
});

var log = function log(s) {
    console.log(s);
};

exports.log = log;

},{}],3:[function(require,module,exports){
Object.defineProperty(exports, "__esModule", {
    value: true
});

var getParameter = function getParameter(t) {
    var e = new RegExp("[&,?]" + t + "=([^\\&,\\#]*)", "i"),
        i = e.exec(window.location.search);
    return i ? i[1] : null;
};

exports.getParameter = getParameter;

},{}]},{},[1]);
