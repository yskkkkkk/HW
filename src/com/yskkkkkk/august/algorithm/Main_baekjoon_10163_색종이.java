package com.yskkkkkk.august.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_baekjoon_10163_색종이 {

	static int[][] map = new int[1001][1001];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] answer = new int[n+1];
		int index = 1;
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < w; j++) {
				for (int k = 0; k < h; k++) {
					map[x+j][y+k] = index;
				}
			}
			index++;
		}
		br.close();
		
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				if (map[i][j] != 0) answer[map[i][j]]++;
			}
		}
		
		for (int i = 1; i < answer.length; i++) 
			System.out.println(answer[i]);	
	}
}
