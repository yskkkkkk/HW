package com.yskkkkkk.july.product;

import java.math.BigDecimal;

public class Tv extends Product{

	private int inch;
	private String type;
	
	public Tv() {
		// TODO Auto-generated constructor stub
	}
	
	public Tv(int productNo, String name, BigDecimal price, int amount, int inch, String type) {
		super(productNo, name, price, amount);
		this.inch = inch;
		this.type = type;
	}
	
	

	public int getInch() {
		return inch;
	}
	public void setInch(int inch) {
		this.inch = inch;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ProductTest [productNo=" + super.getProductNo() + 
				", name=" + super.getName() + 
				", price=" + super.getPrice() + 
				", amount=" + super.getAmount() + 
				", inch=" + inch + 
				", type=" + type + "]";
	}

}
