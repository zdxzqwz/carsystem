package com.it.bean;
/**
 * 
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: Auth.java
* @Description: 权限表
*
* @version: v1.0.0
* @author: Only soul
* @date: 2019年3月21日 下午8:53:41 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年3月21日     Only soul           v1.0.0               修改原因
 */
public class Auth {
	private String authId;//权限编号
	private String authName;//权限名字
	private String authPath;//权限地址
	private String parentId;//父权限id
	private String authDescription;//权限描述
	private String state;//状态
	private String iconCls;//权限图标
	private String background;//模板的背景图片
	public Auth(String authId, String authName, String authPath, String parentId, String authDescription, String state,
			String iconCls) {
		super();
		this.authId = authId;
		this.authName = authName;
		this.authPath = authPath;
		this.parentId = parentId;
		this.authDescription = authDescription;
		this.state = state;
		this.iconCls = iconCls;
	}
	public Auth() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public String getBackground() {
		return background;
	}
	public void setBackground(String background) {
		this.background = background;
	}
	public String getAuthId() {
		return authId;
	}
	public void setAuthId(String authId) {
		this.authId = authId;
	}
	public String getAuthName() {
		return authName;
	}
	public void setAuthName(String authName) {
		this.authName = authName;
	}
	public String getAuthPath() {
		return authPath;
	}
	public void setAuthPath(String authPath) {
		this.authPath = authPath;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getAuthDescription() {
		return authDescription;
	}
	public void setAuthDescription(String authDescription) {
		this.authDescription = authDescription;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	@Override
	public String toString() {
		return "Auth [authId=" + authId + ", authName=" + authName + ", authPath=" + authPath + ", parentId=" + parentId
				+ ", authDescription=" + authDescription + ", state=" + state + ", iconCls=" + iconCls + "]";
	}
	
	
	
	
}
