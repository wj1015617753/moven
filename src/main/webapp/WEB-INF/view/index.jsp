<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
		<link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/assets/css/global.css" />
		<link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/assets/css/global_color.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-3.2.0.min.js"></script>
		
    </head>
    <body class="index">
        <!--导航区域开始-->
        <div id="index_navi">
            <ul id="menu">
            	<c:forEach items="${admin1.lp}" var="priv">
                	<li><a href="${pageContext.request.contextPath }/${priv.purl }" class="${priv.pclass}_off"></a></li>
                </c:forEach>
            </ul>
        </div>
    </body>
</html>
