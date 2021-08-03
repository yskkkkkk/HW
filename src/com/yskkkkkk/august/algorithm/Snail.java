package com.yskkkkkk.august.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Snail {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Integer, int[][]> answer = new HashMap<>();
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[][] snail = new int[N][N];
			
			int number = 1;
			
			for (int j = 0; j < snail[0].length; j++) {
				snail[0][j] = number++;
			}	// 처음 기본 한개 
			
			int x = 0;
			int y = N-1;
			int flag = 1;
			
			for (int j = N-1; j > 0 ; j--) {
				for (int k = 1; k <= j; k++) {
					x += (1*flag);
					snail[x][y] = number++;
				}
				for (int k = 1; k <= j; k++) {
					y -= (1*flag);
					snail[x][y] = number++;
				}
				flag *= -1;
			}
			answer.put(i, snail);
		}
		
		for (int i = 1; i <= answer.size(); i++) {
			System.out.println("#"+i);
			for (int[] js : answer.get(i)) {
				for (int js2 : js) {
					System.out.print(js2+" ");
				}
				System.out.println();
			}
		}
	}
}
