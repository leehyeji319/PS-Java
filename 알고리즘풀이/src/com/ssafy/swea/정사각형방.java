package com.ssafy.swea;

import java.util.*;
import java.io.*;

public class 정사각형방 {
	private static int N;
	private static int[][] map;
	private static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	private static int[] dc = { 0, 0, -1, 1 }; // 상하좌우
	private static int answer;
	private static int max;
	private static int start;

	public static void main(String[] args) throws Exception, IOException {
		System.setIn(new FileInputStream("res/square.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			max = 0;
			start = 0;
			map = new int[N][N];
			// map에 넣기
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					answer = 0;
					bfs(r, c);
					if (max < answer) {
						max = answer;
						start = map[r][c];
					} 
					if (max == answer) {
						start = Math.min(map[r][c], start);
					}
				}
			}
			System.out.println("#"+tc+" "+start+" "+(max + 1));
		}
	}

	private static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { r, c });
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			r = cur[0];
			c = cur[1];

			// 4방탐색
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (nr<0 || nc<0 || nr>=N || nc>=N || (map[nr][nc] != map[r][c]+1)) {
					continue;
				}
				answer++;
				queue.offer(new int[] {nr, nc});
				break;
			}
		}
	}

}
