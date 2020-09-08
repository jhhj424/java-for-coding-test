package Implementation.problem;

import java.util.Arrays;

/*
구현 문제
기둥과 보 - 2020 카카오 신입 공채
https://programmers.co.kr/learn/courses/30/lessons/60061?language=java
 */
public class ColumnsAndBeams {
    private static boolean[][] pillar; // 기둥
    private static boolean[][] beam; // 보
    public static void main(String[] args) {
//        int[][] bf = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
        int[][] bf = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
        int[][] result = solution(5,bf);
        for(int i=0; i<result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }
    public static int[][] solution(int n, int[][] build_frame) {
        pillar = new boolean[n+1][n+1];
        beam = new boolean[n+1][n+1];
        int[][] answer;
        int cnt = 0;
        for(int i=0; i<build_frame.length; i++) {
            // 삭제
            if(build_frame[i][3] == 0) {
                // 기둥
                if(build_frame[i][2] == 0) {
                    int x = build_frame[i][0];
                    int y = build_frame[i][1];
                    pillar[x][y] = false;
                    if(canDestruct(build_frame,cnt)) {
                        cnt--;
                    }
                    else {
                        pillar[x][y] = true;
                    }
                }
                // 보
                else {
                    int x = build_frame[i][0];
                    int y = build_frame[i][1];
                    beam[x][y] = false;
                    if(canDestruct(build_frame,cnt)) {
                        cnt--;
                    }
                    else {
                        beam[x][y] = true;
                    }
                }
            }
            // 설치
            else {
                // 기둥
                if(build_frame[i][2] == 0) {
                    if(canBuildPillar(build_frame,i)) {
                        int x = build_frame[i][0];
                        int y = build_frame[i][1];
                        pillar[x][y] = true;
                        cnt++;
                    }
                }
                // 보
                else {
                    if(canBuildBeam(build_frame,i)) {
                        int x = build_frame[i][0];
                        int y = build_frame[i][1];
                        beam[x][y] = true;
                        cnt++;
                    }
                }
            }
        }

        answer = new int[cnt][3];
        int index = 0;
        for(int i=0; i<n+1; i++) {
            for(int j=0; j<n+1; j++) {
                if(pillar[i][j]) answer[index++] = new int[]{i,j,0};
                if(beam[i][j]) answer[index++] = new int[]{i,j,1};
            }
        }
        return answer;
    }
    static boolean canBuildPillar(int[][] build_frame, int index) {
        int x = build_frame[index][0];
        int y = build_frame[index][1];
        // 바닥이거나 보의 한쪽 끝이거나 다른 기둥 위에 있다.
        return y == 0 || beam[x - 1][y] || pillar[x][y - 1];
    }
    static boolean canBuildBeam(int[][] build_frame, int index) {
        int x = build_frame[index][0];
        int y = build_frame[index][1];
        // 한쪽 끝 부분이 기둥 위거나, 양쪽 끝 부분이 다른 보와 동시에 연결되어있다.
        return pillar[x][y - 1] || pillar[x + 1][y - 1] || (beam[x - 1][y] && beam[x + 1][y]);
    }
    static boolean canDestruct(int[][] build_frame, int cnt) {
        for(int i=0; i<cnt; i++) {
            if(build_frame[i][3] == 1) {
                // 기둥
                if(build_frame[i][2] == 0) {
                    if(!canBuildPillar(build_frame,i)) {
                        return false;
                    }
                }
                // 보
                else {
                    if(!canBuildBeam(build_frame,i)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}