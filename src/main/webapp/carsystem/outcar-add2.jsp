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
	<link rel="stylesheet" type="text/css" href="css/public.css" />
	<link rel="stylesheet" type="text/css" href="jquery-easyui-1.4.2/themes/default/easyui.css" charset="UTF-8" />
	<link rel="stylesheet" type="text/css" href="jquery-easyui-1.4.2/themes/icon.css" charset="UTF-8" />
	<script src="jquery-easyui-1.4.2/jquery.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
	<script src="jquery-easyui-1.4.2/jquery.easyui.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="jquery-easyui-1.4.2/locale/easyui-lang-zh_CN.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
	<title>添加出车记录</title>
</head>
<body>
		<div class="" style="width: 500px;margin: 0 auto;padding-left: 50px;margin-top: 20px;font-size: 12px;">
			
		
        <form id="ff" method="post">
        	<input type="hidden" name="out_id" value="${out_car.out_id }">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>车牌号:</td>
	    			<td>
	    				<select id="out_car_id" class="easyui-combogrid" name="out_car_id" style="width:250px;height:26px"   
						        data-options="  
						        required:true,
						        invalidMessage:'车牌号必填',
						        missingMessage:'车牌号必填',
						            panelWidth:535,
						            panelHeight:300,  
						            idField:'car_id', 
						            editable:false, 
						            value:'${out_car.out_car_id }',  
						            textField:'car_id',    
						            url:'../car.do?opt=queryAll2', 
						            pagination:true,
						            method:'get',
						            columns:[[    
						                {field:'car_id',title:'车牌号',width:80},    
						                {field:'car_name',title:'车辆名称',width:80},    
						                {field:'car_flag',title:'租赁车辆',width:120,hidden:true},    
						                {field:'car_time',title:'添加时间',width:100,hidden:true}, 
						                {field:'car_vehicles',title:'车辆状况',width:80},
						                {field:'vehm_name',title:'车辆型号',width:80},
						                {field:'veh_name',title:'车辆类型',width:70},
						                {field:'reg_name',title:'所属大区',width:70},  
						                {field:'fil_name',title:'分公司',width:70} 
						            ]]    
						        "></select>
					</td>
	    		</tr>
	    		<tr>
	    			<td>驾驶员编号:</td>
	    			<td>
	    				<select id="dri_id" class="easyui-combogrid" name="dri_id" style="width:250px;height:26px"   
							        data-options="    
							            panelWidth:450, 
							            panelHeight:300,
							             missingMessage:'驾驶员编号必填',      
							            idField:'dri_id', 
							            required:true,
							            value:'${out_car.dri_id }', 
							            method:'get',
							            pagination:true,
							            editable:false,
							            textField:'dri_id',    
							            url:'../driver.do?opt=queryAll2',    
							            columns:[[    
							                {field:'dri_id',title:'编号',width:30},    
							                {field:'dri_name',title:'名字',width:60},    
							                {field:'dri_age',title:'年龄',width:35},    
							                {field:'dri_sex',title:'性别',width:35},
							                {field:'dri_addr',title:'地址',width:100},    
							                {field:'dri_phone',title:'电话',width:90}, 
							                {field:'dri_lic_id',title:'驾照编号',width:50,hidden:true},    
							                {field:'dri_lic_type',title:'驾照类型',width:70}, 
							                {field:'dri_cer_no',title:'资格证号',width:100,hidden:true},    
							                {field:'dri_cer_type',title:'从业证类别',width:50,hidden:true}, 
							                {field:'dir_hiredate',title:'入职日期',width:80,hidden:true},    
							                {field:'dir_termdate',title:'离职日期',width:80,hidden:true}    
							            ]]    
							        "></select> 
					</td>
	    		</tr>
	    		<%-- <tr>
	    			<td>驾驶员姓名:</td>
	    			<td><input class="easyui-textbox" value="${out_car.dri_name }" type="text" name="dri_name" data-options="required:true" style="width:250px;height:26px"/></td>
	    		</tr> --%>
	    		<tr>
	    			<td>出车事由:</td>
	    			<td><input class="easyui-textbox" value="${out_car.out_why }" type="text" name="out_why" data-options="required:true" validType="midLength[5,10]" missingMessage="出车事由必填!"  style="width:250px;height:26px"/></td>
	    		</tr>
	    		<tr>
	    			<td>目的地:</td>
	    			<td><input class="easyui-textbox" value="${out_car.out_test }" type="text" name="out_test" data-options="required:true"  validType="val[5,10]" missingMessage="目的地必填!"  style="width:250px;height:26px"/></td>
	    		</tr>
	    		<tr>
	    			<td>出车时间:</td>
	    			<td>
	    				<input class="easyui-datetimebox" id="out_time" name="out_time"data-options="required:true,showSeconds:false,editable:false,panelWidth:250" value="${out_car.out_time }" style="width:250px;height:26px">
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>出车备注:</td>
	    			<td>
	    				<input class="easyui-textbox" data-options="multiline:true" name="out_notes" value="${out_car.out_notes }" style="width:300px;height:100px">
	    			</td>
	    		</tr>
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="submitForm()">保存</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="clearForm()">取消</a>
	    </div>
	</div>
	<script type="text/javascript">
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
			$('#out_time').datebox({
				required:true , 
				missingMessage:'出车时间必填!' ,
				editable:false
			});
	
		});
		function submitForm(){
			$('#ff').form('submit', {    
			    url:"../outcar.do?opt=upd",    
			    onSubmit: function(){    
			    	return $(this).form("validate");
			    },    
			    success:function(data){   
			    	var data = eval('(' + data + ')');  
			       	if(data.success){
			       		
			       	 	layer.msg('修改出车信息成功!', {icon: 1});
				       	 setTimeout(function(){
				       		parent.location.href = "outcar-list.html";
		    				}, 1500);
			       	}else{
			       		//$.messager.alert('提示','修改出车信息失败!','warning');
			       		layer.msg('修改出车信息失败!', {icon: 5});
			       		setTimeout(function(){
				       		parent.location.href = "outcar-list.html";
		    				}, 1500);
			       	}
			       	
			        
			    }    
			}); 
			//clearForm();
		}
		function alertsuccess(){
			$.messager.alert('提示','添加出车信息成功!','info');
			layer.closeAll();
		}
		//取消输入
		function clearForm(){	
			var index = parent.layer.getFrameIndex(window.name);
			parent.layer.close(index);
		}
	</script>
	</body>

</html>