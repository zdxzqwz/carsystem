package com.it.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.bean.Filiale;
import com.it.bean.Region;
import com.it.global.IFiliale;
import com.it.services.FilialeImpl;
import com.it.utils.StringUtil;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class FilialeServlet
 */
@WebServlet({ "/FilialeServlet", "/filiale.do" })
public class FilialeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilialeServlet() {
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
		  String reg_id = request.getParameter("reg_id");
		  //3.生成对象
		  Region region=new Region();
		  IFiliale ifil=new FilialeImpl();
		  if(StringUtil.isNotEmpty(reg_id)) {
			  region.setReg_id(reg_id);
		  }
           System.out.println("servlet------reg_id--->"+reg_id);
		  //4 执行
		  List<Filiale> list=ifil.queryFilialesByRegionId(region);
		  JSONArray array=JSONArray.fromObject(list);
		  System.out.println(array.toString());
		  out.print(array);
	}

}
