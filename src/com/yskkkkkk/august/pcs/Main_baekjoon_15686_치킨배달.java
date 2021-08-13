package com.yskkkkkk.august.pcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 조원의 도움을 받아서 개선한 버전 
public class Main_baekjoon_15686_치킨배달 {

	private static int[][] town;
	private static Place[] chickens;
	private static Place[] homes;
	private static Place[] result;
	private static int n, m;
	private static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		result = new Place[m];

		town = new int[n + 1][n + 1];

		int homeCount = 0;
		int chickenCount = 0;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				town[i][j] = Integer.parseInt(st.nextToken());
				if (town[i][j] == 1) homeCount++;
				else if (town[i][j] == 2) chickenCount++;
			}
		}
		br.close();
		
		homes = new Place[homeCount];
		chickens = new Place[chickenCount];

		int homeIndex = 0;
		int chickenIndex = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (town[i][j] == 1) homes[homeIndex++] = new Place(i, j);
				else if (town[i][j] == 2) chickens[chickenIndex++] = new Place(i, j);
			}
		}
		makeCombination(0, 0);

		System.out.println(min);
	}

	private static void makeCombination(int count, int start) {
		if (count == m) {
			min = Math.min(min, calculator(result));
			return;
		}
		for (int i = start; i < chickens.length; i++) {
			result[count] = chickens[i];
			makeCombination(count + 1, i + 1);
		}
	}

	private static int calculator(Place[] remainChickens) {
		int sum = 0;
		
		for (Place p1 : homes) {
			int number = Integer.MAX_VALUE;
			for (Place p2 : remainChickens) {
				number = Math.min(number, Math.abs(p1.getR()-p2.getR()) + Math.abs(p1.getS()-p2.getS()));  
			}
			sum += number;
		}

		return sum;
	}

	private static class Place {
		private int r;
		private int s;

		public int getR() {
			return r;
		}

		public int getS() {
			return s;
		}

		public Place(int r, int s) {
			super();
			this.r = r;
			this.s = s;
		}

		@Override
		public String toString() {
			return "Chicken [r=" + r + ", s=" + s + "]";
		}
	}
}
