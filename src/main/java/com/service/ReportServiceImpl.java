package com.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ReportDAO;
import com.model.MyItem;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportDAO reportDAO;

    public List<MyItem> reportReceipt(Date date, int limit) {
        return reportDAO.reportReceipt(date, limit);
    }

}
