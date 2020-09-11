package greedy.problem;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/*
완전탐색 - 소수 찾기 - 프로그래머스 레벨2 - 테스트 코드
https://programmers.co.kr/learn/courses/30/lessons/42839?language=java
 */
public class FindPrimeNumbersTest {

    @Test
    public void solution() {
        assertThat(FindPrimeNumbers.solution("011"), is(2));
    }
}