package greedy;

import java.util.Arrays;

/**
 * 그리디 알고리즘 02 : 큰 수의 법칙
 */
public class greedy_02 {
    public static void main(String[] args) {
        // [0]: arr2의 길이, [1]=M: M 번 더할 수 있음, [2]=K: 연속 숫자가 K 번을 초과하여 더해질 수 없음
        int[] arr1 = {5,8,3};
        int[] arr2 = {2,4,5,4,6};

        System.out.println(큰수의법칙(arr1, arr2)); // result: 46
    }

    public static int 큰수의법칙(int[] arr1, int[] arr2) {
        int ret = 0;
        int len = arr1[0];
        int M = arr1[1];
        int K = arr1[2];
        int big, small, cnt;
        Arrays.sort(arr2);
        big = arr2[len-1];
        small = arr2[len-2];
        cnt = 0;

        for(int i=0; i<M; i++) {
            cnt++;
            if(cnt >= K) {
                ret += small;
                cnt = 0;
                continue;
            }
            ret += big;
        }

        return ret;
    }
}
