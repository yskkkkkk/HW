package com.yskkkkkk.august.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_창용마을무리의개수BFS {

	static int result;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= testCase; i++) {
			result = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] contact = new int[n + 1][n + 1];
			
			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				contact[x][y] = 1;
				contact[y][x] = 1;
			}
			
			int[] visit = new int[n + 1];
			bfsUseQueue(1, contact, visit);
			
			System.out.println("#"+i+" "+result);
		}
		br.close();
	}
	
	public static void bfsUseQueue(int v, int[][] contact, int[] visit) {
		result++;
		Queue<Integer> queue = new LinkedList<>();

		visit[v] = 1;
		queue.offer(v);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int k = 0; k < size; k++) {
				int i = queue.poll();
				for (int j = 1; j <= visit.length-1; j++) {
					if (contact[i][j] == 1 && visit[j] == 0) {
						visit[j] = 1;
						queue.offer(j);
					}
				}
			}
		}
		
		for (int i = 1; i < visit.length; i++) {
			if(visit[i]==0) bfsUseQueue(i, contact, visit);
		}
	}

}
