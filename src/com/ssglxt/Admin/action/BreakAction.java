package com.ssglxt.Admin.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.ssglxt.domain.DO.ssglxt_break;
import com.ssglxt.domain.VO.BreakVO;
import com.ssgxlt.Admin.service.BreakService;

public class BreakAction extends ActionSupport {
private BreakService breakService;
private ssglxt_break Break;
private String breakIDAll;
private BreakVO breakVO;


public BreakVO getBreakVO() {
	return breakVO;
}

public void setBreakVO(BreakVO breakVO) {
	this.breakVO = breakVO;
}

public String getBreakIDAll() {
	return breakIDAll;
}

public void setBreakIDAll(String breakIDAll) {
	this.breakIDAll = breakIDAll;
}

public ssglxt_break getBreak() {
	return Break;
}

public void setBreak(ssglxt_break break1) {
	Break = break1;
}

public BreakService getBreakService() {
	return breakService;
}

public void setBreakService(BreakService breakService) {
	this.breakService = breakService;
}
/*
 * 违规登记
 */
public void addBreak() throws IOException{
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	if(breakService.addBreak(Break)){
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
	if(breakService.updateBreak(Break)){
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
	breakService.getBreakListBysearchPage(breakVO);
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
	Break = breakService.getBreakById(Break.getBreak_id());
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	GsonBuilder gsonBuilder = new GsonBuilder();
 	 gsonBuilder.setPrettyPrinting();// 格式化json数据
 	 Gson gson = gsonBuilder.create();
 	 pw.write(gson.toJson(Break));
}
/*
 * 跳转违规管理
 */
public String list_break(){
	return "list_break";
}
}
