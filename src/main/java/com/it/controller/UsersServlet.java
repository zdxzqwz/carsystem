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


import com.it.bean.Users;
import com.it.global.IUsers;
import com.it.services.UsersImpl;
import com.it.utils.StringUtil;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class UsersServlet
 */
@WebServlet({ "/UsersServlet", "/user.do" })
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersServlet() {
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
	 * @param user_sex 
	 * @param user_mobile 
	 * @param user_phone 
	 * @param user_addr 
	 * @param user_name 
	 * @param user_inputer 
	 * @param out 
	 * @param ListU 
	 * @param listU 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		//1设置编码格式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		//response.setCharacterEncoding("text/html;charset=utf-8");
		//2获取页面信息
		String opt = request.getParameter("opt");
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		String user_name = request.getParameter("user_name");
		String user_sex = request.getParameter("user_sex");
		String user_addr = request.getParameter("user_addr");
		String user_phone = request.getParameter("user_phone");
		String user_inputer = request.getParameter("user_inputer");
		String user_pwd1 = request.getParameter("user_pwd1");
		//String user_pwd2 = request.getParameter("user_pwd2");
		String roleId = request.getParameter("roleId");//角色id
		PrintWriter out = response.getWriter();
		//3生成对象
		//System.out.println(user_id);
		//System.out.println(user_pwd);
		Users users = new Users();
		//4生成service
		IUsers iUsers = new UsersImpl();
		//存放list集合内容
		List<Users> list = null;
		
		//判断执行功能
		//点击右上角，查看个人信息功能
		if("userShow".equals(opt)) {
			System.out.println("请求到了");
			HttpSession httpSession = request.getSession();
			Users user2 = (Users)httpSession.getAttribute("user");
			JSONObject json = JSONObject.fromObject(user2);
			out.print(json);
			return;
		}
		//退出登录
		if("logout".equals(opt)) {
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("carsystem/login.jsp");
			return;
		}
		//登录
		if("login".equals(opt)) {
			HttpSession session = request.getSession();
			String imageCode = request.getParameter("imageCode");
			//""null
			if(!"".equals(user_id)&&user_id!=null) {
				users.setUser_id(user_id);
			}
		    if(!"".equals(user_pwd)&&user_id!=null) {
		    	users.setUser_pwd(user_pwd);
		    }
		    
		    //执行
		    Users user2 = iUsers.login(users);
		    System.out.println(user2);
		    if (imageCode.equals(session.getAttribute("sRand"))&&user2!=null) {
		    	session.setAttribute("user", user2);
			    session.setMaxInactiveInterval(60*60*1000);
		    	response.sendRedirect("auth.do?opt=showLeft");
		    }else {
		    	out.print("<script>");
				out.print("window.alert('账户名、密码或验证码错误');");
				out.print("window.location.href='carsystem/login.jsp';");
				out.print("</script>");
		    	//response.sendRedirect("carsystem/login.jsp");
		    }
		    
		    return;
		}
	
//查询单个
	    if("findById".equals(opt)) {
	    	//System.out.println("123345");
	    	//""null
	    	if(!"".equals(user_id)&&user_id!=null) {
				users.setUser_id(user_id);
	    	}
	    	Users users2 = iUsers.findUsersById(users); 
	    	System.out.println(users2);
	    	//HttpSession session = request.getSession();
	    	if(users2!= null) {
	    		out.print("<script>");
				out.print("window.location.href='carsystem/member-add2.jsp");
				out.print("</script>");
				request.setAttribute("user", users2); 
				//转发
				request.getRequestDispatcher("carsystem/member-add2.jsp").forward(request, response);
    		}
	    	
	    }
	    /*
	     * 查询单个密码
	     */
	    if("findById2".equals(opt)) {
	    	//System.out.println("123345");
	    	//""null
	    	if(!"".equals(user_id)&&user_id!=null) {
				users.setUser_id(user_id);
	    	}
	    	Users users2 = iUsers.findUsersById(users);
	    	System.out.println(users2);
	    	//HttpSession session = request.getSession();
	    	if(users2!= null) {
	    		out.print("<script>");
				out.print("window.location.href=carsystem/change-password.jsp");
				out.print("</script>");
	     request.setAttribute("user", users2); 
	      //转发
	    request.getRequestDispatcher("carsystem/change-password.jsp").forward(request, response);
    		}
	    	return;
	    }
	    //删除用户
	    if("del".equals(opt)) {
	    	//获取前端页面的id集合
			
              System.out.println("user_id--->"+user_id);
              
			users.setUser_id(user_id);
			  //JSONObject result = new JSONObject(); 
			  boolean flag = iUsers.delUsers(users);
				
				if(flag){
					
			  out.print("<script>");
				out.print("alert('删除成功'); ");
				out.print("window.location.href='user.do?opt=queryAll'; ");
				out.print("</script>");
		    }else {
		    	out.print("<script>");
				out.print("alert('删除失败'); ");
				
				out.print("</script>");
		    }
		} 
	  //查询所有
	    if("queryAll".equals(opt)){
	    	if(StringUtil.isNotEmpty(user_id)) {
	    		users.setUser_id(user_id);
	    	}
	    	if (StringUtil.isNotEmpty(user_pwd)) {
                users.setUser_pwd(user_pwd);
	    }
	    	list = iUsers.queryAllUsers(users);
	    	//把对象存储到request中
			request.setAttribute("list", list);
			//跳转--》转发
			request.getRequestDispatcher("carsystem/member-list.jsp").forward(request, response);
			
			
			return;
	    }
	    
	//用户修改 
	if("upd".equals(opt)) {
		//""null
		if(!"".equals(user_id)&&user_id!=null) {
			users.setUser_id(user_id);
		}
		if(!"".equals(roleId)&&roleId!=null) {
			users.setRoleId(roleId);
		}
		if(!"".equals(user_pwd)&&user_pwd!=null) {
			users.setUser_pwd(user_pwd);
			
		}
		if(!"".equals(user_name)&&user_name!=null) {
			users.setUser_name(user_name);
		}
		if(!"".equals(user_sex)&&user_sex!=null) {
			if(user_sex.equals("0")) {
				user_sex="男";
			}else {
				user_sex="女";
			}
			users.setUser_sex(user_sex);
		}

		if(!"".equals(user_addr)&&user_addr!=null) {
			users.setUser_addr(user_addr);
		}
		if(!"".equals(user_phone)&&user_phone!=null) {
			users.setUser_phone(user_phone);
		}
		if(!"".equals(user_inputer)&&user_inputer!=null) {
			users.setUser_inputer(user_inputer);
		}
		boolean falg = iUsers.updUsers(users);

		if(falg){
			
			out.print("<script>");
			out.print("alert('修改成功'); ");
			out.print("parent.location.href='user.do?opt=queryAll'; ");
			out.print("</script>");
	    }else {
	    	out.print("<script>");
			out.print("alert('修改失败'); ");
			//out.print("parent.location.href='carsystem/member-list.jsp'; ");
			out.print("</script>");
	    }

		
		
		return;
	}
	/*
	 * 修改密码
	 */
	if("pwd".equals(opt)) {
		if(!"".equals(user_id)&&user_id!=null) {
			users.setUser_id(user_id);
			
		}
		if(!"".equals(user_pwd1)&&user_pwd1!=null) {
			users.setUser_pwd(user_pwd1);
			
		}
		System.out.println("user_id--->"+user_id);
		
		boolean flag = iUsers.pwdUsers(users);
	    if(flag) {
	    	out.print("<script>");
			out.print("alert('修改成功'); ");
			out.print("parent.location.href='user.do?opt=queryAll'; ");
			out.print("</script>");
	    }else {
	    	out.print("<script>");
			out.print("alert('修改失败'); ");
			out.print("parent.location.href='user.do?opt=queryAll'; ");
			out.print("</script>");
	    }
		return;
	}	
			 



	//用户添加
	if("add".equals(opt)){
		// "" null
		if(!"".equals(user_pwd)&&user_pwd!=null) {
			users.setUser_pwd(user_pwd);
		}
		if(!"".equals(user_name)&&user_name!=null) {
			users.setUser_name(user_name);
		}
		if(!"".equals(roleId)&&roleId!=null) {
			users.setRoleId(roleId);
		}
		if(!"".equals(user_sex)&&user_sex!=null) {
			if(user_sex.equals("0")) {
				user_sex="男";
			}else {
				user_sex="女";
			}
			users.setUser_sex(user_sex);
		}
		if(!"".equals(user_addr)&&user_addr!=null) {
			users.setUser_addr(user_addr);
		}
		if(!"".equals(user_phone)&&user_phone!=null) {
			users.setUser_phone(user_phone);
		}
		Long time = System.currentTimeMillis();
		Date date = new Date(time);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd HH:mm:ss");
		String tm = dateFormat.format(date);
		users.setCreate_time(tm);
		
		
		if(!"".equals(user_inputer)&&user_inputer!=null) {
			users.setUser_inputer(user_inputer);
		}
		
		
		//JSONObject result = new JSONObject();
		boolean flag = iUsers.addUsers(users);
	
		if(flag){
			
			out.print("<script>");
			out.print("parent.location.href='user.do?opt=queryAll'; ");
			out.print("</script>");
	    }else {
	    	response.sendRedirect("carsystem/member-add.jsp");
	    }

		
		return;
	}	
		

}	
	}
	
	
