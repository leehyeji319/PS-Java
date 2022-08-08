package com.ssafay.swea;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution_한빈이의SpotMart {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] arr = new int[N];
			
			for (int i = 0; i < N; i++) arr[i] = sc.nextInt();
			
			Arrays.sort(arr);
			
			int start = 0;
			int end = arr.length - 1;
			int cur = 0;
			int answer = 0;
			//이분탐색
			while(start!=end) {
				int sum = arr[start] + arr[end];
				if (sum > M) {
					end--;
				} else {
					cur = arr[start] + arr[end];
					answer = answer > cur ? answer : cur;
					start++;
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		
		}
		
	}

}
