package com.course.mapeamentojpa.enums;

public enum OrderStatus {
	WAITING_PAYMENT("Waiting Paiment"),
	PAID("Paid"),
	SHIPPED("Shipped"),
	DELIVERED("Delivered"),
	CANCELED("Canceled");
	
	private String name;
	
	private OrderStatus(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
