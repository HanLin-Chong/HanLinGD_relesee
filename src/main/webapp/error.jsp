<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>错误页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <!-- 禁止用户缩放 -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <link rel="icon" href="img/czyh.png">
    <link rel="stylesheet" href="css/normalize.css"/>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>


    <script src="js/jquery-1.11.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</head>
<body>
<%
String s = request.getParameter("error");
if (s == null){
    s = "0";
}
int error = Integer.parseInt(s);
%>
发生意外错误！错误码：<%=error %>
<br/>具体情况请参照下列叙述，每条叙述的编号就是错误码
<hr/>
错误码参照：
<br/>
0：未发生错误，是您主动访问该页
<br/>
1：当前登录的用户的角色不属于系统内的三个角色（客户经理、审核员、领导），这可能是由数据库中存储的角色信息意外被修改所致。请联系开发者解决
<br/>
2：您没有权限访问之前请求的资源，可能是登录超时/没有登录/账号权限不足，请<a href="login.html">登录</a>
<br/>
</body>
</html>
