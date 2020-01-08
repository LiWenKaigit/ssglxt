package com.ssglxt.Super.dao;

import com.ssglxt.domain.DO.ssglxt_superAdmin;

public interface SuperAdminDao {

public	ssglxt_superAdmin getAdminById(String superAdmin_id);//根据id得到超级管理员的信息

public boolean updatePassword(ssglxt_superAdmin old_superAdmin);//修改密码

}
