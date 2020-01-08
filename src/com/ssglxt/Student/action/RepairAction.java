package com.ssglxt.Student.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.ssglxt.Student.service.RepairService;
import com.ssglxt.domain.DO.ssglxt_repair;
import com.ssglxt.domain.VO.RepairVO;

public class RepairAction extends ActionSupport {
private RepairService repairService;
private ssglxt_repair repair;
private String repairIDAll;
private RepairVO repairVO;


public RepairVO getRepairVO() {
	return repairVO;
}

public void setRepairVO(RepairVO repairVO) {
	this.repairVO = repairVO;
}

public String getRepairIDAll() {
	return repairIDAll;
}

public void setRepairIDAll(String repairIDAll) {
	this.repairIDAll = repairIDAll;
}

public ssglxt_repair getRepair() {
	return repair;
}

public void setRepair(ssglxt_repair repair) {
	this.repair = repair;
}

public RepairService getRepairService() {
	return repairService;
}

public void setRepairService(RepairService repairService) {
	this.repairService = repairService;
}
/*
 * 添加报修
 */
public void addRepair() throws IOException{
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	if(repairService.addRepair(repair)){
		pw.write("1");
	}else{
		pw.write("2");
	}
}
/*
 * 待维修物品信息
 */
public void getRepairOkListBysearchPage() throws IOException{
	repairService.getRepairOkListBysearchPage(repairVO);
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	 GsonBuilder gsonBuilder = new GsonBuilder();
 	 gsonBuilder.setPrettyPrinting();// 格式化json数据
 	 Gson gson = gsonBuilder.create();
 	 pw.write(gson.toJson(repairVO));
}
/*
 * 修改报修
 */
public void updateRepair() throws IOException{
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	if(repairService.updateRepair(repair)){
		pw.write("1");
	}else{
		pw.write("2");
	}
}
/*
 * 处理维修物品
 */
public void updateRepairChange() throws IOException{
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	if(repairService.updateRepairChange(repair.getRepair_id(),repair.getRepair_status())){
		pw.write("1");
	}else{
		pw.write("2");
	}
}
/*
 * 删除报修
 */
public void deleteRepair() throws IOException{
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	if(repairService.deleteRepair(repairIDAll)){
		pw.write("1");
	}else{
		pw.write("2");
	}
}
/*
 * 分页查找报修信息
 */
public void getRepairListBysearchPage() throws IOException{
	repairVO = repairService.getRepairListBysearchPage(repairVO);
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	 GsonBuilder gsonBuilder = new GsonBuilder();
 	 gsonBuilder.setPrettyPrinting();// 格式化json数据
 	 Gson gson = gsonBuilder.create();
 	 pw.write(gson.toJson(repairVO));
}
/*
 * 根据id得到报修信息
 */
public void getRepairById() throws IOException{
	repair = repairService.getRepairById(repair.getRepair_id());
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	GsonBuilder gsonBuilder = new GsonBuilder();
 	 gsonBuilder.setPrettyPrinting();// 格式化json数据
 	 Gson gson = gsonBuilder.create();
 	 pw.write(gson.toJson(repair));
}
/*
 * 跳转报修
 */
public String list_repair(){
	return "list_repair";
}
}
