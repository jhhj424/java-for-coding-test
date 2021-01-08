package Simulation.problem;

import java.util.*;

/**
 * 시뮬레이션 - 프린터 큐 : https://www.acmicpc.net/problem/1966
 */
public class Boj1966 {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int allTestCaseCnt = sc.nextInt();

        for (int i = 0; i < allTestCaseCnt; i++) {
            // 로직 처리
            int n = sc.nextInt();
            int targetIdx = sc.nextInt();
            Queue<Doc> q = new LinkedList<>();
            Doc target = null;
            for (int j = 0; j < n; j++) {
                int nextInt = sc.nextInt();
                Doc doc = new Doc(nextInt, j);
                q.offer(doc);

                if (targetIdx == j) {
                    target = doc;
                }
            }

            int result = 0;
            while (!q.isEmpty()) {
                Doc now = q.peek();
                if (isBest(now.중요도, q)) {
                    result++;
                    if (now.equals(target)) {
                        System.out.println(result);
                        break;
                    }
                } else {
                    q.offer(now);
                }
                q.poll();
            }
        }

    }

    private static boolean isBest(int 중요도, Queue<Doc> q) {
        int max = q.stream()
                .mapToInt(value -> value.중요도)
                .max()
                .getAsInt();
        return max == 중요도;
    }

    static class Doc {
        int 중요도;
        int index;
        Doc(int 중요도, int index) {
            this.중요도 = 중요도;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Doc{" +
                    "중요도=" + 중요도 +
                    ", index=" + index +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Doc doc = (Doc) o;
            return 중요도 == doc.중요도 &&
                    index == doc.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(중요도, index);
        }
    }
}
