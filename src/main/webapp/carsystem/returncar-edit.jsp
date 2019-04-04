<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<link rel="stylesheet" type="text/css" href="jquery-easyui-1.4.2/themes/default/easyui.css" charset="UTF-8" />
		<link rel="stylesheet" type="text/css" href="jquery-easyui-1.4.2/themes/icon.css" charset="UTF-8" />
		<script src="jquery-easyui-1.4.2/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="jquery-easyui-1.4.2/jquery.easyui.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="jquery-easyui-1.4.2/locale/easyui-lang-zh_CN.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
		<title>修改还车记录</title>
</head>
<body>
		<div class="" style="margin: 0 auto;margin-top: 20px;margin-left: 100px; font-size: 12px;">
			
		
        <form id="ff" method="post">
        		<input type="hidden" name="ret_id" value="${returncar.ret_id }">
        		
	    	<table cellpadding="5">
	    		<tr>
	    			<td>车牌号:</td>
	    			<td>
	    				<input class="easyui-textbox"  type="text" name="car_id" id="" value="${returncar.car_id }" readonly="readonly" style="width:250px;height:26px"/>
					</td>
	    		</tr>
	    		<tr>
	    			<td>驾驶员编号:</td>
	    			<td>
	    				<select id="cc" class="easyui-combogrid" name="dri_id" value="${returncar.dri_id }" readonly="readonly" style="width:250px;height:26px"   
							        data-options="    
							            panelWidth:500,
							            value: ${returncar.dri_id },      
							            idField:'code', 
							            required:true,
							            method:'get',
							            textField:'code',    
							            url:'datagrid_data.json',    
							            columns:[[    
							                {field:'code',title:'编号',width:60},    
							                {field:'name',title:'名字',width:100},    
							                {field:'addr',title:'地址',width:120},    
							                {field:'col4',title:'电话',width:100}    
							            ]]    
							        "></select>
					</td>
	    		</tr>
	    		<tr>
	    			<td>驾驶员姓名:</td>
	    			<td>
	    				<input class="easyui-textbox"  type="text" name="dri_name" id="" value="${returncar.dri_name }" readonly="readonly" style="width:250px;height:26px"/>
					</td>
	    		</tr>
	    		<tr>
	    			<td>出车事由:</td>
	    			<td><input class="easyui-textbox"  type="text" name="ret_out_why" id="" value="${returncar.ret_out_why } "validType="midLength[5,10]" missingMessage="出车事由必填!" style="width:250px;height:26px"/></td>
	    		</tr>
	    		<tr>
	    			<td>目的地:</td>
	    			<td><input class="easyui-textbox"  type="text" name="ret_out_test" id="" value="${returncar.ret_out_test }" validType="val[5,10]" missingMessage="目的地必填!"  style="width:250px;height:26px"/></td>
	    		</tr>
	    		<tr>
	    			<td>出车时间:</td>
	    			<td>
	    				<input class="easyui-datetimebox" name="ret_out_time"data-options="required:true,showSeconds:false,editable:false,panelWidth:250" value="${returncar.ret_out_time }" style="width:250px;height:26px">
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>还车时间:</td>
	    			<td>
	    				<input class="easyui-datetimebox" name="ret_return_time" id="ret_return_time" data-options="required:true,showSeconds:false,panelWidth:250" value="${returncar.ret_return_time }" style="width:250px;height:26px">
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>备注:</td>
	    			<td>
	    				<input class="easyui-textbox" data-options="multiline:true" name="ret_notes" value="${returncar.ret_notes }" style="width:300px;height:100px">
	    			</td>
	    		</tr>
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="submitForm()">保存</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="clearForm()">清空</a>
	    </div>
	</div>
	<script type="text/javascript">
	//表单验证
	$(function(){
		//验证器
		$.extend($.fn.validatebox.defaults.rules, {   
			midLength: {   
			 			validator: function(value, param){   
    						return value.length >= param[0] && value.length <= param[1];    
					},   
				message: '出车事由必须在{0}到{1}个字符之间!'  
			} ,
			val: {   
				validator: function(value, param){   
					return value.length >= param[0] && value.length <= param[1];    
				},   
				message: '目的地必须在{0}到{1}个字符之间!'  
			}
		}); 
		//日期验证
		$('#ret_return_time').datebox({
			required:true , 
			missingMessage:'还车时间必填!' ,
			editable:false
		});

	});
	//表单提交
		function submitForm(){
			$('#ff').form('submit', {    
			    url:"../returncar.do?opt=upd",    
			    onSubmit: function(){    
			    	return $(this).form("validate");
			    },    
			    success:function(data){   
			    	var data = eval('(' + data + ')'); 
			    	//alert(data.success);
			       	if(data.success){
			       	 	layer.msg('修改还车信息成功!', {icon: 1});
				       	 setTimeout(function(){
				       		parent.location.href = "returncar-list.html";
		    				}, 1500);
			       	}else{
			       		layer.msg('修改还车信息失败!', {icon: 5});
			       		setTimeout(function(){
				       		parent.location.href = "returncar-list.html";
		    				}, 1500);
			       	}   
			    }    
			}); 
		}
	//清空内容
	function clearForm(){
		var index = parent.layer.getFrameIndex(window.name);
		parent.layer.close(index);
	}
	</script>
	</body>

</html>