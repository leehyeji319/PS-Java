package com.ssafy.live0801.recursive;

import java.util.Scanner;

public class R1_FatorialTest {
	
	//loop
	static int factorial1(int n) {
		// 5 * 4 * 3 * 2 *! 
		int res = 1;
		
		for (int i = n; i >= 1; i--) {
			res *= i;
		}
		
		return res; 
	}
	
	
	static int res = 1; //얘는 멤버변수로 
	static void factorial2(int i) { //i값을 기존 누적값에 곱하는 방식으로 계승을 구한다.
		//기저조건 
		if (i < 1) return;
		
		res *= i;
		factorial2(i-1);
	}
	
	//리턴값을 활용하는 구조 
	static int factorial3(int n) { //n! 계산후에 리턴
		if (n <= 1) return 1;
		return n * factorial3(n-1); //나로할 수 잇는 일, 나빼고 할 수 있는 일
		//return 자신 * 나머지팩토리얼
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		System.out.println(factorial1(N));
		factorial2(N);
		System.out.println(res);
		System.out.println(factorial3(N)); // 리턴값을 활용하는 예
	}

}
