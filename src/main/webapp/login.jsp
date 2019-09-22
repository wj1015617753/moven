<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
	<link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/assets/css/global.css" />
	<link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/assets/css/global_color.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-3.2.0.min.js"></script>
	
	
	<script type="text/javascript">
	$(function(){
		$("#sub").click(function(){
			$("#loginForm").submit();
		})
	})
	</script>
</head>
<body class="index">
	<div class="login_box">
		<form action="${pageContext.request.contextPath}/login.do" id="loginForm" method="post">
			<span class="required" style="text-align: center;"></span>
			<table>
				<tr>
					<td class="login_info">账号：</td>
					<td colspan="2"><input name="username" type="text" class="width150" /></td>
					<td class="login_error_info"><span class="required"></span></td>
				</tr>
				<tr>
					<td class="login_info">密码：</td>
					<td colspan="2"><input name="password" type="password"
						class="width150" /></td>
					<td><span class="required"></span></td>
				</tr>
				<tr>
					<td></td>
					<td class="login_button" colspan="2"><a id="sub"><img
							src="${pageContext.request.contextPath}/assets/images/login_btn.png" /></a></td>
					<td><span class="required">${msg}</span></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
