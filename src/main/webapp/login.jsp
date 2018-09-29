<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int error = 0;
try{
	error = Integer.parseInt(request.getParameter("error"));
	System.out.println(error);
} catch (Exception e){
	error = 0;
}
%>
  <base href="<%=basePath%>">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>稠州银行部门业务系统-登录</title>
	
	<style type="text/css">

	</style>

</head>
<body>


		    <form id="autologin" class="login-form" method="post" action="user/login">
		      <input id="autoname"  type="text" placeholder="账号" name="userId"/>
		      <input id="autopw"  type="password" placeholder="密码" name="password" />
		      <button id="login" type="submit">登录</button>
		      
		      
		    </form>

	<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>

	<script type="text/javascript">
	

	


	$(document).ready(function(){
	
	
	


	});
	</script>
</body>
</html>