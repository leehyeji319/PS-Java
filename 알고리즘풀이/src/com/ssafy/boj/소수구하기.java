package com.ssafy.boj;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class 소수구하기 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int M = in.nextInt();
		int N = in.nextInt();
		
		//N만큼 boolean배열을 true로 초기화
		boolean[] prime = new boolean[N + 1];
		Arrays.fill(prime, true);
		
		//0,1은 소수가 아님이까 제외
		prime[0] = prime[1] = false;
		
		for (int i=2; i * i < N + 1; i++) {
			//prime[i]이 소수라면
			if (prime[i]) {
				//prime[j] 소수가 아닌 표시
				for (int j = i*i; j < N + 1; j += i) prime[j] = false;
			}
		}
		
		for (int i = M; i <= N; i++) {
			if (prime[i]) System.out.println(i);
		}
	}

}
