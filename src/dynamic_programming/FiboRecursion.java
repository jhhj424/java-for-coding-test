package dynamic_programming;

/**
 * 동적프로그래밍 - 피보나치수열 재귀함수 구현
 */
public class FiboRecursion {
    // 피보나치 함수(Fibonacci Function)을 재귀함수로 구현
    public static int fibo(int x) {
        if (x == 1 || x == 2) {
            return 1;
        }
        return fibo(x - 1) + fibo(x - 2);
    }
    public static int fibo2(int n) {
        if (n <= 1)
            return n;
        else
            return fibo(n-2) + fibo(n-1);
    }

    public static void main(String[] args) {
        System.out.println(fibo(4));
        System.out.println(fibo2(4));
    }
}
