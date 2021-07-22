package com.yskkkkkk.july;

import java.math.BigDecimal;

public class Product {

	private int ProductNo;
	private String name;
	private BigDecimal price;
	private int amount;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int productNo, String name, BigDecimal price, int amount) {
		super();
		ProductNo = productNo;
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	public int getProductNo() {
		return ProductNo;
	}

	public void setProductNo(int productNo) {
		ProductNo = productNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Product [ProductNo=" + ProductNo + ", name=" + name + ", price=" + price + ", amount=" + amount + "]";
	}
	
}
