package com.yskkkkkk.october.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14891_톱니바퀴 {
	static int n = 4, m = 8;
	static int[][] magnet = new int[n][m];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				magnet[i][j] = Character.getNumericValue(input.charAt(j));
			}
		}
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			boolean[] contactPoint = checkContact();
			check(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()), contactPoint);
		}
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += Math.pow(2, i) * magnet[i][0];
		}
		System.out.println(sum);
		br.close();
	}

	static boolean[] checkContact() {
		boolean[] result = new boolean[3];
		for (int i = 0; i < 3; i++) {
			if (magnet[i][2] != magnet[i + 1][6]) {
				result[i] = true;
			}
		}
		return result;
	}

	static void check(int index, int direction, boolean[] cp) {
		rotate(index, direction);
		switch (index) {
		case 0:
			if (cp[0])
				toRight(1, -direction, cp);
			break;
		case 1:
			if (cp[0])
				toLeft(0, -direction, cp);
			if (cp[1])
				toRight(2, -direction, cp);
			break;
		case 2:
			if (cp[1])
				toLeft(1, -direction, cp);
			if (cp[2])
				toRight(3, -direction, cp);
			break;
		case 3:
			if (cp[2])
				toLeft(2, -direction, cp);
			break;
		}
	}

	static void toRight(int index, int direction, boolean[] cp) {
		rotate(index, direction);
		if (index < n - 1 && cp[index])
			toRight(++index, -direction, cp);
	}

	static void toLeft(int index, int direction, boolean[] cp) {
		rotate(index, direction);
		if (index > 0 && cp[--index])
			toLeft(index, -direction, cp);
	}

	static void rotate(int index, int direction) {
		if (direction == 1) {
			int temporary = magnet[index][m - 1];
			for (int i = m - 1; i > 0; i--) {
				magnet[index][i] = magnet[index][i - 1];
			}
			magnet[index][0] = temporary;
		} else {
			int temporary = magnet[index][0];
			for (int i = 0; i < m - 1; i++) {
				magnet[index][i] = magnet[index][i + 1];
			}
			magnet[index][m - 1] = temporary;
		}
	}
}
