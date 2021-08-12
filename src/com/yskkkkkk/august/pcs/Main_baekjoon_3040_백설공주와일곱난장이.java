package com.yskkkkkk.august.pcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_baekjoon_3040_백설공주와일곱난장이 {

	static int[] dwarfs;
	static int N = 7;
	static int[] result = new int[N];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dwarfs = new int[9];

		for (int i = 0; i < 9; i++) {
			dwarfs[i] = Integer.parseInt(br.readLine());
		
		}
		
		makeCombination(0, 0);
		br.close();
	}

	private static void makeCombination(int count, int start) {
		if (count == N) {
			if (calculator() == 100) {
				for (int i : result) {
					System.out.println(i);
				}
			};
			return;
		}
		for (int i = start; i < dwarfs.length; i++) {
			result[count] = dwarfs[i];
			makeCombination(count+1, i+1);
		}
	}

	private static int calculator() {
		int sum = 0;
		for (int i : result) {
			sum += i;
		}
		return sum;
	}
}
