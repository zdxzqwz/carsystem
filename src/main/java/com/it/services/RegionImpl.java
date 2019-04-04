package com.it.services;

import java.util.List;

import com.it.bean.Region;
import com.it.dao.RegionDao;
import com.it.global.IRegion;
/**
 * 
* @ClassName: IRegionImpl 
* @Description: TODO(所属大区功能接口的实现类) 
* @author lijing
* @date 2019年3月13日 下午10:25:36 
*
 */
public class RegionImpl implements IRegion {

	RegionDao regd=new RegionDao();
	@Override
	public void addRegion(Region reg) {
         regd.addRegion(reg);
	}

	@Override
	public void updRegion(Region reg) {
		 regd.updRegion(reg);
	}

	@Override
	public void delRegion(Region reg) {
		 regd.delRegion(reg);
	}

	@Override
	public List<Region> queryAll(Region reg) {
		
		return regd.queryAll(reg);
	}

	@Override
	public Region findById(Region reg) {
		// TODO Auto-generated method stub
		return  regd.findById(reg);
	}

}
