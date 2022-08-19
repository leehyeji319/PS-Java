package com.ssafy.boj;

import java.util.*;
import java.io.*;

public class BOJ_빵집_3109 {
	static int R, C, answer;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); // R행
		C = Integer.parseInt(st.nextToken()); // C열

		visited = new boolean[R][C];
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (line[j] == 'x') {
					map[i][j] = 1;

				} else if (line[j] == '.'){
					map[i][j] = 0;
				}
			}
		}
		
		for (int i = 0; i < R; i++) {
			if (map[i][0] == 0) {
				if (dfs(i, 0)) {
					answer++;
				}
			}
		}

		System.out.println(answer);

	}

	public static boolean dfs(int r, int c) {
		if (c == C - 1) {
			return true;
		}

		for (int d : dr) {
			if (0 <= (r + d) && (r + d) < R && map[r + d][c + 1] == 0 && !(visited[r + d][c + 1])) {
				visited[r + d][c + 1] = true;
				if (dfs(r + d, c + 1)) {
					return true;
				}
			}

		}
		return false;
	}
	
	
	
}
