package ClassPractice.exam1017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Algo2_1_서울_9반_이혜지 {
	static int V, P, totalCnt;
	static int[] numbers, input;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T + 1; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken()); //마을 개수
			P = Integer.parseInt(st.nextToken()); //경찰서 개수

			totalCnt = 0;
			input = new int[V];
			numbers = new int[P];
			//출력 가능한 V개 마을 중 P개 선택하여 경찰서를 짓는 조합 경우의 수
			// nCr vCp
			for (int i = 0; i < V; i++) {
				input[i] = i;
			}

			comb(0, 0);
			System.out.println("#" + tc + " " + totalCnt);
		}
	}

	private static void comb(int cnt, int start ) { //cnt:직전까지 뽑은 순열에 포함된수의개수, start: 시도할 수의 시작 위치
		if (cnt == P) {
			totalCnt++; //조합ㄱ ㅐ수 ++
			return;
		}

		for (int i = start; i < V; i++) {
			numbers[cnt] = input[i];
			comb(cnt + 1, i + 1); //다음수 뽑으러가기
		}
	}

}
