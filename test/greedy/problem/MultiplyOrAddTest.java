package greedy.problem;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

/*
그리디 문제 02 : 곱하기 혹은 더하기 테스트 코드

문제설명
각 자리가 숫자(0부터 9)로만 이루어진 문자열 S가 주어졌을 때, 왼쪽부터 오른쪽으로 하나씩 모든 숫자를 확인하며 숫자 사이에 'X'혹은 '+' 연산자를 넣어 결과적으로 만들어질 수 있는 가장 큰 수를 구하는 프로그램을 작성하세요.
단, +보다 X를 먼저 계산하는 일반적인 방식과는 달리, 모든 연산은 왼쪽에서부터 순서대로 이루어진다고 가정합니다.
예를 들어 02984라는 문자열이 주어지면, 만들어질 수 있는 가장 큰 수는 ((( 0 + 2 ) x 9) x 8) x 4) = 576입니다.

입력 조건
첫째 줄에 여러 개의 숫자로 구성된 하나의 문자열 S가 주어집니다. (1 <= S의 길이 <= 20)

출력 조건
첫째 줄에 만들어질 수 있는 가장 큰 수를 출력합니다.
 */
public class MultiplyOrAddTest {

    @Test
    public void toTest() {
        MultiplyOrAdd multiplyOrAdd = new MultiplyOrAdd();
        String s1 = "02984";
        String s2 = "567";
        String s3 = "23498573245";
        assertThat(multiplyOrAdd.toTest(s1), is(576));
        assertThat(multiplyOrAdd.toTest(s2), is(210));
        assertThat(multiplyOrAdd.toTest(s3), is(7257600));
    }
}