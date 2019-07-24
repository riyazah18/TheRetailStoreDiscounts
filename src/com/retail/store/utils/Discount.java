package com.retail.store.utils;

public enum Discount {
	
		THIRTY_PERCENT(30), TEN_PERCENT(10), FIVE_PERCENT(5);
	
		private double value;  
		private Discount(double value){  
		this.value=value;  
		}
		public double getValue() {
			return value;
		}
		public void setValue(double value) {
			this.value = value;
		}
		
	

}
