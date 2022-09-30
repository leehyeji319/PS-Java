package ProblemSolving.BOJ;

import java.io.IOException;
import java.util.Scanner;

public class 구간합구하기4 {

	public static void main(String[] args) throws Exception, IOException {
		
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int M = in.nextInt();
		
		//n개의 숫자를 입력받아 배열에 넣기
		int[] arr = new int[N + 1];
		arr[0] = 0;
		
		//배열의 원소를 합해서 애초에 넣기
		for (int i = 1; i <= N; i++) {
			arr[i] = arr[i - 1] + in.nextInt();
		}
		
		//M번 입력받고, 입력 받은 숫자의 범위만큼 배열에서 빼서 구함
		//1~y까지 합 - 1~(x-1)까지 합 = x~y까지 합
		for (int i = 0; i < M; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			
			System.out.println(arr[y] - arr[x - 1]);
		}
		
	}
}
