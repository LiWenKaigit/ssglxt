package com.ssglxt.Student.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.ssglxt.Student.service.StudentService;
import com.ssglxt.domain.DO.ssglxt_student;
import com.ssglxt.domain.VO.StudentVO;
import com.ssgxlt.Student.dao.StudentDao;

import util.TeamUtil;

public class StudentServiceImpl implements StudentService {
private StudentDao studentDao;

public StudentDao getStudentDao() {
	return studentDao;
}

public void setStudentDao(StudentDao studentDao) {
	this.studentDao = studentDao;
}
/*
 * (non-Javadoc)学生入住登记
 * @see com.ssglxt.Student.service.StudentService#addStudent(com.ssglxt.domain.DO.ssglxt_student)
 */
@Override
public boolean addStudent(ssglxt_student student) {
	student.setStudent_id(TeamUtil.getUuid());
	String time = TeamUtil.getStringSecond();
	student.setStudent_password("000000");
	student.setStudent_role("1");
	student.setStudent_creat_time(time);
	student.setStudent_modify_time(time);
	if(studentDao.addStudent(student)){
		return true;
	}else{
		return false;
	}
}
/*
 * (non-Javadoc)修改学生信息
 * @see com.ssglxt.Student.service.StudentService#updateStudent(com.ssglxt.domain.DO.ssglxt_student)
 */
@Override
public boolean updateStudent(ssglxt_student student) {
	ssglxt_student oldstudent = getStudentById(student.getStudent_id());
	//使用反射将前端传过来的数据，和查找出数据库中的数据，使用反射将该更新的数据更新
    Class<?> srcClass = oldstudent.getClass();//数据库查出的源对象数据
    Class<?> descClass = student.getClass();//前端传的需要更新的数据
    if(!descClass.equals(srcClass)){
        try {
			throw new Exception("源对象与目标对象类型不一致！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    Method[] descClassDeclaredMethods = descClass.getDeclaredMethods();
    Method[] srcClassDeclaredMethods = srcClass.getDeclaredMethods();
    for(Method descMethod : descClassDeclaredMethods){
        if (descMethod.getName().startsWith("get")){
            try {
				Object invoke = descMethod.invoke(student);
                if ((invoke != null) && !"".equals(invoke.toString().trim())){
                    String methodSetMethod = "set"+descMethod.getName().substring(3);
                    for (Method srcMethod : srcClassDeclaredMethods){
                        if (srcMethod.getName().equalsIgnoreCase(methodSetMethod)){
                            srcMethod.invoke(oldstudent,invoke);
                        }
                    }
                }
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        }
    }
	String time = TeamUtil.getStringSecond();
	oldstudent.setStudent_modify_time(time);
	if(studentDao.updateStudent(oldstudent)){
		return true;
	}else{
		return false;
	}
}
/*
 * (non-Javadoc)删除学生
 * @see com.ssglxt.Student.service.StudentService#deleteStudent(java.lang.String)
 */
@Override
public boolean deleteStudent(String studentIDAll) {
	String[] arr = studentIDAll.split(",");
	for(String student_id : arr){
		studentDao.deleteStudent(student_id);
	}
	return true;
}

@Override
public StudentVO getStudentListBysearchPage(StudentVO studentVO) {
	// TODO Auto-generated method stub
	int count = studentDao.getCountStudentList(studentVO);
	studentVO.setTotalRecords(count);
	System.out.println(studentVO.getPageIndex());
	studentVO.setTotalPages(((count - 1) / studentVO.getPageSize()) + 1);
	if (studentVO.getPageIndex() <= 1) {
		studentVO.setHavePrePage(false);
	} else {
		studentVO.setHavePrePage(true);
	}
	if (studentVO.getPageIndex() >= studentVO.getTotalPages()) {
		studentVO.setHaveNextPage(false);
	} else {
		studentVO.setHaveNextPage(true);
	}
	//keywordVO.setTotalCount(count);
	//keywordVO.setPageSize(10);
	//keywordVO.setTotalPage((int) Math.ceil((double) count / keywordVO.getPageSize()));
	return studentDao.getStudentListByPage(studentVO);
}
/*
 * (non-Javadoc)根据id得到学生信息
 * @see com.ssglxt.Student.service.StudentService#getStudentById(java.lang.String)
 */
@Override
public ssglxt_student getStudentById(String student_id) {
	return studentDao.getStudentById(student_id);
}


}
