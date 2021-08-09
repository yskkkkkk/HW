package com.yskkkkkk.august.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SpotMart {

	private static int[] choice = new int[2];
	private static int limit;
	private static int sum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int testCase = Integer.parseInt(br.readLine());
		for (int i = 1; i <= testCase; i++) {
			sum = -1;
			st = new StringTokenizer(br.readLine());
			int snack = Integer.parseInt(st.nextToken());
			limit = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int[] input = new int[snack];
			for (int j = 0; j < snack; j++) {
				input[j] = Integer.parseInt(st.nextToken());
			}
			combination(0, 0, snack, 2, input);
			System.out.println("#"+i+" "+ sum);

		}
	}

	private static void combination(int index, int depth, int n, int r, int[] input) {
		
		if (depth == r) {
			if ( sum == -1 && choice[0] + choice[1] <= limit) {
				sum = choice[0] + choice[1];
			} else if ( sum < choice[0] + choice[1] && choice[0] + choice[1] <= limit) {
				sum = choice[0] + choice[1];
			}
			return;
		}
		if (index == n)
			return;

		choice[depth] = input[index];
		combination(index + 1, depth + 1, n, 2, input);
		combination(index + 1, depth, n, 2, input);
	}

}
