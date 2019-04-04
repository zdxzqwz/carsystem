package com.it.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.it.bean.Expense;
import com.it.global.IExpense;
import com.it.services.ExpenseServices;
import com.it.utils.StringUtil;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class ExpesnseServlet
 */
@WebServlet(
		asyncSupported = true, 
		urlPatterns = { 
				"/ExpesnseServlet", 
				"/expense.do"
		})
public class ExpesnseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpesnseServlet() {
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
		//获取页面信息呢
		String opt = request.getParameter("opt");
		String ret_id = request.getParameter("ret_id");//还车编号
		String exp_id = request.getParameter("exp_id");//费用编号
		String exp_water = request.getParameter("exp_water");//加水费
		String exp_park = request.getParameter("exp_park");//停车费
		String exp_wash = request.getParameter("exp_wash");//洗车费
		String exp_toll = request.getParameter("exp_toll");//过来费
		String exp_fuel = request.getParameter("exp_fuel");//燃油费
		String exp_upkeep = request.getParameter("exp_upkeep");//保养费
		String exp_annual = request.getParameter("exp_annual");//年检费
		String exp_insure = request.getParameter("exp_insure");//保险费
		String exp_price = request.getParameter("exp_price");//总计
		String exp_notes = request.getParameter("exp_notes");//备注
		//String url = request.getParameter("url");//
		//生成对象
		PrintWriter out = response.getWriter();
		Expense expense = new Expense();
		IExpense iExpense = new ExpenseServices();
		HttpSession session = request.getSession();
		//判断opt，执行对应功能
		//点击保存实际执行的是修改功能
		if ("upd".equals(opt)) {
			if (StringUtil.isNotEmpty(ret_id)) {
				expense.setRet_id(ret_id);
			}
			if (StringUtil.isNotEmpty(exp_id)) {
				expense.setExp_id(exp_id);
			}
			if (StringUtil.isNotEmpty(exp_water)) {
				expense.setExp_water(exp_water);
			}
			if (StringUtil.isNotEmpty(exp_park)) {
				expense.setExp_park(exp_park);
			}
			if (StringUtil.isNotEmpty(exp_wash)) {
				expense.setExp_wash(exp_wash);
			}
			if (StringUtil.isNotEmpty(exp_toll)) {
				expense.setExp_toll(exp_toll);
			}
			if (StringUtil.isNotEmpty(exp_fuel)) {
				expense.setExp_fuel(exp_fuel);
			}
			if (StringUtil.isNotEmpty(exp_upkeep)) {
				expense.setExp_upkeep(exp_upkeep);
			}
			if (StringUtil.isNotEmpty(exp_annual)) {
				expense.setExp_annual(exp_annual);
			}
			if (StringUtil.isNotEmpty(exp_insure)) {
				expense.setExp_insure(exp_insure);
			}
			if (StringUtil.isNotEmpty(exp_price)) {
				expense.setExp_price(exp_price);
			}
			if (StringUtil.isNotEmpty(exp_notes)) {
				expense.setExp_notes(exp_notes);
			}
			if(iExpense.updExpense(expense)) {
				out.print("{\"success\": true,\"message\": \"添加成功.\"}");
			}else {
				out.print("{\"success\": false,\"message\": \"添加失败.\"}");
			}
			return;
		}
		//按照还车编号id，查找费用编号
		if("findById".equals(opt)) {
			if(!"".equals(ret_id)&&ret_id!=null) {
				expense.setRet_id(ret_id);
			}
			Expense expense2 = iExpense.findByIdExpense(expense);
			if(expense2!=null) {
				
				session.setAttribute("expense", expense2);
				JSONObject object = JSONObject.fromObject(expense2);
				out.print("{\"success\": true,\"expense\": "+object+"}");
				/*
				 * out.print(object); out.print("<script>");
				 * out.print("window,location.href='carsystem/"+url+"';");
				 * out.print("</script>");
				 */
			}else {
				out.print("{\"success\": false,\"expense\": \"操作错误\"}");
			}
			return;
		}
		//添加费用记录
		if("add".equals(opt)) {
			if(!"".equals(ret_id)&&ret_id!=null) {
				expense.setRet_id(ret_id);
			}
			//执行添加方法
			if(iExpense.addExpense(expense)) {
				Expense expense2 = iExpense.findByIdExpense(expense);
				//如果找到则存入session，并打开url界面
				if(expense2!=null) {
					//覆盖前面存入的对象
					session.setAttribute("expense", expense2);
					JSONObject object = JSONObject.fromObject(expense2);
					out.print("{\"success\": true,\"expense\": "+object+"}");
					/*
					 * out.print(object); out.print("<script>");
					 * out.print("window,location.href='carsystem/"+url+"';");
					 * out.print("</script>");
					 */
				}else {
					out.print("{\"success\": false,\"expense\": \"操作错误\"}");
				}
			} else {
				out.print("{\"success\": false,\"message\": \"添加失败.\"}");
			}
			return;
		}
	}

}
