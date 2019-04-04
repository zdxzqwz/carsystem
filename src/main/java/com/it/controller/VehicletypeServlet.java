package com.it.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.bean.Vehicletype;
import com.it.global.IVehicletype;
import com.it.services.VehicletypeImpl;
import com.it.utils.StringUtil;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class VehicletypeServlet
 */
@WebServlet({ "/VehicletypeServlet", "/veh.do" })
public class VehicletypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicletypeServlet() {
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

		//1.设置编码格式
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		  //2 获取页面信息
		  String veh_id = request.getParameter("veh_id");
		//3.生成对象
		Vehicletype veh=new Vehicletype();
		IVehicletype iveh=new VehicletypeImpl();
		//4.""  null
		if(StringUtil.isNotEmpty(veh_id)) {
			veh.setVeh_id(veh_id);
		}
		//执行
		List<Vehicletype> list=iveh.queryAll(veh);
		System.out.println("vehmservlet-------->"+list);
		JSONArray array=JSONArray.fromObject(list);
		System.out.println(array.toString());
		out.print(array);
	}

}
