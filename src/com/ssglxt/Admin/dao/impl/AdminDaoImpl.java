package com.ssglxt.Admin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ssglxt.Admin.dao.AdminDao;
import com.ssglxt.domain.DO.ssglxt_admin;
import com.ssglxt.domain.VO.AdminVO;

public class AdminDaoImpl implements AdminDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
/*
 * (non-Javadoc)添加宿舍管理员
 * @see com.ssglxt.Admin.dao.AdminDao#addAdmin(com.ssglxt.domain.DO.ssglxt_admin)
 */
	@Override
	public boolean addAdmin(ssglxt_admin admin) {
		try {
			Session session = getSession();
			session.save(admin);
			session.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
/*
 * (non-Javadoc)修改宿舍管理员
 * @see com.ssglxt.Admin.dao.AdminDao#updateAdmin(com.ssglxt.domain.DO.ssglxt_admin)
 */
	@Override
	public boolean updateAdmin(ssglxt_admin admin) {
		try {
			Session session = getSession();
			session.update(admin);
			session.flush();
			session.clear();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
/*
 * (non-Javadoc)删除宿舍管理员
 * @see com.ssglxt.Admin.dao.AdminDao#deleteAdmin(java.lang.String)
 */
	@Override
	public void deleteAdmin(String admin_id) {
		Session session = getSession();
		String hql = "delete from ssglxt_admin where admin_id='"+admin_id+"'";
		Query query =session .createQuery(hql);
		query.executeUpdate();
		session.flush();
		session.clear();
	}

	@Override
	public int getCountAdminList(AdminVO adminVO) {
		Session session = getSession();
		String hql = "select count(*) from ssglxt_admin where 1=1";
		if (adminVO.getAdmin_name()!= null
				&& adminVO.getAdmin_name().trim().length() > 0)
			hql = hql + " and admin_name like '%" + adminVO.getAdmin_name() + "%'";
		long count = (long) session.createQuery(hql).uniqueResult();
		return (int) count;
	}

	@Override
	public void getAdminListByPage(AdminVO adminVO) {
		System.out.println("进入了dao");
		Session session = getSession();
		System.out.println("001");
		List<ssglxt_admin> adminList = new ArrayList<ssglxt_admin>();
		System.out.println("002");
		String hql = "from ssglxt_admin where 1=1 ";
		if (adminVO.getAdmin_name()!= null
				&& adminVO.getAdmin_name().trim().length() > 0)
			hql = hql + " and admin_name like '%" + adminVO.getAdmin_name() + "%'";
		hql = hql + " order by admin_modify_time desc";
		System.out.println("003");
		Query query = session.createQuery(hql);	
		System.out.println("004");
//		query.setFirstResult(
//				(keywordVO.getCurrPage() - 1) * keywordVO.getPageSize());
//		query.setMaxResults(keywordVO.getPageSize());
		adminList = query.list();
		System.out.println(adminList.toString());
		adminVO.setSsglxt_adminList(adminList);
		session.clear();
		
	}
/*
 * (non-Javadoc)根据id得到宿舍管理员信息
 * @see com.ssglxt.Admin.dao.AdminDao#getAdminById(java.lang.String)
 */
	@Override
	public ssglxt_admin getAdminById(String admin_id) {
		Session session = getSession();
		String hql = "from ssglxt_admin where admin_id='"+admin_id+"'";
		Query query= session.createQuery(hql);
		ssglxt_admin admin = (ssglxt_admin) query.uniqueResult();
		return admin;
	}
}
