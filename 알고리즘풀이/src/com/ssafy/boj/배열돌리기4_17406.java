package com.ssafy.boj;

import java.util.*;
import java.io.*;

public class 배열돌리기4_17406 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			
			int startR = R - S - 1;
			int startC = C - S - 1;
			int endR = R + S - 1;
			int endC = C + S - 1;
			
			int groupCnt = Math.min(N, M)/2;
			for (int cnt = 0; cnt < groupCnt; cnt++) {
				int n_max = N - endR - cnt;
				int m_max = M - endR - cnt;
				
				int value = arr[startR][startC];
				
				//윗변 왼->오
				for (int i = endC; i > startC; i--) {
					//arr[startR][i] = arr[startR][i - 1]
				}
				
				
			}
		}

	}

}
