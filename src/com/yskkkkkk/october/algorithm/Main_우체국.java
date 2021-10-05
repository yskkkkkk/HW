package com.yskkkkkk.october.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_우체국 {

	static int[] result, village, office;
	static int V, P, min;
	static long L;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		min = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		L = Long.parseLong(st.nextToken());

		village = new int[V];
		result = new int[P];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < village.length; i++) {
			village[i] = Integer.parseInt(st.nextToken());
		}

		office = new int[P]; 

		combination(0, 0);

		System.out.println(min);
		for (int i : office) {
			System.out.print(i + " ");
		}
	}

	static void combination(int depth, int start) {
		if (depth == P) {
			int tmp = calculator(result);
			if (min > tmp) { 
				min = tmp;
				office = Arrays.copyOf(result, result.length);
			}
			return;
		}
		for (int i = start; i < V; i++) {
			result[depth] = village[i];
			combination(depth + 1, i + 1);
		}
	}

	static int calculator(int[] result) {
		int sum = 0;
		for (int i = 0; i < village.length; i++) {
			long min = Integer.MAX_VALUE;
			for (int j = 0; j < result.length; j++) {
				long d = Math.min(Math.abs(result[j] - village[i]), L - Math.abs(result[j] - village[i]));
				min = Math.min(min, d);
				if (d == 0)
					break;
			}
			sum += min;
		}
		return sum;
	}

}
