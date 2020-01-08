package com.ssglxt.domain.VO;

import java.util.List;

import com.ssglxt.domain.DO.ssglxt_admin;
import com.ssglxt.domain.DO.ssglxt_bed;
import com.ssglxt.domain.DO.ssglxt_dormitoryBuilding;
import com.ssglxt.domain.DO.ssglxt_student;



public class StudentVO {
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
	private String student_name;//姓名
	private List<ssglxt_student> ssglxt_studentList;
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public List<ssglxt_student> getSsglxt_studentList() {
		return ssglxt_studentList;
	}
	public void setSsglxt_studentList(List<ssglxt_student> ssglxt_studentList) {
		this.ssglxt_studentList = ssglxt_studentList;
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
		return "StudentVO [pageIndex=" + pageIndex + ", totalRecords=" + totalRecords + ", pageSize=" + pageSize
				+ ", totalPages=" + totalPages + ", HavePrePage=" + HavePrePage + ", HaveNextPage=" + HaveNextPage
				+ ", student_name=" + student_name + ", ssglxt_studentList=" + ssglxt_studentList + "]";
	}
	
	

	
}
