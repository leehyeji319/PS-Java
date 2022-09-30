package ProblemSolving.BOJ;//package com.ssafy.boj;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class 배열돌리기2_16927 {	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//
//		st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//		int R = Integer.parseInt(st.nextToken());
//
//		int[][] arr = new int[N][M];
//
//		for (int i = 0; i < N; i++) {
//			st = new StringTokenizer(br.readLine());
//			for (int j = 0; j < M; j++) {
//				arr[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//
//		//cnt = 2 * N + 2 * M - 4 :가장 바깥 테두리 돌릴경우 회전시 처음 상태와 같아지는 횟수(-4:겹치는 꼭지점위치)
//		//cnt -=8: 하나씩 안쪽 테두리로 들어갈수록 회전시 처음상태와 같아지는 횟수(4방이 하나씩 줄어드므로 총 8칸 줄어듬 )
////		for (int k = 0, c = 2*N+2*M-4; k < group; ++k, cnt-=8) {//테두리 별로 회전시킴
////			
////			
////		}
//
//		for (int r = 0; r < R; r++) {
//			for (int cnt = 0; cnt < groupCnt; cnt++) {
//				int n_max = N - cnt - 1;
//				int m_max = M - cnt - 1;
//				
//				int value = arr[cnt][cnt];
//				
//				//윗쪽 오른쪽에서 왼쪽으
//				for (int i = cnt; i < m_max; i++) {
//					arr[cnt][i] = arr[cnt][i + 1];
//				}
//				
//				//오른쪽 아래에서 위
//				for (int i = cnt; i < n_max; i++) {
//					arr[i][m_max] = arr[i + 1][m_max];
//				}
//				
//				//아래쪽변 왼쪽에서 오른쪽으
//				for (int i = m_max; i > cnt; i--) {
//					arr[n_max][i] = arr[n_max][i - 1];
//				}
//				
//				//왼쪽 변 위에서 아래
//				for (int i = n_max; i > cnt; i--) {
//					arr[i][cnt] = arr[i - 1][cnt];
//				}
//				
//				arr[cnt + 1][cnt] = value;
//				
//			}
//		}
//		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
//
//	}
//}
