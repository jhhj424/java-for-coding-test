import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        int[][] i = {{3, 5}, {3, 2}, {6, 3}, {6, 1}, {4, 6}};
        System.out.println(solution(i));
    }

    static int cnt = 0;
    private static int solution(int[][] links) {
        List<Integer> list = createSizeList(links);
        List<ArrayList<Integer>> lists = createDoubleLists(list);
        createGroup(links, list, lists);
        btk(lists, 0);
        return cnt;
    }

    private static void createGroup(int[][] links, List<Integer> list, List<ArrayList<Integer>> lists) {
        for (int i = 0; i < list.size(); i++) {
            Integer mark = list.get(i);
            for (int[] link : links) {
                if (link[0] != mark) continue;
                addInLists(lists.get(i), 0, link);
                addInLists(lists.get(i), 1, link);
            }
            Collections.sort(lists.get(i));
        }
    }

    private static List<ArrayList<Integer>> createDoubleLists(List<Integer> list) {
        List<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            lists.add(new ArrayList<>());
        }
        return lists;
    }

    private static List<Integer> createSizeList(int[][] links) {
        List<Integer> list = new ArrayList<>();
        for (int[] link : links) {
            if (!list.contains(link[0])) {
                list.add(link[0]);
            }
        }
        return list;
    }

    private static void addInLists(ArrayList<Integer> integers, int i, int[] link) {
        if (!integers.contains(link[i])) {
            integers.add(link[i]);
        }
    }

    static boolean[] visited = new boolean[10001];
    private static void btk(List<ArrayList<Integer>> lists, int k) {
        if (k == lists.size()) {
            cnt++;
            return;
        }
        for (int i = 0; i < lists.get(k).size(); i++) {
            int idx = lists.get(k).get(i);
            if (!visited[idx]) {
                visited[idx] = true;
                btk(lists, k+1);
                visited[idx] = false;
            }
        }
    }
}
