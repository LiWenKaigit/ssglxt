package com.ssglxt.Admin.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.ssglxt.domain.DO.ssglxt_admin;
import com.ssglxt.domain.VO.AdminVO;
import com.ssgxlt.Admin.service.AdminService;

public class AdminAction extends ActionSupport {
private AdminService adminService;
private ssglxt_admin admin;
private String adminIDAll;
private AdminVO adminVO;


public AdminVO getAdminVO() {
	return adminVO;
}

public void setAdminVO(AdminVO adminVO) {
	this.adminVO = adminVO;
}

public String getAdminIDAll() {
	return adminIDAll;
}

public void setAdminIDAll(String adminIDAll) {
	this.adminIDAll = adminIDAll;
}

public ssglxt_admin getAdmin() {
	return admin;
}

public void setAdmin(ssglxt_admin admin) {
	this.admin = admin;
}

public AdminService getAdminService() {
	return adminService;
}

public void setAdminService(AdminService adminService) {
	this.adminService = adminService;
}
/*
 * 添加宿舍管理员	
 */
public void addAdmin() throws IOException{
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	if(adminService.addAdmin(admin)){
		pw.write("1");
	}else{
		pw.write("2");
	}
}
/*
 * 修改宿舍管理员信息
 */
public void updateAdmin() throws IOException{
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	if(adminService.updateAdmin(admin)){
		pw.write("1");
	}else{
		pw.write("2");
	}
}
/*
 * 删除宿舍管理员
 */
public void deleteAdmin() throws IOException{
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	if(adminService.deleteAdmin(adminIDAll)){
		pw.write("1");
	}else{
		pw.write("2");
	}
}
/*
 * 分页查找宿舍管理员
 */
public void getAdminListBysearchPage() throws IOException{
	System.out.println("进入了action");
	adminService.getAdminListBysearchPage(adminVO);
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	 GsonBuilder gsonBuilder = new GsonBuilder();
 	 gsonBuilder.setPrettyPrinting();// 格式化json数据
 	 Gson gson = gsonBuilder.create();
 	 pw.write(gson.toJson(adminVO));
}
/*
 * 根据id得到宿舍管理员信息
 */
public void getAdminById() throws IOException{
	admin = adminService.getAdminById(admin.getAdmin_id());
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	GsonBuilder gsonBuilder = new GsonBuilder();
 	 gsonBuilder.setPrettyPrinting();// 格式化json数据
 	 Gson gson = gsonBuilder.create();
 	 pw.write(gson.toJson(admin));
}
/*
 * 跳转宿舍管理员管理
 */
public String  list_admin(){
	return "list_admin";
}
}
