package com.yskkkkkk.august.algorithm;

import java.util.Scanner;

public class SwitchOnOff {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] switches = new int[sc.nextInt()];					// 스위치 갯수
		
		for (int i = 0; i < switches.length; i++) {
			switches[i] = sc.nextInt();							// 상태 입력
		}
		
		int roop = sc.nextInt();								// 학생 반복 수 
		for (int i = 0; i < roop; i++) {
			int gender = sc.nextInt();
			if (gender == 1) {									// 남학생
				int number = sc.nextInt();
				for (int j = number; j < switches.length; j+=number) {
					switches[j-1] = (switches[j-1]+1)%2;		// 1이면 0으로 0이면 1로 
				}
			} else if (gender == 2) {							// 여학생
				int number = sc.nextInt()-1;
				int j = 1;
				while (number-j > 0 && number+j < switches.length) {
					if (switches[number-j] == switches[number+j]) {
						j++;
					} else {
						break;
					}
				}
				if (switches.length <= 2) j--;					// 다만 길이가 너무 짧을 떄는 j값 조정
				for (int k = number-j; k <= number+j; k++) {
					switches[k] = (switches[k]+1)%2;
				}
			}
		}
		sc.close();
		
		for (int d = 0; d < switches.length; d++) {
			if (d%20 == 0) System.out.println();
			System.out.print(switches[d]+" ");
		}
	}
}
