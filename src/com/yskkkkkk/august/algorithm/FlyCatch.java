package com.yskkkkkk.august.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FlyCatch {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < testCase; i++) {
			st = new StringTokenizer(br.readLine());
			int area = Integer.parseInt(st.nextToken());		
			int attack = Integer.parseInt(st.nextToken());	
			int sum = 0;
			
			int[][] array = new int[area][area];
			for (int j = 0; j < area; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < area; k++) {
					array[j][k] = Integer.parseInt(st.nextToken());  
				}
			}
			
			for (int j = 0; j <= area-attack; j++) {
				for (int k = 0; k <= area-attack; k++) {
					int temp = sum;
					sum = 0;
					
					for (int m = 0; m < attack; m++) {
						for (int n = 0; n < attack; n++) {
							sum += array[j+m][k+n];
						}
					}
					sum = temp >= sum ? temp : sum;
				}
			}
			
			System.out.println("#"+(i+1)+" "+sum);
		}
		br.close();
	}
}
