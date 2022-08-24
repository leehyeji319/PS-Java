package com.ssafy.boj;
import java.util.*;

public class BOJ_11286_절대값힙 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Numbers> h = new PriorityQueue<>();
		int N = sc.nextInt();
		
		
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			//0이 아닐때
			if (num != 0) {
				Numbers numbers = new Numbers(Math.abs(num), num);
				h.add(numbers);
			}
			if (num == 0) {
				if (h.isEmpty()) {
					System.out.println(0);
				} else {
					int n = h.poll().originalNum;
					System.out.println(n);
				}
			}
		}

	}
	
	static class Numbers implements Comparable<Numbers>{
		private int absNum;
		private int originalNum;
		
		public Numbers(int absNum, int originalNum) {
			this.absNum = absNum;
			this.originalNum = originalNum;
		}

		public int getAbsNum() {
			return absNum;
		}

		public int getOriginalNum() {
			return originalNum;
		}

		@Override
		public int compareTo(Numbers o) {
			if (this.absNum != o.absNum) return this.absNum - o.absNum; //절댓값 작은거 기준 
			return this.originalNum - o.originalNum; //똑같으면 원래 수에서 작은거기준
		}
				
	}
}

