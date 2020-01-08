package com.ssglxt.Super.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.ssglxt.Super.service.DormitoryService;
import com.ssglxt.domain.DO.ssglxt_dormitory;
import com.ssglxt.domain.VO.DormitoryVO;

public class DormitoryAction extends ActionSupport {
private DormitoryService dormitoryService;
private ssglxt_dormitory dormitory;
private String dormitoryIDAll;
private DormitoryVO dormitoryVO;


public DormitoryVO getDormitoryVO() {
	return dormitoryVO;
}

public void setDormitoryVO(DormitoryVO dormitoryVO) {
	this.dormitoryVO = dormitoryVO;
}

public String getDormitoryIDAll() {
	return dormitoryIDAll;
}

public void setDormitoryIDAll(String dormitoryIDAll) {
	this.dormitoryIDAll = dormitoryIDAll;
}

public ssglxt_dormitory getDormitory() {
	return dormitory;
}

public void setDormitory(ssglxt_dormitory dormitory) {
	this.dormitory = dormitory;
}

public DormitoryService getDormitoryService() {
	return dormitoryService;
}

public void setDormitoryService(DormitoryService dormitoryService) {
	this.dormitoryService = dormitoryService;
}
/*
 * 添加宿舍
 */
public void addDormitory() throws IOException{
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	if(dormitoryService.addDormitory(dormitory)){
		pw.write("1");
	}else{
		pw.write("2");
	}
}
/*
 * 修改宿舍
 */
public void updateDormitory() throws IOException{
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	if(dormitoryService.updateDormitory(dormitory)){
		pw.write("1");
	}else{
		pw.write("2");
	}
}
/*
 * 删除宿舍
 */
public void deleteDormitory() throws IOException{
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	if(dormitoryService.deleteDormitory(dormitoryIDAll)){
		pw.write("1");
	}else{
		pw.write("2");
	}
}
/*
 * 分页查找宿舍信息
 */
public void getDormitoryListBysearchPage() throws IOException{
	System.out.println(dormitoryVO.toString());
	dormitoryVO = 	dormitoryService.getDormitoryListBysearchPage(dormitoryVO);
	System.out.println(dormitoryVO.toString());
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	 GsonBuilder gsonBuilder = new GsonBuilder();
 	 gsonBuilder.setPrettyPrinting();// 格式化json数据
 	 Gson gson = gsonBuilder.create();
 	 pw.write(gson.toJson(dormitoryVO));
}
/*
 * 根据id得到宿舍信息
 */
public void getDormitoryById() throws IOException{
	dormitory = dormitoryService.getDormitoryById(dormitory.getDormitory_id());
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	GsonBuilder gsonBuilder = new GsonBuilder();
 	 gsonBuilder.setPrettyPrinting();// 格式化json数据
 	 Gson gson = gsonBuilder.create();
 	 pw.write(gson.toJson(dormitory));
}
/**
 * 根据宿舍楼查询宿舍房间
 * @return
 * @throws IOException 
 */
public void getDormitoryByDormitoryBuildingName() throws IOException{
	List<ssglxt_dormitory> dormitoryList = dormitoryService.getDormitoryByDormitoryBuildingName(dormitory);
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	GsonBuilder gsonBuilder = new GsonBuilder();
	gsonBuilder.setPrettyPrinting();// 格式化json数据
	Gson gson = gsonBuilder.create();
 	pw.write(gson.toJson(dormitoryList));
}
/*
 * 跳转宿舍房间管理页面
 */
public String list_Dormitory(){
	return "list_Dormitory";
}
}
