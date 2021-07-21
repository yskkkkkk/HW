package com.yskkkkkk.july;

import java.util.Scanner;

public class Solution22 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
	
		int t = sc.nextInt();
		
		for (int tc = 1; tc <= t; tc++) {
			int area = sc.nextInt();
			int numbers = sc.nextInt();
			int[][] testCases = new int[numbers][3];
			
			for (int i = 0; i < testCases.length; i++) {
				for (int j = 0; j < testCases[i].length; j++) {
					testCases[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 0; i < testCases.length; i++) {
				switch (testCases[i][2]) {
				case 1:
					move(i, 0, area, -1, testCases);
					break;
				case 2:
					move(i, 0, area, 1, testCases);
					break;
				case 3:
					move(i, 1, area, -1, testCases);
					break;
				case 4:
					move(i, 1, area, 1, testCases);
					break;
				}
			}
			int answer = 0;
			for (int[] is : testCases) {
				if (is[2] != 0) {
					answer ++;
				}
			}
			
			System.out.println("\n#"+tc+" "+answer);
		}
		sc.close();
	}
	
	static boolean collision(int index, int area, int[][] testCase) {
		for (int i = 0; i < testCase.length; i++) {
			if (i == index) continue;
			if (testCase[index][0] == testCase[i][0] && testCase[index][1] == testCase[i][1]) {
				testCase[index][0] = -1;
				testCase[index][1] = -1;
				testCase[index][2] = 0;
				break;
			}else if (testCase[index][0] >= area || testCase[index][0] < 0 || testCase[index][1] >= area || testCase[index][1] < 0 ) {
				testCase[index][0] = -1;
				testCase[index][1] = -1;
				testCase[index][2] = 0;
				break;
			}
		}
		return true;
	}

	static void move(int i, int j, int area, int direction, int[][] testCases) {
		testCases[i][j] += (3*direction);
		collision(i, area, testCases);
		testCases[i][j] += (2*direction);
		collision(i, area, testCases);
		testCases[i][j] += (1*direction);
		collision(i, area, testCases);
	}
}
