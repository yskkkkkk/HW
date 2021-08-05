package com.yskkkkkk.august.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Encoding {

	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int i = 0; i < 10; i++) {
			br.readLine();
			st = new StringTokenizer(br.readLine());
			Queue<Integer> queue = new LinkedList<>();
			int n = st.countTokens();
			for (int j = 0; j < n; j++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
			
			int minus = 1;
			while(true) {
				queue.add(queue.poll() - minus++);
				if (minus == 6) minus = 1;
				if (queue.peek() - minus <= 0) {
					queue.poll();
					queue.add(0);
					break;
				}
			}
			
			System.out.print("#"+(i+1)+" ");
			for (int k = 0; k < n; k++) {
				System.out.print(queue.poll()+" ");
			}
			System.out.println();
		}
		br.close();
	}
}
