package Implementation;

/**
 * 구현 알고리즘 03 : 왕실의 나이트
 */
public class Implementation_03 {
    public static void main(String[] args) {
        String input = "c2";
        System.out.println(왕실의나이트1(input));
        System.out.println(왕실의나이트2(input));
    }

    // 시간복잡도 : O(N)
    public static int 왕실의나이트1(String s) {
        int ret = 0;
        int row = s.charAt(1) - '0';
        int column = s.charAt(0) - 'a' + 1;
        int[][] steps = {{-2,-1},{-2,1},{-1,2},{1,2},{2,-1},{2,1},{1,-2},{-1,-2}};
        for(int i=0; i<steps.length; i++) {
            int afterRow = 0, afterCol = 0;
            afterRow += row + steps[i][0];
            afterCol += column + steps[i][1];
            if(afterRow > 0 && afterCol > 0 && afterRow <= 8  && afterCol <= 8) {
                ret++;
            }
        }
        return ret;
    }

    // 시간복잡도 : O(N)
    public static int 왕실의나이트2(String s) {
        int row = s.charAt(1) - '0';
        int column = s.charAt(0) - 'a' + 1;

        // 나이트가 이동할 수 있는 8가지 방향 정의
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        // 8가지 방향에 대하여 각 위치로 이동이 가능한지 확인
        int result = 0;
        for (int i = 0; i < 8; i++) {
            // 이동하고자 하는 위치 확인
            int nextRow = row + dx[i];
            int nextColumn = column + dy[i];
            // 해당 위치로 이동이 가능하다면 카운트 증가
            if (nextRow >= 1 && nextRow <= 8 && nextColumn >= 1 && nextColumn <= 8) {
                result += 1;
            }
        }
        return result;
    }
}
