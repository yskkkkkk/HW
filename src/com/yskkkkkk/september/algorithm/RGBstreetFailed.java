package com.yskkkkkk.september.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGBstreetFailed {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] cost = new int[n+1][3];
		int index = 0;
		
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
				if (i == 1) {
					if (min > cost[i][j]) {
						min = cost[i][j];
						index = j;
					}
				}
			}
		}
		br.close();
		
		int arr[] = new int[n + 1];
		
		arr[1] = min;
		
		for (int i = 2; i <= n; i++) {
			if (index == 0) {
				if (cost[i][1] < cost[i][2]) index = 1;
				else index = 2;
				arr[i] = cost[i][index];
			}else if (index == 1) {
				if (cost[i][0] < cost[i][2]) index = 0;
				else index = 2;
				arr[i] = cost[i][index];
			}else if (index == 2) {
				if (cost[i][0] < cost[i][1]) index = 0;
				else index = 1;
				arr[i] = cost[i][index];
			}
		}
		
		int sum = 0;
		for (int i : arr) {
			sum += i;
		}
		
		System.out.println(sum);
		
	}
}
