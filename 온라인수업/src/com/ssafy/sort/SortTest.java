package com.ssafy.sort;

import java.util.Arrays;

public class SortTest {

	public static void main(String[] args) {
		
		int[] arr = {4, 3, 7, 9, 5};
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		
		//Comparable CompareTo는 못바꾸고 못씀
		String[] locs = {"서울", "대전", "구미", "광주", "부울경"};
		System.out.println(Arrays.toString(locs));
		Arrays.sort(locs);
		System.out.println(Arrays.toString(locs));
		
		//원소가 가지고 잇는 Comparable안쓰고 Comparator 쓰게 된다,,? 
	}

}
