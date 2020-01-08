package com.ssglxt.Super.service;

import com.ssglxt.domain.VO.LoginOroutVO;

public interface LoginOroutService {

public	LoginOroutVO login(LoginOroutVO loginOroutVO);//登录

public boolean updatePassword(String id,String rose, String oldPassword, String newPassword);//修改密码

}
