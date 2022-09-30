package ProblemSolving.PRGRMS;

import java.util.PriorityQueue;

public class Solution_더맵게 {
	static PriorityQueue<Integer> pq = new PriorityQueue<>();

	public static void main(String[] args) {
		int[] scoville = { 1, 2, 3, 9, 10, 12 };
		int K = 7;
		System.out.println(solution(scoville, K));

	}

	public static int solution(int[] scoville, int K) {
		int answer = 0;

		for (int s : scoville) {
			pq.add(s);
		}

		while (pq.peek() < K) {
			int first = pq.poll();
			if (pq.size() == 0) {
				return -1;
			}
			int second = pq.poll();

			int newScoville = first + second * 2;
			pq.add(newScoville);
			answer++;
		}

		return answer;

	}

}
