package greedy.problem;
import java.util.*;

/*
그리디 문제 03 : 문자열 뒤집기 샘플 코드

문제
다솜이는 0과 1로만 이루어진 문자열 S를 가지고 있습니다. 다솜이는 이 문자열 S에 있는 모든 숫자를 전부 같게 만들려고 합니다.
다솜이가 할 수 있는 행동은 S에서 연속된 하나 이상의 숫자를 잡고 모두 뒤집는 것입니다.
뒤집는 것은 1을 0으로, 0을 1로 바꾸는 것을 의미합니다.
예를 들어 S = 001100일 때는 다음과 같습니다.
1. 전체를 뒤집으면 1110011이 됩니다.
2. 4번째 문자부터 5번째 문자까지 뒤집으면 1111111이 되어서 두 번 만에 모두 같은 숫자로 만들 수 있습니다.
하지만, 처음부터 4번째 문자부터 5번째 문자까지 문자를 뒤집으면 한 번에 0000000이 되어서 1번 만에 모두 같은 숫자로 만들 수 있습니다.
문자열 S가 주어졌을 때, 다솜이가 해야 하는 행동의 최소 횟수를 출력하세요.

입력조건
첫째 줄에 0과 1로만 이루어진 문자열 S가 주어집니다. S의 길이는 100만 보다 작습니다.

출력 조건
첫째 줄에 다솜이가 해야 하는 행동의 최소 횟수를 출력합니다.
 */
public class StringFlipSample {

    public static String str;
    public static int count0 = 0; // 전부 0으로 바꾸는 경우
    public static int count1 = 0; // 전부 1로 바꾸는 경우

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.next();

        // 첫 번째 원소에 대해서 처리
        if (str.charAt(0) == '1') {
            count0 += 1;
        }
        else {
            count1 += 1;
        }

        // 두 번째 원소부터 모든 원소를 확인하며
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                // 다음 수에서 1로 바뀌는 경우
                if (str.charAt(i + 1) == '1') count0 += 1;
                    // 다음 수에서 0으로 바뀌는 경우
                else count1 += 1;
            }
        }

        System.out.println(Math.min(count0, count1));
    }
}
