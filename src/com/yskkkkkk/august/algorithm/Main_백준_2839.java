package com.yskkkkkk.august.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_2839 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		br.close();
		
		int share = input/5;
		int min = Integer.MAX_VALUE;
		for (int i = share; i >= 0; i--) {
			int rest = input - (5*i);
			if (rest%3 == 0) {
				min = Math.min(min, i+rest/3);
			}
		}
		min = min == Integer.MAX_VALUE ? -1 : min;
		System.out.println(min);
		
	}
}
