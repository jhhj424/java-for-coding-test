package greedy.problem;

import java.util.Arrays;
import java.util.Scanner;

/*
그리디 문제 04 : 만들 수 없는 금액

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
public class AmountThatCannotBeMade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String s = scan.nextLine();
        System.out.println(AmountThatCannotBeMade.answer(n, s));
    }

    public static int answer(int n, String s) {
        String[] str_arr = s.split(" ");
        int[] arr = new int[str_arr.length];
        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(str_arr[i]);
        }
        int ret = 1;
        Arrays.sort(arr);
        for(int i=0; i<n; i++) {
            if(arr[i] > ret) break;
            ret += arr[i];
        }

        return ret;
    }
}
