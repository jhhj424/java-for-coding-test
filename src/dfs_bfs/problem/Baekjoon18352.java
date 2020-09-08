package dfs_bfs.problem;

import java.util.*;

/*
BFS/DFS 실전문제
특정 거리의 도시 찾기
https://www.acmicpc.net/problem/18352

문제
어떤 나라에는 1번부터 N번까지의 도시와 M개의 단방향 도로가 존재한다. 모든 도로의 거리는 1이다.

이 때 특정한 도시 X로부터 출발하여 도달할 수 있는 모든 도시 중에서, 최단 거리가 정확히 K인 모든 도시들의 번호를 출력하는 프로그램을 작성하시오. 또한 출발 도시 X에서 출발 도시 X로 가는 최단 거리는 항상 0이라고 가정한다.

예를 들어 N=4, K=2, X=1일 때 다음과 같이 그래프가 구성되어 있다고 가정하자.



이 때 1번 도시에서 출발하여 도달할 수 있는 도시 중에서, 최단 거리가 2인 도시는 4번 도시 뿐이다.  2번과 3번 도시의 경우, 최단 거리가 1이기 때문에 출력하지 않는다.

입력
첫째 줄에 도시의 개수 N, 도로의 개수 M, 거리 정보 K, 출발 도시의 번호 X가 주어진다. (2 ≤ N ≤ 300,000, 1 ≤ M ≤ 1,000,000, 1 ≤ K ≤ 300,000, 1 ≤ X ≤ N) 둘째 줄부터 M개의 줄에 걸쳐서 두 개의 자연수 A, B가 공백을 기준으로 구분되어 주어진다. 이는 A번 도시에서 B번 도시로 이동하는 단방향 도로가 존재한다는 의미다. (1 ≤ A, B ≤ N) 단, A와 B는 서로 다른 자연수이다.

출력
X로부터 출발하여 도달할 수 있는 도시 중에서, 최단 거리가 K인 모든 도시의 번호를 한 줄에 하나씩 오름차순으로 출력한다.

이 때 도달할 수 있는 도시 중에서, 최단 거리가 K인 도시가 하나도 존재하지 않으면 -1을 출력한다.
 */
public class Baekjoon18352 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); // 도시의 개수
        int m = scan.nextInt(); // 도로의 개수
        int k = scan.nextInt(); // 목표 최단거리
        int x = scan.nextInt(); // 출발도시
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        // 모든 도시 최단거리 초기화
        int[] d = new int[300001];
        // 그래프, 최단 거리 배열 초기화
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
            d[i] = -1;
        }

        // 출발도시 최단거리는 0으로 초기화
        d[x] = 0;

        // 모든 도로 정보 입력
        for(int i=0; i<m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            graph.get(a).add(b);
        }

        // BFS
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        while (!q.isEmpty()) {
            int now = q.poll();
            // 현재 도시에서 이동할 수 있는 도시 확인
            for(int i=0; i< graph.get(now).size();i++) {
                int nextNode = graph.get(now).get(i);
                // 아직 방문하지 않았다면
                if(d[nextNode] == -1) {
                    // 최단거리 갱신
                    d[nextNode] = d[now] + 1;
                    q.offer(nextNode);
                }
            }
        }
        // 최단 거리가 k인 모든 도시의 번호를 오름차순 출력
        boolean chk = false;
        for(int i=1; i<=n; i++) {
            if(d[i] == k) {
                System.out.println(i);
                chk = true;
            }
        }
        if(!chk) System.out.println(-1);

    }
}
