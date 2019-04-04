<%@page import="com.it.bean.Auth"%>
<%@page import="java.util.List"%>
<%@page import="com.it.bean.Users"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="stylesheet" type="text/css" href="carsystem/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="carsystem/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="carsystem/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="carsystem/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="carsystem/static/h-ui.admin/css/style.css" />
<title>北京市腾谊车管运营平台 v1.0</title>
</head>
<body>
<%
	Users user = (Users)session.getAttribute("user");
	if(user==null){
%>
	<script>
		window.alert('登陆过期，请重新登陆!');
		top.location.href="login.jsp";
	</script>
<%} %> 
<header class="navbar-wrapper">
	<div class="navbar navbar-fixed-top">
		<div class="container-fluid cl"> <a class="logo navbar-logo f-l mr-10 hidden-xs" href="/aboutHui.shtml">北京市腾谊车管运营平台</a> <a class="logo navbar-logo-m f-l mr-10 visible-xs" href="/aboutHui.shtml">H-ui</a> 
			<span class="logo navbar-slogan f-l mr-10 hidden-xs">v1.0</span> 
			<a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>
		<nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
			<ul class="cl">
				<li>${user.roleName}</li>
				<li class="dropDown dropDown_hover">
					<a href="#" class="dropDown_A">${user.user_name}<i class="Hui-iconfont">&#xe6d5;</i></a>
					<ul class="dropDown-menu menu radius box-shadow">
						<li><a href="javascript:;" onClick="myselfinfo('carsystem/member-show.html')">个人信息</a></li>
						<li><a href="carsystem/login.jsp">切换账户</a></li>
						<li><a href="javascript:;"onClick="logout()">退出</a></li>
				</ul>
			</li>
				<!-- <li id="Hui-msg"> <a href="#" title="消息"><span class="badge badge-danger">1</span><i class="Hui-iconfont" style="font-size:18px">&#xe68a;</i></a> </li> -->
				<li id="Hui-skin" class="dropDown right dropDown_hover"> <a href="javascript:;" class="dropDown_A" title="换肤"><i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a>
					<ul class="dropDown-menu menu radius box-shadow">
						<li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
						<li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
						<li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
						<li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
						<li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
						<li><a href="javascript:;" data-val="orange" title="橙色">橙色</a></li>
					</ul>
				</li>
			</ul>
		</nav>
	</div>
</div>
</header>
<aside class="Hui-aside">
	<div class="menu_dropdown bk_2">
	<%List<Auth> list = (List<Auth>)request.getAttribute("list"); %>
	<%if(list==null){ %>
		<script>
		window.alert('登陆过期，请重新登陆!');
		top.location.href="login.jsp";
		</script>
	
	<%}else{ %>
	<%
		for(Auth a: list){
			if("1".equals(a.getParentId())){
	%>
		<dl id="menu-article">
			<dt><i class="Hui-iconfont"><%=a.getBackground() %>;</i> <%=a.getAuthName() %><i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<%
					for(Auth a1: list){
						if(a.getAuthId().equals(a1.getParentId())){
					%>
					<li><a data-href="carsystem/<%=a1.getAuthPath() %>" data-title="<%=a1.getAuthName() %>" href="javascript:void(0)"><%=a1.getAuthName() %></a></li>
						<%} %>
					<%} %>
				</ul>
			</dd>
		</dl>
			<%} %>
		<%} %>
	<%} %>
</div>
</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section class="Hui-article-box">
	<div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
		<div class="Hui-tabNav-wp">
			<ul id="min_title_list" class="acrossTab cl">
				<li class="active">
					<span title="我的桌面" data-href="carsystem/welcome.html">我的桌面</span>
					<em></em></li>
		</ul>
	</div>
		<div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a></div>
</div>
	<div id="iframe_box" class="Hui-article">
		<div class="show_iframe">
			<div style="display:none" class="loading"></div>
			<iframe scrolling="yes" frameborder="0" src="carsystem/welcome.html"></iframe>
	</div>
</div>
</section>

<div class="contextMenu" id="Huiadminmenu">
	<ul>
		<li id="closethis">关闭当前 </li>
		<li id="closeall">关闭全部 </li>
</ul>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="carsystem/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="carsystem/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="carsystem/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="carsystem/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="carsystem/lib/jquery.contextmenu/jquery.contextmenu.r2.js"></script>
<script type="text/javascript">
/* $(function(){
	window.location.href="";
}); */
/*个人信息*/
function logout(){
	layer.confirm('确定退出吗？', function(){
		window.location.href="user.do?opt=logout";
	});	
	
}
function myselfinfo(url){
	
	layer_show("查看信息",url,"300","380");
	/* layer.open({
		type: 1,
		area: ['300px','200px'],
		fix: false, //不固定
		maxmin: true,
		shade:0.4,
		title: '查看信息',
		content: url
	}); */
}

/*资讯-添加*/
function article_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*图片-添加*/
function picture_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*产品-添加*/
function product_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}


</script> 


</body>

</html>