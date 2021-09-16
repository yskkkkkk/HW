package com.yskkkkkk.september.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_맥주마시면서걷기 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int con = Integer.parseInt(br.readLine());

			Place[] p = new Place[con + 2];
			for (int i = 0; i < con + 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				p[i] = new Place(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			boolean[][] relation = new boolean[con + 2][con + 2];
			for (int i = 0; i < p.length - 1; i++) {
				for (int j = i; j < p.length; j++) {
					if (Math.abs(p[i].x - p[j].x) + Math.abs(p[i].y - p[j].y) <= 1000) {
						relation[i][j] = relation[j][i] = true;
					}
				}
			}
			for (int k = 0; k < relation.length; k++) {
				for (int i = 0; i < relation.length; i++) {
					for (int j = 0; j < relation.length; j++) {
						if (!relation[i][j]) {
							if (relation[i][k] && relation[k][j])
								relation[i][j] = true;
						}
					}
				}
			}

			String result = relation[0][relation.length - 1] ? "happy" : "sad";
			System.out.println(result);

		}
		br.close();
	}

	static class Place {
		int x;
		int y;

		public Place(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}
}