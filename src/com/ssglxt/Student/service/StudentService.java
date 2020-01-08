package com.ssglxt.Student.service;

import com.ssglxt.domain.DO.ssglxt_student;
import com.ssglxt.domain.VO.StudentVO;

public interface StudentService {

public	boolean addStudent(ssglxt_student student);//学生入住登记

public boolean updateStudent(ssglxt_student student);//修改学生信息

public boolean deleteStudent(String studentIDAll);//删除学生

public StudentVO getStudentListBysearchPage(StudentVO studentVO);//分页查找学生信息

public ssglxt_student getStudentById(String student_id);//根据id得到学生信息

}
