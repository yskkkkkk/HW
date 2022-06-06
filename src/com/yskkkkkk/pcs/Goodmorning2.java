package com.yskkkkkk.pcs;

import java.util.Arrays;
import java.util.Scanner;
//Goodmorning 
//
//1단계 - 기본 고정된 배열과 n, r
//2단계 - n, r 배열값을 입력받아서 출력 
//3단계 - input 배열을 멤버변수가 아닌 매개변수로 전달 ( 속도강점 )
//4단계 - 배열을 원시타입이 아닌 객체로 생성해서 순조부 생성 
public class Goodmorning2 {

	static int N, R;
	static int[] input;
	static boolean[] selected;
	static int[] result;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();

		input = new int[N];
		selected = new boolean[N];
		result = new int[R];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		sc.close();
		
		System.out.println("----permutation----");
		permutation(0);

		System.out.println("----combination----");
		combination(0, 0);

		System.out.println("----subset----");
		subset(0);

	}

	private static void permutation(int depth) {
		if (depth == R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!selected[i]) {
				result[depth] = input[i];
				selected[i] = true;
				permutation(depth + 1);
				selected[i] = false;
			}
		}
	}

	private static void combination(int depth, int start) {
		if (depth == R) {
			System.out.println(Arrays.toString(result));
			return;
		}

		for (int i = start; i < N; i++) {
			result[depth] = input[i];
			combination(depth + 1, i + 1);
		}
	}

	private static void subset(int depth) {
		if(depth==N) {
			   System.out.print("부분집합>>> ");
			   for(int i=0; i<N; i++) {
				   if(selected[i])
				   System.out.print(input[i]+" ");
			   }
			   System.out.println();
			   return;
			}
	        selected[depth]=true;
			subset(depth+1);
			selected[depth]=false;
			subset(depth+1);
	}
}
