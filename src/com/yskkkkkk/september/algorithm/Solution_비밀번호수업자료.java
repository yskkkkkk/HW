package com.yskkkkkk.september.algorithm;

import java.io.IOException;
import java.util.Scanner;

public class Solution_비밀번호수업자료 {

	public static int T = 0, N, M;
	public static long Q = 1000000007;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 7
			M = sc.nextInt(); // 11
			long result = surjection(M, N, Q);
			// 황당 modular는 더했을 때 작아질수 있다.
			// 2^3-2^2===(8-4)=== -3 ===4(mod 7)
			System.out.printf("#%d %d\n", tc, result >= 0 ? result : (result + Q));
		}
		sc.close();
	}// main

	static long surjection(int m, int n, long p) {
		long tot = 0L;
		for (int i = 0; i < n; i++) {
			tot = (tot + ((i % 2 == 0 ? 1L : -1L) * (((power(n - i, m, p) % p) * nCr(n, i, p) % p) % p)) % p) % p;
		}
		return tot % p;
	}

	/*
	 * 5C2%7 -> 5!/(3!*2!) %7 -> 5!* 6^5 * 2^5 %7 -> (5! %7)*(6^1 %7 * 6^4 %7)*(2^1
	 * %7 * 2^4 %7)
	 */
	static long power(long x, long y, long p) {
		long res = 1L;

		x = x % p;
		// => 3^7 > 7 3 1 3^7 --> 3^1*3^2*3^4
		while (y > 0) {
			if (y % 2 == 1)
				res = (res * x) % p;
			y = y >> 1; // y = y/2
			x = (x * x) % p;
		}

		return res % p;
	}

	static long modInverse(long n, long p) {
		return power(n, p - 2, p);
	}

	static long nCr(int n, int r, long p) {

		if (r == 0)
			return 1L;

		long[] fac = new long[n + 1];
		fac[0] = 1;

		for (int i = 1; i <= n; i++)
			fac[i] = fac[i - 1] * i % p;

		return (fac[n] * modInverse(fac[r], p) % p * modInverse(fac[n - r], p) % p) % p;
	}
}
