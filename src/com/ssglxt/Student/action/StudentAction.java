package com.ssglxt.Student.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.ssglxt.Student.service.StudentService;
import com.ssglxt.domain.DO.ssglxt_student;
import com.ssglxt.domain.VO.StudentVO;

public class StudentAction extends ActionSupport {
private StudentService studentService;
private ssglxt_student student;
private String studentIDAll;
private StudentVO studentVO;


public StudentVO getStudentVO() {
	return studentVO;
}

public void setStudentVO(StudentVO studentVO) {
	this.studentVO = studentVO;
}

public String getStudentIDAll() {
	return studentIDAll;
}

public void setStudentIDAll(String studentIDAll) {
	this.studentIDAll = studentIDAll;
}

public ssglxt_student getStudent() {
	return student;
}

public void setStudent(ssglxt_student student) {
	this.student = student;
}

public StudentService getStudentService() {
	return studentService;
}

public void setStudentService(StudentService studentService) {
	this.studentService = studentService;
}

/*
 * 学生入住登记
 */
public void addStudent() throws IOException{
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	if(studentService.addStudent(student)){
		pw.write("1");
	}else{
		pw.write("2");
	}
}
/*
 * 修改学生信息
 */
public void updateStudent() throws IOException{
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	if(studentService.updateStudent(student)){
		pw.write("1");
	}else{
		pw.write("2");
	}
}
/*
 * 删除学生信息
 */
public void deleteStudent() throws IOException{
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	if(studentService.deleteStudent(studentIDAll)){
		pw.write("1");
	}else{
		pw.write("2");
	}
}
/*
 * 分页查找学生信息
 */
public void getStudentListBysearchPage() throws IOException{
	studentVO = studentService.getStudentListBysearchPage(studentVO);
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	 GsonBuilder gsonBuilder = new GsonBuilder();
 	 gsonBuilder.setPrettyPrinting();// 格式化json数据
 	 Gson gson = gsonBuilder.create();
 	 pw.write(gson.toJson(studentVO));
}
/*
 * 根据id得到学生信息
 */
public void getStudentById() throws IOException{
	student = studentService.getStudentById(student.getStudent_id());
	System.out.println("aaaaa"+student.toString());
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	GsonBuilder gsonBuilder = new GsonBuilder();
 	 gsonBuilder.setPrettyPrinting();// 格式化json数据
 	 Gson gson = gsonBuilder.create();
 	 pw.write(gson.toJson(student));
}
/*
 * 跳转学生管理页面
 */
public String list_student(){
	return "list_studnet";
}
}
