package com.ssafy.boj;

import java.util.*;
import java.io.*;

public class 색종이만들기 {

	static int[][] map;
	static int white;
	static int blue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		div(0, 0, N);
		System.out.println(white);
		System.out.println(blue);

	}

	public static void div(int row, int col, int size) {

		if (check(row, col, size)) {
			if (map[row][col] == 0)
				white++;
			else
				blue++;

			return;
		}

		int tmpSize = size / 2;

		div(row, col, tmpSize); // 1
		div(row, col + tmpSize, tmpSize); // 2
		div(row + tmpSize, col, tmpSize); // 3
		div(row + tmpSize, col + tmpSize, tmpSize); // 4

	}

	public static boolean check(int row, int col, int size) {

		int color = map[row][col];

		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				// 색상 안같을때
				if (map[i][j] != color)
					return false;
			}
		}
		return true;
	}

}
