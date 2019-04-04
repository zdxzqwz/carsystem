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
		<link rel="stylesheet" type="text/css" href="css/public.css" />
		<link rel="stylesheet" type="text/css" href="jquery-easyui-1.4.2/themes/default/easyui.css" charset="UTF-8" />
		<link rel="stylesheet" type="text/css" href="jquery-easyui-1.4.2/themes/icon.css" charset="UTF-8" />
		<script src="jquery-easyui-1.4.2/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="jquery-easyui-1.4.2/jquery.easyui.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="jquery-easyui-1.4.2/locale/easyui-lang-zh_CN.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/outcar.js">
		</script>

		<title>在出车记录里添加还车记录</title>
</head>
<body>
		<div class="" style="margin: 0 auto;margin-top: 20px;margin-left: 100px; font-size: 12px;">
			
		
        <form id="ff" method="post">
        		<input type="hidden" name="out_id" value="${out_car.out_id }">
        		<input type="hidden" name="out_inputer" value="${out_car.out_inputer }">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>车牌号:</td>
	    			<td>
	    				<input class="easyui-textbox"  type="text" name="car_id" id="" value="${out_car.out_car_id }" readonly="readonly" style="width:250px;height:26px"/>
					</td>
	    		</tr>
	    		<tr>
	    			<td>驾驶员编号:</td>
	    			<td>
	    				<input class="easyui-textbox"  type="text" name="dri_id" id="" value="${out_car.dri_id }" readonly="readonly" style="width:250px;height:26px"/>
					</td>
	    		</tr>
	    		<tr>
	    			<td>驾驶员姓名:</td>
	    			<td>
	    				<input class="easyui-textbox"  type="text" name="dri_name" id="" value="${out_car.dri_name }" readonly="readonly" style="width:250px;height:26px"/>
					</td>
	    		</tr>
	    		<tr>
	    			<td>出车事由:</td>
	    			<td><input class="easyui-textbox"  type="text" name="ret_out_why" id="" value="${out_car.out_why } "validType="midLength[5,10]" missingMessage="出车事由必填!" style="width:250px;height:26px"/></td>
	    		</tr>
	    		<tr>
	    			<td>目的地:</td>
	    			<td><input class="easyui-textbox"  type="text" name="ret_out_test" id="" value="${out_car.out_test }" validType="val[5,10]" missingMessage="目的地必填!" style="width:250px;height:26px"/></td>
	    		</tr>
	    		<tr>
	    			<td>出车时间:</td>
	    			<td>
	    				<input class="easyui-textbox"  type="text" name="ret_out_time" id="" value="${out_car.out_time }" readonly="readonly" style="width:250px;height:26px"/>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>还车时间:</td>
	    			<td>
	    				<input class="easyui-datetimebox" name="ret_return_time" id="ret_return_time" data-options="required:true,showSeconds:false,editable:false,panelWidth:250" value="" style="width:250px;height:26px">
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>备注:</td>
	    			<td>
	    				<input class="easyui-textbox" data-options="multiline:true" name="ret_notes" value="${out_car.out_notes }" style="width:300px;height:100px">
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
			    url:"../returncar.do?opt=add",    
			    onSubmit: function(){    
			    	return $(this).form("validate");
			    },    
			    success:function(data){  
			    	//alert(data);
			    	var data = eval('(' + data + ')');  
			    	//alert(data.success);
			       	if(data.success){
			       		//alert("修改成功");
			       		$.messager.alert('提示','还车成功!','info');
			       	 	//layer.msg('修改出车信息成功!', {icon: 1});
				       	 setTimeout(function(){
				       		parent.location.href = "outcar-list.html";
		    				}, 1500);
			       	}else{
			       		$.messager.alert('提示','还车失败','warning');
			       		//layer.msg('修改出车信息失败!', {icon: 5});
			       		setTimeout(function(){
				       		parent.location.href = "outcar-list.html";
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