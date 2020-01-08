package com.ssglxt.domain.VO;

import java.util.List;

import com.ssglxt.domain.DO.ssglxt_bed;
import com.ssglxt.domain.DO.ssglxt_dormitoryBuilding;



public class BedVO {
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
	private String bed_buildingName;//宿舍楼名称
	private List<ssglxt_bed> ssglxt_bedList;
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getBed_buildingName() {
		return bed_buildingName;
	}
	public void setBed_buildingName(String bed_buildingName) {
		this.bed_buildingName = bed_buildingName;
	}
	public List<ssglxt_bed> getSsglxt_bedList() {
		return ssglxt_bedList;
	}
	public void setSsglxt_bedList(List<ssglxt_bed> ssglxt_bedList) {
		this.ssglxt_bedList = ssglxt_bedList;
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
		return "BedVO [pageIndex=" + pageIndex + ", totalRecords=" + totalRecords + ", pageSize=" + pageSize
				+ ", totalPages=" + totalPages + ", HavePrePage=" + HavePrePage + ", HaveNextPage=" + HaveNextPage
				+ ", bed_buildingName=" + bed_buildingName + ", ssglxt_bedList=" + ssglxt_bedList + "]";
	}
	

	
}
