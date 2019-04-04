package com.it.services;

import java.util.List;

import com.it.bean.PageBean;
import com.it.bean.Return_Car;
import com.it.dao.Return_CarDAO;
import com.it.global.IReturn_Car;
/**
 * 
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: ReturnCarServices.java
* @Description: 还车表的服务层
*
* @version: v1.0.0
* @author: Only soul
* @date: 2019年3月15日 上午9:26:09 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年3月15日     Only soul           v1.0.0               修改原因
 */
public class ReturnCarServices implements IReturn_Car {
	Return_CarDAO dao = new Return_CarDAO();
	
	@Override
	public List<Return_Car> queryAllReturnCar(PageBean pageBean, Return_Car returncar,String datemin,String datemax) {		
		return dao.queryAllReturnCar(pageBean, returncar,datemin,datemax);
	}

	@Override
	public boolean addReturnCar(Return_Car returncar) {		
		return dao.addReturnCar(returncar);
	}

	@Override
	public boolean delReturnCar(Return_Car returncar) {		
		return dao.delReturnCar(returncar);
	}

	@Override
	public boolean updReturnCar(Return_Car returncar) {	
		return dao.updReturnCar(returncar);
	}

	@Override
	public Return_Car findById(Return_Car returncar) {		
		return dao.findById(returncar);
	}

	@Override
	public int returnCarCount(Return_Car returncar) {
		return dao.returnCarCount(returncar);
	}

	@Override
	public int returnCarDelete(String delIds) {
		return dao.returnCarDelete(delIds);
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
