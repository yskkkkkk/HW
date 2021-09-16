package com.yskkkkkk.september.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_최장길이수열 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());

			int[] input = new int[n];
			int[] lis = new int[n];
			int max=Integer.MIN_VALUE;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				input[i] = Integer.parseInt(st.nextToken());
				lis[i] = 1;
				
				for(int j=0; j<i; ++j) {		
					if(input[j]<= input[i] && lis[j]+1>lis[i]) 	lis[i] = lis[j]+1;
				}
				if(lis[i]>max) max = lis[i]; 
			}

			System.out.println("#" + tc + " " + max);
		}
		br.close();
	}
}
