package com.yskkkkkk.august.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_창용마을무리의개수DFS {

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
			
			boolean[] visited = new boolean[n+1];
			dfsUseStack(1, contact, visited, true);
			
			System.out.println("#"+i+" "+result);
		}
		br.close();
	}
	
	public static void dfsUseStack(int v, int[][] contact, boolean[] visited, boolean flag) {
		result++;
		int l = contact.length - 1;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(v);
		visited[v] = true;

		while (!stack.isEmpty()) {
			int w = stack.peek();
			flag = false;

			for (int i = 1; i <= l; i++) {
				if (contact[w][i] == 1 && !visited[i]) {
					stack.push(i);
					visited[i] = true;
					flag = true;

					break;
				}
			}

			if (!flag) {
				stack.pop();
			}
		}
		
		for (int i = 1; i < visited.length; i++) {
			if(!visited[i]) dfsUseStack(i, contact, visited, true);
		}
	}
}
