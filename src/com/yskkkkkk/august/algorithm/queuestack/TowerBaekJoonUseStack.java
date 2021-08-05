package com.yskkkkkk.august.algorithm.queuestack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class TowerBaekJoonUseStack {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int number = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder answer = new StringBuilder();
		
		Stack<Integer> towers = new Stack<>();
		Stack<Integer> index = new Stack<>();
		
		towers.push(Integer.parseInt(st.nextToken()));
		index.push(1);
		answer.append("0 ");
		
		for (int i = 2; i <= number; i++) {
			int tower = Integer.parseInt(st.nextToken());
			
			while(!towers.isEmpty()) {
				if (tower < towers.peek()) {
					answer.append(index.peek() + " ");
					break;
				}
				towers.pop();
				index.pop();
			}
			if (towers.isEmpty()) {
				answer.append("0 ");
			}
			towers.push(tower);
			index.push(i);
			
		}
		System.out.println(answer.toString());
		
		br.close();
	}
}
