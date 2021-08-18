package com.yskkkkkk.august.pcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_요리사 {

	private static int[] input;
	private static int material, R;
	private static int[] choose;
	private static int[][] map;
	private static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());

		for (int i = 0; i < testCase; i++) {
			min = Integer.MAX_VALUE;
			material = Integer.parseInt(br.readLine());
			R = material / 2;
			choose = new int[R];
			input = new int[material];
			map = new int[material][material];
			for (int j = 0; j < material; j++) {
				input[j] = j;
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < map.length; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}

			makeCombination(0, 0);
			System.out.println("#"+(i+1)+" "+min);
		}

	}

	private static void makeCombination(int depth, int start) {
		if (depth == R) {
			calculator(choose);
			return;
		}
		for (int i = start; i < material; i++) {
			choose[depth] = input[i];
			makeCombination(depth + 1, i + 1);
		}
	}

	private static void calculator(int[] choose) {
		int[] unChoose = new int[R];
		int chooseCount = 0;
		int count = 0;
		for (int i = 0; i < material; i++) {
			if (chooseCount < R && i == choose[chooseCount]) chooseCount++;
			else unChoose[count++] = i;
		}
		
		int sum = 0;
		for (int i = 0; i < choose.length; i++) {
			for (int j = 0; j < choose.length; j++) {
				sum += map[choose[i]][choose[j]];
			}
		}
		for (int i = 0; i < unChoose.length; i++) {
			for (int j = 0; j < unChoose.length; j++) {
				sum -= map[unChoose[i]][unChoose[j]];
			}
		}
		min = Math.min(min, Math.abs(sum));
	}

}
