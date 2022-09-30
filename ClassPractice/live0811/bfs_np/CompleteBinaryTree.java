package com.ssafy.live0811.bfs_np;

import java.util.*;

//완전이진트리
public class CompleteBinaryTree {

	private char[] nodes; // 영어로 할거라 챠로햇어용
	private int lastIndex; // 마지막노드의 인덱스
	private final int SIZE; // 객체상수

	public CompleteBinaryTree(int size) {
		super();
		SIZE = size; // 객체상수는 반드시 생성자에서 초기화해야함
		nodes = new char[size + 1]; // 1인덱스부터 사용
	}

	public boolean add(char e) { // 완전이진트리에 맞게 추가
		if (lastIndex == SIZE) {
			return false;
		}
		nodes[++lastIndex] = e;
		return true;
	}

	public void bfs2() {
		Queue<Integer> queue = new LinkedList<Integer>(); // index를 관리
		queue.offer(1);

		while (!queue.isEmpty()) { // 방문 대상이 있을때까지 반복
			int size = queue.size(); // 안에서 사이즈 체크하고 사이즈만큼만 돈다 //동일 너비대상 개수
			while (--size >= 0) {
				int current = queue.poll(); // 다음 방문할 대상이누구입니까? 방문차례인 대상 정보 꺼내기
				System.out.print(nodes[current] + " "); // 방문해서 해야할일 처리

				// 현재 방문노드의 자식노드들을 대기열에 넣기
				if (current * 2 <= lastIndex)
					queue.offer(current * 2); // 왼쪽자식
				if (current * 2 + 1 <= lastIndex)
					queue.offer(current * 2 + 1); // 오른쪽 자식

			}
			System.out.println();
		}
		System.out.println();
	}

	public void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>(); // index를 관리
		queue.offer(1);

		while (!queue.isEmpty()) { // 방문 대상이 있을때까지 반복
			int current = queue.poll(); // 다음 방문할 대상이누구입니까? 방문차례인 대상 정보 꺼내기
			System.out.print(nodes[current] + " "); // 방문해서 해야할일 처리

			// 현재 방문노드의 자식노드들을 대기열에 넣기
			if (current * 2 <= lastIndex)
				queue.offer(current * 2); // 왼쪽자식
			if (current * 2 + 1 <= lastIndex)
				queue.offer(current * 2 + 1); // 오른쪽 자식
		}
		System.out.println();
	}

	public void dfs() {
		Stack<Integer> stack = new Stack<Integer>(); // index를 관리
		stack.push(1);

		while (!stack.isEmpty()) { // 방문 대상이 있을때까지 반복
			int current = stack.pop(); // 다음 방문할 대상이누구입니까? 방문차례인 대상 정보 꺼내기
			System.out.print(nodes[current] + " "); // 방문해서 해야할일 처리

			// 현재 방문노드의 자식노드들을 대기열에 넣기
			if (current * 2 <= lastIndex)
				stack.push(current * 2); // 왼쪽자식
			if (current * 2 + 1 <= lastIndex)
				stack.push(current * 2 + 1); // 오른쪽 자식
		}
		System.out.println();
	}

	public void dfsByPreOrder(int current) {
		//먼저 조건을 보고 보낸다.
		System.out.print(nodes[current] + " "); // 방문해서 해야할 일 처리

		if (current * 2 <= lastIndex) dfsByPreOrder(current * 2);
		if (current * 2 + 1 <= lastIndex) dfsByPreOrder(current * 2 + 1);
	}

	public void dfsByInOrder(int current) { //일단 재귀태워서 보내고 그다음에 조건을 체크한다. //이건 이진트리니까 가능한거지
		//기저조건써야함
		if (current>lastIndex) return;

		if (current * 2 <= lastIndex) dfsByInOrder(current * 2);
		System.out.print(nodes[current] + " "); // 방문해서 해야할 일 처리
		if (current * 2 + 1 <= lastIndex) dfsByInOrder(current * 2 + 1);
	}
	
	public void dfsByPostOrder(int current) { //일단 재귀태워서 보내고 그다음에 조건을 체크한다.
		//기저조건써야함
		if (current>lastIndex) return;

		if (current * 2 <= lastIndex) dfsByPostOrder(current * 2);
		if (current * 2 + 1 <= lastIndex) dfsByPostOrder(current * 2 + 1);
		System.out.print(nodes[current] + " "); // 방문해서 해야할 일 처리
	}
}
