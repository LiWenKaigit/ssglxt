package com.ssglxt.domain.DO;

public class ssglxt_dormitoryBuilding {

	
	private String dormitoryBuilding_id;//宿舍楼id
	
	private String dormitoryBuilding_buildingName;//楼名称
	
	private String dormitoryBuilding_roomNumber;//房间数
	
	private String dormitoryBuilding_liveSex;//居住性别
	
	private String dormitoryBuilding_creat_time;//创建时间
	
	private String dormitoryBuilding_modify_time;//修改时间

	public String getDormitoryBuilding_id() {
		return dormitoryBuilding_id;
	}

	public void setDormitoryBuilding_id(String dormitoryBuilding_id) {
		this.dormitoryBuilding_id = dormitoryBuilding_id;
	}

	public String getDormitoryBuilding_buildingName() {
		return dormitoryBuilding_buildingName;
	}

	public void setDormitoryBuilding_buildingName(String dormitoryBuilding_buildingName) {
		this.dormitoryBuilding_buildingName = dormitoryBuilding_buildingName;
	}

	public String getDormitoryBuilding_roomNumber() {
		return dormitoryBuilding_roomNumber;
	}

	public void setDormitoryBuilding_roomNumber(String dormitoryBuilding_roomNumber) {
		this.dormitoryBuilding_roomNumber = dormitoryBuilding_roomNumber;
	}

	public String getDormitoryBuilding_liveSex() {
		return dormitoryBuilding_liveSex;
	}

	public void setDormitoryBuilding_liveSex(String dormitoryBuilding_liveSex) {
		this.dormitoryBuilding_liveSex = dormitoryBuilding_liveSex;
	}

	public String getDormitoryBuilding_creat_time() {
		return dormitoryBuilding_creat_time;
	}

	public void setDormitoryBuilding_creat_time(String dormitoryBuilding_creat_time) {
		this.dormitoryBuilding_creat_time = dormitoryBuilding_creat_time;
	}

	public String getDormitoryBuilding_modify_time() {
		return dormitoryBuilding_modify_time;
	}

	public void setDormitoryBuilding_modify_time(String dormitoryBuilding_modify_time) {
		this.dormitoryBuilding_modify_time = dormitoryBuilding_modify_time;
	}

	@Override
	public String toString() {
		return "ssglxt_dormitoryBuilding [dormitoryBuilding_id=" + dormitoryBuilding_id
				+ ", dormitoryBuilding_buildingName=" + dormitoryBuilding_buildingName
				+ ", dormitoryBuilding_roomNumber=" + dormitoryBuilding_roomNumber + ", dormitoryBuilding_liveSex="
				+ dormitoryBuilding_liveSex + ", dormitoryBuilding_creat_time=" + dormitoryBuilding_creat_time
				+ ", dormitoryBuilding_modify_time=" + dormitoryBuilding_modify_time + "]";
	}
	
	
}
