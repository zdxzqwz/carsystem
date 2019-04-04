package com.it.global;

import java.util.List;

import com.it.bean.Vehiclemodel;
import com.it.bean.Vehicletype;


/**
 * 
* @ClassName: IVehiclemodel 
* @Description: TODO(定义了车辆型号表的功能接口) 
* @author lijing
* @date 2019年3月14日 上午10:16:46 
*
 */
public interface IVehiclemodel {

		//添加车辆型号
		public void addVehiclemodel(Vehiclemodel vehm);
		//修改车辆型号
		public void updVehiclemodel(Vehiclemodel vehm);
		//删除车辆型号
		public void delVehiclemodel(Vehiclemodel vehm);
		//查询所有车辆型号
		public List<Vehiclemodel> queryAll(Vehiclemodel vehm);
		//查询车辆型号
		public Vehiclemodel findById(Vehiclemodel vehm);
		//通过大区查找车辆型号
		public List<Vehiclemodel> queryVehmByVehId(Vehicletype veh);
}
