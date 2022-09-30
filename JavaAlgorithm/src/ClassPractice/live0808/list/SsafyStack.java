package ClassPractice.live0808.list;

public class SsafyStack<E> implements IStack<E>{

	private Node<E> top; //더미노드 아님!! 
	
	@Override
	public void push(E data) { //첫노드삽입 알고리즘
		top = new Node<E>(data, top); //여기서 노드생성, 데이터저장, 링크저장 세개 다하는거임
		
	}

	@Override
	public E pop() {
		if (isEmpty()) {
			System.out.println("공백스택이어서 작업이 불가능합니다.");
			return null;
		}
		
		Node<E> popNode = top;
		top = popNode.link; //다음노드를 탑으로 오게끔 바꿔준다.
		popNode.link = null; //제거하려는 노드를 끊어주고 
		return popNode.data; //내가 갖고있었던 데이터를 리턴해주면 맨꼭대기에 있던 애가 리턴된다.
		
	}

	@Override
	public E peek() {
		if (isEmpty()) {
			System.out.println("공백스택이어서 작업이 불가능합니다.");
			return null;
		}
		return top.data; //공백이 아니면 탑의 데이터를 준다.
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return top == null;
	}

	@Override
	public int size() {
		//맨앞에서부터 끝까지 탐색한 노드의 갯수
		int cnt = 0;
		//java는 항상 참과 거짓이 될 수 있는 조건으로 해야함 (temp != null)
		for (Node<E> temp = top; temp != null; temp = temp.link) { //temp의 link를 따라가준다. 
			//null이 아니면 카운트++
			++cnt; //여기에 노드에 접근할때마다 하고싶은거 작성해주면 된다. 
		}
		
		return cnt;
	}
	
}
