package com.yskkkkkk.august.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_16935_배열돌리기3 {

	private static int n, m, r;
	private static int[][] array;
	private static int[][] arrayCopy;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		array = new int[n+1][m+1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < r; i++) {
			int order = Integer.parseInt(st.nextToken());
			switch (order) {
			case 1:
				circulate1();
				break;
			case 2:
				circulate2();
				break;
			case 3:
				circulate3();
				break;
			case 4:
				circulate4();
				break;
			case 5:
				circulate5();
				break;
			case 6:
				circulate6();
				break;
			}
		}
		br.close();
		for (int i = 1; i < arrayCopy.length; i++) {
			for (int j = 1; j < arrayCopy[i].length; j++) {
				System.out.print(arrayCopy[i][j] + " ");
			}
			System.out.println();
		}
	}// main
	
	private static void circulate1() {
		arrayCopy = new int[n+1][m+1];
		for (int i = 1; i <= n/2; i++) {
			for (int j = 1; j <= m; j++) {
				arrayCopy[i][j] = array[array.length-i][j];
				arrayCopy[array.length-i][j] = array[i][j];
			}
		}
		array = arrayCopy;
	}

	private static void circulate2() {
		arrayCopy = new int[n+1][m+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m/2; j++) {
				arrayCopy[i][j] = array[i][array[i].length-j];
				arrayCopy[i][array[i].length-j] = array[i][j];
			}
		}
		array = arrayCopy;
	}
	
	private static void circulate3() {
		arrayCopy = new int[m+1][n+1];
		for (int i = 1; i <= m; i++) {
			for (int j = n; j >= 1; j--) {
				arrayCopy[i][array.length-j] = array[j][i];
			}
		}
		array = arrayCopy;
		n = array.length-1;
		m = array[0].length-1;
	}
	
	private static void circulate4() {
		arrayCopy = new int[m+1][n+1];
		for (int i = m; i >= 1; i--) {
			for (int j = 1; j <= n; j++) {
				arrayCopy[array[j].length-i][j] = array[j][i];
			}
		}
		array = arrayCopy;
		n = array.length-1;
		m = array[0].length-1;
	}

	private static void circulate5() {
		arrayCopy = new int[n+1][m+1];
		for (int i = 1; i <= n/2; i++) {
			for (int j = 1; j <= m/2; j++) {
				arrayCopy[i][j+m/2] = array[i][j];
				arrayCopy[i+n/2][j+m/2] = array[i][j+m/2];
				arrayCopy[i+n/2][j] = array[i+n/2][j+m/2];
				arrayCopy[i][j] = array[i+n/2][j];
			}
		}
		array = arrayCopy;
	}
	
	private static void circulate6() {
		arrayCopy = new int[n+1][m+1];
		for (int i = 1; i <= n/2; i++) {
			for (int j = 1; j <= m/2; j++) {
				arrayCopy[i+n/2][j] = array[i][j];
				arrayCopy[i+n/2][j+m/2] = array[i+n/2][j];
				arrayCopy[i][j+m/2] = array[i+n/2][j+m/2];
				arrayCopy[i][j] = array[i][j+m/2];
			}
		}
		array = arrayCopy;
	}
}