package ClassPractice.exam1017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Algo1_서울_9반_이혜지 {
	static int N, S, M; //신청한 동아리 수, s는 팀원 능력치합 조건, M은 개인 능력치 조건

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int count = 0; //가능한 동아리 수

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int p1 = Integer.parseInt(st.nextToken()); //팀원1
			int p2 = Integer.parseInt(st.nextToken()); //2
			int p3 = Integer.parseInt(st.nextToken()); //3
			int total = p1 + p2 + p3; //팀원 능력치 합
			if (M <= p1 && M <= p2 && M <= p3 && S <= total) { //스마트클럽가입조건
				count++;
				sb.append(p1 + " " + p2 + " " + p3 + " ");
			}
		}
		System.out.println(count);
		System.out.println(sb);
	}
}
