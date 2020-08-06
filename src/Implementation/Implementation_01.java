package Implementation;

/**
 * 구현 알고리즘 01 : 상하좌우
 * L: 왼쪽으로 한 칸 이동
 * R: 오른쪽으로 한 칸 이동
 * U: 위로 한 칸 이동
 * D: 아래로 한 칸 이동
 */
public class Implementation_01 {
    public static void main(String[] args) {
        int n = 5;
        String str = "R R R U D D D D D D D";
        int[] result = 상하좌우1(n, str);
        for(int i: result) {
            System.out.print(i + " ");
        }
        System.out.println();
        result = 상하좌우2(n, str);
        for(int i: result) {
            System.out.print(i + " ");
        }
    }
    public static int[] 상하좌우1(int n, String 이동계획서) {
        int x=1, y=1; // 시작 좌표
        int[] ret = new int[2]; // 도착 좌표
        String[] c = 이동계획서.split(" ");
        for(int i=0; i<c.length; i++) {
            if(c[i].equals("L")) {
                y -= 1;
            }else if(c[i].equals("R")) {
                y += 1;
            }else if(c[i].equals("U")) {
                x -= 1;
            }else { // "D" 일때
                x += 1;
            }
            if(x < 1) x +=1;
            else if(y < 1) y +=1;
            else if(x > n) x -=1;
            else if(y > n) y -=1;
        }
        ret[0] = x;
        ret[1] = y;

        return ret;
    }
    public static int[] 상하좌우2(int n, String 이동계획서) {
        int x=1, y=1; // 시작 좌표
        int[] ret = new int[2]; // 도착 좌표
        String[] plans = 이동계획서.split(" ");
        // L, R, U, D에 따른 이동 방향
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        char[] moveTypes = {'L', 'R', 'U', 'D'};

        // 이동 계획을 하나씩 확인
        for (int i = 0; i < plans.length; i++) {
            char plan = plans[i].charAt(0);
            // 이동 후 좌표 구하기
            int nx = -1, ny = -1;
            for (int j = 0; j < 4; j++) {
                if (plan == moveTypes[j]) {
                    nx = x + dx[j];
                    ny = y + dy[j];
                }
            }
            // 공간을 벗어나는 경우 무시
            if (nx < 1 || ny < 1 || nx > n || ny > n) continue;
            // 이동 수행
            x = nx;
            y = ny;
        }
        ret[0] = x;
        ret[1] = y;

        return ret;
    }
}
