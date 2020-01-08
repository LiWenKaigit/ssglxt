package com.ssglxt.domain.VO;

import java.util.List;

import com.ssglxt.domain.DO.ssglxt_dormitory;
import com.ssglxt.domain.DO.ssglxt_dormitoryBuilding;



public class DormitoryVO {
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
	private String dormitory_buildingName;//宿舍楼名称
	//private String dormitory_name;//宿舍名称
	
	private List<ssglxt_dormitory> ssglxt_dormitoryList;

	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getDormitory_buildingName() {
		return dormitory_buildingName;
	}
	public void setDormitory_buildingName(String dormitory_buildingName) {
		this.dormitory_buildingName = dormitory_buildingName;
	}
	public List<ssglxt_dormitory> getSsglxt_dormitoryList() {
		return ssglxt_dormitoryList;
	}
	public void setSsglxt_dormitoryList(List<ssglxt_dormitory> ssglxt_dormitoryList) {
		this.ssglxt_dormitoryList = ssglxt_dormitoryList;
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
		return "DormitoryVO [pageIndex=" + pageIndex + ", totalRecords=" + totalRecords + ", pageSize=" + pageSize
				+ ", totalPages=" + totalPages + ", HavePrePage=" + HavePrePage + ", HaveNextPage=" + HaveNextPage
				+ ", dormitory_buildingName=" + dormitory_buildingName + ", ssglxt_dormitoryList="
				+ ssglxt_dormitoryList + "]";
	}

	


	
}
