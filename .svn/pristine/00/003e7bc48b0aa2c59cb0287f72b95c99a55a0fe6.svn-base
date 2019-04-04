package com.it.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.it.bean.Expense;
import com.it.utils.JDBCUtils;
/**
 * 
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: ExpenseDAO.java
* @Description: 费用表的dao层
*
* @version: v1.0.0
* @author: Only soul
* @date: 2019年3月19日 下午9:00:44 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年3月19日     Only soul           v1.0.0               修改原因
 */
public class ExpenseDAO {
	QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	/**
	 * 
	* @Description: 添加还车纪录时自动通过还车编号添加一条费用纪录，点击查看费用记录其实调用的修改方法
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月19日 下午9:42:14
	 */
	public boolean addExpense(Expense expense) {
		String sql = "INSERT INTO `carsystem`.`expense`(`ret_id`) VALUES ('"+expense.getRet_id()+"');";
		System.out.println("添加维修记录sql---->"+sql);
		try {
			if(qr.update(sql)>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("添加费用记录失败");
		}finally {
			//释放资源到数据库连接池
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
		return false;
	}

	/**
	 * 
	* @Description: 删除还车记录时，根据还车编号删除对应的费用纪录
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月19日 下午9:52:30
	 */
	public boolean delExpense(Expense expense) {
		String sql = "DELETE FROM `carsystem`.`expense` WHERE `ret_id` = '"+expense.getRet_id()+"';";
		System.out.println("删除维修记录sql---->"+sql);
		try {
			if(qr.update(sql)>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("删除费用记录失败");
		}finally {
			//释放资源到数据库连接池
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
		return false;
	}

	/**
	 * 
	* @Description: 修改
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月19日 下午9:53:26
	 */
	public boolean updExpense(Expense expense) {
		String sql = "UPDATE `carsystem`.`expense`"
				+ "SET `exp_water` = '"+expense.getExp_water()+"',`exp_park` = '"+expense.getExp_park()+"',`exp_wash` = '"+expense.getExp_wash()+"',"
				+ "`exp_toll` = '"+expense.getExp_toll()+"',`exp_fuel` = '"+expense.getExp_fuel()+"',`exp_upkeep` = '"+expense.getExp_upkeep()+"',"
				+ "`exp_annual` = '"+expense.getExp_annual()+"',`exp_insure` = '"+expense.getExp_insure()+"',`exp_price` = '"+expense.getExp_price()+"',"
				+ "`exp_inputer` = '"+expense.getExp_inputer()+"',`exp_notes` = '"+expense.getExp_notes()+"'"
				+ "WHERE `ret_id` = '"+expense.getRet_id()+"';";
		System.out.println("修改费用记录sql---->"+sql);
		try {
			if(qr.update(sql)>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("修改费用记录失败");
		}finally {
			//释放资源到数据库连接池
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
		return false;
	}

	
	public List<Expense> queryAllExpense(Expense expense) {
		
		return null;
	}

	/**
	 * 
	* @Description: 根据还车编号查询单个
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月19日 下午10:00:00
	 */
	public Expense findByIdExpense(Expense expense) {
		String sql = "SELECT * FROM `carsystem`.`expense` WHERE ret_id="+expense.getRet_id();
		System.out.println("查询单个费用记录sql---->"+sql);
		Expense expense1 = null;
		try {
			expense1 = qr.query(sql, new BeanHandler<Expense>(Expense.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询单个费用纪录失败");
		}finally {
			//释放资源到数据库连接池
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
		return expense1;
	}
}
