package com.yskkkkkk.august.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_refrigerator {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		C[] list = new C[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			C c = new C(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			list[i] = c;
		}

		Arrays.sort(list, new Comparator<C>() {
			@Override
			public int compare(C o1, C o2) {
				return o1.getMaxTem() - o2.getMaxTem();
			}
		});

		int cnt = 1;
		int max = list[0].getMaxTem();
		for (int i = 1; i < n; i++) {
			if (list[i].getMinTem() > max) {
				cnt++;
				max = list[i].getMaxTem();
			}
		}

		System.out.println(cnt);
	}

	private static class C {
		private int minTem;
		private int maxTem;

		public C(int minTem, int maxTem) {
			super();
			this.minTem = minTem;
			this.maxTem = maxTem;
		}

		public int getMinTem() {
			return minTem;
		}

		public int getMaxTem() {
			return maxTem;
		}

		@Override
		public String toString() {
			return "[minTem=" + minTem + ", maxTem=" + maxTem + "]";
		}
	}

}