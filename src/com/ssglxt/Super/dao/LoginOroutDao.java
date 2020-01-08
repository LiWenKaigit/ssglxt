package com.ssglxt.Super.dao;

import com.ssglxt.domain.VO.LoginOroutVO;

public interface LoginOroutDao {

public	LoginOroutVO login(LoginOroutVO loginOroutVO);//登录

public Boolean queryByPassword(String id,String rose,String oldPassword);//查找密码是否正确

public void updatePassword(String id,String rose, String newPassword);//修改密码

}
