package com.it.services;

import java.util.List;

import com.it.bean.Vehicletype;
import com.it.dao.VehicletypeDao;
import com.it.global.IVehicletype;
/**
 * 
* @ClassName: IVehicletypeImpl 
* @Description: TODO(车辆型号接口功能的实现类) 
* @author lijing
* @date 2019年3月14日 上午10:27:57 
*
 */
public class VehicletypeImpl implements IVehicletype {

	VehicletypeDao vehd=new VehicletypeDao();
	@Override
	public void addVehicletype(Vehicletype veh) {
		vehd.addVehicletype(veh);
	}

	@Override
	public void updVehicletype(Vehicletype veh) {
		vehd.updVehicletype(veh);
	}

	@Override
	public void delVehicletype(Vehicletype veh) {
		vehd.delVehicletype(veh);
	}

	@Override
	public List<Vehicletype> queryAll(Vehicletype veh) {
		// TODO Auto-generated method stub
		return 	vehd.queryAll(veh);
	}

	@Override
	public Vehicletype findById(Vehicletype veh) {
		// TODO Auto-generated method stub
		return 	vehd.findById(veh);
	}

}
