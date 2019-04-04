package com.it.bean;

/**
 * 
* @ClassName: DriverInfo 
* @Description: TODO(驾驶员档案) 
* @author lijing
* @date 2019年3月13日 下午7:26:42 
*
 */
public class DriverInfo {

	private String dri_id;//驾驶员编号
	private String dri_age;//驾驶员年龄
	private String dri_name;//驾驶员姓名
	private String dri_sex;//驾驶员性别
	private String dri_addr;//驾驶员地址
	private String dri_phone;//驾驶员电话
	private String dri_lic_id;//驾驶员驾照编号
	private String dri_lic_type;//驾驶员驾照类型
	private String dri_cer_no;//从业资格证号
	private String dri_cer_type;//从业证类别
	private String dir_hiredate;//入职日期
	private String dir_termdate;//离职日期
	/**
	 * 
	* <p>Title: 无参构造方法</p> 
	* <p>Description: </p>
	 */
	public DriverInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DriverInfo(String dri_id, String dri_age, String dri_name, String dri_sex, String dri_addr, String dri_phone,
			String dri_lic_id, String dri_lic_type, String dri_cer_no, String dri_cer_type, String dir_hiredate,
			String dir_termdate) {
		super();
		this.dri_id = dri_id;
		this.dri_age = dri_age;
		this.dri_name = dri_name;
		this.dri_sex = dri_sex;
		this.dri_addr = dri_addr;
		this.dri_phone = dri_phone;
		this.dri_lic_id = dri_lic_id;
		this.dri_lic_type = dri_lic_type;
		this.dri_cer_no = dri_cer_no;
		this.dri_cer_type = dri_cer_type;
		this.dir_hiredate = dir_hiredate;
		this.dir_termdate = dir_termdate;
	}
	@Override
	public String toString() {
		return "DriverInfo [dri_id=" + dri_id + ", dri_age=" + dri_age + ", dri_name=" + dri_name + ", dri_sex="
				+ dri_sex + ", dri_addr=" + dri_addr + ", dri_phone=" + dri_phone + ", dri_lic_id=" + dri_lic_id
				+ ", dri_lic_type=" + dri_lic_type + ", dri_cer_no=" + dri_cer_no + ", dri_cer_type=" + dri_cer_type
				+ ", dir_hiredate=" + dir_hiredate + ", dir_termdate=" + dir_termdate + "]";
	}
	public String getDri_id() {
		return dri_id;
	}
	public void setDri_id(String dri_id) {
		this.dri_id = dri_id;
	}
	public String getDri_age() {
		return dri_age;
	}
	public void setDri_age(String dri_age) {
		this.dri_age = dri_age;
	}
	public String getDri_name() {
		return dri_name;
	}
	public void setDri_name(String dri_name) {
		this.dri_name = dri_name;
	}
	public String getDri_sex() {
		return dri_sex;
	}
	public void setDri_sex(String dri_sex) {
		this.dri_sex = dri_sex;
	}
	public String getDri_addr() {
		return dri_addr;
	}
	public void setDri_addr(String dri_addr) {
		this.dri_addr = dri_addr;
	}
	public String getDri_phone() {
		return dri_phone;
	}
	public void setDri_phone(String dri_phone) {
		this.dri_phone = dri_phone;
	}
	public String getDri_lic_id() {
		return dri_lic_id;
	}
	public void setDri_lic_id(String dri_lic_id) {
		this.dri_lic_id = dri_lic_id;
	}
	public String getDri_lic_type() {
		return dri_lic_type;
	}
	public void setDri_lic_type(String dri_lic_type) {
		this.dri_lic_type = dri_lic_type;
	}
	public String getDri_cer_no() {
		return dri_cer_no;
	}
	public void setDri_cer_no(String dri_cer_no) {
		this.dri_cer_no = dri_cer_no;
	}
	public String getDri_cer_type() {
		return dri_cer_type;
	}
	public void setDri_cer_type(String dri_cer_type) {
		this.dri_cer_type = dri_cer_type;
	}
	public String getDir_hiredate() {
		return dir_hiredate;
	}
	public void setDir_hiredate(String dir_hiredate) {
		this.dir_hiredate = dir_hiredate;
	}
	public String getDir_termdate() {
		return dir_termdate;
	}
	public void setDir_termdate(String dir_termdate) {
		this.dir_termdate = dir_termdate;
	}
	
	
}
