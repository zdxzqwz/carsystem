package com.it.services;

import java.util.List;

import com.it.bean.Role;
import com.it.dao.RoleDAO;
import com.it.global.IRole;
/**
 * 
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: RoleServices.java
* @Description: 角色表的服务类
*
* @version: v1.0.0
* @author: Only soul
* @date: 2019年3月22日 下午4:27:59 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年3月22日     Only soul           v1.0.0               修改原因
 */
public class RoleServices implements IRole {
	RoleDAO dao = new RoleDAO();
	@Override
	public boolean addRole(Role role, String authId) {
		
		return dao.addRole(role, authId);
	}

	@Override
	public boolean delRole(Role role) {
		
		return dao.delRole(role);
	}

	@Override
	public boolean updRole(Role role, String authId) {
		
		return dao.updRole(role, authId);
	}

	@Override
	public Role findByIdRole(Role role) {
		
		return dao.findByIdRole(role);
	}

	@Override
	public List<Role> queryAllRole(Role role) {
		
		return dao.queryAllRole(role);
	}

	@Override
	public int roleCount(Role role) {
		// TODO Auto-generated method stub
		return dao.roleCount(role);
	}

}
