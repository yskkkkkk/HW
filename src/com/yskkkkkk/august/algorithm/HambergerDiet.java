package com.yskkkkkk.august.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HambergerDiet {

	static int max = 0;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int caseCount = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < caseCount; i++) {
			st = new StringTokenizer(br.readLine());
			
			int testCase = Integer.parseInt(st.nextToken());
			int calorie = Integer.parseInt(st.nextToken());
			
			int[][] cases = new int[testCase][2];
			
			for (int j = 0; j < testCase; j++) {
				st = new StringTokenizer(br.readLine());
				cases[j][0] = Integer.parseInt(st.nextToken());
				cases[j][1] = Integer.parseInt(st.nextToken());
			}
			
			subset(cases, 0, calorie, new boolean[cases.length]);
			System.out.println("#"+(i+1)+" "+max);
		}
		br.close();
	}
	
	static void subset(int[][] arr, int idx, int calorie, boolean[] sel) {
		
		if (idx == arr.length) {
			int sum = 0;
			int calSum = 0;
			for (int i = 0; i < sel.length; i++) {
				if (sel[i])	sum += arr[i][1];
			}
			if (sum <= calorie) {
				for (int i = 0; i < sel.length; i++) {
					if (sel[i])	calSum += arr[i][0];
				}
			}
			if (max < calSum) {
				max = calSum;
			}
			return;
		}

		sel[idx] = true;
		subset(arr, idx + 1, calorie, sel);
		sel[idx] = false;
		subset(arr, idx + 1, calorie, sel);
		return;
	}
	
}
