package com.it.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.DbUtils;

import com.it.bean.User_Check;
import com.it.global.ICheck;
import com.it.services.CheckImpl;
import com.it.utils.JDBCUtils;

/**
 * Servlet implementation class CheckServlet
 */
@WebServlet({ "/CheckServlet", "/check.do" })
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置编码格式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//获取页面信息
		String opt=request.getParameter("opt");//获取opt
		String ck_id=request.getParameter("ckId");//获取考核记录编号
		String  ck_user_id=request.getParameter("userId");//获取员工编号
		String ck_user_name=request.getParameter("userName");//获取员工姓名
		String  ck_cowa=request.getParameter("ckCowa");//获取工作考核评分
		String ck_schedule=request.getParameter("ckSchedule");//获取工作完成进度评分
		String ck_standard=request.getParameter("ckStandard");//获取工作安全规范评分
		String ck_propose=request.getParameter("ckPropose");//获取建议
		String ck_month=request.getParameter("ckMonth");//获取时间
		System.out.println(ck_id);
		//生成对象
		PrintWriter out=response.getWriter();//
		User_Check ck=new User_Check();
		ICheck icheck=new CheckImpl();
		//存放集合
		List<User_Check> list=null;
		//判断opt功能
		//添加
		if("add".equals(opt)) {
			if(!"".equals(ck_user_id)&&ck_user_id!=null){
				ck.setCk_user_id(Integer.parseInt(ck_user_id));
			}
			if(!"".equals(ck_cowa)&& ck_cowa!=null){
				ck.setCk_cowa(Integer.parseInt( ck_cowa));
			}
			if(!"".equals(ck_schedule)&& ck_schedule!=null){
				ck.setCk_schedule(Integer.parseInt( ck_schedule));
			}
			if(!"".equals(ck_standard)&& ck_standard!=null){
				ck.setCk_standard(Integer.parseInt(ck_standard));
			}
			if(!"".equals(ck_propose)&& ck_propose!=null){
				ck.setCk_propose(ck_propose);
			}
			if(!"".equals(ck_month)&& ck_month!=null){
				ck.setCk_month(ck_month);
			}
			
			try {
				System.out.println(ck);
				
			    icheck.addCheck(ck);
				out.print("<script>");
				out.print("window.location.href='check.do?opt=queryAll';");
				out.print("</script>");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response.sendRedirect("carsystem/check404.html");
			}finally {
				//释放资源到数据库连接池
				try {
					DbUtils.close(JDBCUtils.getConnections());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException("关闭资源失败!");
				}
			}
			
		}
		//查询所有，模糊查询
		if("queryAll".equals(opt)) {
			
			if(!"".equals(ck_user_id)&&ck_user_id!=null){
				ck.setCk_user_id(Integer.parseInt(ck_user_id));
			}
			if(!"".equals(ck_user_name)&&ck_user_name!=null){
				ck.setUser_name(ck_user_name);
			}
			try {
				 list=icheck.queryAll(ck);
				System.out.println(list.size());
  				request.setAttribute("list", list);
  				request.getRequestDispatcher("carsystem/users-check.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response.sendRedirect("404.html");
			}finally {
				//释放资源到数据库连接池
				try {
					DbUtils.close(JDBCUtils.getConnections());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException("关闭资源失败!");
				}
			}
		}
		//查询单个
		if("findById".equals(opt)) {
			System.out.println("111111");
			
			if(!"".equals(ck_id)&&ck_id!=null){
				ck.setCk_id(Integer.parseInt(ck_id));
			}
		   try {
			   System.out.println(ck);
			User_Check list1= icheck.findById(ck);
			   System.out.println(list1);
			   request.setAttribute("list1", list1);
 				request.getRequestDispatcher("carsystem/check-upd.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("404.html");
		}finally {
			//释放资源到数据库连接池
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
		   
		
	}
		//修改
		if("upd".equals(opt)) {
			if(!"".equals(ck_id)&&ck_id!=null){
				ck.setCk_id(Integer.parseInt(ck_id));
			}
			if(!"".equals(ck_user_id)&&ck_user_id!=null){
				ck.setCk_user_id(Integer.parseInt(ck_user_id));
			}
			if(!"".equals(ck_cowa)&& ck_cowa!=null){
				ck.setCk_cowa(Integer.parseInt( ck_cowa));
			}
			if(!"".equals(ck_schedule)&& ck_schedule!=null){
				ck.setCk_schedule(Integer.parseInt( ck_schedule));
			}
			if(!"".equals(ck_standard)&& ck_standard!=null){
				ck.setCk_standard(Integer.parseInt(ck_standard));
			}
			if(!"".equals(ck_propose)&& ck_propose!=null){
				ck.setCk_propose(ck_propose);
			}
			if(!"".equals(ck_month)&& ck_month!=null){
				ck.setCk_month(ck_month);
			}
			try {
				System.out.println(ck);
				icheck.updCheck(ck);
				out.print("<script>");
				out.print("window.location.href='check.do?opt=queryAll';");
				out.print("</script>");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response.sendRedirect("404.html");
			}finally {
				//释放资源到数据库连接池
				try {
					DbUtils.close(JDBCUtils.getConnections());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException("关闭资源失败!");
				}
			}
		}
		//删除
		if("del".equals(opt)) {
			if(!"".equals(ck_id)&&ck_id!=null){
				ck.setCk_id(Integer.parseInt(ck_id));
			}
			try {
				System.out.println(ck);
				icheck.delCheck(ck);
				 response.sendRedirect("check.do?opt=queryAll");
//				out.print("<script>");
//				out.print("top.window.location.href='check.do?opt=queryAll';");
//				out.print("</script>");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response.sendRedirect("404.html");
			}finally {
				//释放资源到数据库连接池
				try {
					DbUtils.close(JDBCUtils.getConnections());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException("关闭资源失败!");
				}
			}
			
		}
}
}
