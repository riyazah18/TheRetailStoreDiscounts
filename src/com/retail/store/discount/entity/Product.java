package com.retail.store.discount.entity;


public class Product {
	
	private String name;	    
	private double price;
	private boolean isGrocery;
	
	
	// -- getters and setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isGrocery() {
		return isGrocery;
	}
	public void setGrocery(boolean isGrocery) {
		this.isGrocery = isGrocery;
	}
	
	
	

}
