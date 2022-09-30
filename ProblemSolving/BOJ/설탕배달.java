package com.ssafy.boj;

import java.util.Scanner;

public class 설탕배달 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int result = 0;
		
		while (N >= 0) {
			if (N % 5 == 0) {
				result += N / 5;
				System.out.println(result);
				break;
			}
			N -= 3;
			result++;
		}
		if (N < 0) System.out.println(-1);

	}

}
