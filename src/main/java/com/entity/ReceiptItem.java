package com.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "receipt_item")
public class ReceiptItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long receiptItemId;
	
	@ManyToOne
	@JoinColumn(name = "receiptId")
	private Receipt receipt;
	
	@OneToOne
	@JoinColumn(name = "productId")
	private Product product;
	
	private int receiptItemQuantity;
	private double receiptItemPrice;
	private int receiptItemSale;
	private boolean receiptItemStatus;

	public long getReceiptItemId() {
		return receiptItemId;
	}

	public void setReceiptItemId(long receiptItemId) {
		this.receiptItemId = receiptItemId;
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getReceiptItemQuantity() {
		return receiptItemQuantity;
	}

	public void setReceiptItemQuantity(int receiptItemQuantity) {
		this.receiptItemQuantity = receiptItemQuantity;
	}

	public double getReceiptItemPrice() {
		return receiptItemPrice;
	}

	public void setReceiptItemPrice(double receiptItemPrice) {
		this.receiptItemPrice = receiptItemPrice;
	}

	public int getReceiptItemSale() {
		return receiptItemSale;
	}

	public void setReceiptItemSale(int receiptItemSale) {
		this.receiptItemSale = receiptItemSale;
	}

	public boolean isReceiptItemStatus() {
		return receiptItemStatus;
	}

	public void setReceiptItemStatus(boolean receiptItemStatus) {
		this.receiptItemStatus = receiptItemStatus;
	}

}
