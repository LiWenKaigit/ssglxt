package com.ssglxt.Super.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ssglxt.Super.dao.DormitoryBuildingDao;
import com.ssglxt.domain.DO.ssglxt_dormitoryBuilding;
import com.ssglxt.domain.VO.DormitoryBuildingVO;

public class DormitoryBuildingDaoImpl implements DormitoryBuildingDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
/*
 * (non-Javadoc)添加宿舍楼
 * @see com.ssglxt.Super.dao.DormitoryBuildingDao#addDormitoryBuilding(com.ssglxt.domain.DO.ssglxt_dormitoryBuilding)
 */
	@Override
	public boolean addDormitoryBuilding(ssglxt_dormitoryBuilding dormitoryBuilding) {
		try {
			Session session = getSession();
			session.save(dormitoryBuilding);
			session.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
/*
 * (non-Javadoc)修改宿舍楼信息
 * @see com.ssglxt.Super.dao.DormitoryBuildingDao#updateDormitoryBuilding(com.ssglxt.domain.DO.ssglxt_dormitoryBuilding)
 */
	@Override
	public boolean updateDormitoryBuilding(ssglxt_dormitoryBuilding dormitoryBuilding) {
		try {
			Session session = getSession();
			session.update(dormitoryBuilding);
			session.flush();
			session.clear();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
/*
 * (non-Javadoc)删除宿舍楼信息
 * @see com.ssglxt.Super.dao.DormitoryBuildingDao#deleteDormitoryBuilding(java.lang.String)
 */
	@Override
	public void deleteDormitoryBuilding(String dormitoryBuilding_id) {
		Session session = getSession();
		String hql = "delete from ssglxt_dormitoryBuilding where dormitoryBuilding_id='"+dormitoryBuilding_id+"'";
		Query query =session .createQuery(hql);
		query.executeUpdate();
		session.flush();
		session.clear();
		
	}

	@Override
	public int getCountDormitoryBuildingList(DormitoryBuildingVO dormitoryBuildingVO) {
		// TODO Auto-generated method stub
		Session session = getSession();
		String hql = "select count(*) from ssglxt_dormitoryBuilding where 1=1";
		if (dormitoryBuildingVO.getDormitoryBuilding_buildingName()!= null
				&& dormitoryBuildingVO.getDormitoryBuilding_buildingName().trim().length() > 0)
			hql = hql + " and dormitoryBuilding_buildingName like '%" + dormitoryBuildingVO.getDormitoryBuilding_buildingName() + "%'";
		long count = (long) session.createQuery(hql).uniqueResult();
		return (int) count;
	}

	@Override
	public void getDormitoryBuildingListByPage(DormitoryBuildingVO dormitoryBuildingVO) {
		// TODO Auto-generated method stub
		Session session = getSession();
		List<ssglxt_dormitoryBuilding> dormitoryBuildingList = new ArrayList<ssglxt_dormitoryBuilding>();
		String hql = "from ssglxt_dormitoryBuilding where 1=1 ";
		if (dormitoryBuildingVO.getDormitoryBuilding_buildingName()!= null
				&& dormitoryBuildingVO.getDormitoryBuilding_buildingName().trim().length() > 0)
			hql = hql + " and dormitoryBuilding_buildingName like '%" + dormitoryBuildingVO.getDormitoryBuilding_buildingName() + "%'";
		hql = hql + " order by dormitoryBuilding_modify_time desc";
		Query query = session.createQuery(hql);	
//		query.setFirstResult(
//				(keywordVO.getCurrPage() - 1) * keywordVO.getPageSize());
//		query.setMaxResults(keywordVO.getPageSize());
		dormitoryBuildingList = query.list();
		dormitoryBuildingVO.setSsglxt_dormitoryBuildingList(dormitoryBuildingList);
		session.clear();
	}
/*
 * (non-Javadoc)根据id得到宿舍楼信息
 * @see com.ssglxt.Super.dao.DormitoryBuildingDao#getDormitoryBuildingById(java.lang.String)
 */
	@Override
	public ssglxt_dormitoryBuilding getDormitoryBuildingById(String dormitoryBuilding_id) {
		Session session = getSession();
		String hql = "from ssglxt_dormitoryBuilding where dormitoryBuilding_id='"+dormitoryBuilding_id+"'";
		Query query= session.createQuery(hql);
		ssglxt_dormitoryBuilding dormitoryBuilding = (ssglxt_dormitoryBuilding) query.uniqueResult();
		session.clear();
		return dormitoryBuilding;
	}
}
