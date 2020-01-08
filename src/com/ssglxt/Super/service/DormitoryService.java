package com.ssglxt.Super.service;

import java.util.List;

import com.ssglxt.domain.DO.ssglxt_dormitory;
import com.ssglxt.domain.VO.DormitoryVO;

public interface DormitoryService {

public	boolean addDormitory(ssglxt_dormitory dormitory);//添加宿舍

public boolean updateDormitory(ssglxt_dormitory dormitory);//修改宿舍

public boolean deleteDormitory(String dormitoryIDAll);//删除宿舍

public DormitoryVO getDormitoryListBysearchPage(DormitoryVO dormitoryVO);//分页查找宿舍信息

public ssglxt_dormitory getDormitoryById(String dormitory_id);//根据id得到宿舍信息

public List<ssglxt_dormitory> getDormitoryByDormitoryBuildingName(ssglxt_dormitory dormitory);//根据宿舍楼查询宿舍房间


}
