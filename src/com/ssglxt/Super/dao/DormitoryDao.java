package com.ssglxt.Super.dao;

import java.util.List;

import com.ssglxt.domain.DO.ssglxt_dormitory;
import com.ssglxt.domain.VO.DormitoryVO;

public interface DormitoryDao {

public	boolean addDormitory(ssglxt_dormitory dormitory);//添加宿舍

public boolean updateDormitory(ssglxt_dormitory dormitory);//修改宿舍

public void deleteDormitory(String dormitory_id);//删除宿舍

public int getCountDormitoryList(DormitoryVO dormitoryVO);

public DormitoryVO getDormitoryListByPage(DormitoryVO dormitoryVO);

public ssglxt_dormitory getDormitoryById(String dormitory_id);//根据id得到宿舍信息

public List<ssglxt_dormitory> getDormitoryByDormitoryBuildingName(ssglxt_dormitory dormitory);//根据宿舍楼查询宿舍房间

}
