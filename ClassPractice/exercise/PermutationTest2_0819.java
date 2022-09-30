package com.ssafy.exercise;

import java.util.*;
import java.io.*;

public class PermutationTest2_0819 {
	static int N, R, totalCnt;
	static int[] numbers, input;
	static boolean[] isSelected;
	
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		R = Integer.parseInt(br.readLine());
		totalCnt = 0;
		
		input = new int[N];
		numbers = new int[R];
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		perm(0);
		System.out.println("총 경우의 수: " + totalCnt);
		
	}
	
	private static void perm(int cnt) {// cnt: 직전까지 뽑은 순열에 포함된 수의 개수
		if (cnt == R) { //여기에 내가 처리하고싶은거 담으면 된다
			totalCnt++; 
			System.out.println(Arrays.toString(numbers));
			return;
			
		}
		
		for (int i = 0; i < N; i ++) {
			if (isSelected[i]) continue;
			numbers[cnt] = input[i];
			isSelected[i] = true;
			
			perm(cnt + 1); //다음 수 뽑으러 가기
			isSelected[i] = false;
 		}
	} 

}
