package Implementation.problem;

import java.io.*;
import java.util.*;

/*
구현문제
뱀 - 삼성전자 SW 역량테스트

문제
 'Dummy' 라는 도스게임이 있다. 이 게임에는 뱀이 나와서 기어다니는데, 사과를 먹으면 뱀 길이가 늘어난다. 뱀이 이리저리 기어다니다가 벽 또는 자기자신의 몸과 부딪히면 게임이 끝난다.

게임은 NxN 정사각 보드위에서 진행되고, 몇몇 칸에는 사과가 놓여져 있다. 보드의 상하좌우 끝에 벽이 있다. 게임이 시작할때 뱀은 맨위 맨좌측에 위치하고 뱀의 길이는 1 이다. 뱀은 처음에 오른쪽을 향한다.

뱀은 매 초마다 이동을 하는데 다음과 같은 규칙을 따른다.

먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
사과의 위치와 뱀의 이동경로가 주어질 때 이 게임이 몇 초에 끝나는지 계산하라.

입력
첫째 줄에 보드의 크기 N이 주어진다. (2 ≤ N ≤ 100) 다음 줄에 사과의 개수 K가 주어진다. (0 ≤ K ≤ 100)

다음 K개의 줄에는 사과의 위치가 주어지는데, 첫 번째 정수는 행, 두 번째 정수는 열 위치를 의미한다. 사과의 위치는 모두 다르며, 맨 위 맨 좌측 (1행 1열) 에는 사과가 없다.

다음 줄에는 뱀의 방향 변환 횟수 L 이 주어진다. (1 ≤ L ≤ 100)

다음 L개의 줄에는 뱀의 방향 변환 정보가 주어지는데,  정수 X와 문자 C로 이루어져 있으며. 게임 시작 시간으로부터 X초가 끝난 뒤에 왼쪽(C가 'L') 또는 오른쪽(C가 'D')로 90도 방향을 회전시킨다는 뜻이다. X는 10,000 이하의 양의 정수이며, 방향 전환 정보는 X가 증가하는 순으로 주어진다.

출력
첫째 줄에 게임이 몇 초에 끝나는지 출력한다.
 */
public class Snake {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n+1][n+1];
        int appCnt = Integer.parseInt(br.readLine());
        for(int i=0; i<appCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 사과가 있는 칸을 1로 초기화
            arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }
        List<Pos> list = new ArrayList<>();
        int dLen = Integer.parseInt(br.readLine());
        for(int i=0; i<dLen; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Pos(Integer.parseInt(st.nextToken()), st.nextToken()));
        } // 입력 END

        int result = move(arr, list);
        System.out.println(result);
    }
    public static int move(int[][] board, List<Pos> list) {
        int ret = 0;
        int index = 0;
        // 초기 뱀은 1,1 부터 시작, 몸길이는 1
        SnakePos s = new SnakePos(1,1);
        Queue<SnakePos> q = new LinkedList<>();
        // 꼬리정보는 큐에서 처리
        q.offer(s);
        // 초기 이동값: 오른쪽
        int d = 0;
        // 우 하 좌 상
        int dx[] = {0,1,0,-1};
        int dy[] = {1,0,-1,0};
        while(true) {
            ret++;
            // 벽이랑 부딪힐경우 return
            if(s.x+dx[d] < 1 || s.x+dx[d] > board.length-1 || s.y+dy[d] < 1 || s.y+dy[d] > board.length-1)
                return ret;
            // 진행방향으로 뱀 이동
            s.x += dx[d];
            s.y += dy[d];
            // 자기 자신과 부딪혔을때 return
            if(board[s.x][s.y] == 2) return ret;
            // 진행 방향에 사과가 없다면 뱀이 이동 후 꼬리 제거
            if(board[s.x][s.y] == 0) {
                // 뱀 이동
                board[s.x][s.y] = 2;
                // 꼬리 추가
                q.offer(new SnakePos(s.x,s.y));
                // ts = 꼬리 정보 SnakePos
                SnakePos ts = q.poll();
                // 꼬리 비우기
                board[ts.x][ts.y] = 0;
            }
            // 사과가 있다면
            else if(board[s.x][s.y] == 1){
                // 뱀 이동
                board[s.x][s.y] = 2;
                // 꼬리 추가
                q.offer(new SnakePos(s.x,s.y));
            }
            // 위의 이동을 하고 방향 전환
            if(ret == list.get(index).time) {
                // 왼쪽
                if(list.get(index).direction.equals("L")) {
                    d = d==0?3:d-1;
                }
                // 오른쪽
                else if(list.get(index).direction.equals("D")){
                    d = (d+1)%4;
                }
                index++;
                if(list.size() == index) {
                    index--;
                }
            }
        }
    }
}
class Pos {
    int time;
    String direction;

    Pos(int t, String d) {
        this.time = t;
        this.direction = d;
    }
}
class SnakePos {
    // 뱀 좌표
    int x;
    int y;
    SnakePos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}