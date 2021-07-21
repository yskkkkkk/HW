package com.yskkkkkk.july;

public class CircleArea {

	/*1. 반지름이 5Cm인 원의 넓이를 구하는 프로그램을 작성하세요.
	출력 예> 
	반지름이 5Cm인 원의 넓이는 ??.?Cm2입니다.*/
	
	public static void main(String[] args) {
		int round = 5;
		double area = round*round*3.14;
		
		System.out.println("반지름이 "+round+"Cm인 원의 넓이는 "+area+"Cm2입니다.");
	}
}
