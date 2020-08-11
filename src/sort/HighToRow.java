package sort;

import java.util.*;
/**
 * 정렬문제 : 위에서 아래로
 * 자바 라이브러리중 Arrays.sort(arr, Collections.reverseOrder()) 사용
 *  - 내림차순 정렬
 * ※ 대상은 Wrapper 클래스만 가능
 */
public class HighToRow {
    public static void main(String[] args) {
        int n = 3;
        Integer[] arr = {15,27,12};
        Arrays.sort(arr, Collections.reverseOrder());
        for(int i: arr) {
            System.out.println(i);
        }
    }
}
