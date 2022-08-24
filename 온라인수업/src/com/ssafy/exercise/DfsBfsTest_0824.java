package com.ssafy.exercise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class DfsBfsTest_0824 {

	static int[][] map;
	static int N, M, V;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[to][from] = 1;
			map[from][to] = 1;
		}

		bfs();
		dfs(V);
	}

	private static void dfs(int cur) {
		visited[cur] = true;
		System.out.println((char)(cur + 'A'));

		for (int i = 0; i < N; i++) {
			if (!visited[i] && map[cur][i] != 0) {
				dfs(i);
			}
		}
	}

	private static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N];

		visited[0] = true;
		queue.offer(0);

		while(!queue.isEmpty()) {
			int cur = queue.poll();
			System.out.println((char)(cur + 'A'));

			for (int i = 0; i< N; i++) {
				if (!visited[i] && map[cur][i] == 0) {
					visited[i] = true;
					queue.offer(i);
				}
			}
			System.out.println();
		}
	}
}
