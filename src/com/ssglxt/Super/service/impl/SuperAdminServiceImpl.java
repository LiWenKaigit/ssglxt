package com.ssglxt.Super.service.impl;

import com.ssglxt.Super.dao.SuperAdminDao;
import com.ssglxt.Super.service.SuperAdminService;
import com.ssglxt.domain.DO.ssglxt_superAdmin;

import util.TeamUtil;

public class SuperAdminServiceImpl implements SuperAdminService {
private  SuperAdminDao superAdminDao;

public SuperAdminDao getSuperAdminDao() {
	return superAdminDao;
}

public void setSuperAdminDao(SuperAdminDao superAdminDao) {
	this.superAdminDao = superAdminDao;
}
/*
 * (non-Javadoc)修改密码
 * @see com.ssglxt.Super.service.SuperAdminService#updatePassword(com.ssglxt.domain.DO.ssglxt_superAdmin)
 */

public boolean updatePassword(ssglxt_superAdmin superAdmin) {
	ssglxt_superAdmin old_superAdmin = superAdminDao.getAdminById(superAdmin.getSuperAdmin_id());
	old_superAdmin.setSuperAdmin_password(superAdmin.getSuperAdmin_password());
	String time = TeamUtil.getStringSecond();
	old_superAdmin.setSuperAdmin_modify_time(time);
	return superAdminDao.updatePassword(old_superAdmin);
}

}
