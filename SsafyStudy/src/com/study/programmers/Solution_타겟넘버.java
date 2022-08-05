package com.study.programmers;


import java.util.*;

public class Solution_타겟넘버 {


    public static void main(String[] args) {
      int[] numbers = {1, 1, 1, 1, 1};
      int target = 3;

      System.out.println(solution(numbers, target));
    }
    

    public static int solution(int[] numbers, int target) {
        int answer = 0;
        Stack<Integer> parents = new Stack<>();
        
        parents.add(0);
        
        for (int i = 0; i < numbers.length; i++) {
          Stack<Integer> child = new Stack<>();
          for (int j = 0; j < parents.size(); j++) {
            child.add(parents.get(j) + numbers[i]);
            child.add(parents.get(j) - numbers[i]);
          }


          parents = child;
        }

        for (Integer p : parents) {
          if (p == target) {
            answer++;
          }
        }

        return answer;
    }

}
