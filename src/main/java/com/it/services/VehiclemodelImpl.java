package com.it.services;

import java.util.List;

import com.it.bean.Vehiclemodel;
import com.it.bean.Vehicletype;
import com.it.dao.VehiclemodelDao;
import com.it.global.IVehiclemodel;
/**
 * 
* @ClassName: IVehiclemodelImpl 
* @Description: TODO(车辆型号接口功能的实现类) 
* @author lijing
* @date 2019年3月14日 上午10:28:02 
*
 */
public class VehiclemodelImpl implements IVehiclemodel {

	VehiclemodelDao vehmd=new VehiclemodelDao() ;
	@Override
	public void addVehiclemodel(Vehiclemodel vehm) {
		vehmd.addVehiclemodel(vehm);
	}

	@Override
	public void updVehiclemodel(Vehiclemodel vehm) {
		vehmd.updVehiclemodel(vehm);
	}

	@Override
	public void delVehiclemodel(Vehiclemodel vehm) {
		vehmd.delVehiclemodel(vehm);
	}

	@Override
	public List<Vehiclemodel> queryAll(Vehiclemodel vehm) {
		// TODO Auto-generated method stub
		return vehmd.queryAll(vehm);
	}

	@Override
	public Vehiclemodel findById(Vehiclemodel vehm) {
		// TODO Auto-generated method stub
		return vehmd.findById(vehm);
	}

	@Override
	public List<Vehiclemodel> queryVehmByVehId(Vehicletype veh) {
		// TODO Auto-generated method stub
		return vehmd.queryVehmByVehId(veh);
	}

}
