package com.it.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.bean.Car;
import com.it.bean.PageBean;
import com.it.bean.Technical_File;
import com.it.global.ITechnical_File;
import com.it.services.Technical_FileImpl;
import com.it.utils.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class Technical_FileServlet
 */
@WebServlet({ "/Technical_FileServlet", "/tech.do" })
public class Technical_FileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Technical_FileServlet() {
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

		String car_tec_cno = request.getParameter("car_tec_cno");// 车牌号
		String tec_release_date = request.getParameter("tec_release_date");// 生产日期
		String tec_origin = request.getParameter("tec_origin");// 产地
		String tec_vin = request.getParameter("tec_vin");// 车架号
		String tec_ctype = request.getParameter("tec_ctype");// 车辆类型等级
		String tec_fuel_type = request.getParameter("tec_fuel_type");// 燃油种类
		String tec_cpower = request.getParameter("tec_cpower");// 车辆发动机功率
		String tec_driving_type = request.getParameter("tec_driving_type");// 驱动形式
		String tec_cc = request.getParameter("tec_cc");// 发动机排量
		String tec_neshaps = request.getParameter("tec_neshaps");// 排放标准
		String tec_tires_no = request.getParameter("tec_tires_no");// 轮胎数量
		String tec_axis = request.getParameter("tec_axis");// 驱动轴数
		String tec_transmission_type = request.getParameter("tec_transmission_type");// 变速器形式
		String tec_retarder = request.getParameter("tec_retarder");// 缓速器
		String tec_diverter = request.getParameter("tec_diverter");// 转向器
		String tec_service_brake = request.getParameter("tec_service_brake");// 制动形式
		String tec_suspension_mode = request.getParameter("tec_suspension_mode");// 悬挂形式

		// 生成对象
		PrintWriter out = response.getWriter();
		Technical_File tech = new Technical_File();
		ITechnical_File itech = new Technical_FileImpl();
		Car car = new Car();
		//ICar icar = new CarImpl();
        List<Technical_File> list=null;
		// 判断opt执行功能

		//查询所有 showAll
		if("queryAll".equals(opt)) {
			String page = request.getParameter("page");
			String rows = request.getParameter("rows");
			if (StringUtil.isNotEmpty(car_tec_cno)) {
				tech.setCar_tec_cno(car_tec_cno);
			}
			System.out.println(tech);
			JSONObject result = new JSONObject();
			PageBean pageBean = new PageBean(Integer.parseInt(page),
					Integer.parseInt(rows));
			list = itech.queryAllTechnical_File(pageBean,tech);
			//查询总记录数
			int total = itech.Technical_FileCount(tech);
			//传给前台jsonarray
			JSONArray jsonArray = JSONArray.fromObject(list);
			result.put("total", total);
			result.put("rows", jsonArray);
			System.out.println(result.toString());
	
			out.print(result);
			return;
		}

		// 查找 findById
		String flag1 = "1";// 可用
		if ("findById".equals(opt)) {
			// "" null

			if (StringUtil.isNotEmpty(car_tec_cno)) {

				tech.setCar_tec_cno(car_tec_cno);

			}
			Technical_File tech1 = itech.findByIdTechFile(tech);

			if (tech1 != null) {
				flag1 = "-1";
			}
			System.out.println("flag-->" + flag1);
			out.print(flag1);
			
            return;
		}
		// 修改车辆技术档案
		if ("upd".equals(opt)) {
			// 判断“” null
			// 1
			if (StringUtil.isNotEmpty(car_tec_cno)) {
				tech.setCar_tec_cno(car_tec_cno);
			}
			// 2
			if (StringUtil.isNotEmpty(tec_release_date)) {
				tech.setTec_release_date(tec_release_date);
			}
			// 3
			if (StringUtil.isNotEmpty(tec_origin)) {
				tech.setTec_origin(tec_origin);
			}
			// 4
			if (StringUtil.isNotEmpty(tec_vin)) {
				tech.setTec_vin(tec_vin);
			}
			// 5
			if (StringUtil.isNotEmpty(tec_ctype)) {
				tech.setTec_ctype(tec_ctype);
			}
			// 6
			if (StringUtil.isNotEmpty(tec_fuel_type)) {
				tech.setTec_fuel_type(tec_fuel_type);
			}
			// 7
			if (StringUtil.isNotEmpty(tec_cpower)) {
				tech.setTec_cpower(tec_cpower);
			}
			// 8
			if (StringUtil.isNotEmpty(tec_driving_type)) {
				tech.setTec_driving_type(tec_driving_type);
			}
			// 9
			if (StringUtil.isNotEmpty(tec_cc)) {
				tech.setTec_cc(tec_cc);
			}
			// 10
			if (StringUtil.isNotEmpty(tec_neshaps)) {
				tech.setTec_neshaps(tec_neshaps);
			}
			// 11
			if (StringUtil.isNotEmpty(tec_tires_no)) {
				tech.setTec_tires_no(tec_tires_no);
			}
			// 12
			if (StringUtil.isNotEmpty(tec_axis)) {
				tech.setTec_axis(tec_axis);
			}
			// 13
			if (StringUtil.isNotEmpty(tec_transmission_type)) {
				tech.setTec_transmission_type(tec_transmission_type);
			}
			// 14
			if (StringUtil.isNotEmpty(tec_retarder)) {
				tech.setTec_retarder(tec_retarder);
			}
			// 15
			if (StringUtil.isNotEmpty(tec_diverter)) {
				tech.setTec_diverter(tec_diverter);
			}
			// 16
			if (StringUtil.isNotEmpty(tec_service_brake)) {
				tech.setTec_service_brake(tec_service_brake);
			}
			// 17
			if (StringUtil.isNotEmpty(tec_suspension_mode)) {
				tech.setTec_suspension_mode(tec_suspension_mode);
			}
			boolean flag=itech.updTechFile(tech);
			if(flag) {
				out.print("{\"success\": true,\"message\": \"修改车辆技术记录成功.\"}");
			}else {
				out.print("{\"error\": false,\"message\": \"修改车辆技术记录失败.\"}");
			}
            return;
		}

