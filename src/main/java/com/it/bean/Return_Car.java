package com.it.bean;
/**
 * 
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: Return_Car.java
* @Description: 还车表
*
* @version: v1.0.0
* @author: Only soul
* @date: 2019年3月14日 下午2:26:59 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年3月14日     Only soul           v1.0.0               修改原因
 */
public class Return_Car {
	private String ret_id;//还车编号
	private String dri_id;//驾驶员编号
	private String dri_name;//驾驶员姓名
	private String exp_id;//费用支出编号
	private String cmt_id;//评议记录编号
	private String car_id;//车牌号
	private String ret_out_why;//出车事由
	private String ret_out_test;// 目的地
	private String ret_out_time;//出车时间
	private String ret_return_time;//还车时间
	private String out_inputer;//出车记录人
	private String ret_inputer;//还车记录人
	private String ret_notes;//备注
	public String getRet_id() {
		return ret_id;
	}
	public void setRet_id(String ret_id) {
		this.ret_id = ret_id;
	}
	public String getDri_id() {
		return dri_id;
	}
	public void setDri_id(String dri_id) {
		this.dri_id = dri_id;
	}
	public String getDri_name() {
		return dri_name;
	}
	public void setDri_name(String dri_name) {
		this.dri_name = dri_name;
	}
	public String getExp_id() {
		return exp_id;
	}
	public void setExp_id(String exp_id) {
		this.exp_id = exp_id;
	}
	public String getCmt_id() {
		return cmt_id;
	}
	public void setCmt_id(String cmt_id) {
		this.cmt_id = cmt_id;
	}
	public String getCar_id() {
		return car_id;
	}
	public void setCar_id(String car_id) {
		this.car_id = car_id;
	}
	public String getRet_out_why() {
		return ret_out_why;
	}
	public void setRet_out_why(String ret_out_why) {
		this.ret_out_why = ret_out_why;
	}
	public String getRet_out_test() {
		return ret_out_test;
	}
	public void setRet_out_test(String ret_out_test) {
		this.ret_out_test = ret_out_test;
	}
	public String getRet_out_time() {
		return ret_out_time;
	}
	public void setRet_out_time(String ret_out_time) {
		this.ret_out_time = ret_out_time;
	}
	public String getRet_return_time() {
		return ret_return_time;
	}
	public void setRet_return_time(String ret_return_time) {
		this.ret_return_time = ret_return_time;
	}
	public String getOut_inputer() {
		return out_inputer;
	}
	public void setOut_inputer(String out_inputer) {
		this.out_inputer = out_inputer;
	}
	public String getRet_inputer() {
		return ret_inputer;
	}
	public void setRet_inputer(String ret_inputer) {
		this.ret_inputer = ret_inputer;
	}
	public String getRet_notes() {
		return ret_notes;
	}
	public void setRet_notes(String ret_notes) {
		this.ret_notes = ret_notes;
	}
	public Return_Car(String ret_id, String dri_id, String dri_name, String exp_id, String cmt_id, String car_id,
			String ret_out_why, String ret_out_test, String ret_out_time, String ret_return_time, String out_inputer,
			String ret_inputer, String ret_notes) {
		super();
		this.ret_id = ret_id;
		this.dri_id = dri_id;
		this.dri_name = dri_name;
		this.exp_id = exp_id;
		this.cmt_id = cmt_id;
		this.car_id = car_id;
		this.ret_out_why = ret_out_why;
		this.ret_out_test = ret_out_test;
		this.ret_out_time = ret_out_time;
		this.ret_return_time = ret_return_time;
		this.out_inputer = out_inputer;
		this.ret_inputer = ret_inputer;
		this.ret_notes = ret_notes;
	}
	public Return_Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Return_Car [ret_id=" + ret_id + ", dri_id=" + dri_id + ", dri_name=" + dri_name + ", exp_id=" + exp_id
				+ ", cmt_id=" + cmt_id + ", car_id=" + car_id + ", ret_out_why=" + ret_out_why + ", ret_out_test="
				+ ret_out_test + ", ret_out_time=" + ret_out_time + ", ret_return_time=" + ret_return_time
				+ ", out_inputer=" + out_inputer + ", ret_inputer=" + ret_inputer + ", ret_notes=" + ret_notes + "]";
	}
	
	/**
	 * get  和      set
	 */
	
	
	
	
	
	
	
	
	
}
