package com.yskkkkkk.july;

import java.math.BigDecimal;

public class ProductTest {

	public static void main(String[] args) {
		Tv tv = new Tv();
		tv.setProductNo(1);
		tv.setName("ssafy smart tv");
		tv.setPrice(new BigDecimal(2990000));
		tv.setAmount(1200);
		tv.setInch(52);
		tv.setType("smart TV");
		
		System.out.println(tv);
		System.out.println("해당 텔레비전의 크기는 "+tv.getInch()+"인치 입니다.");
		
		System.out.println("------------------------------------------");
		
		Refrigerator refrigerator = new Refrigerator();
		refrigerator.setProductNo(1);
		refrigerator.setName("ssafy 냉장고");
		refrigerator.setPrice(new BigDecimal(1900000));
		refrigerator.setAmount(400);
		refrigerator.setCapacity("870L");
	
		System.out.println(refrigerator);
		System.out.println("찾으시는 상품의 이름은 "+refrigerator.getName()+"입니다.");
	}
}
