package com.it.global;

import java.util.List;
import com.it.bean.Car;
import com.it.bean.CarInfo;
import com.it.bean.PageBean;

/**
 * 
 * @ClassName: ICar
 * @Description: TODO(定义了车辆档案的功能接口)
 * @author lijing
 * @date 2019年3月13日 上午11:03:11
 *
 */
public interface ICar {

	// 添加出车记录
	boolean addCar(Car car);

	// 删除出车记录
	boolean delCar(Car car);

	// 修改出车记录
	boolean updCar(Car car);

	// 查询单个
	Car findByIdCar(Car car);

	// 查询所有 分页和模糊查询
	List<Car> queryAllCar(PageBean pageBean, Car car);
	List<Car> queryAllCar( Car car);

	// 查询总记录数
	int CarCount(Car car);

	// 删除多条记录
	int CarDelete(String delIds);

    //多表查询所有
	List<CarInfo> queryAllCarInfo(PageBean pageBean, CarInfo cari);	
	//查询所有空闲车辆  带分页
	 List<CarInfo> queryAllCarInfo1(PageBean pageBean);
	 //修改车辆状态
	 boolean updVehicles(String rep_car_id,String vehicles);

}
