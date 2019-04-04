package com.it.services;

import java.util.List;

import com.it.bean.Users;
import com.it.dao.UsersDAO;
import com.it.global.IUsers;

public class UsersImpl implements IUsers{
      UsersDAO usersDAO = new UsersDAO();
	
	public Users login(Users users) {
		// TODO Auto-generated method stub
		return usersDAO.login(users);
	}
	@Override
	public boolean addUsers(Users users) {
		// TODO Auto-generated method stub
		return usersDAO.addUsers(users);
	}
	@Override
	public boolean delUsers(Users users) {
		// TODO Auto-generated method stub
		return usersDAO.delUsers(users);
	}
	@Override
	public boolean updUsers(Users users) {
		// TODO Auto-generated method stub
		return usersDAO.updUsers(users);
	}
	@Override
	public List<Users> queryAllUsers(Users users) {
		// TODO Auto-generated method stub
		return usersDAO.queryAllUsers(users);
	}
	@Override
	public Users findUsersById(Users users) {
		// TODO Auto-generated method stub
		return usersDAO.findUsersById(users);
	}
	@Override
	public int userDelete(String delIds) {
		// TODO Auto-generated method stub
		return usersDAO.userDelete(delIds);
	}
	@Override
	public boolean pwdUsers(Users users) {
		// TODO Auto-generated method stub
		return usersDAO.pwdUsers(users);
	}
	@Override
	public boolean existUserWithRoleId(String roleId) {
		// TODO Auto-generated method stub
		return usersDAO.existUserWithRoleId(roleId);
	}

}
