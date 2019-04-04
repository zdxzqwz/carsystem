package com.it.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.it.bean.Expense;
import com.it.bean.Out_Car;
import com.it.bean.PageBean;
import com.it.bean.Return_Car;
import com.it.bean.Users;
import com.it.global.IExpense;
import com.it.global.IOut_CarServices;
import com.it.global.IReturn_Car;
import com.it.services.CarImpl;
import com.it.services.Commentlmpl;
import com.it.services.ExpenseServices;
import com.it.services.Out_CarServices;
import com.it.services.ReturnCarServices;
import com.it.utils.StringUtil;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class Return_CarServlet
 */
@WebServlet(
asyncSupported = true, 
urlPatterns = { 
"/Return_CarServlet", 
"/returncar.do"
})
public class Return_CarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Return_CarServlet() {
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
		//设置编码各格式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//获取页面信息
		String opt = request.getParameter("opt");
		String ret_id = request.getParameter("ret_id");////还车编号
		String out_id = request.getParameter("out_id");//出车编号,添加还车记录后删除对应的出车记录
		String dri_id = request.getParameter("dri_id");//驾驶员编号
		String car_id = request.getParameter("car_id");//车牌号
		String ret_out_why = request.getParameter("ret_out_why");//出车事由
		String ret_out_test = request.getParameter("ret_out_test");//目的地
		String ret_out_time = request.getParameter("ret_out_time");//出车时间
		String ret_return_time = request.getParameter("ret_return_time");//还车时间
		String ret_notes = request.getParameter("ret_notes");//出车备注
		String dri_name = request.getParameter("dri_name");//驾驶员姓名
		String out_inputer = request.getParameter("out_inputer");//出车登记人
		//System.out.println(car_id+"\t123"+dri_name);
		//生成 对象
		PrintWriter out = response.getWriter();
		Return_Car return_car = new Return_Car();
		Out_Car outcar = new Out_Car();//出车表
		Expense expense = new Expense();//费用表对象
		//Driver_Comment dri_com = new Driver_Comment();//驾驶员评议
		//services对象
		IOut_CarServices outServices = new Out_CarServices();//出车表的服务类
		IExpense expServices = new ExpenseServices();//费用表的服务类
		//IComment iComment = new Commentlmpl();//评议表的服务类
		IReturn_Car services = new ReturnCarServices();//还车表的服务类
		//判断opt，执行相应功能
		//批量删除
		if("delIds".equals(opt)) {
			String delIds = request.getParameter("delIds");//批量删除获取id;
			if(!"".equals(delIds)&&delIds!=null) {
				int count = services.returnCarDelete(delIds);
				out.print(count);
			}
			return;
		}
		//修改还车纪录
		if("upd".equals(opt)) {
			if(!"".equals(ret_id)&&ret_id!=null) {
				return_car.setRet_id(ret_id);
			}
			if(!"".equals(dri_id)&&dri_id!=null) {
				return_car.setDri_id(dri_id);
			}
			if(!"".equals(car_id)&&car_id!=null) {
				return_car.setCar_id(car_id);
			}
			if(!"".equals(dri_name)&&dri_name!=null) {
				return_car.setDri_name(dri_name);
			}
			if(!"".equals(ret_out_why)&&ret_out_why!=null) {
				return_car.setRet_out_why(ret_out_why);
			}
			if(!"".equals(ret_out_test)&&ret_out_test!=null) {
				return_car.setRet_out_test(ret_out_test);
			}
			if(!"".equals(ret_out_time)&&ret_out_time!=null) {
				return_car.setRet_out_time(ret_out_time);
			}
			if(!"".equals(ret_return_time)&&ret_return_time!=null) {
				return_car.setRet_return_time(ret_return_time);
			}
			if(!"".equals(ret_notes)&&ret_notes!=null) {
				return_car.setRet_notes(ret_notes);
			}
			if(services.updReturnCar(return_car)) {
				out.print("{\"success\": true,\"message\": \"修改还车记录成功.\"}");
			}else {
				out.print("{\"success\": false,\"message\": \"修改还车记录失败.\"}");
			}
			return;
		}
		//查找单个还车纪录
		if("findById".equals(opt)) {
			String url = request.getParameter("url");
			if(!"".equals(ret_id)&&ret_id!=null) {
				return_car.setRet_id(ret_id);
			}
			Return_Car returncar1 = services.findById(return_car);
			HttpSession session = request.getSession();
			session.setAttribute("returncar", returncar1);
			System.out.println(returncar1);
			out.print("<script>");
			out.print("window.location.href=\"carsystem/"+url+"\"");
			out.print("</script>");
			return;
		}
		//删除出车记录,先删除评议记录和费用纪录
		if("del".equals(opt)) {
			if(!"".equals(ret_id)&&ret_id!=null) {
				return_car.setRet_id(ret_id);
				expense.setRet_id(ret_id);
			}
			//先根据外键删除从表的信息
			expServices.delExpense(expense);
			new Commentlmpl().delCommentByFk(return_car);
			if(services.delReturnCar(return_car)) {
				out.print("{\"success\": true,\"message\": \"删除还车记录成功.\"}");
			}else {
				out.print("{\"success\": false,\"message\": \"删除还车记录成功.\"}");
			}
			return;
		}
		//添加还车纪录
		if("add".equals(opt)) {
			//获取session
			HttpSession session = request.getSession();
			Users user = (Users)session.getAttribute("user");
			if (StringUtil.isNotEmpty(user.getUser_name())) {
				return_car.setRet_inputer(user.getUser_name());
			}
			if(!"".equals(out_inputer)&&out_inputer!=null) {
				return_car.setOut_inputer(out_inputer);
			}
			if(!"".equals(dri_id)&&dri_id!=null) {
				return_car.setDri_id(dri_id);
			}
			if(!"".equals(car_id)&&car_id!=null) {
				return_car.setCar_id(car_id);
			}
			if(!"".equals(dri_name)&&dri_name!=null) {
				return_car.setDri_name(dri_name);
			}
			if(!"".equals(ret_out_why)&&ret_out_why!=null) {
				return_car.setRet_out_why(ret_out_why);
			}
			if(!"".equals(ret_out_test)&&ret_out_test!=null) {
				return_car.setRet_out_test(ret_out_test);
			}
			if(!"".equals(ret_out_time)&&ret_out_time!=null) {
				return_car.setRet_out_time(ret_out_time);
			}
			if(!"".equals(ret_return_time)&&ret_return_time!=null) {
				return_car.setRet_return_time(ret_return_time);
			}
			if(!"".equals(ret_notes)&&ret_notes!=null) {
				return_car.setRet_notes(ret_notes);
			}
			if(!"".equals(out_id)&&out_id!=null) {
				outcar.setOut_id(out_id);
			}
			if(new CarImpl().updVehicles(car_id,"空闲")) {
				if(services.addReturnCar(return_car)&&outServices.delOutCar(outcar)) {
					out.print("{\"success\": true,\"message\": \"添加还车记录成功.\"}");
				}else {
					out.print("{\"success\": false,\"message\": \"添加还车记录失败.\"}");
				}
			}else {
				out.print("{\"success\": false,\"message\": \"添加还车记录失败.\"}");
			}
			
			return;
		}
		//查询所有
		if("queryAll".equals(opt)) {
			String datemin = request.getParameter("datemin");//日期范围
			String datemax = request.getParameter("datemax");//日期范围
			String page = request.getParameter("curr");
			String limit = request.getParameter("limit");
			if(!"".equals(car_id)&&car_id!=null) {
				return_car.setCar_id(car_id);
			}
			if(!"".equals(dri_name)&&dri_name!=null) {
				return_car.setDri_name(dri_name);
			}
			if ("".equals(page) || page == null||"undefined".equals(page)) {
				page = "1";
			}
			if ("".equals(limit) || limit == null||"undefined".equals(page)) {
				limit = "10";
			}
			PageBean pageBean = new PageBean(Integer.parseInt(page),Integer.parseInt(limit));
			int count = services.returnCarCount(return_car);
			List<Return_Car>list = services.queryAllReturnCar(pageBean, return_car, datemin, datemax);
			JSONArray array = JSONArray.fromObject(list);
			String a = "{\"count\":"+count+",\"returncar\":"+array+"}";
			out.print(a);
			return;
		}
	}

}
