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
		<script src="js/outcar.js">
		</script>

		<title>添加费用记录</title>
	</head>
<body>
		<div class="" style="width: 500px;margin: 0 auto;padding-left: 50px;margin-top: 20px;font-size: 10px;">
			
		
        <form id="ff" method="post">
        	<input type="hidden" name="exp_id" value="${expense.exp_id }">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>还车编号:</td>
	    			<td>
	    				<input class="easyui-textbox" precision="2" name="ret_id" value="${expense.ret_id }"/>
					</td>
	    		</tr>
	    		<tr>
	    			<td>加水费:</td>
	    			<td>
	    				<input class="easyui-numberbox" precision="2" name="exp_water" value="${expense.exp_water }"/>
					</td>
	    		</tr>
	    		<tr>
	    			<td>停车费:</td>
	    			<td>
	    				<input class="easyui-numberbox" precision="2" name="exp_park" value="${expense.exp_park }"/>
					</td>
	    		</tr>
	    		<tr>
	    			<td>洗车费:</td>
	    			<td>
	    				<input class="easyui-numberbox" precision="2" name="exp_wash" value="${expense.exp_wash }"/>
					</td>
	    		</tr>
	    		<tr>
	    			<td>过路费:</td>
	    			<td>
	    				<input class="easyui-numberbox" precision="2" name="exp_toll" value="${expense.exp_toll }"/>
					</td>
	    		</tr>
	    		<tr>
	    			<td>燃油费:</td>
	    			<td>
	    				<input class="easyui-numberbox" precision="2" name="exp_fuel" value="${expense.exp_fuel }"/>
					</td>
	    		</tr>
	    		<tr>
	    			<td>保养费:</td>
	    			<td>
	    				<input class="easyui-numberbox" precision="2" name="exp_upkeep" value="${expense.exp_upkeep }"/>
					</td>
	    		</tr>
	    		<tr>
	    			<td>年检费:</td>
	    			<td>
	    				<input class="easyui-numberbox" precision="2" name="exp_annual" value="${expense.exp_annual }"/>
					</td>
	    		</tr>
	    		<tr>
	    			<td>保险费:</td>
	    			<td><input class="easyui-numberbox" precision="2" name="exp_insure" value="${expense.exp_insure }"/></td>
	    		</tr>
	    		<tr>
	    			<td>总计:</td>
	    			<td><%-- <input class="easyui-numberbox" precision="2" id="exp_price"  name="exp_price" value="${expense.exp_price }"/> --%>
	    				<input type="text" id="nn"  name="exp_price"  value="${expense.exp_price }"></input>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>备注:</td>
	    			<td>
	    				<input class="easyui-textbox" data-options="multiline:true" name="exp_notes" value="${expense.exp_notes }" style="width:300px;height:100px">
	    				
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

		
		
		//提交
		function submitForm(){
			
			$('#ff').form('submit', {    
			    url:"../expense.do?opt=upd",    
			    onSubmit: function(){    
			    	return $(this).form("validate");
			    },    
			    success:function(data){  
			    	//alert(data);
			    	var data = eval('(' + data + ')');  
			    	//alert(data.success);
			       	if(data.success){
			       		//alert("修改成功");
			       		$.messager.alert('提示','保存成功!','info');
			       	 	//layer.msg('修改出车信息成功!', {icon: 1});
				       	 setTimeout(function(){
				       		parent.location.href = "returncar-list.html";
		    				}, 1500);
			       	}else{
			       		$.messager.alert('提示','保存失败','warning');
			       		//layer.msg('修改出车信息失败!', {icon: 5});
			       		setTimeout(function(){
				       		parent.location.href = "returncar-list.html";
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