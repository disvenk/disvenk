<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>请输入任意消息</title>
<script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
<script src="http://cdn.sockjs.org/sockjs-0.3.min.js"></script>
<script language=javascript src='/js/layer.js'></script>
<script type="text/javascript">
var ws = null;
$(function () {
	
	var basePath = "ws://localhost:9001/";
    if ('WebSocket' in window) {
         ws = new WebSocket('ws://localhost:9001/webSocketServer'); 
         console.log("连接成功");
    }
    else if ('MozWebSocket' in window) {
        ws = new MozWebSocket("ws://localhost:9001/webSocketServer");
    }
    else {
        ws = new SockJS("ws://localhost:9001/webSocketServer");
    }
    ws.onopen = function () {

    };
    ws.onmessage = function (event) {
    	 pop(event.data);
    };
    ws.onclose = function (event) {
    	 ws.close();
    };
});
function stop(){
    var message = $("#message").val();
    ws.send(message);
}

//提示信息# s- _" j3 `% e4 i
function pop(message){
	//speckText();
    layer.alert("您有新的订单，请及时处理");
}

function speckText(){

var url ="/js/notify.mp3";

var n = new Audio(url);

 n.src = url;

 n.play();

}
</script>
</head>
<body class="keBody">
请输入提示信息: <textarea id="message"></textarea><br />
<input type="button" onclick="stop()" value="开始" />
</body>
</html>
</body>
</html>