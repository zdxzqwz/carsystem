package com.it.bean;
/**
 * 
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: Role.java
* @Description: 角色表
*
* @version: v1.0.0
* @author: Only soul
* @date: 2019年3月21日 下午9:06:22 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年3月21日     Only soul           v1.0.0               修改原因
 */
public class Role {
	private String roleId;//权限编号
	private String roleName;//权限名字
	private String roleInfo;//权限描述
	
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(String roleId, String roleName, String roleInfo) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleInfo = roleInfo;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleInfo() {
		return roleInfo;
	}
	public void setRoleInfo(String roleInfo) {
		this.roleInfo = roleInfo;
	}
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", roleInfo=" + roleInfo + "]";
	}

	
}
