package dynamic_programming;

/**
 * 동적프로그래밍 - 피보나치수열 재귀함수 구현(탑다운 다이나믹 프로그래밍)
 */
public class FiboMemoization {
    // 한 번 계산된 결과를 메모이제이션(Memoization)하기 위한 배열 초기화
    public static long[] d = new long[1000];

    // 메모이제이션을 한 피보 재귀호출 vs 일반 피보 재귀호출 카운트 비교
    public static long cnt1 = 0, cnt2 = 0;

    // 피보나치 함수(Fibonacci Function)를 재귀함수로 구현 (탑다운 다이나믹 프로그래밍)
    public static long fibo(int n) {
        cnt1++;
        // 종료 조건
        if (n <= 1)
            return n;
        // 이미 계산한 적 있는 문제라면 그대로 반환
        if(d[n] != 0)
            return d[n];
        // 아직 계산하지 않은 문제라면 점화식에 따라서 피보나치 결과 반환
        d[n] = fibo(n-2) + fibo(n-1);
        return d[n];
    }

    // 일반 재귀함수
    public static long fibo2(int n) {
        cnt2++;
        if (n <= 1)
            return n;
        else
            return fibo2(n-2) + fibo2(n-1);
    }

    public static void main(String[] args) {
        System.out.println(1 + " : "+ fibo(40) + " : " +cnt1);
        System.out.println(2+ " : " +fibo2(40) + " : " +cnt2);
    }
}
