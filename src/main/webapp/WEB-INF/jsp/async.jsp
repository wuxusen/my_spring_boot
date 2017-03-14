<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<div>this is callback</div>
<div id="msgFromPush"></div>

<script type="text/javascript"
        src="<c:url value="http://code.jquery.com/jquery-latest.js" />"></script>
<script type="text/javascript">
    if (!!window.EventSource) { //EventSource是SSE的客户端.此时说明浏览器支持EventSource对象
        var source = new EventSource('push');//发送消息
        s = '';
        source.addEventListener('message', function(e) {
            s += e.data + "<br/>";
            $("#msgFromPush").html(s);
            //window.location.href="http://www.baidu.com"
        });//添加客户端的监听

        source.addEventListener('open', function(e) {
            console.log("连接打开");
        }, false);

        source.addEventListener('error',function(e){
            if(e.readyState==EventSource.CLOSED){
                console.log("连接关闭");
            }else{
                console.log(e.readyState);
            }
        });
    }else{
        console.log("您的浏览器不支持SSE");
    }
</script>
</body>
</html>