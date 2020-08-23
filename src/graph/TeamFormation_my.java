package graph;

import java.io.*;
import java.util.*;

/*
 기타 그래프 문제 - 팀 결성 : 내 풀이 :
 서로소 집합 알고리즘 풀이 - 경로 압축 방식

입력 예시
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1

 */
public class TeamFormation_my {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] parent = new int[100001];

    private static int findParent(int x) {
        if(x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }
    private static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 학생중 끝번호 n, 연산의 개수 m
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i=1; i<=n; i++) {
            parent[i] = i;
        }

        for(int i=0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int oper = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(oper == 0) {
                unionParent(a, b);
            }
            else if(oper == 1) {
                if(findParent(a) == findParent(b)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
        br.close();
    }
}
