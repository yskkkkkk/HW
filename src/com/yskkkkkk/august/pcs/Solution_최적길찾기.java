package com.yskkkkkk.august.pcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_최적길찾기 {

	static Place[] ps, result;
	static Place home, company;
	static boolean[] selected;
	static int n, min;
	
	public static void main(String[] args) throws IOException{
		long startTime = System.currentTimeMillis();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < testCase; i++) {
			min = Integer.MAX_VALUE;
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			home = new Place(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			company = new Place(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			ps = new Place[n];
			result = new Place[n];
			selected = new boolean[n];
			for (int j = 0; j < n; j++) {
				ps[j] = new Place(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			makePermutation(0);
			
			System.out.println("#"+(i+1)+" "+min);
		}
		br.close();

		long endTime = System.currentTimeMillis();
		System.out.println("TIME : " + (endTime - startTime) + "(ms)");
	}
	
	static void makePermutation(int depth) {
		if (depth == n) {
			calculator(result);
			return;
		}
		for (int i = 0; i < n; i++) {
			if(!selected[i]) {
				result[depth] = ps[i];
				selected[i] = true;
				makePermutation(depth+1);
				selected[i] = false;
			}
		}
	}
	
	static void calculator(Place[] result) {
		int sum = distance(home, result[0]);
		for (int i = 0; i < result.length-1; i++) {
			sum += distance(result[i], result[i+1]);
		}
		sum += distance(result[n-1], company);
		
		min = Math.min(min, sum);
	}
	
	static int distance(Place p1, Place p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}
	
	static class Place{
		private int x;
		private int y;
		public Place(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
