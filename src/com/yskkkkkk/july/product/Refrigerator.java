package com.yskkkkkk.july.product;

import java.math.BigDecimal;

public class Refrigerator extends Product{
	
	private String capacity;
	
	public Refrigerator() {
	}

	public Refrigerator(int productNo, String name, BigDecimal price, int amount, String capacity) {
		super(productNo, name, price, amount);
		this.capacity = capacity;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return " [ProductNo=" + super.getProductNo() + 
				", name=" + super.getName() + 
				", price=" + super.getPrice() + 
				", amount=" + super.getAmount() + 
				", capacity=" + capacity+"]";
	}
	
}
