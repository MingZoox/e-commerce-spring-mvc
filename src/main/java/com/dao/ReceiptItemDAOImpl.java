package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.ReceiptItem;

@Repository
@Transactional
public class ReceiptItemDAOImpl implements ReceiptItemDAO{
	@Autowired
	SessionFactory sessionFactory;

	public void create(ReceiptItem object) {
		sessionFactory.getCurrentSession().save(object);
	}

	public void update(ReceiptItem object) {
		sessionFactory.getCurrentSession().merge(object);
	}

	public void delete(ReceiptItem object) {
		sessionFactory.getCurrentSession().delete(object);
	}

	public ReceiptItem findById(int ReceiptItemId) {
		return (ReceiptItem) sessionFactory.getCurrentSession().get(ReceiptItem.class, ReceiptItemId);
	}

	public List<ReceiptItem> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from ReceiptItem",ReceiptItem.class).getResultList();
	}
}
