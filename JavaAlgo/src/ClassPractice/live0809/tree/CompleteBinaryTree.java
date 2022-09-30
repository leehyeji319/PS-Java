package ClassPractice.live0809.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

//완전이진트리
class CompleteBinaryTree {

	
	private char[] nodes; //node의 데이터로 char값을 기억할거임
	private int lastIndex; //완전이진트리니까 어디까지 저장됐는지 size관리 해야함
	private final int SIZE;
	
	
	//final 상수만 받아와서 생성자로 초기화
	public CompleteBinaryTree(int size) {
		super();
		SIZE = size;
		//곱셈의 성질때문에 하나 더 잡아준거임. 0곱하면 0이니까 
		nodes = new char[SIZE+1]; //SIZE개수의 노드를 저장(1인덱스부터 사용)
	}
	
	public boolean isFull() {
		return lastIndex == SIZE;
	}
	
	public boolean isEmpty() {
		return lastIndex == 0; //lastIndex는 노드가 저장된 마지막 인덱스. 근데 0이면 아무것도 저장안된거니까~
	}
	
	public void add(char e) {
		//노드를 추가할거야 데이터를 .. 
		if(isFull()) {
			System.out.println("노드를 추가할 공간이 없습니다.");
			return;
		}
		//마지막으로 저장된 인덱스
		nodes[++lastIndex] = e; //인덱스를늘려주면서 채웟단말야
	}
	
	//트리 전체 노드를 너비우선탐색으로 순회(탐색)
	public void bfs() {
		//내맘대로 아니고 규칙에 짜여진대로 할거예여 
		
		//우변은 링크드 리스트. 좌변은  왜? ->큐로서의 기능만사용하기 위해서
		//큐에는 노드를 탐색하는데 필요한 정보를 담는다. 
//		Queue<Integer> queue = new LinkedList<>();
		//ArrayDeque로 해도 안바뀜!! 중요해 
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(1); //루트 노드 넣고 시작
		
		while(!queue.isEmpty()) { //방문할 노드가 있을때까지 반복
			int current = queue.poll(); //다음손님 불러요 ~
			System.out.println(nodes[current]);
			
			//할아버지가 몰랐던 애들
			if (current * 2 <= lastIndex) queue.offer(current*2); //마지막 단말노드가 두개가 아닐수가 잇으니까 그거체크
			if (current * 2 + 1  <= lastIndex)queue.offer(current*2 + 1); //마지막 단말노드가 두개가 아닐수가 잇으니까 그거체크
		}
		
		//LinkedList는 ArrayDeque를 구성하고있음
	}
	
	
	public void dfs() { //자료구조만 queue에서 stack으로 변경
		
		Stack<Integer> queue = new Stack<>();
		queue.push(1); //루트 노드 넣고 시작
		
		while(!queue.isEmpty()) { //방문할 노드가 있을때까지 반복
			int current = queue.pop(); //다음손님 불러요 ~
			System.out.println(nodes[current]);
			
			//할아버지가 몰랐던 애들
			if (current * 2 <= lastIndex) queue.push(current*2); //마지막 단말노드가 두개가 아닐수가 잇으니까 그거체크
			if (current * 2 + 1  <= lastIndex)queue.push(current*2 + 1); //마지막 단말노드가 두개가 아닐수가 잇으니까 그거체크
		}
		
		//LinkedList는 ArrayDeque를 구성하고있음
	}
	
}
