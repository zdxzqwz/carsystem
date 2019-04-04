package com.it.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.bean.Vehiclemodel;
import com.it.bean.Vehicletype;
import com.it.global.IVehiclemodel;
import com.it.services.VehiclemodelImpl;
import com.it.utils.StringUtil;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class VehiclemodelServlet
 */
@WebServlet({ "/VehiclemodelServlet", "/vehm.do" })
public class VehiclemodelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehiclemodelServlet() {
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

		  //1 设置编码格式
		  request.setCharacterEncoding("utf-8");
		  response.setCharacterEncoding("utf-8");
		  PrintWriter out = response.getWriter();
		  //2 获取页面信息
		  String veh_id = request.getParameter("veh_id");
		  //3 生成对象
		  Vehicletype veh=new  Vehicletype();
		  IVehiclemodel ivem=new VehiclemodelImpl();
		  if(StringUtil.isNotEmpty(veh_id)) {
			  veh.setVeh_id(veh_id);
		  }
		  //4.执行
		  List<Vehiclemodel> list=ivem.queryVehmByVehId(veh);
		  System.out.println("vehservlet------->"+list);
		  JSONArray array=JSONArray.fromObject(list);
		  System.out.println(array.toString());
		  out.print(array);
		  
		
	}

}
