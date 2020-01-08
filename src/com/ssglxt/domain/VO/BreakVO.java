package com.ssglxt.domain.VO;

import java.util.List;

import com.ssglxt.domain.DO.ssglxt_admin;
import com.ssglxt.domain.DO.ssglxt_bed;
import com.ssglxt.domain.DO.ssglxt_break;
import com.ssglxt.domain.DO.ssglxt_dormitoryBuilding;
import com.ssglxt.domain.DO.ssglxt_student;



public class BreakVO {
	 //首页
	private int pageIndex = 1;
    //总记录数
	private int totalRecords = 0;
    //每页显示的页数
	private int pageSize = 20;
	// 总页数
	private int totalPages = 1;
	// 上一页
	private boolean HavePrePage = false;
	// 下一页
	private boolean HaveNextPage = false;
	private String break_studentId;//违规学生学号
	private List<ssglxt_break> ssglxt_breakList;
	private List<ssglxt_student> ssglxt_studentList;
	
	public List<ssglxt_student> getSsglxt_studentList() {
		return ssglxt_studentList;
	}
	public void setSsglxt_studentList(List<ssglxt_student> ssglxt_studentList) {
		this.ssglxt_studentList = ssglxt_studentList;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getBreak_studentId() {
		return break_studentId;
	}
	public void setBreak_studentId(String break_studentId) {
		this.break_studentId = break_studentId;
	}
	public List<ssglxt_break> getSsglxt_breakList() {
		return ssglxt_breakList;
	}
	public void setSsglxt_breakList(List<ssglxt_break> ssglxt_breakList) {
		this.ssglxt_breakList = ssglxt_breakList;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public boolean isHavePrePage() {
		return HavePrePage;
	}
	public void setHavePrePage(boolean havePrePage) {
		HavePrePage = havePrePage;
	}
	public boolean isHaveNextPage() {
		return HaveNextPage;
	}
	public void setHaveNextPage(boolean haveNextPage) {
		HaveNextPage = haveNextPage;
	}
	@Override
	public String toString() {
		return "BreakVO [pageIndex=" + pageIndex + ", totalRecords=" + totalRecords + ", pageSize=" + pageSize
				+ ", totalPages=" + totalPages + ", HavePrePage=" + HavePrePage + ", HaveNextPage=" + HaveNextPage
				+ ", break_studentId=" + break_studentId + ", ssglxt_breakList=" + ssglxt_breakList
				+ ", ssglxt_studentList=" + ssglxt_studentList + "]";
	}
	
	

	
}
