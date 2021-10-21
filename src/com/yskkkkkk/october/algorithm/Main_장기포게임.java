package com.yskkkkkk.october.algorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_장기포게임 {
	static Point po;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int[][] map;
	static boolean[][] isCatched;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			isCatched = new boolean[n][n];
			
			List<Point> ps = new ArrayList<>();
			for (int i = 0; i < map.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1)
						ps.add(new Point(i, j));
					else if (map[i][j] == 2)
						po = new Point(i, j);
				}
				
			}
			
			List<Point> fMove = check(po, 1);
			for (Point f : fMove) {
				List<Point> sMove = check(f, 2);
				for (Point s : sMove) {
					checkLast(f, s);
				}
			}
			
			int sum = 0;
			for (boolean[] ba : isCatched) {
				for (boolean b : ba) {
					if (b) sum++;
				}
			}
			
			System.out.println("#" + tc + " "+sum);
		}
		br.close();
	}
	

	static void checkLast(Point p1, Point p2) {
		int[][] copyMap = new int[n][n];
		for (int i = 0; i < copyMap.length; i++) {
			copyMap[i] = Arrays.copyOf(map[i], map[i].length);
		}
		copyMap[po.x][po.y] = 0;
		copyMap[p1.x][p1.y] = 0;			
		
		for (int i = 0; i < 4; i++) {
			int x = p2.x + dx[i];
			int y = p2.y + dy[i];
			boolean flag = false;
			while (true) {
				if (x >= n || y >=n || x < 0 || y < 0) break;
				if (copyMap[x][y] == 0) {
					x += dx[i];
					y += dy[i];
					continue;
				}else if(copyMap[x][y] == 1){
					if(!flag) {
						flag = true;
						x += dx[i];
						y += dy[i];
						continue;
					}else {
						isCatched[x][y] = true;
						break;
					}
				}
			}
		}
	}
	
	static List<Point> check(Point p, int index) {
		int[][] copyMap = new int[n][n];
		for (int i = 0; i < copyMap.length; i++) {
			copyMap[i] = Arrays.copyOf(map[i], map[i].length);
		}
		if (index == 2) copyMap[po.x][po.y] = 0;
		
		List<Point> movePoint = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			int x = p.x + dx[i];
			int y = p.y + dy[i];
			boolean flag = false;
			while (true) {
				if (x >= n || y >=n || x < 0 || y < 0) break;
				if (copyMap[x][y] == 0) {
					if(flag) movePoint.add(new Point(x, y));
					
					x += dx[i];
					y += dy[i];
					continue;
				}else if(copyMap[x][y] == 1){
					if(!flag) {
						flag = true;
						x += dx[i];
						y += dy[i];
						continue;
					}else {
						isCatched[x][y] = true;
						movePoint.add(new Point(x, y));
						break;
					}
				}
			}
		}
		return movePoint;
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
