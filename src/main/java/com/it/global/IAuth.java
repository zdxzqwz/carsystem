package com.it.global;

import java.util.List;

import com.it.bean.Auth;

/**
 * 
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: IAuth.java
* @Description: 权限表的功能接口
*
* @version: v1.0.0
* @author: Only soul
* @date: 2019年3月22日 下午4:02:38 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年3月22日     Only soul           v1.0.0               修改原因
 */
public interface IAuth {
	//添加权限
	boolean addAuth(Auth auth);
	//删除权限
	boolean delAuth(Auth auth);
	//修改权限
	boolean updAuth(Auth auth);
	//查找单个
	boolean findById(Auth auth);
	//查询所有权限
	List<Auth> queryAllAuth(Auth auth);
	//查询登录用户对应的权限
	List<Auth> queryAllByUserId(String userId);
	List<Auth> queryAllByRoleId(String roleId);
	//查找该节点有没有子节点
	boolean isLeaf(Auth auth);
	//通过权限id修改state状态
	int updateStateByAuthId(String state, String authId);
	//查询该节点下的权限数量
	int getAuthCountByParentId(String parentId);
	
}
