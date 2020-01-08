package com.ssglxt.Super.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.ssglxt.Super.service.DormitoryBuildingService;
import com.ssglxt.domain.DO.ssglxt_dormitoryBuilding;
import com.ssglxt.domain.VO.DormitoryBuildingVO;

public class DormitoryBuildingAction extends ActionSupport {
private DormitoryBuildingService dormitoryBuildingService;

private ssglxt_dormitoryBuilding dormitoryBuilding;

private String DormitoryBuildingAll;

private DormitoryBuildingVO dormitoryBuildingVO;


public DormitoryBuildingVO getDormitoryBuildingVO() {
	return dormitoryBuildingVO;
}

public void setDormitoryBuildingVO(DormitoryBuildingVO dormitoryBuildingVO) {
	this.dormitoryBuildingVO = dormitoryBuildingVO;
}

public String getDormitoryBuildingAll() {
	return DormitoryBuildingAll;
}

public void setDormitoryBuildingAll(String dormitoryBuildingAll) {
	DormitoryBuildingAll = dormitoryBuildingAll;
}

public ssglxt_dormitoryBuilding getDormitoryBuilding() {
	return dormitoryBuilding;
}

public void setDormitoryBuilding(ssglxt_dormitoryBuilding dormitoryBuilding) {
	this.dormitoryBuilding = dormitoryBuilding;
}

public DormitoryBuildingService getDormitoryBuildingService() {
	return dormitoryBuildingService;
}

public void setDormitoryBuildingService(DormitoryBuildingService dormitoryBuildingService) {
	this.dormitoryBuildingService = dormitoryBuildingService;
}
/*
 * 添加宿舍楼
 */
public void addDormitoryBuilding() throws IOException{
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	if(dormitoryBuildingService.addDormitoryBuilding(dormitoryBuilding)){
		pw.write("1");
	}else{
		pw.write("2");
	}
}

/*
 * 修改宿舍楼信息
 */
public void updateDormitoryBuilding() throws IOException{
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	if(dormitoryBuildingService.updateDormitoryBuilding(dormitoryBuilding)){
		pw.write("1");
	}else{
		pw.write("2");
	}
}
/*
 * 删除宿舍楼
 */
public void deleteDormitoryBuilding() throws IOException{
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	if(dormitoryBuildingService.deleteDormitoryBuilding(DormitoryBuildingAll)){
		pw.write("1");
	}else{
		pw.write("2");
	}
}
/*
 * 分页查找宿舍楼信息
 */
public void getDormitoryBuildingListBysearchPage() throws IOException{
	dormitoryBuildingService.getDormitoryBuildingListBysearchPage(dormitoryBuildingVO);
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	 GsonBuilder gsonBuilder = new GsonBuilder();
 	 gsonBuilder.setPrettyPrinting();// 格式化json数据
 	 Gson gson = gsonBuilder.create();
 	 pw.write(gson.toJson(dormitoryBuildingVO));
}
/*
 * 
 * 根据id得到宿舍楼信息
 */
public void getDormitoryBuildingById() throws IOException{
	dormitoryBuilding = dormitoryBuildingService.getDormitoryBuildingById(dormitoryBuilding.getDormitoryBuilding_id());
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	GsonBuilder gsonBuilder = new GsonBuilder();
 	 gsonBuilder.setPrettyPrinting();// 格式化json数据
 	 Gson gson = gsonBuilder.create();
 	 pw.write(gson.toJson(dormitoryBuilding));
}
/*
 * 跳转宿舍楼管理页面
 */
public String  list_dormitoryBuilding(){
	System.out.println("k");
	return "list_dormitoryBuilding";
}
}
