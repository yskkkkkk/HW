package com.yskkkkkk.september.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_baekjoon_17144_미세먼지 {

	static int[][] map;
	static int r, c, t;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		map = new int[r][c];
		List<Point> airFresher = new ArrayList<>();
		
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) airFresher.add(new Point(i, j, -1));
			}
		}
		br.close();

		for (int tc = 0; tc < t; tc++) {
			List<Point> points = new ArrayList<>();
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (map[i][j] != 0 && map[i][j] != -1 && map[i][j] >= 5)
						points.add(new Point(i, j, map[i][j]));
				}
			}
			dispersion(points);
			circle(airFresher);
		}
		
		int sum = 0;
		for (int[] is : map) {
			for (int i : is) {
				if (i != -1) sum+=i;
			}
		}
		System.out.println(sum);
		
	}

	static void dispersion(List<Point> p) {
		for (int i = 0; i < p.size(); i++) {
			int dust = p.get(i).dust;
			int spread = dust/5;
			for (int j = 0; j < 4; j++) {
				int nx = p.get(i).x + dx[j];
				int ny = p.get(i).y + dy[j];

				if (nx >= 0 && ny >= 0 && nx < r && ny < c && map[nx][ny] != -1) {
					map[nx][ny] += spread;
					map[p.get(i).x][p.get(i).y] -= spread;
				}
			}
		}
	}
	
	static void circle(List<Point> airFresher) {
		int x = airFresher.get(0).x-1;
		int y = airFresher.get(0).y;
		for (int i = 0; i < airFresher.get(0).x-1; i++) {
			map[x][y] = map[--x][y];
		}
		for (int i = 0; i < c-1; i++) {
			map[x][y] = map[x][++y];
		}
		for (int i = 0; i < airFresher.get(0).x; i++) {
			map[x][y] = map[++x][y];
		}
		for (int i = 0; i < c-2; i++) {
			map[x][y] = map[x][--y];
		}
		map[x][y] = 0;
		
		x = airFresher.get(1).x+1;
		y = airFresher.get(1).y;
		for (int i = 0; i < r - airFresher.get(1).x - 2; i++) {
			map[x][y] = map[++x][y];
		}
		for (int i = 0; i < c-1; i++) {
			map[x][y] = map[x][++y];
		}
		for (int i = 0; i < r - airFresher.get(1).x - 1; i++) {
			map[x][y] = map[--x][y];
		}
		for (int i = 0; i < c-2; i++) {
			map[x][y] = map[x][--y];
		}
		map[x][y] = 0;
	}

	static class Point {
		int x;
		int y;
		int dust;
		public Point(int x, int y, int dust) {
			super();
			this.x = x;
			this.y = y;
			this.dust = dust;
		}
	}
}
