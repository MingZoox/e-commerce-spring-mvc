package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Receipt;

@Repository
@Transactional
public class ReceiptDAOImpl implements ReceiptDAO {
	@Autowired
	SessionFactory sessionFactory;

	public void create(Receipt object) {
		sessionFactory.getCurrentSession().save(object);
	}

	public void update(Receipt object) {
		sessionFactory.getCurrentSession().merge(object);
	}

	public void delete(Receipt object) {
		sessionFactory.getCurrentSession().delete(object);
	}

	public Receipt findById(int ReceiptId) {
		return (Receipt) sessionFactory.getCurrentSession().get(Receipt.class, ReceiptId);
	}

	public List<Receipt> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from ReceiptItem",Receipt.class).getResultList();
	}
}
