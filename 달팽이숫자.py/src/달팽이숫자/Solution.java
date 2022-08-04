package 달팽이숫자;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int len = N;
			int[][] arr = new int[N][N];
			
			int num = 1, start = 0;
			
			while (N > 0) {
				num = makeOuter(arr, start, N, num);
				N -= 2;
				start += 1;
			}
			System.out.println("#" + t);
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < len; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
						
			
		}

	}

	// 배열, 해당 사각형 시작 위치, 사각형 크기, 시작 위치
	public static int makeOuter(int[][] arr, int start, 
			int len, int num) { 
		
		int last = start + len - 1; //사각형 (st, st) ~ (last, last)
		for (int c = start; c < last + 1; c ++) { //첫째행
			arr[start][c] = num;
			num++;
		}
		for (int r = start + 1; r < last + 1; r++) { // 최외각에서 제일 오른쪽 열
			arr[r][last] = num;
			num++;
		}
		for (int c = last - 1; c > start - 1; c--) { // 최외각 마지막 행
			arr[last][c] = num;
			num++;
		}
		for (int r = last - 1; r > start; r--) { // 최외각에서 맨 왼쪽 열
			arr[r][start] = num;
			num++;
		}
		return num;
	}

}
