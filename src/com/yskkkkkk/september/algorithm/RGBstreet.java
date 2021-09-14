package com.yskkkkkk.september.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RGBstreet {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] cost = new int[n + 1][3];

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();

		int arr[][] = new int[n + 1][3];
		for (int i = 1; i <= n; i++) {
			arr[i][0] = Math.min(arr[i - 1][1], arr[i - 1][2]) + cost[i][0];
			arr[i][1] = Math.min(arr[i - 1][0], arr[i - 1][2]) + cost[i][1];
			arr[i][2] = Math.min(arr[i - 1][0], arr[i - 1][1]) + cost[i][2];
		}

		Arrays.sort(arr[n]);
		
		System.out.println(arr[n][0]);
		
	}
}
