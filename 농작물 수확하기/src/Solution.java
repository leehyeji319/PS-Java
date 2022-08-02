import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		
		for (int i = 0; i < cnt; i++) {
			int size = sc.nextInt();
			sc.nextLine();
			int sum = 0;
			
			for (int j = size/2; j >= 0; j--) {
				String s = sc.next();
				for (int k = j; k < size - j; k++) {
					sum += s.charAt(k) - '0';
				}
			}
			
			for (int j = 1; j <= size / 2; j++) {
				String s = sc.next();
				for (int k = j; k < size - j; k++) {
					sum += s.charAt(k) - '0';
				}
			}
			
			System.out.println("#" + (i + 1) + " " + sum);
		}
	}

}
