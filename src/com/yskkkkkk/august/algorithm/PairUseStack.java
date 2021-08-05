package com.yskkkkkk.august.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//배운점 stack.size() 로 반복문을 돌리면 안된다. 초기에 사이즈 고정하는 int 필요 예외 테스트케이스에 대한 세심한 처리 
public class PairUseStack {

	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] answer = new int[1];
		
		for (int i = 0; i < answer.length; i++) {
			int size = Integer.parseInt(br.readLine());
			Stack<Character> stack = new Stack<>();
			String input = br.readLine();
			for (int j = 0; j < input.length(); j++) {
				stack.push(input.charAt(j)); 
			}
			int[] sums = new int[4];
			outer: for (int j = 0; j < size; j++) {
				switch (stack.pop()) {
					case '[':	sums[0]+=1;	break;
					case ']':	sums[0]-=1; break;
					case '{':	sums[1]+=2;	break;
					case '}':	sums[1]-=2;	break;
					case '(':	sums[2]+=3;	break;
					case ')':	sums[2]-=3;	break; 
					case '<':	sums[3]+=4;	break;
					case '>':	sums[3]-=4;	break;
				}
				for (int k = 0; k < sums.length; k++) {
					if (sums[k] > 0) {
						sums[k] = -1;
						break outer;
					}
				}
			}
			int sum = 0;
			for (int j : sums) {
				sum += j;
			}
			answer[i] = sum == 0 ? 1 : 0;
		}
		for (int i = 0; i < answer.length; i++) {
			System.out.println("#"+(i+1)+" "+answer[i]);
		}
		br.close();
	}
}
