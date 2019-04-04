package com.it.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.it.bean.DriverInfo;
import com.it.bean.PageBean;
import com.it.global.IDriverInfo;
import com.it.global.IReturn_Car;
import com.it.services.DriverInfoImpl;
import com.it.services.Out_CarServices;
import com.it.services.ReturnCarServices;
import com.it.utils.StringUtil;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class DriverInfoServlet
 */
@WebServlet({ "/DriverInfoServlet", "/driver.do" })
public class DriverInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DriverInfoServlet() {
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
				
				String dri_id = request.getParameter("dri_id");
				String dri_name = request.getParameter("dri_name");
				String dri_sex = request.getParameter("dri_sex");
				String dri_age = request.getParameter("dri_age");		
				String dri_addr = request.getParameter("dri_addr");
				String dri_phone = request.getParameter("dri_phone");
				String dri_cer_no = request.getParameter("dri_cer_no");
				String dri_cer_type = request.getParameter("dri_cer_type");
				String dri_lic_id = request.getParameter("dri_lic_id");
				String dri_lic_type = request.getParameter("dri_lic_type");
				String dir_hiredate = request.getParameter("dir_hiredate");
				String dir_termdate = request.getParameter("dir_termdate");

				//生成对象
				PrintWriter out = response.getWriter();
				DriverInfo driver=new DriverInfo();
				IDriverInfo idriver=new DriverInfoImpl();
				
				//存放集合
				List<DriverInfo> list = null;
				//判断opt执行功能
				
				
				
				//删除功能
				if("del".equals(opt)) {
					//获取前端页面的id集合
					String delIds = request.getParameter("delIds");
					
                      System.out.println("delIds--->"+delIds);
					JSONObject result = new JSONObject();
					String str=null;
					//出车
					//Out_Car outcar=new Out_Car();
					Out_CarServices ioutcar=new Out_CarServices();
					//换车
					//Return_Car rc=new Return_Car();
					IReturn_Car irc=new ReturnCarServices();
					String[] delList=delIds.split("','");
					for (int i = 0; i < delList.length; i++) {
						  str=delList[i];
						  if(ioutcar.findByDriId(str)) {
		  						result.put("errorMsg", "该驾驶员信息无法删除 请联系人力资源部人员！");	
		  						out.print(result);
		  						return;
		  					}
		  					if(irc.findByDriId(str)) {
		  						result.put("errorMsg", "该驾驶员信息无法删除 请联系人力资源部人员！");	
		  						out.print(result);
		  						return; 						
		  					}
					}	
					int delNums = idriver.DriverDelete(delIds);
					if (delNums > 0) {
						result.put("success", true);
						result.put("delNums", delNums);
					} else {
						result.put("errorMsg", "删除失败");
					}
					
					out.print(result);
					return;
				}
				
				
				//修改功能
				if("upd".equals(opt)) {
					System.out.println(driver);
					if(StringUtil.isNotEmpty(dri_id)) {
						driver.setDri_id(dri_id);
					}
					if(StringUtil.isNotEmpty(dri_name)) {
						driver.setDri_name(dri_name);
					}
					if(StringUtil.isNotEmpty(dri_sex)) {
						driver.setDri_sex(dri_sex);
					}
					if(StringUtil.isNotEmpty(dri_age)) {
						driver.setDri_age(dri_age);
					}
					if(StringUtil.isNotEmpty(dri_addr)) {
						driver.setDri_addr(dri_addr);
					}
					if(StringUtil.isNotEmpty(dri_phone)) {
						driver.setDri_phone(dri_phone);
					}
					if(StringUtil.isNotEmpty(dri_cer_no)) {
						driver.setDri_cer_no(dri_cer_no);
					}
					if(StringUtil.isNotEmpty(dri_cer_type)) {
						driver.setDri_cer_type(dri_cer_type);
					}
					if(StringUtil.isNotEmpty(dri_lic_id)) {
						driver.setDri_lic_id(dri_lic_id);
					}
					if(StringUtil.isNotEmpty(dri_lic_type)) {
						driver.setDri_lic_type(dri_lic_type);
					}
					if(StringUtil.isNotEmpty(dir_hiredate)) {
						driver.setDir_hiredate(dir_hiredate);
					}
					if(StringUtil.isNotEmpty(dir_termdate)) {
						driver.setDir_termdate(dir_termdate);
					}
					boolean flag=idriver.updDriver(driver);
					if(flag) {
						out.print("{\"success\": true,\"message\": \"修改驾驶员记录成功.\"}");
					}else {
						out.print("{\"error\": false,\"message\": \"修改驾驶员记录失败.\"}");
					}
					return;
				}
				//添加功能
				if("addDriver".equals(opt)) {
					if(StringUtil.isNotEmpty(dri_id)) {
						driver.setDri_id(dri_id);
					}
					if(StringUtil.isNotEmpty(dri_name)) {
						driver.setDri_name(dri_name);
					}
					if(StringUtil.isNotEmpty(dri_sex)) {
						driver.setDri_sex(dri_sex);
					}
					if(StringUtil.isNotEmpty(dri_age)) {
						driver.setDri_age(dri_age);
					}
					if(StringUtil.isNotEmpty(dri_addr)) {
						driver.setDri_addr(dri_addr);
					}
					if(StringUtil.isNotEmpty(dri_phone)) {
						driver.setDri_phone(dri_phone);
					}
					if(StringUtil.isNotEmpty(dri_cer_no)) {
						driver.setDri_cer_no(dri_cer_no);
					}
					if(StringUtil.isNotEmpty(dri_cer_type)) {
						driver.setDri_cer_type(dri_cer_type);
					}
					if(StringUtil.isNotEmpty(dri_lic_id)) {
						driver.setDri_lic_id(dri_lic_id);
					}
					if(StringUtil.isNotEmpty(dri_lic_type)) {
						driver.setDri_lic_type(dri_lic_type);
					}
					if(StringUtil.isNotEmpty(dir_hiredate)) {
						driver.setDir_hiredate(dir_hiredate);
					}
					if(StringUtil.isNotEmpty(dir_termdate)) {
						driver.setDir_termdate(dir_termdate);
					}
					boolean flag=idriver.addDriver(driver);
					if(flag) {
						out.print("{\"success\": true,\"message\": \"添加驾驶员记录成功.\"}");
					}else {
						out.print("{\"error\": false,\"message\": \"添加驾驶员记录失败.\"}");
					}
					return;
				}
				
				
				
