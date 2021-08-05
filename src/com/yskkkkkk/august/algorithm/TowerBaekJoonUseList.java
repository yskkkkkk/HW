package com.yskkkkkk.august.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TowerBaekJoonUseList {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int number = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		List<Integer> tower = new ArrayList<>();
		List<Integer> answer = new ArrayList<>();
		for (int i = 0; i < number; i++) {
			tower.add(Integer.parseInt(st.nextToken()));
		}
		
		answer.add(0);	// 첫번째 타워의 답 
		
		for (int i = 1; i < tower.size(); i++) {
			for (int j = i-1; j >= 0; j--) {
				if (tower.get(i)<tower.get(j)) {
					answer.add(j+1);
					break;
				} else if (j==0 & tower.get(i)>tower.get(j)) {
					answer.add(0);
				}
			}
		}

		for (Integer integer : answer) {
			System.out.print(integer+" ");
		}
		
		br.close();
	}
}
