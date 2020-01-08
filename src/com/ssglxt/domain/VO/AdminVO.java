package com.ssglxt.domain.VO;

import java.util.List;

import com.ssglxt.domain.DO.ssglxt_admin;
import com.ssglxt.domain.DO.ssglxt_bed;
import com.ssglxt.domain.DO.ssglxt_dormitoryBuilding;



public class AdminVO {
	private int currPage=1;//当前页
	private int totalPage;//总页数
	private int totalCount;//总记录数
	private int pageSize;//每页条数
	private String admin_name;//姓名
	private List<ssglxt_admin> ssglxt_adminList;
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
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public List<ssglxt_admin> getSsglxt_adminList() {
		return ssglxt_adminList;
	}
	public void setSsglxt_adminList(List<ssglxt_admin> ssglxt_adminList) {
		this.ssglxt_adminList = ssglxt_adminList;
	}
	@Override
	public String toString() {
		return "AdminVO [currPage=" + currPage + ", totalPage=" + totalPage + ", totalCount=" + totalCount
				+ ", pageSize=" + pageSize + ", admin_name=" + admin_name + ", ssglxt_adminList=" + ssglxt_adminList
				+ "]";
	}
	

	
}
