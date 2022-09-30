package ProblemSolving.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074_Z {

	private static int N, R, C, visitedNum;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		div(R, C, (int) Math.pow(2, N));
	}

	public static void div(int row, int col, int size) {
		// 네갈죽
		if (size == 1) {
			System.out.println(visitedNum);
		}
		int newSize = size / 2;

		if (row < newSize && col < newSize) { //1
			visitedNum += newSize * newSize * 0;
			div(row, col, newSize);
			
		} else if (row < newSize && col < newSize + newSize) {//2
			visitedNum += newSize * newSize * 1;
			div(row,  col - newSize, newSize);
			
		} else if (row < newSize + newSize && col < newSize) {//3
			visitedNum += newSize * newSize * 2;
			div(row - newSize, col, newSize);
			
		} else if (row < newSize + newSize && col < newSize + newSize) {//4
			visitedNum += newSize * newSize * 3;
			div(row - newSize, col - newSize, newSize);
			
		}
		
	}

}
