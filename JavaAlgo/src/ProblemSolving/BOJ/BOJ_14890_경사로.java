package ProblemSolving.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14890_경사로 {
	private static int N, L;
	private static int[][] map, map2;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); //배열크기
		L = Integer.parseInt(st.nextToken()); //경사로 밑변길이

		map = new int[N][N];
		map2 = new int[N][N]; //90도 회전 행열을 따로

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				map2[j][i] = map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(process());

	}

	private static int process() {
		int count = 0;
		for (int i = 0; i < N; i++) {
			//한줄씩 떼어서 볼겁니다
			if (makeRoad(map[i])) //수평 활주로 건설 체크
				count++;
			if (makeRoad(map2[i])) //수직 활주로 건설 체크
				count++;
		}
		return count;
	}

	//해당 지형 정보로 활주로 건설이 가능하면 true, 불가능하면 false 리턴
	private static boolean makeRoad(int[] road) {
		int beforeHeight = road[0], size = 0;
		int j = 0;

		while (j < N) {

			if (beforeHeight == road[j]) { //동일 높이
				size++; //오르막용
				j++;
			} else if (beforeHeight + 1 == road[j]) { //이전높이보다 1높음: 오르만 경사로 설치 체크
				if (size < L)
					return false; // L길이 미만이면 활주로 건설 불가

				beforeHeight++;
				size = 1;
				j++;
			} else if (beforeHeight - 1 == road[j]) { //이전높이보다 1 작음
				int count = 0;
				for (int k = j; k < N; k++) { //현재위치부터 끝까지 들여다보기
					if (road[k] != beforeHeight - 1) {
						return false;
					}
					if (++count == L) {
						break; //연속길이를 만족해서 내려오거나 ..
					}
				}

				if (count < L) {
					return false;
				}
				beforeHeight--;
				j += L; //다음 탐색위치로 만들어주기
				size = 0;

			} else { //높이 차이가 2 이상일 때
				return false;
			}
		}
		return true;
	}
}





