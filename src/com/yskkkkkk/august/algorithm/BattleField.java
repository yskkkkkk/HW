package com.yskkkkkk.august.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BattleField {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		int T = Integer.parseInt(br.readLine());			// 테스트 케이스 횟수
		
		for (int i = 0; i < T; i++) {
			
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());		// 행
			int W = Integer.parseInt(st.nextToken());		// 열
					
			char[][] field = new char[H][W];
			
			int x = 0;
			int y = 0;
			char direction = 0;
			
			for (int j = 0; j < field.length; j++) {
				String line = br.readLine();
				for (int k = 0; k < line.length(); k++) {
					field[j][k] = line.charAt(k);
					if (field[j][k] == '<' || field[j][k] == '^' || field[j][k] == '>' || field[j][k] == 'v') {
						x = k;
						y = j;
						direction = field[j][k];
					}
				}
			}
			
			int N = Integer.parseInt(br.readLine());		// 명령수행 횟수
			String input = br.readLine();					// 명령 
			
			for (int j = 0; j < N; j++) {
				switch (input.charAt(j)) {
				case 'U':
					direction = '^';
					field[y][x] = direction;
					if (y-1 >= 0 && field[y-1][x] == '.') {
						field[y][x] = '.';
						field[y-1][x] = direction;
						y--;
					}
					break;
				case 'D':
					direction = 'v';
					field[y][x] = direction;
					if (y+1 < H && field[y+1][x] == '.') {
						field[y][x] = '.';
						field[y+1][x] = direction;
						y++;
					}
					break;
				case 'L':
					direction = '<';
					field[y][x] = direction;
					if (x-1 >= 0 && field[y][x-1] == '.') {
						field[y][x] = '.';
						field[y][x-1] = direction;
						x--;
					}
					break;
				case 'R':
					direction = '>';
					field[y][x] = direction;
					if (x+1 < W && field[y][x+1] == '.') {
						field[y][x] = '.';
						field[y][x+1] = direction;
						x++;
					}
					break;
				case 'S':
					boolean exist = true;
					int index = 1;
					switch (direction) {
					case '^':
						while (exist) {
							if (y-index < 0) break;
							if (field[y-index][x] == '*') {
								field[y-index][x] = '.';
								exist = false;
							} 
							else if (field[y-index][x] == '#') exist = false;
							else if (field[y-index][x] == '-' || field[y-index][x] == '.') index++;
						}
						break;
					case 'v':
						while (exist) {
							if (y+index >= H) break;
							if (field[y+index][x] == '*') {
								field[y+index][x] = '.';
								exist = false;
							} 
							else if (field[y+index][x] == '#') exist = false;
							else if (field[y+index][x] == '-' || field[y+index][x] == '.') index++;
						}
						break;
					case '<':
						while (exist) {
							if (x-index < 0) break;
							if (field[y][x-index] == '*') {
								field[y][x-index] = '.';
								exist = false;
							} 
							else if (field[y][x-index] == '#') exist = false;
							else if (field[y][x-index] == '-' || field[y][x-index] == '.') index++;
						}
						break;
					case '>':
						while (exist) {
							if (x+index >= W) break;
							if (field[y][x+index] == '*') {
								field[y][x+index] = '.';
								exist = false;
							} 
							else if (field[y][x+index] == '#') exist = false;
							else if (field[y][x+index] == '-' || field[y][x+index] == '.') index++;
						}
						break;
					}
				}
			}
			
			System.out.print("#"+(i+1)+" ");
			for (char[] cs : field) {
				for (char cs2 : cs) {
					System.out.print(cs2);
				}
				System.out.println();
			}
		}
		br.close();
	}
}
