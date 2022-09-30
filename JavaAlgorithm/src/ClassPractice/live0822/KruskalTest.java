package ClassPractice.live0822;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class KruskalTest {

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
//			return Integer.compare(this.weight, o.weight);

			return this.weight - o.weight;
		}

	}

	static int[] parents;
	static int V, E;
	static Edge[] edgeList; // 간선 리스트

	static void make() { // 크기가 1인 서로소 집합 생성
		parents = new int[V]; // 만들어라!!하면 정점 개수만큼 인덱스 배열을 만들고 그 값들을 자기 자신들로 채운다
		for (int i = 0; i < V; i++) { // 모든 노드가 자신을 부모로하는(대표자) 집합으로 만든다.
			parents[i] = i; // 자신의 부모는 자기로

		}
	}

	static int find(int a) { // a의 대표자찾기
		if (parents[a] == a)
			return a; // 나의 부모가 나라면
		// return 되지 않았으면 내 부모가 있다는 뜻이잖아
		return parents[a] = find(parents[a]); // 나의 부모한테 시켜 데려와달라고. 그렇게 받은 결과가 루트노트
		// 우리의 대표자를 나의 부모로 바꾼다. : pass compression

	}

	static boolean union(int a, int b) { // return값이 true -> union이 성공
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return false;// 오잉 우리 같은 식구였어? 합칠수가없네 return false;

		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		edgeList = new Edge[E];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			edgeList[i] = new Edge(Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}
		
		make();
		Arrays.sort(edgeList);
		
		int result = 0; 
		int count = 0;
		for (Edge edge : edgeList) {
			if (union(edge.from, edge.to)) { //유니온이 성공하면 
				result += edge.weight; //가중치 비용을 더해주고
				if (++count == V - 1) break;
			}
		}
		System.out.println(result);
	}

}