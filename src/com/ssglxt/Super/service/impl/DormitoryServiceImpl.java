package com.ssglxt.Super.service.impl;

import java.util.List;

import com.ssglxt.Super.dao.DormitoryDao;
import com.ssglxt.Super.service.DormitoryService;
import com.ssglxt.domain.DO.ssglxt_dormitory;
import com.ssglxt.domain.VO.DormitoryVO;

import util.TeamUtil;

public class DormitoryServiceImpl implements DormitoryService {
private DormitoryDao dormitoryDao;

public DormitoryDao getDormitoryDao() {
	return dormitoryDao;
}

public void setDormitoryDao(DormitoryDao dormitoryDao) {
	this.dormitoryDao = dormitoryDao;
}
/*
 * (non-Javadoc)添加宿舍
 * @see com.ssglxt.Super.service.DormitoryService#addDormitory(com.ssglxt.domain.DO.ssglxt_dormitory)
 */
@Override
public boolean addDormitory(ssglxt_dormitory dormitory) {
	dormitory.setDormitory_id(TeamUtil.getUuid());
	String time = TeamUtil.getStringSecond();
	dormitory.setDormitory_creat_time(time);
	dormitory.setDormitory_modify_time(time);
	if(dormitoryDao.addDormitory(dormitory)){
		return true;
	}else{
		return false;
	}
}
/*
 * (non-Javadoc)修改宿舍
 * @see com.ssglxt.Super.service.DormitoryService#updateDormitory(com.ssglxt.domain.DO.ssglxt_dormitory)
 */
@Override
public boolean updateDormitory(ssglxt_dormitory dormitory) {
	ssglxt_dormitory oldssglxt_dormitory =  getDormitoryById(dormitory.getDormitory_id());
	dormitory.setDormitory_creat_time(oldssglxt_dormitory.getDormitory_creat_time());
	String time = TeamUtil.getStringSecond();
	dormitory.setDormitory_modify_time(time);
	if(dormitoryDao.updateDormitory(dormitory)){
		return true;
	}else{
		return false;
	}
}
/*
 * (non-Javadoc)删除宿舍
 * @see com.ssglxt.Super.service.DormitoryService#deleteDormitory(java.lang.String)
 */
@Override
public boolean deleteDormitory(String dormitoryIDAll) {
	String[] arr = dormitoryIDAll.split(",");
	for(String dormitory_id : arr){
		dormitoryDao.deleteDormitory(dormitory_id);
	}
	return true;
}
/*
 * (non-Javadoc)分页查找宿舍信息
 * @see com.ssglxt.Super.service.DormitoryService#getDormitoryListBysearchPage(com.ssglxt.domain.VO.DormitoryVO)
 */
@Override
public DormitoryVO getDormitoryListBysearchPage(DormitoryVO dormitoryVO) {
	int count = dormitoryDao.getCountDormitoryList(dormitoryVO);
	dormitoryVO.setTotalRecords(count);
	System.out.println(dormitoryVO.getPageIndex());
	dormitoryVO.setTotalPages(((count - 1) / dormitoryVO.getPageSize()) + 1);
	if (dormitoryVO.getPageIndex() <= 1) {
		dormitoryVO.setHavePrePage(false);
	} else {
		dormitoryVO.setHavePrePage(true);
	}
	if (dormitoryVO.getPageIndex() >= dormitoryVO.getTotalPages()) {
		dormitoryVO.setHaveNextPage(false);
	} else {
		dormitoryVO.setHaveNextPage(true);
	}

	//keywordVO.setTotalCount(count);
	//keywordVO.setPageSize(10);
	//keywordVO.setTotalPage((int) Math.ceil((double) count / keywordVO.getPageSize()));
	//dormitoryDao.getDormitoryListByPage(dormitoryVO);
	return dormitoryDao.getDormitoryListByPage(dormitoryVO);
}
/*
 * (non-Javadoc)根据id得到宿舍信息
 * @see com.ssglxt.Super.service.DormitoryService#getDormitoryById(java.lang.String)
 */
@Override
public ssglxt_dormitory getDormitoryById(String dormitory_id) {
	return dormitoryDao.getDormitoryById(dormitory_id);
}

@Override
public List<ssglxt_dormitory> getDormitoryByDormitoryBuildingName(ssglxt_dormitory dormitory) {
	return dormitoryDao.getDormitoryByDormitoryBuildingName(dormitory);
}
}
