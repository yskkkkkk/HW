package com.yskkkkkk.august.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Flatten {

	public static void main(String[] args) throws IOException {
		int[] answers = new int[10];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int j = 0; j < answers.length; j++) {
			int dump = Integer.parseInt(br.readLine());
			int[] boxes = new int[100];
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < boxes.length; i++) {
				boxes[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < dump; i++) {
				Arrays.sort(boxes);
				boxes[0]++;
				boxes[99]--;
			}
			Arrays.sort(boxes);
			
			answers[j] = boxes[99]-boxes[0];
		}
		br.close();
		for (int i = 0; i < answers.length; i++) {
			System.out.println("#"+(i+1)+" "+answers[i]);
		}
		
	}
}
