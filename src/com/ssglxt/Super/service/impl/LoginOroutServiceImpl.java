package com.ssglxt.Super.service.impl;

import org.hibernate.Session;

import com.ssglxt.Super.dao.LoginOroutDao;
import com.ssglxt.Super.service.LoginOroutService;
import com.ssglxt.domain.VO.LoginOroutVO;

public class LoginOroutServiceImpl implements LoginOroutService {
private LoginOroutDao loginOroutDao;

public LoginOroutDao getLoginOroutDao() {
	return loginOroutDao;
}

public void setLoginOroutDao(LoginOroutDao loginOroutDao) {
	this.loginOroutDao = loginOroutDao;
}
/*
 * (non-Javadoc)登录
 * @see com.ssglxt.Super.service.LoginOroutService#login(com.ssglxt.domain.VO.LoginOroutVO)
 */
@Override
public LoginOroutVO login(LoginOroutVO loginOroutVO) {
	// TODO Auto-generated method stub
	if (loginOroutVO.getUsername() == null || loginOroutVO.getPassword() == null || loginOroutVO.getRole() == null
			|| "".equals(loginOroutVO.getUsername()) || "".equals(loginOroutVO.getPassword()) || "".equals(loginOroutVO.getRole())) {
		return null;
	} else {
		System.out.println("用户名："+loginOroutVO.getUsername()+"密码："+loginOroutVO.getPassword()+"身份："+loginOroutVO.getRole());
		LoginOroutVO findResult = loginOroutDao.login(loginOroutVO);
		return findResult;
	}
}

@Override
	public boolean updatePassword(String id, String rose, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub

		if (loginOroutDao.queryByPassword(id, rose, oldPassword)) {
			loginOroutDao.updatePassword(id, rose, newPassword);
			return true;
		}
		return false;
	}

}
