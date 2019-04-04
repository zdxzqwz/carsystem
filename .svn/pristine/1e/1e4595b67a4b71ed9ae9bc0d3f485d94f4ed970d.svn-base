$(function() {
	queryAllOutCar('','',1,10);
	//模糊查询，给搜索按钮绑定单击事件
	$("#sub").click(function(){
		var out_car_id = $("#out_car_id").val();
		var dri_name = $("#dri_name").val();
		queryAllOutCar(out_car_id,dri_name,1,10);  
	});
});
//分页
function paged(curr,count){
	layui.use('laypage', function(){
		  var laypage = layui.laypage;
		  //执行一个laypage实例
		  laypage.render({
			    elem: 'page'
			    ,count: count
			    ,curr:curr
			    ,layout: ['count', 'prev', 'page', 'next', 'limit','skip']
			    ,jump: function(obj,first){
			    	console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
			        console.log(obj.limit); //得到每页显示的条数
			    	if(!first){
			    		queryAllOutCar('','',obj.curr,obj.limit);
			    	}
			    }
		});
	});
}

function queryAllOutCar(out_car_id,dri_name,curr,limit){
	//模糊查询前先清空
	 $("#tbody").empty();
	//页面加载事件，异步请求查询所有
	 $.getJSON("../outcar.do",{opt:"queryAll",out_car_id:out_car_id,dri_name:dri_name,curr:curr,limit:limit}, function(data){
		 //遍历后台传过来的json对象
		 var data = eval(data);
		 //alert(data.count);
		 $.each(data.outcar, function(i,outcar){
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
                     "<a style=\"text-decoration:none\" href=\"javascript:;\" onclick=\"member_edit2('还车','returncar-add2.jsp','"+outcar.out_id+"','','510')\" title=\"还车\">" +
                     "<i class=\"Hui-iconfont\">&#xe66b;</i>" +
                     "</a>" +
                     "<a title=\"编辑\" href=\"javascript:;\" onclick=\"member_edit('编辑','outcar-add2.jsp','"+outcar.out_id+"','','510')\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6df;</i></a>" +
                     "<a title=\"删除\" href=\"javascript:;\" onclick=\"member_del(this,'"+outcar.out_id+"')\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6e2;</i></a>" +
                     "</td></tr>");
		});
		 paged(curr,data.count);
	});
}
//批量删除
function datadel(){
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
    	    		queryAllOutCar('','',1,10);
    	    		/*setTimeout(function(){
    					window.location.reload();
    				}, 1000);*/
    	    	});
    		});	
    }
}
/*添加出车表*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);	
}
/*用户-编辑*/
function member_edit(title,url,id,w,h){
	layer.open({
		  type: 2,
		  area: ['800px', '510px'],
		  fixed: false, //不固定
		  maxmin: true,
		  content: '../outcar.do?opt=findById&out_id='+id+"&url="+url
		});
}
function member_edit2(title,url,id,w,h){
	layer.confirm('确认要还车吗？',function(){
		layer.open({
			  type: 2,
			  area: ['800px', '510px'],
			  fixed: false, //不固定
			  maxmin: true,
			  content: '../outcar.do?opt=findById&out_id='+id+"&url="+url
			});
	});
}
/*用户-删除*/
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
}
