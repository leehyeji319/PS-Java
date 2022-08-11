package com.ssafy.homeworkreview;

import java.util.Iterator;
import java.util.Stack;

public class homework_0804 {

	public static void main(String[] args) {
		Stack<String> backward = new Stack<>();
		
		Stack<String> forward = new Stack<>();
		
		String[] command = {"http://www.google.com", "http://www.naver.com", "B", 
				"http://www.edu.ssafy.com", "F", "B", "F", "B", "B", "B", "Q"};
		
		String currentPage = "http://www.ssafy.com";
		
		for (int c = 0; c < command.length; c++) {
			 String currentCommand =  command[c];
			 
			 if (currentCommand.equals("B") && !backward.empty()) {
				 System.out.println("뒤로가기");
				 forward.push(currentPage);
				 currentPage = backward.pop();
				
				 
			 } else if (currentCommand.equals("B") && backward.empty()) {
				 System.out.println("뒤로가기 페이지 존재하지않음");
				 System.out.println("현재 페이지: " + currentPage + "\n");
				 continue;
				 
			 } else if (currentCommand.equals("F") && !forward.empty()) {
				 System.out.println("앞으로가기");
				 backward.push(currentPage);
				 currentPage = forward.pop();
			 } else if (currentCommand.equals("F") && forward.empty()) {
				 System.out.println("앞으로가기 페이지 존재하지 않음");
				 System.out.println("현재 페이지: " + currentPage + "\n");
				 continue;
			 } else if (currentCommand.equals("Q")) {
				 System.out.println("현재 페이지: " + currentPage);
				 break;
				 
			 } else {
				 
				 System.out.println("새페이지 이동 :" + currentCommand);
				 forward.clear();
				 
				 backward.push(currentPage);
				 currentPage = currentCommand;
				 
			 }
			 
			 System.out.println("현재 페이지: " + currentPage + "\n");
		}

	}

}
