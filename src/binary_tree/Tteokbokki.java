package binary_tree;

/**
 * 이진 탐색 문제 - 떡볶이 떡 만들기
 * 시간복잡도: O(logN)
 */
public class Tteokbokki {
    public static void main(String[] args) {
        int n=4, m=6;// n=떡개수, m=손님이 요청한 떡의 길이
        int arr[] = {19,15,10,17};
        // 손님이 요청한 떡의 길이를 만족하는 절단기 높이의 최대값
        int start = 0, end = (int)1e9; // (int)1e9: 인트 최대값
        int result = 0;
        while(start <= end) {
            System.out.println("@");
            long total = 0;
            int mid = (start+end)/2;
            for(int i=0; i<n; i++) {
                if(arr[i] > mid) total += arr[i] - mid;
            }
            if(total < m) { // 손님의 요청 길이보다 적을때
                end = mid -1;
            } else{
                result = mid;
                start = mid+1;
            }
        }
        System.out.println(result);
    }
}
