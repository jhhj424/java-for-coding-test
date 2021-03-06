package ShortestPath;

import java.io.*;
import java.util.*;

/**
 * 예제
 * <p>
 * 입력
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6


 * 출력
 * 0
 * 2
 * 3
 * 7
 * INFINITY
 */

/*
최단경로 - 다익스트라 알고리즘 : O(ElogV)
 */
class Node implements Comparable<Node> {
    int index, distance;

    Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
    // 오름차순
    @Override
    public int compareTo(Node other) {
        return this.distance - other.distance;
    }
}

public class DijkstraAlgorithm2 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정
    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    private static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    // 최단 거리 테이블 만들기
    private static int[] d = new int[100001];

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
        pq.offer(new Node(start, 0));
        d[start] = 0;
        while (!pq.isEmpty()) { // 큐가 비어있지 않다면
            // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            Node node = pq.poll();
            assert node != null;
            int dist = node.distance; // 현재 노드까지의 비용
            int now = node.index; // 현재 노드
            // 현재 노드까지의 비용이 현재 노드까지의 최소비용보다 클 경우 무시
            if (d[now] < dist) continue; // d[now] : 현재 노드까지의 최단거리
            // 현재 노드와 연결된 다른 인접한 노드들을 확인
            for (int i = 0; i < graph.get(now).size(); i++) {
                // next_node : 현재 노드와 연결된 다른 노드
                Node next_node = graph.get(now).get(i);
                // cost : 현재 노드까지의 최단거리 + 다음 노드까지의 거리
                int cost = d[now] + next_node.distance;
                /*
                 * 현재 노드를 거쳐서, 다음 노드로 이동하는 거리(cost)가
                 * 다음 노드의 최단거리(d[next_node.index]) 보다 작을 경우
                 */
                if (cost < d[next_node.index]) {
                    d[next_node.index] = cost;
                    pq.offer(new Node(next_node.index, cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 노드의 개수(N), 간선의 개수(M), 시작 노드 번호(Start)
        // 노드의 개수는 최대 100,000개라고 가정
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        // 최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(d, INF);

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }

        // 모든 간선 정보를 입력받기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            // now 노드에서 next 노드로 가는 비용이 cost 라는 의미
            graph.get(now).add(new Node(next, cost));
        }

        // 다익스트라 알고리즘을 수행
        dijkstra(start);

        StringBuilder sb = new StringBuilder();
        // 모든 노드로 가기 위한 최단 거리를 출력
        for (int i = 1; i <= n; i++) {
            // 도달할 수 없는 경우, 무한(INF)이라고 출력
            if (d[i] == INF) sb.append("INF\n");
                // 도달할 수 있는 경우 거리를 출력
            else sb.append(d[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}