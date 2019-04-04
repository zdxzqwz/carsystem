package com.it.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.bean.Auth;
import com.it.bean.Users;
import com.it.global.IAuth;
import com.it.services.AuthServices;
import com.it.utils.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class AuthServlet
 */
@WebServlet(
		asyncSupported = true, 
		urlPatterns = { 
				"/AuthServlet", 
				"/auth.do"
		})
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthServlet() {
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
		String authId=request.getParameter("authId");
		String parentId = request.getParameter("parentId");
		String roleId = request.getParameter("roleId");
		String authName = request.getParameter("authName");
		String iconCls = request.getParameter("iconCls");
		String authPath = request.getParameter("authPath");
		String authDescription = request.getParameter("authDescription");
		//生成对象
		PrintWriter out = response.getWriter();
		//Role_Auth role_Auth = new Role_Auth();
		Auth auth = new Auth();
		IAuth iAuth = new AuthServices();
		//判断opt，并执行对应功能
		//删除节点
		if("del".equals(opt)) {
			if(StringUtil.isNotEmpty(authId)) {
				auth.setAuthId(authId);
			}
			if(StringUtil.isNotEmpty(parentId)) {
				auth.setParentId(parentId);
			}
			//判断是否有子节点
			if(!iAuth.isLeaf(auth)) {
				out.print("{\"success\": false,\"errorMsg\": \"该菜单节点有子节点，不能删除！\"}");
			}else {
				int a = iAuth.getAuthCountByParentId(parentId);
				if(a==1) {
					iAuth.updateStateByAuthId("open", parentId);
					if(iAuth.delAuth(auth)) {
						out.print("{\"success\": true}");
					}else {
						out.print("{\"success\": false,\"errorMsg\": \"删除失败\"}");
					}
				}else {
					if(iAuth.delAuth(auth)) {
						out.print("{\"success\": true}");
					}else {
						out.print("{\"success\": false,\"errorMsg\": \"删除失败\"}");
					}
				}
			}
			return;
		}
		//添加节点
		if("save".equals(opt)) {
			if(StringUtil.isNotEmpty(parentId)) {
				auth.setParentId(parentId);
			}
			if(StringUtil.isNotEmpty(authName)) {
				auth.setAuthName(authName);
			}
			if(StringUtil.isNotEmpty(iconCls)) {
				auth.setIconCls(iconCls);
			}
			if(StringUtil.isNotEmpty(authPath)) {
				auth.setAuthPath(authPath);
			}
			if(StringUtil.isNotEmpty(authDescription)) {
				auth.setAuthDescription(authDescription);
			}
			//roleId为空时添加，else修改
			if(StringUtil.isEmpty(authId)) {
				//判断是否有子节点
				if(iAuth.isLeaf(auth)) {
					if(iAuth.addAuth(auth)) {
						out.print("{\"success\": false}");
					}else {
						out.print("{\"success\": true,\"errorMsg\": \"添加失败.\"}");
					}
				}else {
					//没有的话把状态改成文件夹
					iAuth.updateStateByAuthId("closed", parentId);
					if(iAuth.addAuth(auth)) {
						out.print("{\"success\": false}");
					}else {
						out.print("{\"success\": true,\"errorMsg\": \"添加失败.\"}");
					}
				}
				
			}else {
				auth.setAuthId(authId);
				JSONObject result=new JSONObject();
				if(iAuth.updAuth(auth)) {
					result.put("success", true);
				}else {
					result.put("success", true);
					result.put("errorMsg", "保存失败");
				}
				out.print(result);
			}
			
			
			return;
		}
		//菜单管理
		if("authTreeGridMenu".equals(opt)) {
			//System.out.println(opt);
			if(StringUtil.isNotEmpty(parentId)) {
				auth.setParentId(parentId);
			}
			List<Auth> listAll = iAuth.queryAllAuth(auth);
			List<Map<String, Object>> map = queryItemListByTmpl2(listAll);
			JSONArray json = JSONArray.fromObject(map);
			System.out.println("传给前端的tree---json"+json);
			out.print(json);
			return;
		}
		//异步显示tree
		if("authMenu".equals(opt)) {
			List<Auth> listRole = null;
			if(StringUtil.isNotEmpty(roleId)) {
				listRole = iAuth.queryAllByRoleId(roleId);
			}
			if(StringUtil.isNotEmpty(parentId)) {
				auth.setParentId(parentId);
			}
			//获取所有
			List<Auth> listAll = iAuth.queryAllAuth(auth);
			//System.out.println("所有权限"+listAll);
			List<Map<String, Object>> map = queryItemListByTmpl(listAll,listRole);
			JSONArray json = JSONArray.fromObject(map);
			System.out.println("传给前端的tree---json"+json);
			response.getWriter().print(json);
			return;
		}
		//页面加载事件，根据登陆用户的id，查找对应的所有权限
		if("showLeft".equals(opt)) {
			Users user = (Users)request.getSession().getAttribute("user");
			if(user==null) {
				response.sendRedirect("carsystem/login.html");
				out.print("<script>");
				out.print("alert('登陆过期，请重新登陆！');");
				out.print("window.location.href='carsystem/login.html';");
				out.print("</script>");
				return;
			}
			List<Auth> list = iAuth.queryAllByUserId(user.getUser_id());
			System.out.println("查询到权限集合的大小"+list.size());
			request.setAttribute("list", list);
			request.getRequestDispatcher("carsystem/index2.jsp").forward(request, response);
			return;
		}
	}
	/**
	 * 
	* @Description: 把数据库查询到的list转化为easyui需要的json数据格式
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月24日 上午11:09:03
	 */
	public List<Map<String,Object>> queryItemListByTmpl(List<Auth> listAll,List<Auth> listRole){
		try { 
			List<Auth> itemList = listAll;
			Map<String, Object> map;
			List<Map<String, Object>> rusult = new ArrayList<Map<String, Object>>();
			for(Auth item : itemList){
				if(item.getParentId()==null || item.getParentId().equals("-1")){
					map = new HashMap<String, Object>();
					map.put("id", item.getAuthId());
					map.put("text", item.getAuthName());
					map.put("state", item.getState());
					map.put("iconCls", item.getIconCls());
					map.put("authPath", item.getAuthPath());
					map.put("authDescription", item.getAuthDescription());
					this.getSonTree(map, itemList,listRole);
					rusult.add(map);
				}
			}
			return rusult;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 
	* @Description: 递归添加权限节点的所有孩子
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月24日 上午11:18:40
	 */
	private Map<String,Object> getSonTree(Map<String,Object> map,List<Auth> itemList,List<Auth> listRole){
		List<Map<String,Object>> sonList = new ArrayList<Map<String,Object>>();
		Map<String, Object> sonMap;
		for(Auth item : itemList){
			if(map.get("id").toString().equals(item.getParentId().toString())){
				sonMap = new HashMap<String, Object>();
				sonMap.put("id", item.getAuthId());
				sonMap.put("text", item.getAuthName());
				sonMap.put("state",  item.getState());
				sonMap.put("iconCls", item.getIconCls());
				sonMap.put("authPath", item.getAuthPath());
				sonMap.put("authDescription", item.getAuthDescription());
				if(this.checked(item.getAuthId(), listRole)) {
					sonMap.put("checked", true);
				}
				sonList.add(sonMap);
				this.getSonTree(sonMap,itemList,listRole);
			}
		}
		map.put("children", sonList);
		return map;
	}
	// -0---------------------------------------------------------------------------0//
	/**
	 * 
	* @Description: 该函数的功能描述2
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月24日 下午6:07:02
	 */
	public List<Map<String,Object>> queryItemListByTmpl2(List<Auth> listAll){
		try { 
			List<Auth> itemList = listAll;
			Map<String, Object> map;
			List<Map<String, Object>> rusult = new ArrayList<Map<String, Object>>();
			for(Auth item : itemList){
				if(item.getParentId()==null || item.getParentId().equals("-1")){
					map = new HashMap<String, Object>();
					map.put("id", item.getAuthId());
					map.put("text", item.getAuthName());
					map.put("state", item.getState());
					map.put("iconCls", item.getIconCls());
					map.put("authPath", item.getAuthPath());
					map.put("authDescription", item.getAuthDescription());
					this.getSonTree2(map, itemList);
					rusult.add(map);
				}
			}
			return rusult;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 2
	* @Description: 该函数的功能描述2
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月24日 下午6:07:10
	 */
	private Map<String,Object> getSonTree2(Map<String,Object> map,List<Auth> itemList){
		List<Map<String,Object>> sonList = new ArrayList<Map<String,Object>>();
		Map<String, Object> sonMap;
		for(Auth item : itemList){
			if(map.get("id").toString().equals(item.getParentId().toString())){
				sonMap = new HashMap<String, Object>();
				sonMap.put("id", item.getAuthId());
				sonMap.put("text", item.getAuthName());
				sonMap.put("state",  item.getState());
				sonMap.put("iconCls", item.getIconCls());
				sonMap.put("authPath", item.getAuthPath());
				sonMap.put("authDescription", item.getAuthDescription());
				sonList.add(sonMap);
				this.getSonTree2(sonMap,itemList);
			}
		}
		map.put("children", sonList);
		return map;
	}
	//判断是否选中
	public boolean checked(String authId,List<Auth> listRole) {
		for (Auth auth : listRole) {
			if(auth.getAuthId().equals(authId)) {
				return true;
			}
		}
		return false;
	}

}
