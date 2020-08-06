package greedy;

/**
 * 그리디 알고리즘 03 : 숫자 카드 게임
 */
public class greedy_03 {
    public static void main(String[] args) {
        int[] arr1 = {3,3};
        int[][] arr2 = {{3,1,2},{4,1,4},{2,2,2}};

        int[] arr3 = {2,4};
        int[][] arr4 = {{7,3,1,8},{3,3,3,4}};

        System.out.println(숫자카드게임(arr1, arr2)); // 2
        System.out.println(숫자카드게임(arr3, arr4)); // 3
    }

    // 시간복잡도: O(N^2)
    public static int 숫자카드게임(int[] arr1, int[][] arr2) {
        int ret = 0;

        for(int i=0; i<arr1[0]; i++) {
            int min = 10001;
            for(int j=0; j<arr1[1]; j++) {
                min = Math.min(min, arr2[i][j]);
            }
            ret = Math.max(ret, min);
        }
        return ret;
    }
}
