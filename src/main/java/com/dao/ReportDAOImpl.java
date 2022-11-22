package com.dao;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.MyItem;

@Repository
@Transactional
public class ReportDAOImpl implements ReportDAO {

	@Autowired
	SessionFactory sessionFactory;

	public List<MyItem> reportReceipt(Date date, int limit) {
		List<MyItem> list = new ArrayList<MyItem>();
		for (int i = limit - 1; i >= 0; i--) {
			Date d = subDays(date, i);
			MyItem myItem = new MyItem();
			myItem.setTime(covertD2S(d));
			myItem.setValue(countItemByDate(d));
			list.add(myItem);
		}
		return list;
	}

	private int countItemByDate(Date date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(df.format(date));
		return ((Long) sessionFactory.getCurrentSession()
				.createQuery("SELECT count(*) FROM receipt WHERE DATE_FORMAT(receiptDate,'%Y-%m-%d') = :date")
				.setParameter("date",df.format(date)).uniqueResult()).intValue();
	}

	public static Date addDays(Date date, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}

	public static Date subDays(Date date, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, -days);
		return cal.getTime();
	}

	private String covertD2S(Date date) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyy");
		return df.format(date);
	}

}
