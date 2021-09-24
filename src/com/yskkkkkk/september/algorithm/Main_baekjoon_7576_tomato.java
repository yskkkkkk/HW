package com.yskkkkkk.september.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_baekjoon_7576_tomato {

	static int[][] map;
	static boolean[][] visited;
	static int h, w, count, time;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		map = new int[h][w];
		visited = new boolean[h][w];

		List<Point> points = new ArrayList<>();
		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					count++;
				else if (map[i][j] == 1)
					points.add(new Point(i, j));
			}
		}
		br.close();

		mature(points);

		if (count != 0) time = -1;
		System.out.println(time);
	}

	static void mature(List<Point> p) {
		List<Point> newPoints = new ArrayList<>();
		for (int i = 0; i < p.size(); i++) {
			for (int j = 0; j < 4; j++) {
				int nx = p.get(i).x + dx[j];
				int ny = p.get(i).y + dy[j];

				if (nx >= 0 && ny >= 0 && nx < h && ny < w && !visited[nx][ny]) {
					if (map[nx][ny] == 0) {
						map[nx][ny] = 1;
						count--;
						newPoints.add(new Point(nx, ny));
					}
				}
			}
		}
		
		if (newPoints.size() != 0) {
			time++;
			mature(newPoints);
		}
	}

	static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
