package com.it.services;

import java.util.List;

import com.it.bean.User_Check;
import com.it.dao.CheckDao;
import com.it.global.ICheck;

public class CheckImpl implements ICheck {
     CheckDao dao=new CheckDao();
     //添加
	@Override
	public boolean addCheck(User_Check ck) {
		// TODO Auto-generated method stub
		return dao.addCheck(ck);
	}
//删除
	@Override
	public boolean delCheck(User_Check ck) {
		// TODO Auto-generated method stub
		return dao.delCheck(ck);
	}
//修改
	@Override
	public boolean updCheck(User_Check ck) {
		// TODO Auto-generated method stub
		return dao.updCheck(ck);
	}

	@Override
	//查询所有，模糊查询
	public List<User_Check> queryAll(User_Check ck) {
		// TODO Auto-generated method stub
		return dao.queryAll(ck);
	}
//查询单个
	@Override
	public User_Check findById(User_Check ck) {
		// TODO Auto-generated method stub
		return dao.findById(ck);
	}

	@Override
	public int User_CheckDelete(String delIds) {
		// TODO Auto-generated method stub
		return 0;
	}

}
