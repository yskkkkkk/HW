package com.yskkkkkk.august.algorithm;

import java.util.Scanner;

public class Main_BJ_17478_재귀함수가뭔가요 {

	public static void main(String[] args) {
		int count = 0;
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		sc.close();
		
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		question(count, input);
		answer(input);
	}
	
	public static void question(int count, int num) {
		String string = "";
		String plusString = "____";
		for (int i = 0; i < count; i++) {
			string += plusString;
		}
		if (count >= num) {
			System.out.println(string+"\"재귀함수가 뭔가요?\"");
			System.out.println(string+"\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			return;
		} else {
			System.out.println(string+"\"재귀함수가 뭔가요?\"");
			System.out.println(string+"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
			System.out.println(string+"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
			System.out.println(string+"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
			question(++count, num);
		}
	}
	
	public static void answer(int num) {
		String string = "";
		String plusString = "____";
		for (int i = num; i > 0; i--) {
			string += plusString;
		}
		if (num <= 0) {
			System.out.println("라고 답변하였지.");
			return;
		} else {
			System.out.println(string+"라고 답변하였지.");
			answer(--num);
		}
	}
	
}

