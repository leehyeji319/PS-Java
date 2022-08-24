package com.ssafy.swea;

import java.io.*;
import java.util.*;

/*
 * 중복순열
 * */
public class SWEA_2819_격자판숫자이어붙이기v1 {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] map;
	static HashSet<Integer> set;

	public static void main(String[] args) throws Exception {
		// 데이터 입력 받고
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// 초기화
			map = new int[4][4];
			set = new HashSet<>();
			// 데이터 입력받기
			for (int r = 0; r < 4; r++) {
				String line = br.readLine();
				for (int c = 0, k = 0; c < 4; c++, k += 2) {
					map[r][c] = line.charAt(k) - '0';
				}
			}
			// 4*4 행렬을 모두 반복 돌면서 7개의생성할 수 있는 모든 숫자를 만들기 dfs ==>
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					dfs(i, j, 1, map[i][j]);
				}
			}

			// 결과 출력
			System.out.println("#" + tc + " " + set.size());
		}

	}

	public static void dfs(int r, int c, int cnt, int num) { // 중복순열이기 때매 체크해줄 필요가 없다
		// 기저조건 7개의 숫자를 모두 만들면 종료
		// 7개의 숫자를 set에 넣어주고 return
		if (cnt == 7) {
			set.add(num);
			return;
		}

		// 4방향을 돌면서 숫자 생성하기
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			// 경계검사
			if (nr < 0 || nr >= 4 || nc < 0 || nc >= 4)
				continue;
			dfs(nr, nc, cnt + 1, (num * 10) + map[nr][nc]); // 밀어서1의 자리숫자로 만들으라고 ..
		}
	}
}
