package com.yskkkkkk.august.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SquareRoom {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < testCase; i++) {
			int n = Integer.parseInt(br.readLine());
			int[][] room = new int[n][n];
			
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < n; k++) {
					room[j][k] = Integer.parseInt(st.nextToken());
				}
			}		// 데이터 입력
			
			int roomNumber = room[0][0];		//1번 방의 값 저장 
			int moveNumber = 0;
			
			for (int j = 0; j < room.length; j++) {
				for (int k = 0; k < room.length; k++) {
					int move = move(room, j, k);
					if (moveNumber < move || (moveNumber == move && room[j][k] < roomNumber)) {
						moveNumber = move;
						roomNumber = room[j][k];
					}
				}
			}
			System.out.println("#"+(i+1)+" "+roomNumber+" "+moveNumber);
		}
		br.close();
	}
	
	private static int move(int[][] room, int j, int k) {
		int move = 0;
		while(true) {
			move++;
			if(j-1 >= 0 && room[j-1][k] == room[j][k] +1) {
				j--;
			} else if (k-1 >= 0 && room[j][k-1] == room[j][k] +1) {
				k--;
			} else if (j+1 < room.length && room[j+1][k] == room[j][k] +1) {
				j++;
			} else if (k+1 < room.length && room[j][k+1] == room[j][k] +1) {
				k++;
			} else {
				break;
			}
		}
		return move;
	}
}
