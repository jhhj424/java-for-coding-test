package Implementation;

/**
 * 구현 알고리즘 04 : 게임 개발
 */
public class Implementation_04_1 {
    public static void main(String[] args) {
        int[] map_size = {4,4};
        int[] character = {1,1,0};
        int[][] map = {
                {1,1,1,1},
                {1,0,0,1},
                {1,1,0,1},
                {1,1,1,1},
        };
        System.out.println(게임개발1(map_size, character, map));
    }

    public static int 게임개발1(int[] map_size, int[] character, int[][] map) {
        int ret = 0, turn_cnt = 0;
        // 북, 동, 남, 서 순서대로 캐릭터가 움직이는 거리
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        // 캐릭터의 방향
        int direction = character[2];
        // 캐릭터의 좌표(위치)
        int x = character[0], y = character[1];
        while(true) {
            direction -= 1;
            if (direction == -1) direction = 3;
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            if(map[nx][ny] == 0) { // 해당 땅이 육지일때
                map[nx][ny] = 2; // 가본 땅 표시
                x = nx;
                y = ny;
                ret += 1;
                turn_cnt = 0;
                continue;
            } else { // 육지가아니거나 가본땅일때
                turn_cnt += 1;
            }
            if(turn_cnt == 4) { // 네 방향 모두 갈 수 없는 경우
                nx = x - dx[direction];
                ny = y - dy[direction];
                if(map[nx][ny] == 1) { // 뒤쪽 방향이 바다칸이라 뒤로갈 수 없는 경우
                    break;
                } else { // 이동가능
                    x = nx;
                    y = ny;
                }
                turn_cnt = 0;
            }
        }
        return ret;
    }
}
