package com.ssglxt.Super.service.impl;

import com.ssglxt.Super.dao.AdminDao;
import com.ssglxt.Super.service.AdminService;
import com.ssglxt.domain.DO.ssglxt_admin;
import com.ssglxt.domain.VO.AdminVO;

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
 * (non-Javadoc)分页查找宿舍管理员
 * @see com.ssglxt.Super.service.AdminService#getAdminListBysearchPage(com.ssglxt.domain.VO.AdminVO)
 */
@Override
public void getAdminListBysearchPage(AdminVO adminVO) {
	    int count = adminDao.getCountAdminList(adminVO);
		//keywordVO.setTotalCount(count);
		//keywordVO.setPageSize(10);
		//keywordVO.setTotalPage((int) Math.ceil((double) count / keywordVO.getPageSize()));
		adminDao.getAdminListByPage(adminVO);
	
}
/*
 * (non-Javadoc)添加宿舍管理员
 * @see com.ssglxt.Super.service.AdminService#addAdmin(com.ssglxt.domain.DO.ssglxt_admin)
 */
@Override
public boolean addAdmin(ssglxt_admin admin) {
	admin.setAdmin_id(TeamUtil.getUuid());
	String time = TeamUtil.getStringSecond();
	admin.setAdmin_password("000000");
	admin.setAdmin_role("2");
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
 * @see com.ssglxt.Super.service.AdminService#updateAdmin(com.ssglxt.domain.DO.ssglxt_admin)
 */
@Override
public boolean updateAdmin(ssglxt_admin admin) {
	ssglxt_admin oldssglxt_admin =  getAdminById(admin.getAdmin_id());
	admin.setAdmin_creat_time(oldssglxt_admin.getAdmin_creat_time());
	admin.setAdmin_password(oldssglxt_admin.getAdmin_password());
	admin.setAdmin_role(oldssglxt_admin.getAdmin_role());
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
 * @see com.ssglxt.Super.service.AdminService#deleteAdmin(java.lang.String)
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
 * (non-Javadoc)根据id 得到宿舍管理员的信息
 * @see com.ssglxt.Super.service.AdminService#getAdminById(java.lang.String)
 */
@Override
public ssglxt_admin getAdminById(String admin_id) {
	return adminDao.getAdminById(admin_id);
}

}
