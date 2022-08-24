package com.ssafy.swea;

import java.util.*;
import java.io.*;
/*
 * 이문제는 방문처리가 필요없다. 왜? 똑같은 번호가 아니라 방마다 번호가 다 다르기때문에 방문처리를 딱히 안해줘도 되지.
 * - graph문제는 노드라 안하고 정점이라고 함. 이런문제의 인접정점은 갈수있는 방향이 인접정점이다.
 * - 이런 그래프 문제를 풀 땐, 간선과 정점을 보고 확인해야함.
 * - 얘는 간선이 네개이다. 왜? 상하좌우로 이동이 가능하니까.
 * - 만약 지그재그로 들어온다면 최대 일억이 될수도잇어 최악엔, 그래서 memo를하는거임!! 재귀로..
 * - 나는 갈수있는애를 그냥 태워보낸거고, 걔는 또 걔대로 출발하는거고. 이 결과를 메모를 해서 나한테 온 경우엔 +1만해주면 되는거임 .. 
 * - 너비가 넓을때는 bfs하지말고, dfs가 좋은데, 큐를 쓸거면 우리가 11일 bfs2 size를 매 체크해서 너비를 돌려주는것처럼. 그걸 해줘
 * */
public class SWEA_1861_정사각형방 {
	private static int N;
	private static int[][] map;
	private static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	private static int[] dc = { 0, 0, -1, 1 }; // 상하좌우
	private static int answer;
	private static int max;
	private static int start;

	public static void main(String[] args) throws Exception, IOException {
		System.nanoTime();
		System.setIn(new FileInputStream("res/square_teacher.txt"));
//		System.setIn(new FileInputStream("res/square.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			max = 0;
			start = 0;
			map = new int[N][N];
			// map에 넣기
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//코드가 돌때 시작시간 찍고
			long s = System.nanoTime();
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					answer = 0;
					bfs(r, c);
					if (max < answer) {
						max = answer;
						start = map[r][c];
					} 
					if (max == answer) {
						start = Math.min(map[r][c], start);
					}
				}
			}
			//(코드완료시간 - 코드시작시간) / 나노니까 10^9 로 나눠주기
			 System.out.println((System.nanoTime() - s) / Math.pow(10, 9));
			System.out.println("#"+tc+" "+start+" "+(max + 1));
		}
	}

	private static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { r, c });
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			r = cur[0];
			c = cur[1];

			// 4방탐색
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (nr<0 || nc<0 || nr>=N || nc>=N || (map[nr][nc] != map[r][c]+1)) {
					continue;
				}
				answer++;
				queue.offer(new int[] {nr, nc});
				break;
			}
		}
	}

}
