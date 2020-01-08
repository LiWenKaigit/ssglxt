package com.ssglxt.Super.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ssglxt.Super.dao.DormitoryDao;
import com.ssglxt.domain.DO.ssglxt_dormitory;
import com.ssglxt.domain.VO.DormitoryVO;

public class DormitoryDaoImpl implements DormitoryDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
/*
 * (non-Javadoc)添加宿舍
 * @see com.ssglxt.Super.dao.DormitoryDao#addDormitory(com.ssglxt.domain.DO.ssglxt_dormitory)
 */
	@Override
	public boolean addDormitory(ssglxt_dormitory dormitory) {
		try {
			Session session = getSession();
			session.save(dormitory);
			session.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
/*
 * (non-Javadoc)修改宿舍
 * @see com.ssglxt.Super.dao.DormitoryDao#updateDormitory(com.ssglxt.domain.DO.ssglxt_dormitory)
 */
	@Override
	public boolean updateDormitory(ssglxt_dormitory dormitory) {
		try {
			Session session = getSession();
			session.update(dormitory);
			session.flush();
			session.clear();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
/*
 * (non-Javadoc)删除宿舍
 * @see com.ssglxt.Super.dao.DormitoryDao#deleteDormitory(java.lang.String)
 */
	@Override
	public void deleteDormitory(String dormitory_id) {
		Session session = getSession();
		String hql = "delete from ssglxt_dormitory where dormitory_id='"+dormitory_id+"'";
		Query query =session .createQuery(hql);
		query.executeUpdate();
		session.flush();
		session.clear();
		
	}

	@Override
	public int getCountDormitoryList(DormitoryVO dormitoryVO) {
		Session session = getSession();
		String hql = "select count(*) from ssglxt_dormitory where 1=1";
		if (dormitoryVO.getDormitory_buildingName()!= null
				&& dormitoryVO.getDormitory_buildingName().trim().length() > 0)
			hql = hql + " and dormitory_buildingName like '%" + dormitoryVO.getDormitory_buildingName() + "%'";
		long count = (long) session.createQuery(hql).uniqueResult();
		System.out.println(count);
		return (int) count;
	}

	@Override
	public DormitoryVO getDormitoryListByPage(DormitoryVO dormitoryVO) {
		Session session = getSession();
		List<ssglxt_dormitory> dormitoryList = new ArrayList<ssglxt_dormitory>();
		String hql = "from ssglxt_dormitory where 1=1 ";
		if (dormitoryVO.getDormitory_buildingName()!= null
				&& dormitoryVO.getDormitory_buildingName().trim().length() > 0)
			hql = hql + " and dormitory_buildingName like '%" + dormitoryVO.getDormitory_buildingName() + "%'";
		hql = hql + " order by dormitory_modify_time desc";
		Query query = session.createQuery(hql);	
		query.setFirstResult(
				(dormitoryVO.getPageIndex() - 1) * dormitoryVO.getPageSize());
		query.setMaxResults(dormitoryVO.getPageSize());
		dormitoryList = query.list();
//		query.setFirstResult(
//				(keywordVO.getCurrPage() - 1) * keywordVO.getPageSize());
//		query.setMaxResults(keywordVO.getPageSize());
		//dormitoryList = query.list();
		dormitoryVO.setSsglxt_dormitoryList(dormitoryList);
		session.clear();
		return dormitoryVO;
	}
/*
 * (non-Javadoc)根据id得到宿舍信息
 * @see com.ssglxt.Super.dao.DormitoryDao#getDormitoryById(java.lang.String)
 */
	@Override
	public ssglxt_dormitory getDormitoryById(String dormitory_id) {
		Session session = getSession();
		String hql = "from ssglxt_dormitory where dormitory_id='"+dormitory_id+"'";
		Query query= session.createQuery(hql);
		ssglxt_dormitory dormitory = (ssglxt_dormitory) query.uniqueResult();
		session.clear();
		return dormitory;
	}

	@Override
	public List<ssglxt_dormitory> getDormitoryByDormitoryBuildingName(ssglxt_dormitory dormitory) {
		Session session = getSession();
		String hql = "from ssglxt_dormitory where dormitory_buildingName='"+dormitory.getDormitory_buildingName()+"'";
		Query query= session.createQuery(hql);
		List<ssglxt_dormitory> dormitoryLisy = 	query.list();
		return dormitoryLisy;
	}
}
