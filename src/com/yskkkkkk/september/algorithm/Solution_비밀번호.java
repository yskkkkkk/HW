package com.yskkkkkk.september.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_비밀번호 {

	static int m, n;
	static int MOD = (int) 1e9 + 7;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());

			long result = solve();
			result = result < 0 ? result + MOD : result;
			System.out.println("#"+tc+" "+result);
		}
		br.close();
	}

	// ∑(-1)^i * kCn * (k-i)ⁿ
	static long solve() {
		long total = 0;
		for (int i = 0; i <= m; i++) {
			long l1 = i % 2 == 0 ? 1 : -1;
			long l2 = nCr(i);
			long l3 = (long) (Math.pow(m - i, n));
			long result = ((l1 * l2) % MOD * l3) % MOD;
			total += result;
		}
		return total % MOD;
	}

	// nCr = n! / ((n-r)! * r!)
	static long nCr(int r) {
		if (r == 0)	return 1;
		long l1 = 1;
		long l2 = 1;
		for (int i = 0; i < r; i++) {
			l1 *= (m - i) % MOD;
		}
		for (int i = 1; i <= r; i++) {
			l2 *= i % MOD;
		}
		return (l1 / l2) % MOD;
	}
}
