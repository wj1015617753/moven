<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/assets/css/global.css" />
		<link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/assets/css/global_color.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-3.2.0.min.js"></script>
        <script language="javascript" type="text/javascript">
        function deleteRole(rid) {
            var r = window.confirm("确定要删除此角色吗？");
            //var path = '${pageContext.request.contextPath}';
            if(r) location.href="${pageContext.request.contextPath}/deleteRoleMsg.do?rid="+rid;
            var msg = '${msg}';
            if(msg!=""){
            	$("#operate_result_info").append(msg);
            	$("#operate_result_info").css("display","block");
            }
           // document.getElementById("operate_result_info").style.display = "block";
        }
        
        </script>
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
            <img src="${pageContext.request.contextPath}/assets/images/logo.png" alt="logo" class="left"/>
            <span
		    style="margin-left: 5px; margin-right: 5px; color: blue; font-weight: bold; font-size: 15px;">${admin1.aname }
		    </span>
            <a href="${pageContext.request.contextPath}/exitAction.do">[退出]</a>            
        </div>
        <!--Logo区域结束-->
        <!--导航区域开始-->
        <div id="navi">
            <ul id="menu">
            	<c:forEach items="${admin1.lp}" var="priv">
                	<li><a href="${pageContext.request.contextPath }/${priv.purl }" class="${priv.pclass}_off"></a></li>
                </c:forEach>
            </ul>
        </div>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">
            <form action=""  method="get">
                <!--查询-->
                <div class="search_add">
                    <input type="button" value="增加" class="btn_add" onclick="location.href='${pageContext.request.contextPath}/privsAction.do';" />
                </div>  
                <!--删除的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="${pageContext.request.contextPath}/assets/images/close.png" onclick="this.parentNode.style.display='none';" />
                 
                </div> <!--删除错误！该角色被使用，不能删除。-->
                <!--数据区域：用表格展示数据-->     
                <div id="data">                      
                    <table id="datalist">
                        <tr>                            
                            <th>角色 ID</th>
                            <th>角色名称</th>
                            <th class="width600">拥有的权限</th>
                            <th class="td_modi"></th>
                        </tr>
                        <c:forEach items="${roles}" var="role">                      
                        <tr>
                            <td>${role.rid}</td>
                            <td>${role.rname}</td>
                            <td>${role.privs }</td>
                            <td>
                                <input type="button" value="修改" class="btn_modify" onclick="location.href='${pageContext.request.contextPath}/updateRoleAction.do?rid='+${role.rid};"/>
                                <input type="button" value="删除" class="btn_delete" onclick="deleteRole('${role.rid}');"/>
                            </td>
                        </tr>
                        </c:forEach>
                    </table>
                </div> 
                <!--分页-->
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
           
        </div>
    </body>
</html>
