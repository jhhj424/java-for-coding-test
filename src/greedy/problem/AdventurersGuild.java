package greedy.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
그리디 문제 01 : 모험가 길드
한 마을에 모험가가 N명 있습니다. 모험가 길드에서는 N명의 모험가를 대상으로 '공포도'를 측정했는데, '공포도'가 높은 모험가는 쉽게 공포를 느껴 위험 상황에서 제대로 대처할 능력이 떨어집니다.
모험가 길드장인 봉민이는 뫃머가 그룹을 안전하게 구성하고자 공포도가 X인 모험가는 반드시 X명 이상으로 구성한 모험가 그룹에 참여해야 여행을 떠날 수 있도록 규정했습니다.
동빈이는 최대 명 개의 모험가 그룹을 만들 수 있는지 궁금합니다.
동빈이를 위해 N명의 모험가에 대한 정보가 주어졌을 때, 여행을 떠날 수 있는 그룹 수의 최댓값을 구하는 프로그램을 작성하세요.

예를 들어 N = 5 이고, 각 모험가의 공포도가 [2, 3, 1, 2, 2] 라고 가정합니다.
이때, 그룹 1에 공포도가 1, 2, 3인 모험가를 한 명씩 넣고, 그룹 2에 공포도가 2인 남은 두 명을 넣게 되면, 총 2개의 그룹을 만들 수 있습니다.
또한 몇 명의 모험가는 마을에 그대로 남아 있어도 되기 때문에, 모든 모험가를 특정한 그룹에 넣을 필요는 없습니다.

입력조건
 - 첫째 줄에 모험가의 수 N 이 주어집니다. (N <= N <= 100,000)
 - 둘째 줄에 각 모험가의 공포도의 값을 N 이하의 자연수로 주어지며, 각 자연수는 공백으로 구분합니다.

 출력조건
 - 여행을 떠날 수 있는 그룹 수의 최댓값을 출력합니다.

입력 예시
5
2 3 1 2 2

출력 예시
2
 */
public class AdventurersGuild {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] 공포도 = new int[n];
        for(int i=0; i<n; i++) {
            공포도[i] = Integer.parseInt(st.nextToken());
        }
        // 내림차순 정렬
        Arrays.sort(공포도);
        int result = 0;
        int cnt = 0;
        for(int i=0; i<n; i++) {
            cnt++;
            if(공포도[i] <= cnt) {
                result++;
                cnt=0;
            }
        }
        System.out.println(result);
        br.close();
    }

    // 테스트용 메소드
    public int AdventurersGuildToTest(int n, int[] m) {
        // 내림차순 정렬
        Arrays.sort(m);
        int result = 0;
        int cnt = 0;
        for(int i=0; i<n; i++) {
            cnt++;
            if(m[i] <= cnt) {
                result++;
                cnt=0;
            }
        }
        return result;
    }
}
