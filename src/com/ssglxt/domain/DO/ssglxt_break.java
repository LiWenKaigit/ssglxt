package com.ssglxt.domain.DO;

public class ssglxt_break {

	private String break_id;//违规id
	
	private String break_reason;//违规情况
	
	private String break_time;//违规时间
	
	private String break_studentId;//违规学生学号
	
	private String break_creat_time;//创建时间
	
	private String break_modify_time;//修改时间

	public String getBreak_id() {
		return break_id;
	}

	public void setBreak_id(String break_id) {
		this.break_id = break_id;
	}

	public String getBreak_reason() {
		return break_reason;
	}

	public void setBreak_reason(String break_reason) {
		this.break_reason = break_reason;
	}

	public String getBreak_time() {
		return break_time;
	}

	public void setBreak_time(String break_time) {
		this.break_time = break_time;
	}

	public String getBreak_studentId() {
		return break_studentId;
	}

	public void setBreak_studentId(String break_studentId) {
		this.break_studentId = break_studentId;
	}

	public String getBreak_creat_time() {
		return break_creat_time;
	}

	public void setBreak_creat_time(String break_creat_time) {
		this.break_creat_time = break_creat_time;
	}

	public String getBreak_modify_time() {
		return break_modify_time;
	}

	public void setBreak_modify_time(String break_modify_time) {
		this.break_modify_time = break_modify_time;
	}

	@Override
	public String toString() {
		return "ssglxt_break [break_id=" + break_id + ", break_reason=" + break_reason + ", break_time=" + break_time
				+ ", break_studentId=" + break_studentId + ", break_creat_time=" + break_creat_time
				+ ", break_modify_time=" + break_modify_time + "]";
	}
	
	
	
	
}
