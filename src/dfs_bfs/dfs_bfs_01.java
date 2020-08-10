package dfs_bfs;

/**
 * 탐색 알고리즘 01 : 음료수 얼려 먹기
 */
public class dfs_bfs_01 {
    static int n,m;
    static int[][] 얼음틀 = {
            {0,0,1,1,0},
            {0,0,1,1,1},
            {1,1,0,1,0},
            {0,0,1,0,1},
    };
    public static void main(String[] args) {
        n = 얼음틀.length;
        m = 얼음틀[0].length;
        System.out.println(음료수얼려먹기(얼음틀));
    }
    public static int 음료수얼려먹기(int[][] map) {
        int ret = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(dfs(i,j)) {
                    ret++;
                }
            }
        }
        return ret;
    }

    public static boolean dfs(int x, int y) {
        if(x<0 || x>n-1 || y<0 || y>m-1) return false;
        if(얼음틀[x][y] == 0) {
            얼음틀[x][y] = 1;
            dfs(x-1, y);
            dfs(x,y+1);
            dfs(x+1, y);
            dfs(x, y-1);
            return true;
        }
        return false;
    }
}
