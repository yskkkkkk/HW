package com.yskkkkkk.august.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PerfectShuffle {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < testCase; i++) {
			int cardCount = Integer.parseInt(br.readLine());
			
			List<String> frontCards = new ArrayList<>();
			List<String> backCards = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			
			int count = 0;
			for (int j = 0; j < cardCount; j++) {
				count++;
				if (count <= Math.round(cardCount/2.0)) frontCards.add(st.nextToken());
				else backCards.add(st.nextToken());
			}
			
			System.out.print("#"+(i+1)+" ");
			for (int j = 0; j < frontCards.size(); j++) {
				System.out.print(frontCards.get(j)+" ");
				if (j < backCards.size()) System.out.print(backCards.get(j)+" ");
			}
			System.out.println();
		}
		br.close();
	}
}
