package ProblemSolving.BOJ;

import java.util.Scanner;

public class 백설공주와일곱난쟁이 {
	static int N = 9; 
	static int R = 7; 
	static int[] numbers, input;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		input = new int[N];
		numbers = new int[R];
		
		for (int i = 0; i < N; i ++) {
			input[i] = sc.nextInt();
		}
		
		comb(0,0);
	}

	private static void comb(int cnt, int start) {
		int sum = 0;
		if (cnt==R) {
			for (int i : numbers) {
				sum += i;
			}
			if (sum == 100) {
				for (int i : numbers) {
					System.out.println(i);
				}
			}
			
			return;
		}
		
		for (int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			comb(cnt+1, i + 1);
		}
		
	}
	

}
