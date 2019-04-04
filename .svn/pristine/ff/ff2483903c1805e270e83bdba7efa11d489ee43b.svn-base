 package com.it.global;

import java.util.List;

import com.it.bean.Users;

public interface IUsers {
	
	        //登录
			public Users login(Users users);
			//增加用户
			public boolean addUsers(Users users);
			//删除用户
			public boolean delUsers(Users users);
			//修改用户
			public boolean updUsers(Users users);
			//查询所有用户
			public List<Users> queryAllUsers(Users users);
			//查找单个用户
			public Users findUsersById(Users users);
			//删除多条记录
			public int userDelete(String delIds);
			//修改密码
			public boolean pwdUsers(Users users);
			
			//通过角色id查看该角色下有没有用户
			boolean existUserWithRoleId(String roleId);
			
}
