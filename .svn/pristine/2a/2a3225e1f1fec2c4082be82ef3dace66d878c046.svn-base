package com.it.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.it.bean.PageBean;
import com.it.bean.Repair_Car;
import com.it.bean.Users;
import com.it.services.CarImpl;
import com.it.services.RepairCarServices;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class Repair_CarServlet
 */
@WebServlet(
		asyncSupported = true, 
		urlPatterns = { 
				"/Repair_CarServlet", 
				"/repaircar.do"
		})
public class Repair_CarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Repair_CarServlet() {
        super();
        
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
		//设置编码格式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//获取页面信息
		String opt = request.getParameter("opt");
		String rep_car_id = request.getParameter("rep_car_id");//车牌号
		String rep_id = request.getParameter("rep_id");//修理编号
		String rep_maintain = request.getParameter("rep_maintain");//修理厂
		String rep_details = request.getParameter("rep_details");//修理详情
		String rep_price = request.getParameter("rep_price");//修理价格
		String rep_out_time = request.getParameter("rep_out_time");//送修时间
		String rep_return_time = request.getParameter("rep_return_time");//取车时间
		String rep_notes = request.getParameter("rep_notes");//维修备注
		//生成对象
		PrintWriter out = response.getWriter();
		Repair_Car repairCar = new Repair_Car();
		RepairCarServices carServices = new RepairCarServices();
		//判断opt，执行对应功能
		//批量删除功能
		if("delIds".equals(opt)) {
			String delIds = request.getParameter("delIds");//批量删除获取id;
			if(!"".equals(delIds)&&delIds!=null) {
				int count = carServices.repairCarDelete(delIds);
				out.print(count);
			}
			return;
		}
		//查找单个车辆维修纪录
		if("findById".equals(opt)) {
			String url = request.getParameter("url");
			if(!"".equals(rep_id)&&rep_id!=null) {
				repairCar.setRep_id(rep_id);
			}
			Repair_Car repairCar1 = carServices.findByIdRepairCar(repairCar);
			HttpSession session = request.getSession();
			session.setAttribute("repaircar", repairCar1);
			System.out.println(repairCar1);
			out.print("<script>");
			out.print("window.location.href=\"carsystem/"+url+"\"");
			out.print("</script>");
			return;
		}
		//修改车辆维修记录
		if("upd".equals(opt)) {
			if(!"".equals(rep_id)&&rep_id!=null) {
				repairCar.setRep_id(rep_id);
			}
			if(!"".equals(rep_car_id)&&rep_car_id!=null) {
				repairCar.setRep_car_id(rep_car_id);
			}
			if(!"".equals(rep_maintain)&&rep_maintain!=null) {
				repairCar.setRep_maintain(rep_maintain);
			}
			if(!"".equals(rep_details)&&rep_details!=null) {
				repairCar.setRep_details(rep_details);
			}
			if(!"".equals(rep_price)&&rep_price!=null) {
				repairCar.setRep_price(rep_price);
			}
			if(!"".equals(rep_out_time)&&rep_out_time!=null) {
				repairCar.setRep_out_time(rep_out_time);
			}
			if(!"".equals(rep_return_time)&&rep_return_time!=null) {
				repairCar.setRep_return_time(rep_return_time);
			}
			if(!"".equals(rep_notes)&&rep_notes!=null) {
				repairCar.setRep_notes(rep_notes);
			}
			Users user = (Users)request.getSession().getAttribute("user");
			repairCar.setRep_inputer(user.getUser_name());
			if(carServices.updRepairCar(repairCar)) {
				out.print("{\"success\": true,\"message\": \"修改成功.\"}");
			}else {
				out.print("{\"success\": false,\"message\": \"修改失败.\"}");
			}
			return;
		}
		//添加车辆维修记录
		if("add".equals(opt)) {
			if(!"".equals(rep_car_id)&&rep_car_id!=null) {
				repairCar.setRep_car_id(rep_car_id);
			}
			if(!"".equals(rep_maintain)&&rep_maintain!=null) {
				repairCar.setRep_maintain(rep_maintain);
			}
			if(!"".equals(rep_details)&&rep_details!=null) {
				repairCar.setRep_details(rep_details);
			}
			if(!"".equals(rep_price)&&rep_price!=null) {
				repairCar.setRep_price(rep_price);
			}
			if(!"".equals(rep_out_time)&&rep_out_time!=null) {
				repairCar.setRep_out_time(rep_out_time);
			}
			if(!"".equals(rep_return_time)&&rep_return_time!=null) {
				repairCar.setRep_return_time(rep_return_time);
			}
			if(!"".equals(rep_notes)&&rep_notes!=null) {
				repairCar.setRep_notes(rep_notes);
			}
			Users user = (Users)request.getSession().getAttribute("user");
			repairCar.setRep_inputer(user.getUser_name());
			if(new CarImpl().updVehicles(rep_car_id,"维修中")) {
				if(carServices.addRepairCar(repairCar)) {
					out.print("{\"success\": true,\"message\": \"添加成功.\"}");
				}else {
					out.print("{\"success\": false,\"message\": \"添加失败.\"}");
				}
			}else {
				out.print("{\"success\": false,\"message\": \"添加失败.\"}");
			}
			
			return;
		}
		//车辆修理成功，取回车辆
		if("quche".equals(opt)) {
			if(!"".equals(rep_id)&&rep_id!=null) {
				repairCar.setRep_id(rep_id);
			}
			if(!"".equals(rep_car_id)&&rep_car_id!=null) {
				repairCar.setRep_car_id(rep_car_id);
			}
			
			Long time = System.currentTimeMillis();
			Date date = new Date(time);
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String tm = dateFormat.format(date);
			repairCar.setRep_return_time(tm);
			new CarImpl().updVehicles(rep_car_id,"空闲");
			if(carServices.quche(repairCar)) {
				out.print("{\"success\": true,\"message\": \"取车成功.\"}");
			}else {
				out.print("{\"success\": false,\"message\": \"取车失败.\"}");
			}
			return;
		}
		//删除单个维修记录
		if("del".equals(opt)) {
			if(!"".equals(rep_id)&&rep_id!=null) {
				repairCar.setRep_id(rep_id);
			}
			if(carServices.delRepairCar(repairCar)) {
				out.print("{\"success\": true,\"message\": \"删除维修记录成功.\"}");
			}else {
				out.print("{\"success\": false,\"message\": \"删除维修记录成功.\"}");
			}
			return;
		}
		//查询所有、模糊查询和分页
		if("queryAll".equals(opt)) {
			String datemin = request.getParameter("datemin");//日期范围
			String datemax = request.getParameter("datemax");//日期范围
			String page = request.getParameter("curr");
			String limit = request.getParameter("limit");
			if(!"".equals(rep_car_id)&&rep_car_id!=null) {
				repairCar.setRep_car_id(rep_car_id);
			}
			if(!"".equals(rep_maintain)&&rep_maintain!=null) {
				repairCar.setRep_maintain(rep_maintain);
			}
			if("".equals(page)&&page==null) {
				page = "1";
			}
			if("".equals(limit)&&limit==null) {
				limit = "10";
			}
			PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(limit));
			List<Repair_Car> list = carServices.queryAllRepairCar(pageBean, repairCar, datemin, datemax);
			JSONArray array = JSONArray.fromObject(list);
			int count = carServices.repairCarCount(repairCar, datemin, datemax);
			String a = "{\"count\":"+count+",\"repaircar\":"+array+"}";
			out.print(a);
			return;
		}
	}

}
