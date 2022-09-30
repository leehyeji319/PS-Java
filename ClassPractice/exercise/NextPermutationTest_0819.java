package com.ssafy.exercise;

import java.util.*;
import java.io.*;
public class NextPermutationTest_0819 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		//전처리: 순열에 쓰일 수들을 오름차순 정리
		Arrays.sort(input);
		
		do {
			//처음에 가장 작은 순열 한번 쓰기
			System.out.println(Arrays.toString(input)); //순열완성
			
		} while(np(input));
	}
	
	
	public static boolean np(int[] numbers) {
		int N = numbers.length;
		
		int i = N - 1;
		
		while(i > 0 && numbers[i - 1] >= numbers[i]) --i;
		if (i == 0) return false;
		
		int j = N - 1;
		while(numbers[i - 1] >= numbers[j]) --j;
		
		swap(numbers, i - 1, j); //i -1 와 j값을 교환한다
		
		int k = N - 1;
		while(i<k) swap(numbers, i++, k--);
		
		return true;
	}
	
	public static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

}
