package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entity.Receipt;

@Service
public interface ReceiptService {
	// create
    public void create(Receipt object);

    // update
    public void update(Receipt object);

    // delete
    public void delete(Receipt object);

    // find by id
    public Receipt findById(int ReceiptId);

    // load list Receipt
    public List<Receipt> getAll();
}
