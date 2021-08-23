package com.yskkkkkk.august.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		int[][] contact = new int[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			contact[f][c] = 1;
			contact[c][f] = 1;
		}
		br.close();

		boolean[] visited = new boolean[n + 1];
		dfsUseStack(v, contact, visited, true);
		
		System.out.println();

		int[] visit = new int[n + 1];
		bfsUseQueue(v, contact, visit, n);
	}

	public static void dfsUseStack(int v, int[][] contact, boolean[] visited, boolean flag) {
		int l = contact.length - 1;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(v);
		visited[v] = true;
		System.out.print(v + " ");

		while (!stack.isEmpty()) {
			int w = stack.peek();
			flag = false;

			for (int i = 1; i <= l; i++) {
				if (contact[w][i] == 1 && !visited[i]) {
					stack.push(i);
					System.out.print(i + " ");
					visited[i] = true;
					flag = true;

					break;
				}
			}

			if (!flag) {
				stack.pop();
			}
		}
	}

	public static void bfsUseQueue(int v, int[][] contact, int[] visit, int n) {
		Queue<Integer> queue = new LinkedList<>();

		visit[v] = 1;
		queue.offer(v);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int k = 0; k < size; k++) {
				int i = queue.poll();
				System.out.print(i + " ");
				for (int j = 1; j <= n; j++) {
					if (contact[i][j] == 1 && visit[j] == 0) {
						visit[j] = 1;
						queue.offer(j);
					}
				}
			}
		}
	}
}
