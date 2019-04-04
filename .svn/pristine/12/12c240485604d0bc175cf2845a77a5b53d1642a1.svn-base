package com.it.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.it.bean.DriverInfo;
import com.it.bean.PageBean;
import com.it.utils.JDBCUtils;
import com.it.utils.StringUtil;

/**
 * 
 * @ClassName: DriverInfoDao
 * @Description: TODO(驾驶员档案dao层)
 * @author lijing
 * @date 2019年3月13日 下午7:46:26
 *
 */
public class DriverInfoDao {

	/**
	 * 获取连接池
	 */
	QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

	/**
	 * 
	* @Title: addDriver 
	* @Description: TODO(添加一条驾驶员档案记录) 
	* @param @param driver
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	public boolean addDriver(DriverInfo driver) {
		// 1.编写sql
		/*
		 * String sql =
		 * "INSERT INTO   driver_info ( dri_id , dri_name ,dri_sex , dri_age , dri_addr, dri_phone,dri_lic_id,dri_lic_type,dri_cer_no,dri_cer_type,dir_hiredate,dir_termdate)"
		 * + "VALUES (?,'?','?',?,'?','?','?','?','?','?','?','?');";
		 */
		String sql="INSERT INTO driver_info(dri_id,dri_name,dri_sex,dri_age,dri_addr,dri_phone,"
				+ "dri_lic_id,dri_lic_type,dri_cer_no,dri_cer_type,dir_hiredate,dir_termdate)" + 
				"        VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";
		// 2.打印sql
		System.out.println("添加驾驶员档案sql--->" + sql);
		System.out.println("dirver----?"+driver);
		// 3.处理参数
		Object[] param = {driver.getDri_id(),driver.getDri_name(),driver.getDri_sex(),driver.getDri_age(),
				driver.getDri_addr(),driver.getDri_phone(),driver.getDri_lic_id(),driver.getDri_lic_type(),
				driver.getDri_cer_no(),driver.getDri_cer_type(),driver.getDir_hiredate(),driver.getDir_termdate()};
		
