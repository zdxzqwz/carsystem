package com.it.bean;
/**
 * 
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: PageBean.java
* @Description: 分页的类
*
* @version: v1.0.0
* @author: Only soul
* @date: 2019年3月12日 上午11:36:00 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年3月12日     Only soul           v1.0.0               修改原因
 */
public class PageBean {
	private int page; // 第几页
	private int rows; // 每页记录数
	private int start;  // 起始页
	
	
	public PageBean(int page, int rows) {
		super();
		this.page = page;
		this.rows = rows;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getStart() {
		return (page-1)*rows;
	}
}
