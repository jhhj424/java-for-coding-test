package greedy;

/**
 * 그리디 알고리즘 04 : 1이 될때까지
 *
 * 1. N에서 1을 뺀다
 * 2. N을 K로 나눈다
 */
public class greedy_04 {
    public static void main(String[] args) {
        int num1 = 25;
        int num2 = 5;
        System.out.println(일이될때까지1(num1, num2));
        System.out.println(일이될때까지2(num1, num2));
    }

    // 시간복잡도: O(2N)
    public static int 일이될때까지1(int n, int k) {
        int ret = 0;
        int N = n;
        int K = k;
        while(N >= K) {
            if(N % K == 0) { // 나누어 떨어지면 -> 2
                ret++;
                N = N / K;
            } else {
                ret++;
                N = N - 1;
            }
        }

//        // 마지막으로 남은 수에 대하여 1씩 빼기
//        while(N > 1) {
//            ret++;
//            N = N - 1;
//        }
        // 마지막으로 남은 수에 대하여 1씩 빼기
        ret += (N - 1);

        return ret;
    }

    // 시간복잡도: O(N)
    public static int 일이될때까지2(int n, int k) {
        int ret = 0;
        int N = n;
        int K = k;

        while (true) {
            // N이 K로 나누어 떨어지는 수가 될 때까지만 1씩 빼기
            int target = (N / K) * K;
            ret += (N - target);
            N = target;
            // N이 K보다 작을 때 (더 이상 나눌 수 없을 때) 반복문 탈출
            if (N < K) break;
            // K로 나누기
            ret += 1;
            N /= K;
        }

        // 마지막으로 남은 수에 대하여 1씩 빼기
        ret += (N - 1);

        return ret;
    }
}
