package com.yskkkkkk.july.product;

import java.math.BigDecimal;

public class ProductTest {

	public static void main(String[] args) {
		ProductMgrImpl productMgr = ProductMgrImpl.getInstance();
		
		productMgr.add(new Tv(1, "superTV", new BigDecimal("1190000"), 7, 52, "smart"));
		productMgr.add(new Tv(2, "mini portable tv", new BigDecimal("299000"), 30, 13, "portable"));
		productMgr.add(new Tv(3, "ultraX TV", new BigDecimal("1749000"), 5, 62, "smart"));
		productMgr.add(new Refrigerator(4, "편리한냉장고", new BigDecimal("1290000"), 10, "870L"));
		productMgr.add(new Refrigerator(5, "편리한 김치냉장고", new BigDecimal("690000"), 10, "333L"));
		
		System.out.println("**********************모든 상품 목록**********************");
		productMgr.getAllList();
		
		System.out.println("\n**********************TV 목록**********************");
		for (Tv tv : productMgr.selectTv()) {
			System.out.println(tv);
		}
		System.out.println("\n**********************냉장고 목록**********************");
		for (Refrigerator refrigerator : productMgr.selectRefrigerator()) {
			System.out.println(refrigerator);
		}
		
		System.out.println("\n**********************상품 번호 단일 검색**********************");
		System.out.println(productMgr.selectByNo(2));
		
		System.out.println("\n**********************이름 포함 검색**********************");
		for (Product product : productMgr.selectByName("TV")) {
			System.out.println(product);
		}
		
		System.out.println("\n상품 재고 가격 총합 : "+productMgr.getTotalPrice()+"원");
	}
}
