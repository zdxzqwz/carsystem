<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->

<title>修改密码 - H-ui.admin v3.1</title>
<meta name="keywords" content="H-ui.admin v3.1,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin v3.1，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="carsystem/jquery-easyui-1.4.2/themes/default/easyui.css" />
		<link rel="stylesheet" href="carsystem/jquery-easyui-1.4.2/themes/icon.css" />
		<script src="carsystem/jquery-easyui-1.4.2/jquery.min.js" charset="UTF-8"></script>
		<script src="carsystem/jquery-easyui-1.4.2/jquery.easyui.min.js" charset="UTF-8"></script>
		<script src="carsystem/jquery-easyui-1.4.2/locale/easyui-lang-zh_CN.js" charset="UTF-8"></script>
		<script>
function sub(){       
	var pwd1 = document.getElementById("pwd1");     
	var pwd2 = document.getElementById("pwd2");      
	if(pwd1!=pwd2){      
		
		alert("两次密码不一样"); 
	return false;     
	}       
	return true;  
	}
	</script>   
</head>
<body>

<article class="page-container">
	<form action="user.do?opt=pwd" method="post" class="form form-horizontal" id="form-change-password">
		<input type="hidden" name="user_id" value="${user.user_id }" placeholder="" id="user_id" name="user_id">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>新密码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="password" value="${user.user_pwd }"  class="input-text" autocomplete="off" placeholder="" name="user_pwd1" id="user_pwd1">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>确认密码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="password" value="${user.user_pwd }" class="input-text" autocomplete="off" placeholder="" name="user_pwd2" id="user_pwd2" >
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;保存&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="carsystem/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="carsystem/lib/layer/2.4/layer.js"></script>  
<script type="text/javascript" src="carsystem/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="carsystem/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="carsystem/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="carsystem/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="carsystem/lib/jquery.validation/1.14.0/messages_zh.js"></script> 
<script type="text/javascript">
$(function(){
	$("#form-change-password").validate({
		rules:{
			user_pwd1:{
				required:true,
				minlength:6,
				maxlength:16
			},
			user_pwd2:{
				required:true,
				minlength:6,
				maxlength:16,
				equalTo: "#user_pwd1"
			},
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			$(form).ajaxSubmit();
			var index = parent.layer.getFrameIndex(window.name);
			parent.$('.btn-refresh').click();
			parent.layer.close(index);
		}
	});
});
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>

</html>