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

import com.it.bean.Driver_Comment;
import com.it.global.IComment;
import com.it.services.Commentlmpl;
import com.it.utils.JDBCUtils;



/**
 * Servlet implementation class Driver_CommentServlet
 */
@WebServlet({ "/Driver_CommentServlet", "/comment.do" })
public class Driver_CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Driver_CommentServlet() {
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
		String opt=request.getParameter("opt");
		
		String  ret_id=request.getParameter("retId");//获取还车编号
		String  cmt_id=request.getParameter("cmtId");//获取评议编号
		String  dri_id=request.getParameter("driId");//获取驾驶员编号
		String  ret_name=request.getParameter("retName");//获取驾驶员姓名
		String cmt_quality=request.getParameter("cmtQuality");//获取驾驶员服务质量评分
		String cmt_performance=request.getParameter("cmtPerformance");//获取驾驶员行为表现评分
		String cmt_safety=request.getParameter("cmtSafety");//获取驾驶员行车安全评分
		String cmt_propose=request.getParameter("cmtPropose");//获取备注信息
		String cmt_month=request.getParameter("cmtTime");//获取时间
	
		
		//生成对象
				PrintWriter out = response.getWriter();
				Driver_Comment  comt = new Driver_Comment();
				IComment icomment = new Commentlmpl();
				//存放集合
				//List<Driver_Comment> list = null;
				List<Object[]> list1 = null;
				//判断opt执行功能
				//添加
				if("add".equals(opt)) {
					if(!"".equals(ret_id)&&ret_id!=null){
						comt.setRet_id(Integer.parseInt(ret_id));
					}
					if(!"".equals(cmt_quality)&&cmt_quality!=null) {
						comt.setCmt_quality(Integer.parseInt(cmt_quality));
					}
					if(!"".equals(cmt_performance)&&cmt_performance!=null) {
						comt.setCmt_performance(Integer.parseInt(cmt_performance));
					}
					if(!"".equals(cmt_safety)&&cmt_safety!=null) {
						comt.setCmt_safety(Integer.parseInt(cmt_safety));
					}
					if(!"".equals(cmt_propose)&&cmt_propose!=null) {
						comt.setCmt_propose(cmt_propose);
					}
					if(!"".equals(cmt_month)&&cmt_month!=null) {
						comt.setCmt_month(cmt_month);
					}
					try {
						icomment.addComment(comt);
						response.sendRedirect("carsystem/driver-review.html");
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
		//查询所有
				if("queryAll".equals(opt)) {
					
					try {
			
						list1 = icomment.queryAllcomment();
		
		  				System.out.println(list1.size());
		  				request.setAttribute("list1", list1);
		  				request.getRequestDispatcher("carsystem/driver-review.jsp").forward(request, response);
						//response.sendRedirect("carsystem/driver-review.jsp");
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
					return;
				}
				//查询单个
				if("findById".equals(opt)) {
					List<Object[]> comt2=null;
					if(!"".equals(cmt_id)&&cmt_id!=null){
						System.out.println(cmt_id);
						comt.setCmt_id(Integer.parseInt(cmt_id));
					}
					try {
						comt2=icomment.findById(comt);
						request.setAttribute("comt2", comt2);
						request.getRequestDispatcher("carsystem/review-upd.jsp").forward(request, response);
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
					if(!"".equals(cmt_id)&&cmt_id!=null){
						comt.setCmt_id(Integer.parseInt(cmt_id));
					}
					if(!"".equals(ret_id)&&ret_id!=null){
						comt.setRet_id(Integer.parseInt(ret_id));
					}
					if(!"".equals(cmt_quality)&&cmt_quality!=null) {
						comt.setCmt_quality(Integer.parseInt(cmt_quality));
					}
					if(!"".equals(cmt_performance)&&cmt_performance!=null) {
						comt.setCmt_performance(Integer.parseInt(cmt_performance));
					}
					if(!"".equals(cmt_safety)&&cmt_safety!=null) {
						comt.setCmt_safety(Integer.parseInt(cmt_safety));
					}
					if(!"".equals(cmt_propose)&&cmt_propose!=null) {
						comt.setCmt_propose(cmt_propose);
					}
					if(!"".equals(cmt_month)&&cmt_month!=null) {
						comt.setCmt_month(cmt_month);
					}
					try {
						System.out.println(comt);
						icomment.updComment(comt);
					//	response.sendRedirect("comment.do?opt=queryAll");
						out.print("<script>");
						out.print("window.location.href='comment.do?opt=queryAll';");
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
					if(!"".equals(cmt_id)&&cmt_id!=null){
						comt.setCmt_id(Integer.parseInt(cmt_id));
					}
					try {
						System.out.println(comt);
						icomment.delComment(comt);
					//	response.sendRedirect("comment.do?opt=queryAll");
						out.print("<script>");
						out.print("window.location.href='comment.do?opt=queryAll';");
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
				if("find".equals(opt)) {
					Integer id= null;
					String name ="";
					if(!"".equals(dri_id)&&dri_id!=null){
						  id=(Integer.parseInt(dri_id));
					}
					if(!"".equals(ret_name)&&ret_name!=null){
						name=(ret_name);
					}
	  				try {
	  					
	  					list1 = icomment.find(name, id);
						System.out.println(list1.size());
		  				request.setAttribute("list1", list1);
		  				request.getRequestDispatcher("carsystem/driver-review.jsp").forward(request, response);
						//response.sendRedirect("carsystem/driver-review.jsp");
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
