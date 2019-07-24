package com.retail.store.discount.services;

import java.time.LocalDate;

import com.retail.store.discount.entity.Bill;
import com.retail.store.discount.entity.OrderItems;
import com.retail.store.discount.interfaces.DiscountService;
import com.retail.store.utils.Discount;

public class DiscountServiceImpl implements DiscountService {
	
	
	
	public double discount(Bill bill){
		if(bill !=null){			
				calculateDiscount(bill);			
		}		
		return 0;
		
	}
	
	public double calculateDiscount(Bill bill){
		double nonGroceriesTotalAmount =0;
		double groceriesTotalAmount =0;
		double totalAmount=0;
		double groceriesDiscount=0;		
		// If the user is an employee of the store, he gets a 30% discount
		if(bill.getOrder().getUser().isEmployee()){
			for (OrderItems items : bill.getOrder().getItems()) {
				if(!items.getProduct().isGrocery()){
					nonGroceriesTotalAmount+=items.getProduct().getPrice() * (items.getQunatity() !=0 ? items.getQunatity():1);
				}
				if(items.getProduct().isGrocery()){
					groceriesTotalAmount+=items.getProduct().getPrice() * (items.getQunatity() !=0 ? items.getQunatity():1);
				}
				
				
			}
			totalAmount=nonGroceriesTotalAmount+groceriesTotalAmount;
			bill.setTotalAmount(totalAmount);
			bill.setTotalDiscount(calculatePercentageViseDiscount(nonGroceriesTotalAmount,Discount.THIRTY_PERCENT.getValue()));
			bill.setDiscountedAmount(bill.getTotalAmount() - bill.getTotalDiscount());
			if(groceriesTotalAmount >=100){
				groceriesDiscount=calculateSimpleDiscount(groceriesTotalAmount);
				return bill.getDiscountedAmount()-groceriesDiscount;
			}
			return bill.getDiscountedAmount();
			
		}
		
		// If the user is an affiliate of the store, he gets a 10% discount
		else if(bill.getOrder().getUser().isAffiliate()){
			for (OrderItems items : bill.getOrder().getItems()) {
				if(!items.getProduct().isGrocery()){
					nonGroceriesTotalAmount+=items.getProduct().getPrice() * (items.getQunatity() !=0 ? items.getQunatity():1);
				}
				if(items.getProduct().isGrocery()){
					groceriesTotalAmount+=items.getProduct().getPrice() * (items.getQunatity() !=0 ? items.getQunatity():1);
				}
				
				
			}
			totalAmount=nonGroceriesTotalAmount+groceriesTotalAmount;
			bill.setTotalAmount(totalAmount);
			bill.setTotalDiscount(calculatePercentageViseDiscount(nonGroceriesTotalAmount,Discount.TEN_PERCENT.getValue()));
			bill.setDiscountedAmount(bill.getTotalAmount() - bill.getTotalDiscount());
			if(groceriesTotalAmount >=100){
				groceriesDiscount=calculateSimpleDiscount(groceriesTotalAmount);
				return bill.getDiscountedAmount()-groceriesDiscount;
			}
			return bill.getDiscountedAmount();
			
		}
		
		// If the user has been a customer for over 2 years, he gets a 5% discount.
		else if(bill.getOrder().getUser().getMemberSince() !=null){
			LocalDate currentDate = LocalDate.now();
			LocalDate memberSince = bill.getOrder().getUser().getMemberSince();			
			long years = java.time.temporal.ChronoUnit.YEARS.between( memberSince , currentDate );
		    if(years >=2){
		    	for (OrderItems items : bill.getOrder().getItems()) {
					if(!items.getProduct().isGrocery()){
						nonGroceriesTotalAmount+=items.getProduct().getPrice() * (items.getQunatity() !=0 ? items.getQunatity():1);
					}
					if(items.getProduct().isGrocery()){
						groceriesTotalAmount+=items.getProduct().getPrice() * (items.getQunatity() !=0 ? items.getQunatity():1);
					}
					
					
				}
				totalAmount=nonGroceriesTotalAmount+groceriesTotalAmount;
				bill.setTotalAmount(totalAmount);
				bill.setTotalDiscount(calculatePercentageViseDiscount(nonGroceriesTotalAmount,Discount.FIVE_PERCENT.getValue()));
				bill.setDiscountedAmount(bill.getTotalAmount() - bill.getTotalDiscount());
				if(groceriesTotalAmount >=100){
					groceriesDiscount=calculateSimpleDiscount(groceriesTotalAmount);
					return bill.getDiscountedAmount()-groceriesDiscount;
				}
				return bill.getDiscountedAmount();
		    }			
			
		}
		return 0;
		
	}

	@Override
	public double calculatePercentageViseDiscount(double amount, double percentage) {
		int occurrence=0;
		
		if(amount >=100)
		{
			occurrence=(int)amount / 100;
			occurrence*=5;
		}
		return amount = (amount * percentage / 100) + occurrence;		
	}

	@Override
	public double calculateSimpleDiscount(double amount) {
       int occurrence=0;
		
		if(amount >=100)
		{
			occurrence=(int)amount / 100;
			occurrence*=5;
		}
		return amount = occurrence;	
	}	
	

}
