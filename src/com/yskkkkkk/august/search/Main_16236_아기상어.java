package com.yskkkkkk.august.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236_아기상어 {

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1 ,-1 ,0 ,0 };
	static int[][] map;
	static Shark shark;
	static int time;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					shark = new Shark(i, j, 2, 0, 0);
					map[i][j] = 0;
				}
			}
		}
		br.close();
		
		while(true) {
			PriorityQueue<Food> fishes = new PriorityQueue<>();
			Queue<Shark> q = new LinkedList<>();
			boolean visited[][] = new boolean[n][n];
			q.offer(shark);
			visited[shark.x][shark.y] = true;

			while(!q.isEmpty()) {
				shark = q.poll();

				for(int d = 0; d < 4; d++) {
					int nx = shark.x + dx[d];
					int ny = shark.y + dy[d];
					
					if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue; 
					if(visited[nx][ny]) continue;
					
					if(1 <= map[nx][ny] && map[nx][ny] < shark.size) {
						q.offer(new Shark(nx, ny, shark.size, shark.eatCount, shark.dist+1));
						fishes.offer(new Food(nx, ny, shark.dist + 1));
						visited[nx][ny] = true; 
					} 

					else if(map[nx][ny] == shark.size || map[nx][ny] == 0) {
						q.offer(new Shark(nx, ny, shark.size, shark.eatCount, shark.dist+1));
						visited[nx][ny] = true;
					}
				} 
			}
			if(fishes.size() == 0) break;

			Food fish = fishes.poll();
			time += fish.d;
			shark.eatCount++;
			map[fish.x][fish.y] = 0;

			if(shark.eatCount == shark.size) {
				shark.size++; 
				shark.eatCount = 0;
			}

			shark.x = fish.x;
			shark.y = fish.y;
			shark.dist = 0;
		}
		
		System.out.println(time);
	}

	static class Food implements Comparable<Food>{
		private int x;
		private int y;
		private int d;
		public Food(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}
		
		@Override
		public int compareTo(Food f) {
			int result = this.d - f.d;
			if (this.d == f.d) {
				result = this.x - f.x; 
				if (this.x == f.x) result = this.y - f.y;
			}
			return result;
		}
	}
	
	static class Shark{
		private int x;
		private int y;
		private int size;
		private int eatCount;
		private int dist;
		public Shark(int x, int y, int size, int eatCount, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
			this.eatCount = eatCount;
			this.dist = dist;
		}
	}
}
