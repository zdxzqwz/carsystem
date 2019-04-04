package com.it.services;

import java.util.List;

import com.it.bean.Car;
import com.it.bean.CarInfo;
import com.it.bean.PageBean;
import com.it.dao.CarDao;
import com.it.global.ICar;
/**
 * 
* @ClassName: CarImpl 
* @Description: TODO(车辆档案功能的实现类) 
* @author lijing
* @date 2019年3月13日 上午11:08:25 
*
 */
public class CarImpl implements ICar {

	CarDao cardao=new CarDao();
	@Override
	public boolean addCar(Car car) {
		// TODO Auto-generated method stub
		return cardao.addCar(car);
	}

	@Override
	public boolean delCar(Car car) {
		// TODO Auto-generated method stub
		return cardao.delCar(car);
	}

	@Override
	public boolean updCar(Car car) {
		// TODO Auto-generated method stub
		return cardao.updCar(car);
	}

	@Override
	public Car findByIdCar(Car car) {
		// TODO Auto-generated method stub
		return cardao.findByIdCar(car);
	}

	@Override
	public List<Car> queryAllCar(PageBean pageBean, Car car) {
		// TODO Auto-generated method stub
		return cardao.queryAllCar(pageBean,car);
	}

	@Override
	public int CarCount(Car car) {
		// TODO Auto-generated method stub
		return cardao.CarCount(car);
		
	}

	@Override
	public int CarDelete(String delIds) {
		// TODO Auto-generated method stub
		return cardao.CarDelete(delIds);
	}

	@Override
	public List<Car> queryAllCar(Car car) {
		// TODO Auto-generated method stub
		return cardao.queryAllCar(car);
	}

	@Override
	public List<CarInfo> queryAllCarInfo(PageBean pageBean, CarInfo cari) {
		// TODO Auto-generated method stub
		return cardao.queryAllCarInfo(pageBean, cari);
	}

	@Override
	public List<CarInfo> queryAllCarInfo1(PageBean pageBean) {
		// TODO Auto-generated method stub
		return cardao.queryAllCarInfo1(pageBean);
	}

	@Override
	public boolean updVehicles(String rep_car_id, String vehicles) {
		// TODO Auto-generated method stub
		return cardao.updVehicles(rep_car_id, vehicles);
	}

}
