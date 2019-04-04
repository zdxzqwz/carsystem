package com.it.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.it.bean.Car;
import com.it.bean.CarInfo;
import com.it.bean.PageBean;
import com.it.global.ICar;
import com.it.global.IRepair_Car;
import com.it.global.IReturn_Car;
import com.it.global.ITechnical_File;
import com.it.services.CarImpl;
import com.it.services.Out_CarServices;
import com.it.services.RepairCarServices;
import com.it.services.ReturnCarServices;
import com.it.services.Technical_FileImpl;
import com.it.utils.StringUtil;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class CarServlet
 */
@WebServlet({ "/CarServlet", "/car.do" })
public class CarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码各格式
		request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8"); 
		//获取页面信息
		String opt = request.getParameter("opt");

		String car_id = request.getParameter("car_id");//车牌号
		String car_name = request.getParameter("car_name");//车名
		String vehm_id = request.getParameter("vehm_id");//车辆型号
		String veh_id = request.getParameter("veh_id");//车辆类型
		String reg_id = request.getParameter("reg_id");//所属大区		
		String fil_id = request.getParameter("fil_id");//分公司
		String car_flag = request.getParameter("car_flag");//是否为租赁
		String car_vehicles = request.getParameter("car_vehicles");//车辆状况
		/*
		 * String car_time = request.getParameter("car_time");//操作时间
		 */		
		//生成对象
		PrintWriter out = response.getWriter();
		Car car=new Car();
		ICar icar=new CarImpl();
		CarInfo cari=new CarInfo();
		//存放集合
		List<CarInfo> list = null;
		//判断opt执行功能
		//修改功能upd
		if("upd".equals(opt)) {
			
			if(StringUtil.isNotEmpty(car_id)) {
				car.setCar_id(car_id);
			}
			if(StringUtil.isNotEmpty(car_name)) {
				car.setCar_name(car_name);
			}
			if(StringUtil.isNotEmpty(veh_id)) {
				car.setVeh_id(veh_id);
			}
			if(StringUtil.isNotEmpty(vehm_id)) {
				car.setVehm_id(vehm_id);
			}
			if(StringUtil.isNotEmpty(reg_id)) {
				car.setReg_id(reg_id);
			}
			if(StringUtil.isNotEmpty(fil_id)) {
				car.setFil_id(fil_id);
			}
			if(StringUtil.isNotEmpty(car_vehicles)) {
				car.setCar_vehicles(car_vehicles);
			}
			if(StringUtil.isNotEmpty(car_flag)) {
				car.setCar_flag(car_flag);
			}
				Long time = System.currentTimeMillis();
				Date date = new Date(time);
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String tm = dateFormat.format(date);
				car.setCar_time(tm);
				//打印car
				System.out.println("car------->"+car);
				boolean flag=icar.updCar(car);
				if(flag) {
					out.println("{\"success\": true,\"message\": \"修改车辆档案记录成功.\"}");
				}else {
					out.println("{\"error\": false,\"message\": \"修改车辆档案记录失败.\"}");
				}
				return;
		}

		//删除功能del
		if("del".equals(opt)) {
			String str=null;
			//出车
			//Out_Car outcar=new Out_Car();
			Out_CarServices ioutcar=new Out_CarServices();
			//换车
			//Return_Car rc=new Return_Car();
			IReturn_Car irc=new ReturnCarServices();
			//车辆维修
			//Repair_Car rec=new Repair_Car();
			IRepair_Car ire=new RepairCarServices();
			//车辆技术档案
			//Technical_File tf=new Technical_File();
			ITechnical_File itf=new Technical_FileImpl();
			
			JSONObject result = new JSONObject();			
			//获取前端页面的id集合
			String delIds = request.getParameter("delIds");			
              System.out.println("delIds--->"+delIds);
           // 对delIds进行截取 获String数组;
  			String[] delList = delIds.split("','");
  			if(delList!=null) {
  				for (int i = 0; i < delList.length; i++) {
					 str=delList[i];
  					if(ioutcar.findBycarId(str)) {
  						result.put("errorMsg", "该车辆信息无法删除 请联系运管部人员！");	
  						out.print(result);
  						return;
  					}
  					if(irc.findBycarId(str)) {
  						result.put("errorMsg", "该车辆信息无法删除 请联系运管部人员！");	
  						out.print(result);
  						return; 						
  					}
  					if(ire.findBycarId(str)) {
  						result.put("errorMsg", "该车辆信息无法删除 请联系运管部人员！");	
  						out.print(result);
  						return;						
  					}
  					if(itf.findBycarId(str)) {
  						result.put("errorMsg", "该车辆信息无法删除 请联系运管部人员！");	
  						out.print(result);
  						return;						
  					}
  					
				}
  			}
	
			int delNums = icar.CarDelete(delIds);
			if (delNums > 0) {
				result.put("success", true);
				result.put("delNums", delNums);
			} else {
				result.put("errorMsg", "删除失败");
			}
			
			out.print(result);
			return;
		}
		
		//添加档案addCar
		if("addCar".equals(opt)) {
			
		if(StringUtil.isNotEmpty(car_id)) {
			car.setCar_id(car_id);
		}
		if(StringUtil.isNotEmpty(car_name)) {
			car.setCar_name(car_name);
		}
		if(StringUtil.isNotEmpty(veh_id)) {
			car.setVeh_id(veh_id);
		}
		if(StringUtil.isNotEmpty(vehm_id)) {
			car.setVehm_id(vehm_id);
		}
		if(StringUtil.isNotEmpty(reg_id)) {
			car.setReg_id(reg_id);
		}
		if(StringUtil.isNotEmpty(fil_id)) {
			car.setFil_id(fil_id);
		}
		if(StringUtil.isNotEmpty(car_vehicles)) {
			car.setCar_vehicles(car_vehicles);
		}
		if(StringUtil.isNotEmpty(car_flag)) {
			car.setCar_flag(car_flag);
		}
			Long time = System.currentTimeMillis();
			Date date = new Date(time);
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String tm = dateFormat.format(date);
			car.setCar_time(tm);
			//打印car
			System.out.println("car------->"+car);
			boolean flag=icar.addCar(car);
			if(flag) {
				out.print("{\"success\": true,\"message\": \"添加车辆档案记录成功.\"}");
			}else {
				out.print("{\"error\": false,\"message\": \"添加车辆档案记录失败.\"}");
			}
			return;
		}
		
		
		//查询所有 showAll
		if("queryAll".equals(opt)) {
			String page = request.getParameter("page");
			String rows = request.getParameter("rows");
			
			if (StringUtil.isNotEmpty(car_id)) {
				cari.setCar_id(car_id);
			}
			if (StringUtil.isNotEmpty(car_vehicles)) {
				cari.setCar_vehicles(car_vehicles);
			}
			
			System.out.println("querysevlet---------->"+cari);
			JSONObject result = new JSONObject();
			PageBean pageBean = new PageBean(Integer.parseInt(page),
					Integer.parseInt(rows));
			list = icar.queryAllCarInfo(pageBean, cari);
			//查询总记录数
			int total = icar.CarCount(car);
			//传给前台jsonarray
			JSONArray jsonArray = JSONArray.fromObject(list);
			result.put("total", total);
			result.put("rows", jsonArray);
			System.out.println(result.toString());
			out.print(result);
			return;
		}

		/**
		 * 出车表调用的方法
		 */
		if("queryAll2".equals(opt)) {
			String page = request.getParameter("page");
			String rows = request.getParameter("rows");
			PageBean pageBean = new PageBean(Integer.parseInt(page),
					Integer.parseInt(rows));
			list = icar.queryAllCarInfo1(pageBean);
			//传给前台jsonarray
			JSONArray jsonArray = JSONArray.fromObject(list);
			out.print(jsonArray);
			return;
		}
		//findById
		String flag = "1";//可用
		if("findById".equals(opt)){
			// "" null
			
			if (StringUtil.isNotEmpty(car_id)) {

				car.setCar_id(car_id);

			}
			Car car1 = icar.findByIdCar(car);
			
			if(car1!=null){
				flag = "-1";
						
			}
			System.out.println("flag-->"+flag);
			out.print(flag);
			
			
		}
		
		
		
		
	}

}
