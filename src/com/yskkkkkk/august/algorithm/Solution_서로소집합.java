package com.yskkkkkk.august.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_서로소집합 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] parent;
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= t; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			parent = new int[n+1];
			for (int j = 1; j <= n; j++) {
				parent[j] = j;
			}
			
			StringBuilder sb = new StringBuilder();
			
			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				
				if (st.nextToken().equals("0")) {
					union(parent, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				}else {
					if(check(parent, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))) sb.append("1");
					else sb.append("0");
				}
				
			}
			System.out.println("#"+i+" "+sb.toString());
			
		}
		br.close();
		
	}
	
	static int find(int[] parent, int x) {
	    if (x == parent[x]) return x;
	    return parent[x] = find(parent, parent[x]);
	}
	
	static void union(int[] parent, int x, int y) {
		int px = find(parent, x);
		int py = find(parent, y);
	
		if (px != py) parent[py] = px;
	}
	
	static boolean check(int[] parent, int x, int y) {
		return find(parent, x) == find(parent, y);
	}
}
