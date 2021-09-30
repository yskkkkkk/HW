package com.yskkkkkk.september.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_탈주범검거 {
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static String[] types = {"1367", "1345", "1247", "1256"};
	static int n, m;
	static Queue<Point> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testCase; t++) {
			q.clear();
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			map = new int[n][m];
			visited = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			visited[r][c] = true;
			q.offer(new Point(r, c, map[r][c]));
			int count = 1;
			for (int i = 0; i < l-1; i++) {
				count = move(count);
			}
			System.out.println("#"+t+" "+count);
		}

		br.close();
	}

	static int move(int count) {
		int size = q.size();
		for (int i = 0; i < size; i++) {
			Point current = q.poll();
			int[] direction = distinguishType(current.type);
			
			for (int j = 0; j < direction.length ; j++) {
				int nx = current.x + dx[direction[j]];
				int ny = current.y + dy[direction[j]];
				
				if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]) {
					if (map[nx][ny] != 0 && types[direction[j]].contains(String.valueOf(map[nx][ny]))) {
						visited[nx][ny] = true;
						q.offer(new Point(nx, ny, map[nx][ny]));
						count++;
					}
				}
			}
		}
		return count;
	}
	
	static int[] distinguishType(int type) {
		switch (type) {
		case 1:
			return new int[] {0, 1, 2, 3};
		case 2:
			return new int[] {2, 3};
		case 3:
			return new int[] {0, 1};
		case 4:
			return new int[] {0, 3};
		case 5:
			return new int[] {0, 2};
		case 6:
			return new int[] {1, 2};
		case 7:
			return new int[] {1, 3};
		default:
			return new int[0];
		}
	}
	
	static class Point {
		int x;
		int y;
		int type;
		public Point(int x, int y, int type) {
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}
	
}
