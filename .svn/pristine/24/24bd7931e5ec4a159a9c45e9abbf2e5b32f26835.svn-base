<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.it.bean.Users"%>
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
<title>用户管理</title>
 <link rel="stylesheet" href="js/jquery-easyui-1.4.2/themes/default/easyui.css" />
		<link rel="stylesheet" href="jquery-easyui-1.4.2/themes/icon.css" />
		<script src="jquery-easyui-1.4.2/jquery.min.js" charset="UTF-8"></script>
		<script src="jquery-easyui-1.4.2/jquery.easyui.min.js" charset="UTF-8"></script>
		<script src="jquery-easyui-1.4.2/locale/easyui-lang-zh_CN.js" charset="UTF-8"></script>
		<script>
		function deleteUsers(){
			//获取选中要删除的行
			varselected Rows = $("#dg").datagrid('getSelections');
			if(selectedRows.lenth==0){
				$.messager.alert('系统提示','请选择要删除的数据');
				return;
			}
			}
		//实现删除多条记录
		var strIds=[];
		for(var i=0;i<selectedRows.length;i++){
			strIds.push(selectedRows[i].user_id);
			
		}
		var ids=strIds.join(",");
		
	
		$.messager.confirm("系统提示","您确认要删除这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
			if(r){
				//发起异步请求
				$.post("user.do?opt=del",{delIds:ids},function(result){
					if(result.success){
						$.messager.alert('系统提示',"您已成功删除<font color=red>"+result.delNums+"</font>条数据！");
						$("#dg").datagrid("reload");
					}else{
						$.messager.alert('系统提示',result.errorMsg);
					}
				},"json");
			}
		});
	
		</script>
</head>

<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 用户中心 <span class="c-gray en">&gt;</span> 用户管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<!--<div class="text-c"> 日期范围：-->
		<!--<input type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" id="datemin" class="input-text Wdate" style="width:120px;">
		--->
	<!--	<input type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d' })" id="datemax" class="input-text Wdate" style="width:120px;">-->
		<input type="text" class="input-text" style="width:250px" placeholder="输入用户名称、电话" id="" name="">
		<button type="submit" class="btn btn-success radius" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜用户</button>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a href="javascript:;" onclick="member_add('添加用户','carsystem/member-add.jsp','','510')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加用户</a></span> <span class="r">共有数据：<strong>88</strong> 条</span> </div>
	<div class="mt-20">
	
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
				<th width="25"><input type="checkbox" name="" value=""></th>
				<th width="50">用户编号</th>
				<th width="50">用户密码</th>
				<th width="60">用户姓名</th>
				<th width="40">性别</th>
				<th width="90">角色</th>
				<th width="50">地址</th>
				<th width="90">手机</th>
			
				
				<th width="130">加入时间</th>
				<th width="130">备注</th>
				<th width="130">操作</th>
				
			</tr>
		</thead>
		<tbody>
		<%
		List<Users> list = (List<Users>)request.getAttribute("list");
		for(int i = 0 ;i < list.size();i++ ){
			Users users = list.get(i);
		
		%>
		<tr class="text-c">
		<td><input type="checkbox" value="1" name=""></td>
		
		<td><%=users.getUser_id() %></td>
		
		<td><%=users.getUser_pwd() %></td>
		<td><u style="cursor:pointer" class="text-primary" onclick="member_show('<%=users.getUser_name() %>','carsystem/member-show.html','10001','360','400')"><%=users.getUser_name() %></u></td>
		<td><%=users.getUser_sex() %></td>
		<td><%=users.getRoleName() %></td>
		<td class="text-l"><%=users.getUser_addr() %></td>
		<td><%=users.getUser_phone() %></td>
		<td><%=users.getCreate_time() %></td>
		<td><%=users.getUser_inputer() %></td>
	
		<td class="td-manage">
					<a title="编辑" href="javascript:;" onclick="member_edit('编辑','user.do?opt=findById&user_id=<%=users.getUser_id()%>','4','','510')" class="ml-5" style="text-decoration:none">
						<i class="Hui-iconfont">&#xe6df;</i>
					</a> 
					<a style="text-decoration:none" class="ml-5" onClick="change_password('修改密码','user.do?opt=findById2&user_id=<%=users.getUser_id() %>','10001','600','270')" href="javascript:;" title="修改密码">
						<i class="Hui-iconfont">&#xe63f;</i>
						
					</a> 
					<a title="删除" href="user.do?opt=del&user_id=<%=users.getUser_id() %>"   class="ml-5" style="text-decoration:none">
						<i class="Hui-iconfont">&#xe6e2;</i>
						
		
			</a>
				</td>
	
		</tr>
		
		
		
		<%} %> 
	<!-- 	<tr class="text-c">
				<td><input type="checkbox" value="1" name=""></td>
				<td>1</td>
				<td><u style="cursor:pointer" class="text-primary" onclick="member_show('张三','member-show.html','10001','360','400')">张三</u></td>
				<td>男</td>
				<td>13000000000</td>
				<td>admin@mail.com</td>
				<td class="text-l">北京市 海淀区</td>
				<td>2014-6-11 11:11:42</td>
				<td>没有备注</td>
				<td class="td-status"><span class="label label-success radius">已启用</span></td>
				<td class="td-manage">
					<a style="text-decoration:none" onClick="member_stop(this,'10001')" href="javascript:;" title="停用">
						<i class="Hui-iconfont">&#xe631;</i>
					</a>
					<a title="编辑" href="javascript:;" onclick="member_edit('编辑','member-add.html','4','','510')" class="ml-5" style="text-decoration:none">
						<i class="Hui-iconfont">&#xe6df;</i>
					</a> 
					<a style="text-decoration:none" class="ml-5" onClick="change_password('修改密码','change-password.html','10001','600','270')" href="javascript:;" title="修改密码">
						<i class="Hui-iconfont">&#xe63f;</i>
					</a> 
					<a title="删除" href="javascript:;" onclick="member_del(this,'1')" class="ml-5" style="text-decoration:none">
						<i class="Hui-iconfont">&#xe6e2;</i>
					</a>
				</td>
			</tr> -->
		
		</tbody>
	</table>
	
	</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="carsystem/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="carsystem/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="carsystem/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="carsystem/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="carsystem/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="carsystem/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="carsystem/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
$(function(){
	/*$('.table-sort').dataTable({
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,8,9]}// 制定列不参与排序
		]
	});
	*/
});
/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*用户-查看*/
function member_show(title,url,id,w,h){
	layer_show(title,url,w,h);
}

/*用户-编辑*/
function member_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*密码-修改*/
function change_password(title,url,id,w,h){
	layer_show(title,url,w,h);	
}
/*用户-删除*/
function member_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '',
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").remove();
				layer.msg('已删除!',{icon:1,time:1000});
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}
</script> 
</body>
</html>