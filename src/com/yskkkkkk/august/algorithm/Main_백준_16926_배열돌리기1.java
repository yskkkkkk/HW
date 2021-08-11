package com.yskkkkkk.august.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_16926_배열돌리기1 {

	private static int n, m, r;
	private static int[][] array;

	private static int[] dx = { 0, 1, 0, -1 };
	private static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		array = new int[n+1][m+1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j = 1; j <= m; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int num = Math.min(n, m) / 2;

		for (int i = 0; i < r; i++) {
			circulate(num);
		}
		
		int[] sums = new int[n];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				System.out.print(array[i][j] + " ");
				sums[i-1] += array[i][j];
			}
			System.out.println();
		}

		Arrays.sort(sums);
		System.out.println(sums[0]);
	}// main

	private static void circulate(int num) {

		for (int i = 1; i <= num; i++) {
			int x = i;
			int y = i;
			int temp = array[x][y]; 

			int index = 0;

			while (index < 4) {

				int nx = x + dx[index];
				int ny = y + dy[index];

				if (nx < i || ny < i || nx > n - i + 1 || ny > m - i + 1) {
					index++;
				} else {
					array[x][y] = array[nx][ny];

					x = nx;
					y = ny;
				}

			} // while
			array[i + 1][i] = temp;
		} // for

	}// circulate()

}