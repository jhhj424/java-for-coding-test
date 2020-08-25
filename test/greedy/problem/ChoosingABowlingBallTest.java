package greedy.problem;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

/*
그리디 문제 05 : 볼링공 고르기 (2019 SW 마에스트로 입학 테스트) 테스트 코드
*/
public class ChoosingABowlingBallTest {

    @Test
    public void answer() {
        int n = 5, m = 3;
        int[] arr = {1,3,2,3,2};
        assertThat(ChoosingABowlingBall.answer(n,m,arr), is(8));
        n = 8;
        m = 5;
        int[] arr2 = {1,5,4,3,2,4,5,2};
        assertThat(ChoosingABowlingBall.answer(n,m,arr2), is(25));
    }

    @Test
    public void answer2() {
        int n = 5, m = 3;
        int[] arr = {1,3,2,3,2};
        assertThat(ChoosingABowlingBall.answer2(n,m,arr), is(8));
        n = 8;
        m = 5;
        int[] arr2 = {1,5,4,3,2,4,5,2};
        assertThat(ChoosingABowlingBall.answer2(n,m,arr2), is(25));
    }
}