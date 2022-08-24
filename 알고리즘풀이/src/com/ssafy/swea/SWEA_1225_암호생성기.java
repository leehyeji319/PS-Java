package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1225_암호생성기 {

	public static void main(String[] args) throws IOException {
		int T = 10;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		for (int tc = 1; tc < T + 1; tc++) {
			int t = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			int answer[];
			
			
			int[] arr = new int[8];
			for (int i = 0; i < 8; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int idx = 0;
			int cycle = 1;
			
			while (true) {
				idx %= 8;
				cycle %= 5;
				
				if (cycle == 0) {
					cycle = 5;
				}
				arr[idx] -= cycle;
				
				if (arr[idx] <= 0) {
					arr[idx] = 0;
					idx++;
					break;
				}
				idx++;
				cycle++;
			}
			answer = Arrays.copyOfRange(arr, idx, arr.length);
			int[] answer2 = Arrays.copyOfRange(arr, 0, idx);
			
			int destLength = answer.length + answer2.length;
			int[] dest = new int[destLength];
			
			System.arraycopy(answer, 0, dest, 0, answer.length);
			System.arraycopy(answer2, 0, dest, answer.length, answer2.length);
			
			bw.write("#" + tc);
			for (int i = 0; i < 8; i++) {
				bw.write(" " + dest[i]);
		
			}
			bw.write("\n");
			
			
		}
		bw.flush();
		bw.close();
		br.close();
	}

	
	
	

}
