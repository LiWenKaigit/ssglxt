package com.ssgxlt.Admin.service;

import com.ssglxt.domain.DO.ssglxt_admin;
import com.ssglxt.domain.VO.AdminVO;

public interface AdminService {

public 	boolean addAdmin(ssglxt_admin admin);//添加宿舍管理员

public boolean updateAdmin(ssglxt_admin admin);//修改宿舍管理员信息

public boolean deleteAdmin(String adminIDAll);//删除宿舍管理员

public void getAdminListBysearchPage(AdminVO adminVO);//分页查找宿舍管理员信息

public ssglxt_admin getAdminById(String admin_id);//根据id得到宿舍管理员信息

}
