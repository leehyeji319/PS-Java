package com.ssafy.exercise;

import java.util.*;
import java.io.*;

public class CombinationTest_0819 {
	static int N, R, totalCnt;
	static int[] numbers, input;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		R = Integer.parseInt(br.readLine());
		totalCnt = 0;
		
		input = new int[N];
		numbers = new int[R];
		
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		comb(0,0);
		System.out.println("총 경우의 수: " + totalCnt) ;
	}
	
	
	private static void comb(int cnt, int start) { //start: 시도할 수의 시작 위치
		if (cnt == R) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			comb(cnt+1, i + 1);
		}
	}

}
