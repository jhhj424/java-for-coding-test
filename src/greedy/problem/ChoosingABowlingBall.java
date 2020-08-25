package greedy.problem;

import java.util.Scanner;

/*
그리디 문제 05 : 볼링공 고르기 (2019 SW 마에스트로 입학 테스트)
*/
public class ChoosingABowlingBall {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = scan.nextInt();
        }
        System.out.println(ChoosingABowlingBall.answer(n, m, arr));
        System.out.println(ChoosingABowlingBall.answer2(n, m, arr));
    }

    // O(N^2)
    public static int answer(int n, int m, int[] arr) {
        int cnt=0;
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                if(arr[i] != arr[j]) cnt++;
            }
        }
        return cnt;
    }

    // O(N)
    public static int answer2(int n, int m, int[] arr) {
        int cnt=0;
        int[] ball = new int[m+1];

        // 볼 무게 별 갯수 세기
        for(int i=0; i<arr.length; i++) {
            ball[arr[i]] += 1;
        }

        for(int i=1; i<m+1; i++) {
            n -= ball[i];
            cnt += ball[i] * n;
        }

        return cnt;
    }
}
