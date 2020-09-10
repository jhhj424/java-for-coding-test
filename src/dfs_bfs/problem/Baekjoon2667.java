package dfs_bfs.problem;

import java.util.*;

/*
단지번호붙이기
https://www.acmicpc.net/problem/2667

시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	64077	25671	16355	38.484%
문제
<그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 철수는 이 지도를 가지고 연결된 집들의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다. 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.

입력
첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.

출력
첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.

예제 입력 1
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000
예제 출력 1
3
7
8
9
 */
public class Baekjoon2667 {
    static int n, cnt = 0;
    static int[][] arr;
    static boolean[][] visited = new boolean[626][626];
    static ArrayList<Integer> list = new ArrayList<>();

    // 상 하 좌 우
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        for(int i=0; i<n; i++) {
            String s = sc.next();
            for(int j=0; j<n; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j] && arr[i][j] == 1) {
                    cnt = 1;
                    dfs(i,j);
                    list.add(cnt);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int i: list) {
            System.out.println(i);
        }
    }
    static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int nextX = x+dx[i];
            int nextY = y+dy[i];
            if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) continue;
            if(!visited[nextX][nextY] && arr[nextX][nextY] == 1) {
                dfs(nextX,nextY);
                cnt++;
            }
        }
    }
}
