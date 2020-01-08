package com.ssglxt.Super.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssglxt.Super.service.LoginOroutService;
import com.ssglxt.domain.DO.ssglxt_admin;
import com.ssglxt.domain.DO.ssglxt_student;
import com.ssglxt.domain.DO.ssglxt_superAdmin;
import com.ssglxt.domain.VO.LoginOroutVO;

public class LoginOroutAction extends ActionSupport {
private LoginOroutService loginOroutService;

private LoginOroutVO loginOroutVO;
private String id;
private String oldPassword;
private String newPassword;
private String rose;



public String getRose() {
	return rose;
}

public void setRose(String rose) {
	this.rose = rose;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getOldPassword() {
	return oldPassword;
}

public void setOldPassword(String oldPassword) {
	this.oldPassword = oldPassword;
}

public String getNewPassword() {
	return newPassword;
}

public void setNewPassword(String newPassword) {
	this.newPassword = newPassword;
}

public LoginOroutVO getLoginOroutVO() {
	return loginOroutVO;
}

public void setLoginOroutVO(LoginOroutVO loginOroutVO) {
	this.loginOroutVO = loginOroutVO;
}

public LoginOroutService getLoginOroutService() {
	return loginOroutService;
}

public void setLoginOroutService(LoginOroutService loginOroutService) {
	this.loginOroutService = loginOroutService;
}
/*
 * 登录
 */
public void login() throws IOException {
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	LoginOroutVO loginResult = loginOroutService.login(loginOroutVO);
	if (loginResult != null) {
		if(loginResult.getRole().equals("1")){
			ssglxt_student student =  (ssglxt_student) loginResult.getObj();
			String name =  student.getStudent_name();
			String id = student.getStudent_id();
			String rose = student.getStudent_role();
		
			ActionContext.getContext().getSession().put("loginResultName", name);
			ActionContext.getContext().getSession().put("loginResultRose", rose);
			//ActionContext.getContext().getSession().put("loginResultId", id);
		}
		if(loginResult.getRole().equals("2")){
			ssglxt_admin admin = (ssglxt_admin) loginResult.getObj();
			String name = admin.getAdmin_name();
			String rose = admin.getAdmin_role();
			ActionContext.getContext().getSession().put("loginResultName", name);
			ActionContext.getContext().getSession().put("loginResultRose", rose);
		}
		if(loginResult.getRole().equals("3")){
			ssglxt_superAdmin superAdmin = (ssglxt_superAdmin) loginResult.getObj();
			String name = superAdmin.getSuperAdmin_name();
			String rose = superAdmin.getSuperAdmin_role();
			ActionContext.getContext().getSession().put("loginResultName", name);
			ActionContext.getContext().getSession().put("loginResultRose", rose);
			System.out.println("rose"+rose);
		}
		ActionContext.getContext().getSession().put("loginResult", loginResult);
		System.out.println("aaaaa"+loginResult.toString());
		pw.write("1");
	} else {
		pw.write("2");
	}
}
/**
 * 
 * 登出
 * @return
 * @throws IOException 
 */
public void loginOut() throws IOException {
	System.out.println("ssssssaadafgghjhjk");
		ActionContext.getContext().getSession().remove("loginResult");
		ActionContext.getContext().getSession().remove("loginResultName");
		ActionContext.getContext().getSession().remove("loginResultRose");
}
/**
 * 修改密码
 * @return
 * @throws IOException 
 */
public void updatePassword() throws IOException{
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	if(loginOroutService.updatePassword(id,rose,oldPassword,newPassword)){
		pw.write("1");
	}else{
		pw.write("2");
	}
}
/*
 * 跳转到首页
 */
public String index() {
	System.out.println("dd");
	return "index";
}
}
 