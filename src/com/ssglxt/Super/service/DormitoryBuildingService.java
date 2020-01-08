package com.ssglxt.Super.service;

import com.ssglxt.domain.DO.ssglxt_dormitoryBuilding;
import com.ssglxt.domain.VO.DormitoryBuildingVO;

public interface DormitoryBuildingService {

public	boolean addDormitoryBuilding(ssglxt_dormitoryBuilding dormitoryBuilding);//添加宿舍楼

public boolean updateDormitoryBuilding(ssglxt_dormitoryBuilding dormitoryBuilding);//修改宿舍楼信息

public boolean deleteDormitoryBuilding(String dormitoryBuildingAll);//删除宿舍楼信息

public void getDormitoryBuildingListBysearchPage(DormitoryBuildingVO dormitoryBuildingVO);//分页查找宿舍楼信息

public ssglxt_dormitoryBuilding getDormitoryBuildingById(String dormitoryBuilding_id);//根据id得到宿舍楼信息

}
