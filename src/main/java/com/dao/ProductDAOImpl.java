package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Product;

@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	SessionFactory sessionFactory;

	public void create(Product object) {
		sessionFactory.getCurrentSession().save(object);
	}

	public void update(Product object) {
		sessionFactory.getCurrentSession().merge(object);
	}

	public void delete(Product object) {
		sessionFactory.getCurrentSession().delete(object);
	}

	public Product findById(long productId) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, productId);
	}

	public List<Product> getListByCategory(long categoryId) {
		return sessionFactory.getCurrentSession()
				.createQuery("FROM product WHERE categoryId = :categoryId", Product.class)
				.setParameter("categoryId", categoryId).getResultList();
	}

	public List<Product> getListByCategoryAndLimit(long categoryId, int limit) {
		return sessionFactory.getCurrentSession()
				.createQuery("FROM product WHERE categoryId = :categoryId", Product.class)
				.setParameter("categoryId", categoryId).setMaxResults(limit).getResultList();
	}

	public List<Product> getListFeatured(int limit) {
		return sessionFactory.getCurrentSession().createQuery("FROM product ORDER BY productView DESC", Product.class)
				.setMaxResults(limit).getResultList();
	}

	public List<Product> getListSale(int limit) {
		return sessionFactory.getCurrentSession().createQuery("FROM product ORDER BY productSale DESC", Product.class)
				.setMaxResults(limit).getResultList();
	}

	public List<Product> getListNav(int start, int limit) {
		return sessionFactory.getCurrentSession().createQuery("FROM product", Product.class).setFirstResult(start)
				.setMaxResults(limit).getResultList();
	}

	public int getCount() {
		return Integer.parseInt(sessionFactory.getCurrentSession().createQuery("select count(*) FROM product")
				.getSingleResult().toString());
	}
}
