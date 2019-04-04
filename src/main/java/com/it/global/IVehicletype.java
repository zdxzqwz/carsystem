package com.it.global;

import java.util.List;

import com.it.bean.Vehicletype;

/**
 * 
* @ClassName: IVehicletype 
* @Description: TODO(定义车辆类型表功能的接口) 
* @author lijing
* @date 2019年3月14日 上午10:14:06 
*
 */
public interface IVehicletype {
	 	//添加车辆类型
		public void addVehicletype(Vehicletype veh);
		//修改车辆类型
		public void updVehicletype(Vehicletype veh);
		//删除车辆类型
		public void delVehicletype(Vehicletype veh);
		//查询所有车辆类型
		public List<Vehicletype> queryAll(Vehicletype veh);
		//查询车辆类型
		public Vehicletype findById(Vehicletype veh);

}
