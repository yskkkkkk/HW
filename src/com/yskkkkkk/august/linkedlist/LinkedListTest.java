package com.yskkkkkk.august.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class LinkedListTest {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 1; i <= 10; i++) {
			int length = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());
			LinkedList linkedList = new LinkedList(); 
			for (int j = 0; j < length; j++) {
				linkedList.insertFirst(Integer.parseInt(st.nextToken()));
			}

			int commandCount = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine(), "I");
			for (int j = 0; j < commandCount; j++) {
				StringTokenizer stInfor = new StringTokenizer(st.nextToken());
				int index = Integer.parseInt(stInfor.nextToken())-1;
				int count = Integer.parseInt(stInfor.nextToken());
				Stack<Integer> stack = new Stack<>();
				
				for (int k = 0; k < count; k++) {
					stack.add(Integer.parseInt(stInfor.nextToken()));
				}
				for (int k = 0; k < count; k++) {
					linkedList.add(index, stack.pop());
				}
			}
			
			System.out.print("#"+i+" ");
			linkedList.printList(10);
		}
	}
}