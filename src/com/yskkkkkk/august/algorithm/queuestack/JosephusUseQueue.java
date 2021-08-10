package com.yskkkkkk.august.algorithm.queuestack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JosephusUseQueue {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Queue<Integer> people = new LinkedList<>();
		
		for (int i = 1; i <= n; i++) {
			people.add(i);
		}
		
		sb.append("<");
		while (people.size() != 0) {
			for (int i = 0; i < k-1; i++) {
				people.offer(people.poll());
			} 
			sb.append(people.poll()+", ");
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		
		System.out.println(sb.toString());
		br.close();
	}
}
