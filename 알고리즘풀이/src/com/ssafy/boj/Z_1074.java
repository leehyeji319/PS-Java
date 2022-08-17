package com.ssafy.boj;

import java.util.*;
import java.io.*;

public class Z_1074 {

	private static int visitedNum;
	private static int[][] map;
	private static int N, R, C;
	private static int[] dr = { 0, 0, 1, 0 };
	private static int[] dc = { 0, 1, -1, 1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		div(R, C, (int) Math.pow(2, N));
	}

	public static void div(int row, int col, int size) {
		// 네갈죽
		if (size == 1) {
			System.out.println(visitedNum);
			return;
		}
		int newSize = size / 2;

		if (row < newSize && col < newSize) {
			visitedNum += newSize * newSize * 0;
			div(row, col, newSize);
		} else if (row < newSize && col < newSize + newSize) {
			visitedNum += newSize * newSize * 1;
			div(row, col, col - newSize);
		} else if (row < newSize + newSize && col < newSize) {
			visitedNum += newSize * newSize * 2;
			div(row - newSize, col, newSize);
		} else if (row < newSize + newSize && col < newSize + newSize) {
			visitedNum += newSize * newSize * 3;
			div(row - newSize, col - newSize, newSize);
		}
		
	}

}
