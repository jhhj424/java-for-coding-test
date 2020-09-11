package Implementation.problem;

import java.util.Stack;

/*
2020 카카오 블라인드 테스트 - 괄호 변환

https://programmers.co.kr/learn/courses/30/lessons/60058?language=java
 */
public class ParenthesisConversion {
    public static void main(String[] args) {
//        System.out.println(solution("(()())()")); // (()())()
        System.out.println(solution("()))((()")); // ()(())()
//        System.out.println(solution(")("));
    }
    public static String solution(String p) {
        if(p.isEmpty()) return p;
        Stack<Character> stack = new Stack<>();
        int left=0, right=0;
        String u="",v="";

        // 균형잡힌 괄호 문자열
        for(int i=0; i<p.length(); i++) {
            if(p.charAt(i) == '(') {
                stack.push('(');
                left++;
            }
            else {
                stack.push(')');
                right++;
            }
            if(left==right) {
                u = p.substring(0,i+1);
                v = p.substring(i+1);
                break;
            }
        }// END
        // 3번 과정
        if(isCorrect(u)) {
            return u += solution(v);
        }
        // 4번 과정
        String answer = "(" + solution(v) + ")";
        for(int i=1; i<u.length()-1; i++) {
            if(u.charAt(i)=='(') answer += ')';
            else answer += '(';
        }
        return answer;
    }

    static boolean isCorrect(String s) {
        if(s.charAt(0) == ')') return false;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == ')') {
                if(stack.empty()) return false;
                stack.pop();
            }
            else stack.push(s.charAt(i));
        }
        return true;
    }
}
