package com.ssglxt.Super.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ssglxt.Super.dao.SuperAdminDao;
import com.ssglxt.domain.DO.ssglxt_superAdmin;

public class SuperAdminDaoImpl implements SuperAdminDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
/*
 * (non-Javadoc)根据id得到超级管理员信息
 * @see com.ssglxt.Super.dao.SuperAdminDao#getAdminById(java.lang.String)
 */
	@Override
	public ssglxt_superAdmin getAdminById(String superAdmin_id) {
		Session session = getSession();
		String hql = "from ssglxt_superAdmin where superAdmin_id='" + superAdmin_id + "'";
		Query query = session.createQuery(hql);
		ssglxt_superAdmin superAdmin = (ssglxt_superAdmin) query.uniqueResult();
		return superAdmin;
	}

	@Override
	public boolean updatePassword(ssglxt_superAdmin old_superAdmin) {
		try {
			Session session = getSession();
			session.update(old_superAdmin);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
