package graph;

import java.util.*;

/*
기타 그래프 이론 - 크루스칼(크러스컬) 알고리즘 : 내풀이

입력 예시
7 9
1 2 29
1 5 75
2 3 35
2 6 34
3 4 7
4 6 23
4 7 13
5 6 53
6 7 25
 */
public class KruskalAlgorithm_my {
    // 노드의 개수(V)와 간선(Union 연산)의 개수(E)
    // 노드의 개수는 최대 100,000개라고 가정
    private static int v, e;
    private static int[] parent = new int[100001];
    private static ArrayList<Edge> edges = new ArrayList<>();
    private static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        for(int i=0; i<v; i++) {
            parent[i] = i;
        }

        for(int i=0; i<e; i++) {
            int now = sc.nextInt();
            int next = sc.nextInt();
            int cost = sc.nextInt();
            edges.add(new Edge(cost, now, next));
        }

        Collections.sort(edges);

        for(int i=0; i<edges.size(); i++) {
            int cost = edges.get(i).getDistance();
            int a = edges.get(i).getNodeA();
            int b = edges.get(i).getNodeB();
            if(findParent(a) != findParent(b)) {
                unionParent(a,b);
                result += cost;
            }
        }

        System.out.println(result);
    }

    private static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    private static int findParent(int b) {
        if(b == parent[b]) return b;
        return parent[b] = findParent(parent[b]);
    }
}