package com.it.global;

import java.util.List;

import com.it.bean.User_Check;

public interface ICheck {
    //添加考核记录
	 boolean addCheck(User_Check ck);
	 //删除考核记录
	 boolean delCheck(User_Check ck);
	 //修改考核记录
	 boolean updCheck(User_Check ck);
	 //模糊查询，查询所有
	List<User_Check> queryAll(User_Check ck);
	 //查询单个
	User_Check findById(User_Check ck);
	 //批量删除
	 int User_CheckDelete(String delIds);
}
