package com.it.services;

import java.util.List;

import com.it.bean.DriverInfo;
import com.it.bean.PageBean;
import com.it.dao.DriverInfoDao;
import com.it.global.IDriverInfo;
/**
 * 
* @ClassName: IDriverInfoImpl 
* @Description: TODO(驾驶员档案接口的功能实现类) 
* @author lijing
* @date 2019年3月13日 下午7:41:17 
*
 */
public class DriverInfoImpl implements IDriverInfo {

	DriverInfoDao drid=new DriverInfoDao();
	
	@Override
	public boolean addDriver(DriverInfo driver) {
		// TODO Auto-generated method stub
		return drid.addDriver(driver);
	}

	@Override
	public boolean delDriver(DriverInfo driver) {
		// TODO Auto-generated method stub
		return drid.delDriver(driver);
	}

	@Override
	public boolean updDriver(DriverInfo driver) {
		// TODO Auto-generated method stub
		return drid.updDriver(driver);
	}

	@Override
	public DriverInfo findByIdDriver(DriverInfo driver) {
		// TODO Auto-generated method stub
		return drid.findByIdDriver(driver);
	}

	@Override
	public List<DriverInfo> queryAllDriver(PageBean pageBean, DriverInfo driver) {
		// TODO Auto-generated method stub
		return drid.queryAllDriver(pageBean,driver);
	}

	@Override
	public List<DriverInfo> queryAllDriver(DriverInfo driver) {
		// TODO Auto-generated method stub
		return drid.queryAllDriver(driver);
	}

	@Override
	public int DriverCount(DriverInfo driver) {
		// TODO Auto-generated method stub
		return drid.DriverCount(driver);
	}

	@Override
	public int DriverDelete(String delIds) {
		// TODO Auto-generated method stub
		return drid.DriverDelete(delIds);
	}

}
