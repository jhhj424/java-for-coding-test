package greedy.problem;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

/*
그리디 문제 06 : 무지의 먹방 라이브 테스트 코드
 */
public class EatingRoomLiveOfMujiTest {

    @Test
    public void solution() {
        int[] i = {3,1,2};
        long k = 5;
        assertThat(EatingRoomLiveOfMuji.solution(i,k),is(1));
    }
}