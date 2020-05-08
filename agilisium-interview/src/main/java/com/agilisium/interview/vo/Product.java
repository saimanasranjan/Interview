package com.agilisium.interview.vo;

import java.io.Serializable;

public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String productName;
	private String productCmyName;
	
	public Product(String productName,String productCmyName) {
		this.productName = productName;
		this.productCmyName = productCmyName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCmyName() {
		return productCmyName;
	}

	public void setProductCmyName(String productCmyName) {
		this.productCmyName = productCmyName;
	}

	@Override
	public String toString() {
		return "Product [productName=" + productName + ", productCmyName=" + productCmyName + "]";
	}
	
	
}
