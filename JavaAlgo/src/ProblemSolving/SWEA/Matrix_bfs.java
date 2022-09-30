package ProblemSolving.SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Matrix_bfs {
	static int n; 						//노드개수
	static char[][] map;				//노드를 담을 배열 
	static boolean[][] visited; 			//노드를 방문했는지 체크하는 배열
	static int[] dr = {-1, 1, 0, 0};	//4방 탐색을 위한 배열
	static int[] dc = {0, 0, -1, 1};	//4방 탐색을 위한 배열
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/map.txt")); //이렇게하면 나중에 주석만 해제해주면 된다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new char[n][n];
		visited = new boolean[n][n];
		
		//데이터 입력받기 
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = st.nextToken().charAt(0); //하나씩 가져오면 되니까 
			}
		}
		
		//탐색
		bfs(0, 0); //스타트 좌표 끊어주기
		
	}

	private static void bfs(int r, int c) {
		//큐 생성하기 bfs 니까
		Queue<int[]> queue = new LinkedList<>();
		
		//이거 두개가 제일 중요함 ..
		//큐에 첫 노드를 추가
		queue.offer(new int[] {r,c});
		//방문 체크 하기 --> 젤 중요 !
		visited[r][c] = true; //꺼내올때 방문체크할래요 //성능의 문제로 이렇게 나옴
		
		// 모든 노드를 탐색하기 위해 Q에 노드가 없을때까지 반복처리
		while(!queue.isEmpty()) {
			//큐에서 탐색할 노드를 추출
			int [] cur = queue.poll();
			r = cur[0];
			c = cur[1];
			//노드를 통해 처리할 일을 작성 ==> 출력
			System.out.print(map[r][c] + " -> ");
			//노드를 인접한 노드 탐색
			for (int i = 0, end = dr.length; i< end; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				//안가본 노드여야하고, 4방탐색이기때문에 경계내에 잇어야함
				if (nr<0 || nr>=n || nc<0 || nc>=n || visited[nr][nc]) continue;
				
				//인접한 노드를 큐에 넣기
				queue.offer(new int[] {nr, nc});
				//방문체크하기
				visited[nr][nc] = true;
				
			}
		}
	}

}
