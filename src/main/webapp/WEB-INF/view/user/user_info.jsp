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
        <script language="javascript" type="text/javascript">
            //保存成功的提示信息
           $(function(){
				$("#smit").click(function(){
					$.post({
						url: '${pageContext.request.contextPath}/updateAdminMsgAction.do',
						data: $(".main_form").serialize(),
					    success : function(result){
					    	showResult(result);
					    }
					})
				})
			})
            //保存成功的提示信息
            function showResult(msg) {
				var m;
				if("ok" == msg){
					m = "修改成功";
				}else{
					m = "修改失败";
				}
				$("#save_result_info").text(m);
                showResultDiv(true);
                window.setTimeout("showResultDiv(false);", 3000);
            }
            function showResultDiv(flag) {
                if (flag)
                    $("#save_result_info").css("display","block");
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
            <!--保存操作后的提示信息：成功或者失败-->
            <div id="save_result_info" class="save_success">保存成功！</div><!--保存失败，数据并发错误！-->
            <form action="" method="" class="main_form">
                <div class="text_info clearfix"><span>管理员账号：</span></div>
                <div class="input_info"><input type="text" readonly="readonly" class="readonly" value="${admin1.acname }" /></div>
                <div class="text_info clearfix"><span>角色：</span></div>
                <div class="input_info">
                    <input type="text" readonly="readonly" class="readonly width400" value="${admin1.lr_string }" />
                </div>
                <div class="text_info clearfix"><span>姓名：</span></div>
                <div class="input_info">
                    <input type="text" name="aname" value="${admin1.aname }" />
                    <span class="required">*</span>
                    <div class="validate_msg_long error_msg">20长度以内的汉字、字母的组合</div>
                </div>
                <div class="text_info clearfix"><span>电话：</span></div>
                <div class="input_info">
                    <input type="text" name="atel"class="width200" value="${admin1.atel }" />
                    <div class="validate_msg_medium">电话号码格式：手机或固话</div>
                </div>
                <div class="text_info clearfix"><span>Email：</span></div>
                <div class="input_info">
                    <input type="text" name="aemail" class="width200" value="${admin1.aemail }" />
                    <div class="validate_msg_medium">50长度以内，符合 email 格式</div>
                </div>
                <div class="text_info clearfix"><span>创建时间：</span></div>
                <div class="input_info"><input type="text" readonly="readonly" class="readonly" value="${admin1.createTime }"/></div>
                <div class="button_info clearfix">
                    <input type="button" id="smit" value="保存" class="btn_save" />
                    <input type="button" value="取消" class="btn_save" />
             
                </div>
                    <input type="hidden" name="aid" value="${admin1.id }"/>
            </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
          
        </div>
    </body>
</html>
