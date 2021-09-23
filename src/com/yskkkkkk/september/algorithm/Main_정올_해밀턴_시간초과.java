package com.yskkkkkk.september.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정올_해밀턴_시간초과 {

	static int n;
	static int[] input, result;
	static boolean[] selected;
	static int[][] map;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		input = new int[n - 1];
		selected = new boolean[n - 1];
		result = new int[n - 1];
		for (int i = 0; i < n - 1; i++) {
			input[i] = i + 1;
		}

		for (int i = 0; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		permutation(0, 0);

		System.out.println(min);
		br.close();
	}

	private static void permutation(int cur, int depth) {
		if (depth == n - 1) {
			calculator(result);
			return;
		}
		for (int i = 0; i < n - 1; i++) {
	
			if (!selected[i]) {
				result[depth] = input[i];
				selected[i] = true;
				permutation(i, depth + 1);
				selected[i] = false;
			}
		}
	}

	static void calculator(int[] result) {
		System.out.println(Arrays.toString(result));
		int index = 0;
		int sum = 0;
		for (int i = 0; i < result.length; i++) {
			if (map[index][result[i]] == 0)
				sum += (int) 1e4;
			sum += map[index][result[i]];
			if (sum > min) break;
			index = result[i];
		}
		if (map[index][0] == 0) sum += (int) 1e4;
		sum += map[index][0];
		min = Math.min(min, sum);
	}

}
