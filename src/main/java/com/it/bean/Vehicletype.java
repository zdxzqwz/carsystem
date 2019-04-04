package com.it.bean;
  /**
 	* 
	* @ClassName: Vehicletype 
	* @Description: TODO(车辆类型表) 
	* @author lijing
	* @date 2019年3月14日 上午9:55:17 
	*
    */
public class Vehicletype {

	private String veh_id;//类型编号
	private String veh_name;//类型名字
	
	/**
	 * 
	* <p>Title:无参构造方法</p> 
	* <p>Description: </p>
	 */
	public Vehicletype() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	* <p>Title:有参构造方法 </p> 
	* <p>Description: </p> 
	* @param veh_id
	* @param veh_name
	 */
	public Vehicletype(String veh_id, String veh_name) {
		super();
		this.veh_id = veh_id;
		this.veh_name = veh_name;
	}
	@Override
	public String toString() {
		return "Vehicletype [veh_id=" + veh_id + ", veh_name=" + veh_name + "]";
	}
	/*
	 * get set 方法
	 */
	public String getVeh_id() {
		return veh_id;
	}
	public void setVeh_id(String veh_id) {
		this.veh_id = veh_id;
	}
	public String getVeh_name() {
		return veh_name;
	}
	public void setVeh_name(String veh_name) {
		this.veh_name = veh_name;
	}
	
	
	
	
}
