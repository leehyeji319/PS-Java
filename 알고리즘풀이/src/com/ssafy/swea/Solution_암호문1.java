package com.ssafy.swea;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution_암호문1 {
	public static void main(String[] args) throws Exception, IOException {
		
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		
		for (int tc = 1; tc <= T; tc++) {
			int cnt = 0;
			int oLen =  sc.nextInt();
			
			LinkedList<Integer> list = new LinkedList<>();
			
			for (int i = 0; i < oLen; i++) {
				
				list.add(sc.nextInt());
			}
			
			oLen = sc.nextInt();
			for (int j = 0; j < oLen; j++) {
				String st = sc.next();
				int where = sc.nextInt();
				int many = sc.nextInt();
				for (int k = 0; k < many; k++) {
					list.add(where, sc.nextInt());
					where++;
				}
			}
			
			System.out.println("#" + tc + " ");
			for (int j = 0; j < 10; j++) {
				System.out.print(list.poll() + " ");
			}
			System.out.println();
			
		}
	}
}
