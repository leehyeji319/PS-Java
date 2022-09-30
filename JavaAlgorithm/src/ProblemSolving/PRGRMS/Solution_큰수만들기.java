package ProblemSolving.PRGRMS;

import java.util.Stack;

public class Solution_큰수만들기 {
	
	public static void main(String[] args) {
		
		String number = "4321";
		int k = 2;
		System.out.println(solution(number, k));
	}
	
	public static String solution(String number, int k) {
        String answer = "";
        int len = number.length();
        Stack<Integer> stack = new Stack<>();
        
        int[] num = new int[len];
        
        for (int i = 0; i < len; i++) {
        	num[i] = number.charAt(i) - '0';
        	//stack.add(number.charAt(i) - '0');
        }
        
        for (int n = 0; n < len; n++) {
        	if (stack.empty()) {
        		stack.add(num[n]);
        		continue;
        	}
        	
        	if (k > 0) {
        		while (stack.peek() < num[n]) {
        			stack.pop();
        			k--;
        			if (stack.empty() || k <= 0) {
        				break;
        			}
        		}
        	}
        	stack.push(num[n]);
        }
        
        if (stack.size() == len) {
        	stack.pop();
        }
        
//        if (k > 0) {
//        	for (int i = 0; i < k; k++) {
//        		stack.pop();
//        	}
//        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
        	sb.append(stack.get(i));
        }
       
        return sb.toString();
    }

}
