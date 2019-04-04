package com.it.bean;
/**
 * 
 * @ClassName: Vehiclemodel 
 * @Description: TODO(车辆型号表) 
 * @author lijing
 * @date 2019年3月14日 上午10:00:22 
 *
 */
public class Vehiclemodel {
       
	private String vehm_id;//型号编号
	private String vehm_name;//型号名称
	private String veh_id;//类型编号
	/**
	 * 
	* <p>Title:有参构造方法 </p> 
	* <p>Description: </p> 
	* @param vehm_id
	* @param vehm_name
	* @param veh_id
	 */
	public Vehiclemodel(String vehm_id, String vehm_name, String veh_id) {
		super();
		this.vehm_id = vehm_id;
		this.vehm_name = vehm_name;
		this.veh_id = veh_id;
	}
	/**
	 * 
	* <p>Title:无参构造方法 </p> 
	* <p>Description: </p>
	 */
	public Vehiclemodel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Vehiclemodel [vehm_id=" + vehm_id + ", vehm_name=" + vehm_name + ", veh_id=" + veh_id + "]";
	}
	/*
	 * set get
	 */
	public String getVehm_id() {
		return vehm_id;
	}
	public void setVehm_id(String vehm_id) {
		this.vehm_id = vehm_id;
	}
	public String getVehm_name() {
		return vehm_name;
	}
	public void setVehm_name(String vehm_name) {
		this.vehm_name = vehm_name;
	}
	public String getVeh_id() {
		return veh_id;
	}
	public void setVeh_id(String veh_id) {
		this.veh_id = veh_id;
	}
	
	
	
	
}
