package com.ssglxt.domain.VO;

import java.util.List;

import com.ssglxt.domain.DO.ssglxt_dormitoryBuilding;



public class DormitoryBuildingVO {
	private int currPage=1;//当前页
	private int totalPage;//总页数
	private int totalCount;//总记录数
	private int pageSize;//每页条数
	private String dormitoryBuilding_buildingName;//宿舍楼名称
	private List<ssglxt_dormitoryBuilding> ssglxt_dormitoryBuildingList;
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getDormitoryBuilding_buildingName() {
		return dormitoryBuilding_buildingName;
	}
	public void setDormitoryBuilding_buildingName(String dormitoryBuilding_buildingName) {
		this.dormitoryBuilding_buildingName = dormitoryBuilding_buildingName;
	}
	public List<ssglxt_dormitoryBuilding> getSsglxt_dormitoryBuildingList() {
		return ssglxt_dormitoryBuildingList;
	}
	public void setSsglxt_dormitoryBuildingList(List<ssglxt_dormitoryBuilding> ssglxt_dormitoryBuildingList) {
		this.ssglxt_dormitoryBuildingList = ssglxt_dormitoryBuildingList;
	}
	@Override
	public String toString() {
		return "DormitoryBuildingVO [currPage=" + currPage + ", totalPage=" + totalPage + ", totalCount=" + totalCount
				+ ", pageSize=" + pageSize + ", dormitoryBuilding_buildingName=" + dormitoryBuilding_buildingName
				+ ", ssglxt_dormitoryBuildingList=" + ssglxt_dormitoryBuildingList + "]";
	}


	
}
