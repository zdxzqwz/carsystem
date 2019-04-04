package com.it.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.it.bean.DriverInfo;
import com.it.bean.Out_Car;
import com.it.bean.PageBean;
import com.it.bean.Users;
import com.it.global.IDriverInfo;
import com.it.global.IOut_CarServices;
import com.it.services.CarImpl;
import com.it.services.DriverInfoImpl;
import com.it.services.Out_CarServices;
import com.it.utils.StringUtil;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class Out_CarServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/Out_CarServlet", "/outcar.do" })
public class Out_CarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Out_CarServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码各格式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 获取页面信息
		String opt = request.getParameter("opt");
		String out_id = request.getParameter("out_id");
		String dri_id = request.getParameter("dri_id");// 驾驶员编号
		String out_car_id = request.getParameter("out_car_id");// 车牌号
		String out_why = request.getParameter("out_why");// 出车事由
		String out_test = request.getParameter("out_test");// 目的地
		String out_notes = request.getParameter("out_notes");// 出车备注
		String dri_name = request.getParameter("dri_name");// 驾驶员姓名
		String url = request.getParameter("url");//修改和还车打开不同的url
		String delIds = request.getParameter("delIds");//批量删除获取id;
		String out_time = request.getParameter("out_time");
		// 生成对象
		PrintWriter out = response.getWriter();
		Out_Car out_car = new Out_Car();
		DriverInfo driver = new DriverInfo();
		IDriverInfo driServices = new DriverInfoImpl();
		IOut_CarServices outCarServices = new Out_CarServices();
		
		// 存放集合
		List<Out_Car> list = null;
		// 判断opt执行功能
		//删除多个
		if("delIds".equals(opt)) {
			if(!"".equals(delIds)&&delIds!=null) {
				int count =outCarServices.outCarDelete(delIds);
				out.print(count);
			}
			return;
		}
		// 真正的修改
		if ("upd".equals(opt)) {
			if (StringUtil.isNotEmpty(out_id)) {
				out_car.setOut_id(out_id);
			}
			if (StringUtil.isNotEmpty(dri_id)) {
				out_car.setDri_id(dri_id);
			}
			if (StringUtil.isNotEmpty(dri_name)) {
				out_car.setDri_name(dri_name);
			}
			if (StringUtil.isNotEmpty(out_car_id)) {
				out_car.setOut_car_id(out_car_id);
			}
			if (StringUtil.isNotEmpty(out_why)) {
				out_car.setOut_why(out_why);
			}
			if (StringUtil.isNotEmpty(out_test)) {
				out_car.setOut_test(out_test);
			}
			if (StringUtil.isNotEmpty(out_time)) {
				out_car.setOut_time(out_time);
			}
			if (StringUtil.isNotEmpty(out_notes)) {
				out_car.setOut_notes(out_notes);
			}
			if (outCarServices.updOutCar(out_car)) {
				out.print("{\"success\": true,\"message\": \"修改出车记录成功.\"}");
			} else {
				out.print("{\"success\": false,\"message\": \"修改出车记录失败.\"}");
			}

			return;
		}
		// 按id查询单个
		if ("findById".equals(opt)) {
			if (!"".equals(out_id) && out_id != null) {
				out_car.setOut_id(out_id);
			}
			Out_Car out_car2 = outCarServices.findByIdOutCar(out_car);
			HttpSession session = request.getSession();
			//request.setAttribute("out_car", out_car2);
			session.setAttribute("out_car", out_car2);
			System.out.println(out_car2);
			
			  
			  out.print("<script>");
			  out.print("window.location.href=\"carsystem/"+url+"\"");
			  out.print("</script>");
			  
			 
			//request.getRequestDispatcher("carsystem/outcar-add2.jsp").forward(request,response);
			return;
		}
		// 删除一条出车记录
		if ("del".equals(opt)) {
			if (!"".equals(out_id) && out_id != null) {
				out_car.setOut_id(out_id);
			}
			if (outCarServices.delOutCar(out_car)) {
				out.print("{\"success\": true,\"message\": \"删除出车记录成功.\"}");
			} else {
				out.print("{\"error\": false,\"message\": \"删除出车记录失败.\"}");
			}
			return;
		}
		// 添加
		if ("add".equals(opt)) {
			//获取session
			HttpSession session = request.getSession();
			Users user = (Users)session.getAttribute("user");
			if (StringUtil.isNotEmpty(user.getUser_name())) {
				out_car.setOut_inputer(user.getUser_name());
			}
			if (StringUtil.isNotEmpty(dri_id)) {
				driver.setDri_id(dri_id);
			}
			//通过驾驶员id查找到驾驶员姓
			DriverInfo driver2 = driServices.findByIdDriver(driver);
			if(driver2!=null) {
				out_car.setDri_name(driver2.getDri_name());
			}
			if (StringUtil.isNotEmpty(dri_id)) {
				out_car.setDri_id(dri_id);
			}
			if (StringUtil.isNotEmpty(out_car_id)) {
				out_car.setOut_car_id(out_car_id);
			}
			if (StringUtil.isNotEmpty(out_why)) {
				out_car.setOut_why(out_why);
			}
			if (StringUtil.isNotEmpty(out_test)) {
				out_car.setOut_test(out_test);
			}
			if (StringUtil.isNotEmpty(out_notes)) {
				out_car.setOut_notes(out_notes);
			}
			if (StringUtil.isNotEmpty(out_time)) {
				out_car.setOut_time(out_time);
			}
			if(new CarImpl().updVehicles(out_car_id,"忙")) {
				if (outCarServices.addOutCar(out_car)) {
					out.print("{\"success\": true,\"message\": \"添加出车记录成功.\"}");
				} else {
					out.print("{\"error\": false,\"message\": \"添加出车记录失败.\"}");
				}
			}else {
				out.print("{\"error\": false,\"message\": \"添加出车记录失败.\"}");
			}
			
			return;
		}
		// 查询所有
		if ("queryAll".equals(opt)) {
			String page = request.getParameter("curr");
			String limit = request.getParameter("limit");
			if (!"".equals(out_car_id) && out_car_id != null) {
				out_car.setOut_car_id(out_car_id);
			}
			if (!"".equals(dri_name) && dri_name != null) {
				out_car.setDri_name(dri_name);
			}
			if ("".equals(page) && page == null) {
				page = "1";
			}
			if ("".equals(limit) && limit == null) {
				limit = "10";
			}
			PageBean pageBean = new PageBean(Integer.parseInt(page),Integer.parseInt(limit));
			list = outCarServices.queryAllOutCar(pageBean, out_car);
			// 传给前台jsonarray
			JSONArray jsonArray = JSONArray.fromObject(list);
			int count = outCarServices.outCarCount(out_car);
			String a = "{\"count\":"+count+",\"outcar\":"+jsonArray+"}";
			out.print(a);
			return;
		}
	}

}
