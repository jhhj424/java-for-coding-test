package Implementation.problem;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/*
2020 카카오 블라인드 테스트 - 괄호 변환 - 테스트 코드

https://programmers.co.kr/learn/courses/30/lessons/60058?language=java
 */
public class ParenthesisConversionTest {

    @Test
    public void solution() {
        assertThat(ParenthesisConversion.solution("()))((()"), is("()(())()"));
    }
}