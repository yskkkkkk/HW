package com.yskkkkkk.september.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1755_숫자놀이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] order = new int[] { 9, 4, 8, 7, 2, 1, 6, 5, 0, 3 };
		List<Num> numbers = new ArrayList<>();

		for (int i = N; i <= M; i++) {
			int o = i / 10 == 0 ? order[i % 10]*100 - 5 : order[i / 10] * 100 + order[i % 10] * 10;
			numbers.add(new Num(i, o));
		}

		Collections.sort(numbers, new Comparator<Num>() {
			@Override
			public int compare(Num o1, Num o2) {
				return o1.order - o2.order;
			}
		});

		for (int i = 0; i < numbers.size(); i++) {
			if (i != 0 && i % 10 == 0) System.out.println();
			System.out.print(numbers.get(i).number + " ");
		}
		

	}

	static class Num {
		int number;
		int order;
		public Num(int number, int order) {
			super();
			this.number = number;
			this.order = order;
		}
		@Override
		public String toString() {
			return "Num [number=" + number + ", order=" + order + "]";
		}
	}
}
