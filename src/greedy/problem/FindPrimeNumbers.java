package greedy.problem;

import java.util.HashSet;
import java.util.Set;

/*
완전탐색 - 소수 찾기 - 프로그래머스 레벨2
https://programmers.co.kr/learn/courses/30/lessons/42839?language=java
 */
public class FindPrimeNumbers {
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        System.out.println(solution("17"));
    }

    public static int solution(String numbers) {
        String[] arr = numbers.split("");
        for (int i = 1; i <= arr.length; i++) {
            perm(arr, 0, i);
        }
        return set.size();
    }
    public static void perm(String[] arr, int depth, int k){//숫자 조합
        if(depth==k){//원하는 k개의 숫자가 세팅됐으므로 더이상 순열생성X
            print(arr, k);
        }
        else{
            for(int i=depth; i<arr.length; i++){
                swap(arr, i, depth);
                perm(arr, depth+1, k);
                swap(arr, i, depth);
            }
        }
    }

    public static void swap(String[] arr, int i, int j){
        String temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void print(String[] arr, int k){//숫자 연결
        StringBuilder s=new StringBuilder();
        for(int i=0;i<k;i++){
            s.append(arr[i]);//숫자연결하기
        }
        int num = Integer.parseInt(s.toString());
//        System.out.println(num);
        if(isSosu(num)) set.add(num);
    }

    public static boolean isSosu(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
