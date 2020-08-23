package graph;

import java.io.*;
import java.util.*;

/*
기타 그래프 문제 - 커리큘럼 : 위상정렬 사용 : 내풀이

입력예시
5
10 -1
10 1 -1
4 1 -1
4 3 1 -1
3 3 -1
 */
public class Curriculum_my {
    private static int n;
    // 차수
    private static int[] indegree = new int[501];
    // 시간
    private static int[] time= new int[501];
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    private static void topologySort() {
        int[] result = new int[501];
        for(int i=1; i<n+1; i++) {
            result[i] = time[i];
        }

        Queue<Integer> q = new LinkedList<>();

        // 진입차수가 0인 노드 큐에 삽입
        for(int i=1; i<n+1; i++) {
            if(indegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()) {
            int now = q.poll();
            for(int i=0; i<graph.get(now).size(); i++) {
                int next = graph.get(now).get(i);
                result[next] = Math.max(result[next], result[now]+time[next]);
                indegree[next] -= 1;
                if(indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        for(int i=1; i<n+1; i++) {
            System.out.println(result[i]);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i=0; i<n+1; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=1; i<n+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            time[i] = x;
            while(true) {
                x = Integer.parseInt(st.nextToken());
                if(x == -1) break;
                indegree[i]++;
                graph.get(x).add(i);
            }
        }
        // 위상정렬 수행
        topologySort();
        br.close();
    }
}
