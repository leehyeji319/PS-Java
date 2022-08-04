package com.ssafy.live0804.exercise;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 주사위를 3번 던져서 나올 수 있는 모든 경우의 수 
 * */

public class Dice1 { 
	static int N, totalCnt;
	static int[] numbers;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 던지는주사위 
		int mode = sc.nextInt(); 
		
		totalCnt = 0;
		numbers = new int[6];
		
		switch (mode) {
		case 1: //중복순열 
			dice1(0);
			break;
			
		case 2: //순열 
			isSelected = new boolean[7]; //1~6까지 주사위 눈
			dice2(0);
			break;
			
		case 3: //중복조합 
			dice3(0, 1);
			break;
			
		case 4: //조합 
			dice4(0, 1);
			break;
			
		default:
			System.out.println("잘못된 입력입니다.");
			return;
		}
		
		System.out.println("총 경우의 수 : " + totalCnt);
	}
	
	//주사위 던지기1: 중복순열 
	private static void dice1(int cnt) {
		
		//가능한 모든 수 시도 (주사위 눈 1~6)
		for (int i = 1; i <= 6; i++) {
			//수의 중복 선택이 가능하으몰 중복체크 필요없음
			//해당 수 선택
			numbers[cnt] = i;
			//다음 주사위던지러가기
			dice1(cnt+1);
		}
	}
	
	//주사위 던지기2: 순열 
	private static void dice2(int cnt) {
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		//가능한 모든 수 시도 (주사위 눈 1~6)
		for (int i = 1; i <= 6; i++) {
			//중복 체크 필요!!! 
			if (isSelected[i]) continue;
			//해당 수 선택
			numbers[cnt] = i;
			isSelected[i] = true;
			//다음 주사위던지러가기
			dice2(cnt+1);
			//다 하고 돌아왔으니까 되돌리자
			isSelected[i] = false;
		}
	}
	
	//주사위 던지기3: 중복조합
	private static void dice3(int cnt, int start) {
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice3(cnt+1, i);
		}
	}
	
	//주사위 던지기4 : 조합
	private static void dice4(int cnt, int start) { 
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice4(cnt+1, i+1);
		}
	}
}
