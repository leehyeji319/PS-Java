package ProblemSolving.SWEA;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1208_Flatten {
	
//	static int[] arr = new int[100];
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T= 10;
		
		for(int tc = 1; tc <= T + 1; tc++)
		{
			int dump = sc.nextInt();
			int[] arr = new int[100];
			
			for(int i = 0; i < 100; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			for (int i = 0; i < dump; i++) {
				
				arr[0] += 1;
				arr[99] -= 1;
				Arrays.sort(arr);
				if (arr[99] - arr[0] <= 1) break;
			}
			int answer = arr[99] - arr[0];
			System.out.println("#" + tc + " " + answer);
			continue;
		}
	}
}
