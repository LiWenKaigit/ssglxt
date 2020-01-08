package com.ssgxlt.Admin.service.impl;

import com.ssglxt.Admin.dao.AdminDao;
import com.ssglxt.domain.DO.ssglxt_admin;
import com.ssglxt.domain.VO.AdminVO;
import com.ssgxlt.Admin.service.AdminService;

import util.TeamUtil;

public class AdminServiceImpl implements AdminService {
private AdminDao adminDao;

public AdminDao getAdminDao() {
	return adminDao;
}

public void setAdminDao(AdminDao adminDao) {
	this.adminDao = adminDao;
}
/*
 * (non-Javadoc)添加宿舍管理员
 * @see com.ssgxlt.Admin.service.AdminService#addAdmin(com.ssglxt.domain.DO.ssglxt_admin)
 */
@Override
public boolean addAdmin(ssglxt_admin admin) {
	admin.setAdmin_id(TeamUtil.getUuid());
	String time = TeamUtil.getStringSecond();
	admin.setAdmin_creat_time(time);
	admin.setAdmin_modify_time(time);
	if(adminDao.addAdmin(admin)){
		return true;
	}else{
		return false;
	}
}
/*
 * (non-Javadoc)修改宿舍管理员
 * @see com.ssgxlt.Admin.service.AdminService#updateAdmin(com.ssglxt.domain.DO.ssglxt_admin)
 */
@Override
public boolean updateAdmin(ssglxt_admin admin) {
	String time = TeamUtil.getStringSecond();
	admin.setAdmin_modify_time(time);
	if(adminDao.updateAdmin(admin)){
		return true;
	}else{
		return false;
	}
}
/*
 * (non-Javadoc)删除宿舍管理员
 * @see com.ssgxlt.Admin.service.AdminService#deleteAdmin(java.lang.String)
 */
@Override
public boolean deleteAdmin(String adminIDAll) {
	String[] arr = adminIDAll.split(",");
	for(String admin_id : arr){
		adminDao.deleteAdmin(admin_id);
	}
	return true;
}
/*
 * (non-Javadoc)分页查找宿舍管理员信息
 * @see com.ssgxlt.Admin.service.AdminService#getAdminListBysearchPage(com.ssglxt.domain.VO.AdminVO)
 */
@Override
public void getAdminListBysearchPage(AdminVO adminVO) {
	System.out.println("进入了service");
	//int count = adminDao.getCountAdminList(adminVO);
	//keywordVO.setTotalCount(count);
	//keywordVO.setPageSize(10);
	//keywordVO.setTotalPage((int) Math.ceil((double) count / keywordVO.getPageSize()));
	adminDao.getAdminListByPage(adminVO);
	
}
/*
 * (non-Javadoc)根据id得到宿舍管理员信息
 * @see com.ssgxlt.Admin.service.AdminService#getAdminById(java.lang.String)
 */
@Override
public ssglxt_admin getAdminById(String admin_id) {
	return adminDao.getAdminById(admin_id);
}

}
