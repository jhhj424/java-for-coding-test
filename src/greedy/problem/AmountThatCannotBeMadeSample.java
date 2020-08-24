package greedy.problem;
import java.util.*;
/*
그리디 문제 04 : 만들 수 없는 금액 샘플 코드

문제 설명
동네 편의점의 주인인 동빈이는 N개의 동전을 가지고 있습니다.
이때 N개의 동전을 이용하여 만들 수 없는 양의 정수 금액 중 최솟값을 구하는 프로그램을 작성하세요.
예를 들어, N=5이고, 각 동전이 각각 3원, 2원, 1원, 1원, 9원짜리 (화폐단위) 동전이라고 가정합시다.
이때 동빈이가 만들 수 없는 양의 정수 금액 중 최솟값은 8원입니다.
또 다른 예시로, N=3이고, 각 동전이 각각 3원, 5원 7원짜리 (화폐 단위) 동전이라고 가정합니다.
이때 동빈이가 만들 수 없는 양의 정수 금액 중 최솟값은 1원입니다.

입력 조건
첫째 줄에는 동전의 개수를 나타내는 양의 정수 N이 주어집니다. (1 <= N <= 1000)
둘째 줄에는 각 동전의 화폐 단위를 나타내는 N개의 자연수가 주어지며, 각 자연수는 공백으로 구분합니다. 이때, 각 화폐 단위는 1,000,000 이하의 자연수입니다.

출력 조건
첫째 줄에 주어진 동전들로 만들 수 없는 양의 정수 금액 중 최솟값을 출력합니다.
 */
public class AmountThatCannotBeMadeSample {public static int n;
    public static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            arrayList.add(sc.nextInt());
        }

        Collections.sort(arrayList);

        int target = 1;
        for (int i = 0; i < n; i++) {
            // 만들 수 없는 금액을 찾았을 때 반복 종료
            if (target < arrayList.get(i)) break;
            target += arrayList.get(i);
        }

        System.out.println(target);
    }
}
