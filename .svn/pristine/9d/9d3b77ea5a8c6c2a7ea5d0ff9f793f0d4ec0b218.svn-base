$(function() {
	queryAllreturnCar('','','','');
	//模糊查询，给搜索按钮绑定单击事件
	/*$("#sub").click(function(){
		var car_id = $("#car_id").val();
		var dri_name = $("#dri_name").val();
		var datemin = $("#datemin").val();
		var datemax = $("#datemax").val();
		queryAllOutCar(out_car_id,dri_name);  
	});	*/
});

function queryAllreturnCar(car_id,dri_name,datemin,datemax){
	alert("124");
	//模糊查询前先清空
	/* $("#tbody").empty();
	//页面加载事件，异步请求查询所有
	 $.getJSON("../returncar.do",{opt:"queryAll",car_id:car_id,dri_name:dri_name,datemin:datemin,datemax:datemax}, function(data){
		 alert(data);
		 //遍历后台传过来的json对象
		$.each(data, function(i,returncar){
			 $("#tbody").append("<tr class=\"text-c\"><td><input name=\"outcar\" type=\"checkbox\" value="+outcar.out_id+"></td>"+
                     "<td>"+outcar.out_id+"</td>"+
                     "<td>"+outcar.out_car_id+"</td>"+
                     "<td>"+outcar.dri_name+"</td>"+
                     "<td>"+outcar.out_why+"</td>"+
                     "<td>"+outcar.out_test+"</td>"+
                     "<td>"+outcar.out_time+"</td>"+
                     "<td>"+outcar.out_inputer+"</td>"+
                     "<td>"+outcar.out_notes+"</td>"+
                     "<td>" +
                     "<a style=\"text-decoration:none\" href=\"javascript:;\" onclick=\"member_edit('还车','returncar-add2.jsp','"+outcar.out_id+"','','510')\" title=\"还车\">" +
                     "<i class=\"Hui-iconfont\">&#xe66b;</i>" +
                     "</a>" +
                     "<a title=\"编辑\" href=\"javascript:;\" onclick=\"member_edit('编辑','outcar-add2.jsp','"+outcar.out_id+"','','510')\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6df;</i></a>" +
                     "<a title=\"删除\" href=\"javascript:;\" onclick=\"member_del(this,'"+outcar.out_id+"')\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6e2;</i></a>" +
                     "</td></tr>");
		});
	});*/
}
//批量删除
/*function datadel(){
	 var chk_value =[]; 
	    $("#tbody").find('input[name="outcar"]:checked').each(function(){ //遍历，将所有选中的值放到数组中
	        chk_value.push($(this).val()); 
	    }); 
    if(chk_value.length==0){
        layer.msg('请选中一个!', {icon: 5});
    }
    else{
    	 //给出友情提示
    	layer.confirm('您是确定删除这'+chk_value.length+'条记录吗？', function(){
    			//发起异步请求删除多条记录
    		  $.get("../outcar.do?opt=delIds&delIds="+chk_value, function(data){
    	    		layer.msg('你删除了'+data+"条纪录", {icon: 1});
    	    		setTimeout(function(){
    					window.location.reload();
    				}, 1000);
    	    	});
    		});
    	//console.log(chk_value);
    	
    	
    }
}
添加出车表
function member_add(title,url,w,h){
	layer_show(title,url,w,h);	
}
用户-编辑
function member_edit(title,url,id,w,h){
	layer.open({
		  type: 2,
		  area: ['700px', '510px'],
		  fixed: false, //不固定
		  maxmin: true,
		  content: '../outcar.do?opt=findById&out_id='+id+"&url="+url
		});
	//layer_show(title,url,w,h);
	//$.get("../outcar.do?opt=findById&out_id="+id);
	//window.location.href="../outcar.do?opt=findById&out_id="+id+"";
}
用户-删除
function member_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '../outcar.do?opt=del&out_id='+id,
			dataType: 'json',
			success: function(data){
				
				layer.msg(data.message,{icon:1,time:1000});
				setTimeout(function(){
					window.location.reload();
				}, 1000);
			},
			error:function(data) {
				window.location.reload();
				layer.msg(data.message,{icon:5,time:2000});
				
			},
		});		
	});
}*/
