package com.ssafay.swea;

import java.io.*;
import java.util.*;

class 파리퇴치 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // N*N 배열
			int M = Integer.parseInt(st.nextToken()); // M*M 파리채

			int[][] area = new int[N][N];
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < N; k++) {
					area[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			int max = 0;
			int n = 0;
			for (int x = 0; x <= N - M; x++) {
				for (int y = 0; y <= N - M; y++) {
					int temp = 0;
					for (int l = x; l < x + M; l++) {
						for (int l2 = y; l2 < y + M; l2++) {
							temp += area[l][l2];
						}
					}
					max = Math.max(max, temp);
				}
			}
			sb.append("#").append(i + 1).append(" ").append(max).append("\n");
		}
		System.out.println(sb);

	}
}