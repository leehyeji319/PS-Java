package ClassPractice.live0809.tree;

public class CompleteBinaryTreeTest {

	public static void main(String[] args) {
		int size= 10;
		//일단 10개로 해줌 
		CompleteBinaryTree tree = new CompleteBinaryTree(size);
		
		for (int i = 0; i < size; i++) {
			tree.add((char)('A' + i));
		}
		
//		tree.bfs();
		tree.dfs();

	}

}
