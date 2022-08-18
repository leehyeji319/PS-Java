package com.ssafy.programmers;

import java.util.ArrayList;
import java.util.List;

public class Solution_퍼즐조각채우기 {
	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		int[][] game_board = { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 1 } };
		int[][] table = { { 1, 1, 1 }, { 1, 0, 0 }, { 0, 0, 0 } };
		System.out.println(solution(game_board, table));
	}

	public static int solution(int[][] gameBoard, int[][] table) {
		int answer = -1;

		int[][] gameBoardCopy = deepCopy(gameBoard);
		int[][] tableRotateCopy;
		List<Integer> block = new ArrayList<>();

		int l = gameBoard.length;
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++) {
				if (gameBoardCopy[i][j] == 0) {
					gameBoardCopy[i][j] = 2;
					int[] start = { 0, 0 };
					// 하 ... .
//        			int[] result = dfs(gameBoardCopy, i, j, start, l, 0);

				}
			}
		}

		for (int r = 0; r < 4; r++) {
			table = rotate(table);
			tableRotateCopy = deepCopy(table);

			for (int i = 0; i < l; i++) {
				for (int j = 0; j < l; j++) {
					if (tableRotateCopy[i][j] == 1) {
						tableRotateCopy[i][j] = 2;
						// dfs??
						int[] start = { 0, 0 };
//        				int[] result = dfs(tableRotateCopy, i, j, start, l, 1);
//        				
//        				if 
					}
				}
			}
		}

		return answer;
	}

	public static int[] dfs(int[][] arr, int r, int c, int[] position, int n, int num) {
		int[] ret = position;

		for (int i = 0; i < 4; i++) {
			int nr = dr[i] + r;
			int nc = dc[i] + c;

			if (isRangeIn(arr, nr, nc, n, num)) {
				arr[nr][nc] = 2;
				int tmp1 = position[0] + dr[i];
				int tmp2 = position[1] + dc[i];
				int[] tmpP = { tmp1, tmp2 };
				int[] tmpD = dfs(arr, nr, nc, tmpP, n, num);
				ret[0] += tmpD[0];
				ret[1] += tmpD[1];
			}
		}
		return ret;
	}

	//테이블 90도 돌리기
	public static int[][] rotate(int[][] table) {
		int size = table.length;
		int[][] rotateTable = new int[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				rotateTable[j][size - 1 - i] = table[i][j]; // 돌려돌려~
			}
		}

		return rotateTable;
	}

	public static int[][] deepCopy(int[][] arr) {
		int size = arr.length;
		int[][] arrdeepCopy = new int[size + 1][size + 1];
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				arrdeepCopy[i][j] = arr[i][j];
			}
		}
		return arrdeepCopy;
	}

	public static boolean isRangeIn(int[][] arr, int nr, int nc, int n, int num) {
		if (nr < 0 || nr >= n || nc < 0 || nc >= n || arr[nr][nc] != num) {
			return false;
		}
		return true;
	}

}

/**
 * 제한사항 1. 도형은 최소1개부터 최대6개 
 * 2. 회전만 가능하고 업어치기 불가능 ..테이블을 돌려볼까?
 * 
 */