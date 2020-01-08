package com.ssglxt.Super.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.ssglxt.Super.service.SuperAdminService;
import com.ssglxt.domain.DO.ssglxt_superAdmin;

public class SuperAdminAction extends ActionSupport {
private SuperAdminService superAdminService;
private ssglxt_superAdmin superAdmin;


public ssglxt_superAdmin getSuperAdmin() {
	return superAdmin;
}

public void setSuperAdmin(ssglxt_superAdmin superAdmin) {
	this.superAdmin = superAdmin;
}

public SuperAdminService getSuperAdminService() {
	return superAdminService;
}

public void setSuperAdminService(SuperAdminService superAdminService) {
	this.superAdminService = superAdminService;
}
/*
 * 修改密码
 */
public  void updatePassword() throws IOException{
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	if(superAdminService.updatePassword(superAdmin)){
		pw.write("1");
	}else{
		pw.write("2");
	}
}
}
