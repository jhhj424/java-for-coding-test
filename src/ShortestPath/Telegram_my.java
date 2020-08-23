package ShortestPath;

import java.util.*;
import java.io.*;

/*
최단경로문제 - 전보 : 내 풀이
다익스트라 알고리즘 풀이 : 시간복잡도 : O(ElogV)
 */
/*
입력예시
3 2 1
1 2 4
1 3 2
출력 예시
2 4
 */
class City implements Comparable<City>{
    int index;
    int time;

    City(int index, int time) {
        this.index = index;
        this.time = time;
    }

    @Override
    public int compareTo(City other) {
        return this.time - other.time;
    }
}
public class Telegram_my {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int INF = (int) 1e9;
    private static ArrayList<ArrayList<City>> graph = new ArrayList<>();
    private static int[] d = new int[30001];

    // 다익스트라 알고리즘
    private static void dijkstra(int start) {
        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.offer(new City(start, 0));
        d[start] = 0;

        // pq에 값이 있을 경우 반복
        while(!pq.isEmpty()) {
            // 메세지 전달 시간이 최소인 city 꺼내기
            City city = pq.poll();
            assert city != null;
            int this_time = city.time;
            int this_index = city.index;
            // 만약 최단거리가 현재 this_time 보다 짧을 경우 패스
            if(d[this_index] < this_time) continue;
            // 현재 city 와 통로가 연결된 다른 city 들을 확인
            for(int i=0; i<graph.get(this_index).size(); i++) {
                City next_city = graph.get(this_index).get(i);
                int next_time = d[this_index] + next_city.time;
                if(d[next_city.index] > next_time) {
                    d[next_city.index] = next_time;
                    pq.offer(new City(next_city.index, next_time));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 도시의 개수 n, 통로의 개수 m, 메세지를 보내고자 하는 도시 c
        int n = Integer.parseInt(st.nextToken());
        int m =  Integer.parseInt(st.nextToken());
        int c =  Integer.parseInt(st.nextToken());

        // 최단거리 배열 INF 로 초기화
        Arrays.fill(d, INF);

        // graph 초기화
        for(int i=0; i<n+1; i++) {
            graph.add(new ArrayList<City>());
        }

        // 통로에 대한 정보 x, y, z
        // 특정 도시 x에서 다른 특정 도시 y로 이어지는 통로가 있고, 메세지가 전달되는 시간이 z라는 의미
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            graph.get(x).add(new City(y, z));
        }

        dijkstra(c);

        int result_cnt = 0;
        int max_time = 0;
        for(int i=0; i<=n; i++) {
            if(d[i] != INF) {
                result_cnt++;
                max_time = Math.max(max_time, d[i]);
            }
        }
        System.out.println(result_cnt-1+" "+max_time);
        br.close();
    }
}