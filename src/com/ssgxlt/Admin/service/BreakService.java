package com.ssgxlt.Admin.service;

import com.ssglxt.domain.DO.ssglxt_break;
import com.ssglxt.domain.VO.BreakVO;

public interface BreakService {

public	boolean addBreak(ssglxt_break break1);//违规登记

public boolean updateBreak(ssglxt_break break1);//修改违规

public boolean deleteBreak(String breakIDAll);//删除违规

public void getBreakListBysearchPage(BreakVO breakVO);//分页查找违规信息

public ssglxt_break getBreakById(String break_id);//根据id得到违规信息

}
