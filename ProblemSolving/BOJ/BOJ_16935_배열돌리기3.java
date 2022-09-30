package com.ssafy.boj;

import java.util.*;
import java.io.*;

public class BOJ_16935_배열돌리기3 {

	private static int[][] arr;
	private static int N, M;
	private static int[][] temp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//명령입력받기 실행하기
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			int command = Integer.parseInt(st.nextToken());
			
			switch (command) {
			case 1:
				rotate1t();
				break;
			case 2:
				rotate2();
				break;
			case 3:
				rotate3();
				break;
			case 4:
				rotate4();
				break;
			case 5:
				rotate5();
				break;
			case 6:
				rotate6();
				break;
			}
		}
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void rotate1t() {
		int H = N / 2;
		int t[] = null;
		for (int i =0; i <H; i++) {
			t = arr[i];
			arr[i] = arr[N - 1 - i];
			arr[N - 1 -i] = t;
		}
	}
	
	public static void rotate1() {
		int[][] temp = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				//N - i - 1하면 거꾸로 입력
				temp[N - i - 1][j] = arr[i][j];
			}
		}
		arr = temp;
	}
	
	public static void rotate2() {
		temp = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// M - j -1 열의 맨뒤부터 채우기
				temp[i][M - j - 1] = arr[i][j];
			}
		}
		arr = temp;
	}
	
	public static void rotate3() {
		temp = new int[M][N];
		int c = N - 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[j][c] = arr[i][j];
			}
			c--;
		}
		
		//크기 바꿔주기
		int t = N;
		N = M;
		M = t;
		
		arr = temp;
		
	}
	
	public static void rotate4() {
		temp = new int[M][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[M - j - 1][i] = arr[i][j];
			}
		}
		
		//크기 바꿔주기
		int t = N;
		N = M;
		M = t;
		
		arr = temp;
	}
	
	public static void rotate5() {
		temp = new int[N][M];
		
		//행 가운데 값
		int N_mid = N / 2;
		//열 가운데 
		int M_mid = M / 2;
		
		//1면에서 2
		for (int i = 0; i < N_mid; i++) {
			for (int j = 0; j < M_mid; j++) {
				temp[i][M_mid+j] = arr[i][j];
			}
		}
		
		//2->3
		for (int i = 0; i < N_mid; i++) {
			for (int j = M_mid; j < M; j++) {
				temp[N_mid + 1][j] = arr[i][j];
			}
		}
		
		//3->4
		for (int i = N_mid; i < N; i++) {
			int c = 0;
			for (int j = M_mid; j < M; j++, c++) {
				temp[i][c] = arr[i][j];
			}
		}
		
		//4->1
		
		int Row = 0;
		
		for (int i = N_mid; i < N; i++, Row++) {
			for (int j = 0; j < M_mid; j++) {
				temp[Row][j] = arr[i][j];
			}
		}
		
		arr = temp;
		
	}
	
	public static void rotate6() {
		temp = new int[N][M];
		
		int N_mid = N / 2;
		int M_mid = M / 2;
		
		//1->4
		for (int i = 0; i < N_mid; i++) {
			for (int j = 0; j < M_mid; j++) {
				temp[N_mid + i][j] = arr[i][j];
			}
		}
		
		//4->3
		for (int i = N_mid; i < N; i++) {
			for (int j = 0; j < M_mid; j++) {
				temp[i][M_mid+j] = arr[i][j];
			}
		}
		
		//3->2
		int Row = 0;
		for (int i = N_mid; i < N; i++, Row++) {
			for (int j = M_mid; j <M; j++) {
				temp[Row][j] = arr[i][j];
			}
		}
		
		//2->1
		for (int i = 0; i < N_mid; i++) {
			int c = 0;
			for (int j = M_mid; j < M; j++, c++) {
				temp[i][c] = arr[i][j];
			}
		}
		
		arr = temp;
	}
	

}

//1번 상하반전 : N-i-1
//2번 좌우반전 : M-j-1
//3: int c이용해서 회전, 크기 변환 
//4: int row이용해서 회전,크기변환
//5: 행의 중앙값 nmid 열 중앙값 mmid만들어서 분할이동
//6: 행의 중앙값 nmid 열 중앙값 mmid만들어서 분할이동
