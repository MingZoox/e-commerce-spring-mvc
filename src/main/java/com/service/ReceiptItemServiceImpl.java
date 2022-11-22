package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ReceiptItemDAO;
import com.entity.ReceiptItem;

@Service
public class ReceiptItemServiceImpl implements ReceiptItemService{

    @Autowired
    private ReceiptItemDAO ReceiptItemDAO;

    public void create(ReceiptItem object) {
        ReceiptItemDAO.create(object);
    }

    public void update(ReceiptItem object) {
        ReceiptItemDAO.update(object);
    }

    public void delete(ReceiptItem object) {
    	ReceiptItemDAO.delete(object);
    }

    public ReceiptItem findById(int ReceiptItemId) {
        return ReceiptItemDAO.findById(ReceiptItemId);
    }

    public List<ReceiptItem> getAll() {
        return ReceiptItemDAO.getAll();
    }
}
