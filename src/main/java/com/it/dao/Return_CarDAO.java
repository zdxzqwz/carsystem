package com.it.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import com.it.bean.PageBean;
import com.it.bean.Return_Car;
import com.it.utils.JDBCUtils;

/**
 * 
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: Return_CarDAO.java
* @Description: 还车表DAO层
*
* @version: v1.0.0
* @author: Only soul
* @date: 2019年3月15日 上午9:26:45 
*
* Modification History:
* Date Author  VersionDescription
*---------------------------------------------------------*
* 2019年3月15日     Only soul   v1.0.0   修改原因
 */
public class Return_CarDAO {
	QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	/**
	 * 
	* @Description: 查询所有还车纪录
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月15日 上午9:28:17
	 */
	public List<Return_Car> queryAllReturnCar(PageBean pageBean, Return_Car returncar,String datemin,String datemax) {
		StringBuffer sql = new StringBuffer("select * from return_car where 1=1 ");
		if(returncar!=null) {
			if(!"".equals(returncar.getDri_name())&&returncar.getDri_name()!=null) {
				sql.append("and dri_name like '%"+returncar.getDri_name()+"%' ");
			}
			if(!"".equals(returncar.getCar_id())&&returncar.getCar_id()!=null) {
				sql.append("and car_id like '%"+returncar.getCar_id()+"%' ");
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
		List<Return_Car> list = null;
		try {
			list = qr.query(sql.toString(), new BeanListHandler<Return_Car>(Return_Car.class));
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
	* @Description: 添加还车纪录
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月15日 上午9:30:46
	 */
	public boolean addReturnCar(Return_Car returncar) {
		String sql = "INSERT INTO `carsystem`.`return_car`" + 
				"(`dri_id`,"+ 
				"`dri_name`,"+ 
				//"`exp_id`,"+ 
				//"`cmt_id`,"+ 
				"`car_id`,"+ 
				"`ret_out_why`,"+ 
				"`ret_out_time`,"+ 
				"`ret_return_time`,"+ 
				"`ret_out_test`,"+ 
				"`out_inputer`,"+ 
				"`ret_inputer`,"+ 
				"`ret_notes`)"+ 
				" VALUES ('"+returncar.getDri_id()+"'," + 
				"'"+returncar.getDri_name()+"'," + 
				//"''," + 
				//"''," + 
				"'"+returncar.getCar_id()+"'," + 
				"'"+returncar.getRet_out_why()+"'," + 
				"'"+returncar.getRet_out_time()+"'," + 
				"'"+returncar.getRet_return_time()+"'," + 
				"'"+returncar.getRet_out_test()+"'," + 
				"'"+returncar.getOut_inputer()+"'," + 
				"'"+returncar.getRet_inputer()+"'," + 
				"'"+returncar.getRet_notes()+"');";
		System.out.println("添加还车记录sql---->"+sql);
		try {
			if(qr.update(sql)>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("添加还车记录失败");
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
	* @Description: 删除还车纪录
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月15日 上午9:31:00
	 */
	public boolean delReturnCar(Return_Car returncar) {
		String sql = "DELETE FROM `carsystem`.`return_car` WHERE `ret_id` = '"+returncar.getRet_id()+"';";
		System.out.println("删除还车记录sql---->"+sql);
		try {
			if(qr.update(sql)>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("删除还车记录失败");
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
	* @Description: 修改还车纪录
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月15日 上午9:31:12
	 */
	public boolean updReturnCar(Return_Car ret) {
		String sql = "UPDATE `carsystem`.`return_car` "
				+ "SET`dri_id` = '"+ret.getDri_id()+"',`dri_name` = '"+ret.getDri_name()+"',`car_id` = '"+ret.getCar_id()+"',`ret_out_why` = '"+ret.getRet_out_why()+"',`ret_out_time` = '"+ret.getRet_out_time()+"',"
				+ "`ret_out_test` = '"+ret.getRet_out_test()+"',`ret_return_time` = '"+ret.getRet_return_time()+"',`out_inputer` = '"+ret.getOut_inputer()+"',`ret_inputer` = '"+ret.getRet_inputer()+"',`ret_notes` = '"+ret.getRet_notes()+"'"
				+ "WHERE `ret_id` = '"+ret.getRet_id()+"';";
		System.out.println("修改还车记录sql---->"+sql);
		try {
			if(qr.update(sql)>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("修改还车记录失败");
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
	* @Description: 查询单个还车记录
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月15日 上午9:31:26
	 */
	public Return_Car findById(Return_Car returncar) {
		String sql = "select * from return_car where ret_id="+returncar.getRet_id();
		System.out.println("查询单个出车记录sql---->"+sql);
		Return_Car returncar1 = null;
		try {
			returncar1 = qr.query(sql, new BeanHandler<Return_Car>(Return_Car.class));
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
		return returncar1;
	}

	/**
	 * 
	* @Description: 查询总记录数
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月15日 上午9:33:19
	 */
	public int returnCarCount(Return_Car returncar) {
		String sql = "select count(*) from return_car where 1=1 ";
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
	* @Description: 删除多条还车纪录
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月15日 上午9:33:50
	 */
	public int returnCarDelete(String delIds) {
		String sql = "delete from  return_car where ret_id in (" + delIds + ")";
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
		String sql = "select * from return_car where dri_id='"+dri_id+"'";
		//System.out.println("查询单个出车记录sql---->"+sql);
		Return_Car returncar = null;
		try {
			returncar = qr.query(sql, new BeanHandler<Return_Car>(Return_Car.class));
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
		if(returncar==null) {
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
		String sql = "select * from return_car where car_id='"+car_id+"'";
		//System.out.println("查询单个出车记录sql---->"+sql);
		Return_Car returncar = null;
		try {
			returncar = qr.query(sql, new BeanHandler<Return_Car>(Return_Car.class));
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
		if(returncar==null) {
			return false;
		}else {
			return true;
		}
	}
}
