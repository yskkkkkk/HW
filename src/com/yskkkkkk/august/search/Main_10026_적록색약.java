package com.yskkkkkk.august.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10026_적록색약 {

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		char[][] map = new char[n][n];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		br.close();
		
		boolean[][] visit = new boolean[n][n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visit[i][j]) {
					dfs(map, visit, i, j);
					count++;
				}
			}
		}	// 일반 계산

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = map[i][j] == 'G' ? 'R' : map[i][j];
			}
		}
		for (boolean[] bs : visit) {
			Arrays.fill(bs, false);
		}	// 색약 초기화 
		
		int countRG = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visit[i][j]) {
					dfs(map, visit, i, j);
					countRG++;
				}
			}
		}	// 색약 계산

		System.out.println(count+" "+countRG);
	}

	public static void dfs(char[][] map, boolean[][] visit, int x, int y) {
		visit[x][y] = true;
		char c = map[x][y];
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
			
			if (!visit[nx][ny] && map[nx][ny] == c)	dfs(map, visit, nx, ny);			
		}
	}
}
