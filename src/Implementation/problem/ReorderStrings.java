package Implementation.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
구현 문제
문자열 재정렬 (Facebook 인터뷰)
 */
public class ReorderStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int sum = 0;
        String arr[] = s.split("");
        ArrayList<String> list = new ArrayList();
        for(int i=0; i<arr.length; i++) {
            if(arr[i].charAt(0) - '0' >= 0 && arr[i].charAt(0) - '0' <= 9) {
                sum += Integer.parseInt(arr[i]);
            }else {
                list.add(arr[i]);
            }
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size(); i++) {
            sb.append(list.get(i));
        }
        sb.append(sum);
        System.out.println(sb.toString());
    }
    static String testMethod(String s) {
        int sum = 0;
        String arr[] = s.split("");
        ArrayList<String> list = new ArrayList();
        for(int i=0; i<arr.length; i++) {
            if(arr[i].charAt(0) - '0' >= 0 && arr[i].charAt(0) - '0' <= 9) {
                sum += Integer.parseInt(arr[i]);
            }else {
                list.add(arr[i]);
            }
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size(); i++) {
            sb.append(list.get(i));
        }
        sb.append(sum);
        return sb.toString();
    }
}