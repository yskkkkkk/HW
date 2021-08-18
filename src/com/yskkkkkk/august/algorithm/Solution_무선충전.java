package com.yskkkkkk.august.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_무선충전 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());

		for (int i = 0; i < testCase; i++) {
			Area[][] map = new Area[11][11];

			st = new StringTokenizer(br.readLine());
			int turn = Integer.parseInt(st.nextToken());
			int bc = Integer.parseInt(st.nextToken());

			int[] aMove = new int[turn];
			int[] bMove = new int[turn];

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < aMove.length; j++) {
				aMove[j] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < bMove.length; j++) {
				bMove[j] = Integer.parseInt(st.nextToken());
			}

			for (int j = 0; j < bc; j++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int range = Integer.parseInt(st.nextToken());
				int power = Integer.parseInt(st.nextToken());

				for (int k = 1; k < 11; k++) {
					for (int k2 = 1; k2 < 11; k2++) {
						if (Math.abs(k - x) + Math.abs(k2 - y) <= range) {
							Area area;
							if (map[k][k2] == null) {
								area = new Area(new Integer[] {power});
								map[k][k2] = area;
								continue;
							}
							Integer[] powers = new Integer[map[k][k2].getPowers().length + 1];
							for (int l = 0; l < map[k][k2].getPowers().length; l++) {
								powers[l] = map[k][k2].getPowers()[l];
							}
							powers[powers.length - 1] = power;
							Arrays.sort(powers, Collections.reverseOrder());
							area = map[k][k2];
							area.setPowers(powers);
							map[k][k2] = area;
						}
					}
				}
			}

//			for (int j = 1; j < 11; j++) {
//				for (int j2 = 1; j2 < 11; j2++) {
//					System.out.print(map[j][j2]+"\t");
//				}
//				System.out.println();
//			}

			Person a = new Person(1, 1);
			Person b = new Person(10, 10);

			int aSum = map[1][1] == null ? 0 : map[1][1].getPowers()[0];
			int bSum = map[10][10] == null ? 0 : map[10][10].getPowers()[0];

			for (int j = 0; j < turn; j++) {
				move(aMove, j, a);
				move(bMove, j, b);
				 
				aSum += map[a.getY()][a.getX()] == null ? 0 : map[a.getY()][a.getX()].getPowers()[0];
				bSum += map[b.getY()][b.getX()] == null ? 0 : map[b.getY()][b.getX()].getPowers()[0];
				
			}
			System.out.println(aSum);
			System.out.println(bSum);
			
		}

	}


	private static Person move(int[] personMove, int index, Person p) {
		switch (personMove[index]) {
		case 1:
			p.setY(p.getY() - 1);
			break;
		case 2:
			p.setX(p.getX() + 1);
			break;
		case 3:
			p.setY(p.getY() + 1);
			break;
		case 4:
			p.setX(p.getX() - 1);
			break;
		}
		return p;
	}

	private static class Area {
		private Integer[] powers;

		public Area(Integer[] powers) {
			super();
			this.powers = powers;
		}

		public Integer[] getPowers() {
			return powers;
		}

		public void setPowers(Integer[] powers) {
			this.powers = powers;
		}

		@Override
		public String toString() {
			return Arrays.toString(powers);
		}

	}

	private static class Person {
		private int x;
		private int y;

		public Person(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		@Override
		public String toString() {
			return "[x=" + x + ", y=" + y + "]";
		}
	}
}
