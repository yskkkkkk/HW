package com.yskkkkkk.august.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_빵집 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[][] map = new int[r][c];
		
		for (int i = 0; i < r; i++) {
			String input = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = input.charAt(j) == '.' ? 0 : -1;
			}
		}
		br.close();
		
		for (int i = 0; i < r; i++) {
			int rIndex = i;
			int cIndex = 0;
			map[rIndex][cIndex] = i+1;
			while (cIndex<c-1) {
				if (rIndex-1 >= 0 && map[rIndex-1][cIndex+1] == 0) {
					map[rIndex-1][cIndex+1] = i+1;
					rIndex--;
					cIndex++;
				} else if (map[rIndex][cIndex+1] == 0) {
					map[rIndex][cIndex+1] = i+1;
					cIndex++;
				} else if (rIndex+1 < r && map[rIndex+1][cIndex+1] == 0) {
					map[rIndex+1][cIndex+1] = i+1;
					rIndex++;
					cIndex++;
				} else {
					for (int j = 0; j < r; j++) {
						for (int k = 0; k < c; k++) {
							if (map[j][k] == i+1) map[j][k] = 0;
						}
					}
					break;
				}
			}
		}
		
		int count = 0;
		for (int i = 0; i < r; i++) {
			if (map[i][c-1] != 0) count++; 
		}
		
		System.out.println(count);
		
	}
}
