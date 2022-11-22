package com.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import java.sql.Timestamp;

@Entity(name = "receipt")
public class Receipt implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long receiptId;
	
	@NotEmpty
	private String receiptName;

	private String receiptMail;
	private String receiptAddress;
	private Timestamp receiptDate;
	private boolean receiptStatus;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "receipt")
	private List<ReceiptItem> listReceiptItem;

	public long getReceiptId() {
		return receiptId;
	}

	public void setReceiptId(long receiptId) {
		this.receiptId = receiptId;
	}

	public String getReceiptName() {
		return receiptName;
	}

	public void setReceiptName(String receiptName) {
		this.receiptName = receiptName;
	}

	public String getReceiptMail() {
		return receiptMail;
	}

	public void setReceiptMail(String receiptMail) {
		this.receiptMail = receiptMail;
	}

	public String getReceiptAddress() {
		return receiptAddress;
	}

	public void setReceiptAddress(String receiptAddress) {
		this.receiptAddress = receiptAddress;
	}

	public Timestamp getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(Timestamp receiptDate) {
		this.receiptDate = receiptDate;
	}

	public boolean isReceiptStatus() {
		return receiptStatus;
	}

	public void setReceiptStatus(boolean receiptStatus) {
		this.receiptStatus = receiptStatus;
	}

	public List<ReceiptItem> getListReceiptItem() {
		return listReceiptItem;
	}

	public void setListReceiptItem(List<ReceiptItem> listReceiptItem) {
		this.listReceiptItem = listReceiptItem;
	}

}