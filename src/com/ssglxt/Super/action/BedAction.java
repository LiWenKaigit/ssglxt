package com.ssglxt.Super.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.ssglxt.Super.service.BedService;
import com.ssglxt.domain.DO.ssglxt_bed;
import com.ssglxt.domain.VO.BedVO;

public class BedAction extends ActionSupport {
private BedService bedService;
private ssglxt_bed bed;
private String bedIDAll;
private BedVO bedVO;


public BedVO getBedVO() {
	return bedVO;
}

public void setBedVO(BedVO bedVO) {
	this.bedVO = bedVO;
}

public String getBedIDAll() {
	return bedIDAll;
}

public void setBedIDAll(String bedIDAll) {
	this.bedIDAll = bedIDAll;
}

public ssglxt_bed getBed() {
	return bed;
}

public void setBed(ssglxt_bed bed) {
	this.bed = bed;
}

public BedService getBedService() {
	return bedService;
}

public void setBedService(BedService bedService) {
	this.bedService = bedService;
}
/*
 * 添加床位
 */
public void addBed() throws IOException{
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	if(bedService.addBed(bed)){
		pw.write("1");
	}else{
		pw.write("2");
	}
}
/*
 * 修改床位信息
 */
public void updateBed() throws IOException{
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	if(bedService.updateBed(bed)){
		pw.write("1");
	}else{
		pw.write("2");
	}
}
/*
 * 删除床位
 */
public void deleteBed() throws IOException{
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	if(bedService.deleteBed(bedIDAll)){
		pw.write("1");
	}else{
		pw.write("2");
	}
}
/*
 * 分页查找床位
 */
public void getBedListBysearchPage() throws IOException{
	bedVO = bedService.getBedListBysearchPage(bedVO);
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	 GsonBuilder gsonBuilder = new GsonBuilder();
 	 gsonBuilder.setPrettyPrinting();// 格式化json数据
 	 Gson gson = gsonBuilder.create();
 	 pw.write(gson.toJson(bedVO));
}
/*
 * 根据id得到关键词信息
 */
public void getBedById() throws IOException{
	bed = bedService.getBedById(bed.getBed_id());
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	GsonBuilder gsonBuilder = new GsonBuilder();
 	 gsonBuilder.setPrettyPrinting();// 格式化json数据
 	 Gson gson = gsonBuilder.create();
 	 pw.write(gson.toJson(bed));
}
/**
 * 根据宿舍楼和宿舍房间得到床位
 * @return
 * @throws IOException 
 */
public void getBedByDormitoryAndDormitoryBuilding() throws IOException{
	List<ssglxt_bed> bedList = bedService.getBedByDormitoryAndDormitoryBuilding(bed);
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	GsonBuilder gsonBuilder = new GsonBuilder();
 	 gsonBuilder.setPrettyPrinting();// 格式化json数据
 	 Gson gson = gsonBuilder.create();
 	 pw.write(gson.toJson(bedList));
}
/*
 * 跳转床位管理
 */
public String  list_bed(){
	return "list_bed";
}
}
