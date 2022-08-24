package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926_배열돌리기1v좌표로말고 {

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

		int groupCnt = Math.min(N, M) / 2;
		for (int r = 0; r < R; r++) {
			for (int cnt = 0; cnt < groupCnt; cnt++) {
				int n_max = N - cnt - 1;
				int m_max = M - cnt - 1;
				
				int value = arr[cnt][cnt];
				
				//윗쪽 오른쪽에서 왼쪽으
				for (int i = cnt; i < m_max; i++) {
					arr[cnt][i] = arr[cnt][i + 1];
				}
				
				//오른쪽 아래에서 위
				for (int i = cnt; i < n_max; i++) {
					arr[i][m_max] = arr[i + 1][m_max];
				}
				
				//아래쪽변 왼쪽에서 오른쪽으
				for (int i = m_max; i > cnt; i--) {
					arr[n_max][i] = arr[n_max][i - 1];
				}
				
				//왼쪽 변 위에서 아래
				for (int i = n_max; i > cnt; i--) {
					arr[i][cnt] = arr[i - 1][cnt];
				}
				
				arr[cnt + 1][cnt] = value;
				
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
