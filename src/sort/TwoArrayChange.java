package sort;

import java.util.*;

/**
 * 정렬문제 : 두 배열의 원소 교체
 * 시간복잡도 O(NlogN)
 */
public class TwoArrayChange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        // N과 K를 입력받기
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//
//        // 배열 A의 모든 원소를 입력받기
//        Integer[] a = new Integer[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = sc.nextInt();
//        }
//        // 배열 B의 모든 원소를 입력받기
//        Integer[] b = new Integer[n];
//        for (int i = 0; i < n; i++) {
//            b[i] = sc.nextInt();
//        }
        int n = 5;
        int k = 3;
        Integer[] a = {1,2,5,4,3};
        Integer[] b = {5,5,6,6,5};

        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            // A의 원소가 B의 원소보다 작은 경우
            if (a[i] < b[i]) {
                // 두 원소를 교체
                int temp = a[i];
                a[i] = b[i];
                b[i] = temp;
            }
            // A의 원소가 B의 원소보다 크거나 같을 때, 반복문을 탈출
            else break;
        }

        int sum = 0;
        for(int i=0; i<n;i++) {
            sum += a[i];
        }

        System.out.println(sum);
    }
}
