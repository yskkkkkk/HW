package com.yskkkkkk.october.algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_게리멘더링 {
	static Area[] areas;
	static int[] input, result;
	static boolean[][] map;
	static int n, min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		areas = new Area[n];
		input = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			input[i] = i + 1;
			areas[i] = new Area(i + 1, Integer.parseInt(st.nextToken()));
		}
		map = new boolean[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			for (int j = 0; j < c; j++) {
				int connect = Integer.parseInt(st.nextToken());
				map[i][connect] = true;
				map[connect][i] = true;
			}
		}
		for (int i = 1; i <= n / 2; i++) {
			result = new int[i];
			combination(0, 0, i);
		}
		
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
		br.close();
	}

	static int calculator(int[] aArea) {
		boolean[] check = new boolean[n];
		for (int i = 0; i < aArea.length; i++) {
			check[aArea[i] - 1] = true;
		}
		int[] bArea = new int[n - aArea.length];
		int index = 0;
		for (int i = 0; i < check.length; i++) {
			if (!check[i])
				bArea[index++] = i + 1;
		}
		if (!checkConnection(aArea))
			return Integer.MAX_VALUE;
		if (!checkConnection(bArea))
			return Integer.MAX_VALUE;

		int aSum = 0;
		int bSum = 0;
		for (int i = 0; i < aArea.length; i++) {
			aSum += areas[aArea[i] - 1].p;
		}
		for (int i = 0; i < bArea.length; i++) {
			bSum += areas[bArea[i] - 1].p;
		}

		return Math.abs(aSum - bSum);
	}

	static boolean checkConnection(int[] input) {
		if (input.length == 1)
			return true;
		boolean[] visited = new boolean[n + 1];
		int start = input[0];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int i : input) {
				if (map[current][i] && !visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
		for (int i : input) {
			if (!visited[i]) return false;
		}		
		return true;
	}

	static void combination(int depth, int start, int number) {
		if (depth == number) {
			
			min = Math.min(min, calculator(result));
			return;
		}
		for (int i = start; i < n; i++) {
			result[depth] = input[i];
			combination(depth + 1, i + 1, number);
		}
	}

	static class Area {
		int index;
		int p;

		public Area(int index, int p) {
			super();
			this.index = index;
			this.p = p;
		}
	}
}
