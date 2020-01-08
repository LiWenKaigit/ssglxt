package com.ssglxt.Super.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ssglxt.Super.dao.BedDao;
import com.ssglxt.domain.DO.ssglxt_bed;
import com.ssglxt.domain.VO.BedVO;

public class BedDaoImpl implements BedDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
/*
 * (non-Javadoc)添加床位
 * @see com.ssglxt.Super.dao.BedDao#addBed(com.ssglxt.domain.DO.ssglxt_bed)
 */
	@Override
	public boolean addBed(ssglxt_bed bed) {
		try {
			Session session = getSession();
			session.save(bed);
			session.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
/*
 * (non-Javadoc)修改床位
 * @see com.ssglxt.Super.dao.BedDao#updateBed(com.ssglxt.domain.DO.ssglxt_bed)
 */
	@Override
	public boolean updateBed(ssglxt_bed bed) {
		try {
			Session session = getSession();
			session.update(bed);
			session.flush();
			session.clear();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void deleteBed(String bed_id) {
		Session session = getSession();
		String hql = "delete from ssglxt_bed where bed_id='"+bed_id+"'";
		Query query =session .createQuery(hql);
		query.executeUpdate();
		session.flush();
		session.clear();
		
	}

	@Override
	public int getCountBedList(BedVO bedVO) {
		Session session = getSession();
		String hql = "select count(*) from ssglxt_bed where 1=1";
		if (bedVO.getBed_buildingName()!= null
				&& bedVO.getBed_buildingName().trim().length() > 0)
			hql = hql + " and bed_buildingName like '%" + bedVO.getBed_buildingName() + "%'";
		long count = (long) session.createQuery(hql).uniqueResult();
		return (int) count;
	}

	@Override
	public BedVO getBedListByPage(BedVO bedVO) {
		Session session = getSession();
		List<ssglxt_bed> bedList = new ArrayList<ssglxt_bed>();
		String hql = "from ssglxt_bed where 1=1 ";
		if (bedVO.getBed_buildingName()!= null
				&& bedVO.getBed_buildingName().trim().length() > 0)
			hql = hql + " and bed_buildingName like '%" + bedVO.getBed_buildingName() + "%'";
		hql = hql + " order by bed_modify_time desc";
		Query query = session.createQuery(hql);	
		query.setFirstResult(
				(bedVO.getPageIndex() - 1) * bedVO.getPageSize());
		query.setMaxResults(bedVO.getPageSize());
		bedList = query.list();
//		query.setFirstResult(
//				(keywordVO.getCurrPage() - 1) * keywordVO.getPageSize());
//		query.setMaxResults(keywordVO.getPageSize());
		//bedList = query.list();
		bedVO.setSsglxt_bedList(bedList);
		session.clear();
		return bedVO;
		
	}
/*
 * (non-Javadoc)根据id得到床位信息
 * @see com.ssglxt.Super.dao.BedDao#getBedById(java.lang.String)
 */
	@Override
	public ssglxt_bed getBedById(String bed_id) {
		Session session = getSession();
		String hql = "from ssglxt_bed where bed_id='"+bed_id+"'";
		Query query= session.createQuery(hql);
		ssglxt_bed bed = (ssglxt_bed) query.uniqueResult();
		session.clear();
		return bed;
	}

	@Override
	public List<ssglxt_bed> getBedByDormitoryAndDormitoryBuilding(ssglxt_bed bed) {
		Session session = getSession();
		String hql = "from ssglxt_bed where bed_buildingName='"+bed.getBed_buildingName()+"'and bed_dormitoryName='"+bed.getBed_dormitoryName()+"'";
		Query query= session.createQuery(hql);
		List<ssglxt_bed> bedList = query.list();
		session.clear();
		return bedList;
	}
}
