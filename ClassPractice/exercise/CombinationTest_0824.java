package com.ssafy.exercise;

import java.io.*;
import java.util.*;
public class CombinationTest_0824 {
	static int N, R, totalCnt;
	static int[] input, numbers;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		input = new int[N];
		numbers = new int[R];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		comb(0,0);
		System.out.println("총 경우의 수 : " + totalCnt);
	}

	private static void comb(int cnt, int start) {
		if (cnt == R) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}

		for (int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			comb(cnt + 1, i + 1);
		}
	}
}
