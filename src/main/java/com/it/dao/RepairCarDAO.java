package com.it.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.it.bean.PageBean;
import com.it.bean.Repair_Car;
import com.it.utils.JDBCUtils;

/**
 * 
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: RepairCarDAO.java
* @Description: 车辆维修表的dao层
*
* @version: v1.0.0
* @author: Only soul
* @date: 2019年3月18日 下午10:08:05 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年3月18日     Only soul           v1.0.0               修改原因
 */
public class RepairCarDAO {
	QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	/**
	 * 
	* @Description: 添加车辆维修表
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月18日 下午10:11:13
	 */
	public boolean addRepairCar(Repair_Car repaircar) {
		String sql = "INSERT INTO `carsystem`.`repair_car`(`rep_car_id`,`rep_maintain`,`rep_details`,`rep_out_time`,"
				+ "`rep_return_time`,`rep_price`,`rep_inputer`,`rep_notes`)"
				+ "VALUES ('"+repaircar.getRep_car_id()+"','"+repaircar.getRep_maintain()+"','"+repaircar.getRep_details()+"','"+repaircar.getRep_out_time()+"',"
				+ "'"+repaircar.getRep_return_time()+"','"+repaircar.getRep_price()+"','"+repaircar.getRep_inputer()+"','"+repaircar.getRep_notes()+"');";
		System.out.println("添加维修记录sql---->"+sql);
		try {
			if(qr.update(sql)>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("添加维修记录失败");
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
	* @Description: 删除车辆维修表
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月18日 下午10:11:28
	 */
	public boolean delRepairCar(Repair_Car repaircar) {
		String sql = "DELETE FROM `carsystem`.`repair_car` WHERE `rep_id` = "+repaircar.getRep_id()+";";
		System.out.println("删除维修记录sql---->"+sql);
		try {
			if(qr.update(sql)>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("删除维修记录失败");
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
	* @Description: 修改车辆维修表
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月18日 下午10:11:39
	 */
	public boolean updRepairCar(Repair_Car repaircar) {
		String sql = "UPDATE `carsystem`.`repair_car`"
				+ "SET`rep_car_id` = '"+repaircar.getRep_car_id()+"',`rep_maintain` = '"+repaircar.getRep_maintain()+"',`rep_details` = '"+repaircar.getRep_details()+"',`rep_out_time` = '"+repaircar.getRep_out_time()+"'," 
				+ "`rep_return_time` = '"+repaircar.getRep_return_time()+"',`rep_price` = '"+repaircar.getRep_price()+"',`rep_inputer` = '"+repaircar.getRep_inputer()+"',`rep_notes` = '"+repaircar.getRep_notes()+"'"
				+ "WHERE `rep_id` = '"+repaircar.getRep_id()+"';";
		System.out.println("修改维修记录sql---->"+sql);
		try {
			if(qr.update(sql)>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("修改维修记录失败");
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
	* @Description: 查询所有车辆维修信息
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月18日 下午10:11:49
	 */
	public List<Repair_Car> queryAllRepairCar(PageBean pageBean,Repair_Car repaircar,String datemin,String datemax) {
		StringBuffer sql = new StringBuffer("select * from repair_car where 1=1 ");
		if(repaircar!=null) {
			if(!"".equals(repaircar.getRep_car_id())&&repaircar.getRep_car_id()!=null) {
				sql.append("and rep_car_id like '%"+repaircar.getRep_car_id()+"%' ");
			}
			if(!"".equals(repaircar.getRep_maintain())&&repaircar.getRep_maintain()!=null) {
				sql.append("and rep_maintain like '%"+repaircar.getRep_maintain()+"%' ");
			}
			if(!"".equals(datemin)&&datemin!=null) {
				sql.append("and ret_out_time >= '"+datemin+"' ");
			}
			if(!"".equals(datemax)&&datemax!=null) {
				sql.append("and ret_return_time <= '"+datemax+"' ");
			}
		}
		if (pageBean != null) {
			sql.append(" limit " + pageBean.getStart() + ","
					+ pageBean.getRows());
		}
		System.out.println("带分页和模糊查询的查询所有sql-->"+sql);
		List<Repair_Car> list = null;
		try {
			list = qr.query(sql.toString(), new BeanListHandler<Repair_Car>(Repair_Car.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询还车纪录失败");
		}finally {
			//释放资源到数据库连接池
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
		return list;
	}

	/**
	 * 
	* @Description: 查询单个车辆维修信息
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月18日 下午10:12:02
	 */
	public Repair_Car findByIdRepairCar(Repair_Car repaircar) {
		String sql = "select * from repair_car where rep_id="+repaircar.getRep_id();
		System.out.println("查询单个维修记录sql---->"+sql);
		Repair_Car repaircar1 = null;
		try {
			repaircar1 = qr.query(sql, new BeanHandler<Repair_Car>(Repair_Car.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询单个出车记录失败");
		}finally {
			//释放资源到数据库连接池
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
		return repaircar1;
	}

	/**
	 * 
	* @Description: 批量删除多条车辆维修信息
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月18日 下午10:12:13
	 */
	public int repairCarDelete(String delIds) {
		String sql = "delete from  repair_car where rep_id in (" + delIds + ")";
		 System.out.println("删除多条sql--->"+sql);
		try {
			return qr.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//释放资源到数据库连接池
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
		return 0;
	}

	/**
	 * 
	* @Description: 查询总记录数
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月18日 下午10:12:38
	 */
	public int repairCarCount(Repair_Car repaircar,String datemin,String datemax) {
		StringBuffer sql = new StringBuffer("select count(*) from repair_car where 1=1 ");
		if(repaircar!=null) {
			if(!"".equals(repaircar.getRep_car_id())&&repaircar.getRep_car_id()!=null) {
				sql.append("and rep_car_id like '%"+repaircar.getRep_car_id()+"%' ");
			}
			if(!"".equals(repaircar.getRep_maintain())&&repaircar.getRep_maintain()!=null) {
				sql.append("and rep_maintain like '%"+repaircar.getRep_maintain()+"%' ");
			}
			if(!"".equals(datemin)&&datemin!=null) {
				sql.append("and ret_out_time >= '"+datemin+"' ");
			}
			if(!"".equals(datemax)&&datemax!=null) {
				sql.append("and ret_return_time <= '"+datemax+"' ");
			}
		}
		 Number num;
			try {
				num = (Number)qr.query(sql.toString(),new ScalarHandler<>());
			
				return num.intValue();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("查询数据个数失败!");
			}finally {
				//释放资源到数据库连接池
				try {
					DbUtils.close(JDBCUtils.getConnections());
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException("关闭资源失败!");
				}
			}
	}
	/**
	 * 
	* @Description: 取回维修车辆的
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月19日 下午7:10:21
	 */
	public boolean quche(Repair_Car repaircar) {
		String sql = "UPDATE `carsystem`.`repair_car`"
				+ "SET `rep_return_time` = '"+repaircar.getRep_return_time()+"' WHERE `rep_id` = '"+repaircar.getRep_id()+"';";
		System.out.println("取车sql---->"+sql);
		try {
			if(qr.update(sql)>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("取车失败");
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
	* @Description: 按照外间进行查询
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月25日 下午9:43:45
	 */
	public boolean findBycarId(String car_id) {
		String sql = "select * from repair_car where rep_car_id='"+car_id+"'";
		//System.out.println("查询单个出车记录sql---->"+sql);
		Repair_Car repcar = null;
		try {
			repcar = qr.query(sql, new BeanHandler<Repair_Car>(Repair_Car.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询单个出车记录失败");
		}finally {
			//释放资源到数据库连接池
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
		if(repcar==null) {
			return false;
		}else {
			return true;
		}
	}
}
