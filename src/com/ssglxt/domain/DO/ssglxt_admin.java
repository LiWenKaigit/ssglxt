package com.ssglxt.domain.DO;

public class ssglxt_admin {

	private String admin_id;//宿舍管理员id
	
	private String admin_jobNumber;//工号
	
	private String admin_name;//姓名
	
	private String admin_sex;//性别
	
	private String admin_age;//年龄
	
	private String admin_jobBuilding;//工作楼号
	
	private String admin_phone;//电话
	
	private String admin_address;//家庭住址
	
	private String  admin_password;//密码
	
	private String admin_creat_time;//创建时间
	
	private String admin_modify_time;//修改时间
	
	private String admin_role;//角色

	
	public String getAdmin_role() {
		return admin_role;
	}

	public void setAdmin_role(String admin_role) {
		this.admin_role = admin_role;
	}

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_jobNumber() {
		return admin_jobNumber;
	}

	public void setAdmin_jobNumber(String admin_jobNumber) {
		this.admin_jobNumber = admin_jobNumber;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getAdmin_sex() {
		return admin_sex;
	}

	public void setAdmin_sex(String admin_sex) {
		this.admin_sex = admin_sex;
	}

	public String getAdmin_age() {
		return admin_age;
	}

	public void setAdmin_age(String admin_age) {
		this.admin_age = admin_age;
	}

	public String getAdmin_jobBuilding() {
		return admin_jobBuilding;
	}

	public void setAdmin_jobBuilding(String admin_jobBuilding) {
		this.admin_jobBuilding = admin_jobBuilding;
	}

	public String getAdmin_phone() {
		return admin_phone;
	}

	public void setAdmin_phone(String admin_phone) {
		this.admin_phone = admin_phone;
	}

	public String getAdmin_address() {
		return admin_address;
	}

	public void setAdmin_address(String admin_address) {
		this.admin_address = admin_address;
	}

	public String getAdmin_password() {
		return admin_password;
	}

	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}

	public String getAdmin_creat_time() {
		return admin_creat_time;
	}

	public void setAdmin_creat_time(String admin_creat_time) {
		this.admin_creat_time = admin_creat_time;
	}

	public String getAdmin_modify_time() {
		return admin_modify_time;
	}

	public void setAdmin_modify_time(String admin_modify_time) {
		this.admin_modify_time = admin_modify_time;
	}

	@Override
	public String toString() {
		return "ssglxt_admin [admin_id=" + admin_id + ", admin_jobNumber=" + admin_jobNumber + ", admin_name="
				+ admin_name + ", admin_sex=" + admin_sex + ", admin_age=" + admin_age + ", admin_jobBuilding="
				+ admin_jobBuilding + ", admin_phone=" + admin_phone + ", admin_address=" + admin_address
				+ ", admin_password=" + admin_password + ", admin_creat_time=" + admin_creat_time
				+ ", admin_modify_time=" + admin_modify_time + ", admin_role=" + admin_role + "]";
	}

	
	
}
