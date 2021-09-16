package com.yskkkkkk.september.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_사람네트워크 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int p = Integer.parseInt(st.nextToken());	// 사람의 숫자 
			int[][] relation = new int[p + 1][p + 1];	// 관계를 나타내는 행렬 

			int min = p * p;	// 모든 가중치가 1이므로 해당 문제에서는 최대 맥스값은 p*p보다 작다.
			
			for (int i = 1; i <= p; i++) {
				for (int j = 1; j <= p; j++) {
					int input = Integer.parseInt(st.nextToken());
					relation[i][j] = input == 0 && i!=j ? p : input;	// 0,0 1,1 과같은 곳은 0 으로 관계가 1로 있는곳은 1로 나두고 나머지는 거칠 수 있는 최대값인 p로 
				}
			}
			
			for (int i = 1; i <= p; i++) {	// 출 
				int cc = 0;
				for (int j = 1; j <= p; j++) {	// 도
					if (relation[i][j] == p) {
						int minCost = p;	// 최대값을 설정하고 
						for (int k = 1; k < p; k++) {	// 경
							if (minCost > relation[i][k] + relation[k][j])	// 더짧은길이 있다면 
								minCost = relation[i][k] + relation[k][j];	// max를 해당길로 설정
						}
						relation[i][j] = minCost;
					}
					cc += relation[i][j];	// 행의 모든 값을 더해서 cc를 구함
				}
				min = Math.min(min, cc);	// 지금까지의 cc중 가장 작은 값을 min으로 
			}
			
			System.out.println("#"+tc+" "+min);
		}
		br.close();
	}
}
