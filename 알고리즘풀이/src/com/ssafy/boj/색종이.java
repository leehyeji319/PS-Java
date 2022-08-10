package com.ssafy.boj;

import java.util.*;

public class 색종이 {

	public static void main(String[] args) {
		
		int answer = 0;
		boolean[][] paper = new boolean[100][100];
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					if (!paper[j][k]) {
						paper[j][k] = true;
						answer++;
					}
					
				}
			}
			
		}
		
		System.out.println(answer);
	}

}
