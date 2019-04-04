package com.it.services;

import java.util.List;

import com.it.bean.Auth;
import com.it.dao.AuthDAO;
import com.it.global.IAuth;
/**
 * 
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: AuthServices.java
* @Description: 权限表的服务类
*
* @version: v1.0.0
* @author: Only soul
* @date: 2019年3月22日 下午4:13:52 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年3月22日     Only soul           v1.0.0               修改原因
 */
public class AuthServices implements IAuth {
	AuthDAO dao = new AuthDAO();
	@Override
	public boolean addAuth(Auth auth) {
		// TODO Auto-generated method stub
		return dao.addAuth(auth);
	}

	@Override
	public boolean delAuth(Auth auth) {
		// TODO Auto-generated method stub
		return dao.delAuth(auth);
	}

	@Override
	public boolean updAuth(Auth auth) {
		// TODO Auto-generated method stub
		return dao.updAuth(auth);
	}

	@Override
	public boolean findById(Auth auth) {
		// TODO Auto-generated method stub
		return dao.findById(auth);
	}

	@Override
	public List<Auth> queryAllAuth(Auth auth) {
		// TODO Auto-generated method stub
		return dao.queryAllAuth(auth);
	}

	@Override
	public List<Auth> queryAllByRoleId(String roleId) {
		// TODO Auto-generated method stub
		return dao.queryAllByRoleId(roleId);
	}

	@Override
	public List<Auth> queryAllByUserId(String userId) {
		// TODO Auto-generated method stub
		return dao.queryAllByUserId(userId);
	}

	@Override
	public boolean isLeaf(Auth auth) {
		// TODO Auto-generated method stub
		return dao.isLeaf(auth);
	}

	@Override
	public int updateStateByAuthId(String state, String authId) {
		// TODO Auto-generated method stub
		return dao.updateStateByAuthId(state, authId);
	}

	@Override
	public int getAuthCountByParentId(String parentId) {
		// TODO Auto-generated method stub
		return dao.getAuthCountByParentId(parentId);
	}

}
