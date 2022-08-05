package com.ssafy.sort;

import java.util.Arrays;

public class TwoDimenArrayTest {

	public static void main(String[] args) {
		
		int[][] arr = {{1, 10}, {2,5}, {3, 20}, {4, 10}};
		//얘는 프리미티브가아니라 래퍼런스 타입이자나..
		
		System.out.println(Arrays.deepToString(arr));
		//Arrays.sort(arr); //이러면 오류남. 객체타입의 배열인데 Comparable하지 않다.
		//선언에 implements Comparable이 없잖아..
		//원소가 스스로 비교하게 하는건 불가능하고, Comparator방법밖에없어요
		//-> 변경 
		Arrays.sort(arr, (a,b) -> b[0] - a[0]);
		System.out.println(Arrays.deepToString(arr));
		//두번째원소를 기준으로 오름차순하고싶다면?
		Arrays.sort(arr, (a,b) -> a[1] - b[1]);
		System.out.println(Arrays.deepToString(arr));
		
		//배열의 두번째 원소기준으로 오름차순, 같다면 첫번째 원소 기준으로 오름차순
		//같다면 한번 더 들여댜봐야함. 삼항연산자로 처리
		Arrays.sort(arr, (a,b) -> a[1]!=b[1]?a[1]-b[1]:a[0]-b[0]);
		System.out.println(Arrays.deepToString(arr));
	}

}


//단순히 정렬할때만 comparable comparator를 사용하는게 아니다.
//힙. 우선순위 큐 할때도 잘쓰임. 무언가 순서있게 관리해야하는 기능을 가진거에서 잘씀