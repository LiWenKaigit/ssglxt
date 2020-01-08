package com.ssglxt.Super.dao;

import com.ssglxt.domain.DO.ssglxt_admin;
import com.ssglxt.domain.VO.AdminVO;

public interface AdminDao {

public	int getCountAdminList(AdminVO adminVO);

public void getAdminListByPage(AdminVO adminVO);

public boolean addAdmin(ssglxt_admin admin);//添加宿舍管理员

public boolean updateAdmin(ssglxt_admin admin);//修改宿舍管理员

public void deleteAdmin(String admin_id);//删除宿舍管理员

public ssglxt_admin getAdminById(String admin_id);//根据id得到宿舍管理员的信息

}
