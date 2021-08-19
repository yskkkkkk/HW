package com.yskkkkkk.august.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_빵집 {
	
	static char[][] map;
	static int r;
	static int c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		for(int i=0; i<r; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int result = 0;
		for(int i=0; i<r; i++) {
			if(check(i, 0))	result++;			
		}
		
		System.out.println(result);
	}

	public static boolean check(int x, int y) {
		map[x][y] = '-';
		
		if(y == c-1) return true;
		
		if(x > 0 && map[x-1][y+1] == '.') {
			if(check(x-1, y+1)) return true;
		}
		if(map[x][y+1] == '.') {
			if(check(x, y+1)) return true;
		}
		if(x+1 < r && map[x+1][y+1] == '.') {
			if(check(x+1, y+1)) return true;
		}
		return false;
	}
}

