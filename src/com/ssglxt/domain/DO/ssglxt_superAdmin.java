package com.ssglxt.domain.DO;

public class ssglxt_superAdmin {

	private String superAdmin_id;//超级管理员id
	
	private String superAdmin_jobNumber;//工号
	
	private String superAdmin_password;//密码
	
	private String superAdmin_creat_time;//创建时间
	
	private String superAdmin_modify_time;//修改时间
	
	private String superAdmin_role;//角色
	
	private String superAdmin_name;//姓名
	
	

	public String getSuperAdmin_role() {
		return superAdmin_role;
	}

	public void setSuperAdmin_role(String superAdmin_role) {
		this.superAdmin_role = superAdmin_role;
	}

	public String getSuperAdmin_name() {
		return superAdmin_name;
	}

	public void setSuperAdmin_name(String superAdmin_name) {
		this.superAdmin_name = superAdmin_name;
	}

	public String getSuperAdmin_id() {
		return superAdmin_id;
	}

	public void setSuperAdmin_id(String superAdmin_id) {
		this.superAdmin_id = superAdmin_id;
	}

	public String getSuperAdmin_jobNumber() {
		return superAdmin_jobNumber;
	}

	public void setSuperAdmin_jobNumber(String superAdmin_jobNumber) {
		this.superAdmin_jobNumber = superAdmin_jobNumber;
	}

	public String getSuperAdmin_password() {
		return superAdmin_password;
	}

	public void setSuperAdmin_password(String superAdmin_password) {
		this.superAdmin_password = superAdmin_password;
	}

	public String getSuperAdmin_creat_time() {
		return superAdmin_creat_time;
	}

	public void setSuperAdmin_creat_time(String superAdmin_creat_time) {
		this.superAdmin_creat_time = superAdmin_creat_time;
	}

	public String getSuperAdmin_modify_time() {
		return superAdmin_modify_time;
	}

	public void setSuperAdmin_modify_time(String superAdmin_modify_time) {
		this.superAdmin_modify_time = superAdmin_modify_time;
	}

	@Override
	public String toString() {
		return "ssglxt_superAdmin [superAdmin_id=" + superAdmin_id + ", superAdmin_jobNumber=" + superAdmin_jobNumber
				+ ", superAdmin_password=" + superAdmin_password + ", superAdmin_creat_time=" + superAdmin_creat_time
				+ ", superAdmin_modify_time=" + superAdmin_modify_time + ", superAdmin_role=" + superAdmin_role
				+ ", superAdmin_name=" + superAdmin_name + "]";
	}

	
	
	
}
