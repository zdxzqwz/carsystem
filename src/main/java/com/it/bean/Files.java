package com.it.bean;
/**
 * 
* @ClassName: Files 
* @Description: TODO(实现上传下载的文件类) 
* @author lijing
* @date 2019年3月22日 上午9:14:16 
*
 */
public class Files {
	
	private String f_id;//文件编号
	private String f_name;//文件名
	private String f_path;//文件路径
	/*
	 * set  get
	 */
	public String getF_id() {
		return f_id;
	}
	public void setF_id(String f_id) {
		this.f_id = f_id;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getF_path() {
		return f_path;
	}
	public void setF_path(String f_path) {
		this.f_path = f_path;
	}
	@Override
	public String toString() {
		return "Files [f_id=" + f_id + ", f_name=" + f_name + ", f_path=" + f_path + "]";
	}
	/**
	 * 
	* <p>Title:构造方法 </p> 
	* <p>Description:含参 </p> 
	* @param f_id
	* @param f_name
	* @param f_path
	 */
	public Files(String f_id, String f_name, String f_path) {
		super();
		this.f_id = f_id;
		this.f_name = f_name;
		this.f_path = f_path;
	}
	/**
	 * 
	* <p>Title:构造方法 </p> 
	* <p>Description: 无参</p>
	 */
	public Files() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
