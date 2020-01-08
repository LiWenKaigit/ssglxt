package com.ssglxt.domain.VO;

public class LoginOroutVO {
private String username;//账号
private String password;//密码
private String role;//角色
private Object  obj;

public Object getObj() {
	return obj;
}
public void setObj(Object obj) {
	this.obj = obj;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
@Override
public String toString() {
	return "LoginOroutVO [username=" + username + ", password=" + password + ", role=" + role + "]";
}

}
