package com.ssgxlt.Student.dao;

import java.util.List;

import com.ssglxt.domain.DO.ssglxt_break;
import com.ssglxt.domain.DO.ssglxt_student;
import com.ssglxt.domain.VO.BreakVO;

public interface BreakDao {

public	boolean addBreak(ssglxt_break break1);//违规登记

public int getCountBreakList(BreakVO breakVO);

public BreakVO getBreakListByPage(BreakVO breakVO);

public boolean updateBreak(ssglxt_break break1);//违规修改

public void deleteBreak(String break_id);//删除违规信息

public ssglxt_break getBreakById(String break_id);//根据id得到违规信息

public List<ssglxt_break> getstudentonebreakAll(String string);//根据id得到单个学生的所有违规记录

public List<ssglxt_student> getStudentBybreak_studentId(String break_studentId);//根据违规表中的学生学号得到学生的基本信息

}
