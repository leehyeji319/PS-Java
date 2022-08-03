package com.study.programmers;

import java.util.Stack;

public class Solution_큰수만들기 {
	Stack<Integer> stack = new Stack<>();
	
	public static void main(String[] args) {
		
		String number = "1924";
		int k = 2;
		System.out.println(solution(number, k));
	}
	
	public static String solution(String number, int k) {
        String answer = "";
        
        int[] num = new int[number.length()];
        
        for (int i = 0; i < number.length(); i++) {
        	num[i] = Integer.parseInt(answer);
        }
        
        return answer;
    }

}
