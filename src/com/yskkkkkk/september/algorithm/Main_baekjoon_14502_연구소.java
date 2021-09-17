package com.yskkkkkk.september.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_baekjoon_14502_연구소 {

	static Point[] result = new Point[3];
	static List<Point> virus = new ArrayList<>();
	static int[][] map;
	static int n, m, zero;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		List<Point> points = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					points.add(new Point(i, j));
				if (map[i][j] == 2)
					virus.add(new Point(i, j));
			}
		}
		br.close();
		
		combination(0, 0, points);
		System.out.println(zero);
	}

	static void combination(int depth, int start, List<Point> points) {
		if (depth == 3) {
			setWall(result);
			return;
		}

		for (int i = start; i < points.size(); i++) {
			result[depth] = points.get(i);
			combination(depth + 1, i + 1, points);
		}
	}

	static void setWall(Point[] result) {
		int[][] copyMap = new int[n][m];
		for (int i = 0; i < map.length; i++) {
			copyMap[i] = Arrays.copyOf(map[i], map[i].length);
		}
		for (int i = 0; i < result.length; i++) {
			copyMap[result[i].x][result[i].y] = 1;
		}

		bfs(copyMap);
	}

	static void bfs(int[][] copyMap) {
		boolean[][] visited = new boolean[n][m];
		for (Point p : virus) {
			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] { p.x, p.y });
			visited[p.x][p.y] = true;

			while (!q.isEmpty()) {
				int[] current = q.poll();

				for (int i = 0; i < 4; i++) {
					int nx = current[0] + dx[i];
					int ny = current[1] + dy[i];

					if (nx >= 0 && ny >= 0 && nx < n && ny < m && visited[nx][ny] == false) {
						visited[nx][ny] = true;
						if (copyMap[nx][ny] == 0) {
							copyMap[nx][ny] = 2;
							q.offer(new int[] { nx, ny });
						} else if (copyMap[nx][ny] == 2) {
							q.offer(new int[] { nx, ny });
						}
					}
				}
			}
		}

		zero = Math.max(zero, countZero(copyMap));
	}

	static int countZero(int[][] copyMap) {
		int sum = 0;
		for (int[] is : copyMap) {
			for (int i : is) {
				if (i == 0)
					sum++;
			}
		}
		return sum;
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

	}
}
