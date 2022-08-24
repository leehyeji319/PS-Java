package com.ssafy.boj;

import java.util.*;
import java.io.*;

public class BOJ_1260_DFS와BFS {

	static int[][] map;
	static int N, M, V;
	static boolean visited[];
	
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
			map[to][from] = map[from][to] = 1;
		}
		
		dfs(V);
		System.out.println();
		bfs(V);
	}
	
	private static void dfs(int v) {
		visited[v] = true;
		System.out.print(v + " ");
		
		for (int i = 1; i <= N; i++) {
			if (!visited[i] && map[v][i] == 1) {
				dfs(i);
			}
		}
	}
	
	
	private static void bfs(int v) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(v);
		visited[v] = false;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			System.out.print(cur + " ");
			
			for (int i = 1; i <= N; i++) {
				if(visited[i] && map[cur][i] == 1) {
					queue.offer(i);
					visited[i] = false;
				}
			}
			
		}
	}

}