		//定位标志位
		try {
			int row=qr.update(sql,param);
			return row>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("----添加驾驶员档案失败！！-----");
		}finally {
			try {
				//关闭
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败！！");
			}
		}
		
	}
    /**
* 
    * @Title: delDriver 
    * @Description: TODO(删除一条驾驶员档案记录) 
    * @param @param driver
    * @param @return    设定文件 
    * @return boolean    返回类型 
    * @throws
*/
	public boolean delDriver(DriverInfo driver) {
		//1.编写sql
		String sql="DELETE " + 
				"FROM driver_info " + 
				"WHERE dri_id = ? ";
		//2.打印sql
		System.out.println("删除驾驶员档案sql---->"+sql);
		//3.处理参数
		Object[] param = {driver.getDri_id()};
		//定位标志位
		try {
			int row=qr.update(sql, param);
			return row>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("-----删除驾驶员档案失败！！-----");
		}finally {
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败！！");
			}
		}
	}
    /**
* 
    * @Title: updDriver 
    * @Description: TODO(修改驾驶员档案记录) 
    * @param @param driver
    * @param @return    设定文件 
    * @return boolean    返回类型 
    * @throws
*/
	public boolean updDriver(DriverInfo driver) {
		System.out.println(driver);
		//1.编写sql
				String sql="UPDATE carsystem.driver_info" + 
						" SET " + 
						"  dri_name = ?," + 
						"  dri_sex = ?," + 
						"  dri_age = ?," + 
						"  dri_addr = ?," + 
						"  dri_phone = ?," + 
						"  dri_lic_id = ?," + 
						"  dri_lic_type = ?," + 
						"  dri_cer_no = ?," + 
						"  dri_cer_type = ?," + 
						"  dir_hiredate = ?," + 
						"  dir_termdate = ? " + 
						" WHERE dri_id = ? ";
		//2.打印sql
				System.out.println("修改驾驶员档案sql----->"+sql);
				// 3.处理参数
				Object[] param = {driver.getDri_name(),driver.getDri_sex(),driver.getDri_age(),
						driver.getDri_addr(),driver.getDri_phone(),driver.getDri_lic_id(),
						driver.getDri_lic_type(),driver.getDri_cer_no(),driver.getDri_cer_type(),
						driver.getDir_hiredate(),driver.getDir_termdate(),driver.getDri_id()};
		//定位标志位
				try {
					int row=qr.update(sql,param);
					
					return row>0;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException("----修改驾驶员档案失败！！-----");
				}finally {
					try {
						//关闭
						DbUtils.close(JDBCUtils.getConnections());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						throw new RuntimeException("关闭资源失败！！");
					}
				}
	}
    /**
* 
    * @Title: findByIdDriver 
    * @Description: TODO(查询单个驾驶员档案) 
    * @param @param driver
    * @param @return    设定文件 
    * @return DriverInfo    返回类型 
    * @throws
*/
	public DriverInfo findByIdDriver(DriverInfo driver) {
		//1.编写sql
		String sql="select * from driver_info "
				+ "where dri_id="+driver.getDri_id()+"";
		//2.打印sql
		System.out.println("查找驾驶员档案一条记录sql---->"+sql);
		//3.生成对象
		DriverInfo driver1=null;
		try {
			driver1=qr.query(sql, new BeanHandler<DriverInfo>(DriverInfo.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return driver1;
	}
    /**
* 
    * @Title: queryAllDriver 
    * @Description: TODO(含分页功能的 查询所有驾驶员档案) 
    * @param @param pageBean
    * @param @param driver
    * @param @return    设定文件 
    * @return List<DriverInfo>    返回类型 
    * @throws
*/
	public List<DriverInfo> queryAllDriver(PageBean pageBean, DriverInfo driver) {
		// 1.编写sql
		StringBuffer sql = new StringBuffer("select * from driver_info where 1=1 ");
		if (driver != null) {
			if (driver.getDri_id() != null) {
				sql.append("and dri_id like '%" + driver.getDri_id() + "%'");
			}
			if (StringUtil.isNotEmpty(driver.getDri_name())) {
				sql.append("and dri_name like '%" + driver.getDri_name() + "%'");
			}
		}
		if (pageBean != null) {
			sql.append(" limit " + pageBean.getStart() + "," + pageBean.getRows());
		}
		// 2.打印sql
		System.out.println("查询所有驾驶员档案sql-->" + sql.toString());
		// 3.生成存放驾驶员档案的集合 List<DriverInfo>
		List<DriverInfo> listd=null;
		
		try {
			listd=qr.query(sql.toString(), new BeanListHandler<DriverInfo>(DriverInfo.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("驾驶员档案--查询失败！！");
		} finally {
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败！！");
			}
		}
		return listd;
	}
/**
 * 
* @Title: queryAllDriver 
* @Description: TODO(不含分页功能的 查询所有驾驶员档案记录) 
* @param @param driver
* @param @return    设定文件 
* @return List<DriverInfo>    返回类型 
* @throws
 */
	public List<DriverInfo> queryAllDriver(DriverInfo driver) {
		// 1.编写sql
		StringBuffer sql = new StringBuffer("select * from driver_info where 1=1 ");
		if (driver != null) {
			if (driver.getDri_id() != null) {
				sql.append("and dri_id like '%" + driver.getDri_id() + "%'");
			}
			if (StringUtil.isNotEmpty(driver.getDri_name())) {
				sql.append("and dri_name like '%" + driver.getDri_name() + "%'");
			}
		}
		
		// 2.打印sql
		System.out.println("查询所有驾驶员档案sql-->" + sql.toString());
		// 3.生成存放驾驶员档案的集合 List<DriverInfo>
		List<DriverInfo> listd=null;
		
		try {
			listd=qr.query(sql.toString(), new BeanListHandler<DriverInfo>(DriverInfo.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("驾驶员档案--查询失败！！");
		} finally {
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败！！");
			}
		}
		return listd;
	}
    /**
* 
    * @Title: DriverCount 
    * @Description: TODO(查询记录总数) 
    * @param @param driver
    * @param @return    设定文件 
    * @return int    返回类型 
    * @throws
*/
	public int DriverCount(DriverInfo driver) {
		// 1.编写sql
		StringBuffer sb = new StringBuffer("select count(*) from driver_info where 1=1 ");
		// 有条件判断条件，重新拼接sql

		Number num;
		try {
			num = (Number) qr.query(sb.toString(), new ScalarHandler<>());

			return num.intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查询数据失败!");
		} finally {
			// 释放资源到数据库连接池
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!");
			}
		}
	}
    /**
* 
    * @Title: DriverDelete 
    * @Description: TODO(删除多条记录) 
    * @param @param delIds
    * @param @return    设定文件 
    * @return int    返回类型 
    * @throws
*/
	public int DriverDelete(String delIds) {
		System.out.println(delIds);
		String sql = "delete from  driver_info where dri_id in (" + delIds + ")";
		 System.out.println("sql--->"+sql);
		try {
			return qr.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
