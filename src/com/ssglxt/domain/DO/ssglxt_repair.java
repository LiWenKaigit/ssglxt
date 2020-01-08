package com.ssglxt.domain.DO;

public class ssglxt_repair {

	private String repair_id;//报修id
	
	private String repair_name;//报修物品名
	
	private String repair_remarks;//报修备注
	
	private String repair_studentId;//学生学号
	
	private String repair_status;//维修状态
	
	private String repair_creat_time;//创建时间
	
	private String repair_modify_time;//修改时间

	public String getRepair_id() {
		return repair_id;
	}

	public void setRepair_id(String repair_id) {
		this.repair_id = repair_id;
	}

	public String getRepair_name() {
		return repair_name;
	}

	public void setRepair_name(String repair_name) {
		this.repair_name = repair_name;
	}

	public String getRepair_remarks() {
		return repair_remarks;
	}

	public void setRepair_remarks(String repair_remarks) {
		this.repair_remarks = repair_remarks;
	}

	public String getRepair_studentId() {
		return repair_studentId;
	}

	public void setRepair_studentId(String repair_studentId) {
		this.repair_studentId = repair_studentId;
	}

	public String getRepair_status() {
		return repair_status;
	}

	public void setRepair_status(String repair_status) {
		this.repair_status = repair_status;
	}

	public String getRepair_creat_time() {
		return repair_creat_time;
	}

	public void setRepair_creat_time(String repair_creat_time) {
		this.repair_creat_time = repair_creat_time;
	}

	public String getRepair_modify_time() {
		return repair_modify_time;
	}

	public void setRepair_modify_time(String repair_modify_time) {
		this.repair_modify_time = repair_modify_time;
	}

	@Override
	public String toString() {
		return "ssglxt_repair [repair_id=" + repair_id + ", repair_name=" + repair_name + ", repair_remarks="
				+ repair_remarks + ", repair_studentId=" + repair_studentId + ", repair_status=" + repair_status
				+ ", repair_creat_time=" + repair_creat_time + ", repair_modify_time=" + repair_modify_time + "]";
	}
	
	

}
