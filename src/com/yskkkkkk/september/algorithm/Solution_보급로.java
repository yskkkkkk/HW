package com.yskkkkkk.september.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution_보급로 {
	static int[][] map, distances;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testCase; t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			distances = new int[n][n];
			for (int i = 0; i < n; i++) {
				String st = br.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = Character.getNumericValue(st.charAt(j));
					distances[i][j] = Integer.MAX_VALUE;
				}

			}
			move();
			System.out.println("#" + t + " " + distances[n - 1][n - 1]);
		}

		br.close();
	}

	static void move() {
		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.add(new Point(0, 0, map[0][0]));
		distances[0][0] = map[0][0];
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			int x = point.r;
			int y = point.c;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < n && ny < n && (distances[nx][ny] > distances[x][y] + map[nx][ny])) {
					distances[nx][ny] = distances[x][y] + map[nx][ny];
					queue.add(new Point(nx, ny, distances[nx][ny]));
				}
			}
		}
	}

	static class Point implements Comparable<Point> {
		int r;
		int c;
		int cost;

		public Point(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		@Override
		public int compareTo(Point o) {
			return cost - o.cost;
		}
	}

}
