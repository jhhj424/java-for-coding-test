package ShortestPath;

import java.io.*;
import java.util.*;

/*
최단경로문제 - 미래 도시 : 내 풀이
플로이드-워셜 알고리즘 풀이 : 시간복잡도 : O(N^3)
 */
/*
예제 입력1
5 7
1 2
1 3
1 4
2 4
3 4
3 5
4 5
4 5

예제 입력2
4 2
1 3
2 4
3 4
 */
public class FutureCity_My {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int INF = (int)1e9;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 회사의 개수 n
        int n = Integer.parseInt(st.nextToken());
        // 경로의 개수 m
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n+1][n+1];
        for(int i=0; i< n+1; i++){
            Arrays.fill(graph[i], INF);
        }

        // 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                if (a == b) graph[a][b] = 0;
            }
        }

        for(int i=0; i< m; i++) {
            st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            graph[now][next] = 1;
            graph[next][now] = 1;
        }
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for(int a=1; a<n+1; a++) {
            for(int b=1; b<n+1; b++) {
                for(int c=1; c<n+1; c++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][c] + graph[c][b]);
                }
            }
        }

        int result = graph[1][k] + graph[k][x];

        if(result > INF) System.out.println(-1);
        else System.out.println(result);

        br.close();
    }
}
