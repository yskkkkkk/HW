package com.yskkkkkk.august.algorithm.queuestack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PerfectShuffleUseQueue {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());

		for (int i = 0; i < testCase; i++) {
			int cardCount = Integer.parseInt(br.readLine());

			Queue<String> frontCards = new LinkedList<>();
			Queue<String> backCards = new LinkedList<>();

			st = new StringTokenizer(br.readLine());

			int count = 0;
			for (int j = 0; j < cardCount; j++) {
				count++;
				if (count <= Math.round(cardCount / 2.0))
					frontCards.add(st.nextToken());
				else
					backCards.add(st.nextToken());
			}

			System.out.print("#" + (i + 1) + " ");
			while (!frontCards.isEmpty()) {
				System.out.print(frontCards.poll() + " ");
				if (!backCards.isEmpty()) {
					System.out.print(backCards.poll() + " ");
				}
			}
			System.out.println();
		}
		br.close();
	}
}
