package greedy.problem;

import java.util.*;

/*
그리디 문제 06 : 무지의 먹방 라이브
 */
public class EatingRoomLiveOfMuji {
    public static void main(String[] args) {
        int[] i = {3,1,2};
        long k = 5;
        System.out.println(EatingRoomLiveOfMuji.solution(i, k));
    }
    public static int solution(int[] food_times, long k) {
        // 전체 음식을 먹는 시간보다 k가 크거나 같다면 -1
        long summary = 0;
        for (int i = 0; i < food_times.length; i++) {
            summary += food_times[i];
        }
        if (summary <= k) return -1;

        // 시간이 작은 음식부터 빼야 하므로 우선순위 큐를 이용
        PriorityQueue<Food> pq = new PriorityQueue<>();
        for (int i = 0; i < food_times.length; i++) {
            // 우선순위 큐에 삽입
            pq.offer(new Food(i + 1,food_times[i]));
        }

        summary = 0; // 먹기 위해 사용한 시간
        long previous = 0; // 직전에 다 먹은 음식 시간
        long length = food_times.length; // 남은 음식의 개수

        // summary + (현재의 음식 시간 - 이전 음식 시간) * 현재 음식 개수와 k 비교
        while (summary + ((pq.peek().time - previous) * length) <= k) {
            int now = pq.poll().time;
            summary += (now - previous) * length;
            length -= 1; // 다 먹은 음식 제외
            previous = now; // 이전 음식 시간 재설정
        }

        // 남은 음식 중에서 몇 번째 음식인지 확인하여 출력
        ArrayList<Food> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        // 음식의 번호 기준으로 정렬
        Collections.sort(result, new Comparator<Food>() {
            @Override
            public int compare(Food a, Food b) {
                return Integer.compare(a.order, b.order);
            }
        });
        return result.get((int) ((k - summary) % length)).order;
    }
}
class Food implements Comparable<Food>{
    int order;
    int time;
    Food(int order, int time) {
        this.order = order;
        this.time = time;
    }
    @Override
    public int compareTo(Food ohter) {
        return this.time - ohter.time;
    }
}