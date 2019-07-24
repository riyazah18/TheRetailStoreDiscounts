package com.retail.store.discount.interfaces;

import com.retail.store.discount.entity.Bill;

public interface DiscountService {
	 double discount(Bill bill);
	 double calculateDiscount(Bill bill);
	 double calculatePercentageViseDiscount(double ammount, double percentage);
	 double calculateSimpleDiscount(double amount);

}
