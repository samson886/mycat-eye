//定义全局变量agentUrl
var globalAgentUrl = "";
$.get("agent-url", function(data) {
	globalAgentUrl = data;
});