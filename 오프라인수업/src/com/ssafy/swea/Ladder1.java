package com.ssafy.swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ladder1 {
	static final int T = 10;
	static final int SIZE = 100;
	
	public static void main(String[] args) throws Exception, IOException {
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		//testcase입력
		for (int t = 1; t <= 10; t++) {
			
			int testCaseNumber = Integer.parseInt(br.readLine());
			//2차원배열 초기화
			int[][] ladder = new int[SIZE][SIZE];
			
			int answer = 0;
			int col = 0;
			int row = 99;
			
			for (int i = 0; i < SIZE; i++) {
				String[] line = br.readLine().split(" ");
				
				for (int j = 0; j < SIZE; j++) {
					ladder[i][j] = Integer.parseInt(line[j]);
				}
			}
			
			//숫자 2인 좌표 찾기
			for (int j = 0; j < SIZE; j++) {
				if (ladder[99][j] == 2) {
					col = j;
					break;
				}
			}
			
			while(true) {
				if (row == 0) {
					answer = col;
					break;
				}
				
				//지나간 곳 0으로 바꿔주기
				ladder[row][col] = 0;
				
				// 좌우 먼저확인 후에 위 확인 
				if ((col - 1 >= 0 ) && ladder[row][col - 1] == 1) {
					col--;
				} else if ((col + 1 < 100) && ladder[row][col + 1] == 1) {
					col++;
				} else if ((row - 1 >= 0) && ladder[row - 1][col] == 1) {
					row--;
				}
			}
			
			System.out.println("#" + testCaseNumber + " " + answer);
		}
		
	}

}
