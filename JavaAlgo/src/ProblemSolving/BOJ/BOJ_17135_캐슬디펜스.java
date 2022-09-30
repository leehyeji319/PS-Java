package ProblemSolving.BOJ;//package com.ssafy.boj;
//import java.io.*;
//import java.util.*;
//
//
///*
// * 1. 궁수 위치를 조합으로 
// * 2. 거리 D안에 있으면 바로 죽이고, 없다면 거리를 +1 씩하면서 죽임
// * 3. 거리가 같은 적이 있으면 queue를 이용하여 제일 왼쪽에있는 애부터 죽인다.
// * */
//public class BOJ_캐슬디펜스_17135 {
//	static int N, M, D;
//	static int[][] map, copyMap;
//	static int enemiesCnt;
//	static int answer;
//	//왼쪽부터 탐색하기위함
//	static int[] dr = {0, -1, 0};
//	static int[] dc = {-1, 0, 1};
//	
//	
//	//조합
//	static int[] ableArcher;
//	static int[] archer;
//
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st; 
//		
//		st = new StringTokenizer(br.readLine());
//		N = Integer.parseInt(st.nextToken()); //N행 
//		M = Integer.parseInt(st.nextToken()); //M열
//		D = Integer.parseInt(st.nextToken()); //D거리
//
//		map = new int[N][M];
//		for (int i = 0; i < N; i++) {
//			st = new StringTokenizer(br.readLine());
//			for (int j = 0; j < M; j++) {
//				map[i][j] = Integer.parseInt(st.nextToken());
//				copyMap[i][j] = map[i][j];
//				if (map[i][j] == 1) {
//					enemiesCnt++;
//				}
//			}
//			
//		}
//		
//		combSetArcher(new boolean[M], 0, 0);
//		
//	}
//	
//	public static void combSetArcher(boolean[] selected, int cnt, int start) { //cnt: 직전까지 뽑은 순열에 포함된 개수, start: 시도할 수의 시작 위치ㄴ
//		if (cnt == 3) {
//			archer = new int[3];
//			//3개 조합완성도면 할일 작성
//			int idx = 0;			
//			for (int i = 0; i < M; i++) {
//				if (selected[i])
//				archer[idx++] = i;
//			}
//			
//			
//			playGame(archer);
//			return;
//		}
//		
//		for (int i = start; i < M; i++) {
//			selected[i] = true;
//			archer[cnt] = ableArcher[i]; //앞쪽에서 사용되지 않았다면 수를 사용
//			//다음수 뽑으러 가기
//			combSetArcher(selected, cnt + 1,  i + 1);
//			selected[i] = false;
//		}
//	}
//	
//	public static void playGame(int[] archer) {
//		boolean[][] died;
//		int totalKillCnt = 0;
//		
//		for (int turn = 0; turn < N; turn++) {
//			died = new boolean[N][M];
//			
//			for (int y : archer) {
//				
//				if (map[N - 1][y] == 1) {
//					died[N - 1][y] = true;
//					 
//				} else {
//					//한칸 이내에 없을 경우 한칸씩 늘려가면서 적을 찾음
//					
//				}
//			}
//			
//			
//		}
//		
//		
//	}
//	
//
//	
//	public static int getDistance(int r1, int c1, int r2, int c2) {
//		return Math.abs(r1-r2) + Math.abs(c1 - c2);
//	}
//	
//	public static int kill (boolean[][] died, int[][]map) {
//		
//	}
//	
//	//되돌리기 위한 초기화
//	public static void init() {
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				map[i][j] = copyMap[i][j];
//			}
//		}
//	}
//	
//	public static boolean isRangeIn(int r, int y) {
//		if (0 <= r && r < N && 0 <= y && y < M) {
//			return true;
//		} else {
//			return false;
//		}
//	}
//	
//	
//	public static void move(int[][] map) {
//		for (int i = N - 1; i >= 0; i--) {
//			for (int j = 0; j < M; j++) {
//				if (map[i][j] == 1) {
//					map[i][j] = 0;
//					
//					if (i + 1 < N) {
//						map[i + 1][j] = 1;
//					}
//				}
//			}
//		}
//	}
//	
//	static class Point {
//		int x, y;
//		
//		Point(int x, int y) {
//			this.x = x;
//			this.y = y;
//		}
//	}
//}
//
//
///**
// * 구할 값 : 궁수의 공격으로 제거할수 있는 적의 최대 수
// * 
// * 제한 사항 
// * # 하나의 궁수는 적하나만 공격 가능, 모든 궁수는 동시공격을 하고, 한 적한테 쏠릴수있다
// * # 거리가 D이내이면서 가장 가까운 적을 공격한다. 조건이 여러명인 경우 가장 왼쪽 적을 공격
// * # 사라지는 조건 - 공격을 받았을 때, 성이 있는 칸에 도달했을 때
// * # 턴이 끝나면 적은 한칸 아래로 이동
// * 
// * 
// * # 종료 조건 - 격자판에 모든 적이 사라졌을 때
// */