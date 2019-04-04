package com.it.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.bean.Region;
import com.it.global.IRegion;
import com.it.services.RegionImpl;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class RegionServlet
 */
@WebServlet({ "/RegionServlet", "/region.do" })
public class RegionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegionServlet() {
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

		//设置编码格式
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//生成对象
		Region region=new Region();
		IRegion iregion=new RegionImpl();
		//生成集合List<Region> 执行
		List<Region> list=iregion.queryAll(region);
		JSONArray array =  JSONArray.fromObject(list);
		 if(array.size()>0){
			 System.out.println("---------------->"+array.toString());
			   out.print(array);
			 }else{
				 out.print("");
			 } 
		
		
	}

}
