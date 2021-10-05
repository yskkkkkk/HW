package com.yskkkkkk.october.algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_회전초밥 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] array = new int[N + k];
		int[] counts = new int[d + 1];
		int count = 0, max = 0;
		
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		
		System.arraycopy(array, 0, array, N, k-1);

		for (int i = 0; i < k; i++) {
			if (counts[array[i]]++ == 0) count++;
		}

		for (int i = 1; i < N; i++) {
			if (counts[array[i + k - 1]]++ == 0)
				count++;

			if (--counts[array[i - 1]] < 1)
				count--;

			int temp = count;
			if (counts[c] == 0)
				temp++;

			max = Math.max(max, temp);
		}

		System.out.println(max);
	}
}