package com.ssafy.boj;

import java.util.*;
import java.io.*;
public class BOJ_15686_치킨배달 {

	static ArrayList<House> house = new ArrayList<>();
	static ArrayList<Chicken> chicken = new ArrayList<>();
	
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
					house.add(new House(i, j));
				}
				if (map[i][j] == 2) {
					chicken.add(new Chicken(i, j));
				}
			}
		}
		System.out.println(getMinDistance(map, M));
		
	}
	
	public static int getMinDistance(int[][] map, int M) {
		int size = chicken.size();
		int[] p = new int[size];
		int cnt = 0;
		while(++cnt<=M) p[size -cnt] = 1;
		
		int min = Integer.MAX_VALUE;
		do {
			int sum = getChickenStreet(map, p);
			if (min > sum) min = sum;
		} while (np(p));
		return min;
	}

	public static int getChickenStreet(int[][] map, int[] p) {
		int sum = 0, temp = 0;
		
		for (int h = 0; h < house.size(); h++) {
			int min = Integer.MAX_VALUE;
			for (int c = 0; c < chicken.size(); c++) {
				if (p[c] == 0) continue;
				temp = Math.abs(house.get(h).hrow - chicken.get(c).crow) + Math.abs(house.get(h).hcol - chicken.get(c).ccol);
				min = Math.min(min, temp);
			}
			sum += min;
		}
		return sum;
	}
	
	
	public static boolean np(int[] p) {
		
		int N = p.length;
		int i=N-1;
		while(i>0 && p[i-1]>=p[i]) --i;
		if(i==0) return false;
		
		int j=N-1;
		while(p[i-1]>=p[j]) --j;
		
		swap(p, i-1, j);
		
		int k=N-1;
		while(i<k) swap(p,i++,k--);
		
		return true;
	}
	public static void swap(int[] numbers,int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	
	static class Chicken{
		int crow, ccol;
		public Chicken(int crow, int ccol) {
			this.crow = crow;
			this.ccol = ccol;
		}
	}
	
	static class House{
		int hrow, hcol;
		public House(int hrow, int hcol) {
			this.hrow = hrow;
			this.hcol = hcol;
		}
	}
}
