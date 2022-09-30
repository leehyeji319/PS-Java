package ClassPractice.live0825;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PrimTest2_PQ { //priority queue 사용

    static class Node {
        int vertex, weight;
        Node next; //ㅇㅕㄴ결

        public Node(int vertex, int weight, Node next) {
            this.vertex = vertex;
            this.weight = weight;
            this.next = next;
        }
    }

    static class Vertex {
        int no, weight;

        public Vertex(int no, int weight) {
            this.no = no;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        Node[] adjList = new Node[V]; //각 정점별 인접리스트

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            //무향처리
            adjList[from] = new Node(to, weight, adjList[from]);
            adjList[to] = new Node(from, weight, adjList[to]);
        }

        //프림알고리즘에 필요한 자료구조
        int[] minEdge = new int[V]; //각 정점 입장에서 신장트리에 포함된 정점과의 간선 비용중 최소비용
        boolean[] visited = new boolean[V]; //신장트리에 포함여부

        Arrays.fill(minEdge, Integer.MAX_VALUE); //최소값 관리하기위해 큰 값을 세팅

        // 1.임의의 시작점 처리, 0번 정점을 신장트리의 구성의 시작점
        minEdge[0] = 0;
        int result = 0; //최소신장트리의 바용 누적

        //========pq추가=======//
        PriorityQueue<Vertex> pq = new PriorityQueue<>((v1, v2) -> v1.weight - v2.weight);
        pq.offer(new Vertex(0, minEdge[0]));

        int cnt = 0;
        while (true) { //혹은 !pq.isEmpty()

            //step1. 신장트리의 구성에 포함되지 않은 정점 중 최소비용 정점 선택
            Vertex minVertex = pq.poll();

            //////////////변경///////////
            if (visited[minVertex.no]) continue;
            //setp2. 신장트리에 추가

            visited[minVertex.no] = true;
            result += minVertex.weight;
            if (++cnt == V)
                break;

            //step3. 신장트리에 새롭게 추가되는 정점과 신장트리에 포함되지 않은 정점들의 기존 최소비용과 비교해서 갱신
            //		신장트리에 새롭게 추가되는 정점의 모든 인접정점 들여다보며 처리
            for (Node temp = adjList[minVertex.no]; temp != null; temp = temp.next) {
                if (!visited[temp.vertex] && minEdge[temp.vertex] > temp.weight) {
                    minEdge[temp.vertex] = temp.weight;
                    pq.offer(new Vertex(temp.vertex, minEdge[temp.vertex]));
                }

            }
        }
        System.out.println(result);
    }
}
