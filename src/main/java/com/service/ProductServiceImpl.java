package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ProductDAO;
import com.entity.Product;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
    private ProductDAO productDAO;

    public void create(Product object) {
        productDAO.create(object);
    }

    public void update(Product object) {
        productDAO.update(object);
    }

    public void delete(Product object) {
        productDAO.delete(object);
    }

    public Product findById(long categoryId) {
        return productDAO.findById(categoryId);
    }

    public List<Product> getListByCategory(long categoryId) {
        return productDAO.getListByCategory(categoryId);
    }

    public List<Product> getListFeatured(int limit) {
        return productDAO.getListFeatured(limit);
    }

    public List<Product> getListSale(int limit) {
        return productDAO.getListSale(limit);
    }

    public List<Product> getListNav(int start, int limit) {
        return productDAO.getListNav(start, limit);
    }

	public int totalItem() {
		return productDAO.getCount();
	}
}
