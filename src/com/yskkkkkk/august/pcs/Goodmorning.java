package com.yskkkkkk.august.pcs;

import java.util.Arrays;

public class Goodmorning {

	static int N = 3, R = 2;
	static int[] input = { 0, 1, 2 };
	static boolean[] selected = new boolean[N];
	static int[] result = new int[R];

	public static void main(String[] args) {

		System.out.println("----permutation----");
		permutation(0);

		System.out.println("----combination----");
		combination(0, 0);

		System.out.println("----subset----");
		subset(0);

	}

	private static void permutation(int depth) {
		if (depth == R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!selected[i]) {
				result[depth] = input[i];
				selected[i] = true;
				permutation(depth + 1);
				selected[i] = false;
			}
		}
	}

	private static void combination(int depth, int start) {
		if (depth == R) {
			System.out.println(Arrays.toString(result));
			return;
		}

		for (int i = start; i < N; i++) {
			result[depth] = input[i];
			combination(depth + 1, i + 1);
		}
	}

	private static void subset(int depth) {
		if(depth==N) {
			   System.out.print("부분집합>>> ");
			   for(int i=0; i<N; i++) {
				   if(selected[i])
				   System.out.print(input[i]+" ");
			   }
			   System.out.println();
			   return;
			}
	        selected[depth]=true;
			subset(depth+1);
			selected[depth]=false;
			subset(depth+1);
	}
}
