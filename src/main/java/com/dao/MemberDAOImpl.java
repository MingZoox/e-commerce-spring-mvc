package com.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Member;

@Repository
@Transactional
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	SessionFactory sessionFactory;

	public Member login(String uname,String pass) {
		return (Member) sessionFactory.getCurrentSession()
				.createQuery("FROM member WHERE memberLogin = :uname", Member.class).setParameter("uname", uname)
				.getSingleResult();

	}

}
