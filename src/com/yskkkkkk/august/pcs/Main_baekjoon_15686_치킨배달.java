package com.yskkkkkk.august.pcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 혼자 짠 원본 시간 메모리 조금 아쉬움
public class Main_baekjoon_15686_치킨배달 {

	private static Chicken[] chickens;
	private static Chicken[] result;
	private static int[][] town;
	private static int n;
	private static int m;
	private static int min = Integer.MAX_VALUE;
	private static int chickenCount;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		town = new int[n+1][n+1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				town[i][j] = Integer.parseInt(st.nextToken());
				if (town[i][j] == 2) chickenCount++;
			}
		}
		br.close();
		result = new Chicken[chickenCount-m];
		
		chickens = new Chicken[chickenCount];
		int index = 0;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (town[i][j] == 2) {
					chickens[index++] = new Chicken(i, j); 
				}
			}
		}
		makeCombination(0, 0);
		
		System.out.println(min);
	}
	
	private static void makeCombination(int count, int start) {
		if (count == chickenCount-m) {
			min = Math.min(min, calculator(result));
			return;
		}
		for (int i = start; i < chickens.length; i++) {
			result[count] = chickens[i];
			makeCombination(count+1, i+1);
		}
	}
	
	private static int calculator(Chicken[] closed) {
		int[][] townCopy = new int[n+1][n+1];
		Chicken[] remains = new Chicken[m];
		int index = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				townCopy[i][j] = town[i][j];
				for (int k = 0; k < closed.length; k++) {
					if (i == closed[k].getR() && j == closed[k].getS()) townCopy[i][j] = 0;
				}
				if (townCopy[i][j] == 2) {
					remains[index++] = new Chicken(i, j);
				}
			}
		}
		
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (townCopy[i][j]==1) {
					int number = Integer.MAX_VALUE;
					for (int k = 0; k < remains.length; k++) {
						number = Math.min(number, Math.abs(i-remains[k].getR())+Math.abs(j-remains[k].getS()));
					}
					sum += number;
				}
			}
		}
		return sum;
	}
	
	private static class Chicken{
		private int r;
		private int s;

		public int getR() {
			return r;
		}
		
		public int getS() {
			return s;
		}

		public Chicken(int r, int s) {
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
