package ClassPractice.exercise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PermutationTest_0824 {
	static int N, R, totalCnt;
	static int[] input, numbers;
	static boolean[] isSelected;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		R = Integer.parseInt(br.readLine());
		totalCnt = 0;

		input = new int[N];
		numbers = new int[R];
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}

		perm(0);
		System.out.println("총 경우의 수: " + totalCnt);
	}

	private static void perm(int cnt) {
		if (cnt == R) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}

		for (int i = 0; i < N; i++) {
			if (isSelected[i]) continue;
			numbers[cnt] = input[i];
			isSelected[i] = true;

			perm(cnt + 1);
			isSelected[i] = false;
		}
	}
}
