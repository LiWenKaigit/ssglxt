package com.ssglxt.Super.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ssglxt.Super.dao.LoginOroutDao;
import com.ssglxt.domain.DO.ssglxt_admin;
import com.ssglxt.domain.DO.ssglxt_student;
import com.ssglxt.domain.DO.ssglxt_superAdmin;
import com.ssglxt.domain.VO.LoginOroutVO;

public class LoginOroutDaoImpl implements LoginOroutDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
/*
 * (non-Javadoc)登录
 * @see com.ssglxt.Super.dao.LoginOroutDao#login(com.ssglxt.domain.VO.LoginOroutVO)
 */
	@Override
	public LoginOroutVO login(LoginOroutVO loginOroutVO) {
		// TODO Auto-generated method stub
		System.out.println("a"+loginOroutVO.toString());
	if(loginOroutVO.getRole().equals("1")){
		System.out.println("1");
		String hql = "from ssglxt_student where student_studentId='" + loginOroutVO.getUsername() + "' and student_password='"
				+ loginOroutVO.getPassword() + "'";
		Query query = getSession().createQuery(hql);
		ssglxt_student student = new ssglxt_student();
		student =(ssglxt_student) query.uniqueResult();
		loginOroutVO.setObj(student);
		System.out.println("ssss");
		System.out.println(student);
		if(student==null){
			loginOroutVO=null;
		}
	}else if(loginOroutVO.getRole().equals("2")){
		
		System.out.println("2");
		String hql = "from ssglxt_admin where admin_jobNumber='" + loginOroutVO.getUsername() + "' and admin_password='"
				+ loginOroutVO.getPassword() + "'";
		Query query = getSession().createQuery(hql);
		ssglxt_admin admin = new ssglxt_admin();
		admin =(ssglxt_admin) query.uniqueResult();
		loginOroutVO.setObj(admin);
		if(admin==null){
			loginOroutVO=null;
		}
	}else if(loginOroutVO.getRole().equals("3")){
		String hql = "from ssglxt_superAdmin where superAdmin_jobNumber='" + loginOroutVO.getUsername() + "' and superAdmin_password='"
				+ loginOroutVO.getPassword() + "'";
		Query query = getSession().createQuery(hql);
		ssglxt_superAdmin superAdmin = new ssglxt_superAdmin();
		superAdmin =(ssglxt_superAdmin) query.uniqueResult();
		loginOroutVO.setObj(superAdmin);
		if(superAdmin==null){
			loginOroutVO=null;
		}
	}
		return loginOroutVO;
	}

	@Override
	public Boolean queryByPassword(String id, String rose, String oldPassword) {
		System.out.println("rose"+rose);
		if(rose.equals("1")){
			String hql="from ssglxt_student where student_id='"+id+"' and student_password='"+oldPassword+"'";
			Query query = getSession().createQuery(hql);
			ssglxt_student student = (ssglxt_student) query.uniqueResult();
			if(student==null){
				return false;
			}
		}
		if(rose.equals("2")){
			String hql="from ssglxt_admin where admin_id='"+id+"' and admin_password='"+oldPassword+"'";
			Query query = getSession().createQuery(hql);
			ssglxt_admin admin = (ssglxt_admin) query.uniqueResult();
			if(admin==null){
				return false;
			}
		}
		if(rose.equals("3")){
			String hql="from ssglxt_superAdmin where superAdmin_id='"+id+"' and superAdmin_password='"+oldPassword+"'";
			Query query = getSession().createQuery(hql);
			ssglxt_superAdmin superAdmin = (ssglxt_superAdmin) query.uniqueResult();
			if(superAdmin==null){System.out.println("false");
				return false;
			}System.out.println(superAdmin);
		}
		return true;
	}

	@Override
	public void updatePassword(String id,String rose, String newPassword) {
		Session session = getSession();
		if(rose.equals("1")){
			String hql="from ssglxt_student where student_id='"+id+"'";
			Query query = getSession().createQuery(hql);
			ssglxt_student student = (ssglxt_student) query.uniqueResult();
			student.setStudent_id(id);
			student.setStudent_password(newPassword);
			session.update(student);
			session.flush();
			session.clear();
		}
		if(rose.equals("2")){
			String hql="from ssglxt_admin where admin_id='"+id+"'";
			Query query = getSession().createQuery(hql);
			ssglxt_admin admin = (ssglxt_admin) query.uniqueResult();	
			admin.setAdmin_id(id);
			admin.setAdmin_password(newPassword);
			session.update(admin);
			session.flush();
			session.clear();
		}
		if(rose.equals("3")){
			String hql="from ssglxt_superAdmin where superAdmin_id='"+id+"'";
			Query query = getSession().createQuery(hql);
			ssglxt_superAdmin superAdmin = (ssglxt_superAdmin) query.uniqueResult();
			superAdmin.setSuperAdmin_id(id);
			superAdmin.setSuperAdmin_password(newPassword);
			session.update(superAdmin);
			session.flush();
			session.clear();
		}
	}
}
