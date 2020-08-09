package Implementation;

import java.util.*;

/**
 * 구현 알고리즘 02 : 시각
 */
public class Implementation_02 {
    // 시간복잡도 : O(N)
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int cnt = 0;

        for(int i=0; i<=N; i++) {
            for(int j=0; j<60; j++) {
                for(int k=0; k<60; k++) {
                    if(check(i,j,k)) cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    public static boolean check(int h, int m, int s) {
        if(h % 10 == 3 || m / 10 == 3 || m % 10 == 3 || s / 10 == 3 || s % 10 == 3) {
            return true;
        }
        return false;
    }
}
