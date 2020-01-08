package com.ssglxt.Super.service.impl;

import com.ssglxt.Super.dao.DormitoryBuildingDao;
import com.ssglxt.Super.service.DormitoryBuildingService;
import com.ssglxt.domain.DO.ssglxt_dormitoryBuilding;
import com.ssglxt.domain.VO.DormitoryBuildingVO;

import util.TeamUtil;

public class DormitoryBuildingServiceImpl implements DormitoryBuildingService {
private DormitoryBuildingDao dormitoryBuildingDao;

public DormitoryBuildingDao getDormitoryBuildingDao() {
	return dormitoryBuildingDao;
}

public void setDormitoryBuildingDao(DormitoryBuildingDao dormitoryBuildingDao) {
	this.dormitoryBuildingDao = dormitoryBuildingDao;
}
/*
 * (non-Javadoc)添加宿舍楼
 * @see com.ssglxt.Super.service.DormitoryBuildingService#addDormitoryBuilding(com.ssglxt.domain.DO.ssglxt_dormitoryBuilding)
 */
@Override
public boolean addDormitoryBuilding(ssglxt_dormitoryBuilding dormitoryBuilding) {
	// TODO Auto-generated method stub
	dormitoryBuilding.setDormitoryBuilding_id(TeamUtil.getUuid());
	String time = TeamUtil.getStringSecond();
	dormitoryBuilding.setDormitoryBuilding_creat_time(time);
	dormitoryBuilding.setDormitoryBuilding_modify_time(time);
	if(dormitoryBuildingDao.addDormitoryBuilding(dormitoryBuilding)){
		return true;
	}else{
		return false;
	}
}
/*
 * (non-Javadoc)修改宿舍楼信息
 * @see com.ssglxt.Super.service.DormitoryBuildingService#updateDormitoryBuilding(com.ssglxt.domain.DO.ssglxt_dormitoryBuilding)
 */
@Override
public boolean updateDormitoryBuilding(ssglxt_dormitoryBuilding dormitoryBuilding) {
	ssglxt_dormitoryBuilding oldssglxt_dormitoryBuilding =  getDormitoryBuildingById(dormitoryBuilding.getDormitoryBuilding_id());
	dormitoryBuilding.setDormitoryBuilding_creat_time(oldssglxt_dormitoryBuilding.getDormitoryBuilding_creat_time());
	String time = TeamUtil.getStringSecond();
	dormitoryBuilding.setDormitoryBuilding_modify_time(time);
	if(dormitoryBuildingDao.updateDormitoryBuilding(dormitoryBuilding)){
		return true;
	}else{
		return false;
	}
}
/*
 * (non-Javadoc)删除宿舍楼信息
 * @see com.ssglxt.Super.service.DormitoryBuildingService#deleteKeyword(java.lang.String)
 */
@Override
public boolean deleteDormitoryBuilding(String dormitoryBuildingAll) {
	String[] arr = dormitoryBuildingAll.split(",");
	for(String dormitoryBuilding_id : arr){
		dormitoryBuildingDao.deleteDormitoryBuilding(dormitoryBuilding_id);
	}
	return true;
}
/*
 * (non-Javadoc)分页查找宿舍楼信息
 * @see com.ssglxt.Super.service.DormitoryBuildingService#getDormitoryBuildingListBysearchPage(com.ssglxt.domain.VO.DormitoryBuildingVO)
 */
@Override
public void getDormitoryBuildingListBysearchPage(DormitoryBuildingVO dormitoryBuildingVO) {
	// TODO Auto-generated method stub
	int count = dormitoryBuildingDao.getCountDormitoryBuildingList(dormitoryBuildingVO);
	//keywordVO.setTotalCount(count);
	//keywordVO.setPageSize(10);
	//keywordVO.setTotalPage((int) Math.ceil((double) count / keywordVO.getPageSize()));
	dormitoryBuildingDao.getDormitoryBuildingListByPage(dormitoryBuildingVO);
}
/*
 * (non-Javadoc)根据id得到宿舍楼信息
 * @see com.ssglxt.Super.service.DormitoryBuildingService#getDormitoryBuildingById(java.lang.String)
 */
@Override
public ssglxt_dormitoryBuilding getDormitoryBuildingById(String dormitoryBuilding_id) {
	// TODO Auto-generated method stub
	return dormitoryBuildingDao.getDormitoryBuildingById(dormitoryBuilding_id);
}

}
