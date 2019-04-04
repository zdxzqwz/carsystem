package com.it.dao;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import com.it.bean.Vehicletype;
import com.it.utils.JDBCUtils;
import com.it.utils.StringUtil;
/**
 * 
* @ClassName: VehicletypeDao 
* @Description: TODO(车辆类型dao) 
* @author lijing
* @date 2019年3月14日 上午10:24:23 
*
 */
public class VehicletypeDao {

	/**
	 * 获取连接池
	 */
	QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

	/**
	 * 
	* @Title: addVehicletype 
	* @Description: TODO(添加一条车辆类型记录) 
	* @param @param veh    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void addVehicletype(Vehicletype veh) {
		// 1.编写sql
		String sql = "INSERT INTO vehicletype(veh_id, vel_name) VALUES ( ?,? )";
		// 2.打印sql
		System.out.println("添加车辆类型sql----->" + sql);
		// 3.处理参数
		Object[] param = { veh.getVeh_id(), veh.getVeh_name() };
		// 定位标志位
		try {
			int row = qr.update(sql, param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("车辆类型添加失败!!");
		} finally {
			try {
				// 释放资源到数据库连接池
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!!");
			}
		}
	}
 
	/**
	 * 
	* @Title: updVehicletype 
	* @Description: TODO(修改车辆类型) 
	* @param @param veh    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void updVehicletype(Vehicletype veh) {
		        // 1.编写sql
				String sql = "UPDATE vehicletype SET vel_name = ? WHERE veh_id = ? ;";
				// 2.打印sql
				System.out.println("修改车辆类型sql----->" + sql);
				// 3.处理参数
				Object[] param = { veh.getVeh_id(), veh.getVeh_name() };
				// 定位标志位
				try {
					int row = qr.update(sql, param);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException("车辆类型修改失败!!");
				} finally {
					try {
						// 释放资源到数据库连接池
						DbUtils.close(JDBCUtils.getConnections());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						throw new RuntimeException("关闭资源失败!!");
					}
				}
	}

	/**
	 * 
	* @Title: delVehicletype 
	* @Description: TODO(删除车辆类型) 
	* @param @param veh    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void delVehicletype(Vehicletype veh) {
		// 1.编写sql
		String sql = "DELETE  FROM vehicletype  WHERE  veh_id  = ? ";

		// 2.打印sql
		System.out.println("删除车辆类型sql----->" + sql);
		// 3.处理参数
		Object[] param = { veh.getVeh_id() };
		// 定位标志位
		try {
			int row = qr.update(sql, param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("车辆类型删除失败!!");
		} finally {
			try {
				// 释放资源到数据库连接池
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!!");
			}
		}
	}

	/**
	 * 
	* @Title: queryAll 
	* @Description: TODO(查询所有车辆类型) 
	* @param @param veh
	* @param @return    设定文件 
	* @return List<Vehicletype>    返回类型 
	* @throws
	 */
	public List<Vehicletype> queryAll(Vehicletype veh) {
		//1.编写sql
		StringBuffer sql=new StringBuffer("select * from vehicletype where 1=1 ");
		if(veh!=null) {
			if(StringUtil.isNotEmpty(veh.getVeh_id())) {
				sql.append(" and veh_id like '%"+veh.getVeh_id()+"%'");
			}
			if(StringUtil.isNotEmpty(veh.getVeh_name())) {
				sql.append(" and veh_name like '%"+veh.getVeh_name()+"%'");
			}
		}
		//2.打印sql
		System.out.println("查询所有车辆类型sql----->"+sql.toString());
		//3.存放查询车辆类型的集合 List
		List<Vehicletype> list=null;
		try {
			list=qr.query(sql.toString(), new BeanListHandler<Vehicletype>(Vehicletype.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("车辆类型查询失败!!");
		} finally {
			try {
				// 释放资源到数据库连接池
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!!");
			}
		}
		
		return list;
	}

	/**
	 * 
	* @Title: findById 
	* @Description: TODO(查询车辆类型单个数据) 
	* @param @param veh
	* @param @return    设定文件 
	* @return Vehicletype    返回类型 
	* @throws
	 */
	public Vehicletype findById(Vehicletype veh) {
		// 1.编写sql
		String sql = "select * from vehicletype where veh_id=" + veh.getVeh_id() + "";
		// 2.打印sql
		System.out.println("查询车辆类型sql----->" + sql);
		// 3.生成对象
		Vehicletype veh1 = null;
		try {
			veh1 = qr.query(sql, new BeanHandler<Vehicletype>(Vehicletype.class));
		} catch (SQLException e) {
			throw new RuntimeException("查询车辆类型单个数据失败!");
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
		return veh1;
	}
	
}
