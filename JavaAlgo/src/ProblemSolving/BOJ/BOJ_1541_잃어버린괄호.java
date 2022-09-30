package ProblemSolving.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1541_잃어버린괄호 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		String[] stringNumbers = str.split("[+-]");

		ArrayList<String> op = new ArrayList<>();
		int result = 0;

		int[] numbers = new int[stringNumbers.length];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(stringNumbers[i]);

		}

		int minusCnt = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '-') {
				op.add("-");
				minusCnt++;
			} else if (str.charAt(i) == '+') {
				op.add("+");
			}
		}

		int sum = 0;
		if (minusCnt == 0) {
			for (int i = 0; i < numbers.length; i++) {
				sum += numbers[i];
			}
			System.out.println(sum);
		} else if (minusCnt > 0) {
			int idx = op.indexOf("-");

			for (int i = 0; i < idx + 1; i++) {
				result += numbers[i];
			}

			for (int j = idx + 1; j < numbers.length; j++) {
				result -= numbers[j];
			}
			System.out.println(result);
		}

	}

}
