package com.ssafy.swea;

import java.io.*;
import java.util.*;

public class SWEA_5644_무선충전 {
	private static int[] dr = {0,-1, 0, 1, 0};
	private static int[] dc = {0, 0, 1, 0, -1};
	private static boolean[][] checked;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken()); //몇초
			int A = Integer.parseInt(st.nextToken()); //배터리수 
			
			int[] movingA = new int[M];
			int[] movingB = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				movingA[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				movingB[i] = Integer.parseInt(st.nextToken());
			}
			
			int[][] APs = new int[A][4]; //배터리정보
			
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				int Row = Integer.parseInt(st.nextToken());
				int Col = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());
				
				APs[i][0] = Row;
				APs[i][1] = Col;
				APs[i][2] = C;
				APs[i][3] = P;
			}
			//입력끝
			
			
			Map<Integer, int[]> apPositions = new HashMap<>();
			checked = new boolean[10][10];
			
			//불리언2차원 배열로 충전기 범위를 미리 true로 바꿔놓고, 해시맵에다가 그 좌표를 저장
			for (int i = 0; i < A; i++) {
				int row = APs[i][0];
				int col = APs[i][1];
				int dist = APs[i][2];
				checkChargeArea(row, col, dist, i);
			}
			
			
//			Hashmap areaInCharger
			//슈도코드
//			(5,4) -> [1]
//			(4,5) -> [1,3]
//			(6,9) -> [2]
//					
//			A -> (4,5)
//			B -> (5,4)
//			
//			[1,3]   [1,5,6,7,8]
//					for( 20) {
//						max = '-inf'
//								for(A -> [1,3]) {
//									for (B -> [1,5,6,7,8]) {
//										A -> 1
//										B -> 1
//										if (둘이 같을) {
//											max = (Battery 1, max) 
//										}
//										else 둘이 다를떄 {
//											max = (max, Battery A + Battery B)
//										}
//									}
//								}
//								answer += max
//					}
//			
	
			
		}
		
	}
	
	// 충전기 거리만큼 true로 바꿔주기.
	public static void checkChargeArea(int row, int col, int dist, int apNum) {
		if (dist == 0) return;
		if(row < 0 || row > 9 || col < 0 || col > 9) return;
		
		
		if(checked[row][col] == false) checked[row][col] = true;
		//TODO: hashmap에 apnum 관련 추가 
		checkChargeArea(row + 1, col, dist - 1, apNum);
		checkChargeArea(row - 1, col, dist - 1, apNum);
		checkChargeArea(row, col + 1, dist - 1, apNum);
		checkChargeArea(row, col - 1, dist - 1, apNum);
	}
	
	
//	public static int[][] movingPerson(int[] movingA, int[] movingB, int M) {
//		for (int time = 0; time < M; time++) {
//			
//		}
//	}

}
