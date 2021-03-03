package com.retail.store.discount.main;

import java.time.LocalDate;

import com.retail.store.discount.entity.Bill;
import com.retail.store.discount.entity.Order;
import com.retail.store.discount.entity.OrderItems;
import com.retail.store.discount.entity.Product;
import com.retail.store.discount.entity.User;
import com.retail.store.discount.interfaces.DiscountService;
import com.retail.store.discount.services.DiscountServiceImpl;

/**
 * @Description : A test class for retail store discount.
 * @author riyaz.ahmed
 *
 */
public class Test {

	public static void main(String[] args) {
		
		User user = new User("Riyaz", true, false, LocalDate.of(2018, 01, 10));
		Product usb = new Product();
		usb.setName("4 GB USB");
		usb.setPrice(100.0);
		usb.setGrocery(false);

		Product sugar = new Product();
		sugar.setName("5KG Sugar");
		sugar.setPrice(110.0);
		sugar.setGrocery(true);

		OrderItems orderItems = new OrderItems(usb, 4);
		OrderItems orderItems1 = new OrderItems(sugar, 2);

		Order order = new Order();
		order.setUser(user);
		order.addItems(orderItems);
		order.addItems(orderItems1);

		Bill bill = new Bill();
		bill.setOrder(order);
		
		DiscountService discount = new DiscountServiceImpl();
		System.out.println(discount.calculateDiscount(bill));		
		
	}

}
