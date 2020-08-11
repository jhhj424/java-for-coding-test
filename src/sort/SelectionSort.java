package sort;

/**
 * 선택정렬
 * 시간복잡도 : O(N^2)
 */
public class SelectionSort {
    public static void main(String[] arg) {

        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for(int i=0; i<arr.length; i++) {
            int min_index = i;
            for(int j=i; j<arr.length; j++) {
                if(arr[min_index] > arr[j]) {
                    min_index = j;
                }
            }
            int tmp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = tmp;
        }

        for(int i: arr) {
            System.out.println(i);
        }

    }
}