				//查询所有 showAll
				if("queryAll".equals(opt)) {
					String page = request.getParameter("page");
					String rows = request.getParameter("rows");
					if (StringUtil.isNotEmpty(dri_id)) {
						driver.setDri_id(dri_id);
					}
					if (StringUtil.isNotEmpty(dri_name)) {
						driver.setDri_name(dri_name);
					}
					JSONObject result = new JSONObject();
					PageBean pageBean = new PageBean(Integer.parseInt(page),
							Integer.parseInt(rows));
					list = idriver.queryAllDriver(pageBean, driver);
					//查询总记录数
					int total = idriver.DriverCount(driver);
					//传给前台jsonarray
					JSONArray jsonArray = JSONArray.fromObject(list);
					result.put("total", total);
					result.put("rows", jsonArray);
					System.out.println(result.toString());
			
					out.print(result);
					return;
				}
				if("queryAll2".equals(opt)) {
					System.out.println("1234");
					String page = request.getParameter("page");
					String rows = request.getParameter("rows");
					PageBean pageBean = new PageBean(Integer.parseInt(page),
							Integer.parseInt(rows));
					list = idriver.queryAllDriver(pageBean, driver);
					//传给前台jsonarray
					JSONArray jsonArray = JSONArray.fromObject(list);
					System.out.println(jsonArray);
					out.print(jsonArray);
					return;
				}
				//findById
				String flag = "1";//可用
				if("findById".equals(opt)){
					// "" null
					
					if (StringUtil.isNotEmpty(dri_id)) {

						driver.setDri_id(dri_id);

					}
					DriverInfo driver2 = idriver.findByIdDriver(driver);
					
					if(driver2!=null){
						flag = "-1";
								
					}
					System.out.println("flag-->"+flag);
					out.print(flag);
					
					
				}
			}

		}