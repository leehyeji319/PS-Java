package com.ssafy.offline0812.nextpcomb;

import java.util.Scanner;

public class CombinationNPTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int R = sc.nextInt();
		int[] input = new int[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		int[] p = new int[N];
		//뒤쪽부터 r개만큼 1로 채우기 
		int cnt = 0;
		while(++cnt<=R) p[N-cnt] = 1;
		
		do {
			//완성된 조합을 처리하는 코드
			for (int i = 0; i < p.length; i++) {
				if (p[i] == 1) System.out.print(input[i] + " ");
			}
			System.out.println();
		} while(np(p)); //input배열이 아니라 0과1로 되어있는 p배열을 넘겨야한다.

	}
	
	public static boolean np(int[] numbers) {
		
		int N = numbers.length;
		
		//1단계
		int i = N - 1; //꼭대기 찾기
		while(i > 0 && numbers[i-1]>=numbers[i]) --i; //앞인덱스가 잇어야하고, 떨어지는 지점을 찾아서. 있으면 맨 뒤에서 앞으로 오자
		if (i==0) return false; //꼭대기이후로 절벽이면 이제 끝이야~ 더 만들수 없어
		//2단계
		int j = N - 1; //바꿀애
		while(numbers[i-1] >= numbers[j]) --j; //얘도 찾아서 계속 앞으로 오는거야 ~
		
		//3단계
		swap(numbers, i - 1, j);
		
		//4단계
		int k = N-1;
		while(i<k) swap(numbers, i++, k--); //size가 2이상인애여야하니까
		
		return true; //다하고나면 순열이 완성됐어요~ 하는겨
	}
	
	//3단계 swap하는건 따로 밖에 빼는게 편하더라고~
	public static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

}
