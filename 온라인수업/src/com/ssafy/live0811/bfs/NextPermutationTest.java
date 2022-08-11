package com.ssafy.live0811.bfs;

import java.util.Arrays;
import java.util.Scanner;

public class NextPermutationTest {

	public static void main(String[] args) { //n_p의 단점. nPr은 안됨. nPn임
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] input = new int[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		//전처리 : 순열에 쓰일 수들을 오름차순 정렬 
		Arrays.sort(input);
		
		do {
			//처음에 가장 작은 순열 한번 써야하니까
			System.out.println(Arrays.toString(input)); //순열완성
		} while(np(input));
	}

	
	public static boolean np(int[] numbers) { //numbers 배열의 상태를 근거로 다음 순열 생성, 다음 순열존재하면 true, 아니면 false
		int N = numbers.length;
		//1. 꼭대기를 찾기
		int i = N - 1;
		//지금원소가 처음원소가 아니고 직전원소가 나보다 같거나크다면
		while (i > 0 && numbers[i - 1] >= numbers[i]) --i;  //맨뒤에부터 꼭대기를 찾아야함 //내앞에있는녀석이 나보다 같거나 큰 모습을 보이는것 
		//빠져나왔다면 둘중 뭐때매 빠져나왔는지 모름
		if (i == 0) return false; // 내 앞에 순열이 없는거니까 다음 순열을 만들수없는 이미 가장 큰 순열의 상태!
		
		//2. 꼭대기의 바로 앞자리 (i -1)의 값을 크게 만들 교환 값 뒤쪽에서 찾기 
		int j = N - 1;
		while (numbers[i - 1] >= numbers[j]) --j; //내가 제일 큰수라면계속 뒤져서 찾아야하잖아. 나보다 큰애를 찾을때까지j--
		
		//3. i-1위치값과 j위치값을 교환한다.
		swap(numbers, i - 1, j);
		
		//4. i위치부터 맨뒤까지 수열을 가장 작은 형태의 오름차순으로 변경
		int k = N - 1;
		while (i<k) swap(numbers, i++, k--); //k는 계속 줄여가고, i는 계속 늘려가는거니까, 후치연산으로 처리
		
		return true;
		
	}
	
	public static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
	
	
	
	
}
