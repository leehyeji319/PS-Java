package ProblemSolving.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1247_최적경로v1 {
	static int T, N, res;
	static Point Office, Home, houses[];
	static boolean[] visited;
	static int sel[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			houses = new Point[N];
			visited = new boolean[N];
			sel = new int[N];

			Office = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			//고객좌표
			for (int i = 0; i < N; i++) {
				houses[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			res = Integer.MAX_VALUE;
			process(0, 0);

			System.out.println("#" + tc + " " + res);
		}
	}

	private static void process(int cnt, int idx) {
		if (cnt == N) {
			int sum = 0;

			//집에서 첫번째 고객 집까지의 거리
			sum += Math.abs(Office.x - houses[sel[0]].x) + Math.abs(Office.y - houses[sel[0]].y);
			//이후 고객들이 집 방문
			for (int i = 1; i < N; i++) {
				sum += Math.abs(houses[sel[i]].x - houses[sel[i - 1]].x) +
					Math.abs(houses[sel[i]].y - houses[sel[i - 1]].y);
			}
			//마지막 들린 고객 집에서 내 집까지의 거리
			sum += Math.abs(Home.x - houses[sel[N - 1]].x) + Math.abs(Home.y - houses[sel[N -1]].y);

			res = Math.min(res, sum);
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				sel[idx] = i;
				process(cnt + 1, idx + 1);
				visited[i] = false;
			}
		}
	}

	public static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
