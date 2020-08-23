package ShortestPath;
import java.util.*;
import java.io.*;

class 노드 implements Comparable<노드>{
    int index, cost;

    노드(int index, int cost) {
        this.cost = cost;
        this.index = index;
    }

    // 비용 오름차순 정렬
    @Override
    public int compareTo(노드 other) {
        return this.cost - other.cost;
    }
}
public class Dijkstra_practice {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int INF = (int)1e9;
    private static ArrayList<ArrayList<노드>> list = new ArrayList<ArrayList<노드>>();
    private static int[] d = new int[100001];

    private static void dijkstra(int start) {
        PriorityQueue<노드> pq = new PriorityQueue<노드>();
        pq.offer(new 노드(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()) {
            노드 node = pq.poll();
            int dist = node.cost;
            int now= node.index;

            if(d[now] < dist) continue;

            for(int i=0; i<list.get(now).size(); i++) {
                노드 next_node = list.get(now).get(i);
                int cost = d[now] + next_node.cost;
                if(d[next_node.index] > cost) {
                    d[next_node.index] = cost;
                    pq.offer(new 노드(next_node.index, cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        Arrays.fill(d, INF);

        for(int i=0; i< n+1; i++) {
            list.add(new ArrayList<노드>());
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(now).add(new 노드(next,cost));
        }

        dijkstra(start);

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++) {
            if(d[i] == INF) sb.append("INF\n");
            else sb.append(d[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();



    }
}
