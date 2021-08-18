package com.yskkkkkk.august.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_bj_쿼드트리 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];

		for (int i = 0; i < n; i++) {
			String string = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = Character.getNumericValue(string.charAt(j));
			}
		}
		calculator(map, 0, 0, n);
		br.close();
	}

	private static boolean check(int[][] map, int x, int y, int n) {
		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if (map[x][y] != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	private static void calculator(int[][] map, int x, int y, int n) {
		if (check(map, x, y, n)) {
			System.out.print(map[x][y]);
			return;
		}

		System.out.print("(");
		int s = n / 2;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				calculator(map, x + s * i, y + s * j, s);
			}
		}
		System.out.print(")");
	}
}
