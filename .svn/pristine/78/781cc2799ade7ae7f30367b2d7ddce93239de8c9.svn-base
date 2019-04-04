package com.it.dao;

import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.github.pagehelper.util.StringUtil;
import com.it.bean.PageBean;
import com.it.bean.Technical_File;
import com.it.utils.JDBCUtils;
	/**
	 * 
	* @ClassName: Technical_FileDao 
	* @Description: TODO(车辆技术档案Dao层) 
	* @author lijing
	* @date 2019年3月12日 下午9:29:11 
	*
	 */

public class Technical_FileDao {
/*
 * 获取连接池
 */
	 QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
	/**
	 * 
	* @Title: addTechFile 
	* @Description: TODO(添加一条车辆技术档案记录) 
	* @param @param tf
	* @param @return设定文件 
	* @return boolean返回类型 
	* @throws
	 */
	public boolean addTechFile(Technical_File tf) {
		
		//1.编写sql语句
		String sql="INSERT INTO technical_file(car_tec_cno,tec_release_date,tec_origin,tec_vin," + 
				" tec_ctype,tec_fuel_type,tec_cpower,tec_cc,tec_neshaps,tec_driving_type," + 
				" tec_tires_no,tec_axis,tec_transmission_type,tec_retarder,tec_diverter," + 
				" tec_suspension_mode,tec_service_brake)" + 
				" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		// 2.打印sql
		System.out.println("sql------>" + sql);
		// 3.处理参数
		Object[] param = { tf.getCar_tec_cno(), tf.getTec_release_date(), tf.getTec_origin(), tf.getTec_vin(),
				tf.getTec_ctype(), tf.getTec_fuel_type(), tf.getTec_cpower(), tf.getTec_cc(), tf.getTec_neshaps(),
				tf.getTec_driving_type(), tf.getTec_tires_no(), tf.getTec_axis(), tf.getTec_transmission_type(),
				tf.getTec_retarder(), tf.getTec_diverter(), tf.getTec_suspension_mode(), tf.getTec_service_brake() };
		// 定义标志位
		try {
			int row = qr.update(sql, param);
			System.out.println("---车辆技术档案添加--row=------" + row);
			return row > 0;
		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException("-------添加失败!!--------");
		} finally {
			// 释放资源到连接池
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
	* @Title: delTechFile 
	* @Description: TODO(删除一条车辆技术档案记录) 
	* @param @param tf
	* @param @return设定文件 
	* @return boolean返回类型 
	* @throws
	 */
	public boolean delTechFile(Technical_File tf) {
		//1.编写sql
		String sql="DELETE" + 
				"FROM technical_file" + 
				"WHERE car_tec_cno = ?;";
		// 2.打印sql
		System.out.println("sql------>" + sql);
		// 3.处理参数
		Object[] param = { tf.getCar_tec_cno() };
		// 定义标志位
		try {
			int row = qr.update(sql, param);
			System.out.println("---车辆技术档案删除--row=------" + row);
			return row > 0;
		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException("-------删除失败!!--------");
		} finally {
			// 释放资源到连接池
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
	* @Title: updTechFile 
	* @Description: TODO(修改车辆技术档案资料记录) 
	* @param @param tf
	* @param @return设定文件 
	* @return boolean返回类型 
	* @throws
	 */
	public boolean updTechFile(Technical_File tf) {
		System.out.println("----UPD----"+tf);
		// 1.编写sql语句
		String sql = "UPDATE carsystem.technical_file " + 
				"SET  " + 
				"  tec_release_date = ?, " + 
				"  tec_origin = ?, " + 
				"  tec_vin = ?, " + 
				"  tec_ctype = ?, " + 
				"  tec_fuel_type = ?, " + 
				"  tec_cpower = ?, " + 
				"  tec_cc = ?, " + 
				"  tec_neshaps = ?, " + 
				"  tec_driving_type = ?, " + 
				"  tec_tires_no = ?, " + 
				"  tec_axis = ?, " + 
				"  tec_transmission_type = ?, " + 
				"  tec_retarder = ?, " + 
				"  tec_diverter = ?, " + 
				"  tec_suspension_mode = ?, " + 
				"  tec_service_brake = ? " + 
				"WHERE car_tec_cno = ?";
		// 2.打印sql
		System.out.println("----修改车辆技术档案---sql--->" + sql);
		// 3.处理参数
				Object[] param = { tf.getTec_release_date(), tf.getTec_origin(), tf.getTec_vin(),
						tf.getTec_ctype(), tf.getTec_fuel_type(), tf.getTec_cpower(), tf.getTec_cc(), tf.getTec_neshaps(),
						tf.getTec_driving_type(), tf.getTec_tires_no(), tf.getTec_axis(), tf.getTec_transmission_type(),
						tf.getTec_retarder(), tf.getTec_diverter(), tf.getTec_suspension_mode(), tf.getTec_service_brake(),tf.getCar_tec_cno() };
				// 定义标志位
				try {
					int row = qr.update(sql, param);
					System.out.println("---车辆技术档案修改--row---->" + row);
					return row > 0;
				} catch (SQLException e) {

					e.printStackTrace();
					throw new RuntimeException("-------修改失败!!--------");
				} finally {
					// 释放资源到连接池
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
	* @Title: findByIdTechFile 
	* @Description: TODO(查询单条车辆技术档案记录) 
	* @param @param tf
	* @param @return设定文件 
	* @return Technical_File返回类型 
	* @throws
	 */
	public Technical_File findByIdTechFile(Technical_File tf) {
		//1.编写sql
		String sql="select * from carsystem.technical_file"
				+ "where car_tec_cno = ?";
		//2.打印sql
		System.out.println("------查找车辆技术档案sql---->"+sql);
		//3.处理参数
		Object[] param= {tf.getCar_tec_cno()};
		
		Technical_File tf1=null;
		try {
			tf1=qr.query(sql,new BeanHandler<Technical_File>(Technical_File.class), param);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("-----查找失败！！-----");
		}finally {
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败！");
			}
		}	
		return tf1;
	}
     /**
      * 
     * @Title: queryAllTechnical_File 
     * @Description: TODO(带分页的查询所有) 
     * @param @param pageBean
     * @param @param tf
     * @param @return    设定文件 
     * @return List<Technical_File>    返回类型 
     * @throws
      */
	public List<Technical_File> queryAllTechnical_File(PageBean pageBean, Technical_File tf) {
		//1.编写sql
		StringBuffer sql=new StringBuffer("select * from carsystem.technical_file "
				+ "where 1=1 ");
		if(tf!=null) {
			if(StringUtil.isNotEmpty(tf.getCar_tec_cno())) {
			sql.append("and car_tec_cno like '%" + tf.getCar_tec_cno() + "%'");
			}
		}
		if(pageBean!=null) {
			sql.append(" limit " + pageBean.getStart() + "," + pageBean.getRows());
		}
		// 2.打印sql
		System.out.println("查询所有车辆技术档案sql-->" + sql.toString());
		// 3.生成存放驾驶员档案的集合 List<Technical_File>
		List<Technical_File> list=null;
		try {
			list = qr.query(sql.toString(), new BeanListHandler<Technical_File>(Technical_File.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("车辆技术档案--查询失败！！");
		} finally {
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败！！");
			}
		}
		return list;
	}
     /**
      * 
     * @Title: Technical_FileCount 
     * @Description: TODO(查询多条记录) 
     * @param @param tf
     * @param @return    设定文件 
     * @return int    返回类型 
     * @throws
      */
	public int Technical_FileCount(Technical_File tf) {
		      // 1.编写sql
				StringBuffer sb = new StringBuffer("select count(*) from technical_file where 1=1 ");
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
    * @Title: Technical_FileDelete 
    * @Description: TODO(删除多条记录) 
    * @param @param delIds
    * @param @return    设定文件 
    * @return int    返回类型 
    * @throws
     */
	public int Technical_FileDelete(String delIds) {
		System.out.println(delIds);
		String sql = "delete from  technical_file where car_tec_cno in ('" + delIds + "')";
		 System.out.println("sql--->"+sql);
		try {
			return qr.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
    /**
     * 
    * @Title: findBycarId 
    * @Description: TODO(根据车牌号查找) 
    * @param @param car_id
    * @param @return    设定文件 
    * @return boolean    返回类型 
    * @throws
     */
	public boolean findBycarId(String car_id) {
		// 1.编写sql
		String sql = "select * from carsystem.technical_file where car_tec_cno = '"+car_id+"'";
		// 2.打印sql
		System.out.println("------查找车辆技术档案sql---->" + sql);
	

		Technical_File tf1 = null;
		try {
			tf1 = qr.query(sql, new BeanHandler<Technical_File>(Technical_File.class));
            if(tf1!=null) {
            	return true;
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("-----查找失败！！-----");
		} finally {
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败！");
			}
		}
		return false;
		
	}
	
}
