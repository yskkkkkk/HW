package com.yskkkkkk.july;

import java.util.Scanner;

public class DigitTest1 {

	public static void main(String[] args) {
		//10의 자리가 0부터 9까지 있는 정수 배열
		int[] digits = {0,0,0,0,0,0,0,0,0,0};
		
		System.out.println("100미만의 정수 입력 프로그램입니다. 정지를 위해서는 0을 입력해주세요. ");
		Scanner sc = new Scanner(System.in);
	
		while(true) {
			int number = sc.nextInt();
			
			if (number == 0) {
				break;
			}else if (number>100 || number<0) {
				System.out.println("1이상 99이라의 양의 정수를 입력해 주세요.");
				continue;
			}
			digits[number/10] = digits[number/10] + 1;
		}
		sc.close();
		
		for (int i = 0; i < digits.length; i++) {
			if (digits[i] != 0) {
				System.out.println(i+" : "+digits[i]+"개");
			}
		}
		
	}
}
