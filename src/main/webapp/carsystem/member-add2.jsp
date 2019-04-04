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
<link rel="stylesheet" type="text/css" href="carsystem/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="carsystem/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="carsystem/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="carsystem/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="carsystem/static/h-ui.admin/css/style.css" />
<title>修改用户 - H-ui.admin v3.1</title>

</head>
<body onload="load('${user.roleId}')">
<article class="page-container">
	<form action="user.do?opt=upd" method="post" class="form form-horizontal" id="ff">
	<input type="hidden" value="${user.user_id }"name="user_id">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${user.user_name }" placeholder="" id="user_name" name="user_name">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>密码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="password" class="input-text" value="${user.user_pwd }" placeholder="" id="user_pwd" name="user_pwd">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>性别：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<div class="radio-box">
					<input name="user_sex" type="radio" id="sex-1" value="0" checked>
					<label for="sex-1">男</label>
				</div>
				<div class="radio-box">
					<input type="radio" id="sex-2" name="user_sex" value="1">
					<label for="sex-2">女</label>
				</div>

			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">用户角色：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select class="select" size="1" name="roleId" id="roleId" value="">
					<%-- <option value="" >请选择角色</option>
					<option value="1"<c:if test="${user.roleId eq 1}"> selected </c:if> >系统管理员</option>
					<option value="2"<c:if test="${user.roleId eq 2}"> selected </c:if>>人力资源部工作人员</option>
					<option value="3"<c:if test="${user.roleId eq 3}"> selected </c:if>>运管部工作人员</option> --%>
				</select>
				</span> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>手机：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${user.user_phone}" placeholder="" id="mobile" name="user_phone">
			</div>
		</div>
		
	
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">所在城市：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select class="select" size="1" name="user_addr">
					<option value="${user.user_addr }" selected>请选择城市</option>
					<option value="1">北京</option>
					<option value="2">上海</option>
					<option value="3">广州</option>
				</select>
				</span> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">备注：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="user_inputer" cols="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" onKeyUp="$.Huitextarealength(this,100)"></textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="carsystem/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="carsystem/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="carsystem/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="carsystem/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本--> 
<script type="text/javascript" src="carsystem/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="carsystem/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="carsystem/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="carsystem/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
	function load(id){
		//alert(id);
		$.getJSON("role.do?opt=showRole", function(data){
			$("#roleId").empty();
			var opt = "";
			$.each(data, function(i,item){
					if(id==item.roleId){
						opt+="<option value="+item.roleId+" selected>"+item.roleName+"</option>";
					}else{
						opt+="<option value="+item.roleId+">"+item.roleName+"</option>";
					}    
			});
			$("#roleId").html(opt);
		});
	}
		

</script> 
<!--/请在上方写此页面业务相关的脚本-->

</body>

</html>