package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Category;

@Repository
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	SessionFactory sessionFactory;

	public void create(Category object) {
		sessionFactory.getCurrentSession().save(object);
	}

	public void update(Category object) {
		sessionFactory.getCurrentSession().merge(object);
	}

	public void delete(Category object) {
		sessionFactory.getCurrentSession().delete(object);
	}

	public Category findById(int categoryId) {
		return (Category) sessionFactory.getCurrentSession().get(Category.class, categoryId);
	}

	public List<Category> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from category",Category.class).getResultList();
	}

}
