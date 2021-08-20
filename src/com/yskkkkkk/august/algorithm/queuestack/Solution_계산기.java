package com.yskkkkkk.august.algorithm.queuestack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_계산기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 1; i <= 10; i++) {
			StringBuilder sb = new StringBuilder();
			int size = Integer.parseInt(br.readLine());
			String input = br.readLine();
			Stack<Character> stack = new Stack<>();
			for (int j = 0; j < size; j++) {
				switch (input.charAt(j)) {
				case '+': case '-':
					while (stack.size() != 0) sb.append(stack.pop());
					stack.add(input.charAt(j));
					break;
				case '*': case '/':
					stack.add(input.charAt(j));
					break;
				default:
					sb.append(input.charAt(j));
				}
			}
			while(stack.size() != 0) sb.append(stack.pop());
			
			String parsingInput = sb.toString();
			
			Stack<Integer> cal = new Stack<>();
			for (int j = 0; j < size; j++) {
				int b = 0, a = 0;
				switch (parsingInput.charAt(j)) {
				case '+':
					b = cal.pop();
					a = cal.pop();
					cal.add(a+b);
					break;
				case '-':
					b = cal.pop();
					a = cal.pop();
					cal.add(a-b);
					break;
				case '*':
					b = cal.pop();
					a = cal.pop();
					cal.add(a*b);
					break;
				case '/':
					b = cal.pop();
					a = cal.pop();
					cal.add(a/b);
					break;
				default:
					cal.add(Character.getNumericValue(parsingInput.charAt(j)));
				}
			}
			System.out.println("#"+i+" "+cal.peek());
		}
		
		br.close();
	}
}
