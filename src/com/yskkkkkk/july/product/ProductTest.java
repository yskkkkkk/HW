package com.yskkkkkk.july.product;

import java.math.BigDecimal;
import java.util.Scanner;

public class ProductTest {

	public static void main(String[] args) {
		ProductMgrImpl productMgr = ProductMgrImpl.getInstance();
		
		productMgr.add(new Tv(1, "superTV", new BigDecimal("1190000"), 7, 52, "smart"));
		productMgr.add(new Tv(2, "mini portable tv", new BigDecimal("299000"), 30, 13, "portable"));
		productMgr.add(new Tv(3, "ultraX TV", new BigDecimal("1749000"), 5, 62, "smart"));
		productMgr.add(new Refrigerator(4, "편리한냉장고", new BigDecimal("1290000"), 10, 870));
		productMgr.add(new Refrigerator(5, "편리한 김치냉장고", new BigDecimal("690000"), 10, 330));
		
		Scanner sc = new Scanner(System.in);
		
		int input;
		do {
			System.out.println("<상품정보 관리>\r\n" + 
					"1.모든 tv검색 2.tv크기별 검색 3.모든 냉장고검색 4.냉장고 용량별 검색\n"
					+ "5.상품 번호로 검색 6.상품명으로 검색 7.상품가격 수정 8.모든재고 출력 9.전체재고 가격출력\n"
					+ "이외의 숫자를 입력하시면 종료됩니다.");
			System.out.print("번호입력 ==> ");
			input = sc.nextInt();
			switch (input) {
			case 1:
				System.out.println("\n**********************TV 목록**********************");
				for (Tv tv : productMgr.selectTv()) {
					System.out.println(tv);
				}
				break;
			case 2:
				System.out.print("최소인치입력 ==> ");
				int inch = sc.nextInt();
				System.out.println("\n**********************TV 목록**********************");
				for (Tv tv : productMgr.overInputInch(inch)) {
					System.out.println(tv);
				}
				break;
			case 3:
				System.out.println("\n**********************냉장고 목록**********************");
				for (Refrigerator refrigerator : productMgr.selectRefrigerator()) {
					System.out.println(refrigerator);
				}
				break;
			case 4:
				System.out.print("최소인치입력 ==> ");
				int capacity = sc.nextInt();
				System.out.println("\n**********************냉장고 목록**********************");
				for (Refrigerator refrigerator : productMgr.overInputCapacity(capacity)) {
					System.out.println(refrigerator);
				}
				break;
			case 5:
				System.out.print("상품번호입력 ==> ");
				int productNo = sc.nextInt();
				System.out.println("\n**********************상품 번호 단일 검색**********************");
				System.out.println(productMgr.selectByNo(productNo));
				break;
			case 6:
				System.out.print("상품명입력 ==> ");
				String productName = sc.next();
				System.out.println("\n**********************이름 포함 검색**********************");
				for (Product product : productMgr.selectByName(productName)) {
					System.out.println(product);
				}
				break;
			case 7:
				System.out.print("수정을 원하는 상품번호를 입력해주세요 ==> ");
				int updateNo = sc.nextInt();
				System.out.print("원하는 가격을 입력해주세요 ==> ");
				String updatePrice = sc.next();
				productMgr.updateProductPrice(updateNo, updatePrice);
				break;
			case 8:
				System.out.println("**********************모든 상품 목록**********************");
				productMgr.getAllList();
				break;
			case 9:
				System.out.println("\n상품 재고 가격 총합 : "+productMgr.getTotalPrice()+"원");
			}
		} while (input < 10 || input > 0);
		sc.close();		
	}
}
