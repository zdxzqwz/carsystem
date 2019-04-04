package com.it.services;

import java.util.List;

import com.it.bean.PageBean;
import com.it.bean.Repair_Car;
import com.it.dao.RepairCarDAO;
import com.it.global.IRepair_Car;
/**
 * 
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: RepairCarServices.java
* @Description: 车辆修理的服务层
*
* @version: v1.0.0
* @author: Only soul
* @date: 2019年3月18日 下午10:06:32 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年3月18日     Only soul           v1.0.0               修改原因
 */
public class RepairCarServices implements IRepair_Car {
	RepairCarDAO dao = new RepairCarDAO();
	@Override
	public boolean addRepairCar(Repair_Car repaircar) {
		return dao.addRepairCar(repaircar);
	}

	@Override
	public boolean delRepairCar(Repair_Car repaircar) {
		return dao.delRepairCar(repaircar);
	}

	@Override
	public boolean updRepairCar(Repair_Car repaircar) {
		return dao.updRepairCar(repaircar);
	}

	@Override
	public List<Repair_Car> queryAllRepairCar(PageBean pageBean,Repair_Car repaircar,String datemin,String datemax) {
		return dao.queryAllRepairCar(pageBean,repaircar,datemin,datemax);
	}

	@Override
	public Repair_Car findByIdRepairCar(Repair_Car repaircar) {
		return dao.findByIdRepairCar(repaircar);
	}

	@Override
	public int repairCarDelete(String delIds) {
		return dao.repairCarDelete(delIds);
	}

	@Override
	public int repairCarCount(Repair_Car repaircar,String datemin,String datemax) {
		return dao.repairCarCount(repaircar,datemin,datemax);
	}

	@Override
	public boolean quche(Repair_Car repaircar) {
		// TODO Auto-generated method stub
		return dao.quche(repaircar);
	}

	@Override
	public boolean findBycarId(String car_id) {
		// TODO Auto-generated method stub
		return dao.findBycarId(car_id);
	}

}
