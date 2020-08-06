package greedy;

/**
 * 그리디 알고리즘 01 : 거스름돈 문제
 */
public class greedy_01 {
    public static void main(String[] args) {
        int n = 1260;
        int count = 0;

        // 큰 단위의 화폐부터 차례대로 확인
        int[] arr = {500, 100, 50, 10};

        for(int i=0; i<arr.length; i++) {
            count += n / arr[i];
            n = n % arr[i];
        }

        System.out.println(count);
    }
}
