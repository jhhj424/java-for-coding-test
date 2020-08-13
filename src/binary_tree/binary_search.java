package binary_tree;

/**
 * 이진 탐색 - 재귀구현
 */
public class binary_search {
    public static void main(String[] args) {
        int n = 10;
        int target = 7;
        int[] arr = {1,3,5,7,9,11,13,15,17,19};
        int result = binarySearch(arr, target, 0, n-1);
        if(result == -1) {
            System.out.println("원소가 존재하지 않습니다.");
        } else {
            System.out.println(result + 1);
        }
    }

    public static int binarySearch(int[] arr, int target, int start, int end) {
        if(start > end) return -1;
        int mid = (start+end)/2;
        if(arr[mid] == target)return mid;
        else if(arr[mid] > target) return binarySearch(arr, target, start, mid -1);
        else return binarySearch(arr, target, mid + 1, end);
    }
}
