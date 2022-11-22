package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ReceiptDAO;
import com.entity.Receipt;

@Service
public class ReceiptServiceImpl implements ReceiptService{
	@Autowired
    private ReceiptDAO ReceiptDAO;

    public void create(Receipt object) {
        ReceiptDAO.create(object);
    }

    public void update(Receipt object) {
        ReceiptDAO.update(object);
    }

    public void delete(Receipt object) {
    	ReceiptDAO.delete(object);
    }

    public Receipt findById(int ReceiptId) {
        return ReceiptDAO.findById(ReceiptId);
    }

    public List<Receipt> getAll() {
        return ReceiptDAO.getAll();
    }
}
