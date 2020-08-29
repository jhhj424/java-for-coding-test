package Implementation.problem;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/*
구현 문제
문자열 재정렬 (Facebook 인터뷰) - 테스트코드
 */
public class ReorderStringsTest {

    @Test
    public void testMethod() {
        assertThat(ReorderStrings.testMethod("K1KA5CB7"), is("ABCKK13"));
        assertThat(ReorderStrings.testMethod("AJKDLSI412K4JSJ9D"), is("ADDIJJJKKLSS20"));
    }
}