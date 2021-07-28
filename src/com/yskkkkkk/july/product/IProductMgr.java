package com.yskkkkkk.july.product;

import java.util.ArrayList;

public interface IProductMgr {

	// 상품 추가
	public void add(Product product);
	
	// 상품정보 전체를 검색하는 기능
	public void getAllList();
	
	// 상품번호로 상품을 검색하는 기능
	public Product selectByNo(int productNo);
	
	// 상품명으로 상품을 검색하는 기능(상품명 부분 검색 가능)
	public ArrayList<Product> selectByName(String productName);
	
	// TV정보만 검색
	public ArrayList<Tv> selectTv();
	
	// Refrigerator만 검색
	public ArrayList<Refrigerator> selectRefrigerator();
	
	// 상품번호로 상품을 삭제하는 기능
	public void remove(int productNo);
	
	// 전체 재고 상품 금액을 구하는 기능
	public String getTotalPrice();
	
	// 400L 이상의 Refrigerator 검색
	public ArrayList<Refrigerator> overInputCapacity(int capacity);
	
	// 50inch 이상의 TV검색
	public ArrayList<Tv> overInputInch(int inch);
	
	// 상품번호와 가격을 입력 받아 상품 가격을 변경할 수 있는 기능
	public void updateProductPrice(int productNo, String price);
}
