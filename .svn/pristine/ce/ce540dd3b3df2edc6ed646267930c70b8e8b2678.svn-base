package com.it.services;

import com.it.bean.Role;
import com.it.bean.Role_Auth;
import com.it.dao.Role_AuthDAO;
import com.it.global.IRole_Auth;
/**
 * 
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: Role_AuthServices.java
* @Description: 角色权限映射表
*
* @version: v1.0.0
* @author: Only soul
* @date: 2019年3月22日 下午4:37:17 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年3月22日     Only soul           v1.0.0               修改原因
 */
public class Role_AuthServices implements IRole_Auth {
	Role_AuthDAO dao = new Role_AuthDAO();
	@Override
	public boolean addRoleAuth(Role_Auth roleauth) {
		// TODO Auto-generated method stub
		return dao.addRoleAuth(roleauth);
	}

	@Override
	public boolean delRoleAuth(Role_Auth roleauth) {
		// TODO Auto-generated method stub
		return dao.delRoleAuth(roleauth);
	}

	@Override
	public boolean updRoleAuth(Role_Auth roleauth) {
		// TODO Auto-generated method stub
		return dao.updRoleAuth(roleauth);
	}

	@Override
	public String queryAll(Role role) {
		// TODO Auto-generated method stub
		return dao.queryAll(role);
	}

	@Override
	public boolean queryFK(String column, String id) {
		// TODO Auto-generated method stub
		return dao.queryFK(column, id);
	}

	@Override
	public boolean deleteFK(String column, String id) {
		// TODO Auto-generated method stub
		return dao.deleteFK(column, id);
	}

}
