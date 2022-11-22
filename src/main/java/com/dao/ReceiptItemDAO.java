package com.dao;

import java.util.List;

import com.entity.ReceiptItem;


public interface ReceiptItemDAO {
	// create
    public void create(ReceiptItem object);

    // update
    public void update(ReceiptItem object);

    // delete
    public void delete(ReceiptItem object);

    // find by id
    public ReceiptItem findById(int categoryId);

    // load list category
    public List<ReceiptItem> getAll();
}
