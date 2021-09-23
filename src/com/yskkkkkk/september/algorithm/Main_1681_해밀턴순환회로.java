package com.yskkkkkk.september.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1681_해밀턴순환회로 {

	static int[][] map;
	static boolean[] selected;
	static int n, count, answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		selected = new boolean[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		br.close();

		permutation(0, 0, 0);
		System.out.println(answer);
	}

	static void permutation(int cur, int depth, int sum) {
		if (depth == n-1) {
			if (map[cur][0] == 0) return;
			sum += map[cur][0];
			answer = Math.min(answer, sum);
			return;
		}

		for (int i = 1; i < n; i++) {
			if (!selected[i] && map[cur][i] != 0 && sum + map[cur][i] < answer) {
				selected[i] = true;
				permutation(i, depth + 1, sum + map[cur][i]);
				selected[i] = false;
			}
		}
	}
}