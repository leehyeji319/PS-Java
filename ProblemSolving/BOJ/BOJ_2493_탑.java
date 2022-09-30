package com.ssafy.boj;

import java.util.*;
import java.io.*;

public class BOJ_2493_탑 {

	public static void main(String[] args) throws Exception, IOException {
		//시간초과 잘생각해서
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int topCnt = Integer.parseInt(br.readLine());
		int[] answer = new int[topCnt];
		st = new StringTokenizer(br.readLine());
		Deque<int[]> stack = new ArrayDeque<>();
		stack.push(new int[] {Integer.MAX_VALUE, 0});
		for (int i = 1; i <= topCnt; i++) {
			int height = Integer.parseInt(st.nextToken());
			while (height > stack.peekFirst()[0]) {
				 stack.pop();
			}
			
			answer[i - 1] = stack.peekFirst()[1];
			stack.push(new int[] {height, i});
			
		}
		
		for (int i = 0; i < topCnt; i++) {
			System.out.print(answer[i] + " ");
		}
		
	}

}
//진석님꺼보고배움요