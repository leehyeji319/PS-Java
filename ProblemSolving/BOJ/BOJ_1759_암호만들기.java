package com.ssafy.boj;
import java.io.*;
import java.util.*;
public class BOJ_1759_암호만들기 {
	public static int L, C;
	public static String[] candidate, complete;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken()); //암호길이
		C = Integer.parseInt(st.nextToken()); //후보 문자들
		candidate = new String[C];
		complete = new String[L];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++) {
			candidate[i] = st.nextToken();
		}


		Arrays.sort(candidate);
		// System.out.println(candidateChar);
		// for (String c : candidate) {
		// 	System.out.println("출력 : " + c);
		// }

		//최소 한개의 모음, 두개의 자음을 포함해야함

		comb(0, 0, 0, 0);
	}

	public static void comb(int cnt, int start, int vowelCnt, int consonantCnt) {
		if (cnt == L) {
			if (vowelCnt < 1 || consonantCnt < 2) {
				return;
			}
			for (int i = 0; i < L; i++) {
				System.out.print(complete[i]);
			}
			System.out.println();
			return;
		}

		for (int i = start; i < C; i++) {
			complete[cnt] = candidate[i];
			if (isVowel(complete[cnt])) {
				comb(cnt + 1, i + 1, vowelCnt + 1, consonantCnt);
			} else {
				comb(cnt + 1, i + 1, vowelCnt, consonantCnt + 1);
			}
		}
	}

	public static boolean isVowel(String s) {
		return s.equals("a") ||  s.equals("e") ||  s.equals("i") ||  s.equals("o") ||  s.equals("u");
	}
}
