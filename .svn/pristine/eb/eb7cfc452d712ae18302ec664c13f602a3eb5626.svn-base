package com.it.services;

import java.util.List;

import com.it.bean.PageBean;
import com.it.bean.Technical_File;
import com.it.dao.Technical_FileDao;
import com.it.global.ITechnical_File;
/**
 * 
* @ClassName: Technical_FileImpl 
* @Description: TODO(车辆技术档案接口功能的实现类) 
* @author lijing
* @date 2019年3月12日 下午9:31:09 
*
 */
public class Technical_FileImpl implements ITechnical_File {

	Technical_FileDao tfd=new Technical_FileDao();
	@Override
	public boolean addTechFile(Technical_File tf) {
		// TODO Auto-generated method stub
		return tfd.addTechFile(tf);
	}

	@Override
	public boolean delTechFile(Technical_File tf) {
		// TODO Auto-generated method stub
		return tfd.delTechFile(tf);
	}

	@Override
	public boolean updTechFile(Technical_File tf) {
		// TODO Auto-generated method stub
		return tfd.updTechFile(tf);
	}

	@Override
	public Technical_File findByIdTechFile(Technical_File tf) {
		// TODO Auto-generated method stub
		return tfd.findByIdTechFile(tf);
	}

	@Override
	public List<Technical_File> queryAllTechnical_File(PageBean pageBean, Technical_File tf) {
		// TODO Auto-generated method stub
		return tfd.queryAllTechnical_File(pageBean,tf);
	}

	@Override
	public List<Technical_File> queryAllTechnical_File(Technical_File tf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int Technical_FileCount(Technical_File tf) {
		// TODO Auto-generated method stub
		return tfd.Technical_FileCount(tf);
	}

	@Override
	public int Technical_FileDelete(String delIds) {
		// TODO Auto-generated method stub
		return tfd.Technical_FileDelete(delIds);
	}

	@Override
	public boolean findBycarId(String car_id) {
		// TODO Auto-generated method stub
		return tfd.findBycarId(car_id);
	}

}
