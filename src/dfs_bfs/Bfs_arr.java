package dfs_bfs;

import java.util.*;

/*
BFS - 배열에서 너비 우선 탐색
 */
public class Bfs_arr {
    static int cnt = 0;
    static int big = 0;
    static boolean[][] visited;
    static int[][] input;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n,m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        input = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                input[i][j] = sc.nextInt();
            }
        }
        int max = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(input[i][j] == 0 || visited[i][j])
                    continue;
                cnt++;
                bfs(i, j);
                max = Math.max(max, big);
            }
        }
        System.out.println(cnt);
        System.out.println(max);
    }
    static void bfs(int a, int b) {
        if(visited[a][b]) return;
        Queue<xy> q = new LinkedList<>();
        visited[a][b] = true;
        q.offer(new xy(a, b));
        big = 0;
        while (!q.isEmpty()) {
            big++;
            xy now = q.poll();
            for(int i=0; i<4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx<0 || ny<0 || nx >= n || ny >= m) continue;
                if(visited[nx][ny] || input[nx][ny] == 0) continue;
                visited[nx][ny] = true;
                q.offer(new xy(nx,ny));
            }
        }
    }
}
class xy {
    int x;
    int y;
    public xy(int x, int y) {
        this.x = x;
        this.y = y;
    }
}