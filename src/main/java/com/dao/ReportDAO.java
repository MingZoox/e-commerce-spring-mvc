package com.dao;

import java.util.Date;
import java.util.List;

import com.model.MyItem;

public interface ReportDAO {
    
    public List<MyItem> reportReceipt(Date date, int limit);
    
}
