package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 탐색 알고리즘 02 : 미로 탈출
 * BFS 풀이
 */
public class dfs_bfs_02_01 {
    static int n, m;
    static int[][] map = {
            {1,0,1,0,1,0},
            {1,1,1,1,1,1},
            {0,0,0,0,0,1},
            {1,1,1,1,1,1},
            {1,1,1,1,1,1},
    };
    // 이동할 네 가지 방향 정의 (상, 하, 좌, 우)
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};
    public static void main(String[] args) {
        n = 5;
        m = 6;
        int result = 미로탈출(0,0);
        System.out.println("result: " + result);
    }

    public static int 미로탈출(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y));
        while(!q.isEmpty()) {
            Node node = q.poll();
            x = node.getIndex();
            y = node.getDistance();
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(map[nx][ny] == 0) continue;
                if(map[nx][ny] == 1) {
                    map[nx][ny] = map[x][y] + 1;
                    q.offer(new Node(nx, ny));
                }
            }
        }
        System.out.println("map : ");
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                System.out.print(map[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println();
        return map[n-1][m-1];
    }
}
class Node {

    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }
}
