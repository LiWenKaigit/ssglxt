package com.ssglxt.Super.dao;

import com.ssglxt.domain.DO.ssglxt_dormitoryBuilding;
import com.ssglxt.domain.VO.DormitoryBuildingVO;

public interface DormitoryBuildingDao {

public	boolean addDormitoryBuilding(ssglxt_dormitoryBuilding dormitoryBuilding);//添加宿舍楼

public boolean updateDormitoryBuilding(ssglxt_dormitoryBuilding dormitoryBuilding);//修改宿舍楼信息

public void deleteDormitoryBuilding(String dormitoryBuilding_id);//删除宿舍楼信息

public int getCountDormitoryBuildingList(DormitoryBuildingVO dormitoryBuildingVO);

public void getDormitoryBuildingListByPage(DormitoryBuildingVO dormitoryBuildingVO);

public ssglxt_dormitoryBuilding getDormitoryBuildingById(String dormitoryBuilding_id);//根据id得到宿舍楼信息

}
