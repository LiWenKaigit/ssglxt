package com.ssglxt.domain.DO;

public class ssglxt_bed {

	private String bed_id;//床位id
	
	private String bed_name;//床位名称
	
	private String bed_status;//̬床位状态
	
	private String bed_buildingName;//楼名称
	
	private String bed_dormitoryName;//宿舍名称
	
	private String bed_studentId;//入住学生编号
	
	private String bed_creat_time;//创建时间
	
	private String bed_modify_time;//修改时间

	public String getBed_id() {
		return bed_id;
	}

	public void setBed_id(String bed_id) {
		this.bed_id = bed_id;
	}

	public String getBed_name() {
		return bed_name;
	}

	public void setBed_name(String bed_name) {
		this.bed_name = bed_name;
	}

	public String getBed_status() {
		return bed_status;
	}

	public void setBed_status(String bed_status) {
		this.bed_status = bed_status;
	}

	public String getBed_buildingName() {
		return bed_buildingName;
	}

	public void setBed_buildingName(String bed_buildingName) {
		this.bed_buildingName = bed_buildingName;
	}

	public String getBed_dormitoryName() {
		return bed_dormitoryName;
	}

	public void setBed_dormitoryName(String bed_dormitoryName) {
		this.bed_dormitoryName = bed_dormitoryName;
	}

	public String getBed_studentId() {
		return bed_studentId;
	}

	public void setBed_studentId(String bed_studentId) {
		this.bed_studentId = bed_studentId;
	}

	public String getBed_creat_time() {
		return bed_creat_time;
	}

	public void setBed_creat_time(String bed_creat_time) {
		this.bed_creat_time = bed_creat_time;
	}

	public String getBed_modify_time() {
		return bed_modify_time;
	}

	public void setBed_modify_time(String bed_modify_time) {
		this.bed_modify_time = bed_modify_time;
	}

	@Override
	public String toString() {
		return "ssglxt_bed [bed_id=" + bed_id + ", bed_name=" + bed_name + ", bed_status=" + bed_status
				+ ", bed_buildingName=" + bed_buildingName + ", bed_dormitoryName=" + bed_dormitoryName
				+ ", bed_studentId=" + bed_studentId + ", bed_creat_time=" + bed_creat_time + ", bed_modify_time="
				+ bed_modify_time + "]";
	}
	
	
	
}
