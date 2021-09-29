package com.yskkkkkk.september.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_젤다 {

	static int[][] map, distances;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = 1;
		while (true) {
			n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			map = new int[n][n];
			distances = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					distances[i][j] = Integer.MAX_VALUE;
				}
			}
			move();
			System.out.println("Problem "+testCase+++": "+distances[n-1][n-1]);
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
	
    static class Point implements Comparable<Point>{
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
