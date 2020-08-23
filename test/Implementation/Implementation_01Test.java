package Implementation;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * 구현 알고리즘 01 : 상하좌우 테스트코드
 * L: 왼쪽으로 한 칸 이동
 * R: 오른쪽으로 한 칸 이동
 * U: 위로 한 칸 이동
 * D: 아래로 한 칸 이동
 */
public class Implementation_01Test {
    public static Implementation_01 i = new Implementation_01();
    @Test
    public void 상하좌우1() {
        int n = 5;
        String str = "R R R U D D D D D D D";
        int[] result = i.상하좌우1(n, str);
        assertThat(result[0], is(5));
        assertThat(result[1], is(4));
    }
}