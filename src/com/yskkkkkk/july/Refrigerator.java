package com.yskkkkkk.july;

public class Refrigerator extends Product{
	
	private String capacity;
	
	public Refrigerator() {
		// TODO Auto-generated constructor stub
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Product [ProductNo=" + super.getProductNo() + 
				", name=" + super.getName() + 
				", price=" + super.getPrice() + 
				", amount=" + super.getAmount() + 
				", capacity=" + capacity+"]";
	}
	
}
