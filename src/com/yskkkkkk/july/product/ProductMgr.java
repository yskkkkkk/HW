package com.yskkkkkk.july.product;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;

public class ProductMgr {

	private static int MAX_SIZE = 10000;	
	private Product[] products = new Product[MAX_SIZE];
	private int size;
	
	// 싱글톤 객체 생성
	private static ProductMgr instance = new ProductMgr();
	private ProductMgr() {}
	public static ProductMgr getInstance(){
    	return instance;
	}
	
	public void add(Product product) {
		if (size<MAX_SIZE) products[size++] = product;
	}
	
	// 상품정보 전체를 검색하는 기능
	public Product[] getAllList() {
		return Arrays.copyOf(products, size);
	}
	
	// 상품번호로 상품을 검색하는 기능
	public Product selectByNo(int productNo) {
		Product product = new Product();
		for (Product p : products) {
			if (p.getProductNo() == productNo) {
				product = p;
				break;
			}
		}
		return product;
	}
	
	// 상품명으로 상품을 검색하는 기능(상품명 부분 검색 가능)
	public Product[] selectByName(String productName) {
		int arraySize = 0;
		for (Product p : products) {
			if (p != null && p.getName().contains(productName)) arraySize++;
		}
		
		Product[] result = new Product[arraySize];
		int resultSize = 0;
		for (Product p : products) {
			if (p != null && p.getName().contains(productName)) result[resultSize++] = p;
		}
		
		return result;
	}
	
	// TV정보만 검색
	public Tv[] selectTv() {
		int arraySize = 0;
		for (Product p : products) {
			if (p instanceof Tv) arraySize++;
		}
		
		Tv[] result = new Tv[arraySize];
		int resultSize = 0;
		for (Product p : products) {
			if (p instanceof Tv) result[resultSize++] = (Tv) p;
		}
		
		return result;
	}
	
	// Refrigerator만 검색
	public Refrigerator[] selectRefrigerator() {
		int arraySize = 0;
		for (Product p : products) {
			if (p instanceof Refrigerator) arraySize++;
		}
		
		Refrigerator[] result = new Refrigerator[arraySize];
		int resultSize = 0;
		for (Product p : products) {
			if (p instanceof Refrigerator) result[resultSize++] = (Refrigerator) p;
		}
		
		return result;
	}
	
	// 상품번호로 상품을 삭제하는 기능
	public void remove(int ProductNo) {		
		for (int i = 0; i < size; ++i) {
			if (products[i].getProductNo() == ProductNo) {
				products[i] = products[size-1];
				products[size-1]=null;			
				--size;
				break;
			}
		}
	}
	
	// 전체 재고 상품 금액을 구하는 기능
	public String getTotalPrice() {
		BigDecimal total = BigDecimal.ZERO;
		for (Product product : products) {
			if (product != null) {
				BigDecimal inventoryPrice = product.getPrice().multiply(new BigDecimal(product.getAmount()));
				total = total.add(inventoryPrice);
			}
		}
		DecimalFormat decimalFormat = new DecimalFormat("###,###");
		return decimalFormat.format(total);
	}
	
}
