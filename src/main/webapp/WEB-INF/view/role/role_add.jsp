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
            //保存成功的提示消息
           $(function(){
        		$("#smit").click(function(){
        			$(".main_form").submit();
        		})
        		
        		var msg = '${msg}';
        		if(msg != ""){
        			showResult(msg);
        		}
        	})
        	
            //保存成功的提示消息
            function showResult(msg) {
                showResultDiv(true,msg);
                window.setTimeout("showResultDiv(false,'');", 3000);
            }
            function showResultDiv(flag,msg) { 
                if (flag){
                	$("#save_result_info").text(msg);
                	$("#save_result_info").css("display","block");
                }
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
                	<li><a href="${pageContext.request.contextPath }/${priv.purl }" class="${priv.pclass}_off"></a></li>
                </c:forEach>
            </ul>
        </div>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">            
            <!--保存操作后的提示信息：成功失败-->
            <div id="save_result_info" class="save_success">保存成功！</div><!--保存失败，角色名称重复！-->
            <form action="${pageContext.request.contextPath }/roleAddAction.do" method="post" class="main_form" enctype="multipart/form-data">
                <div class="text_info clearfix"><span>角色名称：</span></div>
                <div class="input_info">
                    <input type="text" class="width200" name="rname" />
                    <span class="required">*</span>
                    <div class="validate_msg_medium">不能为空，且为20长度的字母、数字和汉字的组合</div>
                </div>                    
                <div class="text_info clearfix"><span>设置权限：</span></div>
                <div class="input_info_high">
                    <div class="input_info_scroll">
                        <ul>
                        <c:forEach items="${privs}" var = "privs">
                        <li><input type = "checkbox" name = "myPrivs" value = "${privs.pid}"/>${privs.name}</li>
                        </c:forEach>
                        <%-- <c:forEach items="${admin.lp }" var="privs">
                        	<li><input type = "checkbox" name = "myPrivs" value = "${privs.id}"/>${privs.name}</li>
                        </c:forEach> --%>
                        </ul>
                    </div>
                    <span class="required">*</span>
                    <div class="validate_msg_tiny">至少选择一个权限</div>
                </div>
                <div class="button_info clearfix">
                    <input type="button" id = "smit" value="保存" class="btn_save"  />
                    <input type="button" value="取消" class="btn_save" />
                </div>
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
          
        </div>
    </body>
</html>
