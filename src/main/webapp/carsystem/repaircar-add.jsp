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
		<script src="jquery-easyui-1.4.2/jquery.easyui.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="jquery-easyui-1.4.2/locale/easyui-lang-zh_CN.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
		<title>添加车辆维修记录</title>
	</head>
<body>
	<div class="" style="width: 500px;margin: 0 auto;padding-left: 50px;margin-top: 10px;font-size: 12px;">
        <form id="ff" method="post">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>车牌号:</td>
	    			<td>
	    				<select id="out_car_id" class="easyui-combogrid" name="rep_car_id" style="width:250px;height:26px"   
						        data-options="  
						        required:true,
						        invalidMessage:'车牌号必填',
						        missingMessage:'车牌号必填',
						            panelWidth:535,
						            panelHeight:300,  
						            idField:'car_id', 
						            editable:false,   
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
	    			<td>维修厂:</td>
	    			<td>
	    				<input class="easyui-textbox" type="text" value="" name="rep_maintain" validType="midLength[5,10]" missingMessage="维修厂名字必填!"  data-options="required:true" style="width:250px;height:26px"/>
					</td>
	    		</tr>
	    		<tr>
	    			<td>维修详情:</td>
	    			<td><input class="easyui-textbox" type="text" value="" name="rep_details"  validType="val[10,20]" missingMessage="维修详情必填!"  data-options="required:true" style="width:250px;height:26px"/></td>
	    		</tr>
	    		<tr>
	    			<td>共计费用:</td>
	    			<td><input class="easyui-textbox" type="text" value="" name="rep_price" id="rep_price" data-options="required:true"style="width:250px;height:26px"/></td>
	    		</tr>
	    		<tr>
	    			<td>送修日期:</td>
	    			<td>
	    				<input class="easyui-datetimebox" name="rep_out_time" id="rep_out_time" data-options="required:true,showSeconds:false,editable:false,panelWidth:250" value="" style="width:250px;height:26px">
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>取车日期:</td>
	    			<td>
	    				<input class="easyui-datetimebox" name="rep_return_time"data-options="showSeconds:false,disabled:true,editable:false,panelWidth:250" value="" style="width:250px;height:26px">
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>修理备注:</td>
	    			<td>
	    				<input class="easyui-textbox" name="rep_notes" data-options="multiline:true" value="" style="width:300px;height:100px">
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
	//表单验证
	$(function(){
		//验证器
		$.extend($.fn.validatebox.defaults.rules, {   
			midLength: {   
			 			validator: function(value, param){   
    						return value.length >= param[0] && value.length <= param[1];    
					}  , 
				message: '修理厂必须在{0}到{1}个字符之间!'
				
			} ,
			val: {   
				validator: function(value, param){   
					return value.length >= param[0] && value.length <= param[1];    
				},   
				message: '维修详情必须在{0}到{1}个字符之间!'  
			}
		}); 
		//日期验证
		$('#rep_out_time').datebox({
			required:true , 
			missingMessage:'送修日期时间必填!' ,
			editable:false
		});
		//价格验证框
		$('#rep_price').numberbox({
			min:0 , 
			max:20000 ,
			required:true , 
			missingMessage:'费用必填!' ,
			precision:2
		});

	});
		//提交
		function submitForm(){
			$('#ff').form('submit', {    
			    url:"../repaircar.do?opt=add",    
			    onSubmit: function(){    
			    	return $(this).form("validate");
			    },    
			    success:function(data){   
			    	var data = eval('(' + data + ')');  
			       	if(data.success){
			       	 	layer.msg('添加成功!', {icon: 1});
				       	 setTimeout(function(){
				       		parent.location.href = "repaircar-list.html";
		    				}, 1500);
			       	}else{
			       		layer.msg('添加失败!', {icon: 5});
			       		setTimeout(function(){
				       		parent.location.href = "repaircar-list.html";
		    				}, 1500);
			       	}   
			    }    
			});
		}
		//取消输入
		function clearForm(){	
			var index = parent.layer.getFrameIndex(window.name);
			parent.layer.close(index);
		}
	</script>
	</body>

</html>