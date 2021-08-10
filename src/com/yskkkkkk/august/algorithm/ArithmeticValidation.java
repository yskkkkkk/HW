package com.yskkkkkk.august.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class ArithmeticValidation {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int i = 0; i < 10; i++) {
			String number = br.readLine();
			
			while (number.contains(" ")) number = br.readLine();
			int n = Integer.parseInt(number);
			int result = 1;

			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				int tokens = st.countTokens();
				st.nextToken();					// 버려지는 데이터 
				String value = st.nextToken();	// 검증은 두번째 토큰만 해도된다.

				if (tokens != 2 && Pattern.matches("^[0-9]*$", value)) {
					result = 0;
					break;
				} else if (tokens == 2 && !Pattern.matches("^[0-9]*$", value)) {
					result = 0;
					break;
				}
			}
			System.out.println("#" + (i+1) + " " + result);
		}
		br.close();
	}
}
