package com.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long productId;
	
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;
	
	private String productName;
	private String productImage;
	private double productPrice;
	private String productUrl;
	private int productSale;
	private int productView;
	private String productDescription;
	private boolean productStatus;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductUrl() {
		return productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	public int getProductSale() {
		return productSale;
	}

	public void setProductSale(int productSale) {
		this.productSale = productSale;
	}

	public int getProductView() {
		return productView;
	}

	public void setProductView(int productView) {
		this.productView = productView;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public boolean isProductStatus() {
		return productStatus;
	}

	public void setProductStatus(boolean productStatus) {
		this.productStatus = productStatus;
	}

}
