package com.service;


import java.util.List;
import com.entity.Category;

public interface CategoryService {

    // create
    public void create(Category object);

    // update
    public void update(Category object);

    // delete
    public void delete(Category object);

    // find by id
    public Category findById(int categoryId);

    // load list category
    public List<Category> getAll();

}