package com.ssglxt.Student.service;

import java.util.List;

import com.ssglxt.domain.DO.ssglxt_break;
import com.ssglxt.domain.VO.BreakVO;

public interface BreakService {

public	boolean addBreak(ssglxt_break break1);//违规登记

public boolean updateBreak(ssglxt_break break1);//修改登记

public BreakVO getBreakListBysearchPage(BreakVO breakVO);//分页查找违规信息

public boolean deleteBreak(String breakIDAll);//删除违规

public ssglxt_break getBreakById(String break_id);//根据id得到违规信息

public BreakVO getstudentonebreakAll(String string);//根据id得到单个学生的所有违规记录

}