		// 删除功能del
		if ("del".equals(opt)) {
			// 获取前端页面的id集合
			String delIds = request.getParameter("delIds");

			System.out.println("delIds--->" + delIds);
			JSONObject result = new JSONObject();
			int delNums = itech.Technical_FileDelete(delIds);
			if (delNums > 0) {
				result.put("success", true);
				result.put("delNums", delNums);
			} else {
				result.put("errorMsg", "删除失败");
			}

			out.print(result);
			return;
		}

		// 添加车辆技术档案
		if ("add".equals(opt)) {
			// 判断“” null
			// 1
			if (StringUtil.isNotEmpty(car_tec_cno)) {
				tech.setCar_tec_cno(car_tec_cno);
			}
			// 2
			if (StringUtil.isNotEmpty(tec_release_date)) {
				tech.setTec_release_date(tec_release_date);
			}
			// 3
			if (StringUtil.isNotEmpty(tec_origin)) {
				tech.setTec_origin(tec_origin);
			}
			// 4
			if (StringUtil.isNotEmpty(tec_vin)) {
				tech.setTec_vin(tec_vin);
			}
			// 5
			if (StringUtil.isNotEmpty(tec_ctype)) {
				tech.setTec_ctype(tec_ctype);
			}
			// 6
			if (StringUtil.isNotEmpty(tec_fuel_type)) {
				tech.setTec_fuel_type(tec_fuel_type);
			}
			// 7
			if (StringUtil.isNotEmpty(tec_cpower)) {
				tech.setTec_cpower(tec_cpower);
			}
			// 8
			if (StringUtil.isNotEmpty(tec_driving_type)) {
				tech.setTec_driving_type(tec_driving_type);
			}
			// 9
			if (StringUtil.isNotEmpty(tec_cc)) {
				tech.setTec_cc(tec_cc);
			}
			// 10
			if (StringUtil.isNotEmpty(tec_neshaps)) {
				tech.setTec_neshaps(tec_neshaps);
			}
			// 11
			if (StringUtil.isNotEmpty(tec_tires_no)) {
				tech.setTec_tires_no(tec_tires_no);
			}
			// 12
			if (StringUtil.isNotEmpty(tec_axis)) {
				tech.setTec_axis(tec_axis);
			}
			// 13
			if (StringUtil.isNotEmpty(tec_transmission_type)) {
				tech.setTec_transmission_type(tec_transmission_type);
			}
			// 14
			if (StringUtil.isNotEmpty(tec_retarder)) {
				tech.setTec_retarder(tec_retarder);
			}
			// 15
			if (StringUtil.isNotEmpty(tec_diverter)) {
				tech.setTec_diverter(tec_diverter);
			}
			// 16
			if (StringUtil.isNotEmpty(tec_service_brake)) {
				tech.setTec_service_brake(tec_service_brake);
			}
			// 17
			if (StringUtil.isNotEmpty(tec_suspension_mode)) {
				tech.setTec_suspension_mode(tec_suspension_mode);
			}
			System.out.println("car------->" + car);
			boolean flag = itech.addTechFile(tech);
			if (flag) {
				out.print("{\"success\": true,\"message\": \"添加车辆技术档案记录成功.\"}");
			} else {
				out.print("{\"error\": false,\"message\": \"添加车辆技术档案记录失败.\"}");
			}
			return;
		}

	}

}
