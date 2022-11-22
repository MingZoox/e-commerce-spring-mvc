package com.service;

import java.util.List;

import com.entity.ReceiptItem;

public interface ReceiptItemService {
	// create
    public void create(ReceiptItem object);

    // update
    public void update(ReceiptItem object);

    // delete
    public void delete(ReceiptItem object);

    // find by id
    public ReceiptItem findById(int ReceiptItemId);

    // load list ReceiptItem
    public List<ReceiptItem> getAll();
}
