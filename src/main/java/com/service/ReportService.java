package com.service;

import java.util.Date;
import java.util.List;

import com.model.MyItem;

public interface ReportService {
    
    public List<MyItem> reportReceipt(Date date, int limit);
    
}
