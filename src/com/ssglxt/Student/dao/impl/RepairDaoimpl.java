package com.ssglxt.Student.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ssglxt.domain.DO.ssglxt_repair;
import com.ssglxt.domain.DO.ssglxt_student;
import com.ssglxt.domain.VO.RepairVO;
import com.ssgxlt.Student.dao.RepairDao;

public class RepairDaoimpl implements RepairDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
/*
 * (non-Javadoc)添加报修
 * @see com.ssgxlt.Student.dao.RepairDao#addRepair(com.ssglxt.domain.DO.ssglxt_repair)
 */
	@Override
	public boolean addRepair(ssglxt_repair repair) {
		try {
			Session session = getSession();
			session.save(repair);
			session.flush();
			session.clear();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
/*
 * (non-Javadoc)修改报修
 * @see com.ssgxlt.Student.dao.RepairDao#updateRepair(com.ssglxt.domain.DO.ssglxt_repair)
 */
	@Override
	public boolean updateRepair(ssglxt_repair repair) {
		try {
			Session session = getSession();
			session.update(repair);
			session.flush();
			session.clear();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
/*
 * (non-Javadoc)删除报修
 * @see com.ssgxlt.Student.dao.RepairDao#deleteRepair(java.lang.String)
 */
	@Override
	public void deleteRepair(String repair_id) {
		Session session = getSession();
		String hql = "delete from ssglxt_repair where repair_id='"+repair_id+"'";
		Query query =session .createQuery(hql);
		query.executeUpdate();
		session.flush();
		session.clear();
		
	}

	@Override
	public int getCountRepairList(RepairVO repairVO) {
		Session session = getSession();
		String hql = "select count(*) from ssglxt_repair where 1=1";
		if (repairVO.getRepair_name()!= null
				&& repairVO.getRepair_name().trim().length() > 0)
			hql = hql + " and repair_name like '%" + repairVO.getRepair_name() + "%'";
		if (repairVO.getRepair_status() != null
				&& repairVO.getRepair_status().trim().length() > 0)
			hql = hql + " and repair_status like'%" + repairVO.getRepair_status() + "%'";
		long count = (long) session.createQuery(hql).uniqueResult();
		session.clear();
		return (int) count;
	}

	@Override
	public RepairVO getRepairListByPage(RepairVO repairVO) {
		Session session = getSession();
		List<ssglxt_repair> repairList = new ArrayList<ssglxt_repair>();
		List<ssglxt_student> ssglxt_studentList = new ArrayList<ssglxt_student>();
		String hql = "from ssglxt_repair where 1=1 ";
		if (repairVO.getRepair_name()!= null
				&& repairVO.getRepair_name().trim().length() > 0)
			hql = hql + " and repair_name like '%" + repairVO.getRepair_name() + "%'";
		if (repairVO.getRepair_status() != null
				&& repairVO.getRepair_status().trim().length() > 0)
			hql = hql + " and repair_status like'%" + repairVO.getRepair_status() + "%'";
		hql = hql + " order by repair_modify_time desc";
		Query query = session.createQuery(hql);	
		query.setFirstResult(
				(repairVO.getPageIndex() - 1) * repairVO.getPageSize());
		query.setMaxResults(repairVO.getPageSize());
		repairList = query.list();	
//		query.setFirstResult(
//				(keywordVO.getCurrPage() - 1) * keywordVO.getPageSize());
//		query.setMaxResults(keywordVO.getPageSize());
		//repairList = query.list();
		for(ssglxt_repair repair : repairList){
			String hql1 = "from ssglxt_student where student_studentId='"+repair.getRepair_studentId()+"' ";
			Query query1 = session.createQuery(hql1);	
			ssglxt_student student = (ssglxt_student) query1.uniqueResult();
			ssglxt_studentList.add(student);
		}
		repairVO.setSsglxt_repairList(repairList);
		repairVO.setSsglxt_studentList(ssglxt_studentList);
		session.clear();
		return repairVO;
	}
/*
 * (non-Javadoc)根据id得到报修信息
 * @see com.ssgxlt.Student.dao.RepairDao#getRepairById(java.lang.String)
 */
	@Override
	public ssglxt_repair getRepairById(String repair_id) {
		Session session = getSession();
		String hql = "from ssglxt_repair where repair_id='"+repair_id+"'";
		Query query= session.createQuery(hql);
		ssglxt_repair repair = (ssglxt_repair) query.uniqueResult();
		session.clear();
		return repair;
	}

	@Override
	public int getCountRepairOkList(RepairVO repairVO) {
		Session session = getSession();
		String hql = "select count(*) from ssglxt_repair where repair_status='待处理'";
		if (repairVO.getRepair_name()!= null
				&& repairVO.getRepair_name().trim().length() > 0)
			hql = hql + " and repair_name like '%" + repairVO.getRepair_name() + "%'";
		long count = (long) session.createQuery(hql).uniqueResult();
		session.clear();
		return (int) count;
	}

	@Override
	public void getRepairOkListByPage(RepairVO repairVO) {
		Session session = getSession();
		List<ssglxt_repair> repairList = new ArrayList<ssglxt_repair>();
		List<ssglxt_student> ssglxt_studentList = new ArrayList<ssglxt_student>();
		String hql = "from ssglxt_repair where repair_status='待处理' ";
		if (repairVO.getRepair_name()!= null
				&& repairVO.getRepair_name().trim().length() > 0)
			hql = hql + " and repair_name like '%" + repairVO.getRepair_name() + "%'";
		hql = hql + " order by repair_modify_time desc";
		Query query = session.createQuery(hql);	
//		query.setFirstResult(
//				(keywordVO.getCurrPage() - 1) * keywordVO.getPageSize());
//		query.setMaxResults(keywordVO.getPageSize());
		repairList = query.list();
		for(ssglxt_repair repair : repairList){
			String hql1 = "from ssglxt_student where student_studentId='"+repair.getRepair_studentId()+"' ";
			Query query1 = session.createQuery(hql1);	
			ssglxt_student student = (ssglxt_student) query1.uniqueResult();
			ssglxt_studentList.add(student);
		}
		repairVO.setSsglxt_repairList(repairList);
		repairVO.setSsglxt_studentList(ssglxt_studentList);
		session.clear();
		
	}
/*
 * (non-Javadoc)处理维修物品
 * @see com.ssgxlt.Student.dao.RepairDao#updateRepairChange(com.ssglxt.domain.DO.ssglxt_repair)
 */
	@Override
	public boolean updateRepairChange(ssglxt_repair repair) {
		try {
			Session session = getSession();
			session.save(repair);
			session.flush();
			session.clear();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
}
}