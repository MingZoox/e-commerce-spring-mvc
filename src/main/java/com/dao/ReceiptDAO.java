package com.dao;

import java.util.List;

import com.entity.Receipt;

public interface ReceiptDAO {
	// create
    public void create(Receipt object);

    // update
    public void update(Receipt object);

    // delete
    public void delete(Receipt object);

    // find by id
    public Receipt findById(int categoryId);

    // load list category
    public List<Receipt> getAll();
}
