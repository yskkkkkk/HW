package com.yskkkkkk.september.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_사람네트워크 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int peopleCount = Integer.parseInt(st.nextToken());
			int[][] relation = new int[peopleCount + 1][peopleCount + 1];

			int max = peopleCount * peopleCount;
			int result = max * peopleCount;
			
			for (int i = 1; i <= peopleCount; i++) {
				for (int j = 1; j <= peopleCount; j++) {
					int input = Integer.parseInt(st.nextToken());
					relation[i][j] = input == 0 && i!=j ? max : input;
				}
			}
			
			for (int i = 1; i <= peopleCount; i++) {
				int sum = 0;
				for (int j = 1; j <= peopleCount; j++) {
					if (relation[i][j] == max) {
						int min = max;
						for (int k = 1; k < peopleCount; k++) {
							if (min > relation[i][k] + relation[k][j]) 
								min = relation[i][k] + relation[k][j];
						}
						relation[i][j] = min;
					}
					sum += relation[i][j];
				}
				result = Math.min(result, sum);
			}
			
			System.out.println("#"+tc+" "+result);
		}
		br.close();
	}
}
