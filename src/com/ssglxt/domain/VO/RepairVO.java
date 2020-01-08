package com.ssglxt.domain.VO;

import java.util.List;

import com.ssglxt.domain.DO.ssglxt_admin;
import com.ssglxt.domain.DO.ssglxt_bed;
import com.ssglxt.domain.DO.ssglxt_dormitoryBuilding;
import com.ssglxt.domain.DO.ssglxt_repair;
import com.ssglxt.domain.DO.ssglxt_student;



public class RepairVO {
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
	private String repair_name;//报修物品名
	private String repair_status;
	private List<ssglxt_repair> ssglxt_repairList;
	private List<ssglxt_student> ssglxt_studentList;
	
	
	
	public List<ssglxt_student> getSsglxt_studentList() {
		return ssglxt_studentList;
	}
	public void setSsglxt_studentList(List<ssglxt_student> ssglxt_studentList) {
		this.ssglxt_studentList = ssglxt_studentList;
	}
	public String getRepair_status() {
		return repair_status;
	}
	public void setRepair_status(String repair_status) {
		this.repair_status = repair_status;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getRepair_name() {
		return repair_name;
	}
	public void setRepair_name(String repair_name) {
		this.repair_name = repair_name;
	}
	public List<ssglxt_repair> getSsglxt_repairList() {
		return ssglxt_repairList;
	}
	public void setSsglxt_repairList(List<ssglxt_repair> ssglxt_repairList) {
		this.ssglxt_repairList = ssglxt_repairList;
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
		return "RepairVO [pageIndex=" + pageIndex + ", totalRecords=" + totalRecords + ", pageSize=" + pageSize
				+ ", totalPages=" + totalPages + ", HavePrePage=" + HavePrePage + ", HaveNextPage=" + HaveNextPage
				+ ", repair_name=" + repair_name + ", repair_status=" + repair_status + ", ssglxt_repairList="
				+ ssglxt_repairList + ", ssglxt_studentList=" + ssglxt_studentList + "]";
	}
	



	
}
