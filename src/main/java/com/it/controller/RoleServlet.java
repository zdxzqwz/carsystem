package com.it.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.bean.Role;
import com.it.bean.Role_Auth;
import com.it.global.IRole;
import com.it.global.IRole_Auth;
import com.it.global.IUsers;
import com.it.services.RoleServices;
import com.it.services.Role_AuthServices;
import com.it.services.UsersImpl;
import com.it.utils.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class RoleServlet
 */
@WebServlet(
		asyncSupported = true, 
		urlPatterns = { 
				"/RoleServlet", 
				"/role.do"
		})
public class RoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoleServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//获取页面信息
		String opt = request.getParameter("opt");
		String roleId = request.getParameter("roleId");
		String roleName = request.getParameter("roleName");//角色名称
		String roleInfo = request.getParameter("roleInfo");//角色信息
		String authIds = request.getParameter("authIds");//授权的权限字符串
		//生成对象
		PrintWriter out = response.getWriter();
		Role role = new Role();
		IRole iRole = new RoleServices();
		IUsers iUsers = new UsersImpl();
		Role_Auth role_Auth = new Role_Auth();
		IRole_Auth iRole_Auth = new Role_AuthServices();
		if("showRole".equals(opt)) {
			System.out.println("请求到了");
			List<Role> list = iRole.queryAllRole(role);
			JSONArray array = JSONArray.fromObject(list);
			out.print(array);
			return;
		}
		//给角色授权
		if("auth".equals(opt)) {
			System.out.println("进入角色授权");
			if(StringUtil.isNotEmpty(roleId)) {
				role_Auth.setRoleId(roleId);
			}
			if(StringUtil.isNotEmpty(authIds)) {
				role_Auth.setAuthId(authIds);
			}
			if(iRole_Auth.updRoleAuth(role_Auth)) {
				out.print("{\"success\": false}");
			} else {
				out.print("{\"success\": true,\"errorMsg\": \"授权失败.\"}");
				
			}
			return;
		}
		//删除
		if("del".equals(opt)) {
			String delIds = request.getParameter("delIds");
			JSONObject result = new JSONObject();
			String str[] = delIds.split(",");
			for (int i = 0; i < str.length; i++) {
				boolean f = iUsers.existUserWithRoleId(str[i]);
				if (f) {
					result.put("errorIndex", i);
					result.put("errorMsg", "角色下面有用户，不能删除！");
					out.print(result);
					return;
				}
			}
			role.setRoleId(delIds);
			boolean flag = iRole.delRole(role);
			if (flag) {
				result.put("success", true);
				result.put("delNums", str.length);
			} else {
				result.put("errorMsg", "删除失败");
			}
			out.print(result);
			return;
		}
		//添加和修改
		if("add".equals(opt)) {
			if(StringUtil.isNotEmpty(roleName)) {
				role.setRoleName(roleName);
			}
			if(StringUtil.isNotEmpty(roleInfo)) {
				role.setRoleInfo(roleInfo);
			}
			if(StringUtil.isNotEmpty(roleId)) {
				role.setRoleId(roleId);
			}
			boolean flag = false;
			if(StringUtil.isNotEmpty(roleId)) {
				flag = iRole.updRole(role, "");
			}else {
				flag = iRole.addRole(role, "");
			}
			if (flag) {
				out.print("{\"success\": false,\"message\": \"保存成功.\"}");
			} else {
				out.print("{\"success\": true,\"message\": \"保存失败.\"}");
				
			}
			return;
		}
		if("queryAll".equals(opt)) {
			//String page = request.getParameter("page");
			//String rows = request.getParameter("rows");
			//PageBean pageBean = new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
			List<Role> list = iRole.queryAllRole(role);
			int total = iRole.roleCount(role);
			JSONArray array = JSONArray.fromObject(list);
			JSONObject object = new JSONObject();
			object.put("total", total);
			object.put("rows", array);
			System.out.println("查询所有角色json"+object);
			out.print(object);
			return;
		}
	}

}
