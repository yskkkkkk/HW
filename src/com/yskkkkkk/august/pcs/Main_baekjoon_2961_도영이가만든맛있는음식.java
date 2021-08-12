package com.yskkkkkk.august.pcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_baekjoon_2961_도영이가만든맛있는음식 {

	private static int T;
	private static boolean[] visited;
	private static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Taste[] tastes = new Taste[T];
		visited = new boolean[T];

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			Taste taste = new Taste(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			tastes[i] = taste;

		}
		br.close();
		subSet(tastes, 0);
		System.out.println(min);
	}

	private static void subSet(Taste[] arr, int index) {
		if (index == T) {
			calculator(arr);
			return;
		}

		visited[index] = false;
		subSet(arr, index + 1);

		visited[index] = true;
		subSet(arr, index + 1);

	}

	private static void calculator(Taste[] arr) {
		int sour = 1;
		int bitter = 0;
		for (int i = 0; i < arr.length; i++) {
			if (visited[i]) {
				sour *= arr[i].getSour();
				bitter += arr[i].getBitter();
			}
		}
		if (bitter != 0) min = Math.min(min, Math.abs(sour - bitter));
	}

	private static class Taste {
		private int sour;
		private int bitter;

		public int getSour() {
			return sour;
		}

		public int getBitter() {
			return bitter;
		}

		public Taste(int sour, int bitter) {
			super();
			this.sour = sour;
			this.bitter = bitter;
		}

		@Override
		public String toString() {
			return "[sour=" + sour + ", bitter=" + bitter + "]";
		}
	}
}
