package com.yskkkkkk.september.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_최장길이수열시간개선 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());

			int[] input = new int[n];
			int[] lis = new int[n];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}

			int size = 0;

			for (int i = 0; i < n; i++) {
				int insertIdx = Arrays.binarySearch(lis, 0, size, input[i]);
				insertIdx = Math.abs(insertIdx) - 1;
				lis[insertIdx] = input[i];

				if (size == insertIdx) size++;
			}
			System.out.println("#" + tc + " " + size);
		}
		br.close();
	}
}
