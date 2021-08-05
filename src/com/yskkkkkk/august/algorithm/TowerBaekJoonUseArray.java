package com.yskkkkkk.august.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TowerBaekJoonUseArray {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int number = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] tower = new int[number];
		int[] answer = new int[number];
		
		for (int i = 0; i < number; i++) {
			tower[i] = Integer.parseInt(st.nextToken());
		}
		
		answer[0] = 0;
		
		for (int i = 1; i < number; i++) {
			for (int j = i-1; j >= 0; j--) {
				if (tower[i]<tower[j]) {
					answer[i] = j+1;
					break;
				} else if (j==0 & tower[i]>tower[j]) {
					answer[i] = 0;
				}
			}
		}

		for (Integer integer : answer) {
			System.out.print(integer+" ");
		}
		
		br.close();
	}
}
