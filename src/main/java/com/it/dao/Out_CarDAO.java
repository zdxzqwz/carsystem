package com.it.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.it.bean.Out_Car;
import com.it.bean.PageBean;
import com.it.utils.JDBCUtils;

/**
 * 
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: Out_CarDAO.java
* @Description: 出车表的dao层
*
* @version: v1.0.0
* @author: Only soul
* @date: 2019年3月12日 上午11:41:12 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年3月12日     Only soul           v1.0.0               修改原因
 */
public class Out_CarDAO {
	//获取连接池
	QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	/**
	 * 
	* @Description: 添加一条出车记录
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月12日 上午11:48:39
	 */
	public boolean addOutCar(Out_Car out_car) {
		String sql = "INSERT INTO `carsystem`.`out_car` (`dri_id`,`dri_name`,`out_car_id`,`out_why`,`out_test`,`out_time`,`out_notes`,`out_inputer`) "
				+ "VALUES ("+out_car.getDri_id()+",'"+out_car.getDri_name()+"','"+out_car.getOut_car_id()+"','"+out_car.getOut_why()+"','"+out_car.getOut_test()+"','"+out_car.getOut_time()+"','"+out_car.getOut_notes()+"','"+out_car.getOut_inputer()+"');";
		System.out.println("添加出车记录sql---->"+sql);
		try {
			if(qr.update(sql)>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("添加出车记录失败");
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
	* @Description: 删除一条出车记录
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月12日 上午11:48:47
	 */
	public boolean delOutCar(Out_Car out_car) {
		String sql = "DELETE FROM `carsystem`.`out_car` WHERE `out_id` = "+out_car.getOut_id()+";";
		System.out.println("删除出车记录sql---->"+sql);
		try {
			if(qr.update(sql)>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("删除出车记录失败");
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
	* @Description: 修改一条出车记录
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月12日 上午11:49:05
	 */
	public boolean updOutCar(Out_Car out_car) {
		String sql = "UPDATE `carsystem`.`out_car` "
				+ "SET `dri_id` = "+out_car.getDri_id()+",`out_car_id` = '"+out_car.getOut_car_id()+"',`out_why` = '"+out_car.getOut_why()+"',`out_test` = '"+out_car.getOut_test()+"',`out_time` = '"+out_car.getOut_time()+"',`out_notes` = '"+out_car.getOut_notes()+"'  "
				+ "WHERE `out_id` = "+out_car.getOut_id()+";";
		System.out.println("修改出车记录sql---->"+sql);
		try {
			if(qr.update(sql)>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("修改出车记录失败");
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
	* @Description: 根据ID查询单个出车记录
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月12日 上午11:49:19
	 */
	public Out_Car findByIdOutCar(Out_Car out_car) {
		String sql = "select * from out_car where out_id="+out_car.getOut_id();
		System.out.println("查询单个出车记录sql---->"+sql);
		Out_Car outcar = null;
		try {
			outcar = qr.query(sql, new BeanHandler<Out_Car>(Out_Car.class));
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
		return outcar;
	}

	/**
	 * 
	* @Description: 带分页和模糊查询的查询所有
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月12日 上午11:49:35
	 */
	public List<Out_Car> queryAllOutCar(PageBean pageBean, Out_Car out_car) {
		StringBuffer sql = new StringBuffer("select * from out_car where 1=1 ");
		if(out_car!=null) {
			if(!"".equals(out_car.getDri_name())&&out_car.getDri_name()!=null) {
				sql.append("and dri_name like '%"+out_car.getDri_name()+"%' ");
			}
			if(!"".equals(out_car.getOut_car_id())&&out_car.getOut_car_id()!=null) {
				sql.append("and out_car_id like '%"+out_car.getOut_car_id()+"%' ");
			}
		}
		if (pageBean != null) {
			sql.append(" limit " + pageBean.getStart() + ","
					+ pageBean.getRows());
		}
		System.out.println("带分页和模糊查询的查询所有sql-->"+sql);
		List<Out_Car> list = null;
		try {
			list = qr.query(sql.toString(), new BeanListHandler<Out_Car>(Out_Car.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询失败");
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
	* @Description: 查询记录数
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月12日 上午11:49:53
	 */
	public int outCarCount(Out_Car out_car) {
		StringBuffer sql = new StringBuffer("select count(*) from out_car where 1=1 ");
		if(out_car!=null) {
			if ((!"".equals(out_car.getDri_name()) && out_car.getDri_name() != null)) {
				sql.append("and dri_name like '"+out_car.getDri_name()+"' ");
			}
			if ((!"".equals(out_car.getOut_car_id()) && out_car.getOut_car_id() != null)) {
				sql.append("and out_car_id like '"+out_car.getOut_car_id()+"' ");
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
	* @Description: 删除多条记录 
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月12日 上午11:53:00
	 */
	public int outCarDelete(String delIds) {
		String sql = "delete from  out_car where out_id in (" + delIds + ")";
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
	* @Description: 删除驾驶员档案调用方法，按照驾驶员编号查询
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月25日 下午9:08:44
	 */
	public boolean findByDriId(String dri_id) {
		String sql = "select * from out_car where dri_id='"+dri_id+"'";
		//System.out.println("查询单个出车记录sql---->"+sql);
		Out_Car outcar = null;
		try {
			outcar = qr.query(sql, new BeanHandler<Out_Car>(Out_Car.class));
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
		if(outcar==null) {
			return false;
		}else {
			return true;
		}
		
	}

	/**
	 * 
	* @Description: 按照车牌号进行查询
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月25日 下午9:34:23
	 */
	public boolean findBycarId(String car_id) {
		String sql = "select * from out_car where out_car_id='"+car_id+"'";
		//System.out.println("查询单个出车记录sql---->"+sql);
		Out_Car outcar = null;
		try {
			outcar = qr.query(sql, new BeanHandler<Out_Car>(Out_Car.class));
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
		if(outcar==null) {
			return false;
		}else {
			return true;
		}
	}
}
