package com.ssglxt.Super.service.impl;

import java.util.List;

import com.ssglxt.Super.dao.BedDao;
import com.ssglxt.Super.service.BedService;
import com.ssglxt.domain.DO.ssglxt_bed;
import com.ssglxt.domain.VO.BedVO;

import util.TeamUtil;

public class BedServiceImpl implements BedService {
private BedDao bedDao;

public BedDao getBedDao() {
	return bedDao;
}

public void setBedDao(BedDao bedDao) {
	this.bedDao = bedDao;
}
/*
 * (non-Javadoc)添加床位
 * @see com.ssglxt.Super.service.BedService#addBed(com.ssglxt.domain.DO.ssglxt_bed)
 */
@Override
public boolean addBed(ssglxt_bed bed) {
	bed.setBed_id(TeamUtil.getUuid());
	String time = TeamUtil.getStringSecond();
	bed.setBed_creat_time(time);
	bed.setBed_modify_time(time);
	if(bedDao.addBed(bed)){
		return true;
	}else{
		return false;
	}
}
/*
 * (non-Javadoc)修改床位
 * @see com.ssglxt.Super.service.BedService#updateBed(com.ssglxt.domain.DO.ssglxt_bed)
 */
@Override
public boolean updateBed(ssglxt_bed bed) {
	ssglxt_bed oldssglxt_bed =  getBedById(bed.getBed_id());
	bed.setBed_creat_time(oldssglxt_bed.getBed_creat_time());
	String time = TeamUtil.getStringSecond();
	bed.setBed_modify_time(time);
	if(bedDao.updateBed(bed)){
		return true;
	}else{
		return false;
	}
}
/*
 * (non-Javadoc)删除床位
 * @see com.ssglxt.Super.service.BedService#deleteBed(java.lang.String)
 */
@Override
public boolean deleteBed(String bedIDAll) {
	String[] arr = bedIDAll.split(",");
	for(String bed_id : arr){
		bedDao.deleteBed(bed_id);
	}
	return true;
}

@Override
public BedVO getBedListBysearchPage(BedVO bedVO) {
	int count = bedDao.getCountBedList(bedVO);
	bedVO.setTotalRecords(count);
	System.out.println(bedVO.getPageIndex());
	bedVO.setTotalPages(((count - 1) / bedVO.getPageSize()) + 1);
	if (bedVO.getPageIndex() <= 1) {
		bedVO.setHavePrePage(false);
	} else {
		bedVO.setHavePrePage(true);
	}
	if (bedVO.getPageIndex() >= bedVO.getTotalPages()) {
		bedVO.setHaveNextPage(false);
	} else {
		bedVO.setHaveNextPage(true);
	}

	//keywordVO.setTotalCount(count);
	//keywordVO.setPageSize(10);
	//keywordVO.setTotalPage((int) Math.ceil((double) count / keywordVO.getPageSize()));
	return bedDao.getBedListByPage(bedVO);
}
/*
 * (non-Javadoc)根据id得到床位信息
 * @see com.ssglxt.Super.service.BedService#getBedById(java.lang.String)
 */
@Override
public ssglxt_bed getBedById(String bed_id) {
	return bedDao.getBedById(bed_id);
}

@Override
public List<ssglxt_bed> getBedByDormitoryAndDormitoryBuilding(ssglxt_bed bed) {
	return bedDao.getBedByDormitoryAndDormitoryBuilding(bed);
}

}
