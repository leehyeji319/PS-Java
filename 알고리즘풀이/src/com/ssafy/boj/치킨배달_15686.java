package com.ssafy.boj;

import java.util.*;
import java.io.*;
public class 치킨배달_15686 {
	static ArrayList<int[]> house = new ArrayList<>();
	static ArrayList<int[]> chicken = new ArrayList<>();
	static ArrayList<int[]> chickenDistance = new ArrayList<>();
	static int[][] answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		
		//배열 받아오고 집이랑 치킨 좌표도 넣어주기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					house.add(new int[] {i, j});
				}
				if (map[i][j] == 2) {
					chicken.add(new int[] {i, j});
				}
			}
		}
		//미리 조합을 해놓고 돌려도 될듯 ??
		int chickenSize = chicken.size();
		int houseSize = house.size();
		answer = new int[chickenSize][houseSize];
		//치킨집마다 집집거리넣어주기
		for (int c = 0; c < chickenSize; c++) {
			for (int h = 0; h < houseSize; h++) {
				int[] tc = chicken.get(c);
				int[] th = house.get(h);
				int abs = Math.abs(tc[0] - th[0]) + Math.abs(tc[1] - th[1]);
				answer[c][h] = abs;
			}
		}
		//이제 치킨이 집집마다 answer = [[1,2,3,4], [2, 1, 3, 4], [6, 7, 1, 9]] answer[0]
	}

}
