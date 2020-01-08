package com.ssgxlt.Student.dao;

import com.ssglxt.domain.DO.ssglxt_student;
import com.ssglxt.domain.VO.StudentVO;

public interface StudentDao {

public	boolean addStudent(ssglxt_student student);//学生入住登记

public boolean updateStudent(ssglxt_student student);//修改学生信息

public void deleteStudent(String student_id);//删除学生

public int getCountStudentList(StudentVO studentVO);

public StudentVO getStudentListByPage(StudentVO studentVO);

public ssglxt_student getStudentById(String student_id);//根据id得到学生信息

}
