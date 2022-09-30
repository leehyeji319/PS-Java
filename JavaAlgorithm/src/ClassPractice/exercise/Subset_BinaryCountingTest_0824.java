package ClassPractice.exercise;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Subset_BinaryCountingTest_0824 {

	static int[] numbers;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		numbers = new int[N];

		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}

		generateSubset();
	}

	private static void generateSubset() {
		for (int flag = 0, caseCnt = 1<<N; flag < caseCnt; flag++) {
			for (int i = 0; i < N; ++i) {
				if ((flag & (1<<i)) != 0) {
					System.out.println(numbers[i] + " ");
				}
			}
			System.out.println();
		}
	}

}
