package com.retail.store.discount.entity;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private List<OrderItems> items;
	private User user;
	
	public Order()
	{
		items=new ArrayList<OrderItems>();
	}

	// getter setter
	public List<OrderItems> getItems() {

		return (List<OrderItems>) this.items;
	}

	public void addItems(OrderItems items) {
		this.items.add(items);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
