package com.it.global;

import java.util.List;

import com.it.bean.Role;

/**
 * 
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: IRole.java
* @Description:角色表的功能接口
*
* @version: v1.0.0
* @author: Only soul
* @date: 2019年3月22日 下午4:24:58 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年3月22日     Only soul           v1.0.0               修改原因
 */
public interface IRole {
	//添加角色
	public boolean addRole(Role role,String authId);
	//删除角色
	public boolean delRole(Role role);
	//修改角色
	public boolean updRole(Role role,String authId);
	//查询单个
	public Role findByIdRole(Role role);
	//查询所有角色
	public List<Role> queryAllRole(Role role);
	//查询数据个数
	public int roleCount(Role role);
}
