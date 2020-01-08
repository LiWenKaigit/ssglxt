package com.ssglxt.domain.DO;

public class ssglxt_dormitory {

	private String dormitory_id;//宿舍id
	
	private String dormitory_buildingName;//楼名称
	
	private String dormitory_name;//宿舍名称
	
	private String dormitory_scale;//宿舍规模
	
	private String dormitory_liveStatus;//宿舍入住情况
	
	private String dormitory_studentId;//学生入住的编号
	
	private String dormitory_creat_time;//创建时间
	
	private String dormitory_modify_time;//修改时间

	public String getDormitory_id() {
		return dormitory_id;
	}

	public void setDormitory_id(String dormitory_id) {
		this.dormitory_id = dormitory_id;
	}

	public String getDormitory_buildingName() {
		return dormitory_buildingName;
	}

	public void setDormitory_buildingName(String dormitory_buildingName) {
		this.dormitory_buildingName = dormitory_buildingName;
	}

	public String getDormitory_name() {
		return dormitory_name;
	}

	public void setDormitory_name(String dormitory_name) {
		this.dormitory_name = dormitory_name;
	}

	public String getDormitory_scale() {
		return dormitory_scale;
	}

	public void setDormitory_scale(String dormitory_scale) {
		this.dormitory_scale = dormitory_scale;
	}

	public String getDormitory_liveStatus() {
		return dormitory_liveStatus;
	}

	public void setDormitory_liveStatus(String dormitory_liveStatus) {
		this.dormitory_liveStatus = dormitory_liveStatus;
	}

	public String getDormitory_studentId() {
		return dormitory_studentId;
	}

	public void setDormitory_studentId(String dormitory_studentId) {
		this.dormitory_studentId = dormitory_studentId;
	}

	public String getDormitory_creat_time() {
		return dormitory_creat_time;
	}

	public void setDormitory_creat_time(String dormitory_creat_time) {
		this.dormitory_creat_time = dormitory_creat_time;
	}

	public String getDormitory_modify_time() {
		return dormitory_modify_time;
	}

	public void setDormitory_modify_time(String dormitory_modify_time) {
		this.dormitory_modify_time = dormitory_modify_time;
	}

	@Override
	public String toString() {
		return "ssglxt_dormitory [dormitory_id=" + dormitory_id + ", dormitory_buildingName=" + dormitory_buildingName
				+ ", dormitory_name=" + dormitory_name + ", dormitory_scale=" + dormitory_scale
				+ ", dormitory_liveStatus=" + dormitory_liveStatus + ", dormitory_studentId=" + dormitory_studentId
				+ ", dormitory_creat_time=" + dormitory_creat_time + ", dormitory_modify_time=" + dormitory_modify_time
				+ "]";
	}
	
	
	
}
