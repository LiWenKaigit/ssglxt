package com.ssglxt.Student.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ssglxt.domain.DO.ssglxt_break;
import com.ssglxt.domain.DO.ssglxt_student;
import com.ssglxt.domain.VO.BreakVO;
import com.ssgxlt.Student.dao.BreakDao;

public class BreakDaoImpl implements BreakDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	/*
	 * (non-Javadoc)违规登记
	 * @see com.ssgxlt.Student.dao.BreakDao#addBreak(com.ssglxt.domain.DO.ssglxt_break)
	 */
	@Override
	public boolean addBreak(ssglxt_break break1) {
		try {
			Session session = getSession();
			session.save(break1);
			session.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public int getCountBreakList(BreakVO breakVO) {
		Session session = getSession();
		String hql = "select count(*) from ssglxt_break where 1=1";
		if (breakVO.getBreak_studentId()!= null
				&& breakVO.getBreak_studentId().trim().length() > 0)
			hql = hql + " and break_studentId like '%" + breakVO.getBreak_studentId() + "%'";
		long count = (long) session.createQuery(hql).uniqueResult();
		return (int) count;
	}

	@Override
	public BreakVO getBreakListByPage(BreakVO breakVO) {
		Session session = getSession();
		List<ssglxt_break> breakList = new ArrayList<ssglxt_break>();
		List<ssglxt_student> ssglxt_studentList = new ArrayList<ssglxt_student>();
		String hql = "from ssglxt_break where 1=1 ";
		if (breakVO.getBreak_studentId()!= null
				&& breakVO.getBreak_studentId().trim().length() > 0)
			hql = hql + " and break_studentId like '%" + breakVO.getBreak_studentId() + "%'";
		hql = hql + " order by break_modify_time desc";
		Query query = session.createQuery(hql);	
		query.setFirstResult(
				(breakVO.getPageIndex() - 1) * breakVO.getPageSize());
		query.setMaxResults(breakVO.getPageSize());
		breakList = query.list();
//		query.setFirstResult(
//				(keywordVO.getCurrPage() - 1) * keywordVO.getPageSize());
//		query.setMaxResults(keywordVO.getPageSize());
		//breakList = query.list();
		for(ssglxt_break break1 : breakList){
			String hql1 = "from ssglxt_student where student_studentId='"+break1.getBreak_studentId()+"' ";
			Query query1 = session.createQuery(hql1);	
			ssglxt_student student = (ssglxt_student) query1.uniqueResult();
			ssglxt_studentList.add(student);
		}
		breakVO.setSsglxt_breakList(breakList);
		breakVO.setSsglxt_studentList(ssglxt_studentList);
		session.clear();
		return breakVO;
	}
/*
 * (non-Javadoc)违规修改
 * @see com.ssgxlt.Student.dao.BreakDao#updateBreak(com.ssglxt.domain.DO.ssglxt_break)
 */
	@Override
	public boolean updateBreak(ssglxt_break break1) {
		try {
			Session session = getSession();
			session.update(break1);
			session.flush();
			session.clear();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
/*
 * (non-Javadoc)删除违规信息
 * @see com.ssgxlt.Student.dao.BreakDao#deleteBreak(java.lang.String)
 */
	@Override
	public void deleteBreak(String break_id) {
		Session session = getSession();
		String hql = "delete from ssglxt_break where break_id='"+break_id+"'";
		Query query =session .createQuery(hql);
		query.executeUpdate();
		session.flush();
		session.clear();
		
	}
/*
 * (non-Javadoc)根据id得到违规信息
 * @see com.ssgxlt.Student.dao.BreakDao#getBreakById(java.lang.String)
 */
	@Override
	public ssglxt_break getBreakById(String break_id) {
		Session session = getSession();
		String hql = "from ssglxt_break where break_id='"+break_id+"'";
		Query query= session.createQuery(hql);
		ssglxt_break break1 = (ssglxt_break) query.uniqueResult();
		session.clear();
		return break1;
	}

	@Override
	public List<ssglxt_break> getstudentonebreakAll(String string) {
		Session session = getSession();
		String hql = "from ssglxt_break where break_studentId='"+string+"'";
		Query query= session.createQuery(hql);
		List<ssglxt_break> breakListOneStudnet = query.list();
		return breakListOneStudnet;
	}

	@Override
	public List<ssglxt_student> getStudentBybreak_studentId(String break_studentId) {
		Session session = getSession();
		String hql = "from ssglxt_student where student_studentId='"+break_studentId+"'";
		Query query= session.createQuery(hql);
		List<ssglxt_student> ssglxt_studentList = query.list();
		return ssglxt_studentList;
	}

}
