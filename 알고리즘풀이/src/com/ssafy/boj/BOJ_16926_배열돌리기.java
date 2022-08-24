package com.ssafy.boj;

import java.util.*;
import java.io.*;

public class BOJ_16926_배열돌리기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] dr = {0,1,0,-1}; //우 상 좌 하
		int[] dc = {1,0,-1,0}; //우 상 좌 하
		
		int groupCnt = Math.min(N, M) / 2;
		
		for (int r = 0; r < R; r++) { //r번 만큼 돌리기시작
			for (int i = 0; i < groupCnt; i++) {
				int row = i;
				int col = i;
				
				int value = arr[row][col];
				
				int dir = 0; //방향
				
				while (dir < 4) {
					int nr = row + dr[dir];
					int nc = col + dc[dir];
					
					if (nr >= i && nc >= i && nr < N - i && nc < M -i) {
						arr[row][col] = arr[nr][nc];
						row = nr;
						col = nc;
					}
					
					//범위 끝나면 방향 바꾸기
					else dir++;
				}
				arr[i+1][i] = value; //(1,1), (2,2) 이거 밑에칸에 넣어주기
				
				
			}
			
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
