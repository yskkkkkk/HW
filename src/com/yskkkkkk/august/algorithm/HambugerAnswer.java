package com.yskkkkkk.august.algorithm;

import java.io.*;
import java.util.*;

public class HambugerAnswer {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int testCase = Integer.parseInt(br.readLine());
		for (int i = 1; i <= testCase; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());		// 재료의 수
			int limit = Integer.parseInt(st.nextToken());	// 제한 칼로리
			
			int[][] arr = new int[n][2];					// 재료를 집어넣을 이차원배열
			int[] depth = new int[limit+1];					// 각각 칼로리에 맞춘 

			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				arr[j][0] = Integer.parseInt(st.nextToken());	// 재료의 맛
				arr[j][1] = Integer.parseInt(st.nextToken());	// 재료의 칼로리
			}
			
			for (int j = 0; j < n; j++) {
				for (int k = limit; k >= arr[j][1]; k--) {
					depth[k] = Math.max(depth[k], depth[k - arr[j][1]] + arr[j][0]);
				}
			}

			for (int j : depth) {
				System.out.println(j);
			}
			
			System.out.println("#"+i+" "+depth[limit]);
		}
	}
}


