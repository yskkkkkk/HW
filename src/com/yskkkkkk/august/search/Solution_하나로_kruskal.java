package com.yskkkkkk.august.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 크루스칼 알고리즘 사용
public class Solution_하나로_kruskal {

	static int V, E, edgeCount;
	static Edge[] edgeList;
	static int[] parents;
	static Island[] result = new Island[2];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= testCase; t++) {
			edgeCount = 0;
			V = Integer.parseInt(br.readLine());
			E = (V * (V-1))/2;
			edgeList = new Edge[E];
			
			List<Island> list = new ArrayList<>();
			StringTokenizer xs = new StringTokenizer(br.readLine());
			StringTokenizer ys = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < V; i++) {
				list.add(new Island(Integer.parseInt(xs.nextToken()),Integer.parseInt(ys.nextToken()), i));
			}
			double taxRate = Double.parseDouble(br.readLine());
			
			combination(list, 0, 0);
			
			Arrays.sort(edgeList); // 오름차순 정렬
			make(); // 모든 정점을 각각으로 집합으로 만들고 출발
			
			// 간선 하나씩 시도하며 트리 만들어 감.
			int cnt = 0;
			double result = 0;
			for (Edge edge : edgeList) {
				if(union(edge.start, edge.end)) {
					result += edge.weight;
					if(++cnt == V-1) break; // 신장트리 완성
				}
			}
			System.out.println("#"+t+" "+Math.round(result * taxRate));	
			
		}
		br.close();
	}
	
	private static void make() {
		parents = new int[V];
		// 모든 원소를 자신을 대표자로 만듦
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}
	
	// a가 속한 집합의 대표자 찾기
	private static int find(int a) {
		if(a==parents[a]) return a;
		return parents[a] = find(parents[a]); 
	}

	// 두 원소를 하나의 집합으로 합치기(대표자를 이용해서 합침)
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false; 
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	static double calculator(Island i1, Island i2) {
		return (Math.pow(i1.x-i2.x, 2) + Math.pow(i1.y-i2.y, 2));
	}
	
	private static void combination(List<Island> list, int depth, int start) {
		if (depth == 2) {
			edgeList[edgeCount++] = new Edge(result[0].index, result[1].index, calculator(result[0], result[1]));
			return;
		}

		for (int i = start; i < V; i++) {
			result[depth] = list.get(i);
			combination(list, depth + 1, i + 1);
		}
	}
	
	static class Island{
		private int x;
		private int y;
		private int index;
		public Island(int x, int y, int index) {
			super();
			this.x = x;
			this.y = y;
			this.index = index;
		}
		
	}
	
	static class Edge implements Comparable<Edge>{
		int start;
		int end;
		double weight;
		public Edge(int start, int end, double weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			if (this.weight - o.weight < 0) return -1;
			else return 1;
		}
	}
}
