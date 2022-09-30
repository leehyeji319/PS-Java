package com.ssafy.exercise;
import java.io.*;
import java.util.*;
public class SubsetTest {

	static int N, totalCnt;
	static int[] input;
	static boolean[] isSelected;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		totalCnt = 0; 
		input = new int[N];
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		subset(0);
		System.out.println("총 경우의 수 : " + totalCnt);
	}
	
	private static void subset(int index) { //index: 부분집합에 고려할 대상 cnt: 직전까지 고려한 원소 수
		//기저조건
		if (index == N) {
			totalCnt++;
			for (int i = 0; i < N; i++) {
				System.out.print(isSelected[i]?input[i]:"X");
				System.out.print("\t");
				
			}
			System.out.println();
			return;
		}
		
		
		isSelected[index] = true;
		subset(index+1);
		isSelected[index] = false;
		subset(index+1);
	}

}
