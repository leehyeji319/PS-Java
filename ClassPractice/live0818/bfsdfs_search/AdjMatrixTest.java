package com.ssafy.live0818.bfsdfs_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AdjMatrixTest {
	
	static int[][] map;
	static int N, M, V;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
	
		map = new int[N + 1][N + 1]; //0으로 초기화
		visited = new boolean[N + 1];
		for (int i = 0; i < M; i++) { //간선 정보해당하는 부분 덮어씀
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[to][from] = 1;
			map[from][to] = 1; //무향그래프
		}
		
//		bfs();
		dfs(V);
		
	}
	
	
	private static void dfs(int cur) {
		
		visited[cur] = true; //탐색나올때
		System.out.println((char)(cur + 'A'));
		
		//현정점의 인접정점들에 큐에 넣어서 차후 탐색하도록 만들기
		for (int i = 0; i < N; i++) {
			if (!visited[i] && map[cur][i] != 0) { //방문하지 않앗으며 인접한 경우
				dfs(i);
			}
		}
	}
	
	private static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N]; //방문관리배열
		
		visited[0] = true;
		queue.offer(0);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			System.out.println((char)(cur + 'A'));
			
			//현 정점의 인접정점들에 큐에 넣어서 차후 탐색하도록 만들기
			for (int i = 0; i < N; i++) {
				if (!visited[i] && map[cur][i] == 0) { //방문하지 않앗으며 인접한 경우
					
					visited[i] = true;
					queue.offer(i);
					
				}
			}
			System.out.println();
		}
	}

}
