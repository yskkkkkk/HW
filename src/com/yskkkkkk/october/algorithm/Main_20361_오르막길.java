package com.yskkkkkk.october.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_20361_오르막길 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] height = new int[N];
		char[] type = new char[N-1];
		Arrays.fill(type, 'u');
		for (int i = 0; i < height.length; i++) {
			height[i] = Integer.parseInt(st.nextToken());
			if (i > 0 && height[i-1] >= height[i]) type[i-1] = 'd';
		}
		br.close();
		
		int max = 0;
		int index = 0;
		for (int i = 0; i < type.length; i++) {
			if (type[i] == 'd') {
				max = Math.max(max, height[i] - height[index]); 
				index = i + 1;
			}
		}
		if (type[type.length-1] == 'u') {
			max = Math.max(max, height[height.length-1] - height[index]);
		}
		
		System.out.println(max);
	}
}
