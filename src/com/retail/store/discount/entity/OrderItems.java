package com.retail.store.discount.entity;

public class OrderItems {
	private Product product;
	private int qunatity;
	
	public OrderItems(Product product, int qunatity) {
		super();
		this.product = product;
		this.qunatity = qunatity;
	}
	// getters setters
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQunatity() {
		return qunatity;
	}
	public void setQunatity(int qunatity) {
		this.qunatity = qunatity;
	}
	
	

}
