package com.service;

import java.util.List;

import com.entity.Product;

public interface ProductService {
	// create
    public void create(Product object);

    // update
    public void update(Product object);

    // delete
    public void delete(Product object);

    // find by id
    public Product findById(long productId);
    
    public int totalItem ();

    // load list product by category
    public List<Product> getListByCategory(long categoryId);

    // load list product by featured
    public List<Product> getListFeatured(int limit);

    // load list product by sale
    public List<Product> getListSale(int limit);

    // load list product by nav
    public List<Product> getListNav(int start, int limit);
	
}
