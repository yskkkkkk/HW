package com.yskkkkkk.august.pcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_baekjoon_1759_암호만들기 {

	static int l, c;
	static char[] result;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		char[] list = new char[c];
		result = new char[l];
		
		String alphabet = br.readLine();
		for (int i = 0; i < alphabet.length(); i+=2) {
			list[i/2] = alphabet.charAt(i);
		}
		br.close();
		Arrays.sort(list);
		
		combination(list, 0, 0);
	}
	
	static void combination(char[] list, int depth, int start) {
		if (depth == l) {
			print(result);
			return;
		}
		for (int i = start; i < c; i++) {
			result[depth] = list[i];
			combination(list, depth+1, i+1);
		}
	}
	
	static void print(char[] result) {
		int vowel = 0;
		int consonant = 0;
		for (char c : result) {
			if (c=='a' || c=='o' || c=='e' || c=='u' || c=='i') vowel++;
			else consonant++;
			if (vowel>=1 && consonant>=2) {
				for (char ch : result) 
					System.out.print(ch);
				System.out.println();
				break;
			}
		}
	}
}
