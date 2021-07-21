package com.yskkkkkk.july;

import java.util.Scanner;

public class CheckPoint {

	/*3. “몸무게+100-키”를 비만수치 공식이라고 하자. 
	키와 몸무게를 자연수로 입력받아 첫 번째 줄에 비만수치를 출력하고, 비만수치가 0보다 크면 다음
	줄에 비만이라는 메시지를 출력하는 프로그램을 작성하시오. (출력형식은 아래 출력 예를 참고하세
	요.)
	Package : com.java.first Class : CheckPoint
	입력 예> 155 60
	출력 예> 
	비만수치는 5입니다.
	당신은 비만이군요*/
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 
		System.out.println("키와 몸무게를 이용한 비만수치 출력 프로그램입니다.");
		System.out.print("키와 몸무게를 입력하세요 (ex:키 몸무게)...-> ");
		int height = sc.nextInt();
		int weight = sc.nextInt();
		sc.close();
		
		int obesityRate = weight+100-height;
				
		System.out.println("-----------------------------");
		System.out.println("비만수치는 "+obesityRate+"입니다.");
		if(obesityRate > 0) {
			System.out.println("당신은 비만이군요.");	
		}
	}
}
