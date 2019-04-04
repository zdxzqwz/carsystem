package com.it.global;

import java.util.List;

import com.it.bean.PageBean;
import com.it.bean.Repair_Car;

/**
 * 
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: IRepair_Car.java
* @Description: 车辆维修功能 接口
*
* @version: v1.0.0
* @author: Only soul
* @date: 2019年3月18日 下午9:44:36 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年3月18日     Only soul           v1.0.0               修改原因
 */
public interface IRepair_Car {
	//增
	boolean addRepairCar(Repair_Car repaircar);
	//删
	boolean delRepairCar(Repair_Car repaircar);
	//改
	boolean updRepairCar(Repair_Car repaircar);
	//查
	List<Repair_Car> queryAllRepairCar(PageBean pageBean,Repair_Car repaircar,String datemin,String datemax);
	//查询单个
	Repair_Car findByIdRepairCar(Repair_Car repaircar);
	//删除多条记录
	int repairCarDelete(String delIds);
	//查询记录数
	int repairCarCount(Repair_Car repaircar,String datemin,String datemax);
	//取车的方法
	boolean quche(Repair_Car repaircar);
	//按照车牌号查询
	boolean findBycarId(String car_id);
}
