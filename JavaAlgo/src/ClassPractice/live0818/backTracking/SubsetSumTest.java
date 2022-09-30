package ClassPractice.live0818.backTracking;

import java.util.Scanner;

//n개의 자연수를 입력받고 목표합이 주어지면 목표합에 해당하는 부분집합을 출력
public class SubsetSumTest {

	static int N, totalCnt, S;
	static int[] input;
	static boolean[] isSelected; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt(); //목표합값
		totalCnt = 0;
		input = new int[N];
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		subset(0, 0);
		System.out.println("총 경우의수 : " + totalCnt);

	}
	
	private static void subset(int index, int sum) { //index : 부분집합에 고려할 대상 cnt: 직전까지 고려한 원소 수
		//기저조건
		if (sum == S) { 
			totalCnt++;
			//부분집합의 구성 상태를 찍어보기
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					
					System.out.print(input[i] + "\t");
				}
			}
			System.out.println();
			return;
		}
		
		// sum > S
		if (sum > S || index == N) return; //sum이 목표값보다 크거나, 모든걸 다 골랏으면 리턴
		
		//sum < S
		//원소 선택
		isSelected[index] = true;
		subset(index+1, sum + input[index]); //현재위치의 다음위치 원소 
		//원소 미선택
		isSelected[index] = false;
		subset(index+1, sum); //선택안했으니까 그냥 sum값을 그대로 보내
	}
}
