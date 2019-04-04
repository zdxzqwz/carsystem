package com.it.services;

import java.util.List;

import com.it.bean.Out_Car;
import com.it.bean.PageBean;
import com.it.dao.Out_CarDAO;
import com.it.global.IOut_CarServices;
/**
 * 
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: Out_CarServices.java
* @Description: 出车表的接口实现类
*
* @version: v1.0.0
* @author: Only soul
* @date: 2019年3月12日 上午11:19:07 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年3月12日     Only soul           v1.0.0               修改原因
 */
public class Out_CarServices implements IOut_CarServices {
	Out_CarDAO dao = new Out_CarDAO();
	@Override
	public boolean addOutCar(Out_Car out_car) {
		// TODO Auto-generated method stub
		return dao.addOutCar(out_car);
	}

	@Override
	public boolean delOutCar(Out_Car out_car) {
		// TODO Auto-generated method stub
		return dao.delOutCar(out_car);
	}

	@Override
	public boolean updOutCar(Out_Car out_car) {
		// TODO Auto-generated method stub
		return dao.updOutCar(out_car);
	}

	@Override
	public Out_Car findByIdOutCar(Out_Car out_car) {
		// TODO Auto-generated method stub
		return dao.findByIdOutCar(out_car);
	}

	@Override
	public List<Out_Car> queryAllOutCar(PageBean pageBean, Out_Car out_car) {
		// TODO Auto-generated method stub
		return dao.queryAllOutCar(pageBean, out_car);
	}

	@Override
	public int outCarCount(Out_Car out_car) {
		// TODO Auto-generated method stub
		return dao.outCarCount(out_car);
	}

	@Override
	public int outCarDelete(String delIds) {
		// TODO Auto-generated method stub
		return dao.outCarDelete(delIds);
	}

	@Override
	public boolean findByDriId(String dri_id) {
		// TODO Auto-generated method stub
		return dao.findByDriId(dri_id);
	}

	@Override
	public boolean findBycarId(String car_id) {
		// TODO Auto-generated method stub
		return dao.findBycarId(car_id);
	}

}
