package com.it.global;

import com.it.bean.Role;
import com.it.bean.Role_Auth;

/**
 * 
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: IRole_Auth.java
* @Description: 权限角色关联表的接口层
*
* @version: v1.0.0
* @author: Only soul
* @date: 2019年3月22日 下午4:31:40 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年3月22日     Only soul           v1.0.0               修改原因
 */
public interface IRole_Auth {
	//添加角色权限
		public boolean addRoleAuth(Role_Auth roleauth);
		//删除角色权限
		public boolean delRoleAuth(Role_Auth roleauth);
		//修改角色权限
		public boolean updRoleAuth(Role_Auth roleauth);
		//查询所有角色id对应的权限
		public String queryAll(Role role);
		//查询外键
		public boolean queryFK(String column, String id);
		//删除外键
		public boolean deleteFK(String column, String id);
}
