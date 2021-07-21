package com.yskkkkkk.july;

import java.util.Scanner;

public class Compute {

	/*2. 두 개의 정수를 입력 받아 곱과 몫을 출력하시오.
	Package : com.java.first Class : Compute
	입력 예> 16 5
	출력 예>  
	곱=80
	몫=3*/
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 
		System.out.println("두개의 정수를 입력받아서 곱과 몫을 출력하는 프로그램입니다.");
		System.out.print("첫 번째 정수를 입력하세요 ....-> ");
		int first = sc.nextInt();
		System.out.print("두 번째 정수를 입력하세요 ....-> ");
		int second = sc.nextInt();
		sc.close();
		
		System.out.println("-----------------------------");
		System.out.println("곱 = "+first*second);
		System.out.println("몫 = "+first/second);
	}
}
