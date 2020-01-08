package com.ssglxt.Student.service.impl;

import java.util.List;

import com.ssglxt.Student.service.BreakService;
import com.ssglxt.domain.DO.ssglxt_break;
import com.ssglxt.domain.DO.ssglxt_student;
import com.ssglxt.domain.VO.BreakVO;
import com.ssgxlt.Student.dao.BreakDao;

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
 * @see com.ssglxt.Student.service.BreakService#addBreak(com.ssglxt.domain.DO.ssglxt_break)
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
 * (non-Javadoc)修改违规信息
 * @see com.ssglxt.Student.service.BreakService#updateBreak(com.ssglxt.domain.DO.ssglxt_break)
 */
	@Override
	public boolean updateBreak(ssglxt_break break1) {
		ssglxt_break oldssglxt_break =  getBreakById(break1.getBreak_id());
		break1.setBreak_creat_time(oldssglxt_break.getBreak_creat_time());
		String time = TeamUtil.getStringSecond();
		break1.setBreak_modify_time(time);
		
		if(breakDao.updateBreak(break1)){
			return true;
		}else{
			return false;
		}
	}
/*
 * (non-Javadoc)分页查找违规信息
 * @see com.ssglxt.Student.service.BreakService#getBreakListBysearchPage(com.ssglxt.domain.VO.BreakVO)
 */
	@Override
	public BreakVO getBreakListBysearchPage(BreakVO breakVO) {
		int count = breakDao.getCountBreakList(breakVO);
		breakVO.setTotalRecords(count);
		System.out.println(breakVO.getPageIndex());
		breakVO.setTotalPages(((count - 1) / breakVO.getPageSize()) + 1);
		if (breakVO.getPageIndex() <= 1) {
			breakVO.setHavePrePage(false);
		} else {
			breakVO.setHavePrePage(true);
		}
		if (breakVO.getPageIndex() >= breakVO.getTotalPages()) {
			breakVO.setHaveNextPage(false);
		} else {
			breakVO.setHaveNextPage(true);
		}
		//keywordVO.setTotalCount(count);
		//keywordVO.setPageSize(10);
		//keywordVO.setTotalPage((int) Math.ceil((double) count / keywordVO.getPageSize()));
		return breakDao.getBreakListByPage(breakVO);
		
	}
/*
 * (non-Javadoc)删除违规信息
 * @see com.ssglxt.Student.service.BreakService#deleteBreak(java.lang.String)
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
 * (non-Javadoc)根据id得到违规信息
 * @see com.ssglxt.Student.service.BreakService#getBreakById(java.lang.String)
 */
	@Override
	public ssglxt_break getBreakById(String break_id) {
		return breakDao.getBreakById(break_id);
	}

	@Override
	public BreakVO getstudentonebreakAll(String string) {
		// TODO Auto-generated method stub
		BreakVO breakVO = new BreakVO();
		System.out.println(string);
		List<ssglxt_break> ssglxt_breakList =  breakDao.getstudentonebreakAll(string);
		System.out.println(ssglxt_breakList);
		breakVO.setSsglxt_breakList(ssglxt_breakList);
		for(ssglxt_break ssglxt_break1 : ssglxt_breakList){
			List<ssglxt_student> ssglxt_studentList =  breakDao.getStudentBybreak_studentId(ssglxt_break1.getBreak_studentId());
			breakVO.setSsglxt_studentList(ssglxt_studentList);
		}
		return breakVO;
	}

}
