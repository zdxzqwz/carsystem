package com.it.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.it.bean.Vehiclemodel;
import com.it.bean.Vehicletype;
import com.it.utils.JDBCUtils;
import com.it.utils.StringUtil;
/**
 * 
* @ClassName: VehiclemodelDao 
* @Description: TODO(车辆型号dao) 
* @author lijing
* @date 2019年3月14日 上午10:23:46 
*
 */
public class VehiclemodelDao {

	/**
	 * 获取连接池
	 */
	QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
    /**
     * 
    * @Title: addVehiclemodel 
    * @Description: TODO(添加一条车辆型号档案记录) 
    * @param @param vehm    设定文件 
    * @return void    返回类型 
    * @throws
     */
	public void addVehiclemodel(Vehiclemodel vehm) {
		//1.编写sql
		String sql="INSERT INTO vehiclemodel (vehm_id,veh_id,vehm_name)VALUES (?,?,?)";
		//2.打印sql
		System.out.println("添加车辆型号sql----->"+sql);
		//3.处理参数
		Object[] param= {vehm.getVehm_id(),vehm.getVeh_id(),vehm.getVehm_name()};
		//定位标志位
		try {
			int row=qr.update(sql, param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("车辆型号添加失败!!");
		}finally {
			try {
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
    * @Title: updVehiclemodel 
    * @Description: TODO(修改车辆型号记录) 
    * @param @param vehm    设定文件 
    * @return void    返回类型 
    * @throws
     */
	public void updVehiclemodel(Vehiclemodel vehm) {
		// 1.编写sql
		String sql = "UPDATE vehiclemodel SET veh_id = ?, vehm_name = ? WHERE vehm_id = ? ";
		// 2.打印sql
		System.out.println("修改车辆型号sql----->" + sql);
		// 3.处理参数
		Object[] param = { vehm.getVeh_id(), vehm.getVehm_name(), vehm.getVehm_id() };
		// 定位标志位
		try {
			int row = qr.update(sql, param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("车辆型号修改失败!!");
		} finally {
			try {
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
    * @Title: delVehiclemodel 
    * @Description: TODO(删除车辆型号记录) 
    * @param @param vehm    设定文件 
    * @return void    返回类型 
    * @throws
     */
	public void delVehiclemodel(Vehiclemodel vehm) {
		// 1.编写sql
		String sql = "DELETE FROM vehiclemodel WHERE vehm_id = ?";
		// 2.打印sql
		System.out.println("修改车辆型号sql----->" + sql);
		// 3.处理参数
		Object[] param = { vehm.getVeh_id() };
		// 定位标志位
		try {
			int row = qr.update(sql, param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("车辆型号修改失败!!");
		} finally {
			try {
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
    * @Description: TODO(查询所有车辆型号) 
    * @param @param vehm
    * @param @return    设定文件 
    * @return List<Vehiclemodel>    返回类型 
    * @throws
     */
	public List<Vehiclemodel> queryAll(Vehiclemodel vehm) {
		// 1.编写sql
		StringBuffer sql = new StringBuffer("select * from vehiclemodel where 1=1 ");
		if (vehm != null) {
			if (StringUtil.isNotEmpty(vehm.getVehm_id())) {
				sql.append(" and vehm_id like '%" + vehm.getVehm_id() + "%'");
			}
			if (StringUtil.isNotEmpty(vehm.getVehm_name())) {
				sql.append(" and vehm_name like '%" + vehm.getVehm_name() + "%'");
			}
		}
		// 2.打印sql
		System.out.println("查询车辆型号sql----->" + sql);
		// 3.存放分公司的集合 List<Vehiclemodel>
		List<Vehiclemodel> listf = null;
		try {
			listf = qr.query(sql.toString(), new BeanListHandler<Vehiclemodel>(Vehiclemodel.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查询失败!!");
		} finally {
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!!");
			}
		}

		return listf;
	}
    /**
     * 
    * @Title: findById 
    * @Description: TODO(查询一条车辆型号记录) 
    * @param @param vehm
    * @param @return    设定文件 
    * @return Vehiclemodel    返回类型 
    * @throws
     */
	public Vehiclemodel findById(Vehiclemodel vehm) {
		// 1.编写sql
		String sql = "select * from vehiclemodel where vehm_id=" + vehm.getVehm_id() + "";
		// 2.打印sql
		System.out.println("查询车辆型号sql----->" + sql);
		// 3.生成对象
		Vehiclemodel vehm1 = null;
		try {
			vehm1 = qr.query(sql, new BeanHandler<Vehiclemodel>(Vehiclemodel.class));
		} catch (SQLException e) {
			throw new RuntimeException("查询单个数据失败!");
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
		return vehm1;
	}
    /**
     * 
    * @Title: queryVehmByVehId 
    * @Description: TODO(通过车辆类型Id获取车辆型号) 
    * @param @param veh
    * @param @return    设定文件 
    * @return List<Vehiclemodel>    返回类型 
    * @throws
     */
	public List<Vehiclemodel> queryVehmByVehId(Vehicletype veh) {
		// 1.编写sql
		StringBuffer sql = new StringBuffer("select * from vehiclemodel where 1=1 ");
		if (veh != null) {
			if (StringUtil.isNotEmpty(veh.getVeh_id())) {
				sql.append(" and veh_id like '%" + veh.getVeh_id() + "%'");
			}

		}
		// 2.打印sql
		System.out.println("查询车辆型号sql----->" + sql);
		// 3.存放车辆型号的集合 List<Vehiclemodel>
		List<Vehiclemodel> listf = null;
		try {
			listf = qr.query(sql.toString(), new BeanListHandler<Vehiclemodel>(Vehiclemodel.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查询失败!!");
		} finally {
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!!");
			}
		}

		return listf;
	}
	
}
