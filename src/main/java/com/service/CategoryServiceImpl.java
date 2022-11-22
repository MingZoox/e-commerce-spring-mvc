package com.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CategoryDAO;
import com.entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    public void create(Category object) {
        categoryDAO.create(object);
    }

    public void update(Category object) {
        categoryDAO.update(object);
    }

    public void delete(Category object) {
    	categoryDAO.delete(object);
    }

    public Category findById(int categoryId) {
        return categoryDAO.findById(categoryId);
    }

    public List<Category> getAll() {
        return categoryDAO.getAll();
    }

}