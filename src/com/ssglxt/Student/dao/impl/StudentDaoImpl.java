package com.ssglxt.Student.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ssglxt.domain.DO.ssglxt_student;
import com.ssglxt.domain.VO.StudentVO;
import com.ssgxlt.Student.dao.StudentDao;

public class StudentDaoImpl implements StudentDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
/*
 * (non-Javadoc)学生入住登记
 * @see com.ssgxlt.Student.dao.StudentDao#addStudent(com.ssglxt.domain.DO.ssglxt_student)
 */
	@Override
	public boolean addStudent(ssglxt_student student) {
		try {
			Session session = getSession();
			session.save(student);
			session.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
/*
 * (non-Javadoc)修改学生信息
 * @see com.ssgxlt.Student.dao.StudentDao#updateStudent(com.ssglxt.domain.DO.ssglxt_student)
 */
	@Override
	public boolean updateStudent(ssglxt_student student) {
		try {
			Session session = getSession();
			session.update(student);
			session.flush();
			session.clear();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
/*
 * (non-Javadoc)删除学生
 * @see com.ssgxlt.Student.dao.StudentDao#deleteStudent(java.lang.String)
 */
	@Override
	public void deleteStudent(String student_id) {
		Session session = getSession();
		String hql = "delete from ssglxt_student where student_id='"+student_id+"'";
		Query query =session .createQuery(hql);
		query.executeUpdate();
		session.flush();
		session.clear();
	}

	@Override
	public int getCountStudentList(StudentVO studentVO) {
		Session session = getSession();
		String hql = "select count(*) from ssglxt_student where 1=1";
		if (studentVO.getStudent_name()!= null
				&& studentVO.getStudent_name().trim().length() > 0)
			hql = hql + " and student_name like '%" + studentVO.getStudent_name() + "%'";
		long count = (long) session.createQuery(hql).uniqueResult();
		return (int) count;
	}

	@Override
	public StudentVO getStudentListByPage(StudentVO studentVO) {
		Session session = getSession();
		List<ssglxt_student> studentList = new ArrayList<ssglxt_student>();
		String hql = "from ssglxt_student where 1=1 ";
		if (studentVO.getStudent_name()!= null
				&& studentVO.getStudent_name().trim().length() > 0)
			hql = hql + " and student_name like '%" + studentVO.getStudent_name() + "%'";
		hql = hql + " order by student_modify_time desc";
		Query query = session.createQuery(hql);	
		query.setFirstResult(
				(studentVO.getPageIndex() - 1) * studentVO.getPageSize());
		query.setMaxResults(studentVO.getPageSize());
		studentList = query.list();
//		query.setFirstResult(
//				(keywordVO.getCurrPage() - 1) * keywordVO.getPageSize());
//		query.setMaxResults(keywordVO.getPageSize());
	//	studentList = query.list();
		studentVO.setSsglxt_studentList(studentList);
		session.clear();
		return studentVO;
	}
/*
 * (non-Javadoc)根据id得到学生信息
 * @see com.ssgxlt.Student.dao.StudentDao#getStudentById(java.lang.String)
 */
	@Override
	public ssglxt_student getStudentById(String student_id) {
		Session session = getSession();
		String hql = "from ssglxt_student where student_id='"+student_id+"'";
		Query query= session.createQuery(hql);
		ssglxt_student student = (ssglxt_student) query.uniqueResult();
		return student;
	}
}
