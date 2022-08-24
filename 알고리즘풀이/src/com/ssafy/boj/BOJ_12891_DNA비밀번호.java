package com.ssafy.boj;

import java.util.*;
import java.io.*;

public class BOJ_12891_DNA비밀번호 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		

		String dna = br.readLine();
		
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int[] limit = new int[4];
		for (int i = 0; i < 4; i++) {
			limit[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] current = new int[4];
		
		for (int i = 0; i < P; i++) {
			char init = dna.charAt(i);
			if (init == 'A') current[0]++;
			else if (init == 'C') current[1]++;
			else if (init == 'G') current[2]++;
			else if (init == 'T') current[3]++;
		}
		int cnt = 0;
		int size = dna.length();
		//처음저장한거 비교후 시작 
		if(isAble(limit, current)) cnt++;
		
		//슬라이딩윈도우로 풀어볼게욥 ㅎ
		int start = 0;
		int end = start + P;
		while (end < size) { //이것도변수로 빼는게 좋아 size로 ,, 매번 조회를 하니까

			char out = dna.charAt(start);
			char in = dna.charAt(end);
			//나가는거 카운
			if (out == 'A') current[0]--;
			else if (out =='C') current[1]--;
			else if (out == 'G') current[2]--;
			else if (out == 'T') current[3]--;
			//들어오는거 카운트
			if (in == 'A') current[0]++;
			else if (in =='C') current[1]++;
			else if (in == 'G') current[2]++;
			else if (in == 'T') current[3]++;
			
			if (isAble(limit, current)) cnt++;
			start++;
			end++;

		}
		
		System.out.println(cnt);
		
		
	}

	public static boolean isAble(int[] limit, int[] current) {
		for (int i = 0; i < 4; i++) {
			if (limit[i] > current[i]) return false;
		}
		return true;
	}

}


//if elseif 보다 switch로 처리하는게 더 빠르다.
//switch는 비교하면서 내려가는게 아니라 더 좋아요 
//그리고 비교가 많으니까 그냥 쌤처럼 메소드로 따로 빼는게 좋다.
