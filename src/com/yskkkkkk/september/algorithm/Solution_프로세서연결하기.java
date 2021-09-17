package com.yskkkkkk.september.algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_프로세서연결하기 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] map;
	static int n, maxCore, minLine;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= t; testCase++) {
			n = Integer.parseInt(br.readLine());

			map = new int[n][n];
			ArrayList<Core> cores = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1)
						cores.add(new Core(i, j));
				}
			}
			maxCore = 0;
			minLine = Integer.MAX_VALUE;

			dfs(0, 0, 0, cores);
			System.out.println("#" + testCase + " " + minLine);
		}
		br.close();
	}

	public static void dfs(int idx, int coreCnt, int lineLen, ArrayList<Core> cores) {
		if (idx == cores.size()) {
			if (coreCnt > maxCore) {
				maxCore = coreCnt;
				minLine = lineLen;

			} else if (coreCnt == maxCore) {
				if (minLine > lineLen) {
					minLine = lineLen;
				}
			}
			return;
		}
		Core c = cores.get(idx);

		for (int i = 0; i < 4; i++) {
			if (c.x == 0 || c.x == n - 1 || c.y == 0 || c.y == n - 1) {
				dfs(idx + 1, coreCnt + 1, lineLen, cores);
				break;

			}
			int check = checkLine(i, c);
			int nx = c.x;
			int ny = c.y;
			if (check != -1) {	// 벽에 닿지 않을 때
				dfs(idx + 1, coreCnt + 1, lineLen + check, cores);
				for (int j = 0; j < check; j++) {
					nx += dx[i];
					ny += dy[i];
					map[nx][ny] = 0;

				}
			}

		}
		dfs(idx + 1, coreCnt, lineLen, cores); // 코어를 선택하지않고 넘어가는 경우
	}

	public static int checkLine(int i, Core core) {
		int line = 0;
		int nx = core.x + dx[i];
		int ny = core.y + dy[i];
		boolean check = false;
		while (true) {
			line++;
			if ((nx == 0 || nx == n - 1 || ny == 0 || ny == n - 1) && map[nx][ny] == 0) {
				check = true;
				break;
			}
			if (map[nx][ny] != 0) {
				check = false;
				break;
			}
			nx += dx[i];
			ny += dy[i];

		}
		nx = core.x;
		ny = core.y;
		if (check) {
			for (int idx = 0; idx < line; idx++) {
				nx += dx[i];
				ny += dy[i];
				map[nx][ny] = 2;

			}
			return line;
		}
		return -1;
	}

	static class Core {
		int x; int y;
		public Core(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
