package com.yskkkkkk.september.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_구간합기본 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			
			long result = 0;
			for (long i = a; i <= b; i++) {
				result += calculator(i);
			}
			
			System.out.println("#"+tc+" "+result);
		}
		br.close();
	}
	
	static int calculator(long input) {
		int sum = 0;
		while(true) {
			sum += input % 10;
			input /= 10;
			if (input == 0) break;
		}
		
		return sum;
	}
}
