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
			if('${msg}'!=''){
				showResult();
			}
			$("#sum").click(function(){
				$(".main_form").submit();
			})
		})
		
		 //保存成功的提示信息
        function showResult() {
            showResultDiv(true);
            window.setTimeout("showResultDiv(false);", 3000);
        }
        function showResultDiv(flag) {
            if (flag)
                $("#save_result_info").css("display","black");
            else
            	$("#save_result_info").css("display","none");
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
                	<li><a href="${pageContext.request.contextPath}/${priv.purl }" class="${priv.pclass}_off"></a></li>
                </c:forEach>
            </ul>
        </div>
        <!--导航区域结束-->
        <div id="main">      
            <!--保存操作后的提示信息：成功或者失败-->      
            <div id="save_result_info" class="save_success">${msg}</div><!--保存失败，旧密码错误！-->
            <form action="${pageContext.request.contextPath}/updateAction.do" method="post" class="main_form">
                <div class="text_info clearfix"><span>旧密码：</span></div>
                <div class="input_info">
                    <input type="password" class="width200"  name="oldpassword"/><span class="required">*</span>
                    <div class="validate_msg_medium"></div>
                </div>
                <div class="text_info clearfix"><span>新密码：</span></div>
                <div class="input_info">
                    <input type="password"  class="width200" name="newpassword" /><span class="required">*</span>
                    <div class="validate_msg_medium"></div>
                </div>
                <div class="text_info clearfix"><span>重复新密码：</span></div>
                <div class="input_info">
                    <input type="password" class="width200"  /><span class="required">*</span>
                    <div class="validate_msg_medium"></div>
                </div>
                <div class="button_info clearfix">
                    <input type="button" value="保存" class="btn_save" id="sum" />
                    <input type="button" value="取消" class="btn_save" />
                </div>
                <input type="hidden" name="id" value="${admin1.id }">
            </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
           
        </div>
    </body>
</html>
