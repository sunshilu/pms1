<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/web/jsp/header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/web/css/index.css">
<style type="text/css">
body {
	background: url(${pageContext.request.contextPath}/web/img/girl.png)
		no-repeat;
}
</style>
</head>
<body>
	<form action="${pageContext.request.contextPath}/loginAndReg/login" method="post">
		<div class="bg">
			<div class="wel">系统管理</div>
			<div class="user">
				<div id="yonghu" style="">账&nbsp;&nbsp;&nbsp;号</div>
				<input type="text" name="code" value="u007">
			</div>
			<div class="password">
				<div id="yonghu">密&nbsp;&nbsp;&nbsp;码</div>
				<input class="" type="password" name="password" value="123">
			</div>
			<div class="rem">
				<input type="checkbox" name="" id="" value="">
				<div id="reb">记住密码</div>
			</div>
			<div class="fg">
				<div style="font-size: 11px; margin-top: 11px;">
					<a style="font-size: 11px;"
						href="http://www.17sucai.com/preview/1030817/2018-09-12/%E7%99%BB%E5%BD%95%E9%A1%B5/index.html#">忘记密码？</a>
				</div>
			</div>
			<input class="btn" type="submit" name="登录" value="登录">
		</div>
	</form>
</body>
</html>