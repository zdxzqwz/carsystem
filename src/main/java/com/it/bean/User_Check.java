package com.it.bean;

public class User_Check {
	//员工考核表
	private int ck_id;//考核编号
	private int ck_user_id;//员工编号
	private String user_name;//员工姓名
	private int ck_cowa;//工作考勤评分
	private int ck_schedule;//工作完成进度评分
	private int ck_standard;//工作安全规范评分
	private String ck_propose;//备注
	private String ck_month;//考核时间
	public int getCk_id() {
		return ck_id;
	}
	public void setCk_id(int ck_id) {
		this.ck_id = ck_id;
	}
	public int getCk_user_id() {
		return ck_user_id;
	}
	public void setCk_user_id(int ck_user_id) {
		this.ck_user_id = ck_user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getCk_cowa() {
		return ck_cowa;
	}
	public void setCk_cowa(int ck_cowa) {
		this.ck_cowa = ck_cowa;
	}
	public int getCk_schedule() {
		return ck_schedule;
	}
	public void setCk_schedule(int ck_schedule) {
		this.ck_schedule = ck_schedule;
	}
	public int getCk_standard() {
		return ck_standard;
	}
	public void setCk_standard(int ck_standard) {
		this.ck_standard = ck_standard;
	}
	public String getCk_propose() {
		return ck_propose;
	}
	public void setCk_propose(String ck_propose) {
		this.ck_propose = ck_propose;
	}
	public String getCk_month() {
		return ck_month;
	}
	public void setCk_month(String ck_month) {
		this.ck_month = ck_month;
	}
	public User_Check(int ck_id, int ck_user_id, String user_name, int ck_cowa, int ck_schedule, int ck_standard,
			String ck_propose, String ck_month) {
		super();
		this.ck_id = ck_id;
		this.ck_user_id = ck_user_id;
		this.user_name = user_name;
		this.ck_cowa = ck_cowa;
		this.ck_schedule = ck_schedule;
		this.ck_standard = ck_standard;
		this.ck_propose = ck_propose;
		this.ck_month = ck_month;
	}
	public User_Check() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User_Check [ck_id=" + ck_id + ", ck_user_id=" + ck_user_id + ", user_name=" + user_name
				+ ", ck_cowa=" + ck_cowa + ", ck_schedule=" + ck_schedule + ", ck_standard=" + ck_standard
				+ ", ck_propose=" + ck_propose + ", ck_month=" + ck_month + "]";
	}
	
}
