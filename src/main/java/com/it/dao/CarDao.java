package com.it.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.it.bean.Car;
import com.it.bean.CarInfo;
import com.it.bean.PageBean;
import com.it.utils.JDBCUtils;
import com.it.utils.StringUtil;

/**
 * 
 * @ClassName: CarDao
 * @Description: TODO(车辆档案dao层)
 * @author lijing
 * @date 2019年3月13日 下午2:15:07
 *
 */
public class CarDao {

	/**
	 * 获取连接池
	 */
	QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

	
	
	
	
	/**
	 * 
	 * @Title: addCar @Description: TODO(添加一条车辆档案记录) @param @param
	 * car @param @return 设定文件 @return boolean 返回类型 @throws
	 */
	public boolean addCar(Car car) {
		// 1.编写sql
		String sql = "INSERT INTO car(car_id,vehm_id,reg_id,veh_id,car_name,car_vehicles,fil_id,car_flag,car_time)"
				+ " VALUES (?,?,?,?,?,?,?,?,? )	 ";
		// 2.打印sql
		System.out.println("-----添加车辆档案sql---->" + sql);
		// 3.处理参数
		Object[] param = { car.getCar_id(), car.getVehm_id(), car.getReg_id(), car.getVeh_id(), car.getCar_name(),
				car.getCar_vehicles(), car.getFil_id(), car.getCar_flag(), car.getCar_time()};
		// 定义标志位
		try {
			int row = qr.update(sql, param);
			return row > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("添加车辆档案失败！！");
		} finally {
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
	 * @Title: delCar @Description: TODO(删除一条车辆档案记录) @param @param
	 * car @param @return 设定文件 @return boolean 返回类型 @throws
	 */
	public boolean delCar(Car car) {
		// 1.编写sql
		String sql = "DELETE  FROM car WHERE car_id = ? ";
		// 2.打印sql
		System.out.println("删除车辆档案sql--->" + sql);
		// 3.处理参数
		Object[] param = { car.getCar_id() };
		// 定位标志位
		try {
			int row = qr.update(sql, param);
			return row > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("------删除失败！！------");
		} finally {
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败！");
			}
		}

	}

	/**
	 * 
	 * @Title: updCar @Description: TODO(修改一条车辆档案记录) @param @param
	 * car @param @return 设定文件 @return boolean 返回类型 @throws
	 */
	public boolean updCar(Car car) {
		// 1.编写sql
		String sql = "UPDATE car "
				+ "SET  vehm_id = ? ,reg_id = ?,veh_id = ?, car_name = ? ,"
				+ "car_vehicles = ?, fil_id = ?,car_flag = ?, car_time = ?"
				+ " WHERE car_id = ? ";
		// 2.打印sql
		System.out.println("修改车辆档案sql---->"+sql);
		// 3.处理参数
		Object[] param = { car.getVehm_id(), car.getReg_id(), car.getVeh_id(), car.getCar_name(), car.getCar_vehicles(),
				car.getFil_id(), car.getCar_flag(), car.getCar_time(), car.getCar_id() };
		// 定义标志位
		try {
			int row = qr.update(sql, param);
			return row > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("----车辆档案修改失败!!-----");
		} finally {
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!!");
			}
		}
	}
    /**
     * 
    * @Title: findByIdCar 
    * @Description: TODO(车辆档案查找 findbyid) 
    * @param @param car
    * @param @return    设定文件 
    * @return Car    返回类型 
    * @throws
     */
	public Car findByIdCar(Car car) {
		//1.打印sql
		String sql="select * from car "
				+ "where car_id="+car.getCar_id()+"";
		//2.打印sql
		System.out.println("查找车辆档案sql----->"+sql);
		//3.生成对象
		Car car1=null;
		try {
			car1=qr.query(sql,new BeanHandler<Car>(Car.class));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("-----查找失败!!-----");
		}finally {
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败!!");
			}
		}	
		return car1;
	}

	/**
	 * 
	 * @Title: queryAllCar @Description: TODO(带分页的查询所有 车辆档案) @param @param
	 * pageBean @param @param car @param @return 设定文件 @return List<Car> 返回类型 @throws
	 */
	public List<Car> queryAllCar(PageBean pageBean, Car car) {
		// 1.编写sql
		StringBuffer sql = new StringBuffer("select * from car where 1=1 ");

		if (car != null) {
			// 判断输入合法性 不为空 null
			if (StringUtil.isNotEmpty(car.getCar_id())) {
				sql.append("and car_id like '%" + car.getCar_id() + "%' ");
			}
			if (StringUtil.isNotEmpty(car.getCar_flag())) {
				sql.append("and car_flag like '%" + car.getCar_flag() + "%' ");
			}
		}
		if (pageBean != null) {
			sql.append(" limit " + pageBean.getStart() + "," + pageBean.getRows());
		}
		// 打印sql
		System.out.println("查询所有车辆档案sql-->" + sql.toString());
		// 存放car档案的集合 List<Car>
		List<Car> listc = null;
		try {
			listc = qr.query(sql.toString(), new BeanListHandler<Car>(Car.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("车辆档案--查询失败！！");
		} finally {
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败！！");
			}
		}
		return listc;
	}
	/**
	 * 
	* @Title: queryAllCarInfo1 
	* @Description: TODO(查询所有空闲车辆  带分页) 
	* @param @param pageBean
	* @param @return    设定文件 
	* @return List<CarInfo>    返回类型 
	* @throws
	 */
	public List<CarInfo> queryAllCarInfo1(PageBean pageBean){
				// 1.编写sql
				StringBuffer sql = new StringBuffer("SELECT c.car_id,c.car_name,c.car_flag,c.car_vehicles,c.car_time,c.vehm_id,vm.vehm_name,c.veh_id,vt.veh_name,c.reg_id,r.reg_name,c.fil_id,f.fil_name \r\n" + 
						"FROM car AS c,region AS r,filiale AS f,vehiclemodel AS vm ,vehicletype AS vt \r\n" + 
						"WHERE c.reg_id=r.reg_id AND c.fil_id=f.fil_id AND c.veh_id=vt.veh_id AND c.vehm_id=vm.vehm_id  ");
				sql.append("and car_vehicles like '空闲' ");
			
				if (pageBean != null) {
					sql.append(" limit " + pageBean.getStart() + "," + pageBean.getRows());
				}
				// 打印sql
				System.out.println("查询所有车辆档案sql-->" + sql.toString());
				// 存放car档案的集合 List<Car>
				List<CarInfo> listc = null;
				try {
					listc = qr.query(sql.toString(), new BeanListHandler<CarInfo>(CarInfo.class));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException("车辆档案--查询失败！！");
				} finally {
					try {
						DbUtils.close(JDBCUtils.getConnections());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						throw new RuntimeException("关闭资源失败！！");
					}
				}
				return listc;
			
		}
	/**
	 * 
	* @Title: queryAllCarInfo 
	* @Description: TODO(多表查询) 
	* @param @param pageBean
	* @param @param carinfo
	* @param @return    设定文件 
	* @return List<CarInfo>    返回类型 
	* @throws
	 */
	public List<CarInfo> queryAllCarInfo(PageBean pageBean,CarInfo carinfo){
			// 1.编写sql
			StringBuffer sql = new StringBuffer("SELECT c.car_id,c.car_name,c.car_flag,c.car_vehicles,c.car_time,c.vehm_id,vm.vehm_name,c.veh_id,vt.veh_name,c.reg_id,r.reg_name,c.fil_id,f.fil_name \r\n" + 
					"FROM car AS c,region AS r,filiale AS f,vehiclemodel AS vm ,vehicletype AS vt \r\n" + 
					"WHERE c.reg_id=r.reg_id AND c.fil_id=f.fil_id AND c.veh_id=vt.veh_id AND c.vehm_id=vm.vehm_id ");
			System.out.println(carinfo);
			if (carinfo != null) {
				// 判断输入合法性 不为空 null
				if (StringUtil.isNotEmpty(carinfo.getCar_vehicles())) {
					sql.append("and car_vehicles like '%" + carinfo.getCar_vehicles() + "%' ");
				}
				if (StringUtil.isNotEmpty(carinfo.getCar_id())) {
					sql.append("and car_id like '%" + carinfo.getCar_id() + "%' ");
				}
				
			}
			if (pageBean != null) {
				sql.append(" limit " + pageBean.getStart() + "," + pageBean.getRows());
			}
			// 打印sql
			System.out.println("查询所有车辆档案sql-->" + sql.toString());
			// 存放car档案的集合 List<Car>
			List<CarInfo> listc = null;
			try {
				listc = qr.query(sql.toString(), new BeanListHandler<CarInfo>(CarInfo.class));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("车辆档案--查询失败！！");
			} finally {
				try {
					DbUtils.close(JDBCUtils.getConnections());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException("关闭资源失败！！");
				}
			}
			return listc;
		
	}
	
    /**
     * 
    * @Title: CarCount 
    * @Description: TODO(查询记录总数) 
    * @param @param car
    * @param @return    设定文件 
    * @return int    返回类型 
    * @throws
     */
	public int CarCount(Car car) {
		//1.编写sql
		StringBuffer sb = new StringBuffer("select count(*) from car where 1=1 ");
		//有条件判断条件，重新拼接sql
		
		 Number num;
		try {
			num = (Number)qr.query(sb.toString(),new ScalarHandler<>());
		
			return num.intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查询数据失败!");
		}finally {
			//释放资源到数据库连接池
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
    * @Title: CarDelete 
    * @Description: TODO(删除多条记录) 
    * @param @param delIds
    * @param @return    设定文件 
    * @return int    返回类型 
    * @throws
     */
	public int CarDelete(String delIds) {
		System.out.println(delIds);
		String sql = "delete from  car where car_id in ('" + delIds + "')";
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
	* @Title: queryAllCar 
	* @Description: TODO(不含分页功能的 查询所有车辆档案功能) 
	* @param @param car
	* @param @return    设定文件 
	* @return List<Car>    返回类型 
	* @throws
	 */
	public List<Car> queryAllCar(Car car) {
		// 1.编写sql
		StringBuffer sql = new StringBuffer("select * from car where 1=1 ");

		if (car != null) {
			// 判断输入合法性 不为空 null
			if (StringUtil.isNotEmpty(car.getCar_id())) {
				sql.append("and car_id like '%" + car.getCar_id() + "%' ");
			}
			if (StringUtil.isNotEmpty(car.getCar_flag())) {
				sql.append("and car_flag like '%" + car.getCar_flag() + "%' ");
			}
		}
		// 打印sql
		System.out.println("sql-->" + sql.toString());
		// 存放car档案的集合 List<Car>
		List<Car> listc = null;
		try {
			listc = qr.query(sql.toString(), new BeanListHandler<Car>(Car.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("车辆档案--查询失败！！");
		} finally {
			try {
				DbUtils.close(JDBCUtils.getConnections());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("关闭资源失败！！");
			}
		}
		return listc;
	}
	/**
	 * 
	* @Description: 车辆运行调用的修改车辆状态
	* @version: v1.0.0
	* @author: Only soul
	* @date: 2019年3月25日 下午5:25:32
	 */
	public boolean updVehicles(String rep_car_id, String vehicles) {
		// 1.编写sql
				String sql = "UPDATE `carsystem`.`car` SET`car_vehicles` = '"+vehicles+"'  WHERE `car_id` = '"+rep_car_id+"';";
				// 2.打印sql
				System.out.println("修改车辆档案sql---->"+sql);
				
				// 定义标志位
				try {
					int row = qr.update(sql);
					return row > 0;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException("----车辆档案修改失败!!-----");
				} finally {
					try {
						DbUtils.close(JDBCUtils.getConnections());
					} catch (SQLException e) {
						
						e.printStackTrace();
						throw new RuntimeException("关闭资源失败!!");
					}
				}
	}

}
