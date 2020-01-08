package com.ssglxt.Student.service.impl;

import com.ssglxt.Student.service.RepairService;
import com.ssglxt.domain.DO.ssglxt_repair;
import com.ssglxt.domain.VO.RepairVO;
import com.ssgxlt.Student.dao.RepairDao;

import util.TeamUtil;

public class RepairServiceImpl implements RepairService {
private RepairDao repairDao;

public RepairDao getRepairDao() {
	return repairDao;
}

public void setRepairDao(RepairDao repairDao) {
	this.repairDao = repairDao;
}
/*
 * (non-Javadoc)添加报修
 * @see com.ssglxt.Student.service.RepairService#addRepair(com.ssglxt.domain.DO.ssglxt_repair)
 */
@Override
public boolean addRepair(ssglxt_repair repair) {
	repair.setRepair_id(TeamUtil.getUuid());
	String time = TeamUtil.getStringSecond();
	repair.setRepair_status("待处理");
	repair.setRepair_creat_time(time);
	repair.setRepair_modify_time(time);
	if(repairDao.addRepair(repair)){
		return true;
	}else{
		return false;
	}
}
/*
 * (non-Javadoc)修改报修
 * @see com.ssglxt.Student.service.RepairService#updateRepair(com.ssglxt.domain.DO.ssglxt_repair)
 */
@Override
public boolean updateRepair(ssglxt_repair repair) {
	ssglxt_repair oldssglxt_repair =  getRepairById(repair.getRepair_id());
	repair.setRepair_creat_time(oldssglxt_repair.getRepair_creat_time());
	String time = TeamUtil.getStringSecond();
	repair.setRepair_modify_time(time);
	if(repairDao.updateRepair(repair)){
		return true;
	}else{
		return false;
	}
}
/*
 * (non-Javadoc)删除报修
 * @see com.ssglxt.Student.service.RepairService#deleteRepair(java.lang.String)
 */
@Override
public boolean deleteRepair(String repairIDAll) {
	String[] arr = repairIDAll.split(",");
	for(String repair_id : arr){
		repairDao.deleteRepair(repair_id);
	}
	return true;
}
/*
 * (non-Javadoc)分页查找报修信息
 * @see com.ssglxt.Student.service.RepairService#getRepairListBysearchPage(com.ssglxt.domain.VO.RepairVO)
 */
@Override
public RepairVO getRepairListBysearchPage(RepairVO repairVO) {
	int count = repairDao.getCountRepairList(repairVO);
	repairVO.setTotalRecords(count);
	System.out.println(repairVO.getPageIndex());
	repairVO.setTotalPages(((count - 1) / repairVO.getPageSize()) + 1);
	if (repairVO.getPageIndex() <= 1) {
		repairVO.setHavePrePage(false);
	} else {
		repairVO.setHavePrePage(true);
	}
	if (repairVO.getPageIndex() >= repairVO.getTotalPages()) {
		repairVO.setHaveNextPage(false);
	} else {
		repairVO.setHaveNextPage(true);
	}
	//keywordVO.setTotalCount(count);
	//keywordVO.setPageSize(10);
	//keywordVO.setTotalPage((int) Math.ceil((double) count / keywordVO.getPageSize()));
	return repairDao.getRepairListByPage(repairVO);
	
}
/*
 * (non-Javadoc)根据id得到报修信息
 * @see com.ssglxt.Student.service.RepairService#getRepairById(java.lang.String)
 */
@Override
public ssglxt_repair getRepairById(String repair_id) {
	return repairDao.getRepairById(repair_id);
}
/*
 * (non-Javadoc)得到已维修的物品信息
 * @see com.ssglxt.Student.service.RepairService#getRepairOkListBysearchPage(com.ssglxt.domain.VO.RepairVO)
 */
@Override
public void getRepairOkListBysearchPage(RepairVO repairVO) {
	int count = repairDao.getCountRepairOkList(repairVO);
	//keywordVO.setTotalCount(count);
	//keywordVO.setPageSize(10);
	//keywordVO.setTotalPage((int) Math.ceil((double) count / keywordVO.getPageSize()));
	repairDao.getRepairOkListByPage(repairVO);
	
}
/*
 * (non-Javadoc)处理维修物品
 * @see com.ssglxt.Student.service.RepairService#updateRepairChange(com.ssglxt.domain.DO.ssglxt_repair)
 */

@Override
public boolean updateRepairChange(String repair_id, String repair_status) {
	ssglxt_repair repair = repairDao.getRepairById(repair_id);
	repair.setRepair_status("已处理");
	String time = TeamUtil.getStringSecond();
	repair.setRepair_modify_time(time);
	if(repairDao.updateRepair(repair)){
		return true;
	}else{
		return false;
	}
}
}
