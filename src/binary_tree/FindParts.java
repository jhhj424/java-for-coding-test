package binary_tree;

import java.util.Arrays;

/**
 * 이진 탐색 문제 - 부품 찾기
 * 시간복잡도: O((M + N) * logN)
 */
public class FindParts {
    public static void main(String[] args) {
        int n = 5, m = 3; // n= 총부품개수, m = 손님요청부품개수
        int nParts[] = {8,3,7,9,2};
        int mparts[] = {5,7,9};
        Arrays.sort(nParts);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++) {
            sb.append(findByBinarySearch(nParts, mparts[i], 0, n));
        }
        System.out.println(sb.toString());
    }
    public static String findByBinarySearch(int[] arr, int target, int start, int end){
        if(start > end ) return "no ";
        int mid = (start+end)/2;
        if(arr[mid] == target) return "yes ";
        else if(arr[mid] > target) return findByBinarySearch(arr, target, start, mid-1);
        else return findByBinarySearch(arr, target, mid+1, end);
    }
}
