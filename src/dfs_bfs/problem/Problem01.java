package dfs_bfs.problem;

import java.util.*;

/*
    음료수 얼려 먹기 - BFS 풀이
 */
public class Problem01 {

    static boolean[][] visited;
    static int[][] arr;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n,m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int cnt = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(arr[i][j] == 1 || visited[i][j]) continue;
                bfs(i,j);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static void bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(x, y));
        visited[x][y] = true;
        while(!q.isEmpty()) {
            Pair now = q.poll();
            for(int i=0; i<4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(visited[nx][ny] || arr[nx][ny] == 1) continue;
                q.offer(new Pair(nx, ny));
                visited[nx][ny] = true;
            }
        }
    }
}
class Pair {
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
