package com.retail.store.discount.entity;

import java.time.LocalDate;
import java.util.Date;

public class User {
	private String name;
	private boolean isEmployee;
	private boolean isAffiliate;
	private LocalDate memberSince;
	
		
	public User(String name, boolean isEmployee, boolean isAffiliate, LocalDate memberSince) {
		super();
		this.name = name;
		this.isEmployee = isEmployee;
		this.isAffiliate = isAffiliate;
		this.memberSince = memberSince;
	}
	
	
	// getters setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isEmployee() {
		return isEmployee;
	}
	public void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}
	public boolean isAffiliate() {
		return isAffiliate;
	}
	public void setAffiliate(boolean isAffiliate) {
		this.isAffiliate = isAffiliate;
	}
	public LocalDate getMemberSince() {
		return memberSince;
	}
	public void setMemberSince(LocalDate memberSince) {
		this.memberSince = memberSince;
	}
	
	

}
