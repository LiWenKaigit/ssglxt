package com.ssgxlt.Admin.service.impl;

import com.ssglxt.Admin.dao.BreakDao;
import com.ssglxt.domain.DO.ssglxt_break;
import com.ssglxt.domain.VO.BreakVO;
import com.ssgxlt.Admin.service.BreakService;

import util.TeamUtil;

public class BreakServiceImpl implements BreakService {
private BreakDao breakDao;

public BreakDao getBreakDao() {
	return breakDao;
}

public void setBreakDao(BreakDao breakDao) {
	this.breakDao = breakDao;
}
/*
 * (non-Javadoc)违规登记
 * @see com.ssgxlt.Admin.service.BreakService#addBreak(com.ssglxt.domain.DO.ssglxt_break)
 */
@Override
public boolean addBreak(ssglxt_break break1) {
	break1.setBreak_id(TeamUtil.getUuid());
	String time = TeamUtil.getStringSecond();
	break1.setBreak_creat_time(time);
	break1.setBreak_modify_time(time);
	if(breakDao.addBreak(break1)){
		return true;
	}else{
		return false;
	}
}
/*
 * (non-Javadoc)修改违规
 * @see com.ssgxlt.Admin.service.BreakService#updateBreak(com.ssglxt.domain.DO.ssglxt_break)
 */
@Override
public boolean updateBreak(ssglxt_break break1) {
	String time = TeamUtil.getStringSecond();
	break1.setBreak_modify_time(time);
	if(breakDao.updateBreak(break1)){
		return true;
	}else{
		return false;
	}
}
/*
 * (non-Javadoc)删除违规
 * @see com.ssgxlt.Admin.service.BreakService#deleteBreak(java.lang.String)
 */
@Override
public boolean deleteBreak(String breakIDAll) {
	String[] arr = breakIDAll.split(",");
	for(String break_id : arr){
		breakDao.deleteBreak(break_id);
	}
	return true;
}
/*
 * (non-Javadoc)分页查找违规信息
 * @see com.ssgxlt.Admin.service.BreakService#getBreakListBysearchPage(com.ssglxt.domain.VO.BreakVO)
 */
@Override
public void getBreakListBysearchPage(BreakVO breakVO) {
	int count = breakDao.getCountBreakList(breakVO);
	//keywordVO.setTotalCount(count);
	//keywordVO.setPageSize(10);
	//keywordVO.setTotalPage((int) Math.ceil((double) count / keywordVO.getPageSize()));
	breakDao.getBreakListByPage(breakVO);
	
}
/*
 * (non-Javadoc)根据id得到违规信息
 * @see com.ssgxlt.Admin.service.BreakService#getBreakById(java.lang.String)
 */
@Override
public ssglxt_break getBreakById(String break_id) {
	return breakDao.getBreakById(break_id);
}

}
