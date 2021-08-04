package com.yskkkkkk.august.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Farm {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < testCase; i++) {
			int area = Integer.parseInt(br.readLine());
			
			int[][] farm = new int[area][area];
			for (int j = 0; j < area; j++) {
				String input = br.readLine();
				for (int k = 0; k < area; k++) {
					farm[j][k] = Character.getNumericValue(input.charAt(k));   
				}
			}

			int goal = area/2;		// area가 5일 때
			int sum = 0;
			for (int j = 0; j < area; j++) {
				goal = (double)j < area/2.0 ? goal + 1 : goal - 1 ;
				for (int k = 0; k < goal; k++) {
					sum += farm[j][k];
				}
			}			// 3,4,5,4,3를 더해준다.
			
			goal = area/2;
			for (int j = 0; j < farm.length; j++) {
				goal = (double)j < area/2.0 ? goal - 1 : goal + 1 ;
				for (int k = 0; k <= goal; k++) {
					sum -= farm[j][k];
				}
			}			// 마름모 바깝의 부분 2,1,0,1,2를 빼준다.
			
			System.out.println("#"+(i+1)+" "+sum);
		}
		br.close();
	}
}
