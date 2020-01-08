package com.ssglxt.Admin.dao;

import com.ssglxt.domain.DO.ssglxt_break;
import com.ssglxt.domain.VO.BreakVO;

public interface BreakDao {

public	boolean addBreak(ssglxt_break break1);//违规登记

public boolean updateBreak(ssglxt_break break1);//修改违规

public void deleteBreak(String break_id);//删除违规

public int getCountBreakList(BreakVO breakVO);

public void getBreakListByPage(BreakVO breakVO);

public ssglxt_break getBreakById(String break_id);//根据id得到违规信息

}
