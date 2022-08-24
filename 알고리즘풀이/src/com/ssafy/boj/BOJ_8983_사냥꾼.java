package com.ssafy.boj;

import java.util.*;
import java.io.*;
public class BOJ_8983_사냥꾼 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); //사대수 
		int N = Integer.parseInt(st.nextToken()); //동물수
		int L = Integer.parseInt(st.nextToken()); //사정거리
		
		int[] shootingPosition = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			shootingPosition[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] animals = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				animals[i][0] = Integer.parseInt(st.nextToken());
				animals[i][1] = Integer.parseInt(st.nextToken());
			}
		}
		
		

	}

}

//target을 무엇으로..? ->
//start, end를 무엇으로..?