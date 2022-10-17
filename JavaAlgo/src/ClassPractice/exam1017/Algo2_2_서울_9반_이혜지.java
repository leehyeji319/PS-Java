package ClassPractice.exam1017;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 이때 경찰서를 지을 마을을 고를 수 있는 경우의 수(문제 2_1)와 각 마을과 그
 * 마을에서 가장 가까운 경찰서 까지의 거리들의 합이 최소가 되는 경우 거리의 합이
 * 몇인지(문제 2_2)
 */

public class Algo2_2_서울_9반_이혜지 {
	static int V, P, L;
	static long[] towns, police, result;
	static long min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken()); //각마을 위치 좌표
			P = Integer.parseInt(st.nextToken()); //경찰서
			L = Integer.parseInt(st.nextToken()); //큰길 둘레

			towns = new long[V];
			police = new long[P];
			result = new long[P];
			min = Long.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < V; i++) {
				towns[i] = Long.parseLong(st.nextToken());
			}

			comb(0, 0);

			System.out.println("#" + tc + " " + min);
		}


	}

	private static void comb(int cnt, int start) {
		if (cnt == P) { //경찰서 다 뽑앗으면
			getDistance(); //거리 계산하러 들어가
			return;
		}

		for (int i = start; i < V; i++) {
			result[cnt] = towns[i];
			comb(cnt + 1, i + 1);  //다음수 뽑으러가기
		}
	}

	private static void getDistance() {

		// System.out.println(Arrays.toString(result));

		long sumDistance = 0; //마을에서 가장 가까운 경찰서 까지의 거리들의 합
		for (int v = 0; v < V; v++) {
			long minDistance = Long.MAX_VALUE;
			for (int p = 0; p < P; p++) {
				//더 작은 차이 구하기
				long diff = Math.min(Math.abs(towns[v] - result[p]), Math.min(towns[v], result[p]) + L - Math.max(towns[v], result[p]));
				if (minDistance > diff) {
					minDistance = diff;
				}
			}
			sumDistance += minDistance;
		}

		if (sumDistance < min) { //최소값이 변경됐으면 갱신
			min = sumDistance;
		}
	}
}
