package com.it.services;

import java.util.List;

import com.it.bean.Filiale;
import com.it.bean.Region;
import com.it.dao.FilialeDao;
import com.it.global.IFiliale;
/**
 * 
* @ClassName: IFilialeImpl 
* @Description: TODO(分公司表功能接口实现类) 
* @author lijing
* @date 2019年3月13日 下午10:54:26 
*
 */
public class FilialeImpl implements IFiliale {

	FilialeDao fild =new FilialeDao();
	@Override
	public void addFiliale(Filiale fil) {
		fild.addFiliale(fil);
	}

	@Override
	public void updFiliale(Filiale fil) {
		fild.updFiliale(fil);
	}

	@Override
	public void delFiliale(Filiale fil) {
		fild.delFiliale(fil);
	}

	@Override
	public List<Filiale> queryAll(Filiale fil) {
		// TODO Auto-generated method stub
		return fild.queryAll(fil);
	}

	@Override
	public Filiale findById(Filiale fil) {
		// TODO Auto-generated method stub
		return fild.findById(fil);
	}

	@Override
	public List<Filiale> queryFilialesByRegionId(Region reg) {
		// TODO Auto-generated method stub
		return fild.queryFilialesByRegionId(reg);
	}

}
