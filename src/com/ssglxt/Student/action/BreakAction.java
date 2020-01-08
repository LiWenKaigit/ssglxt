package com.ssglxt.Student.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.ssglxt.Student.service.BreakService;
import com.ssglxt.domain.DO.ssglxt_break;
import com.ssglxt.domain.VO.BreakVO;

public class BreakAction extends ActionSupport {
private BreakService breakService;
private ssglxt_break break1;
private String breakIDAll;
private BreakVO breakVO;

public BreakService getBreakService() {
	return breakService;
}

public void setBreakService(BreakService breakService) {
	this.breakService = breakService;
}



public ssglxt_break getBreak1() {
	return break1;
}

public void setBreak1(ssglxt_break break1) {
	this.break1 = break1;
}

public String getBreakIDAll() {
	return breakIDAll;
}

public void setBreakIDAll(String breakIDAll) {
	this.breakIDAll = breakIDAll;
}

public BreakVO getBreakVO() {
	return breakVO;
}

public void setBreakVO(BreakVO breakVO) {
	this.breakVO = breakVO;
}
/*
 * 违规登记
 */
public void addBreak() throws IOException{
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	if(breakService.addBreak(break1)){
		pw.write("1");
	}else{
		pw.write("2");
	}
}
/*
 * 修改违规
 */
public void updateBreak() throws IOException{
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	if(breakService.updateBreak(break1)){
		pw.write("1");
	}else{
		pw.write("2");
	}
}
/*
 * 删除违规
 */
public void deleteBreak() throws IOException{
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	if(breakService.deleteBreak(breakIDAll)){
		pw.write("1");
	}else{
		pw.write("2");
	}
}
/*
 * 分页查找违规信息
 */
public void getBreakListBysearchPage() throws IOException{
	breakVO = breakService.getBreakListBysearchPage(breakVO);
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	 GsonBuilder gsonBuilder = new GsonBuilder();
 	 gsonBuilder.setPrettyPrinting();// 格式化json数据
 	 Gson gson = gsonBuilder.create();
 	 pw.write(gson.toJson(breakVO));
}
/*
 * 根据id得到违规信息
 */
public void getBreakById() throws IOException{
	break1 = breakService.getBreakById(break1.getBreak_id());
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	GsonBuilder gsonBuilder = new GsonBuilder();
 	 gsonBuilder.setPrettyPrinting();// 格式化json数据
 	 Gson gson = gsonBuilder.create();
 	 pw.write(gson.toJson(break1));
}
/**
 * 得到单个学生的所有违规记录
 * @throws IOException 
 */
public void getstudentonebreakAll() throws IOException{
	System.out.println("进来了那你");
	breakVO =  breakService.getstudentonebreakAll(break1.getBreak_studentId());
	System.out.println("ssss"+break1.getBreak_studentId());
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	GsonBuilder gsonBuilder = new GsonBuilder();
 	 gsonBuilder.setPrettyPrinting();// 格式化json数据
 	 Gson gson = gsonBuilder.create();
 	 pw.write(gson.toJson(breakVO));
}
}
